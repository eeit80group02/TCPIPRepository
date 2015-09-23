package model.dao;

/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 21:18
 * 
 */
import global.GlobalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ProcessingMemberBean;
import model.dao.interfaces.ProcessingMemberDAO;

public class ProcessingMemberDAOJdbc implements ProcessingMemberDAO
{
	private DataSource datasource;

	public ProcessingMemberDAOJdbc()
	{
		try
		{
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup(GlobalService.JNDI);
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	// Select by ID
	private static final String SELECT_BY_ID = "SELECT processingMemberId,schoolDemandId,memberId,checkTime,checkStatus FROM ProcessingMember WHERE processingMemberId = ?";
	@Override
	public ProcessingMemberBean findByPrimaryKey(int processingMemberId)
	{
		ProcessingMemberBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,processingMemberId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ProcessingMemberBean();
					result.setProcessingMemberId(rset.getInt("processingMemberId"));
					result.setSchoolDemandId(rset.getInt("schoolDemandId"));
					result.setMemberId(rset.getInt("memberId"));
					result.setCheckTime(rset.getTimestamp("checkTime"));
					result.setCheckStatus(rset.getString("checkStatus"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	// Select ALL ----->getAll(){}
	private static final String SELECT_ALL = "SELECT processingMemberId,schoolDemandId,memberId,checkTime,checkStatus FROM ProcessingMember";
	@Override
	public List<ProcessingMemberBean> getAll()
	{
		List<ProcessingMemberBean> result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ProcessingMemberBean>();
			while(rset.next())
			{
				ProcessingMemberBean bean = new ProcessingMemberBean();
				bean.setProcessingMemberId(rset.getInt("processingMemberId"));
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setCheckTime(rset.getTimestamp("checkTime"));
				bean.setCheckStatus(rset.getString("checkStatus"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	// 新增 --------> insert(){}
	private static final String INSERT = "INSERT INTO ProcessingMember (schoolDemandId,memberId,checkTime,checkStatus) VALUES (?,?,?,?)";
	@Override
	public ProcessingMemberBean insert(ProcessingMemberBean bean)
	{
		ProcessingMemberBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getSchoolDemandId());
				pstmt.setInt(2,bean.getMemberId());
				if(bean.getCheckTime() != null)
				{
					pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getCheckTime().getTime()));
				}
				else
				{
					pstmt.setNull(3,Types.TIMESTAMP);
				}
				pstmt.setString(4,bean.getCheckStatus());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					ResultSet key = pstmt.getGeneratedKeys();
					if(key.next())
					{
						result = findByPrimaryKey(key.getInt(1));
					}
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	// 修改 -------->update(){}
	private static final String UPDATE = "UPDATE ProcessingMember SET schoolDemandId = ?,memberId = ?,checkTime = ?,checkStatus = ? WHERE processingMemberId = ?";
	@Override
	public ProcessingMemberBean update(ProcessingMemberBean bean)
	{
		ProcessingMemberBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getSchoolDemandId());
				pstmt.setInt(2,bean.getMemberId());
				if(bean.getCheckTime() != null)
				{
					pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getCheckTime().getTime()));
				}
				else
				{
					pstmt.setNull(3,Types.TIMESTAMP);
				}
				pstmt.setString(4,bean.getCheckStatus());
				pstmt.setInt(5,bean.getProcessingMemberId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getProcessingMemberId());

				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	// 刪除 ------> delete(){}
	private static final String DELETE = "DELETE FROM ProcessingMember WHERE processingMemberId = ?";
	@Override
	public boolean delete(int processingMemberId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,processingMemberId);
			int i = pstmt.executeUpdate();
			if(i == 1)
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	// 測試
	public static void main(String[] args)
	{
		ProcessingMemberDAO dao = new ProcessingMemberDAOJdbc();

		// findByPrimaryKey for Test 查詢單一筆資料
		ProcessingMemberBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);
//
//		// select All for Test 查詢全部
		List<ProcessingMemberBean> beans = dao.getAll();
		System.out.println();
		for(ProcessingMemberBean b : beans)
		{
			System.out.println(b);
		}
//
//		// insert 新增
//		ProcessingMemberBean bean1 = new ProcessingMemberBean();
//		bean1.setSchoolDemandId(1);
//		bean1.setMemberId(6);
//		bean1.setCheckTime(null);
//		bean1.setCheckStatus("待審核");
//		System.out.println(dao.insert(bean1));
//
//		// update 更新
		ProcessingMemberBean bean2 = new ProcessingMemberBean();
		bean2.setProcessingMemberId(2);
		bean2.setSchoolDemandId(1);
		bean2.setMemberId(6);
		bean2.setCheckTime(new java.util.Date(System.currentTimeMillis()));
		bean2.setCheckStatus("已審核");
		System.out.println(dao.update(bean2));
//
//		// delete 刪除
		System.out.println(dao.delete(1));

	}

}

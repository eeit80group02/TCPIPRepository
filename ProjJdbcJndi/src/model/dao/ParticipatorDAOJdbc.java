package model.dao;

/*
 * 編寫者: Z.Y
 * 撰寫日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 20:41
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

import model.ParticipatorBean;
import model.dao.interfaces.ParticipatorDAO;

public class ParticipatorDAOJdbc implements ParticipatorDAO
{
	private DataSource datasource;

	public ParticipatorDAOJdbc()
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
	
	// SQL 指令
	// Select by ID
	private static final String SELECT_BY_ID = "SELECT participatorId,fullProjId,memberId,activityStartTime,activityEndTime,participateStatus,checkTime,isParticipate FROM Participator WHERE participatorId = ?";
	@Override
	public ParticipatorBean findByPrimaryKey(int participatorId)
	{
		ParticipatorBean result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,participatorId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ParticipatorBean();
					result.setParticipatorId(rset.getInt("participatorId"));
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setMemberId(rset.getInt("memberId"));
					result.setActivityStartTime(rset.getTimestamp("activityStartTime"));
					result.setActivityEndTime(rset.getTimestamp("activityEndTime"));
					result.setParticipateStatus(rset.getString("participateStatus"));
					result.setCheckTime(rset.getTimestamp("checkTime"));
					result.setIsParticipate(rset.getString("isParticipate"));
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
	private static final String SELECT_ALL = "SELECT participatorId,fullProjId,memberId,activityStartTime,activityEndTime,participateStatus,checkTime,isParticipate FROM Participator";

	@Override
	public List<ParticipatorBean> getAll()
	{
		List<ParticipatorBean> result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ParticipatorBean>();
			while(rset.next())
			{
				ParticipatorBean bean = new ParticipatorBean();
				bean.setParticipatorId(rset.getInt("participatorId"));
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setActivityStartTime(rset.getTimestamp("activityStartTime"));
				bean.setActivityEndTime(rset.getTimestamp("activityEndTime"));
				bean.setParticipateStatus(rset.getString("participateStatus"));
				bean.setCheckTime(rset.getTimestamp("checkTime"));
				bean.setIsParticipate(rset.getString("isParticipate"));

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
	private static final String INSERT = "INSERT INTO Participator(fullProjId,memberId,activityStartTime,activityEndTime,participateStatus,checkTime,isParticipate) VALUES (?,?,?,?,?,?,?)";
	@Override
	public ParticipatorBean insert(ParticipatorBean bean)
	{
		ParticipatorBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setString(5,bean.getParticipateStatus());

				if(bean.getCheckTime() != null)
				{
					pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getCheckTime().getTime()));
				}
				else
				{
					pstmt.setNull(6,Types.TIMESTAMP);
				}
				
				if(bean.getIsParticipate() != null)
				{
					pstmt.setString(7,bean.getIsParticipate());
				}
				else
				{
					pstmt.setNull(7,Types.NVARCHAR);
				}
				
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = findByPrimaryKey(key.getInt(1));
						}
					}
					catch(SQLException e)
					{
						e.printStackTrace();
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
	private static final String UPDATE = "UPDATE Participator SET fullProjId = ?,memberId = ?,activityStartTime = ?,activityEndTime = ?,participateStatus = ?,checkTime = ?,isParticipate = ? WHERE participatorId = ?";
	@Override
	public ParticipatorBean update(ParticipatorBean bean)
	{
		ParticipatorBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setString(5,bean.getParticipateStatus());

				if(bean.getCheckTime() != null)
				{
					pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getCheckTime().getTime()));
				}
				else
				{
					pstmt.setNull(6,Types.TIMESTAMP);
				}

				if(bean.getIsParticipate() != null)
				{
					pstmt.setString(7,bean.getIsParticipate());
				}
				else
				{
					pstmt.setNull(7,Types.NVARCHAR);
				}

				pstmt.setInt(8,bean.getParticipatorId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getParticipatorId());
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
	private static final String DELETE = "DELETE FROM Participator WHERE participatorId = ?";

	@Override
	public boolean delete(int participatorId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,participatorId);
			int i = pstmt.executeUpdate();
			if(i == 1)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	// 測試檔
	public static void main(String[] args) throws Exception
	{
		ParticipatorDAO dao = new ParticipatorDAOJdbc();
		
		// findByPrimaryKey for Test 查詢單一筆資料
		ParticipatorBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);

		// select All for Test 查詢全部
		List<ParticipatorBean> beans = dao.getAll();
		for(ParticipatorBean b : beans)
		{
			System.out.println(b);
		}

		// insert 新增 
//		ParticipatorBean bean1 = new ParticipatorBean();
//		bean1.setFullProjId(1);
//		bean1.setMemberId(4);
//		bean1.setActivityStartTime(GlobalService.convertStringToDate("2015-08-09"));
//		bean1.setActivityEndTime(GlobalService.convertStringToDate("2015-08-12"));
//		bean1.setParticipateStatus("待審核");
//		bean1.setCheckTime(null);
//		bean1.setIsParticipate(null);
//		System.out.println(dao.insert(bean1));

		// update 更新 
		ParticipatorBean bean2 = new ParticipatorBean();
		bean2.setParticipatorId(3);
		bean2.setFullProjId(1);
		bean2.setMemberId(4);
		bean2.setActivityStartTime(GlobalService.convertStringToDate("2015-08-19"));
		bean2.setActivityEndTime(GlobalService.convertStringToDate("2015-08-22"));
		bean2.setParticipateStatus("已審核");
		bean2.setCheckTime(new java.util.Date(System.currentTimeMillis()));
		bean2.setIsParticipate(null);
		ParticipatorBean updateResult = dao.update(bean2);
		System.out.println(updateResult);

		// delete 刪除
		System.out.println(dao.delete(1));
		
	}
}

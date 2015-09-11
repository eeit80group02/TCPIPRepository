package model.dao;

/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 21:21
 * 
 */
import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.ProcessingProjBean;
import model.dao.interfaces.ProcessingProjDAO;

public class ProcessingProjDAOJdbc implements ProcessingProjDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	// Select by ID
	private static final String SELECT_BY_ID = "SELECT processingProjId,primaryProjId,schoolId,checkTime,checkStatus FROM ProcessingProj WHERE processingProjId = ?";
	@Override
	public ProcessingProjBean findByPrimaryKey(int processingProjId)
	{
		ProcessingProjBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,processingProjId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ProcessingProjBean();
					result.setProcessingProjId(rset.getInt("processingProjId"));
					result.setPrimaryProjId(rset.getInt("primaryProjId"));
					result.setSchoolId(rset.getInt("schoolId"));
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
	private static final String SELECT_ALL = "SELECT processingProjId,primaryProjId,schoolId,checkTime,checkStatus FROM ProcessingProj";
	@Override
	public List<ProcessingProjBean> getAll()
	{
		List<ProcessingProjBean> result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ProcessingProjBean>();
			while(rset.next())
			{
				ProcessingProjBean bean = new ProcessingProjBean();
				bean.setProcessingProjId(rset.getInt("processingProjId"));
				bean.setPrimaryProjId(rset.getInt("primaryProjId"));
				bean.setSchoolId(rset.getInt("schoolId"));
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
	private static final String INSERT = "INSERT INTO ProcessingProj (primaryProjId,schoolId,checkTime,checkStatus) VALUES(?,?,?,?)";
	@Override
	public ProcessingProjBean insert(ProcessingProjBean bean)
	{
		ProcessingProjBean result = null;

		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getPrimaryProjId());
				pstmt.setInt(2,bean.getSchoolId());
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
	private static final String UPDATE = "UPDATE ProcessingProj SET primaryProjId = ?,schoolId = ?,checkTime = ?,checkStatus = ? WHERE processingProjId = ?";
	@Override
	public ProcessingProjBean update(ProcessingProjBean bean)
	{
		ProcessingProjBean result = null;

		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getPrimaryProjId());
				pstmt.setInt(2,bean.getSchoolId());
				if(bean.getCheckTime() != null)
				{
					pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getCheckTime().getTime()));
				}
				else
				{
					pstmt.setNull(3,Types.TIMESTAMP);
				}
				pstmt.setString(4,bean.getCheckStatus());
				pstmt.setInt(5,bean.getProcessingProjId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getProcessingProjId());

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
	private static final String DELETE = "DELETE FROM ProcessingProj WHERE processingProjId = ?";
	@Override
	public boolean delete(int processingProjId) 
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,processingProjId);
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

	public static void main(String[] args) throws Exception
	{
		ProcessingProjDAO dao = new ProcessingProjDAOJdbc();
		// findByPrimaryKey for Test 查詢單一筆資料
		ProcessingProjBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);

//		// select All for Test 查詢全部
		List<ProcessingProjBean> beans = dao.getAll();
		System.out.println();
		for(ProcessingProjBean b : beans)
		{
			System.out.println(b);
		}
//
//		// insert 新增
		ProcessingProjBean bean1 = new ProcessingProjBean();
		bean1.setPrimaryProjId(1);
		bean1.setSchoolId(11503);
		bean1.setCheckTime(null);
		bean1.setCheckStatus("待審核");
		System.out.println(dao.insert(bean1));

//		// update 更新
		ProcessingProjBean bean2 = new ProcessingProjBean();
		bean2.setProcessingProjId(9);
		bean2.setPrimaryProjId(1);
		bean2.setSchoolId(11503);
		bean2.setCheckTime(new java.util.Date(System.currentTimeMillis()));
		bean2.setCheckStatus("已通過");
		System.out.println(dao.update(bean2));
//
//		// delete 刪除
		System.out.println(dao.delete(1));
	}
}

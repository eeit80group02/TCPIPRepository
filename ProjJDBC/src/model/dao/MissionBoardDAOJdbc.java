package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MissionBoardBean;

public class MissionBoardDAOJdbc
{
	private static final String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String INSERT = "INSERT INTO MissionBoard (fullProjId,name,missionSetNum) VALUES (?,?,?)";
	public MissionBoardBean insert(MissionBoardBean bean)
	{
		MissionBoardBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet key = null;
		try
		{
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,bean.getFullProjId());
			pstmt.setString(2,bean.getName());
			pstmt.setInt(3,bean.getMissionSetNum());
			
			int num = pstmt.executeUpdate();
			
			if(num == 1)
			{
				key = pstmt.getGeneratedKeys();
				
				int pk = 0;
				if(key.next())
					pk = key.getInt(1);
				
				result = findByPrimaryKey(pk);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{

			if(key != null)
			{
				try
				{
					key.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String DELETE = "DELETE FROM MissionBoard WHERE missionBoardId = ?";
	public boolean delete(int id)
	{
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1,id);
			
			int num = pstmt.executeUpdate();
			
			if(num == 1)
			{
				result = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String UPDATE = "UPDATE MissionBoard SET fullProjId = ?,name = ?,missionSetNum = ? WHERE missionBoardId = ?";
	public MissionBoardBean update(MissionBoardBean bean)
	{
		MissionBoardBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setInt(1,bean.getFullProjId());
			pstmt.setString(2,bean.getName());
			pstmt.setInt(3,bean.getMissionSetNum());
			pstmt.setInt(4,bean.getMissionBoardId());
			
			int num = pstmt.executeUpdate();
			
			if(num == 1)
			{
				result = findByPrimaryKey(bean.getMissionBoardId());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT missionBoardId,fullProjId,name,missionSetNum FROM MissionBoard WHERE missionBoardId = ?";
	public MissionBoardBean findByPrimaryKey(int id)
	{
		MissionBoardBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = new MissionBoardBean();
				result.setMissionBoardId(rs.getInt(1));
				result.setFullProjId(rs.getInt(2));
				result.setName(rs.getString(3));
				result.setMissionSetNum(rs.getInt(4));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String SELECT_ALL = "SELECT missionBoardId,fullProjId,name,missionSetNum FROM MissionBoard";
	public List<MissionBoardBean> getAll()
	{
		List<MissionBoardBean> result = new ArrayList<MissionBoardBean>();
		MissionBoardBean bean;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bean = new MissionBoardBean();
				bean.setMissionBoardId(rs.getInt(1));
				bean.setFullProjId(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setMissionSetNum(rs.getInt(4));
				
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public static void main(String[] args)
	{
		MissionBoardDAOJdbc dao = new MissionBoardDAOJdbc();
		
		// findByPrimaryKey
		MissionBoardBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
		
		// select
		List<MissionBoardBean> selectBead;
		selectBead = dao.getAll();
		System.out.println(selectBead);
		
		// insert
		MissionBoardBean insertData = new MissionBoardBean();
		MissionBoardBean insertBean;
		insertData.setFullProjId(2);
		insertData.setName("造神計畫2");
		insertData.setMissionSetNum(1);
		insertBean = dao.insert(insertData);
		System.out.println(insertBean);
		
		// update
		MissionBoardBean updateData = new MissionBoardBean();
		MissionBoardBean updateBean;
		updateData.setMissionBoardId(2);
		updateData.setFullProjId(2);
		updateData.setName("造神計畫2");
		updateData.setMissionSetNum(3);
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
		
		// delete
		boolean delete = dao.delete(2);
		System.out.println("Delete : " + delete);
	}
}

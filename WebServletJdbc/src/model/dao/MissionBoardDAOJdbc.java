package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MissionBoardBean;
import model.dao.interfaces.MissionBoardDAO;

public class MissionBoardDAOJdbc implements MissionBoardDAO
{
	private DataSource datasource;

	public MissionBoardDAOJdbc()
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
	
	private static final String INSERT = "INSERT INTO MissionBoard (fullProjId,name,missionSetNum) VALUES (?,?,?)";
	public MissionBoardBean insert(MissionBoardBean bean)
	{
		MissionBoardBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1,bean.getFullProjId());
			pstmt.setString(2,bean.getName());
			pstmt.setInt(3,bean.getMissionSetNum());
			
			int num = pstmt.executeUpdate();
			
			if(num == 1)
			{
				try(ResultSet key = pstmt.getGeneratedKeys();)
				{
					if(key.next())
					{
						result = findByPrimaryKey(key.getInt(1));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String DELETE = "DELETE FROM MissionBoard WHERE missionBoardId = ?";
	public boolean delete(int id)
	{
		boolean result = false;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			
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
		return result;
	}
	
	private static final String UPDATE = "UPDATE MissionBoard SET fullProjId = ?,name = ?,missionSetNum = ? WHERE missionBoardId = ?";
	public MissionBoardBean update(MissionBoardBean bean)
	{
		MissionBoardBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
		{
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
		return result;
	}
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT missionBoardId,fullProjId,name,missionSetNum FROM MissionBoard WHERE missionBoardId = ?";
	public MissionBoardBean findByPrimaryKey(int id)
	{
		MissionBoardBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
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
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SELECT_ALL = "SELECT missionBoardId,fullProjId,name,missionSetNum FROM MissionBoard";
	public List<MissionBoardBean> getAll()
	{
		List<MissionBoardBean> result = new ArrayList<MissionBoardBean>();
		MissionBoardBean bean;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
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
		boolean delete = dao.delete(100);
		System.out.println("Delete : " + delete);
	}
}

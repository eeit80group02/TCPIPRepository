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

import model.MissionSetBean;

public class MissionSetDAOJdbc
{
	private DataSource datasource;

	public MissionSetDAOJdbc()
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
	
	private static final String INSERT = "INSERT INTO MissionSet (missionBoardId,name,missionSetOrder) VALUES (?,?,?)";
	public MissionSetBean insert(MissionSetBean bean)
	{
		MissionSetBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1,bean.getMissionBoardId());
			pstmt.setString(2,bean.getName());
			pstmt.setInt(3,bean.getMissionSetOrder());
			int num = pstmt.executeUpdate();
			
			if(num == 1)
			{
				try(ResultSet key = pstmt.getGeneratedKeys();)
				{
					int pk = 0;
					if(key.next())
						pk = key.getInt(1);
					
					result = findByPrimaryKey(pk);
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
		return result;
	}
	
	private static final String DELETE = "DELETE FROM MissionSet WHERE missionSetId = ?";
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
	
	private static final String UPDATE = "UPDATE MissionSet SET missionBoardId = ?,name = ?,missionSetOrder = ? WHERE missionSetId = ?";
	public MissionSetBean update(MissionSetBean bean)
	{
		MissionSetBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
		{
			pstmt.setInt(1,bean.getMissionBoardId());
			pstmt.setString(2,bean.getName());
			pstmt.setInt(3,bean.getMissionSetOrder());
			pstmt.setInt(4,bean.getMissionSetId());
			int num = pstmt.executeUpdate();
			if(num == 1)
			{
				result = findByPrimaryKey(bean.getMissionSetId());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	private static final String FIND_BY_PRIMARYKEY = "SELECT missionSetId,missionBoardId,name,missionSetOrder FROM MissionSet WHERE missionSetId = ?";
	public MissionSetBean findByPrimaryKey(int id)
	{
		MissionSetBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);

			try(ResultSet rs = pstmt.executeQuery())
			{			
				if(rs.next())
				{
					result = new MissionSetBean();
					result.setMissionSetId(rs.getInt(1));
					result.setMissionBoardId(rs.getInt(2));
					result.setName(rs.getString(3));
					result.setMissionSetOrder(rs.getInt(4));
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
	
	private static final String SELECT_ALL = "SELECT missionSetId,missionBoardId,name,missionSetOrder FROM MissionSet";
	public List<MissionSetBean> getAll()
	{
		List<MissionSetBean> result = new ArrayList<MissionSetBean>();
		MissionSetBean bean;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new MissionSetBean();
				bean.setMissionSetId(rs.getInt(1));
				bean.setMissionBoardId(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setMissionSetOrder(rs.getInt(4));
				
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
		MissionSetDAOJdbc dao = new MissionSetDAOJdbc();
		
		// findByPK
		MissionSetBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
		
		// getAll
		List<MissionSetBean> selectBean;
		selectBean = dao.getAll();
		System.out.println(selectBean);
		
		// insert
		MissionSetBean insertData = new MissionSetBean();
		MissionSetBean insertBean;
		insertData.setMissionBoardId(3);
		insertData.setName("團康組");
		insertData.setMissionSetOrder(1);
		insertBean = dao.insert(insertData);
		System.out.println(insertBean);
		
		// delete
		boolean delete = dao.delete(4);
		System.out.println("Delete : " + delete);
		
		// update
		MissionSetBean updateData = new MissionSetBean();
		MissionSetBean updateBean;
		updateData.setMissionSetId(1);
		updateData.setMissionBoardId(3);
		updateData.setName("神組");
		updateData.setMissionSetOrder(1);
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
	}

}

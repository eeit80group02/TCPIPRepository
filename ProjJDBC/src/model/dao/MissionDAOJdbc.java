package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.MissionBean;

public class MissionDAOJdbc
{
	private static final String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String INSERT = "INSERT INTO Mission (missionSetId,name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionSetId) VALUES(?,?,?,?,?,?,?,?)";

	public MissionBean insert(MissionBean bean)
	{
		MissionBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1,bean.getMissionSetId());
			pstmt.setString(2,bean.getName());
			if(bean.getHost() != null)
				pstmt.setInt(3,bean.getHost());
			else
				pstmt.setNull(3,Types.INTEGER);
			pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getEndTime().getTime()));
			pstmt.setInt(5,bean.getMissionPriority());
			pstmt.setInt(6,bean.getMissionPosition());
			pstmt.setString(7,bean.getMissionStatus());
			if(bean.getMainMissionSetId() != null)
				pstmt.setInt(8,bean.getMainMissionSetId());
			else
				pstmt.setNull(8,Types.INTEGER);
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

	private static final String DELETE = "DELETE FROM Mission WHERE missionId = ?";

	public boolean delete(int id)
	{
		boolean result = false;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,id);
			int num = pstmt.executeUpdate();
			if(num == 1)
				result = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	private static final String UPDATE = "UPDATE Mission SET missionSetId = ?,name = ?,host = ?,endTime = ?,missionPriority = ?,missionPosition = ?,missionStatus = ?,mainMissionSetId = ? WHERE missionId = ?";

	public MissionBean update(MissionBean bean)
	{
		MissionBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
		{
			pstmt.setInt(1,bean.getMissionSetId());
			pstmt.setString(2,bean.getName());
			if(bean.getHost() != null)
				pstmt.setInt(3,bean.getHost());
			else
				pstmt.setNull(3,Types.INTEGER);
			pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getEndTime().getTime()));
			pstmt.setInt(5,bean.getMissionPriority());
			pstmt.setInt(6,bean.getMissionPosition());
			pstmt.setString(7,bean.getMissionStatus());
			if(bean.getMainMissionSetId() != null)
				pstmt.setInt(8,bean.getMainMissionSetId());
			else
				pstmt.setNull(8,Types.INTEGER);
			pstmt.setInt(9,bean.getMissionId());
			int num = pstmt.executeUpdate();
			if(num == 1)
			{
				result = findByPrimaryKey(bean.getMissionId());
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	private static final String FIND_BY_PRIMARYKEY = "SELECT missionId,missionSetId,name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionSetId FROM Mission WHERE missionId = ?";

	public MissionBean findByPrimaryKey(int id)
	{
		MissionBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new MissionBean();
					result.setMissionId(rs.getInt(1));
					result.setMissionSetId(rs.getInt(2));
					result.setName(rs.getString(3));
					result.setHost((Integer)rs.getObject((4)));
					result.setEndTime(rs.getDate(5));
					result.setMissionPriority(rs.getInt(6));
					result.setMissionPosition(rs.getInt(7));
					result.setMissionStatus(rs.getString(8));
					result.setMainMissionSetId((Integer)rs.getObject((9)));
				}
			}
			catch(Exception e)
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

	private static final String SELECT_ALL = "SELECT missionId,missionSetId,name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionSetId FROM Mission";

	public List<MissionBean> getAll()
	{
		List<MissionBean> result = new ArrayList<MissionBean>();
		MissionBean bean = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);)
		{
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new MissionBean();
					bean.setMissionId(rs.getInt(1));
					bean.setMissionSetId(rs.getInt(2));
					bean.setName(rs.getString(3));
					bean.setHost((Integer)rs.getObject((4)));
					bean.setEndTime(rs.getDate(5));
					bean.setMissionPriority(rs.getInt(6));
					bean.setMissionPosition(rs.getInt(7));
					bean.setMissionStatus(rs.getString(8));
					bean.setMainMissionSetId((Integer)rs.getObject((9)));
					result.add(bean);
				}
			}
			catch(Exception e)
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

	public static void main(String[] args)
	{
		MissionDAOJdbc dao = new MissionDAOJdbc();

		// findByPrimaryKey
		MissionBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(19);
		System.out.println(findByPKBean);

		// select
		List<MissionBean> selectBead;
		selectBead = dao.getAll();
		System.out.println(selectBead);

		// insert
		MissionBean insertData = new MissionBean();
		MissionBean insertBean;
		insertData.setMissionSetId(3);
		insertData.setName("體育組");
		insertData.setHost(null);
		insertData.setEndTime(new java.util.Date());
		insertData.setMissionPriority(2);
		insertData.setMissionPosition(3);
		insertData.setMissionStatus("進行中");
		insertData.setMainMissionSetId(null);
		insertBean = dao.insert(insertData);
		System.out.println(insertBean);

		// delete
		boolean delete = dao.delete(17);
		System.out.println("Delete : " + delete);

		// update
		MissionBean updateData = new MissionBean();
		MissionBean updateBean;
		updateData.setMissionId(19);
		updateData.setMissionSetId(3);
		updateData.setName("體育組");
		updateData.setHost(5);
		updateData.setEndTime(new java.util.Date());
		updateData.setMissionPriority(1);
		updateData.setMissionPosition(2);
		updateData.setMissionStatus("進行中");
		updateData.setMainMissionSetId(null);
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
	}
}

package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MissionParticipatorBean;
import model.dao.interfaces.MissionParticipatorDAO;

public class MissionParticipatorDAOJdbc implements MissionParticipatorDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_PK = "SELECT missionParticipatorId,missionId,memberId FROM MissionParticipator WHERE missionParticipatorId = ?";
	private static final String SELECT_ALL = "SELECT missionParticipatorId,missionId,memberId FROM MissionParticipator";
	private static final String INSERT = "INSERT INTO MissionParticipator (missionId,memberId) VALUES (?,?)";
	private static final String UPDATE = "UPDATE MissionParticipator SET missionId = ?,memberId = ? WHERE missionParticipatorId = ?";
	private static final String DELETE = "DELETE FROM MissionParticipator WHERE missionParticipatorId = ?";

	public MissionParticipatorBean insert(MissionParticipatorBean bean)
	{
		MissionParticipatorBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getMissionId());
				pstmt.setInt(2,bean.getMemberId());

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = select(key.getInt(1));
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

	public MissionParticipatorBean update(MissionParticipatorBean bean)
	{
		MissionParticipatorBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{

				pstmt.setInt(1,bean.getMissionId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setInt(3,bean.getMissionParticipatorId());

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = bean;
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(int id)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,id);
			int num = pstmt.executeUpdate();
			if(num == 1)
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

	public List<MissionParticipatorBean> select()
	{
		List<MissionParticipatorBean> result = new ArrayList<MissionParticipatorBean>();
		MissionParticipatorBean bean = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new MissionParticipatorBean();
				bean.setMissionId(rs.getInt("MissionId"));
				bean.setMemberId(rs.getInt("MemberId"));
				bean.setMissionParticipatorId(rs.getInt("MissionParticipatorId"));

				result.add(bean);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public MissionParticipatorBean select(int id)
	{
		MissionParticipatorBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					result = new MissionParticipatorBean();
					result.setMissionId(rs.getInt("MissionId"));
					result.setMemberId(rs.getInt("MemberId"));
					result.setMissionParticipatorId(rs.getInt("MissionParticipatorId"));
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

	public static void main(String[] args)
	{

		MissionParticipatorDAOJdbc dao = new MissionParticipatorDAOJdbc();
		// insert
		MissionParticipatorBean bean1 = new MissionParticipatorBean();
		bean1.setMissionId(1);
		bean1.setMemberId(2);
		bean1 = dao.insert(bean1);
		System.out.println(bean1);
		System.out.println("--------------------------------------------");

		// update
		MissionParticipatorBean bean2 = new MissionParticipatorBean();
		bean2.setMissionParticipatorId(3);
		bean2.setMissionId(2);
		bean2.setMemberId(3);
		System.out.println(dao.update(bean2));

		System.out.println("--------------------------------------------");

		// delete
		System.out.println(dao.delete(1));

		System.out.println("--------------------------------------------");

		// select_pk
		MissionParticipatorBean bean4 = new MissionParticipatorBean();
		bean4 = dao.select(1);
		System.out.println(bean4);

		System.out.println("--------------------------------------------");

		// select_all
		List<MissionParticipatorBean> list = dao.select();

		for(MissionParticipatorBean bean : list)
		{
			System.out.println(bean);
			System.out.println("");
		}
	}

}

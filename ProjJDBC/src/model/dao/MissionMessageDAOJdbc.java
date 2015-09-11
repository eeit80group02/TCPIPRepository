package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MissionMessageBean;
import model.dao.interfaces.MissionMessageDAO;

public class MissionMessageDAOJdbc implements MissionMessageDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_PK = "SELECT missionMessageId,missionId,memberId,content,messageTime FROM MissionMessage WHERE missionMessageId = ?";
	private static final String SELECT_ALL = "SELECT missionMessageId,missionId,memberId,content,messageTime FROM MissionMessage";
	private static final String INSERT = "INSERT INTO MissionMessage (missionId,memberId,content,messageTime) values (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE MissionMessage SET missionId = ?,memberId = ?,content = ?,messageTime = ? WHERE missionMessageId = ?";
	private static final String DELETE = "DELETE FROM MissionMessage WHERE missionMessageId = ?";

	public MissionMessageBean insert(MissionMessageBean bean)
	{
		MissionMessageBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getMissionId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setString(3,bean.getContent());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getMessageTime().getTime()));
				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					ResultSet key = pstmt.getGeneratedKeys();
					if(key.next())
					{
						result = select(key.getInt(1));
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

	public MissionMessageBean update(MissionMessageBean bean)
	{
		MissionMessageBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getMissionId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setString(3,bean.getContent());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getMessageTime().getTime()));
				pstmt.setInt(5,bean.getMissionMessageId());

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

	public MissionMessageBean select(int id)
	{
		MissionMessageBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					result = new MissionMessageBean();
					result.setMissionMessageId(rs.getInt("MissionMessageId"));
					result.setMissionId(rs.getInt("MissionId"));
					result.setMemberId(rs.getInt("MemberId"));
					result.setContent(rs.getString("Content"));
					result.setMessageTime(rs.getTimestamp("messageTime"));
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

	public List<MissionMessageBean> select()
	{
		List<MissionMessageBean> result = new ArrayList<MissionMessageBean>();
		MissionMessageBean bean = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new MissionMessageBean();
				bean.setMissionMessageId(rs.getInt("MissionMessageId"));
				bean.setMissionId(rs.getInt("MissionId"));
				bean.setMemberId(rs.getInt("MemberId"));
				bean.setContent(rs.getString("Content"));
				bean.setMessageTime(rs.getTimestamp("messageTime"));
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
		MissionMessageDAOJdbc dao = new MissionMessageDAOJdbc();
		
		// insert
		MissionMessageBean bean1 = new MissionMessageBean();
		bean1.setMissionId(1);
		bean1.setMemberId(7);
		bean1.setContent("大家好!!!aabb");
		bean1.setMessageTime(new java.util.Date(System.currentTimeMillis()));
		bean1 = dao.insert(bean1);
		System.out.println(bean1);

		System.out.println("--------------------------------------------");

		// update
		MissionMessageBean bean2 = new MissionMessageBean();
		bean2.setMissionMessageId(1);
		bean2.setMissionId(1);
		bean2.setMemberId(6);
		bean2.setContent("我要吃xxxxxxxxxGG");
		bean2.setMessageTime(new java.util.Date(System.currentTimeMillis()));
		bean2 = dao.update(bean2);
		System.out.println(bean2);
		System.out.println("--------------------------------------------");

		// dalete
		System.out.println(dao.delete(2));

		System.out.println("--------------------------------------------");

		// select_pk
		MissionMessageBean bean4 = dao.select(2);
		System.out.println(bean4);
		System.out.println("--------------------------------------------");

		// select_all
		List<MissionMessageBean> list = dao.select();

		for(MissionMessageBean bean : list)
		{
			System.out.println(bean);
			System.out.println("");
		}
	}
}

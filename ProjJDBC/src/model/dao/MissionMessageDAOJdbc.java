package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.MemberBean;
import model.MissionMessageBean;

public class MissionMessageDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_BY_PK = "select * from MissionMessage where missionMessageId=?";
	private static final String SELECT_ALL = "select * from MissionMessage";
	private static final String INSERT = "insert into MissionMessage (missionId, memberId, content, messageTime) values (?, ?, ?, ?)";
	private static final String UPDATE = "update MissionMessage set missionId=?, memberId=?, content=?, messageTime=? where missionMessageId=?";
	private static final String DELETE = "delete from MissionMessage where missionMessageId=?";
	
	public MissionMessageBean insert(MissionMessageBean bean) {
		MissionMessageBean result = null;
		ResultSet key = null;
		try (	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);){
			if (bean != null) {
				stmt.setInt(1, bean.getMissionId());
				stmt.setInt(2, bean.getMemberId());
				stmt.setString(3, bean.getContent());
				java.util.Date date = bean.getMessageTime();
				if (date != null) {
					long time = date.getTime();
					stmt.setDate(4, new java.sql.Date(time));
				} else {
					stmt.setDate(4, null);
				}
				
				int num = stmt.executeUpdate();
				if (num == 1) {
					key = stmt.getGeneratedKeys();
					int pk = 0;
					if (key.next()) {
						pk = key.getInt(1);
					}
					result = select(pk);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MissionMessageBean update(MissionMessageBean bean) {
		MissionMessageBean result = null;
		try (	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);){
			if (bean != null) {
				stmt.setInt(1, bean.getMissionId());
				stmt.setInt(2, bean.getMemberId());
				stmt.setString(3, bean.getContent());
				java.util.Date date = bean.getMessageTime();
				if (date != null) {
					long time = date.getTime();
					stmt.setDate(4, new java.sql.Date(time));
				} else {
					stmt.setDate(4, null);
				}
				stmt.setInt(5, bean.getMissionMessageId());

				int num = stmt.executeUpdate();
				if (num == 1) {
					result = bean;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean delete(int id) {
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, id);
			int num = stmt.executeUpdate();
			if (num == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	public MissionMessageBean select(int id) {
		MissionMessageBean result = null;
		ResultSet rs = null;
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PK);) {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = new MissionMessageBean();
				result.setMissionId(rs.getInt("MissionId"));
				result.setMemberId(rs.getInt("MemberId"));
				result.setContent(rs.getString("Content"));
				result.setMissionMessageId(rs.getInt("MissionMessageId"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public List<MissionMessageBean> select() {
		List<MissionMessageBean> result = new ArrayList<MissionMessageBean>();
		MissionMessageBean bean = null;
		ResultSet rs = null;
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new MissionMessageBean();
				bean.setMissionId(rs.getInt("MissionId"));
				bean.setMemberId(rs.getInt("MemberId"));
				bean.setContent(rs.getString("Content"));
				bean.setMessageTime(rs.getDate("MessageTime"));
				bean.setMissionMessageId(rs.getInt("MissionMessageId"));
				result.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		// insert
//		MissionMessageDAOJdbc dao1 = new MissionMessageDAOJdbc();
//		MissionMessageBean bean1 = new MissionMessageBean();
//		bean1.setMissionId(1);
//		bean1.setMemberId(7);
//		bean1.setContent("大家好!!!aabb");
//		// 時分秒
//		Date date = new Date();
//		long time = date.getTime();
//		Date date1 = new Date(time);
//		bean1.setMessageTime(date1);
//		bean1 = dao1.insert(bean1);
//		System.out.println(bean1);
		
		System.out.println("--------------------------------------------");
		
		// update
//		MissionMessageDAOJdbc dao2 = new MissionMessageDAOJdbc();
//		MissionMessageBean bean2 = new MissionMessageBean();
//		bean2.setMissionId(1);
//		bean2.setMemberId(6);
//		bean2.setContent("我要吃xxxxxxxxxGG");
//		// 時分秒
//		Date date = new Date();
//		long time = date.getTime();
//		Date date1 = new Date(time);
//		bean2.setMessageTime(date1);
//		bean2.setMissionMessageId(2);
//		dao2.update(bean2);
		
		System.out.println("--------------------------------------------");
		
		// dalete
//		MissionMessageDAOJdbc dao3 = new MissionMessageDAOJdbc();
//		dao3.delete(2);
		
		System.out.println("--------------------------------------------");
		
		// select_pk
		MissionMessageDAOJdbc dao4 = new MissionMessageDAOJdbc();
		MissionMessageBean bean4 = dao4.select(2);
		// toString無法顯示時間
		System.out.println(bean4);
		
		System.out.println("--------------------------------------------");
		
		// select_all
		MissionMessageDAOJdbc dao5 = new MissionMessageDAOJdbc();
		List<MissionMessageBean> list = dao5.select();
		
		for (MissionMessageBean bean : list) {
			System.out.println(bean);
			System.out.println("");
		}
	}
}

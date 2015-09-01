package model.dao;

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

import model.MissionParticipatorBean;

public class MissionParticipatorDAOJdbc {
	// JDBC
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
	// JNDI
	private DataSource dataSource;
	public MissionParticipatorDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TCPIPServer");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_PK = "select * from MissionParticipator where missionParticipatorId=?";
	private static final String SELECT_ALL = "select * from MissionParticipator";
	private static final String INSERT = "insert into MissionParticipator (missionId, memberId) values (?, ?)";
	private static final String UPDATE = "update MissionParticipator set missionId=?, memberId=? where missionParticipatorId=?";
	private static final String DELETE = "delete from MissionParticipator where missionParticipatorId=?";
	
	public MissionParticipatorBean insert(MissionParticipatorBean bean) {
		MissionParticipatorBean result = null;
		ResultSet key = null;
		try (	Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);){
			if (bean != null) {
				stmt.setInt(1, bean.getMissionId());
				stmt.setInt(2, bean.getMemberId());
				
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
	
	public MissionParticipatorBean update(MissionParticipatorBean bean) {
		MissionParticipatorBean result = null;
		ResultSet key = null;
		try (	Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);){
			if (bean != null) {
				stmt.setInt(1, bean.getMissionId());
				stmt.setInt(2, bean.getMemberId());
				stmt.setInt(3, bean.getMissionParticipatorId());
				
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
				Connection conn = dataSource.getConnection();
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
	
	public List<MissionParticipatorBean> select() {
		List<MissionParticipatorBean> result = new ArrayList<MissionParticipatorBean>();
		MissionParticipatorBean bean = null;
		ResultSet rs = null;
		try (	
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new MissionParticipatorBean();
				bean.setMissionId(rs.getInt("MissionId"));
				bean.setMemberId(rs.getInt("MemberId"));
				bean.setMissionParticipatorId(rs.getInt("MissionParticipatorId"));
				
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
	
	public MissionParticipatorBean select(int id) {
		MissionParticipatorBean result = null;
		ResultSet rs = null;
		try (	
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PK);) {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = new MissionParticipatorBean();
				result.setMissionId(rs.getInt("MissionId"));
				result.setMemberId(rs.getInt("MemberId"));
				result.setMissionParticipatorId(rs.getInt("MissionParticipatorId"));
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
//		MissionParticipatorDAOJdbc dao1 = new MissionParticipatorDAOJdbc();
//		MissionParticipatorBean bean1 = new MissionParticipatorBean();
//		bean1.setMissionId(5);
//		bean1.setMemberId(6);
//		dao1.insert(bean1);
		
		System.out.println("--------------------------------------------");
		
		// update
//		MissionParticipatorDAOJdbc dao2 = new MissionParticipatorDAOJdbc();
//		MissionParticipatorBean bean2 = new MissionParticipatorBean();
//		bean2.setMissionId(5);
//		bean2.setMemberId(6);
//		bean2.setMissionParticipatorId(1);
//		dao2.update(bean2);
		
		System.out.println("--------------------------------------------");
		
		// delete
//		MissionParticipatorDAOJdbc dao3 = new MissionParticipatorDAOJdbc();
//		MissionParticipatorBean bean3 = new MissionParticipatorBean();
//		dao3.delete(1);
		
		System.out.println("--------------------------------------------");
		
		// select_pk
		MissionParticipatorDAOJdbc dao4 = new MissionParticipatorDAOJdbc();
		MissionParticipatorBean bean4 = new MissionParticipatorBean();
		bean4 = dao4.select(2);		
		System.out.println(bean4);
		
		System.out.println("--------------------------------------------");
		
		// select_all
//		MissionParticipatorDAOJdbc dao5 = new MissionParticipatorDAOJdbc();
//		List<MissionParticipatorBean> list = dao5.select();
//		
//		for (MissionParticipatorBean bean : list) {
//			System.out.println(bean);
//			System.out.println("");
//		}
	}

}

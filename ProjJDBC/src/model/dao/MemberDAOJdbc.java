package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MemberBean;

public class MemberDAOJdbc {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
	// JNDI
		private DataSource dataSource;
		public MemberDAOJdbc() {
			try {
				Context ctx = new InitialContext();
				this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TCPIPServer");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	
	private static final String SELECT_BY_PK = "select * from Member where memberId=?";
	private static final String SELECT_ALL = "select * from Member";
	private static final String INSERT = "insert into Member (lastName, firstName, idNumber, phone, cellPhone, birthday, address, gender, email, pitctureName, pitcture, pitctureLength, registerTime, RecommendCount, account, password, accountStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "update Member set lastName=?, firstName=?, idNumber=? , phone=?,cellPhone=?,birthday=?,address=?, gender=?, email=?, pitctureName=?, pitcture=?, pitctureLength=?, registerTime=?, RecommendCount=?, account=?, password=?, accountStatus=? where memberId=?";
	private static final String DELETE = "delete from Member where memberId=?";
	
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		ResultSet key = null;
		try (	Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);){
			if (bean != null) {
				stmt.setString(1, bean.getLastName());
				stmt.setString(2, bean.getFirstName());
				stmt.setString(3, bean.getIdNumber());
				stmt.setString(4, bean.getPhone());
				stmt.setString(5, bean.getCellPhone());
				java.util.Date bdate = bean.getBirthday();
				if (bdate != null) {
					long btime = bdate.getTime();
					stmt.setDate(6, new java.sql.Date(btime));
				} else {
					stmt.setDate(6, null);
				}
				stmt.setString(7, bean.getAddress());
				stmt.setString(8, bean.getGender());
				stmt.setString(9, bean.getEmail());
				stmt.setString(10, bean.getPitctureName());
				stmt.setBytes(11, bean.getPitcture());
				stmt.setLong(12, bean.getPitctureLength());
				java.util.Date rdate = bean.getRegisterTime();
				if (rdate != null) {
					long rtime = rdate.getTime();
					stmt.setDate(13, new java.sql.Date(rtime));
				} else {
					stmt.setDate(13, null);
				}
				stmt.setInt(14, bean.getRecommendCount());
				stmt.setString(15, bean.getAccount());
				stmt.setBytes(16, bean.getPassword());
				stmt.setString(17, bean.getAccountStatus());
				
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
	
	public MemberBean update(MemberBean bean) {
		MemberBean result = null;
		try (	Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);){
			if (bean != null) {
				stmt.setString(1, bean.getLastName());
				stmt.setString(2, bean.getFirstName());
				stmt.setString(3, bean.getIdNumber());
				stmt.setString(4, bean.getPhone());
				stmt.setString(5, bean.getCellPhone());
				java.util.Date bdate = bean.getBirthday();
				if (bdate != null) {
					long btime = bdate.getTime();
					stmt.setDate(6, new java.sql.Date(btime));
				} else {
					stmt.setDate(6, null);
				}
				stmt.setString(7, bean.getAddress());
				stmt.setString(8, bean.getGender());
				stmt.setString(9, bean.getEmail());
				stmt.setString(10, bean.getPitctureName());
				stmt.setBytes(11, bean.getPitcture());
				stmt.setLong(12, bean.getPitctureLength());
				java.util.Date rdate = bean.getRegisterTime();
				if (rdate != null) {
					long rtime = rdate.getTime();
					stmt.setDate(13, new java.sql.Date(rtime));
				} else {
					stmt.setDate(13, null);
				}
				stmt.setInt(14, bean.getRecommendCount());
				stmt.setString(15, bean.getAccount());
				stmt.setBytes(16, bean.getPassword());
				stmt.setString(17, bean.getAccountStatus());
				stmt.setInt(18, bean.getMemberId());

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
	
	public MemberBean select(int id) {
		MemberBean result = null;
		ResultSet rs = null;
		try (	
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PK);) {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = new MemberBean();
				result.setMemberId(rs.getInt("memberId"));
				result.setLastName(rs.getString("LastName"));
				result.setFirstName(rs.getString("FirstName"));
				result.setIdNumber(rs.getString("IdNumber"));
				result.setPhone(rs.getString("Phone"));
				result.setCellPhone(rs.getString("CellPhone"));
				result.setBirthday(rs.getDate("Birthday"));
				
				result.setAddress(rs.getString("Address"));
				result.setGender(rs.getString("Gender"));
				result.setEmail(rs.getString("Email"));
				result.setPitctureName(rs.getString("PitctureName"));
				result.setPitcture(rs.getBytes("Pitcture"));
				result.setPitctureLength(rs.getLong("PitctureLength"));
				result.setRegisterTime(rs.getDate("RegisterTime"));
				
				result.setRecommendCount(rs.getInt("RecommendCount"));
				result.setAccount(rs.getString("Account"));
				result.setPassword(rs.getBytes("Password"));
				result.setAccountStatus(rs.getString("AccountStatus"));
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
	
	public List<MemberBean> select() {
		List<MemberBean> result = new ArrayList<MemberBean>();
		MemberBean bean = null;
		ResultSet rs = null;
		try (	
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new MemberBean();
				bean.setMemberId(rs.getInt("memberId"));
				bean.setLastName(rs.getString("LastName"));
				bean.setFirstName(rs.getString("FirstName"));
				bean.setIdNumber(rs.getString("IdNumber"));
				bean.setPhone(rs.getString("Phone"));
				bean.setCellPhone(rs.getString("CellPhone"));
				bean.setBirthday(rs.getDate("Birthday"));
				
				bean.setAddress(rs.getString("Address"));
				bean.setGender(rs.getString("Gender"));
				bean.setEmail(rs.getString("Email"));
				bean.setPitctureName(rs.getString("PitctureName"));
				bean.setPitcture(rs.getBytes("Pitcture"));
				bean.setPitctureLength(rs.getLong("PitctureLength"));
				bean.setRegisterTime(rs.getDate("RegisterTime"));
				
				bean.setRecommendCount(rs.getInt("RecommendCount"));
				bean.setAccount(rs.getString("Account"));
				bean.setPassword(rs.getBytes("Password"));
				bean.setAccountStatus(rs.getString("AccountStatus"));
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
//		MemberDAOJdbc dao1 = new MemberDAOJdbc();
//		MemberBean bean1 = new MemberBean();
//		bean1.setLastName("鋼鐵808080");
//		bean1.setFirstName("人");
//		bean1.setIdNumber("F55667788");
//		bean1= dao1.insert(bean1);
//		System.out.println(bean1);
		
		System.out.println("----------------------------------------------");
		
		// update
//		MemberDAOJdbc dao2 = new MemberDAOJdbc();
//		MemberBean bean2 = new MemberBean();
//		bean2.setLastName("sss8899");
//		bean2.setFirstName("rrr");
//		bean2.setIdNumber("F55667788");
//		bean2.setMemberId(10);
//		dao2.update(bean2);
//		System.out.println(dao2.select(10));
//		
//		System.out.println("----------------------------------------------");
		
		// delete
//		MemberDAOJdbc dao3 = new MemberDAOJdbc();
//		MemberBean bean3 = new MemberBean();
//		bean3.setMemberId(8);
//		boolean count = dao3.delete(bean3.getMemberId());
//		System.out.println(count);
		
		System.out.println("----------------------------------------------");

		
		// select_pk
//		MemberDAOJdbc dao4 = new MemberDAOJdbc();
//		MemberBean bean4 = new MemberBean();
//		bean4 = dao4.select(7);
//		
//		System.out.println(
//			"id="+bean4.getMemberId()+", "
//			+bean4.getLastName()+", "
//			+bean4.getFirstName()+", "
//			+bean4.getIdNumber()+", "
//			+bean4.getPhone()+", "
//			+bean4.getCellPhone()+", "
//			+bean4.getBirthday()+", "
//			+bean4.getAddress()+", "
//			+bean4.getGender()+", "
//			+bean4.getEmail()+", "
//			+bean4.getPitctureName()+", "
//			+bean4.getPitcture()+", "
//			+bean4.getPitctureLength()+", "
//			+bean4.getRegisterTime()+", "
//			+bean4.getRecommendCount()+", "
//			+bean4.getAccount()+", "
//			+bean4.getPassword()+", "
//			+bean4.getAccountStatus());
		
		System.out.println("----------------------------------------------");
		
		// select_all
//		MemberDAOJdbc dao5 = new MemberDAOJdbc();
//		List<MemberBean> list = dao5.select();
//		
//		for (MemberBean bean : list) {
//			System.out.println(
//					"id="+bean.getMemberId()+", "
//					+bean.getLastName()+", "
//					+bean.getFirstName()+", "
//					+bean.getIdNumber()+", "
//					+bean.getPhone()+", "
//					+bean.getCellPhone()+", "
//					+bean.getBirthday()+", "
//					+bean.getAddress()+", "
//					+bean.getGender()+", "
//					+bean.getEmail()+", "
//					+bean.getPitctureName()+", "
//					+bean.getPitcture()+", "
//					+bean.getPitctureLength()+", "
//					+bean.getRegisterTime()+", "
//					+bean.getRecommendCount()+", "
//					+bean.getAccount()+", "
//					+bean.getPassword()+", "
//					+bean.getAccountStatus());
//			System.out.println("");
//		}
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GradeStudentBean;

public class GradeStudentDAOJdbc {

	public static void main(String[] args) {
		GradeStudentDAOJdbc jdbc = new GradeStudentDAOJdbc();
		GradeStudentBean bean = new GradeStudentBean();
		bean.setSchoolId(999999);
		bean.setAnniversary(103);
		bean.setElementaryFirst(126);
		bean.setElementarySecond(111);
		bean.setElementaryThird(107);
		bean.setElementaryFourth(113);
		bean.setElementaryFifth(100);
		bean.setElementarySixth(107);
		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.findByPrimaryKey(999999));
		System.out.println(jdbc.update(103, 111, 111, 111, 111, 111, 111, 0, 0, 0, 999999));
		System.out.println(jdbc.delete(999999));
		System.out.println(jdbc.getAll().size());
		
		
	}
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ALL = "select * from GradeStudent ";
	public List<GradeStudentBean> getAll(){
		List<GradeStudentBean> result = null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<GradeStudentBean>();
			while(rset.next()) {
				GradeStudentBean bean = new GradeStudentBean();
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setAnniversary(rset.getInt("anniversary"));
				bean.setElementaryFirst(rset.getInt("elementaryFirst"));
				bean.setElementarySecond(rset.getInt("elementarySecond"));
				bean.setElementaryThird(rset.getInt("elementaryThird"));
				bean.setElementaryFourth(rset.getInt("elementaryFourth"));
				bean.setElementaryFifth(rset.getInt("elementaryFifth"));
				bean.setElementarySixth(rset.getInt("elementarySixth"));
				bean.setJuniorFirst(rset.getInt("juniorFirst"));
				bean.setJuniorSecond(rset.getInt("juniorSecond"));
				bean.setJuniorThird(rset.getInt("juniorThird"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SELECT_BY_ID = "select * from GradeStudent where schoolId =?";
	public GradeStudentBean findByPrimaryKey(int schoolId){
		GradeStudentBean result = null;
		ResultSet rset= null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setInt(1, schoolId);
			rset = stmt.executeQuery();
			while(rset.next()) {
				result = new GradeStudentBean();
				result.setSchoolId(rset.getInt("schoolId"));
				result.setAnniversary(rset.getInt("anniversary"));
				result.setElementaryFirst(rset.getInt("elementaryFirst"));
				result.setElementarySecond(rset.getInt("elementarySecond"));
				result.setElementaryThird(rset.getInt("elementaryThird"));
				result.setElementaryFourth(rset.getInt("elementaryFourth"));
				result.setElementaryFifth(rset.getInt("elementaryFifth"));
				result.setElementarySixth(rset.getInt("elementarySixth"));
				result.setJuniorFirst(rset.getInt("juniorFirst"));
				result.setJuniorSecond(rset.getInt("juniorSecond"));
				result.setJuniorThird(rset.getInt("juniorThird"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String INSERT = "insert into GradeStudent (schoolId, anniversary, elementaryFirst, elementarySecond, elementaryThird,"
																+ "elementaryFourth, elementaryFifth, elementarySixth, juniorFirst, juniorSecond,"
																+ "juniorThird) values (?,?,?,?,?,?,?,?,?,?,?)"; 
	public GradeStudentBean insert(GradeStudentBean bean) {
		GradeStudentBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(bean!=null) {
				stmt.setInt(1, bean.getSchoolId());
				stmt.setInt(2, bean.getAnniversary());
				stmt.setInt(3, bean.getElementaryFirst());
				stmt.setInt(4, bean.getElementarySecond());
				stmt.setInt(5, bean.getElementaryThird());
				stmt.setInt(6, bean.getElementaryFourth());
				stmt.setInt(7, bean.getElementaryFifth());
				stmt.setInt(8, bean.getElementarySixth());
				stmt.setInt(9, bean.getJuniorFirst());
				stmt.setInt(10, bean.getJuniorSecond());
				stmt.setInt(11, bean.getJuniorThird());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String UPDATE ="update GradeStudent set anniversary=?, elementaryFirst=?, elementarySecond=?, elementaryThird=?,"
																+"elementaryFourth=?, elementaryFifth=?, elementarySixth=?, juniorFirst=?,"
																+ "juniorSecond=?, juniorThird=? where schoolId=?";
	
	public GradeStudentBean update(int anniversary, int elementaryFirst, int elementarySecond, int elementaryThird, 
								   int elementaryFourth, int elementaryFifth, int elementarySixth, int juniorFirst, 
								   int juniorSecond, int juniorThird, int schoolId ){
		GradeStudentBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setInt(1, anniversary);
			stmt.setInt(2, elementaryFirst);
			stmt.setInt(3, elementarySecond);
			stmt.setInt(4, elementaryThird);
			stmt.setInt(5, elementaryFourth);
			stmt.setInt(6, elementaryFifth);
			stmt.setInt(7, elementarySixth);
			stmt.setInt(8, juniorFirst);
			stmt.setInt(9, juniorSecond);
			stmt.setInt(10, juniorThird);
			stmt.setInt(11, schoolId);
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.findByPrimaryKey(schoolId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String DELETE = "delete from GradeStudent where schoolId=?";
	public boolean delete(int schoolId) {
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setInt(1, schoolId);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

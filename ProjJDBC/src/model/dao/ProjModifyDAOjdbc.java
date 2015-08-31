package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjModifyBean;

public class ProjModifyDAOjdbc {

	
	public static void main(String[] args){
		ProjModifyDAOjdbc jdbc = new ProjModifyDAOjdbc();

	}
	
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ALL = "select * from ProjModify ";
	public List<ProjModifyBean> getAll(){
		List<ProjModifyBean> result = null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<ProjModifyBean>();
			while(rset.next()) {
				ProjModifyBean bean = new ProjModifyBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setSchoolMessage(rset.getString("schoolMessage"));
				bean.setSchoolMessageTime(rset.getDate("schoolMessageTime"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setMemberMessage(rset.getString("memberMessage"));
				bean.setMemberMessageTime(rset.getDate("memberMessageTime"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "select * from ProjModify where fullProjId =? and schoolId=? ";
	public ProjModifyBean findByPrimaryKey(int fullProjId, int schoolId){
		ProjModifyBean result = null;
		ResultSet rset= null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, schoolId);
			rset = stmt.executeQuery();
			while(rset.next()) {
				result.setFullProjId(rset.getInt("fullProjId"));
				result.setSchoolId(rset.getInt("schoolId"));
				result.setSchoolMessage(rset.getString("schoolMessage"));
				result.setSchoolMessageTime(rset.getDate("schoolMessageTime"));
				result.setMemberId(rset.getInt("memberId"));
				result.setMemberMessage(rset.getString("memberMessage"));
				result.setMemberMessageTime(rset.getDate("memberMessageTime"));
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
	
	private static final String INSERT = "insert into ProjModify (fullProjId, schoolId, schoolMessage, schoolMessageTime, memberId,"
															 + "memberMessage, memberMessageTime) values (?,?,?,?,?,?,?)";
	
	public ProjModifyBean insert(ProjModifyBean bean){
		ProjModifyBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(bean!=null) {
				stmt.setInt(1, bean.getFullProjId());
				stmt.setInt(2, bean.getSchoolId());
				stmt.setString(3, bean.getSchoolMessage());
				java.util.Date make1 = bean.getSchoolMessageTime();
				if(make1!=null){
					stmt.setDate(4, new java.sql.Date(make1.getTime()));
				} else{
					stmt.setDate(4, null);
				}
				stmt.setInt(5, bean.getMemberId());
				stmt.setString(6, bean.getMemberMessage());
				java.util.Date make2 = bean.getMemberMessageTime();
				if(make2!=null){
					stmt.setDate(7, new java.sql.Date(make2.getTime()));
				} else{
					stmt.setDate(7, null);
				}
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
	
private static final String UPDATE ="update ProjModify set schoolMessage=?, schoolMessageTime=?, memberId=?, memberMessage=?, memberMessageTime=? "
								  + "where fullProjId=? and schoolId=? ";
	
	public ProjModifyBean update(String schoolMessage, java.util.Date schoolMessageTime, int memberId, String memberMessage, java.util.Date memberMessageTime, 
							int fullProjId, int schoolId){
		ProjModifyBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, schoolMessage);
			stmt.setDate(2, new java.sql.Date(schoolMessageTime.getTime()));
			stmt.setInt(3, memberId);
			stmt.setString(4, memberMessage);
			stmt.setDate(5, new java.sql.Date(memberMessageTime.getTime()));
			stmt.setInt(6, fullProjId);
			stmt.setInt(7, schoolId);
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.findByPrimaryKey(fullProjId,schoolId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String DELETE = "delete from ProjModify where fullProjId=? and schoolId=? ";
	
	public boolean delete(int fullProjId, int schoolId) {
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, schoolId);
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

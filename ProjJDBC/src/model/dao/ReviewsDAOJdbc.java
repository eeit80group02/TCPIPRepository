package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReviewsBean;

public class ReviewsDAOJdbc {

	public static void main(String[] args) {
		ReviewsDAOJdbc jdbc = new ReviewsDAOJdbc();
		ReviewsBean bean = new ReviewsBean();
		bean.setFullProjId(5);
		bean.setReferMemberId(1);
		bean.setReferedMemberId(2);
		bean.setContent("GOOD");
		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.getAll());
		System.out.println(jdbc.findByPrimaryKey(5, 1, 2));
		System.out.println(jdbc.update("好帥", 5, 1, 2));
		System.out.println(jdbc.delete(5, 1, 2));

	}
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ALL = "select * from Reviews ";
	public List<ReviewsBean> getAll(){
		List<ReviewsBean> result = null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<ReviewsBean>();
			while(rset.next()) {
				ReviewsBean bean = new ReviewsBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setReferMemberId(rset.getInt("referMemberId"));
				bean.setReferedMemberId(rset.getInt("referedMemberId"));
				bean.setContent(rset.getString("content"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SELECT_BY_ID = "select * from Reviews where fullProjId =? and referMemberId=? and referedMemberId=?";
	public ReviewsBean findByPrimaryKey(int fullProjId, int referMemberId, int referedMemberId){
		ReviewsBean result = null;
		ResultSet rset= null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, referMemberId);
			stmt.setInt(3, referedMemberId);
			rset = stmt.executeQuery();
			while(rset.next()) {
				result = new ReviewsBean();
				result.setFullProjId(rset.getInt("fullProjId"));
				result.setReferMemberId(rset.getInt("referMemberId"));
				result.setReferedMemberId(rset.getInt("referedMemberId"));
				result.setContent(rset.getString("content"));
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
	
	private static final String INSERT = "insert into Reviews (fullProjId, referMemberId, referedMemberId, content) values (?,?,?,?)";
	
	public ReviewsBean insert(ReviewsBean bean){
		ReviewsBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(bean!=null) {
				stmt.setInt(1, bean.getFullProjId());
				stmt.setInt(2, bean.getReferMemberId());
				stmt.setInt(3, bean.getReferedMemberId());
				stmt.setString(4, bean.getContent());
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
	
	private static final String UPDATE ="update Reviews set content=? where fullProjId=? and referMemberId=? and referedMemberId=? ";
	
	public ReviewsBean update(String content, int fullProjId, int referMemberId, int referedMemberId){
		ReviewsBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, content);
			stmt.setInt(2, fullProjId);
			stmt.setInt(3, referMemberId);
			stmt.setInt(4, referedMemberId);
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.findByPrimaryKey(fullProjId,referMemberId,referedMemberId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String DELETE = "delete from Reviews where fullProjId=? and referMemberId=? and referedMemberId=?";
	
	public boolean delete(int fullProjId, int referMemberId, int referedMemberId) {
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, referMemberId);
			stmt.setInt(3, referedMemberId);
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

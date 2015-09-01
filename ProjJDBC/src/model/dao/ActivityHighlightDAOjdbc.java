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

import model.ActivityHighlightBean;
import model.MissionMessageBean;
import model.MissionParticipatorBean;

public class ActivityHighlightDAOjdbc {
	
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_BY_PRYMARY_KEY = "select * from ActivityHighlight where fullProjId=? and memberId=?";
	private static final String GET_ALL = "select * from ActivityHighlight";
	private static final String INSERT = "insert into ActivityHighlight (fullProjId, memberId, imageCover, vedioURL, content) values (?, ?, ?, ?, ?)";
	private static final String UPDATE = "update ActivityHighlight set imageCover=?, vedioURL=?, content=? where fullProjId=? and memberId=?";
	private static final String DELETE = "delete from ActivityHighlight where fullProjId=? and memberId=?";


	
	public ActivityHighlightBean findByPrimaryKey(int fullProjId, int memberId) {
		ActivityHighlightBean result = null;
		ResultSet rs = null;
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);) {
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, memberId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = new ActivityHighlightBean();
				result.setImageCover(rs.getBytes("ImageCover"));
				result.setVedioURL(rs.getString("VedioURL"));
				result.setContent(rs.getString("Content"));
				result.setFullProjId(rs.getInt("FullProjId"));
				result.setMemberId(rs.getInt("MemberId"));
				
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

	
	public List<ActivityHighlightBean> getAll() {
		List<ActivityHighlightBean> result = new ArrayList<ActivityHighlightBean>();
		ActivityHighlightBean bean = null;
		ResultSet rs = null;
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(GET_ALL);) {
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new ActivityHighlightBean();
				bean.setFullProjId(rs.getInt("FullProjId"));
				bean.setMemberId(rs.getInt("MemberId"));
				bean.setImageCover(rs.getBytes("ImageCover"));
				bean.setVedioURL(rs.getString("VedioURL"));
				bean.setContent(rs.getString("Content"));
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

	
	public ActivityHighlightBean insert(ActivityHighlightBean bean) {
		ActivityHighlightBean result = null;
		ResultSet key = null;
		try (	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);){
			if (bean != null) {
				stmt.setInt(1, bean.getFullProjId());
				stmt.setInt(2, bean.getMemberId());
				stmt.setBytes(3, bean.getImageCover());;
				stmt.setString(4, bean.getVedioURL());
				stmt.setString(5, bean.getContent());
				
				int num = stmt.executeUpdate();
				if (num == 1) {
					key = stmt.getGeneratedKeys();
					int pk = 0;
					if (key.next()) {
						pk = key.getInt(1);
					}
//					result = select(pk);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
	}

	
	public ActivityHighlightBean update(ActivityHighlightBean bean) {
		ActivityHighlightBean result = null;
		ResultSet key = null;
		try (	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE)){
			if (bean != null) {
				stmt.setBytes(1, bean.getImageCover());;
				stmt.setString(2, bean.getVedioURL());
				stmt.setString(3, bean.getContent());
				stmt.setInt(4, bean.getFullProjId());
				stmt.setInt(5, bean.getMemberId());
				
				int num = stmt.executeUpdate();
				if (num == 1) {
					result = bean;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return null;
	}

	
	public boolean delete(int fullProjId, int memberId) {
		try (	
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, memberId);
			int num = stmt.executeUpdate();
			if (num == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	public static void main(String[] args) {
		// insert
		ActivityHighlightDAOjdbc dao1 = new ActivityHighlightDAOjdbc();
		ActivityHighlightBean bean1 = new ActivityHighlightBean();
		bean1.setFullProjId(2);
		bean1.setMemberId(6);
		
		String str1 = "qwertyuiop3456";
		byte[] byt1 = str1.getBytes();
		bean1.setImageCover(byt1);
		bean1.setVedioURL(str1);
		bean1.setContent("測試.......");
		dao1.insert(bean1);
		
		// update
//		ActivityHighlightDAOjdbc dao2 = new ActivityHighlightDAOjdbc();
//		ActivityHighlightBean bean2 = new ActivityHighlightBean();
//		
//		String str1 = "777";
//		byte[] byt1 = str1.getBytes();
//		bean2.setImageCover(byt1);
//		bean2.setVedioURL("QOO"+str1);
//		bean2.setContent("測試 update");
//		bean2.setFullProjId(2);
//		bean2.setMemberId(6);
//		dao2.update(bean2);
		
		// delete
//		ActivityHighlightDAOjdbc dao3 = new ActivityHighlightDAOjdbc();
//		dao3.delete(2, 6);
		
		// select_FK
//		ActivityHighlightDAOjdbc dao4 = new ActivityHighlightDAOjdbc();
//		ActivityHighlightBean bean4 = dao4.findByPrimaryKey(2, 6);
//		System.out.println(bean4);
		
		// select_all
		ActivityHighlightDAOjdbc dao5 = new ActivityHighlightDAOjdbc();
		List<ActivityHighlightBean> bean5 = dao5.getAll();
		System.out.println(bean5);
	}
}

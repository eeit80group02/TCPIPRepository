package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OffersBean;



public class OffersDAOJdbc {

	public static void main(String[] args) {
		OffersBean bean = new OffersBean();
		OffersDAOJdbc jdbc = new OffersDAOJdbc();
//		bean.setSchoolDemandId(2);
//		bean.setRoom(true);
//		bean.setPlace(true);
//		bean.setFood(true);
//		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.getAll());
		System.out.println(jdbc.findByPrimaryKey(2));
		System.out.println(jdbc.update(false, false, false, 2));
		System.out.println(jdbc.delete(2));

	}
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ALL = "select * from Offers ";
	public List<OffersBean> getAll(){
		List<OffersBean> result = null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<OffersBean>();
			while(rset.next()) {
				OffersBean bean = new OffersBean();
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setRoom(rset.getBoolean("room"));
				bean.setPlace(rset.getBoolean("place"));
				bean.setFood(rset.getBoolean("food"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private static final String SELECT_BY_ID = "select * from Offers where schoolDemandId =?";
	public OffersBean findByPrimaryKey(int schoolDemandId){
		OffersBean result = null;
		ResultSet rset= null;
		try (
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setInt(1, schoolDemandId);
			rset = stmt.executeQuery();
			while(rset.next()) {
				result = new OffersBean();
				result.setSchoolDemandId(rset.getInt("schoolDemandId"));
				result.setRoom(rset.getBoolean("room"));
				result.setPlace(rset.getBoolean("place"));
				result.setFood(rset.getBoolean("food"));
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
	
	private static final String INSERT = "insert into Offers (schoolDemandId, room, place, food) values (?,?,?,?)";
	
	public OffersBean insert(OffersBean bean){
		OffersBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(bean!=null) {
				stmt.setInt(1, bean.getSchoolDemandId());
				stmt.setBoolean(2, bean.isRoom());
				stmt.setBoolean(3, bean.isPlace());
				stmt.setBoolean(4, bean.isFood());
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
	
	private static final String UPDATE ="update Offers set room=?, place=?, food=? where schoolDemandId=?";
	public OffersBean update(boolean room, boolean place, boolean food, int schoolDemandId){
		OffersBean result = null;
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setBoolean(1, room);
			stmt.setBoolean(2, place);
			stmt.setBoolean(3, food);
			stmt.setInt(4, schoolDemandId);
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.findByPrimaryKey(schoolDemandId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String DELETE = "delete from Offers where schoolDemandId=?";
	public boolean delete(int schoolDemandId) {
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setInt(1, schoolDemandId);
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

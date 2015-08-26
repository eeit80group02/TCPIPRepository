package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrackDonationBean;
import model.TrackProjBean;

public class TrackProjDAOJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		TrackProjDAOJDBC dao = new TrackProjDAOJDBC();
		List<TrackProjBean> beans = dao.getAll();
//		System.out.println(beans);
		TrackProjBean bean = dao.findByPrimaryKey(1, 2);
		System.out.println(bean);

		bean.setFullProjId(4);
		bean.setMemberId(7);
		System.out.println(dao.insert(bean));
		System.out.println(dao.update(1, 6, 4, 7));
		System.out.println(dao.delete(1, 6));
	}

	private static final String SELECT_BY_ID = "select * from trackproj where fullProjId = ? AND memberId = ?";

	public TrackProjBean findByPrimaryKey(int fullProjId, int memberId) {
		TrackProjBean result = null;

		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, memberId);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new TrackProjBean();
				result.setFullProjId(rset.getInt("fullProjId"));
				result.setMemberId(rset.getInt("memberId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String SELECT_ALL = "select * from trackproj";

	public List<TrackProjBean> getAll() {
		List<TrackProjBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<TrackProjBean>();
			while (rset.next()) {
				TrackProjBean bean = new TrackProjBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setMemberId(rset.getInt("memberId"));

				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into trackproj (fullProjId, memberId) values (?, ?)";

	public TrackProjBean insert(TrackProjBean bean) {
		TrackProjBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {

			stmt.setInt(1, bean.getFullProjId());
			stmt.setInt(2, bean.getMemberId());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(bean.getFullProjId(), bean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update trackproj set fullProjId = ?, memberId = ? where fullProjId = ? AND memberId = ?";

	public TrackProjBean update(int newFullProjId, int newMemberId, int fullProjId, int memberId) {
		TrackProjBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setInt(1, newFullProjId);
			stmt.setInt(2, newMemberId);

			stmt.setInt(3, fullProjId);
			stmt.setInt(4, memberId);

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = new TrackProjBean();
				result.setFullProjId(newFullProjId);
				result.setMemberId(newMemberId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from trackproj where fullProjId = ? AND memberId = ?";

	public boolean delete(int fullProjId, int memberId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, memberId);
			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

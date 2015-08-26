package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrackDonationBean;

public class TrackDonationDAOJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		TrackDonationDAOJDBC dao = new TrackDonationDAOJDBC();
		List<TrackDonationBean> beans = dao.getAll();
		// System.out.println(beans);
		TrackDonationBean bean = dao.findByPrimaryKey(3, 6);
		System.out.println(bean);

		bean.setDonationId(2);
		bean.setMemberId(7);
		System.out.println(dao.insert(bean));
		System.out.println(dao.update(4, 6, 2, 7));
		System.out.println(dao.delete(4, 6));
	}

	private static final String SELECT_BY_ID = "select * from trackdonation where donationId = ? AND memberId = ?";

	public TrackDonationBean findByPrimaryKey(int donationId, int memberId) {
		TrackDonationBean result = null;

		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, donationId);
			stmt.setInt(2, memberId);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new TrackDonationBean();
				result.setDonationId(rset.getInt("donationId"));
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

	private static final String SELECT_ALL = "select * from trackdonation";

	public List<TrackDonationBean> getAll() {
		List<TrackDonationBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<TrackDonationBean>();
			while (rset.next()) {
				TrackDonationBean bean = new TrackDonationBean();
				bean.setDonationId(rset.getInt("donationId"));
				bean.setMemberId(rset.getInt("memberId"));

				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into trackdonation (donationId, memberId) values (?, ?)";

	public TrackDonationBean insert(TrackDonationBean bean) {
		TrackDonationBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {

			stmt.setInt(1, bean.getDonationId());
			stmt.setInt(2, bean.getMemberId());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(bean.getDonationId(), bean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update trackdonation set donationId = ?, memberId = ? where donationId = ? AND memberId = ?";

	public TrackDonationBean update(int newDonationId, int newMemberId, int donationId, int memberId) {
		TrackDonationBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setInt(1, newDonationId);
			stmt.setInt(2, newMemberId);

			stmt.setInt(3, donationId);
			stmt.setInt(4, memberId);

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = new TrackDonationBean();
				result.setDonationId(newDonationId);
				result.setMemberId(newMemberId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from trackdonation where donationId = ? AND memberId = ?";

	public boolean delete(int donationId, int memberId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, donationId);
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

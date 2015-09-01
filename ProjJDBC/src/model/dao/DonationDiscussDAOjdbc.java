package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DonationDiscussBean;

public class DonationDiscussDAOjdbc {

	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	private static final String SELECT_BY_PRYMARY_KEY = "select * from DonationDiscuss where memberId=? and schoolId=? and donationId=?";
	private static final String GET_ALL = "select * from DonationDiscuss";
	private static final String INSERT = "insert into DonationDiscuss (donationId, memberMessage, memberMessageTime, schoolMessage, schoolMessageTime,memberId,schoolId) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "update DonationDiscuss set memberMessage=?, memberMessageTime=?, schoolMessage=?,schoolMessageTime=? where memberId=? and schoolId=? and donationId=?";
	private static final String DELETE = "delete from DonationDiscuss where donationId=?";

	public DonationDiscussBean findByPrimaryKey(int memberId, int schoolId, int donationId) {
		DonationDiscussBean bean = null;
		ResultSet rs = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);) {

			pstmt.setInt(1, memberId);
			pstmt.setInt(2, schoolId);
			pstmt.setInt(3, donationId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DonationDiscussBean();
				bean.setDonationId(rs.getInt("donationId"));
				bean.setMemberMessage(rs.getString("memberId"));
				bean.setMemberMessageTime(rs.getDate("memberMessageTime"));
				bean.setSchoolMessage(rs.getString("schoolMessage"));
				bean.setSchoolMessageTime(rs.getDate("schoolMessageTime"));
				bean.setMemberId(rs.getInt("memberId"));
				bean.setSchoolId(rs.getInt("schoolId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	public List<DonationDiscussBean> getAll() {
		List<DonationDiscussBean> resultList = new ArrayList<DonationDiscussBean>();
		DonationDiscussBean bean = null;
		ResultSet rs = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(GET_ALL);) {

			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DonationDiscussBean();
				bean.setDonationId(rs.getInt("donationId"));
				bean.setMemberMessage(rs.getString("memberId"));
				bean.setMemberMessageTime(rs.getDate("memberMessageTime"));
				bean.setSchoolMessage(rs.getString("schoolMessage"));
				bean.setSchoolMessageTime(rs.getDate("schoolMessageTime"));
				bean.setMemberId(rs.getInt("memberId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				resultList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return resultList;
	}

	public DonationDiscussBean insert(DonationDiscussBean bean) {
		DonationDiscussBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			if (bean != null) {
				pstmt.setInt(1, bean.getDonationId());
				pstmt.setString(2, bean.getMemberMessage());
				java.util.Date memberMessageTime = bean.getMemberMessageTime();
				if (memberMessageTime != null) {
					long time = memberMessageTime.getTime();
					pstmt.setDate(3, new java.sql.Date(time));
				} else {
					pstmt.setDate(3, null);
				}
				pstmt.setString(4, bean.getSchoolMessage());
				java.util.Date schoolMessageTime = bean.getSchoolMessageTime();
				if (schoolMessageTime != null) {
					long time = schoolMessageTime.getTime();
					pstmt.setDate(5, new java.sql.Date(time));
				} else {
					pstmt.setDate(5, null);
				}
				pstmt.setInt(6, bean.getMemberId());
				pstmt.setInt(7, bean.getSchoolId());

				int count = pstmt.executeUpdate();
				if (count == 1) {
					System.out.println("insert success");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public DonationDiscussBean update(DonationDiscussBean bean) {
		DonationDiscussBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {

			if (bean != null) {

				pstmt.setString(1, bean.getMemberMessage());

				java.util.Date memberMessageTime = bean.getMemberMessageTime();
				if (memberMessageTime != null) {
					long time = memberMessageTime.getTime();
					pstmt.setDate(2, new java.sql.Date(time));
				} else {
					pstmt.setDate(2, null);
				}

				pstmt.setString(3, bean.getSchoolMessage());

				java.util.Date schoolMessageTime = bean.getSchoolMessageTime();
				if (schoolMessageTime != null) {
					long time = schoolMessageTime.getTime();
					pstmt.setDate(4, new java.sql.Date(time));
				} else {
					pstmt.setDate(4, null);
				}

				pstmt.setInt(5, bean.getMemberId());
				pstmt.setInt(6, bean.getSchoolId());
				pstmt.setInt(7, bean.getDonationId());
				int count = pstmt.executeUpdate();
				if (count >= 1) {
					System.out.println("update success");
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean delete(int donationId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setInt(1, donationId);
			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("delete success");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		DonationDiscussDAOjdbc daojdbc = new DonationDiscussDAOjdbc();
		/** INSERT OK **/
		// DonationDiscussBean bean1 = new DonationDiscussBean();
		// bean1.setDonationId(2);
		// bean1.setMemberId(1);
		// bean1.setMemberMessage("hel22222lo");
		// bean1.setMemberMessageTime(new Date());
		// bean1.setSchoolId(21215);
		// bean1.setSchoolMessage("wor22222ld");
		// bean1.setSchoolMessageTime(new Date());
		// daojdbc.insert(bean1);

		/** UPDATE OK **/
		// DonationDiscussBean bean2 = new DonationDiscussBean();
		// bean2.setDonationId(2);
		// bean2.setMemberId(1);
		// bean2.setMemberMessage("hellojjjjj1");
		// bean2.setMemberMessageTime(new Date());
		// bean2.setSchoolId(21215);
		// bean2.setSchoolMessage("worldjjjjjj11");
		// bean2.setSchoolMessageTime(new Date());
		// daojdbc.update(bean2);

		/** DELETE OK **/
		// DonationDiscussBean bean3 = new DonationDiscussBean();
		// bean3.setDonationId(1);
		// boolean count=daojdbc.delete(bean3.getDonationId());
		// System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY OK **/
		// DonationDiscussBean bean4 = new DonationDiscussBean();
		// bean4=daojdbc.findByPrimaryKey(1,21215,2);
		// System.out.println("" + bean4.getDonationId() + "\t" +
		// bean4.getMemberMessage());

		/** GET_ALL OK **/
		List<DonationDiscussBean> list = daojdbc.getAll();
		System.out.println();
		for (DonationDiscussBean bean5 : list) {
			System.out.println("" + bean5.getDonationId() + "\t" + bean5.getMemberMessage());
		}

	}
}

package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DonationBean;

public class DonationDAOjdbc {

	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	private static final String SELECT_BY_PRYMARY_KEY = "select * from Donation where donationId=? and schoolId=?";
	private static final String GET_ALL = "select * from Donation";
	private static final String INSERT = "insert into Donation (schoolId, donationStatus,supplyName,originalDemandNumber,originalDemandUnit,demandNumber,size,demandContent,supplyStatus,demandTime,expireTime,imageName,imageFile,imageLength,remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "update Donation set donationStatus=?,supplyName=?,originalDemandNumber=?,originalDemandUnit=?,demandNumber=?,size=?,demandContent=?,supplyStatus=?,demandTime=?,expireTime=?,imageName=?,imageFile=?,imageLength=?,remark=? where donationId=? and schoolId=?";
	private static final String DELETE = "delete from Donation where donationId=? and schoolId=?";

	public DonationBean insert(DonationBean bean) {
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {

			if (bean != null) {
				pstmt.setInt(1, bean.getSchoolId());
				pstmt.setString(2, bean.getDonationStatus());
				pstmt.setString(3, bean.getSupplyName());
				pstmt.setInt(4, bean.getOriginalDemandNumber());
				pstmt.setString(5, bean.getOriginalDemandUnit());
				pstmt.setInt(6, bean.getDemandNumber());
				pstmt.setString(7, bean.getSize());
				pstmt.setString(8, bean.getDemandContent());
				pstmt.setString(9, bean.getSupplyStatus());

				java.util.Date tempdate01 = bean.getDemandTime();

				if (tempdate01 != null) {
					long time01 = tempdate01.getTime();
					pstmt.setDate(10, new java.sql.Date(time01));
				} else {
					pstmt.setDate(10, null);
				}

				java.util.Date tempdate02 = bean.getExpireTime();

				if (tempdate02 != null) {
					long time02 = tempdate02.getTime();
					pstmt.setDate(11, new java.sql.Date(time02));
				} else {
					pstmt.setDate(11, null);
				}

				pstmt.setString(12, bean.getImageName());
				pstmt.setBytes(13, bean.getImageFile());
				pstmt.setLong(14, bean.getImageLength());
				pstmt.setString(15, bean.getRemark());

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

	public DonationBean update(DonationBean bean) {
		DonationBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {

			if (bean != null) {

				pstmt.setString(1, bean.getDonationStatus());
				pstmt.setString(2, bean.getSupplyName());
				pstmt.setInt(3, bean.getOriginalDemandNumber());
				pstmt.setString(4, bean.getOriginalDemandUnit());
				pstmt.setInt(5, bean.getDemandNumber());
				pstmt.setString(6, bean.getSize());
				pstmt.setString(7, bean.getDemandContent());
				pstmt.setString(8, bean.getSupplyStatus());

				java.util.Date tempdate01 = bean.getDemandTime();

				if (tempdate01 != null) {
					long time01 = tempdate01.getTime();
					pstmt.setDate(9, new java.sql.Date(time01));
				} else {
					pstmt.setDate(9, null);
				}

				java.util.Date tempdate02 = bean.getExpireTime();

				if (tempdate02 != null) {
					long time02 = tempdate02.getTime();
					pstmt.setDate(10, new java.sql.Date(time02));
				} else {
					pstmt.setDate(10, null);
				}

				pstmt.setString(11, bean.getImageName());
				pstmt.setBytes(12, bean.getImageFile());
				pstmt.setLong(13, bean.getImageLength());
				pstmt.setString(14, bean.getRemark());

				pstmt.setInt(15, bean.getDonationId());
				pstmt.setInt(16, bean.getSchoolId());

				int count = pstmt.executeUpdate();
				if (count >= 1) {
					result = bean;
					System.out.println("update success");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int donationId, int schoolId) {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {

			pstmt.setInt(1, donationId);
			pstmt.setInt(2, schoolId);

			int count = pstmt.executeUpdate();
			if (count >= 1) {
				System.out.println("delete success");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public DonationBean findByPrimaryKey(int donationId, int schoolId) {
		DonationBean bean = null;
		ResultSet rs = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);) {

			pstmt.setInt(1, donationId);
			pstmt.setInt(2, schoolId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DonationBean();

				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit("originalDemandUnit");
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
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

	public List<DonationBean> getAll() {
		List<DonationBean> list = new ArrayList<DonationBean>();
		DonationBean bean = null;
		ResultSet rs = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(GET_ALL);) {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DonationBean();
				bean.setDonationId(rs.getInt("donationId"));
				bean.setSchoolId(rs.getInt("schoolId"));
				bean.setDonationStatus(rs.getString("donationStatus"));
				bean.setSupplyName(rs.getString("supplyName"));
				bean.setOriginalDemandNumber(rs.getInt("originalDemandNumber"));
				bean.setOriginalDemandUnit("originalDemandUnit");
				bean.setDemandNumber(rs.getInt("demandNumber"));
				bean.setSize(rs.getString("size"));
				bean.setDemandContent(rs.getString("demandContent"));
				bean.setSupplyStatus(rs.getString("supplyStatus"));
				bean.setDemandTime(rs.getDate("demandTime"));
				bean.setExpireTime(rs.getDate("expireTime"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImageFile(rs.getBytes("imageFile"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setRemark(rs.getString("remark"));
				list.add(bean);
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

		return list;
	}

	public static void main(String[] args) {
		DonationDAOjdbc daojdbc = new DonationDAOjdbc();
		/** INSERT OK **/
		// DonationBean bean1 = new DonationBean();
		// bean1.setSchoolId(21216);
		// bean1.setDonationStatus("");
		// bean1.setSupplyName("");
		// bean1.setOriginalDemandNumber(12);
		// bean1.setOriginalDemandUnit("");
		// bean1.setDemandNumber(12);
		// bean1.setSize("");
		// bean1.setDemandContent("");
		// bean1.setSupplyStatus("");
		// bean1.setDemandTime(new Date());
		// bean1.setExpireTime(new Date());
		// bean1.setImageName("");
		// bean1.setImageFile(null);
		// bean1.setImageLength(123);
		// bean1.setRemark("");
		// daojdbc.insert(bean1);

		/** UPDATE OK **/
		// DonationBean bean2 = new DonationBean();
		// bean2.setDonationId(2);
		// bean2.setSchoolId(21216);
		// bean2.setDonationStatus("");
		// bean2.setSupplyName("");
		// bean2.setOriginalDemandNumber(12);
		// bean2.setOriginalDemandUnit("");
		// bean2.setDemandNumber(12);
		// bean2.setSize("sssseee");
		// bean2.setDemandContent("");
		// bean2.setSupplyStatus("");
		// bean2.setDemandTime(new Date());
		// bean2.setExpireTime(new Date());
		// bean2.setImageName("");
		// bean2.setImageFile(null);
		// bean2.setImageLength(123);
		// bean2.setRemark("");
		// daojdbc.update(bean2);

		/** DELETE OK **/
		// DonationBean bean3 = new DonationBean();
		// bean3.setDonationId(1);
		// bean3.setSchoolId(21215);
		// boolean count =
		// daojdbc.delete(bean3.getDonationId(),bean3.getSchoolId());
		// System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY **/
		// DonationBean bean4 = new DonationBean();
		// bean4 = daojdbc.findByPrimaryKey(2, 21216);
		// System.out.println("" + bean4.getDonationId() + "\t" +
		// bean4.getSchoolId());

		/** GET_ALL OK **/
		List<DonationBean> list = daojdbc.getAll();
		System.out.println();
		for (DonationBean bean5 : list) {
			System.out.println("" + bean5.getDonationId() + "\t" + bean5.getSchoolId());
		}
	}

}

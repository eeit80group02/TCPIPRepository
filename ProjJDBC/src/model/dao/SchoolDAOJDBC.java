package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SchoolBean;

public class SchoolDAOJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		SchoolDAOJDBC dao = new SchoolDAOJDBC();
		List<SchoolBean> beans = dao.getAll();
		// System.out.println(beans);
		SchoolBean bean = dao.findByPrimaryKey(11503);
		System.out.println(bean);

		bean.setSchoolId(11500);
		System.out.println(dao.insert(bean));
		byte[] bytes = { 5, 4, 3, 2, 1 };
		long l = 1L;
		System.out.println(dao.update("資策會", "0123456789", "[03]桃園市", "台北市大安區資策會", "http://www.tcpip.com", null, bytes,
				l, null, null, null, null, bytes, null, 11500));
		System.out.println(dao.delete(11500));
	}

	private static final String SELECT_BY_ID = "select * from school where schoolId = ?";

	public SchoolBean findByPrimaryKey(int schoolId) {
		SchoolBean result = null;

		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, schoolId);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new SchoolBean();
				result.setSchoolId(rset.getInt("schoolId"));
				result.setName(rset.getString("name"));
				result.setPhone(rset.getString("phone"));
				result.setAddressDistrict(rset.getString("addressDistrict"));
				result.setAddressComplete(rset.getString("addressComplete"));
				result.setUrl(rset.getString("url"));
				result.setFrontCoverName(rset.getString("frontCoverName"));
				result.setFrontCover(rset.getBytes("frontCover"));
				result.setFrontCoverLength(rset.getLong("frontCoverLength"));
				result.setAboutMe(rset.getString("aboutMe"));
				result.setManagerEmail(rset.getString("managerEmail"));
				result.setProjectManager(rset.getString("projectManager"));
				result.setAccountContact(rset.getString("accountContact"));
				result.setPassword(rset.getBytes("password"));
				result.setAccountStatus(rset.getString("accountStatus"));
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

	private static final String SELECT_ALL = "select * from school";

	public List<SchoolBean> getAll() {
		List<SchoolBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<SchoolBean>();
			while (rset.next()) {
				SchoolBean bean = new SchoolBean();
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setName(rset.getString("name"));
				bean.setPhone(rset.getString("phone"));
				bean.setAddressDistrict(rset.getString("addressDistrict"));
				bean.setAddressComplete(rset.getString("addressComplete"));
				bean.setUrl(rset.getString("url"));
				bean.setFrontCoverName(rset.getString("frontCoverName"));
				bean.setFrontCover(rset.getBytes("frontCover"));
				bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
				bean.setAboutMe(rset.getString("aboutMe"));
				bean.setManagerEmail(rset.getString("managerEmail"));
				bean.setProjectManager(rset.getString("projectManager"));
				bean.setAccountContact(rset.getString("accountContact"));
				bean.setPassword(rset.getBytes("password"));
				bean.setAccountStatus(rset.getString("accountStatus"));

				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into school (schoolId, name, phone, addressDistrict, addressComplete, url, frontCoverName, frontCover, frontCoverLength, aboutMe, managerEmail, projectManager, accountContact, password, accountStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public SchoolBean insert(SchoolBean bean) {
		SchoolBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			stmt.setInt(1, bean.getSchoolId());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getPhone());
			stmt.setString(4, bean.getAddressDistrict());
			stmt.setString(5, bean.getAddressComplete());
			stmt.setString(6, bean.getUrl());
			stmt.setString(7, bean.getFrontCoverName());
			stmt.setBytes(8, bean.getFrontCover());
			stmt.setLong(9, bean.getFrontCoverLength());
			stmt.setString(10, bean.getAboutMe());
			stmt.setString(11, bean.getManagerEmail());
			stmt.setString(12, bean.getProjectManager());
			stmt.setString(13, bean.getAccountContact());
			stmt.setBytes(14, bean.getPassword());
			stmt.setString(15, bean.getAccountStatus());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(bean.getSchoolId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update school set name = ?, phone = ?, addressDistrict = ?, addressComplete = ?, url = ?, frontCoverName = ?, frontCover = ?, frontCoverLength = ?, aboutMe = ?, managerEmail = ?, projectManager = ?, accountContact = ?, password = ?, accountStatus = ? where schoolId = ?";

	public SchoolBean update(String name, String phone, String addressDistrict, String addressComplete, String url,
			String frontCoverName, byte[] frontCover, long frontCoverLength, String aboutMe, String managerEmail,
			String projectManager, String accountContact, byte[] password, String accountStatus, int schoolId) {
		SchoolBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, addressDistrict);
			stmt.setString(4, addressComplete);
			stmt.setString(5, url);
			stmt.setString(6, frontCoverName);
			stmt.setBytes(7, frontCover);
			stmt.setLong(8, frontCoverLength);
			stmt.setString(9, aboutMe);
			stmt.setString(10, managerEmail);
			stmt.setString(11, projectManager);
			stmt.setString(12, accountContact);
			stmt.setBytes(13, password);
			stmt.setString(14, accountStatus);
			stmt.setInt(15, schoolId);

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = new SchoolBean();
				result.setSchoolId(schoolId);
				result.setName(name);
				result.setPhone(phone);
				result.setAddressDistrict(addressDistrict);
				result.setAddressComplete(addressComplete);
				result.setUrl(url);
				result.setFrontCoverName(frontCoverName);
				result.setFrontCover(frontCover);
				result.setFrontCoverLength(frontCoverLength);
				result.setAboutMe(aboutMe);
				result.setManagerEmail(managerEmail);
				result.setProjectManager(projectManager);
				result.setAccountContact(accountContact);
				result.setPassword(password);
				result.setAccountStatus(accountStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from school where schoolId = ?";

	public boolean delete(int schoolId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, schoolId);
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

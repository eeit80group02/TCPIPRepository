package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.SchoolDemandBean;

public class SchoolDemandDAOJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		SchoolDemandDAOJDBC dao = new SchoolDemandDAOJDBC();
		List<SchoolDemandBean> beans = dao.getAll();
//		System.out.println(beans);
		SchoolDemandBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);

		bean.setSchoolDemandId(11);
		System.out.println(dao.insert(bean));
		System.out.println(dao.update(11503, 2000, "偏鄉教育計劃", "學校", "具有熱誠的志工，具備程式能力", "田園老師", "02-1234-5678",
				new java.util.Date(), "一千字需求內容", 11));
		System.out.println(dao.delete(11));
	}

	private static final String SELECT_BY_ID = "select * from schooldemand where schoolDemandId = ?";

	public SchoolDemandBean findByPrimaryKey(int schoolDemandId) {
		SchoolDemandBean result = null;

		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, schoolDemandId);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new SchoolDemandBean();
				result.setSchoolDemandId(rset.getInt("schoolDemandId"));
				result.setSchoolId(rset.getInt("schoolId"));
				result.setParticipant(rset.getInt("participant"));
				result.setActivityTopicPicture(rset.getString("activityTopicPicture"));
				result.setActivityLocation(rset.getString("activityLocation"));
				result.setActivitySuitable(rset.getString("activitySuitable"));
				result.setActivityHost(rset.getString("activityHost"));
				result.setActivityContact(rset.getString("activityContact"));
				result.setCreateDate(rset.getDate("createDate"));
				result.setContent(rset.getString("content"));

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

	private static final String SELECT_ALL = "select * from schooldemand";

	public List<SchoolDemandBean> getAll() {
		List<SchoolDemandBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<SchoolDemandBean>();
			while (rset.next()) {
				SchoolDemandBean bean = new SchoolDemandBean();
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setParticipant(rset.getInt("participant"));
				bean.setActivityTopicPicture(rset.getString("activityTopicPicture"));
				bean.setActivityLocation(rset.getString("activityLocation"));
				bean.setActivitySuitable(rset.getString("activitySuitable"));
				bean.setActivityHost(rset.getString("activityHost"));
				bean.setActivityContact(rset.getString("activityContact"));
				bean.setCreateDate(rset.getDate("createDate"));
				bean.setContent(rset.getString("content"));

				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into schooldemand (schoolDemandId, schoolId, participant, activityTopicPicture, activityLocation, activitySuitable, activityHost, activityContact, createDate, content) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SET_IDENTITY_ON = "SET IDENTITY_INSERT schooldemand ON;";
	private static final String SET_IDENTITY_OFF = "SET IDENTITY_INSERT schooldemand Off;";

	public SchoolDemandBean insert(SchoolDemandBean bean) {
		SchoolDemandBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SET_IDENTITY_ON + INSERT + SET_IDENTITY_OFF);) {

			stmt.setInt(1, bean.getSchoolDemandId());
			stmt.setInt(2, bean.getSchoolId());
			stmt.setInt(3, bean.getParticipant());
			stmt.setString(4, bean.getActivityTopicPicture());
			stmt.setString(5, bean.getActivityLocation());
			stmt.setString(6, bean.getActivitySuitable());
			stmt.setString(7, bean.getActivityHost());
			stmt.setString(8, bean.getActivityContact());
			java.util.Date date = bean.getCreateDate();
			if (date != null) {
				long temp = date.getTime();
				stmt.setDate(9, new java.sql.Date(temp));
			} else {
				stmt.setDate(9, null);
			}
			stmt.setString(10, bean.getContent());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(bean.getSchoolDemandId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update schooldemand set schoolId = ?, participant = ?, activityTopicPicture = ?, activityLocation = ?, activitySuitable = ?, activityHost = ?, activityContact = ?, createDate = ?, content = ? where schoolDemandId = ?";

	public SchoolDemandBean update(int schoolId, int participant, String activityTopicPicture, String activityLocation,
			String activitySuitable, String activityHost, String activityContact, java.util.Date createDate,
			String content, int schoolDemandId) {
		SchoolDemandBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setInt(1, schoolId);
			stmt.setInt(2, participant);
			stmt.setString(3, activityTopicPicture);
			stmt.setString(4, activityLocation);
			stmt.setString(5, activitySuitable);
			stmt.setString(6, activityHost);
			stmt.setString(7, activityContact);
			if (createDate != null) {
				long temp = createDate.getTime();
				stmt.setDate(8, new java.sql.Date(temp));
			} else {
				stmt.setDate(8, null);
			}
			stmt.setString(9, content);
			stmt.setInt(10, schoolDemandId);

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = new SchoolDemandBean();
				result.setSchoolId(schoolId);
				result.setParticipant(participant);
				result.setActivityTopicPicture(activityTopicPicture);
				result.setActivityLocation(activityLocation);
				result.setActivitySuitable(activitySuitable);
				result.setActivityHost(activityHost);
				result.setActivityContact(activityContact);
				result.setCreateDate(createDate);
				result.setContent(content);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from schooldemand where schoolDemandId = ?";

	public boolean delete(int schoolDemandId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, schoolDemandId);
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

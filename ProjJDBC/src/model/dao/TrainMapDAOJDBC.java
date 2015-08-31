package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrainMapBean;


public class TrainMapDAOJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		TrainMapDAOJDBC dao = new TrainMapDAOJDBC();
		List<TrainMapBean> beans = dao.getAll();
		System.out.println(beans);
		TrainMapBean bean = dao.findByPrimaryKey("臺北站");
		System.out.println(bean);

		bean.setName("海科館站");
		System.out.println(dao.insert(bean));
		System.out.println(dao.update("平溪站(平溪線)", "海科館站"));
		System.out.println(dao.delete("平溪站(平溪線)"));
	}

	private static final String SELECT_BY_ID = "select * from trainmap where name = ?";

	public TrainMapBean findByPrimaryKey(String name) {
		TrainMapBean result = null;

		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setString(1, name);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new TrainMapBean();
				result.setName(rset.getString("name"));
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

	private static final String SELECT_ALL = "select * from trainmap";

	public List<TrainMapBean> getAll() {
		List<TrainMapBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<TrainMapBean>();
			while (rset.next()) {
				TrainMapBean bean = new TrainMapBean();
				bean.setName(rset.getString("name"));

				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into trainmap (name) values (?)";

	public TrainMapBean insert(TrainMapBean bean) {
		TrainMapBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {

			stmt.setString(1, bean.getName());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(bean.getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update trainmap set name = ? where name = ?";

	public TrainMapBean update(String newName, String name) {
		TrainMapBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, newName);

			stmt.setString(2, name);

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = new TrainMapBean();
				result.setName(newName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from trainmap where name = ?";

	public boolean delete(String name) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setString(1, name);
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

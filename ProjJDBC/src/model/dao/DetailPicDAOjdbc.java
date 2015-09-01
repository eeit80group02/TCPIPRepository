package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetailPicBean;

public class DetailPicDAOjdbc {

	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	private static final String SELECT_BY_PRYMARY_KEY = "select * from DetailPic where fullProjId=?";
	private static final String GET_ALL = "select * from DetailPic";
	private static final String INSERT = "insert into DetailPic (fullProjId, imageName, image, imageLength, imageDescribe) values (?, ?, ?, ?, ?)";
	private static final String UPDATE = "update DetailPic set imageName=?, image=?, imageLength=? ,imageDescribe=? where fullProjId=?";
	private static final String DELETE = "delete from DetailPic where fullProjId=?";

	public DetailPicBean findByPrimaryKey(int fullProjId) {
		DetailPicBean bean = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);) {

			pstmt.setInt(1, fullProjId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new DetailPicBean();

				bean.setFullProjId(rs.getInt("fullProjId"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImage(rs.getBytes("image"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setImageDescribe(rs.getString("imageDescribe"));
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

	public List<DetailPicBean> getAll() {
		List<DetailPicBean> resultlist = new ArrayList<DetailPicBean>();
		DetailPicBean bean = null;
		ResultSet rs = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(GET_ALL);) {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DetailPicBean();

				bean.setFullProjId(rs.getInt("fullProjId"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImage(rs.getBytes("image"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setImageDescribe(rs.getString("imageDescribe"));
				resultlist.add(bean);
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
		return resultlist;
	}

	public DetailPicBean insert(DetailPicBean bean) {
		DetailPicBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {

			if (bean != null) {
				pstmt.setInt(1, bean.getFullProjId());
				pstmt.setString(2, bean.getImageName());
				pstmt.setBytes(3, bean.getImage());
				pstmt.setLong(4, bean.getImageLength());
				pstmt.setString(5, bean.getImageDescribe());

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

	public DetailPicBean update(DetailPicBean bean) {
		DetailPicBean result = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {

			pstmt.setString(1, bean.getImageName());
			pstmt.setBytes(2, bean.getImage());
			pstmt.setLong(3, bean.getImageLength());
			pstmt.setString(4, bean.getImageDescribe());
			pstmt.setInt(5, bean.getFullProjId());

			int count = pstmt.executeUpdate();
			if (count >= 1) {
				System.out.println("update success");
				result = bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean delete(int fullProjId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {

			pstmt.setInt(1, fullProjId);

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

	public static void main(String[] args) {
		DetailPicDAOjdbc daojdbc = new DetailPicDAOjdbc();
		/** INSERT OK **/
//		 DetailPicBean bean1 = new DetailPicBean();
//		 bean1.setFullProjId(43);
//		 bean1.setImageName("xxx.jpg");
//		 bean1.setImage(null);
//		 bean1.setImageLength(19691155);
//		 bean1.setImageDescribe("這是封面圖");
//		 daojdbc.insert(bean1);

		/** UPDATE OK **/
//		 DetailPicBean bean2 = new DetailPicBean();
//		 bean2.setFullProjId(43);
//		 bean2.setImageName("iii.jpg");
//		 bean2.setImage(null);
//		 bean2.setImageLength(19691155);
//		 bean2.setImageDescribe("這是封面圖");
//		 daojdbc.update(bean2);

		/** DELETE OK **/
//		 DetailPicBean bean3 = new DetailPicBean();
//		 bean3.setFullProjId(43);
//		 boolean count = daojdbc.delete(bean3.getFullProjId());
//		 System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY **/
//		 DetailPicBean bean4 = new DetailPicBean();
//		 bean4 = daojdbc.findByPrimaryKey(43);
//		 System.out.println("" + bean4.getFullProjId() + "\t" +
//		 bean4.getImageDescribe());

		/** GET_ALL OK **/
		List<DetailPicBean> list = daojdbc.getAll();
		System.out.println();
		for (DetailPicBean bean5 : list) {
			System.out.println("" + bean5.getFullProjId() + "\t" + bean5.getImageDescribe());
		}
	}
}

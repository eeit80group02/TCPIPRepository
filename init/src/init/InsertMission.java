package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import global.GlobalService;

public class InsertMission {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Mission(missionSetId,name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionId) VALUES (?,?,?,?,?,?,?,?)";

	public static void start() {

		//課程組 
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "教材準備");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "課程教師安排");
			pstmt.setInt(3, 2);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-28").getTime()));
			pstmt.setString(5, "緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "習題準備");
			pstmt.setInt(3, 3);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-30").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 3);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "上課教室安排");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 4);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "教材擬稿");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-23").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "已完成");
			pstmt.setInt(8, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "印製裝訂教材");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "教材成品試閱");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-23").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 3);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "教師聘請");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-19").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 2);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "聘師預算");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-20").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 2);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "題庫蒐集");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-10").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 3);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "習題校正");
			pstmt.setInt(3, 1);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-05-11").getTime()));
			pstmt.setString(5, "非常緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "進行中");
			pstmt.setInt(8, 3);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//器材組
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setString(2, "麥克風準備");
			pstmt.setInt(3, 4);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-10").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "已完成");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setString(2, "訂餐排程");
			pstmt.setInt(3, 5);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-01").getTime()));
			pstmt.setString(5, "緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "已完成");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setString(2, "資源回收人員");
			pstmt.setInt(3, 4);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-04").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 3);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setString(2, "上課教材搬運");
			pstmt.setInt(3, 5);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-07").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 4);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//美宣組
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 3);
			pstmt.setString(2, "教室布置");
			pstmt.setInt(3, 6);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-01").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 3);
			pstmt.setString(2, "開幕會場布置");
			pstmt.setInt(3, 7);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-02").getTime()));
			pstmt.setString(5, "緊急");
			pstmt.setInt(6, 2);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 3);
			pstmt.setString(2, "道具準備");
			pstmt.setInt(3, 6);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-03").getTime()));
			pstmt.setString(5, "緊急");
			pstmt.setInt(6, 3);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 3);
			pstmt.setString(2, "小禮物準備");
			pstmt.setInt(3, 7);
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-06-05").getTime()));
			pstmt.setString(5, "普通");
			pstmt.setInt(6, 4);
			pstmt.setString(7, "進行中");
			pstmt.setNull(8, java.sql.Types.INTEGER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("任務資料新增完成");
	}

	public static void main(String[] args) {
		InsertMissionSet.start();
	}
}

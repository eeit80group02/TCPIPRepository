package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import global.GlobalService;

public class InsertParticipator {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Participator(fullProjId,memberId,activityStartTime,activityEndTime,participateStatus,checkTime,isParticipate) VALUES (?,?,?,?,?,?,?)";

	public static void start() {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 1);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 2);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 3);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 4);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 5);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 6);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 7);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-21").getTime()));
			pstmt.setTimestamp(4, new Timestamp(GlobalService.convertStringToDate("2015-07-21").getTime()));
			pstmt.setString(5, "已審核通過");
			pstmt.setTimestamp(6, new Timestamp(GlobalService.convertStringToDate("2015-05-22").getTime()));
			pstmt.setString(7, "是");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("參加人資料新增完成");
	}

	public static void main(String[] args) {
		InsertParticipator.start();
	}
}

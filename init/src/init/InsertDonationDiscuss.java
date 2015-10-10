package init;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class InsertDonationDiscuss {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	private static final String INSERT = "INSERT INTO DonationDiscuss (donationId, memberId, memberMessage, memberMessageTime, schoolId, schoolMessage, schoolMessageTime) VALUES (?, ?, ?, ?, ?, ?, ?)";

	public static void start() {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			// try start
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			// 第一筆資料
			pstmt.setInt(1, 1); // 捐獻編號 FK
			pstmt.setInt(2, 68); // 會員編號
			pstmt.setString(3, "請問包包的大小有限定嗎？"); // 會員留言
			pstmt.setTimestamp(4, new java.sql.Timestamp(sdf.parse("2015-08-12 06:28").getTime()));	// 會員留言時間
			pstmt.setInt(5, 14659); // 學校編號
			pstmt.setString(6, "大小不限，歡迎捐獻"); // 學校留言
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-08-13 12:20").getTime())); // 學校留言時間
			pstmt.executeUpdate();
			
			// 第二筆資料
			pstmt.setInt(1, 1); // 捐獻編號 FK
			pstmt.setInt(2, 68); // 會員編號
			pstmt.setString(3, "請問有需要側背包嗎？"); // 會員留言
			pstmt.setTimestamp(4, new java.sql.Timestamp(sdf.parse("2015-08-15 12:28").getTime()));	// 會員留言時間
			pstmt.setInt(5, 14659); // 學校編號
			pstmt.setString(6, "目前還是以後背包為主唷，當然有後背包也可以"); // 學校留言
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-08-15 13:20").getTime())); // 學校留言時間
			pstmt.executeUpdate();
			
			// 第三筆資料
			pstmt.setInt(1, 23); // 捐獻編號 FK
			pstmt.setInt(2, 68); // 會員編號
			pstmt.setString(3, "請問有需要用買的嗎，我這裡有一批便宜的空白紙張"); // 會員留言
			pstmt.setTimestamp(4, new java.sql.Timestamp(sdf.parse("2015-10-12 08:33").getTime()));	// 會員留言時間
			pstmt.setInt(5, 94522); // 學校編號
			pstmt.setString(6, "您好，因為經費有限目前暫不考慮用買的"); // 學校留言
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-10-15 12:27").getTime())); // 學校留言時間
			pstmt.executeUpdate();
			
			// 第四筆資料
			pstmt.setInt(1, 23); // 捐獻編號 FK
			pstmt.setInt(2, 81); // 會員編號
			pstmt.setString(3, "請問哪個時間方便收件呢？"); // 會員留言
			pstmt.setTimestamp(4, new java.sql.Timestamp(sdf.parse("2015-11-26 18:28").getTime()));	// 會員留言時間
			pstmt.setInt(5, 94522); // 學校編號
			pstmt.setString(6, "您好，只要是上班時間周一至周五都歡迎寄件到學校，謝謝"); // 學校留言
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-11-30 10:12").getTime())); // 學校留言時間
			pstmt.executeUpdate();

			// try end
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DonationDiscuss新增成功");
	}
	
	public static void main(String[] args) {
		InsertDonationDiscuss.start();
	}
}

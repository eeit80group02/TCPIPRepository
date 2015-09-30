package init;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import global.GlobalService;

public class InsertDonationOrder {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO DonationOeder(memberId,name,address,phone,cellPhone,email,pickTime,donationOederDate,dealId) VALUES (?,?,?,?,?,?,?,?,?)";

	public static void start() {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			// try start
			
			// 第一筆資料
			pstmt.setInt(1, 6);// memberId
			pstmt.setString(2, "簡小文");// name
			pstmt.setString(3, "臺北市大安區復興南路一段");// address
			pstmt.setString(4, "0222815416");// phone
			pstmt.setString(5, "0916075266");// cellPhone
			pstmt.setString(6, "dora@gmail.com");// email			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-09-30 10:06").getTime()));
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-09-30 10:06").getTime()));
			
			pstmt.setString(7, "否");// pickTime
			pstmt.setString(8, "否");// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800275641");// dealId
			pstmt.executeUpdate();


			// 第二筆資料
			pstmt.setInt(1, 6);// memberId
			pstmt.setString(2, "簡小文");// name
			pstmt.setString(3, "臺北市大安區復興南路一段");// address
			pstmt.setString(4, "0222815416");// phone
			pstmt.setString(5, "0916075266");// cellPhone
			pstmt.setString(6, "dora@gmail.com");// email			
			
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-09-30 10:06").getTime()));
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-09-30 10:06").getTime()));
			
			pstmt.setString(7, "否");// pickTime
			pstmt.setString(8, "否");// donationOederDate
			
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800275641");// dealId
			pstmt.executeUpdate();

			// 第三筆資料
		

			// 第四筆資料
			

			// try end
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("DonationOrder新增成功");
	}

	public static void main(String[] args) {
		InsertDonationOrder.start();
	}
}

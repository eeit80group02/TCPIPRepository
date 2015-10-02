package init;

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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			// try start

			// 假資料 貨運單號？
			pstmt.setInt(1, 6);// memberId
			pstmt.setString(2, "簡建文");// name
			pstmt.setString(3, "台北市大安區信義路四段32號");// address
			pstmt.setString(4, "022540395");// phone
			pstmt.setString(5, "0987820258");// cellPhone
			pstmt.setString(6, "eeit8031@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-07-07 17:18").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-07-07 17:18").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800122112");// dealId
			pstmt.executeUpdate();

			// 假資料 貨運單號？
			pstmt.setInt(1, 6);// memberId
			pstmt.setString(2, "簡建文");// name
			pstmt.setString(3, "台北市大安區信義路四段32號");// address
			pstmt.setString(4, "022540395");// phone
			pstmt.setString(5, "0987820258");// cellPhone
			pstmt.setString(6, "eeit8031@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-08-17 09:18").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-08-17 09:18").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800859223");// dealId
			pstmt.executeUpdate();

			// 假資料 貨運單號？
			pstmt.setInt(1, 6);// memberId
			pstmt.setString(2, "簡建文");// name
			pstmt.setString(3, "台北市大安區信義路四段32號");// address
			pstmt.setString(4, "022540395");// phone
			pstmt.setString(5, "0987820258");// cellPhone
			pstmt.setString(6, "eeit8031@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-09-31 10:54").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-09-31 10:54").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800485512");// dealId
			pstmt.executeUpdate();

			// 第一筆資料 貨運單號1
			pstmt.setInt(1, 4);// memberId
			pstmt.setString(2, "林政揚");// name
			pstmt.setString(3, "台北市大安區大安路一段218號");// address
			pstmt.setString(4, "06684734");// phone
			pstmt.setString(5, "0954708579");// cellPhone
			pstmt.setString(6, "eeit8025@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-08-28 13:32").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-08-28 13:32").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800279527");// dealId
			pstmt.executeUpdate();

			// 第二筆資料 貨運單號2
			pstmt.setInt(1, 5);// memberId
			pstmt.setString(2, "許耕瑋");// name
			pstmt.setString(3, "台北市大安區仁愛路三段74號");// address
			pstmt.setString(4, "04725210");// phone
			pstmt.setString(5, "0923821737");// cellPhone
			pstmt.setString(6, "eeit8028@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-09-10 11:21").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-09-10 11:21").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800779588");// dealId
			pstmt.executeUpdate();

			// 第三筆資料 貨運單號3
			pstmt.setInt(1, 1);// memberId
			pstmt.setString(2, "彭聖翔");// name
			pstmt.setString(3, "台北市大安區東豐街9號");// address
			pstmt.setString(4, "06991330");// phone
			pstmt.setString(5, "0961267405");// cellPhone
			pstmt.setString(6, "eeit8004@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-09-22 12:28").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-09-22 12:28").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800268987");// dealId
			pstmt.executeUpdate();

			// 第四筆資料 貨運單號4
			pstmt.setInt(1, 3);// memberId
			pstmt.setString(2, "郭文豪");// name
			pstmt.setString(3, "台北市大安區東豐街43號");// address
			pstmt.setString(4, "05582050");// phone
			pstmt.setString(5, "0935803443");// cellPhone
			pstmt.setString(6, "eeit8014@gmail.com");// email
			pstmt.setTimestamp(7, new java.sql.Timestamp(sdf.parse("2015-10-01 10:17").getTime()));// pickTime
			pstmt.setTimestamp(8, new java.sql.Timestamp(sdf.parse("2015-10-01 10:17").getTime()));// donationOederDate
			pstmt.setString(9, "網路預約成功！ 您的預約單號：105800399889");// dealId
			pstmt.executeUpdate();

			// try end
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DonationOrder新增成功");
	}

	public static void main(String[] args) {
		InsertDonationOrder.start();
	}
}

package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import global.GlobalService;

public class InsertDonationOrderDetail {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO DonationOederDetail(donationOederId,donationId,supplyName,donationAmount) VALUES (?,?,?,?)";

	public static void start() {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			// try start

			/** 貨運單號1 start **/
			// 第一筆資料
			pstmt.setInt(1, 1);// donationOederId
			pstmt.setInt(2, 20);// donationId
			pstmt.setString(3, "電視機");// supplyName
			pstmt.setInt(4, 1);// donationAmount
			pstmt.executeUpdate();
			// 第二筆資料
			pstmt.setInt(1, 1);// donationOederId
			pstmt.setInt(2, 21);// donationId 電視
			pstmt.setString(3, "椅子");// supplyName
			pstmt.setInt(4, 20);// donationAmount
			pstmt.executeUpdate();
			/** 貨運單號1 end **/

			/** 貨運單號2 start **/
			// 第三筆資料
			pstmt.setInt(1, 2);// donationOederId
			pstmt.setInt(2, 21);// donationId
			pstmt.setString(3, "椅子");// supplyName
			pstmt.setInt(4, 60);// donationAmount
			pstmt.executeUpdate();
			/** 貨運單號2 end **/

			
			/** 貨運單號3 start **/
			// 第四筆資料
			pstmt.setInt(1, 3);// donationOederId
			pstmt.setInt(2, 22);// donationId
			pstmt.setString(3, "時鐘");// supplyName
			pstmt.setInt(4, 4);// donationAmount
			pstmt.executeUpdate();
			/** 貨運單號3 end **/
			
			/** 貨運單號4 start **/
			// 第五筆資料
			pstmt.setInt(1, 4);// donationOederId
			pstmt.setInt(2, 25);// donationId
			pstmt.setString(3, "頸繩(識別證帶)");// supplyName
			pstmt.setInt(4, 40);// donationAmount
			pstmt.executeUpdate();
			/** 貨運單號4 end **/
			
			// try end
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DonationOrderDetail新增成功");
	}

	public static void main(String[] args) {
		InsertDonationOrderDetail.start();
	}
}

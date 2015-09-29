package init;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 本程式作用:新增數筆"Donation"之資料於資料庫
 * 
 */
import global.GlobalService;

public class InsertDonation {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Donation (schoolId,donationStatus,supplyName,originalDemandNumber,originalDemandUnit,demandNumber,size,demandContent,supplyStatus,demandTime,expireTime,imageName,imageFile,imageLength,remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start() {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			// 第一筆資料
			// ======================================================================
			pstmt.setInt(1, 11601);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "運貨用板車");// supplyName
			pstmt.setInt(4, 40);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 40);// demandNumber
			pstmt.setString(7, "長度不超過150公分");// size
			pstmt.setString(8, "搬運大型物品時需要，例如：講桌");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			pstmt.setString(10, "2015/09/09");// demandTime
			pstmt.setString(11, "2015/12/10");// expireTime
			pstmt.setString(15, "");// remark

			File file = new File("image/donation/Goods01.jpg");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Donation新增完成");
	}

	public static void main(String[] args) {
		InsertDonation.start();
	}

}

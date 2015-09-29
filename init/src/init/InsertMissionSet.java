package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import global.GlobalService;

public class InsertMissionSet {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO MissionSet(missionBoardId,name,missionSetOrder) VALUES (?,?,?)";

	public static void start() {

		//【將軍國小暑期服務】美人魚現身將軍嶼
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 13);
			pstmt.setString(2, "第一天");
			pstmt.setInt(3, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 13);
			pstmt.setString(2, "第二天");
			pstmt.setInt(3, 2);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 13);
			pstmt.setString(2, "第三天");
			pstmt.setInt(3, 3);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,13);   						
				pstmt.setString(2,"第四天");				
				pstmt.setInt(3,4);					
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 13);
			pstmt.setString(2, "第五天");
			pstmt.setInt(3, 5);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 13);
			pstmt.setString(2, "第六天");
			pstmt.setInt(3, 6);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//偏鄉科學創意教學深耕計畫
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 12);
			pstmt.setString(2, "人事費");
			pstmt.setInt(3, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 12);
			pstmt.setString(2, "活動費");
			pstmt.setInt(3, 2);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 12);
			pstmt.setString(2, "教材費");
			pstmt.setInt(3, 3);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 12);
			pstmt.setString(2, "運費");
			pstmt.setInt(3, 4);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("任務集資料新增完成");
	}

	public static void main(String[] args) {
		InsertMissionSet.start();
	}
}

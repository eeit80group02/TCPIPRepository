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

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "課程組");
			pstmt.setInt(3, 1);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "器材組");
			pstmt.setInt(3, 2);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "美宣組");
			pstmt.setInt(3, 3);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,1);   						
				pstmt.setString(2,"活動組");				
				pstmt.setInt(3,4);					
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		System.out.println("任務集資料新增完成");
	}

	public static void main(String[] args) {
		InsertMissionSet.start();
	}
}

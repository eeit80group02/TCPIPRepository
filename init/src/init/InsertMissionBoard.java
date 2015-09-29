package init;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMissionBoard
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO MissionBoard(fullProjId,name,missionSetNum) VALUES (?,?,?)";

	public static void start()
	{
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,12);   						
				pstmt.setString(2,"偏鄉科學創意教學深耕計畫");				
				pstmt.setInt(3,4);					
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,13);   						
				pstmt.setString(2,"【將軍國小暑期服務】美人魚現身將軍嶼");				
				pstmt.setInt(3,4);					
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		System.out.println("任務板資料新增完成");
}
	
	public static void main(String[] args)
	{
		InsertMissionBoard.start();
	}
}

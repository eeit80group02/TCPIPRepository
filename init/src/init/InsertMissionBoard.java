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
			// 任務板 一
				pstmt.setInt(1,1);   						
				pstmt.setString(2,"亞成鳥青少年野地教育計畫");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
			// 任務板二
				pstmt.setInt(1,2);   						
				pstmt.setString(2,"友善生活實踐計畫");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
			
			// 任務板三
				pstmt.setInt(1,4);   						
				pstmt.setString(2,"【將軍國小暑期服務】美人魚現身將軍嶼");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
			
				// 任務板四
				pstmt.setInt(1,3);   						
				pstmt.setString(2,"流浪毛小孩的【鍾】心期盼");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
				// 任務板五
				pstmt.setInt(1,5);   						
				pstmt.setString(2,"讓教育沒有距離");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
				// 任務板六
				pstmt.setInt(1,8);   						
				pstmt.setString(2,"徐超斌方舟教室夢想計畫");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
				// 任務板七
				pstmt.setInt(1,9);   						
				pstmt.setString(2,"偏鄉科學創意教學深耕計畫	");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
				// 任務板八
				pstmt.setInt(1,6);   						
				pstmt.setString(2,"來自小漁村的台灣代表隊-國際參賽募資計劃");				
				pstmt.setInt(3,0);					
				
				pstmt.executeUpdate();
				
				// 任務板九
				pstmt.setInt(1,7);   						
				pstmt.setString(2,"與一群孩子的午後約定");				
				pstmt.setInt(3,0);					
				
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

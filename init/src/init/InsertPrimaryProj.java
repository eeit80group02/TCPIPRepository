package init;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class InsertPrimaryProj
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO PrimaryProj (memberId, title, frontCoverName, frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static void start()
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,7);				// memberId 發起者
			pstmt.setString(2,"造神計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			File file = new File("image/primaryProj/primaryProj01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());			// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"幫助偏遠學校使用辦公室軟體應用");		// projAbstract 計畫摘要
				pstmt.setString(7,"Word...Office軟體應用");		// content 計畫內容
				pstmt.setString(8,"台中");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015/08/08").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015/08/15").getTime())); // activityEndTime
				
				pstmt.setInt(11,20);  		// demandNum 志工人數
				pstmt.setInt(12,200000);   	// budget
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			
			// 第二筆資料  ======================================================================
			pstmt.setInt(1,4);				// memberId 發起者
			pstmt.setString(2,"關懷偏鄉熱血團");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"一群有理想、抱負的資策會畢業學員，具有充分的資訊技術及教學能力，希望在資訊能力上能帶領偏鄉兒童拉近資訊時代必備的能力。"); // projAbstract 計畫摘要
				pstmt.setString(7,"我們安排基礎程式語言、scratch的教學...");		// content 計畫內容
				pstmt.setString(8,"嘉義市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015/7/1").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015/7/15").getTime())); // activityEndTime
				
				pstmt.setInt(11,20);  		// demandNum 志工人數
				pstmt.setInt(12,90000);   	// budget
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("初步計畫資料 新增完成");
	}
	
	public static void main(String[] args)
	{
		InsertPrimaryProj.start();
	}
}

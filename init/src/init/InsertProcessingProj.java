package init;
/*
 * 功能: 新增數筆初步計畫洽談中學校的資料
 * 
 */

import global.GlobalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;

public class InsertProcessingProj {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO ProcessingProj (primaryProjId,schoolId,checkTime,checkStatus) VALUES(?,?,?,?)";

	public static void start() {
		BufferedReader br = null;
		try {
			File fr = new File("schoolData\\ProcessingProj.txt");
//			new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));)
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fr),"UTF-8"));
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);
			while (br.ready()) {
				String str = br.readLine();
				String[] strArray = str.split("\\s+");
				
				pstmt.setInt(1,Integer.parseInt(strArray[0]));
				pstmt.setInt(2,Integer.parseInt(strArray[1]));
				if(strArray[2].equals("null")){
					pstmt.setNull(3,Types.TIMESTAMP);
				} else {
					//時間-小時
					int randomHour = (int) (Math.random()*24);
					//時間-分秒
					int randomMinute = (int) (1+Math.random()*59);
					int randomSecond = (int) (1+Math.random()*59);
					String formatStr = "%02d";
					String theHour = String.format(formatStr, randomHour);
					String theMinute = String.format(formatStr, randomMinute);
					String theSecond = String.format(formatStr, randomSecond);
					String temp = strArray[2]+" "+ theHour + ":" + theMinute + ":" + theSecond;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					pstmt.setTimestamp(3,new java.sql.Timestamp(sdf.parse(temp).getTime()));	// registerTime
				}
				pstmt.setString(4,strArray[3]);
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("初步計畫洽談中學校的資料新增成功");
	}

	public static void main(String[] args) {
		start();
	}

}

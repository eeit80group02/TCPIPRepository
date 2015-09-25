package init;
/* 
 * 功能: 新增一百筆會員資料
 * 圖片為預設圖片
 * 帳號為:信箱帳號
 * 密碼為: passw0rd
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertMember {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Member(lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,RecommendCount,account,password,accountStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start() {
		BufferedReader br = null;
		try {
			File fr = new File("schoolData\\member.txt");
//			new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));)
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fr),"UTF-8"));
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);
			int count = 1;
			while (br.ready()) {
				String str = br.readLine();
				String[] strArray = str.split("\\s+");
				
				pstmt.setString(1,strArray[0]);				// lastName
				pstmt.setString(2,strArray[1]);   			// firstName
				pstmt.setString(3,strArray[2]);				// idNumber
				pstmt.setString(4,strArray[3]);				// phone
				pstmt.setString(5,strArray[4]);				// cellPhone
				pstmt.setString(6,strArray[5]);				// birthday
				pstmt.setString(7,strArray[6]);				// address
				pstmt.setString(8,strArray[7]);				// gender
				pstmt.setString(9,strArray[8]);				// email
				
				File file = new File("image\\member\\default.jpg");
				FileInputStream fis = new FileInputStream(file);
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				//時間-小時
				int randomHour = (int) (Math.random()*24);
				//時間-分秒
				int randomMinute = (int) (1+Math.random()*59);
				int randomSecond = (int) (1+Math.random()*59);
				String formatStr = "%02d";
				String theHour = String.format(formatStr, randomHour);
				String theMinute = String.format(formatStr, randomMinute);
				String theSecond = String.format(formatStr, randomSecond);
				String temp = strArray[9]+" "+ theHour + ":" + theMinute + ":" + theSecond;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse(temp).getTime()));	// registerTime
				pstmt.setInt(14,Integer.parseInt(strArray[10]));								// RecommendCount
				pstmt.setString(15,strArray[11]);					// account
				pstmt.setBytes(16,strArray[12].getBytes());		// password
				pstmt.setString(17,strArray[13]); 						// accountStatus
				
				pstmt.addBatch();
				
				if(count++ == 500)
				{
					pstmt.executeBatch();
					count = 1;
				}
				
			}
			pstmt.executeBatch();
			
		
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
		System.out.println("會員資料新增成功");
	}

	public static void main(String[] args) {
		Date start = new Date(System.currentTimeMillis());
		start();
		Date end = new Date(System.currentTimeMillis());
		System.out.println(end.getTime()-start.getTime());
	}

}

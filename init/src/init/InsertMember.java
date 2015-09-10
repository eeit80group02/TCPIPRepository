package init;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMember
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO Member(lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,RecommendCount,account,password,accountStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start()
	{
		// 第一筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"彭");							// lastName
			pstmt.setString(2,"聖翔");   						// firstName
			pstmt.setString(3,"G121900921");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1980-01-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8004@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8004");					// account
				pstmt.setBytes(16,"eeit8004".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第二筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"謝");							// lastName
			pstmt.setString(2,"濟謙");   						// firstName
			pstmt.setString(3,"G121900922");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1981-02-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8013@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8013");					// account
				pstmt.setBytes(16,"eeit8013".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
	
		// 第三筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"郭");							// lastName
			pstmt.setString(2,"文豪");   						// firstName
			pstmt.setString(3,"G121900923");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1982-03-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8014@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8014");					// account
				pstmt.setBytes(16,"eeit8014".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第四筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"林");							// lastName
			pstmt.setString(2,"政揚");   						// firstName
			pstmt.setString(3,"G121900924");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1983-04-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8025@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8025");					// account
				pstmt.setBytes(16,"eeit8025".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第五筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"許");							// lastName
			pstmt.setString(2,"耕瑋");   						// firstName
			pstmt.setString(3,"G121900925");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1984-05-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8028@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member05.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8028");					// account
				pstmt.setBytes(16,"eeit8028".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第六筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"簡");							// lastName
			pstmt.setString(2,"建文");   						// firstName
			pstmt.setString(3,"G121900926");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1985-06-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8031@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8031");					// account
				pstmt.setBytes(16,"eeit8031".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第七筆會員資料
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"張");							// lastName
			pstmt.setString(2,"健毅");   						// firstName
			pstmt.setString(3,"G121900927");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1986-07-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8038@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member07.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8038");					// account
				pstmt.setBytes(16,"eeit8038".getBytes());		// password
				pstmt.setString(17,"啟用"); 						// accountStatus
				
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
		
		// 第八筆會員資料  // 待認證
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"張");							// lastName
			pstmt.setString(2,"健毅");   						// firstName
			pstmt.setString(3,"G121900928");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1986-07-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8039@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8039");					// account
				pstmt.setBytes(16,"eeit8039".getBytes());		// password
				pstmt.setString(17,"待認證");						// accountStatus
				
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
		
		// 第八筆會員資料  // 停用
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,"張");							// lastName
			pstmt.setString(2,"健毅");   						// firstName
			pstmt.setString(3,"G121900929");				// idNumber
			pstmt.setString(4,"66316666");					// phone
			pstmt.setString(5,"0988658250");				// cellPhone
			pstmt.setString(6,"1986-07-01");				// birthday
			pstmt.setString(7,"台北市大安區復興南路一段390號2樓");	// address
			pstmt.setString(8,"男");							// gender
			pstmt.setString(9,"eeit8040@org.com");			// email
			
			// 大頭貼
			File file = new File("image/member/member02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(10,file.getName());				// pictureName
				pstmt.setBinaryStream(11,fis,file.length());	// picture
				pstmt.setLong(12,file.length());				// pictureLength
				
				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));	// registerTime
				pstmt.setInt(14,0);								// RecommendCount
				pstmt.setString(15,"eeit8040");					// account
				pstmt.setBytes(16,"eeit8040".getBytes());		// password
				pstmt.setString(17,"停用");						// accountStatus
				
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
		
		System.out.println("會員資料新增完成");
}
	
	public static void main(String[] args)
	{
		InsertMember.start();
	}
}

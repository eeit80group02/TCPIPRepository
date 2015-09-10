package init;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class InsertProcessingProj
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO ProcessingProj (primaryProjId,schoolId,checkTime,checkStatus) VALUES(?,?,?,?)";
	
	public static void start()
	{
		// 第一筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,1);
			pstmt.setInt(2,11601);
			pstmt.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(4,"已通過");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// 第二筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,1);
			pstmt.setInt(2,11602);
			pstmt.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(4,"未通過");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// 第三筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,1);
			pstmt.setInt(2,14501);
			pstmt.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(4,"未通過");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// 第四筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,2);
			pstmt.setInt(2,11601);
			pstmt.setNull(3,Types.TIMESTAMP);
			pstmt.setString(4,"待審核");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// 第五筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,2);
			pstmt.setInt(2,14506);
			pstmt.setNull(3,Types.TIMESTAMP);
			pstmt.setString(4,"待審核");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// 第六筆
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,2);
			pstmt.setInt(2,14509);
			pstmt.setNull(3,Types.TIMESTAMP);
			pstmt.setString(4,"待審核");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("發起者洽談資料");
		
	}
	public static void main(String[] args)
	{
		InsertProcessingProj.start();
	}

}

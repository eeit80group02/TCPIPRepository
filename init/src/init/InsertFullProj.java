package init;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class InsertFullProj
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO FullProj (primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,"
							+ "projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,"
							+ "projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start()
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setInt(1,1);					// primaryProjId
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId
			pstmt.setInt(3,7);					// memberId
			pstmt.setInt(4,11601);				// schoolId
			pstmt.setString(5,"造神計畫");			// title
			File file = new File("image/primaryProj/primaryProj01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover
				pstmt.setLong(8,file.length());		// frontCoverLength
				
				pstmt.setString(9,"幫助偏遠學校使用辦公室軟體應用");		// projAbstract
				pstmt.setString(10,"Word...Office軟體應用");		// content
				pstmt.setNull(11,Types.NVARCHAR);				// location
				
				pstmt.setString(12,"2015/08/08");				//activityStartTime
				pstmt.setString(13,"2015/08/15");				//activityEndTime
				
				pstmt.setInt(14,20);							// estMember
				pstmt.setInt(15,200000);						// budget
		
				pstmt.setNull(16,Types.TIMESTAMP);				// createDate
				pstmt.setString(17,"洽談中");						// projStatus
				pstmt.setNull(18,Types.NVARCHAR);				// orgArchitecture
				
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName
				pstmt.setNull(20,Types.VARBINARY);				// projFile
				pstmt.setNull(21,Types.BIGINT);					// projFileLength
				
				pstmt.setNull(22,Types.INTEGER);				// reviews
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent
				
				pstmt.setNull(24,Types.NVARCHAR);				// schoolConfirm
				pstmt.setNull(25,Types.NVARCHAR);				// memberConfirm
				
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
		
		
	}
	public static void main(String[] args)
	{
		InsertFullProj.start();
	}

}

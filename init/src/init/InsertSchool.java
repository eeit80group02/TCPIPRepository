package init;

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


public class InsertSchool
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO School (schoolId,name,addressDistrict,addressComplete,phone,url,password) VALUES (?,?,?,?,?,?,?)";
	private static final String INSERT_ELEMENTARY_GRADE = "INSERT INTO GradeStudent (schoolId,anniversary,elementaryFirst,elementarySecond,elementaryThird,elementaryFourth,elementaryFifth,elementarySixth) VALUES(?,?,?,?,?,?,?,?)";
	private static final String INSERT_JUNIOR_GRADE = "INSERT INTO GradeStudent (schoolId,anniversary,juniorFirst,juniorSecond,juniorThird) values(?,?,?,?,?)";
	
	public static void start()
	{
		// 國小 資料
		File file = new File("schoolData/103_elementary.txt");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16"));)
		{
			String line = null;
			for(int i = 0 ; i < 4 ; i++)
				line = br.readLine();

			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{

				
				while(line != null)
				{
					String[] splitStr = line.split("\t");
//					System.out.println(line);
					
					int count = 1;
					pstmt.setBytes(7,"password".getBytes());
					for(String str : splitStr)
					{
						pstmt.setString(count++,str);
						
						if(count == 7)
						{
							count = 1;
							pstmt.executeUpdate();
						}
					}
					if(count == 6)
					{
						count = 1;
						pstmt.setNull(6,Types.NVARCHAR);
						pstmt.executeUpdate();
					}
					line = br.readLine();
				}
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
		
	
//		國中 資料
		file = new File("schoolData/103_junior.txt");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Big5"));)
		{
			String line = null;
			for(int i = 0 ; i < 4 ; i++)
				line = br.readLine();
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				while(line != null)
				{
					String[] splitStr = line.split("\t");
//					System.out.println(line);
					
					int count = 1;
					pstmt.setBytes(7,"password".getBytes());
					for(String str : splitStr)
					{
						pstmt.setString(count++,str);
						
						if(count == 7)
						{
							count = 1;
							pstmt.executeUpdate();
						}
					}
					if(count == 6)
					{
						count = 1;
						pstmt.setNull(6,Types.NVARCHAR);
						pstmt.executeUpdate();
					}
					line = br.readLine();
				}
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
		
		// 國小 年級
		file = new File("schoolData/103_elementaryGrade.txt");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));)
		{
			String line = null;
			for(int i = 0 ; i < 4 ; i++)
				line = br.readLine();
			
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_ELEMENTARY_GRADE);)
			{
				while(line != null)
				{
//					System.out.println(line);
					String[] context = line.split("\t");
					
					if(context[14].equals("-"))
						context[14] = "0";
					if(context[15].equals("-"))
						context[15] = "0";		
					if(context[16].equals("-"))
						context[16] = "0";
					if(context[17].equals("-"))
						context[17] = "0";
					if(context[18].equals("-"))
						context[18] = "0";
					if(context[19].equals("-"))
						context[19] = "0";
					if(context[20].equals("-"))
						context[20] = "0";
					if(context[21].equals("-"))
						context[21] = "0";
					if(context[22].equals("-"))
						context[22] = "0";
					if(context[23].equals("-"))
						context[23] = "0";
					if(context[24].equals("-"))
						context[24] = "0";
					if(context[25].equals("-"))
						context[25] = "0";
						
					pstmt.setInt(1,Integer.parseInt(context[2]));
					pstmt.setInt(2,103);
					pstmt.setInt(3,Integer.parseInt(context[14]) + Integer.parseInt(context[15]));
					pstmt.setInt(4,Integer.parseInt(context[16]) + Integer.parseInt(context[17]));
					pstmt.setInt(5,Integer.parseInt(context[18]) + Integer.parseInt(context[19]));
					pstmt.setInt(6,Integer.parseInt(context[20]) + Integer.parseInt(context[21]));
					pstmt.setInt(7,Integer.parseInt(context[22]) + Integer.parseInt(context[23]));
					pstmt.setInt(8,Integer.parseInt(context[24]) + Integer.parseInt(context[25]));

					pstmt.executeUpdate();
					line = br.readLine();
				}
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

		// 代碼 2
		// 1年級 14+15
		// 2年級 16+17
		// 3年級 18+19
		// 4年級 20+21
		// 5年級 22+23
		// 6年級 24+25
		
		file = new File("schoolData/103_juniorGrade.txt");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));)
		{
			String line = null;
			for(int i = 0 ; i < 4 ; i++)
				line = br.readLine();

			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_JUNIOR_GRADE);)
			{
				while(line != null)
				{
//					System.out.println(line);
					String[] context = line.split("\t");
					
					if(context[11].equals("-"))
						context[11] = "0";
					if(context[12].equals("-"))
						context[12] = "0";		
					if(context[13].equals("-"))
						context[13] = "0";
					if(context[14].equals("-"))
						context[14] = "0";
					if(context[15].equals("-"))
						context[15] = "0";
					if(context[16].equals("-"))
						context[16] = "0";
						
					pstmt.setInt(1,Integer.parseInt(context[2]));
					pstmt.setInt(2,103);
					pstmt.setInt(3,Integer.parseInt(context[11]) + Integer.parseInt(context[12]));
					pstmt.setInt(4,Integer.parseInt(context[13]) + Integer.parseInt(context[14]));
					pstmt.setInt(5,Integer.parseInt(context[15]) + Integer.parseInt(context[16]));

					pstmt.executeUpdate();
					line = br.readLine();
				}
			}
			catch(Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("學校資料新增成功");
	}
	public static void main(String[] args) throws Exception, IOException
	{
		start();
		
	}
}

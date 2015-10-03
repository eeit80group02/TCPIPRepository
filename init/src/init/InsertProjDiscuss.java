package init;

import global.GlobalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class InsertProjDiscuss
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	private static final String INSERT = "INSERT INTO ProjDiscuss(fullProjId,questionMemberId,questionMemberContent,questionMemberTime,answerMemberId,answerMemberContent,answerMemberTime) VALUES(?,?,?,?,?,?,?)";
	
	public static void start()
	{
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			File file = new File("schoolData/projDiscuss");
			try(BufferedReader br = new BufferedReader(new FileReader(file));)
			{
				String line = br.readLine();
				while(line != null)
				{
					String[] str = line.split("\t");
					for(int i = 0 ; i < str.length ; i++)
					{
						if(str[i].equalsIgnoreCase("null"))
						{
							pstmt.setNull(i+1,Types.NVARCHAR);
						}
						else
						{
							pstmt.setString(i+1,str[i]);
						}
					}
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
		System.out.println("完整計畫問與答 完成");
	}

	public static void main(String[] args)
	{
		start();
	}
}

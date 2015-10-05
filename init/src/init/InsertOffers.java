package init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import global.GlobalService;

public class InsertOffers
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Offers VALUES (?,?,?,?)";

	public static void start()
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			try(BufferedReader br = new BufferedReader(new FileReader(new File("schoolData/offers.txt")));)
			{
				String line = br.readLine();
				while(line != null)
				{
					String[] str = line.split("\t");
					for(int i = 0 ; i < str.length ; i++)
					{
						pstmt.setString(i+1,str[i]);
						
					}
					pstmt.executeUpdate();
					line = br.readLine();
				}
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			System.out.println("提供項目新增完成");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		start();
	}
}

package global;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GlobalService
{	
	public static final String HOST = "eeit80group02.cloudapp.net";
//	public static final String USERNAME = "sa";  //sa
//	public static final String PASSWORD = "sa123456"; //sa123456
//	public static final String HOST = "qjtxi3tofr.database.windows.net";    //
	public static final String USERNAME = "eeit80group02@qjtxi3tofr";     //sa
	public static final String PASSWORD = "p@ssw0rd"; //sa123456
	public static final String DATABASE = "TCPIP";
	public static final String URL = "jdbc:sqlserver://" + GlobalService.HOST + ":1433;databaseName=" + GlobalService.DATABASE;
	public static final String JNDI = "java:comp/env/jdbc/TCPIP";
	private static SimpleDateFormat sdf;
	
	static
	{
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
	}
	
	public static byte[] convertInputStreamToByteArray(InputStream is)
	{
		byte[] buffer = new byte[1024 * 8];
		byte[] result = null;
		
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();)
		{
			int nRead = is.read(buffer);
			while(nRead != -1)
			{
				baos.write(buffer,0,nRead);
				nRead = is.read(buffer);
			}
			
			result = baos.toByteArray();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(is != null)
			{
				try
				{
					is.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static java.util.Date convertStringToDate(String dateStr)
	{
		java.util.Date result = null;
		
		try
		{
			result = sdf.parse(dateStr);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return result; 
	}
}

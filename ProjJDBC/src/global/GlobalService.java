package global;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;

public class GlobalService
{
	public static final String HOST = "127.0.0.1";
	public static final String USERNAME = "sasa";
	public static final String PASSWORD = "passw0rd";
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
	
	public static String convertByteArrayToBase64String(byte[] data)
	{
		String result = "data:image/jpeg;base64," + Base64.encodeBase64String(data);
		
		return result; 
	}
	
	public static java.util.Date convertStringToDate(String dateStr) throws ParseException
	{
		java.util.Date result = null;
		
		try
		{
			result = sdf.parse(dateStr);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			throw e;
		}
		return result; 
	}
	
//	public static String getFileName(Part part)
//	{
//		for(String content:part.getHeader("Content-Disposition").split(";"))
//		{
//			if(content.trim().startsWith("filename"))
//			{
//				return content.substring(content.indexOf('=') + 1).trim().replace("\"","");
//			}
//		}
//		return null;
//	}
}

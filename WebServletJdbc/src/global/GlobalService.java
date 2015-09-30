package global;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;

public class GlobalService
{
	public static final String HOST = "eeit80group02.cloudapp.net";
//	public static final String USERNAME = "sasa";
//	public static final String PASSWORD = "passw0rd";
//	public static final String DATABASE = "TCPIP";
//	public static final String URL = "jdbc:sqlserver://" + GlobalService.HOST + ":1433;databaseName=" + GlobalService.DATABASE;
	public static final String JNDI = "java:comp/env/jdbc/TCPIP";
	public static final String CONTEXT_PATH = "TCPIP";
	
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
	
	public static String convertByteArrayToBase64String(String name,byte[] data)
	{
		// ���瑼��
		String mimeType = name.substring(name.lastIndexOf('.') + 1);
		if(mimeType.equalsIgnoreCase("JPG") || mimeType.equalsIgnoreCase("JPEG"))
			return "data:image/jpeg;base64," + Base64.encodeBase64String(data);
		else if(mimeType.equalsIgnoreCase("PNG"))
			return "data:image/png;base64," + Base64.encodeBase64String(data);
			
		return null; 
	}
	
	public static byte[] convertBase64StringToByteArray(String data)
	{
		return Base64.decodeBase64(data);
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
	
	public static int compareDate(java.util.Date start,java.util.Date end)
	{
		return end.compareTo(start);
	}
	
	public static String getFileName(Part part)
	{
		for(String content:part.getHeader("Content-Disposition").split(";"))
		{
			if(content.trim().startsWith("filename"))
			{
				return content.substring(content.indexOf('=') + 1).trim().replace("\"","");
			}
		}
		return null;
	}
	
	//Base64編碼
		public static String getBase64Encoded(String param) throws UnsupportedEncodingException{
			String result = null;
			
			if(param != null){
				java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
				byte[] textByte = param.getBytes("UTF-8");
				String encodeId = encoder.encodeToString(textByte);
				result = encodeId;
			}
			
			return result;
		}
		
		//Base64解碼
		public static String getBase64Decoded(String param) throws UnsupportedEncodingException{
			String result = null;
			
			if(param != null){
				java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
				result = new String(decoder.decode(param), "UTF-8");
			}
			return result;
		}
	
}

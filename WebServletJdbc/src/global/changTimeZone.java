package global;

import java.util.TimeZone;

public class changTimeZone
{

	public changTimeZone()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
	}
	public static void main(String[] args)
	{
	}
}

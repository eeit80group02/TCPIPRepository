package listener;

import global.changTimeZone;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class changTimeZoneListener implements ServletContextListener
{
	public void contextDestroyed(ServletContextEvent arg0)
	{
	}

	public void contextInitialized(ServletContextEvent arg0)
	{
		new changTimeZone();
	}

}

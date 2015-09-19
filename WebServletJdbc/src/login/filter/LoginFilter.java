package login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
		urlPatterns={"/*"},
			initParams = {
				@WebInitParam(name = "mustLogin1", value = "/primaryProj/createPrimaryProjForm.jsp"),
				@WebInitParam(name = "mustLogin2", value = "/primaryProj.do?type=displayPersonal"),
				@WebInitParam(name = "mustLogin3", value = "/personal/personal.jsp"),
				@WebInitParam(name = "mustLogin4", value = "/personal/displayPersonalPrimaryProj.jsp"),
				@WebInitParam(name = "mustLogin5", value = "/fullProj/fullproj.jsp"),
				@WebInitParam(name = "mustLogin6", value = "/fullProj.do?type=displayAll"),
				@WebInitParam(name = "mustLogin7", value = "/primaryProj/updatePrimaryProjForm.jsp"),
				@WebInitParam(name = "mustLogin8", value = "/donation/CheckDonationList.jsp"),
		})
public class LoginFilter implements Filter
{
	private FilterConfig fConfig;
	private List<String> url = new ArrayList<String>();
	
	private String servletPath;
	private String contextPath;
	private String requestURI;
	private String queryString;
	
	public void init(FilterConfig fConfig) throws ServletException
	{
		this.fConfig = fConfig;
		// 抓出所有name的集合
		Enumeration<String> names = fConfig.getInitParameterNames();
		while(names.hasMoreElements())
		{
			// 抓出name[key]
			String name = names.nextElement();
			// 根據name 抓出 value[必須登入的url]
			String value = fConfig.getInitParameter(name);
			url.add(value);
		}
	}

	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException
	{
		boolean isRequestedSessionIdValid = false;
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse)
		{
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			servletPath = req.getServletPath();
			contextPath = req.getContextPath();
			requestURI = req.getRequestURI();
			queryString = req.getQueryString();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();
			
//			System.out.println("servletPath = " + servletPath);
//			System.out.println("contextPath = " + contextPath);
//			System.out.println("requestURI = " + requestURI);
//			System.out.println("queryString: "+queryString);
			
			// 檢查登入
			if(mustLogin())
			{
				if(checkLogin(req))
				{
					// 需要登入，已登入
					chain.doFilter(request,response);
				}
				else
				{
					HttpSession session = req.getSession();
					session.setAttribute("requestURI",requestURI);
					if(!isRequestedSessionIdValid)
					{
						session.setAttribute("timeOut","逾時");
					}
					resp.sendRedirect(contextPath + "/login/login.jsp");
					return;
				}
			}
			else
			{
				chain.doFilter(request,response);
			}
		}
		else
		{
			throw new ServletException("Request / Response 型態錯誤");
		}
	}

	public void destroy()
	{
	}

	private boolean checkLogin(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		if(session.getAttribute("LoginOK") == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private boolean mustLogin()
	{
		boolean login = false;

		for(String sURL : url)
		{
			if(servletPath.endsWith(".do"))
			{
				if((servletPath + "?" + queryString).equals(sURL))
				{
					System.out.println(servletPath + "?" + queryString + " => 要登入，才能使用");
					requestURI += "?" + queryString;
					login = true;
					break;
				}
			}
			else
			{
				if(servletPath.equals(sURL))
				{
					System.out.println(servletPath + " => 要登入，才能使用");
					login = true;
					break;
				}

			}
		}
		System.out.println(servletPath + " => 不用登入，就能使用");
		return login;
	}
}
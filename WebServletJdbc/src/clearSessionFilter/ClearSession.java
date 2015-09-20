package clearSessionFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(urlPatterns={"/*"})
public class ClearSession implements Filter{
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = null ;
		HttpServletResponse response = null;
		if(req instanceof HttpServletRequest && resp instanceof HttpServletResponse){
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}
		System.out.println(request.getServletPath());
		if(!request.getServletPath().equals("/schoolDemand/CreatSchoolDemand.jsp")){
			HttpSession session = request.getSession();
			session.removeAttribute("error");
			session.removeAttribute("data");
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
	
}

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
		HttpSession session = request.getSession();
		if(!request.getServletPath().equals("/schoolDemand/CreatSchoolDemand.jsp")){
			session.removeAttribute("error");
			session.removeAttribute("data");
		}
		if(!request.getServletPath().equals("/schoolDemand/SchoolDemandServlet.do")&&!request.getServletPath().equals("/schoolDemand/Display.jsp")&&!request.getServletPath().equals("/schoolDemand/UpdataSchoolDemand.jsp") ){
			session.removeAttribute("Demand");
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
	
}

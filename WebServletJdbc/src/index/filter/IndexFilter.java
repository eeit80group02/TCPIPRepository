//package index.filter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Enumeration;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter(
//		urlPatterns={"/*"},
//		initParams = {
//			@WebInitParam(name="index", value="/index.jsp")
//		})
//public class IndexFilter  implements Filter{
//	Collection<String> url = new ArrayList<String>();
//	
//	@Override
//	public void init(FilterConfig fConfig) throws ServletException {
//		Enumeration<String> e = fConfig.getInitParameterNames();
//		while(e.hasMoreElements()){
//			String name = e.nextElement();
//			url.add(fConfig.getInitParameter(name));
//		}
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse){
//			HttpServletRequest req = (HttpServletRequest) request;
//			HttpServletResponse resp = (HttpServletResponse) response;
//			String servletPath = req.getServletPath();
//			System.out.println("servletPath:" + servletPath);
//			
//			if(servletPath.equals("/index.jsp")){
//				System.out.println("index才會進來這行");
//			} else {
//				chain.doFilter(request, response);
//			}
//			
//		} else {
//			throw new ServletException("Request/Response Type Error");
//		}
//		
////		chain.doFilter(request, response);
//	}
//
//
//	@Override
//	public void destroy() {
//		
//	}
//}

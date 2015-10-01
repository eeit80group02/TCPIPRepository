package index.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

import global.GlobalService;
import model.FullProjBean;
import model.ParticipatorBean;
import model.dao.FullProjDAOJdbc;
import model.dao.ParticipatorDAOJdbc;

@WebFilter(urlPatterns = { "/index.jsp" })
public class IndexFilter implements Filter {
	Collection<String> url = new ArrayList<String>();

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			url.add(fConfig.getInitParameter(name));
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			String servletPath = req.getServletPath();
			System.out.println("servletPath:" + servletPath);

			if (servletPath.equals("/index.jsp")) {
				System.out.println("index才會進來這行");
				FullProjDAOJdbc dao1 = new FullProjDAOJdbc();
				ParticipatorDAOJdbc dao2 = new ParticipatorDAOJdbc();
				List<FullProjBean> beans = dao1.getAll();
				//完整計畫
				List<FullProjBean> theBeans = new ArrayList<FullProjBean>();
				List<Integer> numbers = new ArrayList<Integer>();
				HttpSession session = req.getSession();
				session.setAttribute("bean", theBeans);
				session.setAttribute("numbers", numbers);
				int i = 1;
				for (FullProjBean bean : beans) {
					if (bean.getProjStatus().trim().equals("招募中") && i <= 6) {
						int num = -1;
						String base64String = GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(), bean.getFrontCover());
						bean.setBase64String(base64String);
						theBeans.add(bean);
						
						//參加人的部分
						List<ParticipatorBean> parBeans = dao2.findByFullProjId(bean.getFullProjId());
						for(ParticipatorBean parBean : parBeans){
							if(parBean.getParticipateStatus().trim().equals("已通過")){
								num++;
							}
						}
						numbers.add(num);
						i++;
						System.out.println("我有一根大香蕉");
					}
				}
				chain.doFilter(request, response);
			} else {
				chain.doFilter(request, response);
			}

		} else {
			throw new ServletException("Request/Response Type Error");
		}

	}

	@Override
	public void destroy() {

	}
}

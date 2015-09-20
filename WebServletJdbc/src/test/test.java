package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/schoolDemand/test.do")
public class test extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =  request.getSession();
		String t = request.getParameter("type");
		if(t.equals("s")){
			session.setAttribute("schoolId", "11601");
		}else {
			session.setAttribute("memberId", "1");
		}
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}
	
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.service.MemberService;

@WebServlet("/checkAccount.do")
public class checkAccountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private MemberService service = null;
	
	@Override
	public void init() throws ServletException
	{
		service = new MemberService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println("checkAccount");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		
		if(account != null && account.trim().length() != 0)
		{
			MemberBean bean = service.checkAccount(account);
			
			if(bean != null)
			{
				out.println("exist");
			}
			else
			{
				out.println("not exist");
			}
		}
	}
}

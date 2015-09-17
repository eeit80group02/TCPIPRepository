package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.SchoolBean;
import model.service.LoginService;


@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private LoginService service = null;
	
	@Override
	public void init() throws ServletException
	{
		service = new LoginService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println("LoginServlet");
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String type = request.getParameter("type");
		
		if(type != null && type.trim().length() != 0 && request.getMethod().equals("POST"))
		{
			if(type.equals("member"))
			{
				// 會員登入
				memberLogin(request,response);
			}
			
			if(type.equals("school"))
			{
				// 學校登入
				schoolLogin(request,response);
			}
		}
		else
		{
			System.out.println("error");
		}
	}

	private void schoolLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// 驗證資料
		if(account == null || account.trim().length() == 0)
		{
			errorMsg.put("account","帳號未輸入");
		}
		
		if(password == null || password.trim().length() == 0)
		{
			errorMsg.put("password","密碼未輸入");
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
			return;
		}
		
		// 轉換資料
		int schoolId = 0;
		try
		{
			schoolId = Integer.parseInt(account);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("account","帳號輸入錯誤");
			e.printStackTrace();
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
			return;
		}
		
		// 進行 business logic
		SchoolBean bean = service.schoolLogin(schoolId,password);
		
		if(bean != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("LoginOK",bean);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
		}
		else
		{
			errorMsg.put("password","登入失敗");
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
			return;
		}
	}

	private void memberLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// 驗證資料
		if(account == null || account.trim().length() == 0)
		{
			errorMsg.put("account","帳號未輸入");
		}
		
		if(password == null || password.trim().length() == 0)
		{
			errorMsg.put("password","密碼未輸入");
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
			return;
		}
		
		// 進行 business logic
		MemberBean bean = service.memberLogin(account,password);
		
		if(bean != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("LoginOK",bean);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
		}
		else
		{
			errorMsg.put("password","登入失敗");
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
			return;
		}
		
	}
}

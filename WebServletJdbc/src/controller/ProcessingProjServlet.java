package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProcessingProjBean;
import model.service.ProcessingProjService;

@WebServlet("/ProcessingProj.do")
public class ProcessingProjServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String type = request.getParameter("type");
		
		if(type != null && type.trim().length() != 0)
		{
			if(type.equals("apply"))
			{
				// 會員登入
				applyPrimaryProj(request,response);
			}
		}
		else
		{
			System.out.println("error");
		}
	}

	private void applyPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收參數
		String primaryProjId = request.getParameter("primaryProjId");
		String schoolId = request.getParameter("schoolId");
		
		// 進行資料驗證
		if(primaryProjId == null || primaryProjId.trim().length() == 0)
		{
			errorMsg.put("error","沒有初步計畫");
		}
		
		if(schoolId == null || schoolId.trim().length() == 0)
		{
			errorMsg.put("error","沒有學校編號");
		}
		
		if(!errorMsg.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		// 進行必要的資料轉換
		int pid = 0;
		try
		{
			pid = Integer.parseInt(primaryProjId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","參數有錯");
			e.printStackTrace();
		}
		
		int sid = 0;
		try
		{
			sid = Integer.parseInt(schoolId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","參數有錯");
			e.printStackTrace();
		}
		
		if(!errorMsg.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		// 進行 business logic
		ProcessingProjBean bean = new ProcessingProjBean();
		bean.setSchoolId(sid);
		bean.setPrimaryProjId(pid);
		
		ProcessingProjService service = new ProcessingProjService();
		boolean result = service.applyPrimaryProj(bean);
		if(result)
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
	}
}

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
import model.ProcessingProjBean;
import model.service.ProcessingProjService;

@WebServlet("/processingProj.do")
public class ProcessingProjServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ProcessingProjService service;
	
	@Override
	public void init() throws ServletException
	{
		service = new ProcessingProjService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		
		if(type != null && type.trim().length() != 0)
		{
			if(type.equals("apply"))
			{
				// 學校提出申請
				System.out.println("執行 ProcessingProjServlet applyPrimaryProj");
				applyPrimaryProj(request,response);
			}
			
			if(type.equals("agree"))
			{
				// 發起者審核
				System.out.println("執行 ProcessingProjServlet applyPrimaryProj");
				agreePrimaryProj(request,response);
			}
			
			if(type.equals("cancel"))
			{
				// 發起者取消
				System.out.println("執行 ProcessingProjServlet cancelPrimaryProj");
				cancelPrimaryProj(request,response);
			}
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
	}

	private void cancelPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String processingProjId = request.getParameter("processingProjId");
		
		// 驗證資料
		if(processingProjId == null || processingProjId.trim().length() == 0)
		{
			errorMsg.put("error","沒有processingProjId");
		}
		
		if(!errorMsg.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		// 轉換資料
		int iProcessingProjId = 0;
		try
		{
			iProcessingProjId = Integer.parseInt(processingProjId);
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
		
		// business
		ProcessingProjBean bean = new ProcessingProjBean();
		bean.setProcessingProjId(iProcessingProjId);
		
		boolean result = service.cancelProcessingProj(bean);
		if(result)
		{
			HttpSession session = request.getSession();
			MemberBean memberBean = (MemberBean)session.getAttribute("LoginOK");
			
			response.sendRedirect(request.getContextPath() + "/primaryProj.do?type=displayPersonalByPending&memberId=" + memberBean.getMemberId());
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
	}

	private void agreePrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String processingProjId = request.getParameter("processingProjId");
		
		// 驗證資料
		if(processingProjId == null || processingProjId.trim().length() == 0)
		{
			errorMsg.put("error","沒有processingProjId");
		}
		
		if(!errorMsg.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		// 轉換資料
		int iProcessingProjId = 0;
		try
		{
			iProcessingProjId = Integer.parseInt(processingProjId);
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
		
		// business
		ProcessingProjBean bean = new ProcessingProjBean();
		bean.setProcessingProjId(iProcessingProjId);
		
		boolean result = service.agreeProcessingProj(bean);
		if(result)
		{
			HttpSession session = request.getSession();
			MemberBean memberBean = (MemberBean)session.getAttribute("LoginOK");
			
			response.sendRedirect(request.getContextPath() + "/primaryProj.do?type=displayPersonalByPending&memberId=" + memberBean.getMemberId());
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
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
			String contextPath = request.getContextPath();
			
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/primaryProj.do?type=displayAll"));
			return;
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
	}
}

package controller;

import global.GlobalService;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.ParticipatorBean;
import model.ProcessingProjBean;
import model.service.ParticipatorService;

@WebServlet("/participator.do")
public class ParticipatorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ParticipatorService service;
	
	public void init() throws ServletException
	{
		service = new ParticipatorService();
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
			// 會員提出申請
			if(type.equals("participate"))
			{
				System.out.println("執行 ParticipatorServlet participate");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				participate(request,response);
				return;
			}
			
			// 發起者同意
			if(type.equals("agree"))
			{
				System.out.println("執行 ParticipatorServlet agreeParticipator");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				agreeParticipator(request,response);
				return;
			}
			
			// 發起者取消 or 會員自己取消 一樣改成未通過
			if(type.equals("cancel"))
			{
				System.out.println("執行 ParticipatorServlet cancelParticipator");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				cancelParticipator(request,response);
				return;
			}
			// 顯示 會員申請中的列表
			if(type.equals("displayParticipator"))
			{
				System.out.println("執行 ParticipatorServlet dispalyParticipator");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				dispalyParticipator(request,response);
				return;
			}
			
			// 顯示 會員參予過的計畫列表
			if(type.equals("displayFullProjByParticipator"))
			{
				System.out.println("執行 ParticipatorServlet displayFullProjByParticipator");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayFullProjByParticipator(request,response);
				return;
			}
		}
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
		return;
	}

	private void displayFullProjByParticipator(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean memberBean = null;
		
		// if session.getAttribute("LoginOK") 無法轉型 => 不是會員登入，無操作權力
		if(session.getAttribute("LoginOK") != null && session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean)session.getAttribute("LoginOK");
		}
		else
		{
			String context = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
			return;
		}
		
		ParticipatorBean participatorBean = new ParticipatorBean();
		participatorBean.setMemberId(memberBean.getMemberId());
		
		List<ParticipatorBean> result = service.dispalyFullProjByParticipator(participatorBean);
		
		if(result != null)
		{
			request.setAttribute("participator",result);
			request.getRequestDispatcher("/personal/displayPersonalParticipateFullProjAll.jsp").forward(request,response);
			return;
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
	}

	private void agreeParticipator(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String participatorId = request.getParameter("participatorId");
		
		// 驗證資料
		if(participatorId == null || participatorId.trim().length() == 0)
		{
			errorMsg.put("error","沒有participatorId");
		}
		
		if(!errorMsg.isEmpty())
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
		
		// 轉換資料
		int iParticipatorId = 0;
		try
		{
			iParticipatorId = Integer.parseInt(participatorId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","參數有錯");
			e.printStackTrace();
		}
		
		if(!errorMsg.isEmpty())
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
		
		// business
		ParticipatorBean participateorBean = new ParticipatorBean();
		participateorBean.setParticipatorId(iParticipatorId);
		
		boolean result = service.agreeParticipator(participateorBean);
		if(result)
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath+ "/fullProj.do?type=displayPersonalByParticipate"));
			return;
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
	}

	private void dispalyParticipator(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean memberBean = null;
		
		// if session.getAttribute("LoginOK") 無法轉型 => 不是會員登入，無操作權力
		if(session.getAttribute("LoginOK") != null && session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean)session.getAttribute("LoginOK");
		}
		else
		{
			String context = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
			return;
		}
		
		ParticipatorBean participatorBean = new ParticipatorBean();
		participatorBean.setMemberId(memberBean.getMemberId());
		
		List<ParticipatorBean> result = service.dispalyParticipator(participatorBean);
		
		if(result != null)
		{
			request.setAttribute("participator",result);
			request.getRequestDispatcher("/personal/displayPersonalParticipateFullProj.jsp").forward(request,response);
			return;
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
	}

	private void cancelParticipator(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String participatorId = request.getParameter("participatorId");
		
		// 驗證資料
		if(participatorId == null || participatorId.trim().length() == 0)
		{
			errorMsg.put("error","沒有participatorId");
		}
		
		if(!errorMsg.isEmpty())
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
		
		// 轉換資料
		int iParticipatorId = 0;
		try
		{
			iParticipatorId = Integer.parseInt(participatorId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","參數有錯");
			e.printStackTrace();
		}
		
		if(!errorMsg.isEmpty())
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
		
		// business
		ParticipatorBean participatorBean = new ParticipatorBean();
		participatorBean.setParticipatorId(iParticipatorId);
		
		boolean result = service.cancelParticipator(participatorBean);
		if(result)
		{
			// 根據不同操作 導向不同頁面
			if(request.getParameter("option").equals("1"))
			{
				String contextPath = request.getContextPath();
				response.sendRedirect(response.encodeRedirectURL(contextPath + "/fullProj.do?type=displayPersonalByParticipate"));
				return;
			}
			else if(request.getParameter("option").equals("2"))
			{
				String contextPath = request.getContextPath();
				response.sendRedirect(response.encodeRedirectURL(contextPath + "/participator.do?type=displayParticipator"));
				return;
			}
			else
			{
				String contextPath = request.getContextPath();
				response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
				return;
			}
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
	}

	private void participate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		// if session.getAttribute("LoginOK") 無法轉型 => 不是會員登入，無操作權力
		MemberBean memberBean = null;
		if(session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean)session.getAttribute("LoginOK");
		}
		else
		{
			String context = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
			return;
		}
		
		String fullProjId = request.getParameter("fullProjId");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
				
		ParticipatorBean participatorBean = new ParticipatorBean();
		participatorBean.setFullProjId(Integer.parseInt(fullProjId));
		participatorBean.setMemberId(memberBean.getMemberId());
		
		try
		{
			participatorBean.setActivityStartTime(GlobalService.convertStringToDate(startTime));
			participatorBean.setActivityEndTime(GlobalService.convertStringToDate(endTime));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		ParticipatorBean result = service.participate(participatorBean);
		
		if(result != null)
		{
			session.setAttribute("success","success");
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/fullProj.do?type=display&fullProjId=" + fullProjId));
			return;
		}
		else
		{
			session.setAttribute("participate","此計畫活動時間，您有其他計畫參予中");
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/fullProj.do?type=display&fullProjId=" + fullProjId));
			return;
		}
	}
}

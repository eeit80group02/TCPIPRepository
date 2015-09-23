package controller;

import global.GlobalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.ParticipatorBean;
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
			if(type.equals("participate"))
			{
				// 會員提出申請
				System.out.println("執行 ParticipatorServlet participate");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				participate(request,response);
				return;
			}
		}
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
		return;
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

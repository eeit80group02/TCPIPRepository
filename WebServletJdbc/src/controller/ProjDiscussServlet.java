package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.ProjDiscussBean;
import model.service.ProjDiscussService;

import org.json.simple.JSONObject;

@WebServlet("/projDiscuss.do")
public class ProjDiscussServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private ProjDiscussService service;
	public void init() throws ServletException
	{
		service = new ProjDiscussService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");

		// 接收參數
		String type = request.getParameter("type");

		if(type.equals("display"))
		{
			displayDiscuss(request,response);
		}
		else if(type.equals("reply"))
		{
			replyDiscuss(request,response);
		}
		else if(type.equals("post"))
		{
			postDiscuss(request,response);
		}
//		else if(type.equals("addMember"))
//		{
//			addMemberMessage(request,response);
//		}
//		else if(type.equals("addSchool"))
//		{
//			addSchoolMessage(request,response);
//		}
	}

	private void postDiscuss(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberBean memberBean = null;
		if(session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean) session.getAttribute("LoginOK");
		}
		else
		{
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
			return;
		}
		
		String fullProjId = request.getParameter("fullProjId");
		String content = request.getParameter("content");
		
		int fId = Integer.parseInt(fullProjId);
		
		ProjDiscussBean projDiscusBean = new ProjDiscussBean();
		projDiscusBean.setFullProjId(fId);
		projDiscusBean.setQuestionMemberId(memberBean.getMemberId());
		projDiscusBean.setQuestionMemberContent(content);
		
		JSONObject result = service.postDiscuss(projDiscusBean);
		out.write(result.toJSONString());
		
	}

	private void replyDiscuss(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("type"));
	}

	private void displayDiscuss(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String fullProjId = request.getParameter("fullProjId");
		int fId = Integer.parseInt(fullProjId);
		
		JSONObject jsonObject = service.select(fId);
		System.out.println(jsonObject);
		out.write(jsonObject.toJSONString());
	}
}

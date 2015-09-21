package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProjModifyBean;
import model.service.ProjModifyService;

import org.json.simple.JSONObject;

@WebServlet("/ProjModifyServlet.do")
public class ProjModifyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ProjModifyService service;
	
	@Override
	public void init() throws ServletException
	{
		service = new ProjModifyService();
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
			displayMessage(request,response);
		}
		else if(type.equals("addMember"))
		{
			addMemberMessage(request,response);
		}
		else if(type.equals("addSchool"))
		{
			addSchoolMessage(request,response);
		}
	}

	private void addMemberMessage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String fullProjId = request.getParameter("fullProjId");
		String memberId = request.getParameter("memberId");
		String content = request.getParameter("content");

		int fId = Integer.parseInt(fullProjId);
		int mId = Integer.parseInt(memberId);
		
		System.out.println(fId);
		System.out.println(mId);
		System.out.println(content);
		
		ProjModifyBean projModifyBean = new ProjModifyBean();
		projModifyBean.setFullProjId(fId);
		projModifyBean.setMemberId(mId);
		projModifyBean.setMemberMessage(content);
		
		JSONObject result = service.addMemberMessage(projModifyBean);
		out.write(result.toJSONString());
		
	}
	
	private void addSchoolMessage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String fullProjId = request.getParameter("fullProjId");
		String schoolId = request.getParameter("schoolId");
		String content = request.getParameter("content");

		int fId = Integer.parseInt(fullProjId);
		int sId = Integer.parseInt(schoolId);
		
		System.out.println(fId);
		System.out.println(sId);
		System.out.println(content);
		
		ProjModifyBean projModifyBean = new ProjModifyBean();
		projModifyBean.setFullProjId(fId);
		projModifyBean.setSchoolId(sId);
		projModifyBean.setSchoolMessage(content);
		
		JSONObject result = service.addSchoolMessage(projModifyBean);
		out.write(result.toJSONString());
		
	}

	private void displayMessage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
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

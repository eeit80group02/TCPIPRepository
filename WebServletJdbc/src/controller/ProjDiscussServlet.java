package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		else if(type.equals("addMember"))
//		{
//			addMemberMessage(request,response);
//		}
//		else if(type.equals("addSchool"))
//		{
//			addSchoolMessage(request,response);
//		}
	}

	private void replyDiscuss(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("projDiscuss"));
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

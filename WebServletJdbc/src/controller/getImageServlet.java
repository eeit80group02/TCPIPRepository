package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageHolder;
import model.service.ImageService;

@WebServlet("/getImage.do")
public class getImageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ImageService service;
	
	@Override
	public void init() throws ServletException
	{
		service = new ImageService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		
		if(type.equals("fullProj"))
		{
			System.out.println("執行 getImageServlet displayFullProj");
			System.out.println(request.getRequestURI() + "?" + request.getQueryString());
			displayFullProj(request,response);
		}
		
		if(type.equals("primaryProj"))
		{
			System.out.println("執行 getImageServlet displayPrimaryProj");
			System.out.println(request.getRequestURI() + "?" + request.getQueryString());
			displayPrimaryProj(request,response);
		}
	}

	private void displayPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String primaryProjId = request.getParameter("primaryProjId");
		
		int pid = Integer.parseInt(primaryProjId);
		
		ImageHolder imageHolder = service.getPrimaryProjImage(pid);
		
		response.reset();
		response.setContentType(getServletContext().getMimeType(imageHolder.getName()));
		response.setContentLengthLong(imageHolder.getContentLength());
		response.getOutputStream().write(imageHolder.getContent());
	}

	private void displayFullProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{ 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String fullProjId = request.getParameter("fullProjId");
		
		int fid = Integer.parseInt(fullProjId);
		
		ImageHolder imageHolder = service.getFullProjImage(fid);
		
		response.reset();
		response.setContentType(getServletContext().getMimeType(imageHolder.getName()));
		response.setContentLengthLong(imageHolder.getContentLength());
		response.getOutputStream().write(imageHolder.getContent());
		
	}
}

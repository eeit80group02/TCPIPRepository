package controller;

import java.io.File;
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
import model.ProcessingMemberBean;
import model.SchoolBean;
import model.service.ProcessingMemberService;

@WebServlet("/schoolDemand/Status.do")
public class ProcessingMemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		String type = request.getParameter("type");
		if (type == null || type.trim().length() == 0) {
			errorMsg.put("errorURL", "請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
			return;
		} else {
			if(type.equals("application")){
				System.out.println("申請");
				application(request, response);
			}else if(type.equals("agree")){
				System.out.println("同意");
				agree(request, response);
			}else if(type.equals("disagree")){
				System.out.println("不同意");
				disagree(request, response);
			}else if(type.equals("cancel")){
				System.out.println("取消");
				cancel(request, response);
			}else {
				errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.70(必須post))");
				request.getRequestDispatcher("/error.jsp").forward(request,response);
				return;
			}
		}
		
	}public void application(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		ProcessingMemberService service = new ProcessingMemberService();	
		HttpSession session = request.getSession();
		
		MemberBean mbean = (MemberBean)session.getAttribute("LoginOK");
		if(mbean==null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		
		int memberId = mbean.getMemberId();
		String schoolDemandId = request.getParameter("schoolDemandId");

		int sId = 0;
		try {
			sId = Integer.parseInt(schoolDemandId);
		} catch (NumberFormatException e) {
			System.out.println("錯誤");
			response.sendRedirect("");
			return;
		}
		
		bean.setMemberId(memberId);
		bean.setSchoolDemandId(sId);
		System.out.println(bean);
		bean = service.application(bean);
		if(bean!=null){
			System.out.println("建立成功" + bean);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/submitsuccess.jsp");
			return;
		}else{
			System.out.println("建立失敗");
			request.getRequestDispatcher("").forward(request, response);
		}
	}
	
	public void agree(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		

		ProcessingMemberService service = new ProcessingMemberService();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		HttpSession session = request.getSession();
		SchoolBean sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean ==null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		String processingMemberId = request.getParameter("processingMemberId");
		String memberId = request.getParameter("memberId");
		String schoolDemandId = request.getParameter("schoolDemandId");
		int pMId = 0;
		int mId = 0;
		int sDId = 0;
		if(processingMemberId != null && memberId != null && schoolDemandId != null){
			try {
				pMId = Integer.parseInt(processingMemberId);
				mId = Integer.parseInt(memberId);
				sDId = Integer.parseInt(schoolDemandId);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}
		File image = new File(getServletContext().getRealPath("/images/fullProj/default.jpg"));
		System.out.println(image);
		bean.setProcessingMemberId(pMId);
		bean.setMemberId(mId);
		bean.setSchoolDemandId(sDId);
		System.out.println(bean);
		bean = service.agree(bean,image);
		if(bean!=null){
			System.out.println("同意成功");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/passMember.jsp");
			return;
		}else {
			System.out.println("同意失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}

	}
	public void disagree(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ProcessingMemberService service = new ProcessingMemberService();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		HttpSession session = request.getSession();
		SchoolBean sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean ==null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		String processingMemberId = request.getParameter("processingMemberId");
		String memberId = request.getParameter("memberId");
		String schoolDemandId = request.getParameter("schoolDemandId");
		int pMId = 0;
		int mId = 0;
		int sDId = 0;
		if(processingMemberId != null && memberId != null){
			try {
				pMId = Integer.parseInt(processingMemberId);
				mId = Integer.parseInt(memberId);
				sDId = Integer.parseInt(schoolDemandId);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}
		bean.setProcessingMemberId(pMId);
		bean.setMemberId(mId);
		bean.setSchoolDemandId(sDId);
		System.out.println(bean);
		bean = service.disagree(bean);
		if(bean!=null){
			System.out.println("拒絕成功" + bean);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}else{
			System.out.println("拒絕失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}
	}
	public void cancel(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ProcessingMemberService service = new ProcessingMemberService();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		SchoolBean sbean = null;
		HttpSession session = request.getSession();
		sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean ==null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		String schoolDemandId = request.getParameter("schoolDemandId");
		String memberId = request.getParameter("memberId");
		int sDId = 0;
		int mId = 0;
		try {
			sDId = Integer.parseInt(schoolDemandId);
			mId = Integer.parseInt(memberId);
		} catch (Exception e) {
			response.sendRedirect("");
		}
		bean.setMemberId(mId);
		bean.setSchoolDemandId(sDId);
		bean = service.cancel(bean);
		if(bean!=null){
			System.out.println("取消成功");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}else{
			System.out.println("取消失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender");
		}
		
	}
}

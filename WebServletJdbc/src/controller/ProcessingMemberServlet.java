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
		System.out.println(type);
		System.out.println(request.getMethod());
		if (type == null || type.trim().length() == 0) {
			errorMsg.put("errorURL", "請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
			return;
		} else {

			if (request.getMethod().equals("POST")) {
				if(type.equals("application")){
					System.out.println("同意");
					application(request, response);
				}else if(type.equals("agree")){
					System.out.println("不同意");
					agree(request, response);
				}else if(type.equals("disagree")){
					System.out.println("取消");
					disagree(request, response);
				}else if(type.equals("cancel")){
					System.out.println("取消");
					cancel(request, response);
				}
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
		
//		String memberId = (String)session.getAttribute("memberId");
//		String schoolDemandId = request.getParameter("schoolDemandId");
		
		String memberId = "1";
		String schoolDemandId =  "18";
		
		if(memberId ==null || memberId.trim().length() ==0){
			errorMsg.put("error", "錯誤");
		}
		if(schoolDemandId ==null || schoolDemandId.trim().length() ==0){
			errorMsg.put("error", "錯誤");
		}
		int mId = 0;
		try {
			mId = Integer.parseInt(memberId);
		} catch (NumberFormatException e) {
			errorMsg.put("error", "錯誤");
		}
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolDemandId);
		} catch (NumberFormatException e) {
			errorMsg.put("error", "錯誤");
		}
		if(!errorMsg.isEmpty()){
			request.getRequestDispatcher("").forward(request, response);
		}
		
		bean.setMemberId(mId);
		bean.setSchoolDemandId(sId);
		
		bean = service.application(bean);
		if(bean!=null){
			System.out.println("建立成功" + bean);
			request.getRequestDispatcher("").forward(request, response);
		}else{
			System.out.println("建立失敗");
			request.getRequestDispatcher("").forward(request, response);
		}
	}
	
	public void agree(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		ProcessingMemberService service = new ProcessingMemberService();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		HttpSession session = request.getSession();
		
		String schoolId = (String)session.getAttribute("schoolId");
		String schoolDemandId = request.getParameter("schoolDemandId");
		
		if(schoolId ==null || schoolId.trim().length() ==0){
			errorMsg.put("", "");
		}
		if(schoolDemandId ==null || schoolDemandId.trim().length() ==0){
			errorMsg.put("", "");
		}

		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (NumberFormatException e) {
			errorMsg.put("error", "錯誤");
		}
		int sDId = 0;
		try {
			sDId = Integer.parseInt(schoolDemandId);
		} catch (NumberFormatException e) {
			errorMsg.put("error", "錯誤");
		}
		if(!errorMsg.isEmpty()){
			request.getRequestDispatcher("").forward(request, response);
		}
		
		bean.setMemberId(sId);
		bean.setSchoolDemandId(sDId);
		
		bean = service.agree(bean);
		if(bean!=null){
			System.out.println("建立成功" + bean);
			request.getRequestDispatcher("").forward(request, response);
		}else{
			System.out.println("建立失敗");
			request.getRequestDispatcher("").forward(request, response);
		}
		

	}
	public void disagree(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Map<String, String> errorMsg = new HashMap<String, String>();
		ProcessingMemberService service = new ProcessingMemberService();
		ProcessingMemberBean bean = new ProcessingMemberBean();
		HttpSession session = request.getSession();
		
		//取得Session裡學校Bean
		SchoolBean sbean = (SchoolBean)session.getAttribute("LoginOK");
		//判斷是否登入
		if(sbean ==null){
			//導入登入頁面
			response.sendRedirect("");
		}
		//取得ProcessingMemberID
		//取得SchoolDemandID
		//取得MemberID
		
		
		
		String memberId = request.getParameter("memberId");
		
		
		
	}
	public void cancel(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	}
}

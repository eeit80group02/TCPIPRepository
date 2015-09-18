package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationDiscussBean;
import model.DonationDiscussService;
import model.MemberBean;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//@WebServlet("/MessagesControllServlet")
public class MessagesControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1.接收資料
		// session...
		HttpSession session = request.getSession(false);
		if (session == null) {
			// 導向登入頁面
		}
		
		// member
		MemberBean member = (MemberBean) session.getAttribute("LoginOK");
		int memberId = member.getMemberId();
		
		String reporter = request.getParameter("reporter");
		String textarea = request.getParameter("textarea");
		String donationIdStr = request.getParameter("donationId");
		String schoolIdStr = request.getParameter("schoolId");
		String returnJson = request.getParameter("returnJson");
		// 2.資料轉換
		int donationId = Integer.parseInt(donationIdStr);
		int schoolId = Integer.parseInt(schoolIdStr);
		
		if (reporter.equals("member")) {
			// 3.呼叫Model
			DonationDiscussService service = new DonationDiscussService();
			JSONArray jsonArray = service.saveMemberMessages(textarea, donationId, memberId, schoolId);
			
			// 4.挑選適當畫面
			if (returnJson.equals("true")) {
				if (jsonArray != null) {
					PrintWriter out = response.getWriter();
					out.print(jsonArray);
					System.out.println("會員留言成功");
				}
			}
			
		} else if(reporter.equals("school")) {	
			// 1.接收資料
			String donationDiscussIdStr = request.getParameter("donationDiscussId");
			
			// 2.資料轉換/封裝
			int donationDiscussId = Integer.parseInt(donationDiscussIdStr);
			DonationDiscussBean donationDiscussBean = new DonationDiscussBean();
			donationDiscussBean.setDonationDiscussId(donationDiscussId);
			donationDiscussBean.setSchoolMessage(textarea);
			donationDiscussBean.setSchoolId(schoolId);
			
			// 3.呼叫Model
			DonationDiscussService service = new DonationDiscussService();
			boolean b = service.saveSchoolMessages(donationDiscussBean);
			System.out.println("學校留言是否成功: "+b);
			
			// 4.挑選適當畫面
			RequestDispatcher rd = 
					request.getRequestDispatcher(
							"demand.do?donationId="+donationId
							+"&schoolId="+schoolId
							+"&type=OneDeamndBySchool");
			rd.forward(request, response);
			return;
		}
	}
}

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
import model.SchoolBean;

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
		response.setContentType("application/json; charset=UTF-8");
		System.out.println("123");
		// 1.接收資料
		// session...
		HttpSession session = request.getSession(false);
		if (session == null) {
			// 導向登入頁面
			System.out.println("seesion == null");
		}
		
		int memberId = 0;
		int schoolId = 0;
		// 驗證會員是否登入
		System.out.println("@@1");
		Object obj = session.getAttribute("LoginOK");
		System.out.println("@@12");
		if (obj == null) {
			// 導向登入會員
			System.out.println("無登入狀態，轉至捐獻首頁");
//				response.sendRedirect(response.encodeRedirectURL(request
//						.getContextPath()+"/index.jsp"));
//				return;
			
		} else if (obj instanceof MemberBean) {
			System.out.println("@@m");
			MemberBean member = (MemberBean) session.getAttribute("LoginOK");
			memberId = member.getMemberId();
			System.out.println("會員登入狀態，轉至確定訂單頁");
		} else if (obj instanceof SchoolBean) {
			System.out.println("@@s");
			SchoolBean school = (SchoolBean) session.getAttribute("LoginOK");
			schoolId = school.getSchoolId();
			System.out.println("@@i"+schoolId);
//				System.out.println("學校登入狀態，轉至捐獻首頁");
//				response.sendRedirect(response.encodeRedirectURL(request
//						.getContextPath()+"/donation/FindGoods.jsp"));
//				return;
		}
		System.out.println("@@3");
		String reporter = request.getParameter("reporter");
		System.out.println("reporter "+reporter);
		String textarea = request.getParameter("textarea");
		System.out.println("textarea "+textarea);
		String donationIdStr = request.getParameter("donationId");
		System.out.println("donationId "+donationIdStr);
		String returnJson = request.getParameter("returnJson");
		System.out.println("returnJson "+returnJson);
		// 2.資料轉換
		int donationId = Integer.parseInt(donationIdStr);
		
		if (reporter.equals("member")) {
			String schoolIdStr = request.getParameter("schoolId");
			// ...
			int schoolIdMem = Integer.parseInt(schoolIdStr);
			// 3.呼叫Model
			DonationDiscussService service = new DonationDiscussService();
			JSONArray jsonArray = service.saveMemberMessages(textarea, donationId, memberId, schoolIdMem);
			
			// 4.挑選適當畫面
			if (returnJson.equals("true")) {
				if (jsonArray != null) {
					PrintWriter out = response.getWriter();
					out.print(jsonArray);
					System.out.println("會員留言成功");
				}
			}
			
		} else if(reporter.equals("school")) {	
			System.out.println("schoolId "+schoolId);

			// 1.接收資料
			String donationDiscussIdStr = request.getParameter("donationDiscussId");
			System.out.println("donationDiscussIdStr = "+donationDiscussIdStr);
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

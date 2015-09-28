package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationBillBean;
import model.DonationCart;
import model.DonationOrderBean;
import model.DonationService;
import model.MemberBean;
import model.SchoolBean;

//@WebServlet("/FinallCheckCartServlet")
public class FinallCheckCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 驗證 session，按下禮物 icon與 booking鈕時都要檢查是否是登入會員的狀態
		HttpSession session = request.getSession(false);
		if (session == null) {
			//...
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/FindGoods.jsp"));
			return;
		}
		
		// 驗證會員是否登入
		int memberId = 0;
		Object obj = session.getAttribute("LoginOK");
		if (obj == null) {
			// 導向登入會員
			System.out.println("無登入狀態，轉至捐獻首頁");
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/index.jsp"));
			return;
		
		} else if (obj instanceof MemberBean) {
			System.out.println("會員登入狀態，轉至確定訂單頁");
			MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
			memberId = mBean.getMemberId();
			
		} else if (obj instanceof SchoolBean) {
			System.out.println("學校登入狀態，轉至捐獻首頁");
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/FindGoods.jsp"));
			return;
			
		}
		
		// 驗證 cart，無登入會員下按下確認清單
		DonationCart dCart = (DonationCart) session.getAttribute("DonationCart");
		if (dCart == null) {
			System.out.println("購物車沒有任何物品，轉向捐獻首頁");
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/FindGoods.jsp"));
			return;
		}
		
		// 1.a 接收資料
		String linkto = request.getParameter("linkto");
		String schoolIdStr = request.getParameter("schoolId");
		
		// 1.b 帳單資料
		String name = request.getParameter("txtOcname");
		String address = request.getParameter("txtOaddress");
		String phone = request.getParameter("txtOtel");
		String cellPhone = request.getParameter("txtOmobile");
		String email = request.getParameter("txtOemail");
		// for stepThree
		String schoolId3 = request.getParameter("schoolId3");
		String dealId = request.getParameter("dealId");
		System.out.println("name"+name);
		System.out.println("address"+address);
		System.out.println("phone"+phone);
		System.out.println("email"+email);
		System.out.println("memberId"+memberId);
		System.out.println("schoolId3"+schoolId3);
		System.out.println("dealId"+dealId);
		
		// 封裝訂單主檔
		DonationOrderBean donationOrderBean = new DonationOrderBean();
		donationOrderBean.setMemberId(memberId);
		donationOrderBean.setName(name);
		donationOrderBean.setAddress(address);
		donationOrderBean.setPhone(phone);
		donationOrderBean.setCellPhone(cellPhone);
		donationOrderBean.setEmail(email);
		donationOrderBean.setPickTime(new Date());
		donationOrderBean.setDonationOederDate(new Date());
		// 假定貨運單編號
		donationOrderBean.setDealId(dealId);
		
		
		if (linkto.equals("stepOne")) {
			
			List<DonationBillBean> list = dCart.getDonationOrderBySchool();
			request.setAttribute("DemandOBSchool", list);
			
			System.out.println("cart work");
			RequestDispatcher rd = request.getRequestDispatcher("Bill01.jsp");
			rd.forward(request, response);
			return;
			
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/CheckDonationList.jsp"));
//			return;
			
		} if (linkto.equals("stepTwo")) {
			int schoolId = 0;
			if(schoolIdStr == null || schoolIdStr.trim().length() == 0) {
				System.out.println("stepTwo 資料錯誤");
			}
			schoolId = Integer.parseInt(schoolIdStr);
			DonationBillBean dBean = dCart.getDonationOfOneSchool(schoolId);
			request.setAttribute("OneSchoolBill", dBean);
			
			System.out.println("cart work");
			RequestDispatcher rd = request.getRequestDispatcher("Bill02.jsp");
			rd.forward(request, response);
			return;
			
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/CheckDonationList.jsp"));
//			return;
			
		} if (linkto.equals("stepThree")) {
			int schoolId = 0;
			if(schoolId3 == null || schoolId3.trim().length() == 0) {
				System.out.println("stepTwo 資料錯誤");
			}
			schoolId = Integer.parseInt(schoolId3);
			
			DonationService service = new DonationService();
			DonationOrderBean orderBean = service.OneSchoolOrderBooking(donationOrderBean, schoolId, dCart);
			
			if(orderBean != null) {
				dCart.deleteDonationOfOneSchool(schoolId);
			}
			
			// 傳送購物車最新資訊.
			String idString = dCart.getDonationIdString();
			request.setAttribute("newItemsInCart", idString);
			System.out.println("newItemsInCart@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ = "+idString);
			System.out.println("newItemsInCart = "+idString);
			
			
//			List<DonationBillBean> list = dCart.getDonationOrderBySchool();
//			session.setAttribute("DemandOBSchool", list);
			request.setAttribute("OrderDetail", orderBean);
			
			System.out.println("cart work");
			RequestDispatcher rd = request.getRequestDispatcher("Bill03.jsp");
			rd.forward(request, response);
			return;
			
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/CheckDonationList.jsp"));
//			return;
			
		}  else if (linkto.equals("checkBooking")) {
			
			
			
			System.out.println("cart work");
			RequestDispatcher rd = request.getRequestDispatcher("Bill02.jsp");
			rd.forward(request, response);
			return;
			
		}
	}
}

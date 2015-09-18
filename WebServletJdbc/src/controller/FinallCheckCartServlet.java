package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationCart;
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
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/FindGoods.jsp"));
//			return;
		}
		
		// 驗證會員是否登入
		Object obj = session.getAttribute("LoginOK");
		if (obj == null) {
			// 導向登入會員
			System.out.println("無登入狀態，轉至捐獻首頁");
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/index.jsp"));
//			return;
			
		} else if (obj instanceof MemberBean) {
			System.out.println("會員登入狀態，轉至確定訂單頁");
		} else if (obj instanceof SchoolBean) {
//			System.out.println("學校登入狀態，轉至捐獻首頁");
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/FindGoods.jsp"));
//			return;
		}
		
		// 驗證 cart，無登入會員下按下確認清單
		DonationCart donationCart = (DonationCart) session.getAttribute("DonationCart");
		if (donationCart == null) {
			System.out.println("購物車沒有任何物品，轉向捐獻首頁");
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/FindGoods.jsp"));
//			return;
		}
		
		// 1.接收資料
		String linkto = request.getParameter("linkto");
		
		if (linkto.equals("checkList")) {
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/CheckDonationList.jsp"));
			return;
		} else if (linkto.equals("checkBooking")) {
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/ExpressDelivery.jsp"));
			return;
		}
	}
}

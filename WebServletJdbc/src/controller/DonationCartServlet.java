package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.DonationCart;
import model.DonationService;

//@WebServlet("/DonationCartServlet")
public class DonationCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 若尚未登入會員則自己產生一個 session，負責傳遞資料
		HttpSession session = request.getSession(false);
		String sId = session.getId();
		System.out.println("sId: "+sId);
		DonationCart dCart = (DonationCart) session.getAttribute("DonationCart");
		if (dCart == null) {
			dCart = new DonationCart();
			session.setAttribute("DonationCart", dCart);
		}
		
		// 1.接收資料
		String toCart = request.getParameter("toCart");
		String dialog = request.getParameter("dialog");

		if (toCart == null) {
			RequestDispatcher rd = request.getRequestDispatcher("ExpressDelivery.jsp");
			rd.forward(request, response);
			return;
		}
		String donationIdStr = request.getParameter("donationId");
		int donationId = 0;

		String donateAmountStr = request.getParameter("donateAmount");
		int donateAmount = 0;
		
		if (toCart.equals("insert")) {
			DonationService donationService = new DonationService();
			// 2.資料驗證
			if(donationIdStr != null || donationIdStr.trim().length() != 0) {
			donationId = Integer.parseInt(donationIdStr);
			} 

			DonationBeanDuplicate donationBeanDuplicate = donationService.findOneDemand(donationId);
			// 3.呼叫Model
			boolean b = dCart.insertDonationToCart(donationBeanDuplicate);
			System.out.println("新增至購物車: " + b);
			
			// 4.挑選適當畫面
			if (dialog != null) {
				RequestDispatcher rd = request.getRequestDispatcher("CheckDonationList.jsp");
				rd.forward(request, response);
				return;
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("demand.do?type=FindGoods");
				rd.forward(request, response);
				return;
			}
			
		} else if(toCart.equals("update")) {
			// 2.資料驗證
			if(donationIdStr != null || donationIdStr.trim().length() != 0) {
				donationId = Integer.parseInt(donationIdStr);
			} 
			if (donateAmountStr != null || donateAmountStr.trim().length() == 0) {
				donateAmount = Integer.parseInt(donateAmountStr);
			}
			
			// 3.呼叫Model
			boolean b = dCart.modifyQty(donationId, donateAmount);
			System.out.println("更新購物車欄位: " + b);
			
			// 4.挑選適當畫面
			PrintWriter out = response.getWriter();
			out.print("更新購物車欄位: " + b);
			
		} else if (toCart.equals("delete")) {
			// 2.資料驗證
			if(donationIdStr != null || donationIdStr.trim().length() != 0) {
				donationId = Integer.parseInt(donationIdStr);
			} 
			
			// 3.呼叫Model
			boolean b = dCart.deleteDonation(donationId);
			System.out.println("刪除購物車欄位: " + b);
			
			// 4.挑選適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("CheckDonationList.jsp");
			rd.forward(request, response);
			return;
		} else if (toCart.equals("deleteAll")) {
			// 清空 cart
			boolean b = dCart.remove();
			// 4.挑選適當畫面
			System.out.println("刪除購物車全部欄位: " + b);
			RequestDispatcher rd = request.getRequestDispatcher("demand.do?type=FindGoods");
			rd.forward(request, response);
			return;
		}
	}
}

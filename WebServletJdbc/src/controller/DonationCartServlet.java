package controller;

import java.io.IOException;
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

//@WebServlet("/DonationCartServlet")
public class DonationCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession();
		}
		
		DonationCart dCart = (DonationCart) session.getAttribute("DonationCart");
		if (dCart == null) {
			dCart = new DonationCart();
			session.setAttribute("DonationCart", dCart);
		}
		
		// 1.接收資料
		String toCart = request.getParameter("toCart");
		
		String donationIdStr = request.getParameter("donationId");
		int donationId = 0;
		String schoolIdStr = request.getParameter("schoolId");
		int schoolId = 0;
		// new
		String schoolName = request.getParameter("schoolName");
		String donationStatus = request.getParameter("donationStatus");
		String supplyName = request.getParameter("supplyName");
		String originalDemandNumberStr = request.getParameter("originalDemandNumber");
		int originalDemandNumber = 0;
		String originalDemandUnit = request.getParameter("originalDemandUnit");
		String demandNumberStr = request.getParameter("demandNumber");
		int demandNumber = 0;
		String donateAmountStr = request.getParameter("donateAmount");
		int donateAmount = 0;
		String size = request.getParameter("size");
		String demandContent = request.getParameter("demandContent");
		String supplyStatus = request.getParameter("supplyStatus");
		String remark = request.getParameter("remark");
		
		if (toCart.equals("insert")) {
			// 2.資料驗證
			if(donationIdStr != null || donationIdStr.trim().length() != 0) {
			donationId = Integer.parseInt(donationIdStr);
			} 
			if(schoolIdStr != null || schoolIdStr.trim().length() != 0) {
				schoolId = Integer.parseInt(schoolIdStr);
			}
			if(originalDemandNumberStr != null || originalDemandNumberStr.trim().length() != 0) {
				originalDemandNumber = Integer.parseInt(originalDemandNumberStr);
			}
			if(demandNumberStr != null || demandNumberStr.trim().length() != 0) {
				demandNumber = Integer.parseInt(demandNumberStr);
			} 
			
			// 新增schoolName, 新增donateAmount預設為1
			DonationBeanDuplicate donationBeanDuplicate = 
					new DonationBeanDuplicate(donationId, schoolId,
							 schoolName, donationStatus, supplyName,				
							 originalDemandNumber, originalDemandUnit, demandNumber, 1, size,
							 demandContent, supplyStatus, null, null, null, null, 0, remark);
		
			// 3.呼叫Model
			boolean b = dCart.insertDonationToCart(donationBeanDuplicate);
			System.out.println("新增至購物車: " + b);
			
			// 4.挑選適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("demand.do?type=FindGoods");
			rd.forward(request, response);
			return;
			
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
			RequestDispatcher rd = request.getRequestDispatcher("CheckDonationList.jsp");
			rd.forward(request, response);
			return;
			
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
		}

		
		
		
		
	}

}

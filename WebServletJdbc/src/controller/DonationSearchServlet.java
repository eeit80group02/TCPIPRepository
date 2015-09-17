package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DonationBeanDuplicate;
import model.DonationService;
import model.service.DonationSearchService;

//@WebServlet("/DonationSearchServlet")
public class DonationSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1.接收資料
		String supplyStatus = request.getParameter("supplyStatus");
		String type = request.getParameter("type");
		
		if (supplyStatus != null) {
			DonationSearchService donationSearchService = new DonationSearchService();
			
			List<DonationBeanDuplicate> dbdList = donationSearchService.searchByStatus(supplyStatus);
			request.setAttribute("AllDemands", dbdList);
			
			// 4.轉至適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
			rd.forward(request, response);
			return;
		
		} else if(type != null) {
			if (type.equals("byAmount")){
				DonationSearchService donationSearchService = new DonationSearchService();
				List<DonationBeanDuplicate> dbdList = donationSearchService.searchByOriginalDemandNumber();
				
				request.setAttribute("AllDemands", dbdList);
				
				// 4.轉至適當畫面
				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
				rd.forward(request, response);
				return;
			} else if (type.equals("byExpiretime")) {
				DonationSearchService donationSearchService = new DonationSearchService();
				List<DonationBeanDuplicate> dbdList = donationSearchService.searchByExpiretime();
				
				request.setAttribute("AllDemands", dbdList);
				
				// 4.轉至適當畫面
				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
				rd.forward(request, response);
				return;
			} else if (type.equals("byDemandtime")) {
				DonationSearchService donationSearchService = new DonationSearchService();
				List<DonationBeanDuplicate> dbdList = donationSearchService.searchByDemandtime();
				
				request.setAttribute("AllDemands", dbdList);
				
				// 4.轉至適當畫面
				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}

}

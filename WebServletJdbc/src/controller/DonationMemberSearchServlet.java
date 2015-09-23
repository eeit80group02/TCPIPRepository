package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationBeanDuplicate;
import model.DonationService;
import model.service.DonationSearchService;

//@WebServlet("/DonationSearchServlet")
public class DonationMemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.isNew()) {
			System.out.println("新session");
		} else {
			System.out.println("同session");
		}
//		if(session == null) {
//			// ...
//			System.out.println("session: "+session);
//		}
		
		// 1.接收資料
		String supplyStatus = request.getParameter("supplyStatus");
		String schoolIdStr = request.getParameter("schoolId");
		int schoolId = 0;
		String type = request.getParameter("type");
		String range = request.getParameter("range");
		
		// 2.轉換資料
		if (schoolIdStr != null) {
			schoolId = Integer.parseInt(schoolIdStr);
		}
		
		if (supplyStatus != null) {
			DonationSearchService donationSearchService = new DonationSearchService();
			List<DonationBeanDuplicate> dbdList;
			if (range != null) {
				dbdList = donationSearchService.searchSchoolByStatus(supplyStatus, schoolId);
//				request.setAttribute("AllDemands", dbdList);
				session.setAttribute("OneAllDemands", dbdList);
				
				// 4.轉至適當畫面
//				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//				rd.forward(request, response);
//				return;
				response.sendRedirect(response.encodeRedirectURL(request
						.getContextPath()+"/donation/AllDeamndByMember.jsp"));
				return;
			} else {
				dbdList = donationSearchService.searchByStatus(supplyStatus);
//				request.setAttribute("AllDemands", dbdList);
				session.setAttribute("AllDemands", dbdList);
				
				// 4.轉至適當畫面
//				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//				rd.forward(request, response);
//				return;
				response.sendRedirect(response.encodeRedirectURL(request
						.getContextPath()+"/donation/FindGoods.jsp"));
				return;
			}
//			
		
		} else if(type != null) {
			if (type.equals("byAmount")){
				DonationSearchService donationSearchService = new DonationSearchService();
				
				List<DonationBeanDuplicate> dbdList;
				if (range != null) {
					dbdList = donationSearchService.searchSchoolByOriginalDemandNumber(schoolId);
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("OneAllDemands", dbdList);
					
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/AllDeamndByMember.jsp"));
					return;
				} else {
					dbdList = donationSearchService.searchByOriginalDemandNumber();
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("AllDemands", dbdList);
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/FindGoods.jsp"));
					return;
				}
				
				
				
				
			} else if (type.equals("byExpiretime")) {
				DonationSearchService donationSearchService = new DonationSearchService();
				List<DonationBeanDuplicate> dbdList;
				if (range != null) {
					dbdList = donationSearchService.searchSchoolByExpiretime(schoolId);
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("OneAllDemands", dbdList);
					
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/AllDeamndByMember.jsp"));
					return;
				} else {
					dbdList = donationSearchService.searchByExpiretime();
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("AllDemands", dbdList);
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/FindGoods.jsp"));
					return;
				}
			
			} else if (type.equals("byDemandtime")) {
				DonationSearchService donationSearchService = new DonationSearchService();
				List<DonationBeanDuplicate> dbdList;
				if (range != null) {
					dbdList = donationSearchService.searchSchoolByDemandtime(schoolId);
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("OneAllDemands", dbdList);
					
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/AllDeamndByMember.jsp"));
					return;
				} else {
					dbdList = donationSearchService.searchByDemandtime();
//					request.setAttribute("AllDemands", dbdList);
					session.setAttribute("AllDemands", dbdList);
					// 4.轉至適當畫面
//					RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//					rd.forward(request, response);
//					return;
					response.sendRedirect(response.encodeRedirectURL(request
							.getContextPath()+"/donation/FindGoods.jsp"));
					return;
				}
			}
		}
	}

}

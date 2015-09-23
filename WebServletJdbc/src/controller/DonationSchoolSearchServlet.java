package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationBeanDuplicate;
import model.DonationOrderDuplicateBean;
import model.DonationService;
import model.SchoolBean;
import model.service.DonationSearchService;

//@WebServlet("/DonationSchoolSearchServlet")
public class DonationSchoolSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("LoginOK");
		int schoolId = 0;
		if(obj instanceof SchoolBean) {
			SchoolBean sBean = (SchoolBean) session.getAttribute("LoginOK");
			schoolId = sBean.getSchoolId();
		}
		
		String supplyStatus = request.getParameter("supplyStatus");
		System.out.println("supplyStatus "+supplyStatus);
		String type = request.getParameter("type");
		System.out.println("type "+type);
		String range = request.getParameter("range");
		System.out.println("range "+range);
		
		if (supplyStatus != null) {
			DonationSearchService donationSearchService = new DonationSearchService();
			List<DonationBeanDuplicate> dbdList;
			if (range != null) {
				dbdList = donationSearchService.manageSchoolByStatus(supplyStatus, schoolId);
//				request.setAttribute("AllDemands", dbdList);
				session.setAttribute("OneAllDemands", dbdList);
				
				// 捐獻明細資料
				DonationService service = new DonationService();
				List<DonationOrderDuplicateBean> detailList = service.findOneAllDeamndOrderDetailBySchool(schoolId);
				session.setAttribute("OneAllDetails", detailList);
				// 4.轉至適當畫面
//				RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
//				rd.forward(request, response);
//				return;
				response.sendRedirect(response.encodeRedirectURL(request
						.getContextPath()+"/donation/AllDeamndBySchool.jsp"));
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

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import model.DonationOrderBean;
import model.DonationOrderDetailBean;
import model.DonationService;

//@WebServlet("/OrderAccess")
public class OrderAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// session...
		
		// member
		int memberId = 5;
		// cart...
		HttpSession session = request.getSession();
		DonationCart dCart = (DonationCart) session.getAttribute("DonationCart");
		if (dCart == null) {
			//...
			dCart = new DonationCart();
			session.setAttribute("DonationCart", dCart);
		}
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String cellPhone = request.getParameter("cellPhone");
		String email = request.getParameter("email");
		String pickTime = request.getParameter("pickTime");
		String donationOederDate = request.getParameter("donationOederDate");
		String dealId = request.getParameter("dealId");
		
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
		donationOrderBean.setDealId("kfc1122");
		
		// 3.呼叫Model
		DonationService ds = new DonationService();
		ds.bookingOrder(donationOrderBean, dCart);
		
		// 清空 cart
		dCart.remove();

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
}

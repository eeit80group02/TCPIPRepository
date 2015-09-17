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

//@WebServlet("/FinallCheckCartServlet")
public class FinallCheckCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 驗證 session
		HttpSession session = request.getSession();
		if (session == null) {
			//...
		}
		// 驗證 cart
		DonationCart donationCart = (DonationCart) session.getAttribute("DonationCart");
		if (donationCart == null) {
			//...
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ExpressDelivery.jsp");
		rd.forward(request, response);
		
	}

}

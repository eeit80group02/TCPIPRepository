package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import model.SchoolService;

import org.json.simple.JSONArray;

//@WebServlet("/DonationGoogleServlet")
public class DonationGoogleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchDonation = request.getParameter("searchDonation");
		System.out.println("searchDonation = "+searchDonation);
		
		// 3.呼叫Model
		SchoolService sService = new SchoolService();
		int schoolId = sService.getSchoolIdByName(searchDonation);
		System.out.println("schoolId "+schoolId);
		DonationService dService = new DonationService();
		List<DonationBeanDuplicate> listdbd = dService.findOneAllDeamndByMember(schoolId);
		System.out.println("listdbd = "+listdbd);
		
		HttpSession session = request.getSession();
		session.setAttribute("OneAllDemands", listdbd);
		
		// 5.
		RequestDispatcher rd = request.getRequestDispatcher("AllDeamndByMember.jsp");
		rd.forward(request, response);
		return;
	}
}

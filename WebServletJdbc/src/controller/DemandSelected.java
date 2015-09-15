package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.DonationDiscussBeanDuplicate;
import model.DonationDiscussService;
import model.DonationService;

//@WebServlet("/OneDemand")
public class DemandSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		Map<String, String> errorMsgs = new HashMap<>();
		
		// 1.接收資料
		String type = request.getParameter("type");
		String schoolIdStr = request.getParameter("schoolId");
		String donationIdStr = request.getParameter("donationId");
		
		if (type.equals("FindGoods")) {
			// 3.呼叫Model
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> listDuplivate = service.findDemandsByMember();
			request.setAttribute("AllDemands", listDuplivate);
			
			// 4.轉至適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
			rd.forward(request, response);
			return;
			
		} else if (type.equals("AllDeamndByMember")) {
			
			
			// 2.資料轉換
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> list = service.findOneAllDemands(schoolId);
			request.setAttribute("OneAllDemands", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndByMember.jsp");
			rd.forward(request, response);
			return;
			
		} else if (type.equals("OneDemandByMember")) {
			// 2.資料轉換
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			/* 單一需求內容 */
			DonationBeanDuplicate donationBeanDuplicate  = service.findOneDemand(donationId, schoolId);
			
			/* 留言處理 */
			DonationDiscussService donationDiscussService = new DonationDiscussService();
			List<DonationDiscussBeanDuplicate> discussList = donationDiscussService.getOneDonationAllMessages(donationId);
			
			request.setAttribute("AllMessages", discussList);
			request.setAttribute("OneDemand", donationBeanDuplicate);
			RequestDispatcher rd = request.getRequestDispatcher("OneDemandByMember.jsp");
			rd.forward(request, response);
			return;
			
		}else if (type.equals("AllDeamndBySchool")) {
			// 2.資料轉換
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> list = service.findOneAllDemands(schoolId);
			
			request.setAttribute("OneAllDemands", list);
			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndBySchool.jsp");
			rd.forward(request, response);
			return;
			
		} else if (type.equals("OneDeamndBySchool")) {
			// 2.資料轉換
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			/* 需求內容 */
			DonationBeanDuplicate donationBeanDuplicate  = service.findOneDemand(donationId, schoolId);
			
			/* 留言內容*/
			DonationDiscussService donationDiscussService = new DonationDiscussService();
			List<DonationDiscussBeanDuplicate> discussList = donationDiscussService.getOneDonationAllMessages(donationId);
			
			/* 捐獻會員*/
			
			
			request.setAttribute("AllMessages", discussList);
			request.setAttribute("OneDemand", donationBeanDuplicate);
			RequestDispatcher rd = request.getRequestDispatcher("OneDeamndBySchool.jsp");
			rd.forward(request, response);
			return;
			
		} else if (type.equals("UpdateOneDemand")) {
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			DonationBean donationBean = new DonationBean();
			DonationService service = new DonationService();
			DonationBeanDuplicate donationBeanDuplicate = service.findOneDemand(donationId, schoolId);
			request.setAttribute("OneDemand", donationBeanDuplicate);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateOneDemand.jsp");
			rd.forward(request, response);
			return;
		}
	}
}

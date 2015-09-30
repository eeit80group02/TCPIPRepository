package controller;

import global.GlobalService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.DonationCart;
import model.DonationDiscussBeanDuplicate;
import model.DonationDiscussService;
import model.DonationOrderBean;
import model.DonationOrderDuplicateBean;
import model.DonationService;
import model.SchoolBean;

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
		
		HttpSession session = request.getSession();
		if (session.isNew()) {
			System.out.println("產生session");
		} else {
			System.out.println("同session");
		}
		
		// 驗證購物車
		DonationCart dCart = (DonationCart) session.getAttribute("DonationCart");
		if (dCart == null) {
			dCart = new DonationCart();
			session.setAttribute("DonationCart", dCart);
		}
		
		// 1.接收資料
		String type = request.getParameter("type");
		String schoolIdStr = request.getParameter("schoolId");
		String donationIdStr = request.getParameter("donationId");
		if (type.equals("FindGoods")) {
			// 3.呼叫Model
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> listDuplivate = service.findDemandsByMember();
			List<String> list = dCart.getDonationIdList();
			
//			request.setAttribute("AllDemands", listDuplivate);
			session.setAttribute("AllDemands", listDuplivate);
//			session.setAttribute("cartItems", list);
			
			// 4.轉至適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("FindGoods.jsp");
			rd.forward(request, response);
			return;
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/FindGoods.jsp"));
//			return;
			
		} else if (type.equals("AllDeamndByMember")) {
			// 2.資料轉換
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> listdbd = service.findOneAllDeamndByMember(schoolId);
			List<String> list = dCart.getDonationIdList();
			
//			request.setAttribute("OneAllDemands", list);
			session.setAttribute("OneAllDemands", listdbd);
//			session.setAttribute("cartItems", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndByMember.jsp");
			rd.forward(request, response);
			return;
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/AllDeamndByMember.jsp"));
//			return;
			
		} else if (type.equals("OneDemandByMember")) {
			// 2.資料轉換
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			
			/* 單一需求內容 */
			DonationBeanDuplicate donationBeanDuplicate  = service.findOneDemand(donationId);
//			System.out.println("time1 "+donationBeanDuplicate.getDemandTime());
//			System.out.println("time2 "+donationBeanDuplicate.getExpireTime());
			
			/* 留言處理 */
			DonationDiscussService donationDiscussService = new DonationDiscussService();
			List<DonationDiscussBeanDuplicate> discussList = donationDiscussService.getOneDonationAllMessages(donationId);
			
//			request.setAttribute("AllMessages", discussList);
//			request.setAttribute("OneDemand", donationBeanDuplicate);
			session.setAttribute("AllMessages", discussList);
			session.setAttribute("OneDemand", donationBeanDuplicate);
			RequestDispatcher rd = request.getRequestDispatcher("OneDemandByMember.jsp");
			rd.forward(request, response);
			return;
//			response.sendRedirect(response.encodeRedirectURL(request
//					.getContextPath()+"/donation/OneDemandByMember.jsp"));
//			return;
			
		}else if (type.equals("AllDeamndBySchool")) {
			// 2.資料轉換
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			// 捐獻資料
			DonationService service = new DonationService();
			List<DonationBeanDuplicate> list = service.findOneAllDeamndBySchool(schoolId);
			
			// 捐獻明細資料
			List<DonationOrderDuplicateBean> detailList = service.findOneAllDeamndOrderDetailBySchool(schoolId);

//			request.setAttribute("OneAllDemands", list);
			session.setAttribute("OneAllDemands", list);
			session.setAttribute("OneAllDetails", detailList);
//			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndBySchool.jsp");
//			rd.forward(request, response);
//			return;
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/AllDeamndBySchool.jsp"));
			return;
			
		} else if (type.equals("OneDeamndBySchool")) {
			// 2.資料轉換
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			// 3.呼叫Model
			DonationService service = new DonationService();
			/* 需求內容 */
			DonationBeanDuplicate donationBeanDuplicate  = service.findOneDemand(donationId);
			
			/* 留言內容*/
			DonationDiscussService donationDiscussService = new DonationDiscussService();
			List<DonationDiscussBeanDuplicate> discussList = donationDiscussService.getOneDonationAllMessages(donationId);
			
//			request.setAttribute("AllMessages", discussList);
//			request.setAttribute("OneDemand", donationBeanDuplicate);
			session.setAttribute("AllMessages", discussList);
			session.setAttribute("OneDemand", donationBeanDuplicate);
//			RequestDispatcher rd = request.getRequestDispatcher("OneDeamndBySchool.jsp");
//			rd.forward(request, response);
//			return;
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/OneDeamndBySchool.jsp"));
			return;
			
		} else if (type.equals("UpdateOneDemand")) {
			int donationId = Integer.parseInt(donationIdStr);
			int schoolId = Integer.parseInt(schoolIdStr);
			
			
			DonationService service = new DonationService();
			DonationBeanDuplicate donationBeanDuplicate = service.findOneDemand(donationId);
			
			DonationBean donationBean = new DonationBean();
			donationBean = service.findOneDemandPicture(donationId);

			byte[] image = donationBean.getImageFile();
			System.out.println("image= "+image);
			String imageName = donationBean.getImageName();
			System.out.println("imageName= "+imageName);
			String ImageBase64 = GlobalService.convertByteArrayToBase64String(imageName, image);
			System.out.println("ImageBase64= "+ImageBase64);
//			request.setAttribute("OneDemand", donationBeanDuplicate);
			session.setAttribute("OneDemand", donationBeanDuplicate);
			session.setAttribute("UpdateImage", ImageBase64);
//			RequestDispatcher rd = request.getRequestDispatcher("UpdateOneDemand.jsp");
//			rd.forward(request, response);
//			return;
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/UpdateOneDemand.jsp"));
			return;
		}
	}
}

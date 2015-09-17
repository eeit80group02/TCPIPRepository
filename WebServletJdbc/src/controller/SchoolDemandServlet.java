package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OffersBean;
import model.SchoolDemandBean;
import model.service.SchoolDemandService;

@WebServlet("/schoolDemand/SchoolDemandServlet.do")
public class SchoolDemandServlet extends HttpServlet {

	private SchoolDemandService service;

	@Override
	public void init() throws ServletException {
		service = new SchoolDemandService();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);

		String type = request.getParameter("type");

		if (type == null || type.trim().length() == 0) {
			errorMsg.put("errorURL", "請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
			return;
		} else {
			if (type.equals("create")) {
				// 因為表單必須 post
				if (request.getMethod().equals("POST")) {
					System.out
							.println("執行SchoolDemandServlet creatSchoolDemand");
					creatSchoolDemand(request, response);
				} else {
					errorMsg.put("errorURL",
							"請勿做作不正當請求(PrimaryProjServlet line.70(必須post))");
					request.getRequestDispatcher("/error.jsp").forward(request,
							response);
					return;
				}
			} else if (type.equals("update")) {
				System.out.println("執行SchoolDemandServlet update");
				updateSchoolDemand(request, response);
			} else if (type.equals("displayAll")) {
				System.out.println("執行 SchoolDemandServlet displayAll");
				displayAll(request, response);
			} else if (type.equals("display")) {
				System.out.println("執行 SchoolDemandServlet display");
				display(request, response);
			} else if (type.equals("displayPersonalAll")) {
				System.out.println("執行 SchoolDemandServlet displayPersonalAll");
				displayPersonalAll(request, response);
			} else if (type.equals("displayPersonalRender")) {
				System.out.println("執行 SchoolDemandServlet displayPersonalRender");
				displayPersonalRender(request, response);
			} else if (type.equals("displayPersonalUnrender")) {
				System.out.println("執行 SchoolDemandServlet displayPersonalUnrender");
				displayPersonalUnrender(request, response);
			} else if (type.equals("displayPersonalEnd")) {
				System.out.println("執行 SchoolDemandServlet displayPersonalEnd");
				displayPersonalEnd(request, response);
			} else if (type.equals("displayPersonalFail")) {
				System.out
						.println("執行 SchoolDemandServlet displayPersonalFail");
				displayPersonalFail(request, response);
			} else {
				errorMsg.put("errorURL",
						"請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
				return;
			}
		}
	}

	public void creatSchoolDemand(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMsg = new HashMap<String, String>();
		SchoolDemandBean bean = new SchoolDemandBean();
		OffersBean oBean = new OffersBean();
		HttpSession session = request.getSession();
		request.setAttribute("error", errorMsg);
		System.out.println("----------------------------------Star CreatSchoolDemand----------------------------------");

		// 取值

		String schoolId = (String)session.getAttribute("schoolId");
		String participant = request.getParameter("participant");
		String activityTopic = request.getParameter("activityTopic");
		String activityLocation = request.getParameter("activityLocation");
		String activitySuitable = request.getParameter("activitySuitable");
		String activityHost = request.getParameter("activityHost");
		String activityContact = request.getParameter("activityContact");
		String content = request.getParameter("content");
		String room = request.getParameter("room");
		String place = request.getParameter("place");
		String food = request.getParameter("food");
		
		// 檢查使用者是否輸入
		if(schoolId == null || schoolId.trim().length()==0){
			errorMsg.put("schoolId", "錯誤");
		}
		if (participant == null || participant.trim().length() == 0) {
			errorMsg.put("participant", "必填");
		}
		if (activityTopic == null || activityTopic.trim().length() == 0) {
			errorMsg.put("activityTopic", "必填");
		}
		if (activityLocation == null || activityLocation.trim().length() == 0) {
			errorMsg.put("activityLocation", "必填");
		}
		if (activitySuitable == null || activitySuitable.trim().length() == 0) {
			errorMsg.put("activitySuitable", "必填");
		}
		if (activityHost == null || activityHost.trim().length() == 0) {
			errorMsg.put("activityHost", "必填");
		}
		if (activityContact == null || activityContact.trim().length() == 0) {
			errorMsg.put("activityContact", "必填");
		}
		if (content == null || content.trim().length() == 0) {
			errorMsg.put("content", "必填");
		}

		// 資料轉換格式判斷
		int sId = 0;
		if (schoolId != null) {
			try {
				sId = Integer.parseInt(schoolId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int people = 0;
		try {
			people = Integer.parseInt(participant);
			if (people <= 0) {
				errorMsg.put("participant", "人數要大於零");
			}
		} catch (Exception e) {
			errorMsg.put("participant", "資料有誤");
		}
		if (activityTopic.length() > 30) {
			errorMsg.put("activityTopic", "輸入長度有問題");
		}
		if (activityLocation.length() > 30) {
			errorMsg.put("activityLocation", "輸入長度有問題");
		}
		if (activitySuitable.length() > 30) {
			errorMsg.put("activitySuitable", "輸入長度有問題");
		}
		if (activityHost.length() > 30) {
			errorMsg.put("activityHost", "輸入長度有問題");
		}
		if (activityContact.length() > 20) {
			errorMsg.put("activityContact", "輸入長度有問題");
		}
		if (content.length() > 20) {
			errorMsg.put("content", "輸入長度有問題");
		}
		
		boolean checkRoom = false;
		if(room == null){
			checkRoom = false;
		}else if(room.equals("on")){
			checkRoom = true;
		}
		boolean checkPlace = false;
		if(place == null){
			checkPlace = false;
		}else if(place.equals("on")){
			checkPlace = true;
		}
		boolean checkFood = false;
		if(food ==null){
			checkFood = false;
		}else if(food.equals("on")){
			checkFood = true;
		}
		
		if (!errorMsg.isEmpty()) {
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request, response);
			return;
		}
		
		// 存值進入Bean
		oBean.setFood(checkFood);
		oBean.setPlace(checkPlace);
		oBean.setRoom(checkRoom);

		// 存值進入Bean
		bean.setSchoolId(sId);
		bean.setParticipant(people);
		bean.setActivityTopic(activityTopic);
		bean.setActivityLocation(activityLocation);
		bean.setActivitySuitable(activitySuitable);
		bean.setActivityHost(activityHost);
		bean.setActivityContact(activityContact);
		bean.setContent(content);
		bean.setOfferBean(oBean);

		// 呼叫Service方法
		bean = service.creatSchoolDemand(bean);

		if (bean != null) {
			System.out.println("建立成功bean=" + bean);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		} else {
			System.out.println("建立失敗");
		}
	}

	public void updateSchoolDemand(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star UpdateSchoolDemand----------------------------------");

		SchoolDemandBean bean = new SchoolDemandBean();
		OffersBean obean = new OffersBean();
		Map<String, String> errorMsg = new HashMap<String, String>();
		
		// 取值
		String schoolDemandId = request.getParameter("schoolDemandId");
		bean.setSchoolDemandId(27);
		bean = service.display(bean);
		request.setAttribute("bean", bean);
		if(bean!=null){
			request.getRequestDispatcher("UpdataSchoolDemand.jsp").forward(request, response);
			return;
		}
		String schoolId = request.getParameter("schoolId");
		String participant = request.getParameter("participant");
		String activityTopic = request.getParameter("activityTopic");
		String activityLocation = request.getParameter("activityLocation");
		String activitySuitable = request.getParameter("activitySuitable");
		String activityHost = request.getParameter("activityHost");
		String activityContact = request.getParameter("activityContact");
		String content = request.getParameter("content");
		String room = request.getParameter("room");
		String place = request.getParameter("place");
		String food = request.getParameter("food");

		// 檢查使用者是否輸入
		if (participant == null || participant.trim().length() == 0) {
			errorMsg.put("participant", "必填");
		}
		if (activityTopic == null || activityTopic.trim().length() == 0) {
			errorMsg.put("activityTopic", "必填");
		}
		if (activityLocation == null || activityLocation.trim().length() == 0) {
			errorMsg.put("activityLocation", "必填");
		}
		if (activitySuitable == null || activitySuitable.trim().length() == 0) {
			errorMsg.put("activitySuitable", "必填");
		}
		if (activityHost == null || activityHost.trim().length() == 0) {
			errorMsg.put("activityHost", "必填");
		}
		if (activityContact == null || activityContact.trim().length() == 0) {
			errorMsg.put("activityContact", "必填");
		}
		if (content == null || content.trim().length() == 0) {
			errorMsg.put("content", "必填");
		}

		// 資料轉換格式判斷
		int sDId = 0;
		if (schoolDemandId != null) {
			try {
				sDId = Integer.parseInt(schoolDemandId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int sId = 0;
		if (schoolId != null) {
			try {
				sId = Integer.parseInt(schoolId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int people = 0;
		try {
			people = Integer.parseInt(participant);
			if (people <= 0) {
				errorMsg.put("participant", "人數要大於零");
			}
		} catch (Exception e) {
			errorMsg.put("participant", "資料有誤");
		}
		if (activityTopic.length() > 30) {
			errorMsg.put("activityTopic", "輸入長度有問題");
		}
		if (activityLocation.length() > 30) {
			errorMsg.put("activityLocation", "輸入長度有問題");
		}
		if (activitySuitable.length() > 30) {
			errorMsg.put("activitySuitable", "輸入長度有問題");
		}
		if (activityHost.length() > 30) {
			errorMsg.put("activityHost", "輸入長度有問題");
		}
		if (activityContact.length() > 20) {
			errorMsg.put("activityContact", "輸入長度有問題");
		}
		boolean checkRoom = false;
		try {
			checkRoom = Boolean.parseBoolean(room);
		} catch (Exception e) {
			System.out.println("checkRoom");
		}
		boolean checkPlace = false;
		try {
			checkPlace = Boolean.parseBoolean(place);
		} catch (Exception e) {
			System.out.println("checkPlace");
		}
		boolean checkFood = false;
		try {
			checkFood = Boolean.parseBoolean(food);
		} catch (Exception e) {

			if (!errorMsg.isEmpty()) {
				request.getRequestDispatcher("UpdataSchoolDemand.jsp").forward(
						request, response);
				return;
			}
			
			obean.setRoom(checkRoom);
			obean.setPlace(checkPlace);
			obean.setFood(checkFood);
			
			// 存入Bean
			bean.setSchoolDemandId(sDId);
			bean.setSchoolId(sId);
			bean.setParticipant(people);
			bean.setActivityTopic(activityTopic);
			bean.setActivityLocation(activityLocation);
			bean.setActivitySuitable(activitySuitable);
			bean.setActivityHost(activityHost);
			bean.setActivityContact(activityContact);
			bean.setContent(content);
			bean.setOfferBean(obean);

			// 呼叫Service方法
			bean = service.updateSchoolDemand(bean);

			if (bean != null) {
				System.out.println("更新成功bean=" + bean);
				request.getRequestDispatcher("UpdataSchoolDemand.jsp").forward(
						request, response);
			} else {
				System.out.println("更新失敗");
			}
		}
	}

	public void displayAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayAll----------------------------------");
		List<SchoolDemandBean> result = null;
		result = service.displayAll();
		System.out.println(result.size());
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayAll.jsp").forward(request,response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void display(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("----------------------------------Star DisplaySchoolDemand----------------------------------");

		Map<String, String> errorMsg = new HashMap<String, String>();
		SchoolDemandBean bean = new SchoolDemandBean();

		// 取值
		String schoolDemandId = request.getParameter("schoolDemandId");

		// 格式轉換判斷
		if (schoolDemandId == null || schoolDemandId.trim().length() == 0) {
			errorMsg.put("", "錯誤");
		}
		int sDId = 0;
		try {
			sDId = Integer.parseInt(schoolDemandId);
		} catch (Exception e) {
			errorMsg.put("", "錯誤");
		}

		if (!errorMsg.isEmpty()) {
			request.getRequestDispatcher("Display.jsp").forward(request,
					response);
			return;
		}

		// 存入Bean
		bean.setSchoolDemandId(1);

		// 呼叫Service方法
		bean = service.display(bean);

		System.out.println(bean);
		request.setAttribute("bean", bean);

		if (bean != null) {
			System.out.println("成功查詢bean=" + bean);
			request.getRequestDispatcher("Display.jsp").forward(request,
					response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void displayPersonalAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayAllPersonal----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		String schoolId = (String) session.getAttribute("schoolId");
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		bean.setSchoolId(sId);
		result = service.displayPersonalAll(bean);
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayAllPersonal.jsp").forward(
					request, response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void displayPersonalRender(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalRender----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		String schoolId = (String) session.getAttribute("schoolId");
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		bean.setSchoolId(sId);
		result = service.displayPersonalRender(bean);
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayPersonalRender.jsp").forward(
					request, response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void displayPersonalUnrender(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalUnrender----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		String schoolId = (String) session.getAttribute("schoolId");
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		bean.setSchoolId(sId);
		result = service.displayPersonalUnrender(bean);
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayPersonalUnrender.jsp")
					.forward(request, response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void displayPersonalEnd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalEnd----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		String schoolId = (String) session.getAttribute("schoolId");
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		bean.setSchoolId(sId);
		result = service.displayPersonalEnd(bean);
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayPersonalEnd.jsp").forward(
					request, response);
		} else {
			System.out.println("查詢失敗");
		}
	}

	public void displayPersonalFail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalEnd----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		String schoolId = (String) session.getAttribute("schoolId");
		int sId = 0;
		try {
			sId = Integer.parseInt(schoolId);
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		bean.setSchoolId(sId);
		result = service.displayPersonalFail(bean);
		request.setAttribute("list", result);
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			request.getRequestDispatcher("DisplayPersonalFail.jsp").forward(
					request, response);
		} else {
			System.out.println("查詢失敗");
		}
	}
}

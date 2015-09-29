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

import model.MemberBean;
import model.OffersBean;
import model.SchoolBean;
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
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		} else {
			if (type.equals("create")) {
				// 因為表單必須 post
				if (request.getMethod().equals("POST")) {
					System.out.println("create");
					creat(request, response);
				} else {
					errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.70(必須post))");
					request.getRequestDispatcher("/error.jsp").forward(request,response);
					return;
				}
			} else if (type.equals("update")) {
				System.out.println("update");
				update(request, response);
			} else if (type.equals("updateDisplay")) {
				System.out.println("updateDisplay");
				updateDisplay(request, response);
			} else if (type.equals("display")) {
				System.out.println("display");
				display(request, response);
			} else if (type.equals("displays")) {
				System.out.println("displays");
				displays(request, response);
			} else if (type.equals("displayPersonalRender")) {
				System.out.println("displayPersonalRender");
				displayPersonalRender(request, response);
			} else if (type.equals("displayPersonalUnrender")) {
				System.out.println("displayPersonalUnrender");
				displayPersonalUnrender(request, response);
			} else if (type.equals("mdisplay")) {
				System.out.println("mdisplay");
				mdisplay(request, response);
			} else if (type.equals("mdisplays")) {
				System.out.println("mdisplays");
				mdisplays(request, response);
			}else {
				errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
				return;
			}
		}
	}

	public void creat(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------新增----------------------------------");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> data = new HashMap<String, String>();
		SchoolDemandBean bean = new SchoolDemandBean();
		OffersBean oBean = new OffersBean();
		HttpSession session = request.getSession();

		session.removeAttribute("error");
		session.removeAttribute("data");
		//取得Session
		SchoolBean sBean = (SchoolBean) session.getAttribute("LoginOK");
		if(sBean == null){
			//導入登入頁面
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		int schoolId = sBean.getSchoolId();	
		//取值
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
		
		data.put("participant", participant);
		data.put("activityTopic", activityTopic);
		data.put("activityLocation", activityLocation);
		data.put("activitySuitable", activitySuitable);
		data.put("activityHost", activityHost);
		data.put("activityContact", activityContact);
		data.put("content", content);
		
		if(room !=null){
			if(room.equals("on")){
				room = "true";
				data.put("room", room);
			}
		}
		data.put("room", room);
		if(place !=null){
			if(place.equals("on")){
				place = "true";
				data.put("place", place);
			}
		}
		data.put("place", place);
		
		if(food !=null){
			if(food.equals("on")){
				food = "true";
				data.put("food", food);
			}
		}
		data.put("food", food);
		
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
		int people = 0;
		if(!errorMsg.containsKey("participant")){
			try {
				people = Integer.parseInt(participant);
				if (people <= 0) {
					errorMsg.put("participant", "人數要大於零");
				}
			} catch (Exception e) {
				errorMsg.put("participant", "資料有誤");
			}
		}
		if(!errorMsg.containsKey("activityTopic")){
			if (activityTopic.length() > 30) {
				errorMsg.put("activityTopic", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityLocation")){
			if (activityLocation.length() > 30) {
				errorMsg.put("activityLocation", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activitySuitable")){
			if (activitySuitable.length() > 30) {
				errorMsg.put("activitySuitable", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityHost")){
			if (activityHost.length() > 30) {
				errorMsg.put("activityHost", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityContact")){
			if (activityContact.length() > 100) {
				errorMsg.put("activityContact", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("content")){
			if (content.length() > 500) {
				errorMsg.put("content", "輸入長度有問題");
			}
		}

		boolean checkRoom = false;
		if (room == null) {
			checkRoom = false;
		} else {
			checkRoom = true;
		}
		boolean checkPlace = false;
		if (place == null) {
			checkPlace = false;
		} else {
			checkPlace = true;
		}
		boolean checkFood = false;
		if (food == null) {
			checkFood = false;
		} else {
			checkFood = true;
		}
		if (!errorMsg.isEmpty()) {
			session.setAttribute("error", errorMsg);
			session.setAttribute("data", data);
			System.out.println(data);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/CreatSchoolDemand.jsp");
			return;
		}

		session.removeAttribute("error");
		session.setAttribute("data", data);
		// 存值進入Bean
		oBean.setFood(checkFood);
		oBean.setPlace(checkPlace);
		oBean.setRoom(checkRoom);

		// 存值進入Bean
		bean.setSchoolId(schoolId);
		bean.setParticipant(people);
		bean.setActivityTopic(activityTopic);
		bean.setActivityLocation(activityLocation);
		bean.setActivitySuitable(activitySuitable);
		bean.setActivityHost(activityHost);
		bean.setActivityContact(activityContact);
		bean.setContent(content);
		bean.setOfferBean(oBean);

		// 呼叫Service方法
		bean = service.creat(bean);

		if (bean != null) {
			System.out.println("建立成功bean=" + bean);
			session.setAttribute("Demand", bean);
			response.sendRedirect("SchoolDemandServlet.do?type=display");
			return;
		} else {
			errorMsg.put("Error", "計畫需求建立失敗");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
		}
	}

	public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------更新----------------------------------");
		SchoolBean sbean = null;
		SchoolDemandBean bean = new SchoolDemandBean();
		OffersBean obean = new OffersBean();
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> data = new HashMap<String, String>();
		HttpSession session = request.getSession();

		sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean == null){
			response.sendRedirect("login.jsp");
		}
		bean = (SchoolDemandBean)session.getAttribute("Demand");
		session.removeAttribute("Demand");

		int schoolDemandId = bean.getSchoolDemandId();
		int schoolId = bean.getSchoolId();
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
	
		
		data.put("participant", participant);
		data.put("activityTopic", activityTopic);
		data.put("activityLocation", activityLocation);
		data.put("activitySuitable", activitySuitable);
		data.put("activityHost", activityHost);
		data.put("activityContact", activityContact);
		data.put("content", content);
		
		if(room !=null){
			if(room.equals("on")){
				room = "true";
				data.put("room", room);
			}
		}
		data.put("room", room);
		if(place !=null){
			if(place.equals("on")){
				place = "true";
				data.put("place", place);
			}
		}
		data.put("place", place);
		
		if(food !=null){
			if(food.equals("on")){
				food = "true";
				data.put("food", food);
			}
		}
		data.put("food", food);
		
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
		int people = 0;
		if(!errorMsg.containsKey("participant")){
			try {
				people = Integer.parseInt(participant);
				if (people <= 0) {
					errorMsg.put("participant", "人數要大於零");
				}
			} catch (Exception e) {
				errorMsg.put("participant", "資料有誤");
			}
		}
		if(!errorMsg.containsKey("activityTopic")){
			if (activityTopic.length() > 30) {
				errorMsg.put("activityTopic", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityLocation")){
			if (activityLocation.length() > 30) {
				errorMsg.put("activityLocation", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activitySuitable")){
			if (activitySuitable.length() > 30) {
				errorMsg.put("activitySuitable", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityHost")){
			if (activityHost.length() > 30) {
				errorMsg.put("activityHost", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("activityContact")){
			if (activityContact.length() > 20) {
				errorMsg.put("activityContact", "輸入長度有問題");
			}
		}
		if(!errorMsg.containsKey("content")){
			if (content.length() > 20) {
				errorMsg.put("content", "輸入長度有問題");
			}
		}

		boolean checkRoom = false;
		if (room == null) {
			checkRoom = false;
		} else {
			checkRoom = true;
		}
		boolean checkPlace = false;
		if (place == null) {
			checkPlace = false;
		} else {
			checkPlace = true;
		}
		boolean checkFood = false;
		if (food == null) {
			checkFood = false;
		} else {
			checkFood = true;
		}
		if (!errorMsg.isEmpty()) {
			session.setAttribute("error", errorMsg);
			session.setAttribute("data", data);
			System.out.println(data);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/CreatSchoolDemand.jsp");
			return;
		}

		session.removeAttribute("error");
		session.setAttribute("data", data);

		obean.setSchoolDemandId(schoolDemandId);
		obean.setRoom(checkRoom);
		obean.setPlace(checkPlace);
		obean.setFood(checkFood);
		System.out.println(obean);
		// 存入Bean
		bean.setSchoolDemandId(schoolDemandId);
		bean.setSchoolId(schoolId);
		bean.setParticipant(people);
		bean.setActivityTopic(activityTopic);
		bean.setActivityLocation(activityLocation);
		bean.setActivitySuitable(activitySuitable);
		bean.setActivityHost(activityHost);
		bean.setActivityContact(activityContact);
		bean.setCreateDate(bean.getCreateDate());
		bean.setContent(content);
		bean.setOfferBean(obean);

		// 呼叫Service方法
		bean = service.update(bean);

		if (bean != null) {
			System.out.println("更新成功bean=" + bean);
			session.setAttribute("Demand", bean);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=display");
		} else {
			System.out.println("更新失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/SchoolDemandServlet.do?type=display");
		}

	}
	public void updateDisplay(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------更新前顯示----------------------------------");
		SchoolDemandBean bean =  new SchoolDemandBean();
		SchoolBean sbean = null;
		HttpSession session = request.getSession();
		sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean==null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		bean = (SchoolDemandBean)session.getAttribute("Demand");
		System.out.println(bean);
		session.removeAttribute("Demand");
		int schoolDemandId = bean.getSchoolDemandId();
		bean.setSchoolDemandId(schoolDemandId);
		bean = service.updateDisplay(bean);
		if(bean!=null){
			System.out.println("查詢成功");
			session.setAttribute("Demand", bean);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/UpdataSchoolDemand.jsp");
		}else{
			System.out.println("查詢失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/UpdataSchoolDemand.jsp");
		}
		
	}
	public void mdisplay(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------會員顯示單筆----------------------------------");
		SchoolDemandBean result = new SchoolDemandBean();
		HttpSession session = request.getSession();
		MemberBean mbean = (MemberBean)session.getAttribute("LoginOK");
		if(mbean==null){
			if(mbean.getMemberId()==null){
				System.out.println("非會員登入");
				response.sendRedirect(request.getContextPath()+"/login/login.jsp");
				return;
			}
		}
		String schoolDemandId = request.getParameter("schoolDemandId");
		String schoolId = request.getParameter("schoolId");

		int sDId = 0;
		int sId = 0;
		try {
			sDId = Integer.parseInt(schoolDemandId);
			sId = Integer.parseInt(schoolId);
		} catch (NumberFormatException e) {
			System.out.println("錯誤");
		}
		result.setSchoolDemandId(sDId);
		result.setSchoolId(sId);
		result = service.mdisplay(result);
		if(result!=null){
			session.setAttribute("mDemand", result);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayForSchool.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"");
		}
		
	}
	public void mdisplays(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------會員顯示待洽談----------------------------------");
		List<SchoolDemandBean> result = null;
		HttpSession session = request.getSession();
		session.removeAttribute("mlist");
		MemberBean mbean = (MemberBean)session.getAttribute("LoginOK");
		if(mbean==null){
			if(mbean.getMemberId()==null){
				System.out.println("非會員登入");
				response.sendRedirect(request.getContextPath()+"/login/login.jsp");
				return;
			}
		}
		result = service.mdisplays(mbean);
		System.out.println(result.size());
		
		if (!result.isEmpty()) {
			System.out.println("成功查詢list=" + result);
			session.setAttribute("mlist", result);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayAll.jsp");
			
		} else {
			System.out.println("查詢失敗   導向登入頁面");   
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayAll.jsp");
		}
	}

	public void display(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("----------------------------------查詢單筆----------------------------------");
		SchoolDemandBean bean = null;
		HttpSession session = request.getSession();
		String sId = "";
		int schoolDemandId = 0;
		// 取值

		SchoolBean sbean = (SchoolBean) session.getAttribute("LoginOK");
		if(sbean == null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		int schoolId = sbean.getSchoolId();
		
		sId = request.getParameter("schoolDemandId");
		if(sId==null){
			bean = (SchoolDemandBean) session.getAttribute("Demand");
			session.removeAttribute("Demand");	
			schoolDemandId = bean.getSchoolDemandId();
		}else {
			try {
				schoolDemandId = Integer.parseInt(sId);
			} catch (Exception e) {
				response.sendRedirect("");
			}
		}
		
		// 存入Bean
		bean = new SchoolDemandBean();
		bean.setSchoolDemandId(schoolDemandId);
		bean.setSchoolId(schoolId);

		// 呼叫Service方法
		bean = service.display(bean);

		if (bean != null) {
			System.out.println("成功查詢bean=" + bean);
			session.setAttribute("Demand", bean);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/Display.jsp");
		} else {
			System.out.println("查詢失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/Display.jsp");
		}
	}

	public void displays(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star 學校查詢全部----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		HttpSession session = request.getSession();
		session.removeAttribute("Demand");
		session.removeAttribute("list");
		SchoolBean sbean = (SchoolBean) session.getAttribute("LoginOK");
		if(sbean == null){
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
			return;
		}
		int schoolId = sbean.getSchoolId();

		bean.setSchoolId(schoolId);
		result = service.displays(bean);
		if (!result.isEmpty()) {
			session.setAttribute("list", result);
			System.out.println("成功查詢list=" + result);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayAllPersonal.jsp");
		} else {
			System.out.println("查詢失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayAllPersonal.jsp");
		}
	}

	public void displayPersonalRender(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalRender----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolBean bean = null;
		HttpSession session = request.getSession();
		session.removeAttribute("list");
		bean = (SchoolBean)session.getAttribute("LoginOK");
		if(bean == null){
			response.sendRedirect("login.jsp");
		}
		result = service.displayPersonalRender(bean);
		request.setAttribute("list", result);
		System.out.println(result.size());
		if (!result.isEmpty()) {
			session.setAttribute("list", result);
			System.out.println("成功查詢list=" + result);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayPersonalRender.jsp");
		} else {
			System.out.println("查詢失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayPersonalRender.jsp");
		}
	}

	public void displayPersonalUnrender(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------------------------Star displayPersonalUnrender----------------------------------");
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		SchoolDemandBean bean = new SchoolDemandBean();
		SchoolBean sbean= null;
		HttpSession session = request.getSession();
		session.removeAttribute("list");
		sbean = (SchoolBean)session.getAttribute("LoginOK");
		if(sbean == null){
			response.sendRedirect("login.jsp");
			return;
		}
		int schoolId = sbean.getSchoolId();
		bean.setSchoolId(schoolId);
		result = service.displayPersonalUnrender(bean);
		if (!result.isEmpty()) {
			session.setAttribute("list", result);
			System.out.println("成功查詢list=" + result);
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayPersonalUnrender.jsp");
			return;
		} else {
			System.out.println("查詢失敗");
			response.sendRedirect(request.getContextPath()+"/schoolDemand/DisplayPersonalUnrender.jsp");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void displayPersonalEnd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out
				.println("----------------------------------Star displayPersonalEnd----------------------------------");
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

	public void displayPersonalFail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out
				.println("----------------------------------Star displayPersonalEnd----------------------------------");
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

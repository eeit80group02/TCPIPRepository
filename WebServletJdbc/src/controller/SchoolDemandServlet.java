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

import model.SchoolDemandBean;
import model.service.SchoolDemandService;
@WebServlet("/schoolDemand/SchoolDemandServlet.do")
public class SchoolDemandServlet extends HttpServlet{
	
	private SchoolDemandService service;
	
	@Override
	public void init() throws ServletException
	{
		service = new SchoolDemandService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String type = request.getParameter("type");
		
		if(type == null || type.trim().length() == 0)
		{
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}else
		{
			if(type.equals("create"))
			{
				// 因為表單必須 post 
				if(request.getMethod().equals("POST"))
				{
					System.out.println("執行SchoolDemandServlet creatSchoolDemand");
					creatSchoolDemand(request,response);
				}
				else
				{
					errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.70(必須post))");
					request.getRequestDispatcher("/error.jsp").forward(request,response);
					return;
				}
			}
			else if(type.equals("update"))
			{
				System.out.println("執行SchoolDemandServlet updateSchoolDemand");
				updateSchoolDemand(request,response);
			}
			else if(type.equals("displayUpdate"))
			{
				System.out.println("執行 PrimaryProjServlet displayUpdatePrimaryProj");
				//displayUpdatePrimaryProj(request,response);
			}
			else if(type.equals("displayAll"))
			{
				System.out.println("執行 PrimaryProjServlet displayPrimaryProjAll");
				displayAllNoChat(request,response);
			}
			else if(type.equals("display"))
			{
				System.out.println("執行 PrimaryProjServlet displayPrimaryProj");
				displaySchoolDemand(request, response);
			}
			else
			{
				errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,response);
				return;
			}
		}
	}
			
	
	public void creatSchoolDemand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map<String,String> errorMsg = new HashMap<String,String>();
		SchoolDemandBean bean = new SchoolDemandBean();
		request.setAttribute("error", errorMsg);
		System.out.println("----------------------------------Star CreatSchoolDemand----------------------------------");
		
		//取值
		String schoolId = request.getParameter("schoolId");
		String participant = request.getParameter("participant");
		String activityTopic = request.getParameter("activityTopic");
		String activityLocation = request.getParameter("activityLocation");
		String activitySuitable = request.getParameter("activitySuitable");
		String activityHost = request.getParameter("activityHost");
		String activityContact = request.getParameter("activityContact");
		String content = request.getParameter("content");

		//檢查使用者是否輸入
		if(participant==null ||participant.trim().length()==0){
			errorMsg.put("participant","必填");
		}
		if(activityTopic==null ||activityTopic.trim().length()==0){
			errorMsg.put("activityTopic","必填");
		}
		if(activityLocation==null ||activityLocation.trim().length()==0){
			errorMsg.put("activityLocation","必填");
		}
		if(activitySuitable==null ||activitySuitable.trim().length()==0){
			errorMsg.put("activitySuitable","必填");
		}
		if(activityHost==null ||activityHost.trim().length()==0){
			errorMsg.put("activityHost","必填");
		}
		if(activityContact==null ||activityContact.trim().length()==0){
			errorMsg.put("activityContact","必填");
		}
		if(content==null ||content.trim().length()==0){
			errorMsg.put("content","必填");
		}
		
		//資料轉換格式判斷
		int sId = 0;
		if(schoolId!=null){
			try {
				sId =Integer.parseInt(schoolId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int people =0;
		try {
			people =Integer.parseInt(participant);
			if(people <=0){
				errorMsg.put("participant", "人數要大於零");
			}
		} catch (Exception e) {
			errorMsg.put("participant", "資料有誤");
		}
		if(activityTopic.length()>30){
			errorMsg.put("activityTopic", "輸入長度有問題");
		}
		if(activityLocation.length()>30){
			errorMsg.put("activityLocation", "輸入長度有問題");
		}
		if(activitySuitable.length()>30){
			errorMsg.put("activitySuitable", "輸入長度有問題");
		}
		if(activityHost.length()>30){
			errorMsg.put("activityHost", "輸入長度有問題");
		}
		if(activityContact.length()>20){
			errorMsg.put("activityContact", "輸入長度有問題");
		}
		if(content.length()>20){
			errorMsg.put("content", "輸入長度有問題");
		}
		
		if(!errorMsg.isEmpty()){
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request,response);
			return;		
		}	
		
		//存值進入Bean
		bean.setSchoolId(11503);
		bean.setParticipant(people);
		bean.setActivityTopic(activityTopic);
		bean.setActivityLocation(activityLocation);
		bean.setActivitySuitable(activitySuitable);
		bean.setActivityHost(activityHost);
		bean.setActivityContact(activityContact);
		bean.setContent(content);
		
		//呼叫Service方法
		bean = service.creatSchoolDemand(bean);
		
		if(bean!=null){
			System.out.println("建立成功bean="+bean);
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request, response);
		}else {
			System.out.println("建立失敗");
		}
	}
	
	public void updateSchoolDemand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------------------------------Star UpdateSchoolDemand----------------------------------");
		
		SchoolDemandBean bean = new SchoolDemandBean();
		Map<String,String> errorMsg = new HashMap<String,String>();
		
		//取值
		String schoolDemandId = request.getParameter("schoolDemandId");
		String schoolId = request.getParameter("schoolId");
		String participant = request.getParameter("participant");
		String activityTopic = request.getParameter("activityTopic");
		String activityLocation = request.getParameter("activityLocation");
		String activitySuitable = request.getParameter("activitySuitable");
		String activityHost = request.getParameter("activityHost");
		String activityContact = request.getParameter("activityContact");
		String content = request.getParameter("content");
		
		//檢查使用者是否輸入
		if(participant==null ||participant.trim().length()==0){
			errorMsg.put("participant","必填");
		}
		if(activityTopic==null ||activityTopic.trim().length()==0){
			errorMsg.put("activityTopic","必填");
		}
		if(activityLocation==null ||activityLocation.trim().length()==0){
			errorMsg.put("activityLocation","必填");
		}
		if(activitySuitable==null ||activitySuitable.trim().length()==0){
			errorMsg.put("activitySuitable","必填");
		}
		if(activityHost==null ||activityHost.trim().length()==0){
			errorMsg.put("activityHost","必填");
		}
		if(activityContact==null ||activityContact.trim().length()==0){
			errorMsg.put("activityContact","必填");
		}
		if(content==null ||content.trim().length()==0){
			errorMsg.put("content","必填");
		}
		
		//資料轉換格式判斷
		int sDId = 0;
		if(schoolDemandId!=null){
			try {
				sDId =Integer.parseInt(schoolDemandId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int sId = 0;
		if(schoolId!=null){
			try {
				sId =Integer.parseInt(schoolId);
			} catch (Exception e) {
				errorMsg.put("", "資料有誤");
			}
		}
		int people =0;
		try {
			people =Integer.parseInt(participant);
			if(people <=0){
				errorMsg.put("participant", "人數要大於零");
			}
		} catch (Exception e) {
			errorMsg.put("participant", "資料有誤");
		}
		if(activityTopic.length()>30){
			errorMsg.put("activityTopic", "輸入長度有問題");
		}
		if(activityLocation.length()>30){
			errorMsg.put("activityLocation", "輸入長度有問題");
		}
		if(activitySuitable.length()>30){
			errorMsg.put("activitySuitable", "輸入長度有問題");
		}
		if(activityHost.length()>30){
			errorMsg.put("activityHost", "輸入長度有問題");
		}
		if(activityContact.length()>20){
			errorMsg.put("activityContact", "輸入長度有問題");
		}
		if(content.length()>20){
			errorMsg.put("content", "輸入長度有問題");
		}
		
		if(!errorMsg.isEmpty()){
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request,response);
			return;		
		}
		
		//存入Bean
		bean.setSchoolDemandId(sDId);
		bean.setSchoolId(sId);
		bean.setParticipant(people);
		bean.setActivityTopic(activityTopic);
		bean.setActivityLocation(activityLocation);
		bean.setActivitySuitable(activitySuitable);
		bean.setActivityHost(activityHost);
		bean.setActivityContact(activityContact);
		bean.setContent(content);
		
		//呼叫Service方法
		bean = service.updateSchoolDemand(bean);
		
		if(bean!=null){
			System.out.println("更新成功bean="+bean);
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request, response);
		}else {
			System.out.println("更新失敗");
		}
	}
	
	public void displaySchoolDemand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------------------------------Star DisplaySchoolDemand----------------------------------");
		
		
		Map<String,String> errorMsg = new HashMap<String,String>();
		SchoolDemandBean bean = new SchoolDemandBean();
		
		//取值
		String schoolDemandId = request.getParameter("schoolDemandId");
		
		//格式轉換判斷
		if(schoolDemandId==null||schoolDemandId.trim().length()==0){
			errorMsg.put("","錯誤");
		}
		int sDId = 0;
		try {
			sDId = Integer.parseInt(schoolDemandId);
		} catch (Exception e) {
			errorMsg.put("","錯誤");
		}
		if(!errorMsg.isEmpty()){
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request,response);
			return;		
		}	
		
		//存入Bean
		bean.setSchoolDemandId(sDId);
		
		//呼叫Service方法
		bean  = service.displaySchoolDemand(bean);
		
		
		request.setAttribute("bean", bean);
		
		if(bean!=null){
			System.out.println("成功查詢bean="+bean);
			request.getRequestDispatcher("CreatSchoolDemand.jsp").forward(request, response);
		}else {
			System.out.println("查詢失敗");
		}
	}
	public void displayAllNoChat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("displayAllNoChat");
		List<SchoolDemandBean> result =new ArrayList<SchoolDemandBean>();
		result = service.displayAllNoChat();
		request.setAttribute("list", result);
		if(!result.isEmpty()){
			System.out.println("成功查詢list="+result);
			request.getRequestDispatcher("DisplaySchoolDemand.jsp").forward(request, response);
		}else {
			System.out.println("查詢失敗");
		}
	}
}

package controller;

import global.GlobalService;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.FullProjBean;
import model.MemberBean;
import model.PrimaryProjBean;
import model.service.FullProjService;

@WebServlet("/fullProj.do")
@MultipartConfig(location = "",
				 maxFileSize = 1024 * 1024 * 2)
public class FullProjServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private FullProjService service;

	@Override
	public void init() throws ServletException
	{
		service = new FullProjService();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		String type = request.getParameter("type");
		
		if(type == null || type.trim().length() == 0)
		{
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
		else
		{
			if(type.equals("update"))
			{
				System.out.println("執行 FullProjServlet updateFullProj");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				updateFullProj(request,response);
			}
			// 欲 補齊完整計畫頁面
			else if(type.equals("displayFullProjByChat"))
			{
				System.out.println("執行FullProjServlet displayFullProjByChat[欲補齊完整計畫]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayFullProjByChat(request,response);
			}
			// 瀏覽所有招募中的完整計畫[type=displayAll]
			else if(type.equals("displayAll"))
			{
				System.out.println("執行 FullProjServlet displayFullProjAll");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayFullProjAll(request,response);
			}
			// 看單一完整計畫[type=display&fullId=?]
			else if(type.equals("display"))
			{
				System.out.println("執行 FullProjServlet displayFullProj[單一完整計畫]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayFullProj(request,response);
			}
			// 個人專區，查詢發布過的全部完整計畫
			else if(type.equals("displayPersonal"))
			{
				System.out.println("執行 FullProjServlet displayPersonalFullProj[個人完整計畫列表]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());

				displayPersonalFullProj(request,response);
			}
			// 在個人頁面顯示  需跟學校洽談補齊的計劃[type=displayPersonalByChat]
			else if(type.equals("displayPersonalByChat"))
			{
				System.out.println("執行 FullProjServlet displayPersonalFullProjByChat[需洽談的完整計劃列表]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayPersonalFullProjByChat(request,response);
			}
			// 補齊計畫頁面
//			else if(type.equals("displayUpdateForm"))
//			{
//				System.out.println("執行 FullProjServlet displayUpdateForm[補齊計畫頁面]");
//				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
//				
//				displayUpdateForm(request,response);
//			}
			else
			{
				errorMsg.put("errorURL","請勿做作不正當請求( line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,response);
				return;
			}
		}
	}
	
//	private void displayUpdateForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
//	{
//		request.setCharacterEncoding("UTF-8");
//		
//		HttpSession session = request.getSession();
//		MemberBean memberBean = null;
//		
//		if(session.getAttribute("LoginOK") != null && session.getAttribute("LoginOK") instanceof MemberBean)
//		{
//			memberBean = (MemberBean)session.getAttribute("LoginOK");
//		}
//		else
//		{
//			String context = request.getContextPath();
//			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
//			return;
//		}
//		
//		String fullProjId = request.getParameter("fullProjId");
//		int fullId = Integer.parseInt(fullProjId);
//		
//		FullProjBean fullProjBean = new FullProjBean();
//		fullProjBean.setFullProjId(fullId);
//		
//		FullProjBean result = service.displayFullProj(fullProjBean);
//		if(result != null)
//		{
//			System.out.println(result);
//			request.setAttribute("fullProj",result);
//			request.getRequestDispatcher("/fullProj/updateFullProjForm.jsp").forward(request,response);
//			return;
//		}
//	}

	private void displayPersonalFullProjByChat(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean memberBean = null;
		
		// if session.getAttribute("LoginOK") 無法轉型 => 不是會員登入，無操作權力
		if(session.getAttribute("LoginOK") != null && session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean)session.getAttribute("LoginOK");
		}
		else
		{
			String context = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
			return;
		}
		
		if(memberBean != null)
		{
			// business logic
			FullProjBean fullProjBean = new FullProjBean();
			fullProjBean.setMemberId(memberBean.getMemberId());
			List<FullProjBean> result = service.displayPersonalFullProjProjByChat(fullProjBean);
			
			if(result != null)
			{
				// 成功導向
				System.out.println(result);
				System.out.println("==================================================");
				request.setAttribute("fullProj",result);
				request.getRequestDispatcher("/personal/displayPersonalFullProjByChat.jsp").forward(request,response);
			}
		}
	}
	
	private void displayPersonalFullProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		// if session.getAttribute("LoginOK") 無法轉型 => 不是會員登入，無操作權力
		MemberBean memberBean = null;
		if(session.getAttribute("LoginOK") != null && session.getAttribute("LoginOK") instanceof MemberBean)
		{
			memberBean = (MemberBean)session.getAttribute("LoginOK");
		}
		else
		{
			String context = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(context + "/error/permission.jsp"));
			return;
		}
		
		// 接收資料 從 session LoginOK 抓取
		if(memberBean != null)
		{
			// business logic
			FullProjBean fullProjBean = new FullProjBean();
			fullProjBean.setMemberId(memberBean.getMemberId());
			List<FullProjBean> result = service.displayPersonalFullProj(fullProjBean);
		
			if(result != null)
			{
				// 成功導向
				System.out.println(result);
				System.out.println("==================================================");
				request.setAttribute("fullProj",result);
				request.getRequestDispatcher("/personal/displayPersonalFullProj.jsp").forward(request,response);;
				return;
			}
		}
	}

	private void displayFullProjByChat(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String fullProjId = request.getParameter("fullProjId");
		
		// 驗證資料
		if(fullProjId == null || fullProjId.trim().length() == 0)
		{
			errorMsg.put("error","queryString key error");
		}
		
		// 進行必要資料轉換
		int id = 0;
		try
		{
			id = Integer.parseInt(fullProjId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","queryString value error");
		}
		
		if(!errorMsg.isEmpty())
		{
			// QueryString 有誤
			errorMsg.put("errorURL","請勿做作不正當請求(FullServlet line.134)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

		// business logic
		FullProjBean bean = new FullProjBean();
		bean.setFullProjId(id);
		bean = service.displayFullProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println(bean);
			System.out.println("==============================");
			request.setAttribute("fullProj",bean);
			request.getRequestDispatcher("/fullProj/displayFullProjByChat.jsp").forward(request,response);;
			return;
		}
	}

	private void updateFullProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.removeAttribute("fullProj");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String fullProjId = null;
		String memberId = null;
		String title = null;
		String projAbstract = null;
		String content = null;
		String location = null;
		String startTime = null;
		String endTime = null;
		String estMember = null;
		String budget = null;
		String orgArchitecture = null;
		byte[] img = null;
		String fileName = null;
		long fileLength = 0;
		InputStream is = null;
		
		// 接收前端使用者資料，表單必須 method="post" enctype="multipart/form-data"
		Collection<Part> parts = request.getParts();
		if(parts != null)
		{
			for(Part part : parts)
			{
				String name = part.getName();	  // form input 的 name
				String value = request.getParameter(name);
				if(part.getContentType() == null) // 普通 文字資料
				{
					if(name.equals("fullProjId"))
					{
						fullProjId = value;
					}
					if(name.equals("title"))
					{
						title = value;
					}
					if(name.equals("projAbstract"))
					{
						projAbstract = value;
					}
					if(name.equals("content"))
					{
						content = value;
					}
					if(name.equals("location"))
					{
						location = value;
					}
					if(name.equals("activityStartTime"))
					{
						startTime = value;
					}
					if(name.equals("activityEndTime"))
					{
						endTime = value;
					}
					if(name.equals("estMember"))
					{
						estMember = value;
					}
					if(name.equals("budget"))
					{
						budget = value;
					}
					if(name.equals("orgArchitecture"))
					{
						orgArchitecture = value;
					}
				}
				else if(part.getContentType().equals("image/png") || part.getContentType().equals("image/jpeg")) // file 資料
				{
					if(name.equals("imgFile"))
					{
						fileName = GlobalService.getFileName(part);
						fileLength = part.getSize();
						is = part.getInputStream();
					}
				}
				else
				{
					fileName = GlobalService.getFileName(part);
					if(fileName != null && fileName.trim().length() > 0)
					{
						errorMsg.put("imgFile","檔案格式不正確");
						System.out.println("請選擇正確格式");
					}
//					else
//					{
//						修改 不強制輸入，不輸入=原先圖檔
//						errorMsg.put("imgFile","計畫封面是必須的");
//						System.out.println("沒檔案，計畫封面是必須的");
//					}
				}
			}
		}
		
		// 檢查使用者輸入資料
		if(title == null || title.trim().length() == 0)
		{
			errorMsg.put("title","計畫名稱為必填欄位");
		}
		
		if(projAbstract == null || projAbstract.trim().length() == 0)
		{
			errorMsg.put("projAbstract","計畫摘要為必填欄位");
		}
		
		if(content == null || content.trim().length() == 0)
		{
			errorMsg.put("content","計畫內容為必填欄位");
		}
		
		if(location == null || location.trim().length() == 0)
		{
			errorMsg.put("location","理想地點為必填欄位");
		}
		
		if(startTime == null || startTime.trim().length() == 0)
		{
			errorMsg.put("activityStartTime","活動時間(起)為必填欄位");
		}
		
		if(endTime == null || endTime.trim().length() == 0)
		{
			errorMsg.put("activityEndTime","活動時間(汔)為必填欄位");
		}
		
		if(estMember == null || estMember.trim().length() == 0)
		{
			errorMsg.put("estMember","活動人數為必填欄位");
		}
		
		if(budget == null || budget.trim().length() == 0)
		{
			errorMsg.put("budget","活動預算為必填欄位");
		}
		
		if(budget == null || budget.trim().length() == 0)
		{
			errorMsg.put("orgArchitecture","成員架構為必填欄位");
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/fullProj/updateFullProjForm.jsp").forward(request,response);
			return;
		}
		
		// 進行必要的資料轉換
		int fId = 0;
		try
		{
			fId = Integer.parseInt(fullProjId);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}

		java.util.Date sTime = null;
		try
		{
			sTime = GlobalService.convertStringToDate(startTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("activityStartTime","活動時間(起)格式有誤");
			e.printStackTrace();
		}
		
		java.util.Date eTime = null;
		try
		{
			eTime = GlobalService.convertStringToDate(endTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("activityEndTime","活動時間(迄)格式有誤");
			e.printStackTrace();
		}
		
		// 如果 <= 0 代表 日期起訖相同 或者 迄比起 早
		if(GlobalService.compareDate(sTime,eTime) < 0)
		{
			errorMsg.put("activityEndTime","活動時間(迄) 不能比 活動時間(起)早");
		}
		
		int dNum = 0;
		try
		{
			dNum = Integer.parseInt(estMember);
			if(dNum < 0)
				errorMsg.put("demandNum","人數必須為大於0");
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("demandNum","人數必須為數字");
			e.printStackTrace();
		}
		
		int bget = 0;
		try
		{
			bget = Integer.parseInt(budget);
			if(bget < 0)
				errorMsg.put("budget","預算必須為大於0");
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("budget","預算必須為數字");
			e.printStackTrace();
		}
		
		if(is != null)
		{
			img = GlobalService.convertInputStreamToByteArray(is);
			is.close();
		}
//		else
//		{
//			img = GlobalService.convertBase64StringToByteArray(request.getParameter("bsae64String"));
//		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/fullProj/updateFullProjForm.jsp").forward(request,response);
			return;
		}
		
		// 將必要資料 包成Bean 導向 Business Logic
		FullProjBean fullProjBean = new FullProjBean();
		fullProjBean.setFullProjId(fId);
		fullProjBean.setTitle(title);
		fullProjBean.setProjAbstract(projAbstract);
		fullProjBean.setContent(content);
		fullProjBean.setLocation(location);
		fullProjBean.setActivityStartTime(sTime);
		fullProjBean.setActivityEndTime(eTime);
		fullProjBean.setEstMember(dNum);
		fullProjBean.setBudget(bget);
		fullProjBean.setOrgArchitecture(orgArchitecture);
		fullProjBean.setFrontCoverName(fileName);
		fullProjBean.setFrontCover(img);
		fullProjBean.setFrontCoverLength(fileLength);

		// 進行 Business
		fullProjBean = service.updateFullProj(fullProjBean);
		
		if(fullProjBean != null)
		{
			// 成功導向
			System.out.println(fullProjBean);
			
//			session = request.getSession();
//			session.setAttribute("fullProj",fullProjBean);
			
			response.sendRedirect(request.getContextPath() + "/fullProj.do?type=display&fullProjId=" + fullProjBean.getFullProjId());
		}
		else
		{
			// 失敗導向
			errorMsg.put("error","編輯計畫建立失敗");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
	}

	private void displayFullProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String fullProjId = request.getParameter("fullProjId");
		
		// 驗證資料
		if(fullProjId == null || fullProjId.trim().length() == 0)
		{
			errorMsg.put("queryString","queryString key error[FullProjServlet displayFullProj method]");
		}
		
		// 進行必要資料轉換
		int id = 0;
		try
		{
			id = Integer.parseInt(fullProjId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("queryString","queryString value error[FullProjServlet displayFullProj method]");
		}
		
		if(!errorMsg.isEmpty())
		{
			// queryString 不等於 ?type=display&fullProjId=1...
			errorMsg.put("errorURL","請勿做作不正當請求(FullProjServlet line.198)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

		// business logic
		FullProjBean bean = new FullProjBean();
		bean.setFullProjId(id);
		bean = service.displayFullProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println("單一計劃 :" + bean);
			System.out.println("======================================================");
			request.setAttribute("fullProj",bean);
			request.getRequestDispatcher("/fullProj/displayFullProj.jsp").forward(request,response);
		}
		else
		{
			// 沒查到 結果
			errorMsg.put("errorURL","請勿做作不正當請求(FullProjServlet line.219 查詢失敗)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

	}
	
	private void displayFullProjAll(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("======================================================");
		
		List<FullProjBean> beans = service.displayFullProjAll();
		request.setAttribute("fullProjAll",beans);
		request.getRequestDispatcher("/fullProj/fullproj.jsp").forward(request,response);

		return;			
	}

//	private void createPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
//	{
//		request.setCharacterEncoding("UTF-8");
//		
//		// 錯誤訊息 容器
//		Map<String,String> errorMsg = new HashMap<String,String>();
//		request.setAttribute("error",errorMsg);
//		
//		String memberId = null;
//		String title = null;
//		String projAbstract = null;
//		String content = null;
//		String location = null;
//		String startTime = null;
//		String endTime = null;
//		String demandNum = null;
//		String budget = null;
//		byte[] img = null;
//		String fileName = null;
//		long fileLength = 0;
//		InputStream is = null;
//		
//		// 接收前端使用者資料，表單必須 method="post" enctype="multipart/form-data"
//		Collection<Part> parts = request.getParts();
//		if(parts != null)
//		{
//			for(Part part : parts)
//			{
//				String name = part.getName();	  // form input 的 name
//				String value = request.getParameter(name);
//				if(part.getContentType() == null) // 普通 文字資料
//				{
//					if(name.equals("memberId"))
//					{
//						memberId = value;
//					}
//					if(name.equals("title"))
//					{
//						title = value;
//					}
//					if(name.equals("projAbstract"))
//					{
//						projAbstract = value;
//					}
//					if(name.equals("content"))
//					{
//						content = value;
//					}
//					if(name.equals("location"))
//					{
//						location = value;
//					}
//					if(name.equals("startTime"))
//					{
//						startTime = value;
//					}
//					if(name.equals("endTime"))
//					{
//						endTime = value;
//					}
//					if(name.equals("demandNum"))
//					{
//						demandNum = value;
//					}
//					if(name.equals("budget"))
//					{
//						budget = value;
//					}
//				}
//				else if(part.getContentType().equals("image/png") || part.getContentType().equals("image/jpeg")) // file 資料
//				{
//					if(name.equals("imgFile"))
//					{
//						fileName = GlobalService.getFileName(part);
//						fileLength = part.getSize();
//						is = part.getInputStream();
//					}
//				}
//				else
//				{
//					fileName = GlobalService.getFileName(part);
//					if(fileName != null && fileName.trim().length() > 0)
//					{
//						errorMsg.put("imgFile","檔案格式不正確");
//						System.out.println("請選擇正確格式");
//					}
//					else
//					{
//						errorMsg.put("imgFile","計畫封面是必須的");
//						System.out.println("沒檔案，計畫封面是必須的");
//					}
//				}
//			}
//		}
//		
//		// 檢查使用者輸入資料
//		if(title == null || title.trim().length() == 0)
//		{
//			errorMsg.put("title","計畫名稱為必填欄位");
//		}
//		
//		if(projAbstract == null || projAbstract.trim().length() == 0)
//		{
//			errorMsg.put("projAbstract","計畫摘要為必填欄位");
//		}
//		
//		if(content == null || content.trim().length() == 0)
//		{
//			errorMsg.put("content","計畫內容為必填欄位");
//		}
//		
//		if(location == null || location.trim().length() == 0)
//		{
//			errorMsg.put("location","理想地點為必填欄位");
//		}
//		
//		if(startTime == null || startTime.trim().length() == 0)
//		{
//			errorMsg.put("startTime","活動時間(起)為必填欄位");
//		}
//		
//		if(endTime == null || endTime.trim().length() == 0)
//		{
//			errorMsg.put("endTime","活動時間(汔)為必填欄位");
//		}
//		
//		if(demandNum == null || demandNum.trim().length() == 0)
//		{
//			errorMsg.put("demandNum","活動人數為必填欄位");
//		}
//		
//		if(budget == null || budget.trim().length() == 0)
//		{
//			errorMsg.put("budget","活動預算為必填欄位");
//		}
//		
//		if(!errorMsg.isEmpty())
//		{
//			request.getRequestDispatcher("/primaryProj/createPrimaryProjForm.jsp").forward(request,response);
//			return;
//		}
//		
//		// 進行必要的資料轉換
//		int mid = 0;
//		try
//		{
//			mid = Integer.parseInt(memberId);
//		}
//		catch(NumberFormatException e)
//		{
//			e.printStackTrace();
//		}
//		
//		java.util.Date sTime = null;
//		try
//		{
//			sTime = GlobalService.convertStringToDate(startTime);
//		}
//		catch(ParseException e)
//		{
//			errorMsg.put("startTime","活動時間(起)格式有誤");
//			e.printStackTrace();
//		}
//		
//		java.util.Date eTime = null;
//		try
//		{
//			eTime = GlobalService.convertStringToDate(endTime);
//		}
//		catch(ParseException e)
//		{
//			errorMsg.put("endTime","活動時間(迄)格式有誤");
//			e.printStackTrace();
//		}
//		
//		// 如果 <= 0 代表 日期起訖相同 或者 迄比起 早
//		if(GlobalService.compareDate(sTime,eTime) <= 0)
//		{
//			errorMsg.put("endTime","活動時間(迄) 不能比 活動時間(起)早");
//		}
//		
//		int dNum = 0;
//		try
//		{
//			dNum = Integer.parseInt(demandNum);
//			if(dNum < 0)
//				errorMsg.put("demandNum","人數必須為大於0");
//		}
//		catch(NumberFormatException e)
//		{
//			errorMsg.put("demandNum","人數必須為數字");
//			e.printStackTrace();
//		}
//		
//		int bget = 0;
//		try
//		{
//			bget = Integer.parseInt(budget);
//			if(bget < 0)
//				errorMsg.put("budget","預算必須為大於0");
//		}
//		catch(NumberFormatException e)
//		{
//			errorMsg.put("budget","預算必須為數字");
//			e.printStackTrace();
//		}
//		
//		if(is != null)
//		{
//			img = GlobalService.convertInputStreamToByteArray(is);
//			is.close();
//		}
//		
//		if(!errorMsg.isEmpty())
//		{
//			request.getRequestDispatcher("/primaryProj/createPrimaryProjForm.jsp").forward(request,response);
//			return;
//		}
//		
//		// 將必要資料 包成Bean 導向 Business Logic
//		PrimaryProjBean bean = new PrimaryProjBean();
//		bean.setMemberId(mid);
//		bean.setTitle(title);
//		bean.setProjAbstract(projAbstract);
//		bean.setContent(content);
//		bean.setIdealPlace(location);
//		bean.setActivityStartTime(sTime);
//		bean.setActivityEndTime(eTime);
//		bean.setDemandNum(dNum);
//		bean.setBudget(bget);
//		bean.setFrontCoverName(fileName);
//		bean.setFrontCover(img);
//		bean.setFrontCoverLength(fileLength);
//
//		// 進行 Business
//		bean = service.createPrimaryProj(bean);
//		
//		if(bean != null)
//		{
//			// 成功導向
//			System.out.println(bean);
//			HttpSession session = request.getSession();
//			session.setAttribute("primaryProj",bean);
//			response.sendRedirect(request.getContextPath() + "/primaryProj/displayPrimaryProj.jsp");
//		}
//		else
//		{
//			// 失敗導向
//			errorMsg.put("error","初步計畫建立失敗");
//			request.getRequestDispatcher("/error.jsp").forward(request,response);
//			return;
//		}
//	}

}

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

import model.MemberBean;
import model.PrimaryProjBean;
import model.service.PrimaryProjService;

@WebServlet("/primaryProj.do")
@MultipartConfig(location = "",
				 maxFileSize = 1024 * 1024 * 2)
public class PrimaryProjServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private PrimaryProjService service;

	@Override
	public void init() throws ServletException
	{
		service = new PrimaryProjService();
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
			if(type.equals("create"))
			{
				// 因為表單必須 post 
				if(request.getMethod().equals("POST"))
				{
					System.out.println("執行 PrimaryProjServlet createPrimaryProj");
					System.out.println(request.getRequestURI() + "?" + request.getQueryString());
					
					createPrimaryProj(request,response);
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
				System.out.println("執行 PrimaryProjServlet updatePrimaryProj");
				updatePrimaryProj(request,response);
			}
			else if(type.equals("displayUpdate"))
			{
				System.out.println("執行 PrimaryProjServlet displayUpdatePrimaryProj");
				displayUpdatePrimaryProj(request,response);
			}
			else if(type.equals("displayAll"))
			{
				System.out.println("執行 PrimaryProjServlet displayPrimaryProjAll");
				displayPrimaryProjAll(request,response);
			}
			// 單一初步計畫
			else if(type.equals("display"))
			{
				System.out.println("執行 PrimaryProjServlet displayPrimaryProj");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayPrimaryProj(request,response);
			}
			// 個人管理頁面 => 顯示發布過的初步計畫
			else if(type.equals("displayPersonal"))
			{
				System.out.println("執行 PrimaryProjServlet displayPersonalPrimaryProj[個人初步計畫列表]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayPersonalPrimaryProj(request,response);
			}
			// 個人管理頁面=> 顯示需要審核的初步計畫[有學校申請]
			else if(type.equals("displayPersonalByPending"))
			{
				System.out.println("執行 PrimaryProjServlet displayPersonalPrimaryProjByPending[審核計畫列表]");
				System.out.println(request.getRequestURI() + "?" + request.getQueryString());
				
				displayPersonalPrimaryProjByPending(request,response);
			}
			else
			{
				errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,response);
				return;
			}
		}
	}
	
	private void displayPersonalPrimaryProjByPending(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
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
			PrimaryProjBean primaryProjBean = new PrimaryProjBean();
			primaryProjBean.setMemberId(memberBean.getMemberId());
			List<PrimaryProjBean> result = service.displayPersonalPrimaryProjByPending(primaryProjBean);
		
			if(result != null)
			{
				// 成功導向
				System.out.println(result);
				System.out.println("==================================================");
				request.setAttribute("primaryProj",result);
				request.getRequestDispatcher("/personal/displayPersonalPrimaryProjByPending.jsp").forward(request,response);
				return;
			}
		}
	}

	private void displayPersonalPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
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
			PrimaryProjBean primaryProjBean = new PrimaryProjBean();
			primaryProjBean.setMemberId(memberBean.getMemberId());
			List<PrimaryProjBean> result = service.displayPersonalPrimaryProj(primaryProjBean);
			
			if(result != null)
			{
				// 成功導向
				System.out.println(result);
				System.out.println("==================================================");
				request.setAttribute("primaryProj",result);
				request.getRequestDispatcher("/personal/displayPersonalPrimaryProj.jsp").forward(request,response);;
				return;
			}
		}
	}

	private void displayUpdatePrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String primaryProjId = request.getParameter("primaryProjId");
		
		// 驗證資料
		if(primaryProjId == null || primaryProjId.trim().length() == 0)
		{
			errorMsg.put("error","queryString key error");
		}
		
		// 進行必要資料轉換
		int id = 0;
		try
		{
			id = Integer.parseInt(primaryProjId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","queryString value error");
		}
		
		if(!errorMsg.isEmpty())
		{
			// QueryString 有誤
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.134)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

		// business logic
		PrimaryProjBean bean = new PrimaryProjBean();
		bean.setPrimaryProjId(id);
		bean = service.displayPrimaryProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println(bean);
			HttpSession session = request.getSession();
			session.setAttribute("primaryProj",bean);
			response.sendRedirect(request.getContextPath() + "/primaryProj/updatePrimaryProjForm.jsp");
//			request.setAttribute("primaryProj",bean);
//			request.getRequestDispatcher("/primaryProj/updatePrimaryProjForm.jsp").forward(request,response);;
			return;
		}
		else
		{
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.154)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
	}

	private void updatePrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.removeAttribute("primaryProj");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String primaryProjId = null;
		String memberId = null;
		String title = null;
		String projAbstract = null;
		String content = null;
		String location = null;
		String startTime = null;
		String endTime = null;
		String demandNum = null;
		String budget = null;
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
					if(name.equals("primaryProjId"))
					{
						primaryProjId = value;
					}
					if(name.equals("memberId"))
					{
						memberId = value;
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
					if(name.equals("startTime"))
					{
						startTime = value;
					}
					if(name.equals("endTime"))
					{
						endTime = value;
					}
					if(name.equals("demandNum"))
					{
						demandNum = value;
					}
					if(name.equals("budget"))
					{
						budget = value;
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
			errorMsg.put("startTime","活動時間(起)為必填欄位");
		}
		
		if(endTime == null || endTime.trim().length() == 0)
		{
			errorMsg.put("endTime","活動時間(汔)為必填欄位");
		}
		
		if(demandNum == null || demandNum.trim().length() == 0)
		{
			errorMsg.put("demandNum","活動人數為必填欄位");
		}
		
		if(budget == null || budget.trim().length() == 0)
		{
			errorMsg.put("budget","活動預算為必填欄位");
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/primaryProj/updatePrimaryProjForm.jsp").forward(request,response);
			return;
		}
		
		// 進行必要的資料轉換
		int pId = 0;
		try
		{
			pId = Integer.parseInt(primaryProjId);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		int mId = 0;
		try
		{
			mId = Integer.parseInt(memberId);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
//		Object object = session.getAttribute("LoginOK");
//		if(object instanceof MemberBean)
//		{
//			MemberBean memberBean = (MemberBean)object;
//			if(memberBean.getMemberId() != mId)
//			{
//				String contextPath = request.getContextPath();
//				response.sendRedirect(response.encodeRedirectURL(contextPath + "/error/permission.jsp"));
//				return;
//			}
//		}
		java.util.Date sTime = null;
		try
		{
			sTime = GlobalService.convertStringToDate(startTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("startTime","活動時間(起)格式有誤");
			e.printStackTrace();
		}
		
		java.util.Date eTime = null;
		try
		{
			eTime = GlobalService.convertStringToDate(endTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("endTime","活動時間(迄)格式有誤");
			e.printStackTrace();
		}
		
		// 如果 <= 0 代表 日期起訖相同 或者 迄比起 早
		if(GlobalService.compareDate(sTime,eTime) <= 0)
		{
			errorMsg.put("endTime","活動時間(迄) 不能比 活動時間(起)早");
		}
		
		int dNum = 0;
		try
		{
			dNum = Integer.parseInt(demandNum);
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
			request.removeAttribute("primaryProj");
			request.getRequestDispatcher("/primaryProj/updatePrimaryProjForm.jsp").forward(request,response);
			return;
		}
		
		// 將必要資料 包成Bean 導向 Business Logic
		PrimaryProjBean bean = new PrimaryProjBean();
		bean.setPrimaryProjId(pId);
		bean.setMemberId(mId);
		bean.setTitle(title);
		bean.setProjAbstract(projAbstract);
		bean.setContent(content);
		bean.setIdealPlace(location);
		bean.setActivityStartTime(sTime);
		bean.setActivityEndTime(eTime);
		bean.setDemandNum(dNum);
		bean.setBudget(bget);
		bean.setFrontCoverName(fileName);
		bean.setFrontCover(img);
		bean.setFrontCoverLength(fileLength);

		// 進行 Business
		bean = service.updatePrimaryProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println(bean);
			
//			displayPrimaryProj(request,response);
//			session = request.getSession();
//			session.setAttribute("primaryProj",bean);
			
			response.sendRedirect(request.getContextPath() + "/primaryProj.do?type=display&primaryProjId=" + bean.getPrimaryProjId());
		}
		else
		{
			// 失敗導向
			errorMsg.put("error","編輯計畫建立失敗");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
	}

	private void displayPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getRequestURI() + "?" + request.getQueryString());
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		// 接收資料
		String primaryProjId = request.getParameter("primaryProjId");
		
		// 驗證資料
		if(primaryProjId == null || primaryProjId.trim().length() == 0)
		{
			errorMsg.put("queryString","queryString key error");
		}
		
		// 進行必要資料轉換
		int id = 0;
		try
		{
			id = Integer.parseInt(primaryProjId);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("error","queryString value error");
		}
		
		if(!errorMsg.isEmpty())
		{
			// queryString 不等於 ?type=display&primaryProjId=1...
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.198)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

		// business logic
		PrimaryProjBean bean = new PrimaryProjBean();
		bean.setPrimaryProjId(id);
		bean = service.displayPrimaryProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println(bean);
			System.out.println("======================================================");
			request.setAttribute("primaryProj",bean);
			request.getRequestDispatcher("/primaryProj/displayPrimaryProj.jsp").forward(request,response);
		}
		else
		{
			// 沒查到 結果
			errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.219 查詢失敗)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}

	}
	
	private void displayPrimaryProjAll(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getRequestURI() + "?" + request.getQueryString());
		System.out.println("======================================================");
		
		List<PrimaryProjBean> beans = service.displayPrimaryProjAll();
		request.setAttribute("primaryProjAll",beans);
		request.getRequestDispatcher("/primaryProj/displayPrimaryProjAll.jsp").forward(request,response);
		return;			
	}

	private void createPrimaryProj(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// 錯誤訊息 容器
		Map<String,String> errorMsg = new HashMap<String,String>();
		request.setAttribute("error",errorMsg);
		
		String memberId = null;
		String title = null;
		String projAbstract = null;
		String content = null;
		String location = null;
		String startTime = null;
		String endTime = null;
		String demandNum = null;
		String budget = null;
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
					if(name.equals("memberId"))
					{
						memberId = value;
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
					if(name.equals("startTime"))
					{
						startTime = value;
					}
					if(name.equals("endTime"))
					{
						endTime = value;
					}
					if(name.equals("demandNum"))
					{
						demandNum = value;
					}
					if(name.equals("budget"))
					{
						budget = value;
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
					else
					{
						errorMsg.put("imgFile","計畫封面是必須的");
						System.out.println("沒檔案，計畫封面是必須的");
					}
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
			errorMsg.put("startTime","活動時間(起)為必填欄位");
		}
		
		if(endTime == null || endTime.trim().length() == 0)
		{
			errorMsg.put("endTime","活動時間(汔)為必填欄位");
		}
		
		if(demandNum == null || demandNum.trim().length() == 0)
		{
			errorMsg.put("demandNum","活動人數為必填欄位");
		}
		
		if(budget == null || budget.trim().length() == 0)
		{
			errorMsg.put("budget","活動預算為必填欄位");
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/primaryProj/createPrimaryProjForm.jsp").forward(request,response);
			return;
		}
		
		// 進行必要的資料轉換
		int mid = 0;
		try
		{
			mid = Integer.parseInt(memberId);
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
			errorMsg.put("startTime","活動時間(起)格式有誤");
			e.printStackTrace();
		}
		
		java.util.Date eTime = null;
		try
		{
			eTime = GlobalService.convertStringToDate(endTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("endTime","活動時間(迄)格式有誤");
			e.printStackTrace();
		}
		
		// 如果 <= 0 代表 日期起訖相同 或者 迄比起 早
		if(GlobalService.compareDate(sTime,eTime) < 0)
		{
			errorMsg.put("endTime","活動時間(迄) 不能比 活動時間(起)早");
		}
		
		int dNum = 0;
		try
		{
			dNum = Integer.parseInt(demandNum);
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
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/primaryProj/createPrimaryProjForm.jsp").forward(request,response);
			return;
		}
		
		// 將必要資料 包成Bean 導向 Business Logic
		PrimaryProjBean bean = new PrimaryProjBean();
		bean.setMemberId(mid);
		bean.setTitle(title);
		bean.setProjAbstract(projAbstract);
		bean.setContent(content);
		bean.setIdealPlace(location);
		bean.setActivityStartTime(sTime);
		bean.setActivityEndTime(eTime);
		bean.setDemandNum(dNum);
		bean.setBudget(bget);
		bean.setFrontCoverName(fileName);
		bean.setFrontCover(img);
		bean.setFrontCoverLength(fileLength);

		// 進行 Business
		bean = service.createPrimaryProj(bean);
		
		if(bean != null)
		{
			// 成功導向
			System.out.println(bean);
			HttpSession session = request.getSession();
			session.setAttribute("primaryProj",bean);
			response.sendRedirect(request.getContextPath() + "/primaryProj/displayPrimaryProj.jsp");
		}
		else
		{
			// 失敗導向
			errorMsg.put("error","初步計畫建立失敗");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		}
	}
}

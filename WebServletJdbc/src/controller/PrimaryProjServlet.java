package controller;

import global.GlobalService;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/createPrimaryProj.do")
@MultipartConfig(location = "",
				 maxFileSize = 1024 * 1024 * 2)
public class PrimaryProjServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
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
			request.getRequestDispatcher("/createPrimaryProjForm.jsp").forward(request,response);
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
		
		java.util.Date sTime;
		try
		{
			sTime = GlobalService.convertStringToDate(startTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("startTime","活動時間(起)格式有誤");
			e.printStackTrace();
		}
		
		java.util.Date eTime;
		try
		{
			eTime = GlobalService.convertStringToDate(endTime);
		}
		catch(ParseException e)
		{
			errorMsg.put("endTime","活動時間(迄)格式有誤");
			e.printStackTrace();
		}
		
		int dNum = 0;
		try
		{
			dNum = Integer.parseInt(demandNum);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("demandNum","人數必須為整數");
			e.printStackTrace();
		}
		
		int bget = 0;
		try
		{
			bget = Integer.parseInt(budget);
		}
		catch(NumberFormatException e)
		{
			errorMsg.put("budget","預算必須為整數");
			e.printStackTrace();
		}
		
		if(is != null)
		{
			img = GlobalService.convertInputStreamToByteArray(is);
			is.close();
		}
		
		if(!errorMsg.isEmpty())
		{
			request.getRequestDispatcher("/createPrimaryProjForm.jsp").forward(request,response);
			return;
		}
		
		// 將必要資料 包成Bean 進行 Business Logic
		
	}
}

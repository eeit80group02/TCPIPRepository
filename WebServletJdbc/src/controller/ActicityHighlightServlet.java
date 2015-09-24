package controller;

import global.GlobalService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ActivityHighlightBean;
import model.MemberBean;
import model.service.ActicityHighlightService;

public class ActicityHighlightServlet extends HttpServlet {

	private ActicityHighlightService service;

	@Override
	public void init() throws ServletException {
		service = new ActicityHighlightService();
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
					System.out.println("create");
					creat(request, response);
				} else {
					errorMsg.put("errorURL",
							"請勿做作不正當請求(PrimaryProjServlet line.70(必須post))");
					request.getRequestDispatcher("/error.jsp").forward(request,
							response);
					return;
				}
			} else if (type.equals("update")) {
				System.out.println("update");
				update(request, response);
			} else if (type.equals("display")) {
				System.out.println("display");
				display(request, response);
			} else if (type.equals("displays")) {
				System.out.println("displays");
				displayAll(request, response);
			} else {
				errorMsg.put("errorURL",
						"請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
				return;
			}
		}
	}

	public void creat(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		MemberBean mBean = null;
		ActivityHighlightBean bean = new ActivityHighlightBean();
		HttpSession session = request.getSession();
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		byte[] img = null;
		String fileName = null;
		long fileLength = 0;
		InputStream is = null;
		String content = null;
		String vedioURL = null;
		mBean = (MemberBean) session.getAttribute("LoginOK");
		int mId = mBean.getMemberId();
		String fullProjId = request.getParameter("fullProjId");
		int fPId = 0;
		fPId = Integer.parseInt(fullProjId);
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			for (Part part : parts) {
				String name = part.getName(); // form input 的 name
				String value = request.getParameter(name);
				if (part.getContentType() == null) {
					if (name.equals("content")) {
						content = value;
					}
					if (name.equals("vedioURL")) {
						vedioURL = value;
					}
				} else if (part.getContentType().equals("image/png")
						|| part.getContentType().equals("image/jpeg")) {
					if (name.equals("imgFile")) {
						fileName = GlobalService.getFileName(part);
						fileLength = part.getSize();
						is = part.getInputStream();
					}
				} else {
					fileName = GlobalService.getFileName(part);
					if (fileName != null && fileName.trim().length() > 0) {
						errorMsg.put("imgFile", "檔案格式不正確");
						System.out.println("請選擇正確格式");
					}
				}
			}
		}
		bean.setMemberId(mId);
		bean.setFullProjId(fPId);
		bean.setFrontCoverName(fileName);
		bean.setFrontCover(img);
		bean.setFrontCoverLength(fileLength);
		bean.setVideoURL(vedioURL);
		bean = service.creat(bean);
		if(bean!=null){
			System.out.println("新增成功");
			response.sendRedirect("");
		}else{
			System.out.println("時間未到");
		}

	}

	public void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		MemberBean mBean = null;
		ActivityHighlightBean bean = new ActivityHighlightBean();
		HttpSession session = request.getSession();
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		byte[] img = null;
		String fileName = null;
		long fileLength = 0;
		InputStream is = null;
		String content = null;
		String vedioURL = null;
		mBean = (MemberBean) session.getAttribute("LoginOK");
		int mId = mBean.getMemberId();
		String fullProjId = request.getParameter("fullProjId");
		int fPId = 0;
		fPId = Integer.parseInt(fullProjId);
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			for (Part part : parts) {
				String name = part.getName(); // form input 的 name
				String value = request.getParameter(name);
				if (part.getContentType() == null) {
					if (name.equals("content")) {
						content = value;
					}
					if (name.equals("vedioURL")) {
						vedioURL = value;
					}
				} else if (part.getContentType().equals("image/png")
						|| part.getContentType().equals("image/jpeg")) {
					if (name.equals("imgFile")) {
						fileName = GlobalService.getFileName(part);
						fileLength = part.getSize();
						is = part.getInputStream();
					}
				} else {
					fileName = GlobalService.getFileName(part);
					if (fileName != null && fileName.trim().length() > 0) {
						errorMsg.put("imgFile", "檔案格式不正確");
						System.out.println("請選擇正確格式");
					}
				}
			}
		}
		bean.setMemberId(mId);
		bean.setFullProjId(fPId);
		bean.setFrontCoverName(fileName);
		bean.setFrontCover(img);
		bean.setFrontCoverLength(fileLength);
		bean.setVideoURL(vedioURL);
		bean = service.update(bean);
		if(bean!=null){
			System.out.println("更新成功");
			response.sendRedirect("");
		}else{
			System.out.println("更新失敗");
		}
	}

	public void display(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ActivityHighlightBean bean = null;
		String fullProjId = request.getParameter("fullProjId");
		int fPId = Integer.parseInt(fullProjId);
		bean.setFullProjId(fPId);
		bean = service.display(bean);
		if(bean!=null){
			System.out.println("查詢成功");
			response.sendRedirect("");
		}else{
			System.out.println("查詢失敗");
		}
	}

	public void displayAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<ActivityHighlightBean> list = null;
		list = service.displayAll();
		if(!list.isEmpty()){
			System.out.println("有花絮");
		}
	}
}

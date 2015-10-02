package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.TrackProjBean;
import model.service.FollowService;

public class FollowServlet extends HttpServlet{
	FollowService service;
	@Override
	public void init() throws ServletException {
		service = new FollowService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);

		String type = request.getParameter("type");

		if (type == null || type.trim().length() == 0) {
			errorMsg.put("errorURL", "請勿做作不正當請求(PrimaryProjServlet line.55)");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
			return;
		} else {
			if (type.equals("follow")) {
				follow(request,response);
			} else if (type.equals("displays")) {
				System.out.println("displays");
				displays(request, response);
			} else {
				errorMsg.put("errorURL","請勿做作不正當請求(PrimaryProjServlet line.83)");
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
				return;
			}
		}
	}

	private void displays(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> error = new HashMap<String, String>();
		HttpSession session = request.getSession();
		List<TrackProjBean> list = null;
		MemberBean mBean =null;
		try {
			mBean = (MemberBean) session.getAttribute("LoginOK");
			if(mBean == null){
				error.put("err", "請先登入");
			}
		} catch (Exception e) {
			error.put("err", "你沒有權限操作");
		}
		if(!error.isEmpty()){
			return;
		}
		int memberId = mBean.getMemberId();
		list = service.displays(memberId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("").forward(request, response);
		
	}

	private void follow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> error = new HashMap<String, String>();
		HttpSession session = request.getSession();
		TrackProjBean bean = null;
		MemberBean mBean =null;
		try {
			mBean = (MemberBean) session.getAttribute("LoginOK");
			if(mBean == null){
				error.put("err", "請先登入");
			}
		} catch (Exception e) {
			error.put("err", "你沒有權限操作");
		}
		if(!error.isEmpty()){
			response.sendRedirect("");
		}
		bean = new TrackProjBean();
		String id = request.getParameter("fullProjId");
		int fullProjId = 0;
		if(id!=null){
			try {
				fullProjId = Integer.parseInt(id);
			} catch (Exception e) {
				return;
			}
		}
		int memberId = mBean.getMemberId(); 
		bean.setMemberId(memberId);
		bean.setFullProjId(fullProjId);
		bean = service.follow(bean);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("").forward(request, response);
		
	}
	
}

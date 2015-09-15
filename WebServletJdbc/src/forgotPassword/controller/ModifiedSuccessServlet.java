package forgotPassword.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.dao.MemberDAOJdbc;

@WebServlet("/forgotPassword/resetSuccess.do")
public class ModifiedSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("ResetPassword.jsp called ModifiedSuccessServlet success!!");
		
		//判斷使用者輸入的兩次密碼是否都相等
		String pw1 = request.getParameter("password");
		String pw2 = request.getParameter("check");
		
		Map<String,String> MsgErr = new HashMap<String,String>();
		request.setAttribute("ErrMsg", MsgErr);
		HttpSession session = request.getSession();
		//取得輸入忘記密碼信箱的會員資訊
		MemberBean bean = (MemberBean) session.getAttribute("findUserId");
		
		if(pw1.trim().equals(pw2.trim()) && bean != null){
			int memberId = bean.getMemberId();
			System.out.println("memberId: " + memberId);
			System.out.println(pw2);
			bean.setPassword(pw2.getBytes());
			
			MemberDAOJdbc dao = new MemberDAOJdbc();
			
			if(dao.update(bean) != null){
				System.out.println("修改密碼成功");
				//修改密碼成功
				response.sendRedirect("resetTemplate.jsp");
				
			}
			
		} else if (!pw1.trim().equals(pw2.trim())){
			//put使用者輸入的密碼不一致的資訊
			MsgErr.put("pw1Err", "您輸入的兩個密碼不一致");
			MsgErr.put("pw2Err", "您輸入的兩個密碼不一致");
		} else {
			System.out.println("無法取得使用者於忘記密碼頁面,輸入信箱的資訊");
		}
		
		if(!MsgErr.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("resetPassword.jsp");
			rd.forward(request, response);
			return;
		}
	}
	
}

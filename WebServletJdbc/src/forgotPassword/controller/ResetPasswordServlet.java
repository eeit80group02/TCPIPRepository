package forgotPassword.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import model.MemberBean;
import model.dao.MemberDAOJdbc;
     
@WebServlet("/resetPassword.do")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("使用者忘記密碼信件,呼叫此servlet成功");
		String memberId = request.getParameter("user");
		String memberPw = request.getParameter("code");
		
		//使用Base64(編碼/解碼)比對使用者的 QueryString
		String decodedId = GlobalService.getBase64Decoded(memberId);
		String decodedPW = GlobalService.getBase64Decoded(memberPw);
		
		
		//取得該會員於資料庫儲存的密碼用來比對
		MemberDAOJdbc dao = new MemberDAOJdbc();
		MemberBean bean = dao.select(Integer.parseInt(decodedId));
		byte[] dbPassword = bean.getPassword();
		String password = new String(dbPassword);
		
		if(bean != null && password.trim().equals(decodedPW.trim())){
			//通過驗證後導向輸入新密碼之頁面
			HttpSession session = request.getSession();
			//紀錄是哪一位會員要重設密碼
			session.setAttribute("findUserId", bean);
			response.sendRedirect("forgotPassword/resetPassword.jsp");
		} else {
			System.out.println("GeneratePasswordServlet.class: 使用者的ID於DB內查無此資料");
			//該連結重複點選......(已經失效)
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<p>您所點選的連結已經失效</p>");
			out.print("</body>");
			out.print("</html>");
		}
		
	}
}

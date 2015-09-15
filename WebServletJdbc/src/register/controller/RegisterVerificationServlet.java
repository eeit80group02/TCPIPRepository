package register.controller;

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


@WebServlet("/RegisterVerification.do")
public class RegisterVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("ReqisterVerificationServlet, success!!");
		
		//將使用者的id經過base64解碼
		String id = request.getParameter("id");
		String decodedId = GlobalService.getBase64Decoded(id);
		String code = request.getParameter("code");
		
		//比較使用者發送的request 的 query string 與資料庫內的是否相同
		MemberDAOJdbc dao = new MemberDAOJdbc();
		
		MemberBean bean = dao.select(Integer.parseInt(decodedId));
		if(bean != null && bean.getIdentityCode().equals(code)){
			System.out.println("使用者登入成功!!");
			String str1 = bean.getAccountStatus();
			System.out.println("RegisterMailSendServlet: " + str1);
			//判斷該會員連結是否已經認證
			if(!str1.trim().equals("已審核".trim())){
				System.out.println(str1.trim().equals("已審核".trim()));
				bean.setAccountStatus("已審核");
				dao.update(bean);
				HttpSession session = request.getSession();
				session.setAttribute("LoginOK", bean);
				response.sendRedirect("registerVerification/template.jsp");
			} else {
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
}

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

import model.MemberBean;
import model.dao.MemberDAOJdbc;
import sendMail.model.SendMailService;

@WebServlet("/forgotPassword/forgotPassword.do")
public class ForgotPasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("forgotPassword.jsp call ForgotPasswordServlet is successed!!");
		
		Map<String, String> errMsg = new HashMap<String,String>();
		request.setAttribute("MsgErr", errMsg);
		//將使用者輸入的信箱與DB內註冊的信箱做比對,假如一樣即可發送mail給使用者
		String userEmail = request.getParameter("email");
		MemberDAOJdbc dao = new MemberDAOJdbc();
		MemberBean bean = dao.selectEmail(userEmail);
		//假如使用者所填寫的email可於DB中搜尋的到
		if(bean != null){
			//確認該會員是否已經通過驗證
			String dbAccountStatus = bean.getAccountStatus();
			if(dbAccountStatus.trim().equals("已審核".trim())){
//				System.out.println("可從DB中取出該會員的資訊");
				
				String dbFirstName = bean.getFirstName();
				int dbMemberId = bean.getMemberId();
				byte[] dbPassword = bean.getPassword();

				SendMailService sms = new SendMailService();
				boolean sendResult = sms.sendForgotPWMail(userEmail, dbMemberId, dbFirstName, dbPassword);
				
				if(sendResult){
					//假如會員已經通過認證而且忘記密碼認證信發送成功則......
					response.sendRedirect("forgotTemplate.jsp");
				}
				
			} else {
				System.out.println("該帳號尚未通過審核");
			}
		}
		else if(bean == null){
			System.out.println("使用者填寫的信箱於資料庫中搜尋不到");
			//看是要轉到另外一個view或者忘記密碼表單直接顯示該email搜尋不到的訊息!!
			errMsg.put("inputError", "該帳號沒有註冊資訊,或者您沒有填寫任何資料");
		}
		
		//假如有錯誤
		if(!errMsg.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.jsp");
			rd.forward(request, response);
			return;
		}
	}
	
}

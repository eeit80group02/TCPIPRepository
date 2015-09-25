package controller;
/*
 * 檔案: ShowSchoolDataServlet.java
 * 功能: 當使用者點選修改學校連結時會從資料庫撈取學校的資料顯示在修改的欄位
 * 
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import model.MemberBean;
import model.SchoolBean;
import model.dao.MemberDAOJdbc;
import model.dao.SchoolDAOJdbc;

@WebServlet("/personal/showMemberData.do")
public class ShowMemberDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("personmanager.jsp call ShowMemberDataServlet success!!");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberBean tempBean = (MemberBean)session.getAttribute("LoginOK");
		
		MemberDAOJdbc dao = new MemberDAOJdbc();
		if(tempBean.getMemberId() != null){
			MemberBean bean = dao.select(tempBean.getMemberId());
			if(bean.getPicture() != null){
				bean.setBase64String(GlobalService.convertByteArrayToBase64String(bean.getPictureName(), bean.getPicture()));
			}
			session.setAttribute("member", bean);
			response.sendRedirect(getServletContext().getContextPath() + "/personal/maintainpersonal.jsp");
		} else {
			System.out.println("bean.getMemberId() = null");
		}
	}
	public static void main(String[] args) {
	}

}

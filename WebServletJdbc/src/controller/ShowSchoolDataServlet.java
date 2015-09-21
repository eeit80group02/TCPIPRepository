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
import model.SchoolBean;
import model.dao.SchoolDAOJdbc;

@WebServlet("/school/showSchoolData.do")
public class ShowSchoolDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("school.jsp call ShowSchoolDataServlet success!!");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		SchoolBean tempBean = (SchoolBean)session.getAttribute("LoginOK");
		SchoolDAOJdbc dao = new SchoolDAOJdbc();
		if(tempBean.getSchoolId() != null){
			SchoolBean bean = dao.findByPrimaryKey(tempBean.getSchoolId());
			if(bean.getFrontCover() != null){
				bean.setBase64String(GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(), bean.getFrontCover()));
			}
			session.setAttribute("school", bean);
			response.sendRedirect(getServletContext().getContextPath() + "/school/schoolupdate.jsp");
		} else {
			System.out.println("bean.getSchoolId() = null");
		}
	}
	public static void main(String[] args) {
	}

}

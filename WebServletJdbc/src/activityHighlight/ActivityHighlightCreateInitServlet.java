package activityHighlight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.ActivityHighlightBean;
import model.FullProjBean;
import model.MemberBean;
import model.dao.ActivityHighlightDAOJdbc;
import model.dao.FullProjDAOJdbc;
import model.dao.MemberDAOJdbc;

/**
 * Servlet implementation class ActicityHighlightInitServlet
 */
@WebServlet("/ActivityHighlightCreateInitServlet")
public class ActivityHighlightCreateInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullProjId = request.getParameter("fullProjId");
		String memberId = request.getParameter("memberId");
		// get memberId, fullProjId from outer page

		ActivityHighlightBean result = new ActivityHighlightDAOJdbc().findByPrimaryKey(Integer.valueOf(fullProjId));
		if (result == null) {

			FullProjDAOJdbc proj = new FullProjDAOJdbc();
			FullProjBean projBean = proj.findByPrimaryKey(Integer.valueOf(fullProjId));
			String projName = projBean.getTitle();

			MemberDAOJdbc member = new MemberDAOJdbc();
			MemberBean memberBean = member.select(Integer.valueOf(memberId));
			String memberName = memberBean.getLastName() + memberBean.getFirstName();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("projName", projName);
			jsonObject.put("memberName", memberName);
			jsonObject.put("fullProjId", fullProjId);
			jsonObject.put("memberId", memberId);

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(jsonObject.toJSONString());
		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "花絮已存在!");
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(jsonObject.toJSONString());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

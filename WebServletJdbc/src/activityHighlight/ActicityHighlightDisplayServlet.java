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
 * Servlet implementation class ActicityHighlightDisplayServlet
 */
@WebServlet("/ActicityHighlightDisplayServlet")
public class ActicityHighlightDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberId = 1;
		int fullProjId = 1;
		
		FullProjDAOJdbc proj = new FullProjDAOJdbc();
		FullProjBean projBean = proj.findByPrimaryKey(fullProjId);
		String projName = projBean.getTitle();
		
		MemberDAOJdbc member = new MemberDAOJdbc();
		MemberBean memberBean = member.select(memberId);
		String memberName = memberBean.getLastName() + memberBean.getFirstName();
		
		ActivityHighlightDAOJdbc activity = new ActivityHighlightDAOJdbc();
		ActivityHighlightBean activityBean = activity.findByPrimaryKey(fullProjId);
		
		JSONObject jsonObject = new JSONObject();
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out= response.getWriter();
		if(activityBean!=null){
			jsonObject.put("projName", projName);
			jsonObject.put("memberName", memberName);
			jsonObject.put("videoURL", activityBean.getVideoURL());
			jsonObject.put("frontCover", new String(activityBean.getFrontCover()));
			jsonObject.put("content", activityBean.getContent());
			out.write(jsonObject.toJSONString());
		} else {
			jsonObject.put("error", "尚未建立花絮!");
			out.write(jsonObject.toJSONString());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

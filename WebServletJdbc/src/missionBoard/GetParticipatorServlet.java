package missionBoard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.MemberBean;
import model.ParticipatorBean;
import model.dao.MemberDAOJdbc;
import model.dao.ParticipatorDAOJdbc;

@WebServlet("/GetParticipatorServlet")
public class GetParticipatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer missionBoardId = Integer.valueOf(request.getParameter("missionBoardId"));
		Integer fullProjId = Integer.valueOf(request.getParameter("fullProjId"));
		
		JSONObject members = new JSONObject();
		List<ParticipatorBean> beans = new ParticipatorDAOJdbc().findByFullProjId(fullProjId);
		for(ParticipatorBean pb: beans){
			JSONObject member = new JSONObject();
			Integer memberId = pb.getMemberId();
			MemberBean memberBean = new MemberDAOJdbc().select(memberId);
			String memberName = memberBean.getLastName() + memberBean.getFirstName();
			
			member.put("memberName", memberName);
			member.put("memberId", memberBean.getMemberId());
			members.put("member"+memberBean.getMemberId(), member);
		}
		
		
		System.out.println("member="+members);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("members", members);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.write(jsonObject.toJSONString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

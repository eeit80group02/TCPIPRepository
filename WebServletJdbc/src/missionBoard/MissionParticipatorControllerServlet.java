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
import model.MissionParticipatorBean;
import model.dao.MemberDAOJdbc;
import model.dao.MissionParticipatorDAOJdbc;

@WebServlet("/MissionParticipatorControllerServlet")
public class MissionParticipatorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String memberId = request.getParameter("memberId");
		String missionId = request.getParameter("missionId");

		System.out.println(action);
		System.out.println(memberId);
		System.out.println(missionId);

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (action.equalsIgnoreCase("insert")) {
			MissionParticipatorBean missionParticipatorBean = new MissionParticipatorBean();
			missionParticipatorBean.setMemberId(Integer.valueOf(memberId));
			missionParticipatorBean.setMissionId(Integer.valueOf(missionId));
			MissionParticipatorBean result = new MissionParticipatorDAOJdbc().insert(missionParticipatorBean);

			if (result != null) {
				out.write("Insert succeed!");
			} else {
				out.write("Insert failed!");
			}
		} else if (action.equalsIgnoreCase("delete")) {
			List<MissionParticipatorBean> result = new MissionParticipatorDAOJdbc()
					.selectByMissionId(Integer.valueOf(missionId));
			int missionParticipatorId = 0;
			for (MissionParticipatorBean bean : result) {
				if (bean.getMemberId() == Integer.valueOf(memberId)) {
					missionParticipatorId = bean.getMissionParticipatorId();
				}
			}

			if (missionParticipatorId > 0) {
				boolean deleteResult = new MissionParticipatorDAOJdbc().delete(missionParticipatorId);
				if (deleteResult) {
					out.write("Delete succeed!");
				} else {
					out.write("Delete failed!");
				}
			} else {
				out.write("No mission found! Not going to delete.");
			}
		} else if (action.equalsIgnoreCase("get")) {
			List<MissionParticipatorBean> result = new MissionParticipatorDAOJdbc()
					.selectByMissionId(Integer.valueOf(missionId));

			if (result != null) {
				JSONObject missionParticipator = new JSONObject();
				for (MissionParticipatorBean bean : result) {
					int memberNumber = bean.getMemberId();
					MemberBean memberBean = new MemberDAOJdbc().select(memberNumber);
					String memberName = memberBean.getLastName() + memberBean.getFirstName();

					JSONObject member = new JSONObject();
					member.put("memberName", memberName);
					member.put("memberId", memberNumber);

					missionParticipator.put("member" + memberNumber, member);
				}

				response.setContentType("application/json; charset=UTF-8");
				out.write(missionParticipator.toJSONString());
			} else {
				out.write("Mission not found!");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

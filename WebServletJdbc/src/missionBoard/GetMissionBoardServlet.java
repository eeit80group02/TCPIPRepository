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
import model.MissionBean;
import model.MissionBoardBean;
import model.MissionSetBean;
import model.dao.MemberDAOJdbc;
import model.dao.MissionBoardDAOJdbc;
import model.dao.MissionDAOJdbc;
import model.dao.MissionSetDAOJdbc;

@WebServlet("/GetMissionBoardServlet")
public class GetMissionBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer fullProjId = Integer.valueOf(request.getParameter("fullProjId"));

		MissionBoardDAOJdbc mbdao = new MissionBoardDAOJdbc();
		MissionBoardBean board = mbdao.findByFullProjId(fullProjId);

		if (board != null) {
			String boardName = board.getName();
			Integer missionBoardId = board.getMissionBoardId();
			Integer missionSetNum = board.getMissionSetNum();
			JSONObject missionBoard = new JSONObject();
			missionBoard.put("fullProjId", fullProjId);
			missionBoard.put("missionBoardId", missionBoardId);
			missionBoard.put("boardName", boardName);
			missionBoard.put("missionSetNum", missionSetNum);

			JSONObject missionSets = new JSONObject();
			JSONObject missions = new JSONObject();
			List<MissionSetBean> missionSetBeans = new MissionSetDAOJdbc().findByMissionBoardID(missionBoardId);
			if (missionSetBeans != null) {
				for (MissionSetBean bean : missionSetBeans) {
					JSONObject missionSet = new JSONObject();
					missionSet.put("missionSetId", bean.getMissionSetId());
					missionSet.put("missionSetName", bean.getName());
					missionSet.put("missionSetOrder", bean.getMissionSetOrder());

					missionSets.put("missionSet" + bean.getMissionSetId(), missionSet);

					List<MissionBean> missionBeans = new MissionDAOJdbc().findByMissionSetId(bean.getMissionSetId());
					for (MissionBean missionBean : missionBeans) {
						JSONObject mission = new JSONObject();
						Integer host = missionBean.getHost();
						MemberBean mb = new MemberDAOJdbc().select(host);
						String hostName = mb.getLastName() + mb.getFirstName();
						Integer hostId = mb.getMemberId();
						System.out.println(hostName);

						mission.put("host", hostName);
						mission.put("memberId", hostId);
						mission.put("name", missionBean.getName());
						mission.put("missionSetId", missionBean.getMissionSetId());
						mission.put("missionId", missionBean.getMissionId());
						mission.put("missionEndTime", missionBean.getEndTime().toString());
						mission.put("missionPriority", missionBean.getMissionPriority());
						mission.put("missionPosition", missionBean.getMissionPosition());
						mission.put("missionStatus", missionBean.getMissionStatus());
						mission.put("mainMissionId", missionBean.getMainMissionId());

						System.out.println("mission="+mission);

						missions.put("mission" + missionBean.getMissionId(), mission);
					}
				}

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", "succeed");
				jsonObject.put("missionBoard", missionBoard);
				jsonObject.put("missionSets", missionSets);
				jsonObject.put("missions", missions);

				System.out.println("jsonObject=" + jsonObject);

				response.setContentType("application/json; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(jsonObject.toJSONString());
			} else {
				response.setContentType("application/json; charset=UTF-8");
				PrintWriter out = response.getWriter();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", "noMissionSetFound!");
				out.write(jsonObject.toJSONString());
			}
		} else {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "noBoardFound");
			out.write(jsonObject.toJSONString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

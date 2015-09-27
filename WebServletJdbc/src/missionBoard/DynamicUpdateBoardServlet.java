package missionBoard;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import global.GlobalService;
import model.MissionBean;
import model.MissionSetBean;
import model.dao.MissionDAOJdbc;
import model.dao.MissionSetDAOJdbc;

@WebServlet("/DynamicUpdateBoardServlet")
public class DynamicUpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUCCEED = "succeed";
	private static final String FAILED = "failed";
	private static final String UPDATE_MISSION_SET_ORDER = "UpdateMissionSetOrder";
	private static final String UPDATE_MISSION_SET_NAME = "UpdateMissionSetName";
	private static final String UPDATE_MISSION_POSITION = "UpdateMissionPosition";
	private static final String INSERT_MISSION_SET = "InsertMissionSet";
	private static final String DELETE_MISSION_SET = "DeleteMissionSet";
	private static final String INSERT_MISSION = "InsertMission";
	private static final String UPDATE_MISSION = "UpdateMission";
	private static final String DELETE_MISSION = "DeleteMission";

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase(UPDATE_MISSION_SET_ORDER) || action.equalsIgnoreCase(UPDATE_MISSION_SET_NAME)) {
			String missionSetOrder = request.getParameter("missionSetOrder");
			String missionSetId = request.getParameter("missionSetId");
			String name = request.getParameter("name");
			String missionBoardId = request.getParameter("missionBoardId");

			System.out.println("missionSetOrder=" + missionSetOrder);
			System.out.println("missionSetId=" + missionSetId);
			System.out.println("name=" + name);
			System.out.println("missionBoardId=" + missionBoardId);

			MissionSetBean missionSetBean = new MissionSetBean();
			missionSetBean.setMissionSetId(Integer.valueOf(missionSetId));
			missionSetBean.setMissionSetOrder(Integer.valueOf(missionSetOrder));
			missionSetBean.setName(name);
			missionSetBean.setMissionBoardId(Integer.valueOf(missionBoardId));
			MissionSetBean result = new MissionSetDAOJdbc().update(missionSetBean);

			JSONObject resultObject = new JSONObject();
			resultObject.put("missionBoardId", result.getMissionBoardId());
			resultObject.put("missionSetId", result.getMissionSetId());
			resultObject.put("missionSetOrder", result.getMissionSetOrder());
			resultObject.put("name", result.getName());

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result != null) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", SUCCEED);
				jsonObject.put("missionSet", resultObject);
				out.write(jsonObject.toJSONString());
			} else {
				out.write(FAILED);
			}
		} else if (action.equalsIgnoreCase(UPDATE_MISSION_POSITION) || action.equalsIgnoreCase(UPDATE_MISSION)) {
			String missionId = request.getParameter("missionId");
			String missionSetId = request.getParameter("missionSetId");
			String name = request.getParameter("name");
			String host = request.getParameter("host");
			String endTime = request.getParameter("endTime");
			String missionPriority = request.getParameter("missionPriority");
			String missionPosition = request.getParameter("missionPosition");
			String missionStatus = request.getParameter("missionStatus");
			String mainMissionId = request.getParameter("mainMissionId");

			System.out.println("missionId=" + missionId);
			System.out.println("missionSetId=" + missionSetId);
			System.out.println("name=" + name);
			System.out.println("host=" + host);
			System.out.println("endTime=" + endTime);
			System.out.println("missionPriority=" + missionPriority);
			System.out.println("missionPosition=" + missionPosition);
			System.out.println("missionStatus=" + missionStatus);
			System.out.println("mainMissionId=" + mainMissionId);

			MissionBean missionBean = new MissionBean();
			missionBean.setMissionId(Integer.valueOf(missionId));
			missionBean.setMissionSetId(Integer.valueOf(missionSetId));
			missionBean.setName(name);
			missionBean.setHost(Integer.valueOf(host));
			try {
				missionBean.setEndTime(GlobalService.convertStringToDate(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			missionBean.setMissionPriority(missionPriority);
			missionBean.setMissionPosition(Integer.valueOf(missionPosition));
			missionBean.setMissionStatus(missionStatus);
			if (mainMissionId.equalsIgnoreCase("") || mainMissionId.equalsIgnoreCase("null") || mainMissionId == null) {
				missionBean.setMainMissionId(null);
			} else {
				missionBean.setMainMissionId(Integer.valueOf(mainMissionId));
			}
			MissionBean result = new MissionDAOJdbc().update(missionBean);

			JSONObject resultObject = new JSONObject();
			resultObject.put("endTime", result.getEndTime().toString());
			resultObject.put("host", result.getHost());
			resultObject.put("mainMissionId", result.getMainMissionId());
			resultObject.put("missionId", result.getMissionId());
			resultObject.put("missionPosition", result.getMissionPosition());
			resultObject.put("missionPriority", result.getMissionPriority());
			resultObject.put("missionSetId", result.getMissionSetId());
			resultObject.put("missionStatus", result.getMissionStatus());
			resultObject.put("name", result.getName());

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result != null) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", SUCCEED);
				jsonObject.put("mission", resultObject);
				out.write(jsonObject.toJSONString());
			} else {
				out.write(FAILED);
			}
		} else if (action.equalsIgnoreCase(INSERT_MISSION_SET)) {
			String missionBoardId = request.getParameter("missionBoardId");
			String name = request.getParameter("name");
			String missionSetOrder = request.getParameter("missionSetOrder");

			System.out.println("missionBoardId=" + missionBoardId);
			System.out.println("name=" + name);
			System.out.println("missionSetOrder=" + missionSetOrder);

			MissionSetBean missionSetBean = new MissionSetBean();
			missionSetBean.setMissionBoardId(Integer.valueOf(missionBoardId));
			missionSetBean.setName(name);
			missionSetBean.setMissionSetOrder(Integer.valueOf(missionSetOrder));
			MissionSetBean result = new MissionSetDAOJdbc().insert(missionSetBean);

			JSONObject resultObject = new JSONObject();
			resultObject.put("missionBoardId", result.getMissionBoardId());
			resultObject.put("missionSetId", result.getMissionSetId());
			resultObject.put("missionSetOrder", result.getMissionSetOrder());
			resultObject.put("name", result.getName());

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result != null) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", SUCCEED);
				jsonObject.put("missionSet", resultObject);
				out.write(jsonObject.toJSONString());
			} else {
				out.write(FAILED);
			}
		} else if (action.equalsIgnoreCase(DELETE_MISSION_SET)) {
			String missionSetId = request.getParameter("missionSetId");

			System.out.println("missionSetId=" + missionSetId);

			List<MissionBean> beans = new MissionDAOJdbc().findByMissionSetId(Integer.valueOf(missionSetId));
			for (MissionBean bean : beans) {
				if (bean.getMainMissionId() != null) {
					// this is subMission, delete first
					boolean deleteSubMission = new MissionDAOJdbc().delete(bean.getMissionId());
					System.out.println("Delete SubMission: " + deleteSubMission);
				}
			}
			System.out.println("All subMission under mission should be removed!");

			for (MissionBean bean : beans) {
				if (bean.getMainMissionId() == null) {
					// this is Mission, delete before MisisonSet
					boolean deleteMission = new MissionDAOJdbc().delete(bean.getMissionId());
					System.out.println("Delete Mission: " + deleteMission);
				}
			}
			System.out.println("All mission under missionSet should be removed!");

			boolean result = new MissionSetDAOJdbc().delete(Integer.valueOf(missionSetId));
			System.out.println("Remove missionSet: " + result);

			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result) {
				out.write(SUCCEED);
			} else {
				out.write(FAILED);
			}
		} else if (action.equalsIgnoreCase(INSERT_MISSION)) {
			String missionSetId = request.getParameter("missionSetId");
			String name = request.getParameter("name");
			String host = request.getParameter("host");
			String endTime = request.getParameter("endTime");
			String missionPriority = request.getParameter("missionPriority");
			String missionPosition = request.getParameter("missionPosition");
			String missionStatus = request.getParameter("missionStatus");
			String mainMissionId = request.getParameter("mainMissionId");

			System.out.println("missionSetId=" + missionSetId);
			System.out.println("name=" + name);
			System.out.println("host=" + host);
			System.out.println("endTime=" + endTime);
			System.out.println("missionPriority=" + missionPriority);
			System.out.println("missionPosition=" + missionPosition);
			System.out.println("missionStatus=" + missionStatus);
			System.out.println("mainMissionId=" + mainMissionId);

			MissionBean missionBean = new MissionBean();
			missionBean.setMissionSetId(Integer.valueOf(missionSetId));
			missionBean.setName(name);
			missionBean.setHost(Integer.valueOf(host));
			try {
				missionBean.setEndTime(GlobalService.convertStringToDate(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			missionBean.setMissionPriority(missionPriority);
			missionBean.setMissionPosition(Integer.valueOf(missionPosition));
			missionBean.setMissionStatus(missionStatus);
			if (mainMissionId.equalsIgnoreCase("") || mainMissionId.equalsIgnoreCase("null") || mainMissionId == null) {
				missionBean.setMainMissionId(null);
			} else {
				missionBean.setMainMissionId(Integer.valueOf(mainMissionId));
			}
			MissionBean result = new MissionDAOJdbc().insert(missionBean);

			JSONObject resultObject = new JSONObject();
			resultObject.put("endTime", result.getEndTime().toString());
			resultObject.put("host", result.getHost());
			resultObject.put("mainMissionId", result.getMainMissionId());
			resultObject.put("missionId", result.getMissionId());
			resultObject.put("missionPosition", result.getMissionPosition());
			resultObject.put("missionPriority", result.getMissionPriority());
			resultObject.put("missionSetId", result.getMissionSetId());
			resultObject.put("missionStatus", result.getMissionStatus());
			resultObject.put("name", result.getName());

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result != null) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", SUCCEED);
				jsonObject.put("mission", resultObject);
				out.write(jsonObject.toJSONString());
			} else {
				out.write(FAILED);
			}
		} else if (action.equalsIgnoreCase(DELETE_MISSION)) {
			String missionId = request.getParameter("missionId");

			System.out.println("delete missionId=" + missionId);

			List<MissionBean> beans = new MissionDAOJdbc().findByMainMissionId(Integer.valueOf(missionId));
			for (MissionBean bean : beans) {
				if (bean.getMainMissionId() != null) {
					// this is subMission, delete first
					boolean deleteSubMission = new MissionDAOJdbc().delete(bean.getMissionId());
					System.out.println("Delete SubMission: " + deleteSubMission);
				}
			}
			System.out.println("All subMission under mission should be removed!");

			boolean result = new MissionDAOJdbc().delete(Integer.valueOf(missionId));
			System.out.println("Remove mission: " + result);

			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result) {
				out.write(SUCCEED);
			} else {
				out.write(FAILED);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

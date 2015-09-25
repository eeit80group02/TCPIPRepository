package missionBoard;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.GlobalService;
import model.MissionBean;
import model.MissionSetBean;
import model.dao.MissionDAOJdbc;
import model.dao.MissionSetDAOJdbc;

/**
 * Servlet implementation class DynamicUpdateBoardServlet
 */
@WebServlet("/DynamicUpdateBoardServlet")
public class DynamicUpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUCCEED = "succeed";
	private static final String FAILED = "failed";
	private static final String UPDATE_MISSIONSETORDER = "UpdateMissionSetOrder";
	private static final String UPDATE_MISSIONPOSITION = "UpdateMissionPosition";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase(UPDATE_MISSIONSETORDER)) {
			String missionSetOrder = request.getParameter("missionSetOrder");
			String missionSetId = request.getParameter("missionSetId");
			String missionSetName = request.getParameter("missionSetName");
			String missionBoardId = request.getParameter("missionBoardId");

			System.out.println(missionSetOrder);
			System.out.println(missionSetId);
			System.out.println(missionSetName);
			System.out.println(missionBoardId);
			
			MissionSetBean missionSetBean = new MissionSetBean();
			missionSetBean.setMissionSetId(Integer.valueOf(missionSetId));
			missionSetBean.setMissionSetOrder(Integer.valueOf(missionSetOrder));
			missionSetBean.setName(missionSetName);
			missionSetBean.setMissionBoardId(Integer.valueOf(missionBoardId));
			MissionSetBean result = new MissionSetDAOJdbc().update(missionSetBean);
			if (result != null) {
				out.write(UPDATE_MISSIONSETORDER + ":" + SUCCEED);
			} else {
				out.write(UPDATE_MISSIONSETORDER + ":" + FAILED);
			}
		} else if(action.equalsIgnoreCase(UPDATE_MISSIONPOSITION)){
			String missionId = request.getParameter("missionId");
			String missionSetId = request.getParameter("missionSetId");
			String name = request.getParameter("name");
			String host = request.getParameter("host");
			String endTime = request.getParameter("endTime");
			String missionPriority = request.getParameter("missionPriority");
			String missionPosition = request.getParameter("missionPosition");
			String missionStatus = request.getParameter("missionStatus");
			String mainMissionId = request.getParameter("mainMissionId");
			
			System.out.println("missionId="+missionId);
			System.out.println("missionSetId="+missionSetId);
			System.out.println("name="+name);
			System.out.println("host="+host);
			System.out.println("endTime="+endTime);
			System.out.println("missionPriority="+missionPriority);
			System.out.println("missionPosition="+missionPosition);
			System.out.println("missionStatus="+missionStatus);
			System.out.println("mainMissionId="+mainMissionId);
			
			MissionBean missionBean = new MissionBean();
			missionBean.setMissionId(Integer.valueOf(missionId));
			missionBean.setMissionSetId(Integer.valueOf(missionSetId));
			missionBean.setName(name);
			missionBean.setHost(Integer.valueOf(host));
			try {
				missionBean.setEndTime(GlobalService.convertStringToDate(endTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			missionBean.setMissionPriority(missionPriority);
			missionBean.setMissionPosition(Integer.valueOf(missionPosition));
			missionBean.setMissionStatus(missionStatus);
			if( mainMissionId.equalsIgnoreCase("") ){
				missionBean.setMainMissionId(null);
			} else{
				missionBean.setMainMissionId(Integer.valueOf(mainMissionId));
			}
			MissionBean result = new MissionDAOJdbc().update(missionBean);
			if (result != null) {
				out.write(UPDATE_MISSIONPOSITION + ":" + SUCCEED);
			} else {
				out.write(UPDATE_MISSIONPOSITION + ":" + FAILED);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

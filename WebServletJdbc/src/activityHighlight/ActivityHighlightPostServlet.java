package activityHighlight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActivityHighlightBean;
import model.dao.ActivityHighlightDAOJdbc;
import model.dao.FullProjDAOJdbc;

/**
 * Servlet implementation class ActivityHighlightPostServlet
 */
@WebServlet("/ActivityHighlightPostServlet")
public class ActivityHighlightPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String content = request.getParameter("content");
		String frontCover = request.getParameter("frontCover");
		String fullProjId = request.getParameter("fullProjId");
		String memberId = request.getParameter("memberId");
		String frontCoverName = request.getParameter("frontCoverName");
		String videoURL = request.getParameter("videoURL");

		if (content.equalsIgnoreCase("") || frontCover.equalsIgnoreCase("") || frontCoverName.equalsIgnoreCase("") || videoURL.equalsIgnoreCase("")) {
			out.write("確認欄位已填");
		} else {
			ActivityHighlightDAOJdbc activity = new ActivityHighlightDAOJdbc();
			ActivityHighlightBean activityBean = new ActivityHighlightBean();
			activityBean.setFullProjId(Integer.valueOf(fullProjId));
			activityBean.setMemberId(Integer.valueOf(memberId));
			activityBean.setFrontCoverName(frontCoverName);
			activityBean.setFrontCover(frontCover.getBytes());
			activityBean.setFrontCoverLength((long) frontCover.getBytes().length);
			activityBean.setVideoURL(videoURL);
			activityBean.setContent(content);
			ActivityHighlightBean resultBean = activity.insert(activityBean);

			if (resultBean != null) {
				out.write("花絮創建成功!");
			} else {
				out.write("花絮創建失敗!");
			}
		}
	}

}

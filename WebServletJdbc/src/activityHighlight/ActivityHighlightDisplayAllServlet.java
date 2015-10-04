package activityHighlight;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import global.GlobalService;
import model.ActivityHighlightBean;
import model.FullProjBean;
import model.MemberBean;
import model.dao.ActivityHighlightDAOJdbc;
import model.dao.FullProjDAOJdbc;
import model.dao.MemberDAOJdbc;

@WebServlet("/ActivityHighlightDisplayAllServlet.do")
public class ActivityHighlightDisplayAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			List<ActivityHighlightBean> queryResult = new ActivityHighlightDAOJdbc().getAll();
				if(queryResult.size() != 0){
					List<ActivityHighlightBean> beanstransferToBase64 = new ArrayList<ActivityHighlightBean>();
					for(ActivityHighlightBean bean : queryResult){
						int fullProjId = bean.getFullProjId();
						ActivityHighlightDAOJdbc jdbcService = new ActivityHighlightDAOJdbc();
						FullProjBean fullProjBean = jdbcService.getJoinFullProjBean(fullProjId);
						if(fullProjBean != null){
							bean.setFullProjBean(fullProjBean);
						}
						bean.setBase64String(new String(bean.getFrontCover(),"UTF-8"));
						beanstransferToBase64.add(bean);

					}
					
					request.setAttribute("activityHighLightAll", beanstransferToBase64);
					request.getRequestDispatcher("/Activity/ActivityHighlightDisplayAll.jsp").forward(request, response);;
				
				}else{
					
				}
		
	
//		List<ActivityHighlightBean> beans = new ActivityHighlightDAOJdbc().getAll();
//		
//		JSONObject activityhighlights = new JSONObject();
//		for(ActivityHighlightBean bean : beans){
//			JSONObject activityhighlight = new JSONObject();
//			activityhighlight.put("content", bean.getContent());
//			activityhighlight.put("frontCover", new String(bean.getFrontCover(), "UTF-8"));
//			activityhighlight.put("fullProjId", bean.getFullProjId());
//			activityhighlight.put("memberId", bean.getMemberId());
//			activityhighlight.put("videoURL", bean.getVideoURL());
//			
//			FullProjBean fullProj = new FullProjDAOJdbc().findByPrimaryKey(bean.getFullProjId());
//			activityhighlight.put("title", fullProj.getTitle());
//			
//			MemberBean member = new MemberDAOJdbc().select(bean.getMemberId());
//			String memberName = member.getLastName() + member.getFirstName();
//			activityhighlight.put("memberName", memberName);
//			
//			activityhighlights.put("activityhighlight"+bean.getFullProjId(), activityhighlight);
//		}
//		
//		
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.write(activityhighlights.toJSONString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package model.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.MemberBean;
import model.ProjDiscussBean;
import model.ProjModifyBean;
import model.dao.MemberDAOJdbc;
import model.dao.ProjDiscussDAOJdbc;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.ProjDiscussDAO;

public class ProjDiscussService
{
	private ProjDiscussDAO projDiscusDAO = null;
	private MemberDAO memberDAO = null;
	public ProjDiscussService()
	{
		projDiscusDAO = new ProjDiscussDAOJdbc();
		memberDAO = new MemberDAOJdbc();
	}
	
	public JSONObject select(int fullProjId)
	{
		List<ProjDiscussBean> beans = projDiscusDAO.selectByFullProjId(fullProjId);
		JSONArray jsonArray = new JSONArray();
		for(ProjDiscussBean bean : beans)
		{
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("projDiscussId",bean.getProjDiscussId().toString());
			MemberBean questionMemberBean = memberDAO.select(bean.getQuestionMemberId());
			String questionMember;
			if(questionMemberBean.getGender().equals("男"))
			{
				questionMember = String.format("[No.%04d] " + questionMemberBean.getLastName() + "先生",bean.getQuestionMemberId());
			}
			else
			{
				questionMember = String.format("[No.%04d] " + questionMemberBean.getLastName() + "小姐",bean.getQuestionMemberId());
			}
			jsonObject.put("questionMemberId",bean.getQuestionMemberId());
			jsonObject.put("questionMember",questionMember);
			jsonObject.put("questionMemberContent",bean.getQuestionMemberContent().toString());
			
			java.util.Date questionTime = bean.getQuestionMemberTime();
			jsonObject.put("questionMemberTime",String.format("%TF %TT",questionTime,questionTime));

			
			if(bean.getAnswerMemberId() != null)
			{

				jsonObject.put("answerMemberId",bean.getAnswerMemberId());
				jsonObject.put("answerMember","發起者");
				jsonObject.put("answerMemberContent",bean.getAnswerMemberContent().toString());
				
				java.util.Date answerTime = bean.getAnswerMemberTime();
				jsonObject.put("answerMemberTime",String.format("%TF %TT",answerTime,answerTime));
			}
			else
			{
				jsonObject.put("answerMemberId","null");
			}
			jsonArray.add(jsonObject);
		}
		
		JSONObject result = new JSONObject();
		result.put("result",jsonArray);
		return result;
	}
	
	public JSONObject postDiscuss(ProjDiscussBean bean)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result","failure");
		if(bean != null)
		{
			bean.setQuestionMemberTime(new java.util.Date(System.currentTimeMillis()));
			ProjDiscussBean temp = projDiscusDAO.insert(bean);
			if(temp != null)
			{
				jsonObject.put("result","success");
			}
		}
		return jsonObject;
	}
	
	public JSONObject replyDiscuss(ProjDiscussBean bean)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result","failure");
		if(bean != null)
		{
			// 先查詢
			ProjDiscussBean temp = projDiscusDAO.findByPrimaryKey(bean.getProjDiscussId());
			temp.setAnswerMemberId(bean.getAnswerMemberId());
			temp.setAnswerMemberContent(bean.getAnswerMemberContent());
			temp.setAnswerMemberTime(new java.util.Date(System.currentTimeMillis()));
			
			bean = projDiscusDAO.update(temp);
			if(bean != null)
			{
				jsonObject.put("result","success");
			}
		}
		return jsonObject;
	}
	
	public static void main(String[] args)
	{
		
	}
}

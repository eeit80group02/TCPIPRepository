package model.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.MemberBean;
import model.ProjDiscusBean;
import model.ProjModifyBean;
import model.dao.MemberDAOJdbc;
import model.dao.ProjDiscusDAOJdbc;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.ProjDiscusDAO;

public class ProjDiscussService
{
	private ProjDiscusDAO projDiscusDAO = null;
	private MemberDAO memberDAO = null;
	public ProjDiscussService()
	{
		projDiscusDAO = new ProjDiscusDAOJdbc();
		memberDAO = new MemberDAOJdbc();
	}
	
	public JSONObject select(int fullProjId)
	{
		List<ProjDiscusBean> beans = projDiscusDAO.selectByFullProjId(fullProjId);
		JSONArray jsonArray = new JSONArray();
		for(ProjDiscusBean bean : beans)
		{
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("projDiscusId",bean.getProjDiscusId().toString());
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
			
			jsonObject.put("questionMemberId",questionMember);
			jsonObject.put("questionMemberContent",bean.getQuestionMemberContent().toString());
			
			java.util.Date questionTime = bean.getQuestionMemberTime();
			jsonObject.put("questionMemberTime",String.format("%TF %TT",questionTime,questionTime));

			
			if(bean.getAnswerMemberId() != null)
			{
				jsonObject.put("answerMemberId",bean.getAnswerMemberId().toString());
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
	public static void main(String[] args)
	{
		
	}

}

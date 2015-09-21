package model.service;

import java.util.Date;
import java.util.List;

import model.ProjModifyBean;
import model.dao.ProjModifyDAOJdbc;
import model.dao.interfaces.ProjModifyDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProjModifyService
{
	private ProjModifyDAO projModifyDAO;
	public ProjModifyService()
	{
		projModifyDAO = new ProjModifyDAOJdbc();
	}
	
	public JSONObject select(int fullProjId)
	{
		List<ProjModifyBean> beans = projModifyDAO.selectByFullProjId(fullProjId);
		JSONArray jsonArray = new JSONArray();
		for(ProjModifyBean bean : beans)
		{
			JSONObject jsonObject = new JSONObject();
			
			if(bean.getMemberId() != null)
			{
				jsonObject.put("memberId",bean.getMemberId().toString());
				jsonObject.put("memberMessage",bean.getMemberMessage().toString());
				jsonObject.put("memberMessageTime",bean.getMemberMessageTime().toString());
			}
			else
			{
				jsonObject.put("memberId","null");
			}
			
			if(bean.getSchoolId() != null)
			{
				jsonObject.put("schoolId",bean.getSchoolId().toString());
				jsonObject.put("schoolMessage",bean.getSchoolMessage().toString());
				jsonObject.put("schoolMessageTime",bean.getSchoolMessageTime().toString());
			}
			else
			{
				jsonObject.put("schoolId","null");
			}
			jsonArray.add(jsonObject);
		}
		
		JSONObject result = new JSONObject();
		result.put("result",jsonArray);
		return result;
	}
	
	public JSONObject addMemberMessage(ProjModifyBean bean)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result","failure");
		if(bean != null)
		{
			bean.setMemberMessageTime(new java.util.Date(System.currentTimeMillis()));
			ProjModifyBean temp = projModifyDAO.insert(bean);
			if(temp != null)
			{
				jsonObject.put("result","success");
			}
		}
		return jsonObject;
	}
	
	public JSONObject addSchoolMessage(ProjModifyBean bean)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result","failure");
		if(bean != null)
		{
			bean.setSchoolMessageTime(new java.util.Date(System.currentTimeMillis()));
			ProjModifyBean temp = projModifyDAO.insert(bean);
			if(temp != null)
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

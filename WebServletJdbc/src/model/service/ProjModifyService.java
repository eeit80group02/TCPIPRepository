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
				
				java.util.Date memberDate = bean.getMemberMessageTime();
				// 格式化輸出 ex 2015-09-09 11:22:33
				jsonObject.put("memberMessageTime",String.format("%TF %TT",memberDate,memberDate));
				
			}
			else
			{
				jsonObject.put("memberId","null");
			}
			
			if(bean.getSchoolId() != null)
			{
				jsonObject.put("schoolId",bean.getSchoolId().toString());
				jsonObject.put("schoolMessage",bean.getSchoolMessage().toString());
				
				java.util.Date schoolDate = bean.getSchoolMessageTime();
				jsonObject.put("schoolMessageTime",String.format("%TF %TT",schoolDate,schoolDate));
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

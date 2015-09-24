package model.service;

import java.util.List;

import model.ActivityHighlightBean;
import model.FullProjBean;
import model.dao.ActivityHighlightDAOJdbc;
import model.dao.FullProjDAOJdbc;
import model.dao.interfaces.ActivityHighlightDAO;
import model.dao.interfaces.FullProjDAO;



public class ActicityHighlightService {
	
	private ActivityHighlightDAO activityHighlightDAO;
	private FullProjDAO fullProjDAO;
	public ActicityHighlightService(){
		activityHighlightDAO = new ActivityHighlightDAOJdbc();
		fullProjDAO = new FullProjDAOJdbc();
	}
	
	public ActivityHighlightBean creat(ActivityHighlightBean bean){
		ActivityHighlightBean result = null;
		FullProjBean fBean = null;
		fBean = fullProjDAO.findByPrimaryKey(bean.getFullProjId());
		if(fBean.getActivityEndTime().getTime()<System.currentTimeMillis()){
			System.out.println("時間未到");
			return result;
		}
		result = activityHighlightDAO.insert(bean);
		return result;	
	}
	public ActivityHighlightBean update(ActivityHighlightBean bean){
		ActivityHighlightBean result = null;
		result = activityHighlightDAO.update(bean);
		return result;	
	}
	public List<ActivityHighlightBean> displayAllforMember(ActivityHighlightBean bean){
		List<ActivityHighlightBean> result = null;
		result = activityHighlightDAO.findByPrimaryMemberId(bean);
		return result;	
	}
	public ActivityHighlightBean display(ActivityHighlightBean bean){
		ActivityHighlightBean result = null;
		result = activityHighlightDAO.findByPrimaryKey(bean.getFullProjId());
		return result;
	}
	public List<ActivityHighlightBean> displayAll(){
		List<ActivityHighlightBean> result = null;
		result = activityHighlightDAO.getAll();
		return result;	
	}
}

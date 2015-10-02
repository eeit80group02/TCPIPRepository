package model.service;

import java.util.List;

import model.TrackProjBean;
import model.dao.TrackProjDAOJdbc;
import model.dao.interfaces.TrackProjDAO;

public class FollowService {
	TrackProjDAO trackProjDAO = null;
	public FollowService(){
		trackProjDAO = new TrackProjDAOJdbc();
	}
	
	public TrackProjBean follow(TrackProjBean bean){
		TrackProjBean result = null;
		if(bean!=null){
			result = trackProjDAO.findByMemberId(bean.getMemberId(), bean.getFullProjId());
			if(result == null){
				trackProjDAO.insert(bean);
			}else if(result != null){
				trackProjDAO.delete(result.getTrackProjId());
			}
		}
		return result;
	}
	public List<TrackProjBean> displays(int memberId){
		List<TrackProjBean> result = null;
		if(memberId !=0){
			result = trackProjDAO.getMemberAll(memberId);
		}
		return result;
	}
}

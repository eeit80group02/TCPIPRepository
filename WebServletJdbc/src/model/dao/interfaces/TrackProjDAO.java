package model.dao.interfaces;

import java.util.List;

import model.TrackProjBean;

public interface TrackProjDAO
{

	public TrackProjBean findByPrimaryKey(int trackProjId);

	public List<TrackProjBean> getAll();

	public TrackProjBean insert(TrackProjBean bean);

	public TrackProjBean update(TrackProjBean bean);

	public boolean delete(int trackProjId);
	
	public TrackProjBean findByMemberId(int memberId, int fullProjId);
	
	public List<TrackProjBean> getMemberAll(int memberId);
}
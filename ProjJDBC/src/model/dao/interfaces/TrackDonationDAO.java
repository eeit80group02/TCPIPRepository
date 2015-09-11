package model.dao.interfaces;

import java.util.List;

import model.TrackDonationBean;

public interface TrackDonationDAO
{

	public TrackDonationBean findByPrimaryKey(int trackDonationId);

	public List<TrackDonationBean> getAll();

	public TrackDonationBean insert(TrackDonationBean bean);

	public TrackDonationBean update(TrackDonationBean bean);

	public boolean delete(int trackDonationId);

}
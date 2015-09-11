package model.dao.interfaces;

import java.util.List;

import model.DonationBean;

public interface DonationDAO
{

	public DonationBean insert(DonationBean bean);

	public DonationBean update(DonationBean bean);

	public boolean delete(int donationId);

	public DonationBean findByPrimaryKey(int donationId);

	public List<DonationBean> getAll();

}
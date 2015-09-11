package model.dao.interfaces;

import java.util.List;

import model.DonationDiscussBean;

public interface DonationDiscussDAO
{

	public DonationDiscussBean findByPrimaryKey(int donationDiscussId);

	public List<DonationDiscussBean> getAll();

	public DonationDiscussBean insert(DonationDiscussBean bean);

	public DonationDiscussBean update(DonationDiscussBean bean);

	public boolean delete(int donationDiscussId);

}
package model.dao.interfaces;

import java.util.List;

import model.DonationOrderBean;

public interface DonationOrderDAO
{

	public DonationOrderBean insert(DonationOrderBean bean);

	public boolean delete(int id);

	public DonationOrderBean update(DonationOrderBean bean);

	public DonationOrderBean findByPrimaryKey(int id);

	public List<DonationOrderBean> getAll();

}
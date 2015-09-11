package model.dao.interfaces;

import java.util.List;

import model.DonationOrderDetailBean;

public interface DonationOrderDetailDAO
{

	public DonationOrderDetailBean insert(DonationOrderDetailBean bean);

	public boolean delete(int id);

	public DonationOrderDetailBean update(DonationOrderDetailBean bean);

	public DonationOrderDetailBean findByPrimaryKey(int id);

	public List<DonationOrderDetailBean> getAll();

}
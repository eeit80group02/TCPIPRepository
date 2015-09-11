package model.dao.interfaces;

import java.util.List;

import model.OffersBean;

public interface OffersDAO
{

	public List<OffersBean> getAll();

	public OffersBean findByPrimaryKey(int schoolDemandId);

	public OffersBean insert(OffersBean bean);

	public OffersBean update(OffersBean bean);

	public boolean delete(int schoolDemandId);

}
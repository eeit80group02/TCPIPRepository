package model.dao.interfaces;

import java.util.List;

import model.SchoolDemandBean;

public interface SchoolDemandDAO
{

	public SchoolDemandBean findByPrimaryKey(int schoolDemandId);

	public List<SchoolDemandBean> getAll();

	public SchoolDemandBean insert(SchoolDemandBean bean);

	public SchoolDemandBean update(SchoolDemandBean bean);

	public boolean delete(int schoolDemandId);

}
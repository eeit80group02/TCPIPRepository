package model.dao.interfaces;

import java.util.List;

import model.SchoolBean;

public interface SchoolDAO
{

	public SchoolBean findByPrimaryKey(int schoolId);

	public List<SchoolBean> getAll();

	public SchoolBean insert(SchoolBean bean);

	public SchoolBean update(SchoolBean bean);

	public boolean delete(int schoolId);

}
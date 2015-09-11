package model.dao.interfaces;

import java.util.List;

import model.MissionBean;

public interface MissionDAO
{

	public MissionBean insert(MissionBean bean);

	public boolean delete(int id);

	public MissionBean update(MissionBean bean);

	public MissionBean findByPrimaryKey(int id);

	public List<MissionBean> getAll();

}
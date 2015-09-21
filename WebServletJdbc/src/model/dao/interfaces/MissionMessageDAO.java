package model.dao.interfaces;

import java.util.List;

import model.MissionMessageBean;

public interface MissionMessageDAO
{

	public List<MissionMessageBean> select();

	public MissionMessageBean select(int id);

	public boolean delete(int id);

	public MissionMessageBean update(MissionMessageBean bean);

	public MissionMessageBean insert(MissionMessageBean bean);

}
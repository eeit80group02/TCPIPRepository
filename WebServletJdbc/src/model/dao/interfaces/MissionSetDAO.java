package model.dao.interfaces;

import java.util.List;

import model.MissionSetBean;

public interface MissionSetDAO
{

	public List<MissionSetBean> findByMissionBoardID(int id);

	public List<MissionSetBean> getAll();

	public MissionSetBean findByPrimaryKey(int id);

	public MissionSetBean update(MissionSetBean bean);

	public boolean delete(int id);

	public MissionSetBean insert(MissionSetBean bean);

}
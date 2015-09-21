package model.dao.interfaces;

import java.util.List;

import model.MissionParticipatorBean;

public interface MissionParticipatorDAO
{

	public MissionParticipatorBean select(int id);

	public List<MissionParticipatorBean> select();

	public boolean delete(int id);

	public MissionParticipatorBean update(MissionParticipatorBean bean);

	public MissionParticipatorBean insert(MissionParticipatorBean bean);

}
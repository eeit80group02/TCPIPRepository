package model.dao.interfaces;

import java.util.List;

import model.ParticipatorBean;

public interface ParticipatorDAO
{

	public ParticipatorBean findByPrimaryKey(int participatorId);

	public List<ParticipatorBean> getAll();

	public ParticipatorBean insert(ParticipatorBean bean);

	public ParticipatorBean update(ParticipatorBean bean);

	public boolean delete(int participatorId);

	public List<ParticipatorBean> selectByFullProjId(int fullProjId);

	public List<ParticipatorBean> selectByMemberId(int memberId);

}
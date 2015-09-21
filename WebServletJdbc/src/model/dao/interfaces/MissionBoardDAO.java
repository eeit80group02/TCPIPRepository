package model.dao.interfaces;

import java.util.List;

import model.MissionBoardBean;

public interface MissionBoardDAO
{

	public MissionBoardBean insert(MissionBoardBean bean);

	public boolean delete(int id);

	public MissionBoardBean findByFullProjId(int id);

	public List<MissionBoardBean> getAll();

	public MissionBoardBean findByPrimaryKey(int id);

	public MissionBoardBean update(MissionBoardBean bean);

}
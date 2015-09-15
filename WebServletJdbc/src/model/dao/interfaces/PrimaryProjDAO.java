package model.dao.interfaces;

import java.util.List;

import model.PrimaryProjBean;

public interface PrimaryProjDAO
{

	public PrimaryProjBean findByPrimaryKey(int primaryProjId);

	public List<PrimaryProjBean> getAll();

	public PrimaryProjBean insert(PrimaryProjBean bean);

	public PrimaryProjBean update(PrimaryProjBean bean);

	public boolean delete(int primaryProjId);

	public List<PrimaryProjBean> selectByMemberId(int memberId);

}
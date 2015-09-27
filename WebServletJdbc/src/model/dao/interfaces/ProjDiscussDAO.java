package model.dao.interfaces;

import java.util.List;

import model.ProjDiscussBean;

public interface ProjDiscussDAO
{

	public List<ProjDiscussBean> getAll();

	public ProjDiscussBean findByPrimaryKey(int projDiscussId);

	public ProjDiscussBean insert(ProjDiscussBean bean);

	public ProjDiscussBean update(ProjDiscussBean bean);

	public boolean delete(int projDiscussId);

	public List<ProjDiscussBean> selectByFullProjId(int fullProjId);

}
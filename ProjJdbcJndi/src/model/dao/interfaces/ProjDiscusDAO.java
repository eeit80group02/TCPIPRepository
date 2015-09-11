package model.dao.interfaces;

import java.util.List;

import model.ProjDiscusBean;

public interface ProjDiscusDAO
{

	public List<ProjDiscusBean> getAll();

	public ProjDiscusBean findByPrimaryKey(int projDiscussId);

	public ProjDiscusBean insert(ProjDiscusBean bean);

	public ProjDiscusBean update(ProjDiscusBean bean);

	public boolean delete(int projDiscussId);

}
package model.dao.interfaces;

import java.util.List;

import model.FullProjBean;

public interface FullProjDAO
{

	public List<FullProjBean> getAll();

	public FullProjBean findByPrimaryKey(int fullProjId);

	public FullProjBean insert(FullProjBean bean);

	public FullProjBean update(FullProjBean bean);

	public boolean delete(int fullProjId);

}
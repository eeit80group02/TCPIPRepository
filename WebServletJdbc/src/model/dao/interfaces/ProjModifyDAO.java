package model.dao.interfaces;

import java.util.List;

import model.ProjModifyBean;

public interface ProjModifyDAO
{

	public List<ProjModifyBean> getAll();

	public ProjModifyBean findByPrimaryKey(int projModifyId);

	public ProjModifyBean insert(ProjModifyBean bean);

	public ProjModifyBean update(ProjModifyBean bean);

	public boolean delete(int projModifyId);

	public List<ProjModifyBean> selectByFullProjId(int fullProjId);

}
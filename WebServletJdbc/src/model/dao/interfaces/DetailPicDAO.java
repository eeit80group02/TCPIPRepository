package model.dao.interfaces;

import java.util.List;

import model.DetailPicBean;

public interface DetailPicDAO
{

	public DetailPicBean findByPrimaryKey(int fullProjId,String imageName);

	public List<DetailPicBean> getAll();

	public DetailPicBean insert(DetailPicBean bean);

	public DetailPicBean update(DetailPicBean bean);

	public boolean delete(int fullProjId,String imageName);

}
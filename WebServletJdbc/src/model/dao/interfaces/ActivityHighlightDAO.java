package model.dao.interfaces;

import java.util.List;

import model.ActivityHighlightBean;

public interface ActivityHighlightDAO
{

	public ActivityHighlightBean findByPrimaryKey(int fullProjId);

	public List<ActivityHighlightBean> getAll();

	public ActivityHighlightBean insert(ActivityHighlightBean bean);

	public ActivityHighlightBean update(ActivityHighlightBean bean);

	public boolean delete(int fullProjId);

}
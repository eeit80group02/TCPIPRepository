package model.dao.interfaces;

import java.util.List;

import model.TrainMapBean;

public interface TrainMapDAO
{

	public TrainMapBean findByPrimaryKey(String name);

	public List<TrainMapBean> getAll();

	public TrainMapBean insert(TrainMapBean bean);

	public TrainMapBean update(String newName,String name);

	public boolean delete(String name);

}
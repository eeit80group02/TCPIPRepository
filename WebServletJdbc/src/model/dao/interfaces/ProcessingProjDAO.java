package model.dao.interfaces;

import java.util.List;

import model.ProcessingProjBean;

public interface ProcessingProjDAO
{

	public ProcessingProjBean findByPrimaryKey(int processingProjId);

	public List<ProcessingProjBean> getAll();

	public ProcessingProjBean insert(ProcessingProjBean bean);

	public ProcessingProjBean update(ProcessingProjBean bean);

	public boolean delete(int processingProjId);

	public List<ProcessingProjBean> selectByPrimaryProjId(int primaryProjId);

}
package model.dao.interfaces;

import java.util.List;

import model.ProcessingMemberBean;

public interface ProcessingMemberDAO
{

	public ProcessingMemberBean findByPrimaryKey(int processingMemberId);

	public List<ProcessingMemberBean> getAll();

	public ProcessingMemberBean insert(ProcessingMemberBean bean);

	public ProcessingMemberBean update(ProcessingMemberBean bean);

	public boolean delete(int processingMemberId);

}
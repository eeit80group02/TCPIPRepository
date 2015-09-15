package model.service;

import java.util.List;

import model.PrimaryProjBean;
import model.ProcessingProjBean;
import model.dao.PrimaryProjDAOJdbc;
import model.dao.ProcessingProjDAOJdbc;
import model.dao.interfaces.PrimaryProjDAO;
import model.dao.interfaces.ProcessingProjDAO;

public class ProcessingProjService
{
	private ProcessingProjDAO processingProjDAO = null;
	private PrimaryProjDAO primaryProjDAO = null;
	
	public ProcessingProjService()
	{
		processingProjDAO = new ProcessingProjDAOJdbc();
		primaryProjDAO = new PrimaryProjDAOJdbc();
	}

	public boolean applyPrimaryProj(ProcessingProjBean bean)
	{
		// 檢查 
		if(bean != null)
		{
			int primaryProjId = bean.getPrimaryProjId();
			int schoolId = bean.getSchoolId();
			
			// 找出 編號 跟 學校 是否已申請過
			List<ProcessingProjBean> processingProjBeans = processingProjDAO.selectByPrimaryProjId(primaryProjId);
			for(ProcessingProjBean processingProjBean : processingProjBeans)
			{
				if(processingProjBean.getSchoolId() == schoolId && processingProjBean.getCheckStatus().equals("待審核"))
				{
					return false;
				}
			}
			
			bean.setCheckStatus("待審核");
			bean.setCheckTime(null);
			ProcessingProjBean result = processingProjDAO.insert(bean);
			if(result != null)
			{
				// 新增成功時，對該計畫狀態更改為洽談中
				PrimaryProjBean temp = primaryProjDAO.findByPrimaryKey(bean.getPrimaryProjId());
				temp.setProjStatus("洽談中");
				temp = primaryProjDAO.update(temp);
				if(temp != null)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean agreeProcessingProj(ProcessingProjBean bean)
	{
		return false;
	}
	
	public static void main(String[] args)
	{

	}

}

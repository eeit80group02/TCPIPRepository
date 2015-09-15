package model.service;

import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

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
		if(bean != null)
		{
			int processingProjId = bean.getProcessingProjId();
			// 先對該 處理計畫 select
			ProcessingProjBean processingProjBean = processingProjDAO.findByPrimaryKey(processingProjId);
			processingProjBean.setCheckTime(new java.util.Date(System.currentTimeMillis()));
			processingProjBean.setCheckStatus("同意");
			processingProjBean = processingProjDAO.update(processingProjBean);
			
			if(processingProjBean != null)
			{
				// 修改完成 同時對這些計畫其餘改為 不同意 & 該計畫改成洽談完成
				int primaryProjId = processingProjBean.getPrimaryProjId();
				int schoolId = processingProjBean.getSchoolId();
				
				// 找出同計劃其他有申請的學校 一併回應取消
				List<ProcessingProjBean> temps = processingProjDAO.selectByPrimaryProjId(primaryProjId);
				for(ProcessingProjBean temp : temps)
				{
					// 找出 其他學校待審核 對她做取消
					if(temp.getCheckStatus().equals("待審核") && temp.getSchoolId() != schoolId)
					{
						temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
						temp.setCheckStatus("不同意");
						processingProjDAO.update(temp);
						
						// 對該計畫改成 洽談完成
						PrimaryProjBean primaryProjBean = primaryProjDAO.findByPrimaryKey(primaryProjId);
						primaryProjBean.setProjStatus("洽談完成");
						primaryProjDAO.update(primaryProjBean);
						
						// 建立完整計畫囉...
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{

	}

}

package model.service;

import java.util.ArrayList;
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
	
	public List<ProcessingProjBean> displayProcessingProjByStatusPending(int memberId)
	{
		List<ProcessingProjBean> result = new ArrayList<ProcessingProjBean>();
		
		// 先找出 mid 發布過的計畫 的 初步計畫
		List<PrimaryProjBean> beans = primaryProjDAO.selectByMemberId(memberId);
		if(beans != null)
		{
			for(PrimaryProjBean bean : beans)
			{
				// 用找出他發過的計畫 用該計畫去找是否有待審核的
				int primaryProjId = bean.getPrimaryProjId();
				String status = "待審核";
				List<ProcessingProjBean> temps = processingProjDAO.selectByPrimaryProjIdAndStatus(primaryProjId,status);
				for(ProcessingProjBean temp:temps)
				{
					result.add(temp);
				}
			}
		}
		
		return result;
	}
	public boolean applyPrimaryProj(int primaryProjId,int schoolId)
	{
		if(primaryProjId > 0 && schoolId > 0)
		{
			ProcessingProjBean bean = new ProcessingProjBean();
			bean.setPrimaryProjId(primaryProjId);
			bean.setSchoolId(schoolId);
			bean.setCheckStatus("待審核");
			bean.setCheckTime(null);
			processingProjDAO.insert(bean);
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		ProcessingProjService service = new ProcessingProjService();
		
		for(ProcessingProjBean bean :service.displayProcessingProjByStatusPending(4))
			System.out.println(bean);
	}
}

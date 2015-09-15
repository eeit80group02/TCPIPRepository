package model.service;

import global.GlobalService;

import java.util.ArrayList;
import java.util.List;

import model.PrimaryProjBean;
import model.ProcessingProjBean;
import model.dao.PrimaryProjDAOJdbc;
import model.dao.ProcessingProjDAOJdbc;
import model.dao.interfaces.PrimaryProjDAO;
import model.dao.interfaces.ProcessingProjDAO;

public class PrimaryProjService
{
	private PrimaryProjDAO primaryProjDAO;
	private ProcessingProjDAO processingProjDAO;
	
	public PrimaryProjService()
	{
		this.primaryProjDAO = new PrimaryProjDAOJdbc();
		this.processingProjDAO = new ProcessingProjDAOJdbc();
	}
	
	public PrimaryProjBean createPrimaryProj(PrimaryProjBean bean)
	{
		PrimaryProjBean result = null;
		
		if(bean != null)
		{
			// business logic 預設 待洽談 & 建立時間
			bean.setProjStatus("待洽談");
			bean.setCreateDate(new java.util.Date(System.currentTimeMillis()));
			result = primaryProjDAO.insert(bean);
			if(result != null)
			{
				result.setBsae64String(GlobalService.convertByteArrayToBase64String(result.getFrontCoverName(),result.getFrontCover()));
			}
		}
		return result ;
	}
	
	public PrimaryProjBean updatePromaryProj(PrimaryProjBean bean)
	{
		PrimaryProjBean result = null;
		
		if (bean != null) 
		{
			// 先selete 抓齊所有資料 在對使用者的資料做修改
			PrimaryProjBean temp = primaryProjDAO.findByPrimaryKey(bean.getPrimaryProjId());
			if(temp != null)
			{
				temp.setMemberId(bean.getMemberId());
				temp.setTitle(bean.getTitle());
				temp.setProjAbstract(bean.getProjAbstract());
				temp.setContent(bean.getContent());
				temp.setIdealPlace(bean.getIdealPlace());
				temp.setActivityStartTime(bean.getActivityStartTime());
				temp.setActivityEndTime(bean.getActivityEndTime());
				temp.setDemandNum(bean.getDemandNum());
				temp.setBudget(bean.getBudget());
				
				// 前端使用者有做更圖，才修改，否則沿用舊的
				if(bean.getFrontCover() != null)
				{
					temp.setFrontCoverName(bean.getFrontCoverName());
					temp.setFrontCover(bean.getFrontCover());
					temp.setFrontCoverLength(bean.getFrontCoverLength());
				}
				
				result = primaryProjDAO.update(temp);
				if(result != null)
				{
					result.setBsae64String(GlobalService.convertByteArrayToBase64String(result.getFrontCoverName(),result.getFrontCover()));
				}
			}
		}
		return result;
	}
	
	public List<PrimaryProjBean> displayPromaryProjAll()
	{
		List<PrimaryProjBean> result = new ArrayList<PrimaryProjBean>();
		result = primaryProjDAO.getAll();
		
		List<PrimaryProjBean> temp = new ArrayList<PrimaryProjBean>();
		for(PrimaryProjBean bean : result)
		{
			if(bean.getProjStatus().equals("洽談完成"))
			{
				temp.add(bean);
			}
			else
			{
				bean.setBsae64String(GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(),bean.getFrontCover()));
			}
		}
		
		for(PrimaryProjBean bean : temp)
		{
			result.remove(bean);
		}
		
		return result;
	}
	
	public PrimaryProjBean displayPromaryProj(PrimaryProjBean bean)
	{
		PrimaryProjBean result = null;
		
		if(bean != null)
		{
			result = primaryProjDAO.findByPrimaryKey(bean.getPrimaryProjId());
			if(result != null)
			{
				result.setBsae64String(GlobalService.convertByteArrayToBase64String(result.getFrontCoverName(),result.getFrontCover()));
			}
		}
		return result;
	}
	
	public List<PrimaryProjBean> displayPersonalPromaryProj(PrimaryProjBean bean)
	{
		List<PrimaryProjBean> result = null;
		
		if(bean != null)
		{
			result = primaryProjDAO.selectByMemberId(bean.getMemberId());
		}
		return result;
	}
	
	// 查詢 個人頁面 有學校申請的 計畫
	public List<PrimaryProjBean> displayPersonalPromaryProjByPending(PrimaryProjBean bean)
	{
		List<PrimaryProjBean> result = new ArrayList<PrimaryProjBean>();
		
		if(bean != null)
		{
			// 先查詢 該會員的所有初步計畫
			List<PrimaryProjBean> temps = primaryProjDAO.selectByMemberId(bean.getMemberId());
			for(PrimaryProjBean temp : temps)
			{
				if(temp.getProjStatus().equals("洽談中"))
				{
					// 有在洽談中的初步計畫編號
					int primaryProjId = temp.getPrimaryProjId();
					// 對該計畫去查學所有有申請
					List<ProcessingProjBean> processing = processingProjDAO.selectByPrimaryProjId(primaryProjId);
					// 找出該計畫需要待審核的集合
					List<ProcessingProjBean> pending = new ArrayList<ProcessingProjBean>();
					for(ProcessingProjBean process:processing)
					{
						if(process.getCheckStatus().equals("待審核"))
						{
							pending.add(process);
						}
					}
					temp.setProcessingProjBean(pending);
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		PrimaryProjService service = new PrimaryProjService();
//		PrimaryProjBean bean1 = new PrimaryProjBean();
//		bean1.setMemberId(6);
//		bean1.setTitle("餐餐都有麥當當");
//		File file = new File("image/primaryProj/primaryProj01.jpg");
//		try(FileInputStream fis = new FileInputStream(file);)
//		{
//			bean1.setFrontCoverName(file.getName());
//			bean1.setFrontCover(GlobalService.convertInputStreamToByteArray(fis));
//			bean1.setFrontCoverLength(file.length());
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		bean1.setProjAbstract("摘要（Abstract）又稱文摘或提要。它是以簡明扼要的文句，將某種文獻的主要內容，正確無誤地摘錄出來，使讀者於最短的時間內，得知原著的大意。");
//		bean1.setContent("初步計畫的內文檔案內容會比摘要多很多.......");
//		bean1.setIdealPlace("新竹尖石鄉");
//		try
//		{
//			bean1.setActivityStartTime(GlobalService.convertStringToDate("2015-10-10"));
//			bean1.setActivityEndTime(GlobalService.convertStringToDate("2015-10-17"));
//		}
//		catch(ParseException e)
//		{
//			e.printStackTrace();
//		}
//		bean1.setDemandNum(30);
//		bean1.setBudget(20000);
//		
//		System.out.println(service.createPrimaryProj(bean1));
		
//		PrimaryProjBean bean2 = dao.findByPrimaryKey(8);
//		bean2.setMemberId(2);
//		bean2.setTitle("做了修改");
//		bean2.setProjAbstract("");
//		bean2.setContent("");
//		bean2.setIdealPlace("");
//		try
//		{
//			bean2.setActivityStartTime(GlobalService.convertStringToDate("2011-11-11"));
//			bean2.setActivityEndTime(GlobalService.convertStringToDate("2011-11-13"));
//		}
//		catch(ParseException e)
//		{
//			e.printStackTrace();
//		}
//		bean2.setDemandNum(4);
//		bean2.setBudget(5);
//		bean2.setFrontCoverName("");
//		bean2.setFrontCover(new byte[]{1,2,3,4,5});
//		bean2.setFrontCoverLength(12345L);
//		
//		System.out.println(service.updatePromaryProj(bean2));
		
		List<PrimaryProjBean> result = service.displayPromaryProjAll();
		System.out.println(result.get(1).getBsae64String());
		
	}

}

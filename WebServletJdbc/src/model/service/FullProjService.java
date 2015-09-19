package model.service;

import global.GlobalService;

import java.util.ArrayList;
import java.util.List;

import model.FullProjBean;
import model.dao.FullProjDAOJdbc;
import model.dao.interfaces.FullProjDAO;

public class FullProjService
{
	private FullProjDAO fullProjDAO = null;
	public FullProjService()
	{
		fullProjDAO = new FullProjDAOJdbc();
	}

	public List<FullProjBean> displayFullProjAll()
	{
		List<FullProjBean> result = new ArrayList<FullProjBean>();
		result = fullProjDAO.getAll();
		
		List<FullProjBean> temp = new ArrayList<FullProjBean>();
		for(FullProjBean bean : result)
		{
			if(bean.getProjStatus().equals("招募中"))
			{
				bean.setBase64String(GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(),bean.getFrontCover()));
				temp.add(bean);
			}
		}
		
		return temp;
	}
	
	public List<FullProjBean> displayPersonalFullProj(FullProjBean bean)
	{
		List<FullProjBean> result = null;
		
		if(bean != null)
		{
			result = fullProjDAO.selectByMemberId(bean.getMemberId());
		}
		return result;
	}

	public List<FullProjBean> displayPersonalFullProjProjByChat(FullProjBean bean)
	{
		List<FullProjBean> result = new ArrayList<FullProjBean>();
		
		if(bean != null)
		{
			// 先查詢 該會員的所有完整計畫
			List<FullProjBean> temps = fullProjDAO.selectByMemberId(bean.getMemberId());
			for(FullProjBean temp : temps)
			{
				if(temp.getProjStatus().equals("洽談中"))
				{
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	// 顯示單一完整計畫 
	public FullProjBean displayFullProj(FullProjBean bean)
	{
		FullProjBean result = null;
		if(bean != null)
		{
			int fullProjId = bean.getFullProjId();
			result = fullProjDAO.findByPrimaryKey(fullProjId);
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		FullProjService service = new FullProjService();
		System.out.println(service.displayFullProjAll());
	}

}

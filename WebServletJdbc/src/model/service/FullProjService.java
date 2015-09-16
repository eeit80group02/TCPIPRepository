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
			if(bean.getProjStatus().equals("洽談完成"))
			{
				temp.add(bean);
			}
			else
			{
				bean.setBase64String(GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(),bean.getFrontCover()));
			}
		}
		
		for(FullProjBean bean : temp)
		{
			result.remove(bean);
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		FullProjService service = new FullProjService();
		System.out.println(service.displayFullProjAll());
	}

}

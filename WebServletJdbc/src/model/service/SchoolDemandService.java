package model.service;

import global.GlobalService;

import java.util.ArrayList;
import java.util.List;

import model.PrimaryProjBean;
import model.SchoolDemandBean;
import model.dao.SchoolDemandDAOJdbc;
import model.dao.interfaces.SchoolDemandDAO;

public class SchoolDemandService {
	
	private SchoolDemandDAO dao;
	public SchoolDemandService(){
		this.dao = new SchoolDemandDAOJdbc();
	}
	
	public SchoolDemandBean creatSchoolDemand(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		if(bean!=null){
			bean.setDemandStatus("待洽談");
			bean.setCreateDate(new java.util.Date(System.currentTimeMillis()));
			result = dao.insert(bean);
		}
		return result;
	}
	public SchoolDemandBean updateSchoolDemand(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		if(bean!=null){
			result = dao.update(bean);
		}
		return result;
	}
	public SchoolDemandBean displaySchoolDemand(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		if(bean!=null){
			result = dao.findByPrimaryKey(bean.getSchoolDemandId());
		}
		return result;
	}
	public List<SchoolDemandBean> displayAllNoChat(){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = new ArrayList<SchoolDemandBean>();
		
		list = dao.getAll();

		for(SchoolDemandBean bean : list)
		{
			if(bean.getDemandStatus().equals("待洽談"))
			{
				result.add(bean);
			}
		}
		
		for(SchoolDemandBean bean : result)
		{
			list.remove(bean);
		}
		
		return result;
	}
	public List<SchoolDemandBean> displayAllPersonal(SchoolDemandBean bean){
		List<SchoolDemandBean> result = null;
		return result;
	}

}

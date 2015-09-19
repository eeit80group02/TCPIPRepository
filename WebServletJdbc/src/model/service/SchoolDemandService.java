package model.service;

import global.GlobalService;

import java.util.ArrayList;
import java.util.List;

import model.OffersBean;
import model.PrimaryProjBean;
import model.ProcessingMemberBean;
import model.SchoolDemandBean;
import model.dao.OffersDAOJdbc;
import model.dao.ProcessingMemberDAOJdbc;
import model.dao.SchoolDemandDAOJdbc;
import model.dao.interfaces.OffersDAO;
import model.dao.interfaces.ProcessingMemberDAO;
import model.dao.interfaces.SchoolDemandDAO;

public class SchoolDemandService {
	
	private SchoolDemandDAO schoolDemandDao;
	private OffersDAO offersDao;
	private ProcessingMemberDAO processingMember ;
	
	public SchoolDemandService(){
		this.schoolDemandDao = new SchoolDemandDAOJdbc();
		this.offersDao = new OffersDAOJdbc();
		this.processingMember = new ProcessingMemberDAOJdbc();
	}
	
	public SchoolDemandBean creatSchoolDemand(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean oBean = bean.getOfferBean();
		System.out.println(bean);
		if(bean!=null){
			bean.setDemandStatus("待洽談");
			bean.setCreateDate(new java.util.Date(System.currentTimeMillis()));
			result = schoolDemandDao.insert(bean);
			oBean.setSchoolDemandId(result.getSchoolDemandId());
			oBean = offersDao.insert(oBean);
			result.setOfferBean(oBean);
		}
		return result;
	}
	public SchoolDemandBean updateSchoolDemand(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean temp = null;
		if(bean!=null){
			result = schoolDemandDao.update(bean);
			temp = offersDao.update(bean.getOfferBean());
			result.setOfferBean(temp);
		}
		return result;
	}	
	public List<SchoolDemandBean> displayAll(){
		
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();

		for(SchoolDemandBean bean : list){
			for(OffersBean obean:olist){
				if(bean.getDemandStatus().equals("待洽談") && bean.getSchoolDemandId().equals(obean.getSchoolDemandId()))
				{
					bean.setOfferBean(obean);
					result.add(bean);
				}
			}
		}
		list.clear();
		olist.clear();
		return result;
	}
	public SchoolDemandBean display(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean temp = null;
		if(bean!=null){
			result = schoolDemandDao.findByPrimaryKey(bean.getSchoolDemandId());
			temp = offersDao.findByPrimaryKey(bean.getSchoolDemandId());
			result.setOfferBean(temp);
		}
		return result;
	}
	public List<SchoolDemandBean> displayPersonalAll(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp :list){
			for(OffersBean obean : olist){
				if(bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){
					temp.setOfferBean(obean);
					result.add(temp);
				}
			}
		}
		list.clear();
		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalRender(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp : list){
			for(OffersBean obean : olist){
				if(temp.getDemandStatus().equals("待洽談") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
					temp.setOfferBean(obean);
					result.add(temp);
				}
			}
		}for(SchoolDemandBean temp : result){
			list.remove(temp);
		}
		list.clear();
		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalUnrender(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<ProcessingMemberBean> pMlist = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		pMlist = processingMember.getAll();
		for(SchoolDemandBean temp : list){
			for(OffersBean obean : olist){
				if(temp.getDemandStatus().equals("洽談中") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
					temp.setOfferBean(obean);
				}
			}
			for(ProcessingMemberBean pMbean:pMlist){
				if(temp.getSchoolDemandId() == pMbean.getSchoolDemandId() && pMbean.getCheckStatus().equals("待審核")){
					temp.setProcessingMemberBean(pMbean);
					result.add(temp);
				}
			}
			
		}
		list.clear();
		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalEnd(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp : list){
			for(OffersBean obean : olist){
				if(temp.getDemandStatus().equals("洽談完成") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
					temp.setOfferBean(obean);
					result.add(temp);
				}
			}
		}for(SchoolDemandBean temp : result){
			list.remove(temp);
		}
		list.clear();
		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalFail(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp : list){
			for(OffersBean obean : olist){
				if(temp.getDemandStatus().equals("洽談失敗") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
					temp.setOfferBean(obean);
					result.add(temp);
				}
			}
		}for(SchoolDemandBean temp : result){
			list.remove(temp);
		}
		list.clear();
		olist.clear();
		return result;
	}
}

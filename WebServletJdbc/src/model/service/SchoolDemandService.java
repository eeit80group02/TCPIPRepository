package model.service;

import java.util.ArrayList;
import java.util.List;

import model.MemberBean;
import model.OffersBean;

import model.ProcessingMemberBean;
import model.SchoolBean;
import model.SchoolDemandBean;
import model.dao.MemberDAOJdbc;
import model.dao.OffersDAOJdbc;
import model.dao.ProcessingMemberDAOJdbc;
import model.dao.SchoolDAOJdbc;
import model.dao.SchoolDemandDAOJdbc;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.OffersDAO;
import model.dao.interfaces.ProcessingMemberDAO;
import model.dao.interfaces.SchoolDAO;
import model.dao.interfaces.SchoolDemandDAO;

public class SchoolDemandService {
	
	private SchoolDemandDAO schoolDemandDao;
	private OffersDAO offersDao;
	private ProcessingMemberDAO processingMemberDao ;
	private MemberDAO memberDao;
	private SchoolDAO schoolDao;
	
	public SchoolDemandService(){
		this.schoolDemandDao = new SchoolDemandDAOJdbc();
		this.offersDao = new OffersDAOJdbc();
		this.processingMemberDao = new ProcessingMemberDAOJdbc();
		this.memberDao = new MemberDAOJdbc();
		this.schoolDao = new SchoolDAOJdbc();
		}
	
	
	public SchoolDemandBean creat(SchoolDemandBean bean){
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
	public SchoolDemandBean update(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean temp = null;
		if(bean!=null){
			result = schoolDemandDao.update(bean);
			temp = offersDao.update(bean.getOfferBean());
			result.setOfferBean(temp);
		}
		return result;
	}
	public SchoolDemandBean updateDisplay(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean temp = null;
		if(bean!=null){
			temp = offersDao.findByPrimaryKey(bean.getSchoolDemandId());
			result = schoolDemandDao.findByPrimaryKey(bean.getSchoolDemandId());
			result.setOfferBean(temp);
		}
		return result;
	}
	public SchoolDemandBean display(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean temp = null;
		SchoolBean sBean = null;
		if(bean!=null){
			result = schoolDemandDao.findByPrimaryKey(bean.getSchoolDemandId());
			temp = offersDao.findByPrimaryKey(bean.getSchoolDemandId());
			sBean = schoolDao.findByPrimaryKey(bean.getSchoolId());
			result.setOfferBean(temp);
			result.setSchoolBean(sBean);
		}
		return result;
	}
	public List<SchoolDemandBean> displays(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp :list){
			for(OffersBean oBean : olist){
				if(bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId() == oBean.getSchoolDemandId()){
					temp.setOfferBean(oBean);
					result.add(temp);
				}
			}
		}
		list.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalRender(SchoolBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<OffersBean> olist = null;
		list = schoolDemandDao.getAll();
		olist = offersDao.getAll();
		for(SchoolDemandBean temp : list){
			for(OffersBean obean : olist){
				if(bean.getSchoolId().equals(temp.getSchoolId()) && temp.getDemandStatus().equals("待洽談") && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
					temp.setOfferBean(obean);
					result.add(temp);
				}
			}
		}
		list.clear();
		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalUnrender(SchoolDemandBean bean){
		List<SchoolDemandBean> result = null;
		List<SchoolDemandBean> slist = null;
		List<ProcessingMemberBean> plist = null;
		List<MemberBean> mlist = null;
		List<MemberBean> temp = null;
		result = schoolDemandDao.findByPrimarySchoolId(bean.getSchoolId());
		mlist = memberDao.select();
		for(SchoolDemandBean sDBean : result){
			plist = processingMemberDao.finBySchoolDemandId(sDBean.getSchoolDemandId());
			for(ProcessingMemberBean pMBean : plist){
				for(MemberBean mBean : mlist){
					if(pMBean.getMemberId() == mBean.getMemberId()){
						pMBean.setMemberBean(mBean);
					}
				}	
			}
			sDBean.setProcessingMemberList(plist);
		}
		for(SchoolDemandBean v:result){
			System.out.println(v);
		}
		return result;
	}
	public SchoolDemandBean mdisplay(SchoolDemandBean bean){
		SchoolDemandBean result = null;
		OffersBean oBean = null;
		SchoolBean sBean = null;
		if(bean!=null){
			result = schoolDemandDao.findByPrimaryKey(bean.getSchoolDemandId());
			sBean = schoolDao.findByPrimaryKey(bean.getSchoolId());
			oBean = offersDao.findByPrimaryKey(bean.getSchoolDemandId());
			result.setSchoolBean(sBean);
			result.setOfferBean(oBean);
		}
		return result;
	}
	public List<SchoolDemandBean> mdisplays(MemberBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> temp = new ArrayList<SchoolDemandBean>();
		List<SchoolDemandBean> list = null;
		List<ProcessingMemberBean> pMlist = null;
		list = schoolDemandDao.getAll();
		pMlist = processingMemberDao.finByMemerId(bean.getMemberId());
		for(SchoolDemandBean sDBean : list){
			if(sDBean.getDemandStatus().equals("待洽談") || sDBean.getDemandStatus().equals("洽談中")){
				sDBean.setOfferBean(offersDao.findByPrimaryKey(sDBean.getSchoolDemandId()));
				sDBean.setSchoolBean(schoolDao.findByPrimaryKey(sDBean.getSchoolId()));
				result.add(sDBean);
			}
		}
		for(ProcessingMemberBean pMBean: pMlist){
			System.out.println(pMBean);
			for(SchoolDemandBean sDBean : list){
				if(pMBean.getSchoolDemandId() == sDBean.getSchoolDemandId()){
					temp.add(sDBean);
				}
			}
		}
		pMlist.clear();
		result.removeAll(temp);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<SchoolDemandBean> displayPersonalEnd(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
//		List<SchoolDemandBean> list = null;
//		List<ProcessingMemberBean> pMlist = null;
//		List<OffersBean> olist = null;
//		List<MemberBean> mlist = null;
//		list = schoolDemandDao.getAll();
//		olist = offersDao.getAll();
//		pMlist = processingMemberDao.getAll();
//		mlist = memberDao.select();
//		for(SchoolDemandBean temp : list){
//			for(OffersBean obean : olist){
//				if(temp.getDemandStatus().equals("洽談完成") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
//					temp.setOfferBean(obean);
//				}
//			}
//			for(ProcessingMemberBean pMbean : pMlist){
//				for(MemberBean mbean : mlist){
//					if(pMbean.getMemberId() == mbean.getMemberId()){
//						pMbean.setMemberBean(mbean);
//					}
//				}
//				if(temp.getSchoolDemandId() == pMbean.getSchoolDemandId() && pMbean.getCheckStatus().equals("已通過")){
//					temp.setProcessingMemberBean(pMbean);
//					result.add(temp);
//				}
//			}
//			
//		}
//		pMlist.clear();
//		list.clear();
//		olist.clear();
		return result;
	}
	public List<SchoolDemandBean> displayPersonalFail(SchoolDemandBean bean){
		List<SchoolDemandBean> result = new ArrayList<SchoolDemandBean>();
//		List<SchoolDemandBean> list = null;
//		List<ProcessingMemberBean> pMlist = null;
//		List<OffersBean> olist = null;
//		List<MemberBean> mlist = null;
//		list = schoolDemandDao.getAll();
//		olist = offersDao.getAll();
//		pMlist = processingMemberDao.getAll();
//		mlist = memberDao.select();
//		for(SchoolDemandBean temp : list){
//			for(OffersBean obean : olist){
//				if(temp.getDemandStatus().equals("洽談失敗") && bean.getSchoolId().equals(temp.getSchoolId()) && temp.getSchoolDemandId().equals(obean.getSchoolDemandId())){		
//					temp.setOfferBean(obean);
//				}
//			}
//			for(ProcessingMemberBean pMbean : pMlist){
//				for(MemberBean mbean : mlist){
//					if(pMbean.getMemberId() == mbean.getMemberId()){
//						pMbean.setMemberBean(mbean);
//					}
//				}
//				if(temp.getSchoolDemandId() == pMbean.getSchoolDemandId() && pMbean.getCheckStatus().equals("未通過")){
//					temp.setProcessingMemberBean(pMbean);
//					result.add(temp);
//				}
//			}
//			
//		}
//		pMlist.clear();
//		list.clear();
//		olist.clear();
		return result;
	}
}

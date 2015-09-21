package model.service;

import model.ProcessingMemberBean;
import model.SchoolDemandBean;
import model.dao.ProcessingMemberDAOJdbc;
import model.dao.SchoolDemandDAOJdbc;
import model.dao.interfaces.ProcessingMemberDAO;
import model.dao.interfaces.SchoolDemandDAO;

public class ProcessingMemberService {
	private ProcessingMemberDAO processingMemberDAO;
	private SchoolDemandDAO schoolDemandDAO;
	
	public ProcessingMemberService(){
		processingMemberDAO = new ProcessingMemberDAOJdbc();
		schoolDemandDAO = new SchoolDemandDAOJdbc();
	}
	
	public ProcessingMemberBean application(ProcessingMemberBean bean){
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;
		if(bean!=null){
			sBean = schoolDemandDAO.findByPrimaryKey(bean.getSchoolDemandId());
			if(sBean!=null && sBean.getDemandStatus().equals("待洽談")){
				bean.setCheckStatus("待審核");
				result = processingMemberDAO.insert(bean);
				if(result != null){
					sBean.setDemandStatus("洽談中");
					schoolDemandDAO.update(sBean);
				}
			}
		}
		return result;
	}
	public ProcessingMemberBean agree(ProcessingMemberBean bean){
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;
		if(bean!=null){
			
			sBean = schoolDemandDAO.findByPrimaryKey(bean.getSchoolDemandId());
			if(sBean!=null && sBean.getDemandStatus().equals("洽談中") ){
				bean.setCheckTime(new java.util.Date(System.currentTimeMillis()));
				bean.setCheckStatus("已通過");
				result = processingMemberDAO.update(bean);
				if(result != null){
					sBean.setDemandStatus("洽談完成");
					schoolDemandDAO.update(sBean);
				}
			}
		}
		return result;
	}
	public ProcessingMemberBean disagree(ProcessingMemberBean bean){
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;
		if(bean!=null){
			sBean = schoolDemandDAO.findByPrimaryKey(bean.getSchoolDemandId());
			if(sBean!=null && sBean.getDemandStatus().equals("洽談中")){
				bean.setCheckStatus("未通過");
				result = processingMemberDAO.update(bean);
				if(result != null){
					sBean.setDemandStatus("洽談失敗");
					schoolDemandDAO.update(sBean);
				}
			}
		}
		return result;
	}
	public ProcessingMemberBean cancel (ProcessingMemberBean bean){
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;
		if(bean!=null){
			sBean = schoolDemandDAO.findByPrimaryKey(bean.getSchoolDemandId());
			if(sBean!=null && sBean.getSchoolDemandId().equals(bean.getSchoolDemandId())){
				bean.setCheckStatus("未通過");
				result = processingMemberDAO.update(bean);
				if(result != null){
					sBean.setDemandStatus("下架");
					schoolDemandDAO.update(sBean);
				}
			}
		}
		return result;
	}
	
}

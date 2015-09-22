package model.service;

import java.util.List;

import model.FullProjBean;
import model.ProcessingMemberBean;
import model.SchoolDemandBean;
import model.dao.FullProjDAOJdbc;
import model.dao.ProcessingMemberDAOJdbc;
import model.dao.SchoolDemandDAOJdbc;
import model.dao.interfaces.FullProjDAO;
import model.dao.interfaces.ProcessingMemberDAO;
import model.dao.interfaces.SchoolDemandDAO;

public class ProcessingMemberService {
	private ProcessingMemberDAO processingMemberDAO;
	private SchoolDemandDAO schoolDemandDAO;
	private FullProjDAO fullProjDAO;

	public ProcessingMemberService() {
		processingMemberDAO = new ProcessingMemberDAOJdbc();
		schoolDemandDAO = new SchoolDemandDAOJdbc();
		fullProjDAO = new FullProjDAOJdbc();
	}

	public ProcessingMemberBean application(ProcessingMemberBean bean) {
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;
		if (bean != null) {
			sBean = schoolDemandDAO.findByPrimaryKey(bean.getSchoolDemandId());
			if (sBean != null && sBean.getDemandStatus().equals("待洽談")) {
				bean.setCheckStatus("待審核");
				result = processingMemberDAO.insert(bean);
				if (result != null) {
					sBean.setDemandStatus("洽談中");
					schoolDemandDAO.update(sBean);
				}
			}
		}
		return result;
	}

	public ProcessingMemberBean agree(ProcessingMemberBean bean) {
		List<ProcessingMemberBean> list = null;
		ProcessingMemberBean result = new ProcessingMemberBean();
		SchoolDemandBean sDBean = new SchoolDemandBean();
		FullProjBean fBean = new FullProjBean();
		if (bean != null) {
			list = processingMemberDAO.getAll();
			for (ProcessingMemberBean temp : list) {
				if (bean.getSchoolDemandId() == temp.getSchoolDemandId()) {
					result.setProcessingMemberId(temp.getProcessingMemberId());
					result.setCheckStatus("未通過");
					processingMemberDAO.update(result);
				}
			}
			result.setProcessingMemberId(bean.getProcessingMemberId());
			result.setCheckTime(new java.util.Date(System.currentTimeMillis()));
			result.setCheckStatus("已通過");
			result = processingMemberDAO.update(result);
			if (result != null) {
				sDBean.setSchoolDemandId(bean.getSchoolDemandId());
				sDBean.setDemandStatus("洽談完成");
				sDBean = schoolDemandDAO.update(sDBean);
				if (sDBean != null) {
					fBean.setSchoolId(sDBean.getSchoolId());
					fBean.setMemberId(bean.getMemberId());
					fBean.setSchoolDemandId(sDBean.getSchoolDemandId());
					fBean.setTitle(sDBean.getActivityTopic());
					fBean.setFrontCoverName(frontCoverName);
					fBean.setFrontCover(frontCover);
					fBean.setFrontCoverLength(frontCoverLength);
					fBean.setProjAbstract(projAbstract);
					fBean.setContent(content);
					fBean.setLocation(sDBean.getActivityLocation());
					fBean.setActivityStartTime(activityStartTime);
					fBean.setActivityEndTime(activityEndTime);
					fBean.setEstMember(estMember);
					fBean.setBudget(budget);
					fBean.setCreateDate(result.getCheckTime());
					fBean.setProjStatus("洽談中");
					fullProjDAO.insert(fBean); 
				}
			}
		}
		return result;
	}

	public ProcessingMemberBean disagree(ProcessingMemberBean bean) {
		List<ProcessingMemberBean> list = null;
		ProcessingMemberBean result = null;
		if (bean != null) {
			bean.setProcessingMemberId(bean.getProcessingMemberId());
			bean.setCheckStatus("未通過");
			result = processingMemberDAO.update(bean);
		}
		return result;
	}

	public ProcessingMemberBean cancel(ProcessingMemberBean bean) {
		ProcessingMemberBean result = null;
		SchoolDemandBean sBean = null;

		bean.setProcessingMemberId(bean.getProcessingMemberId());
		bean.setCheckStatus("未通過");
		result = processingMemberDAO.update(bean);
		if (result != null) {
			sBean.setDemandStatus("下架");
			schoolDemandDAO.update(sBean);

		}
		return result;
	}

}

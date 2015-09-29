package model.service;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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
			if (sBean != null && !sBean.getDemandStatus().equals("洽談完成")
					&& !sBean.getDemandStatus().equals("洽談失敗")) {
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
		File image = new File("C:/Users/Student/git/TCPIPRepository/WebServletJdbc/image/fullProj/default.jpg");
		FileInputStream is = null;
		List<ProcessingMemberBean> list = null;
		ProcessingMemberBean result = null;
		SchoolDemandBean sDBean = new SchoolDemandBean();
		FullProjBean fBean = new FullProjBean();
		try {
			is = new FileInputStream(image);
			if (bean != null) {
				result = new ProcessingMemberBean();
				list = processingMemberDAO.getAll();
				for (ProcessingMemberBean temp : list) {
					if (bean.getSchoolDemandId() == temp.getSchoolDemandId()) {
						result.setMemberId(temp.getMemberId());
						result.setProcessingMemberId(temp.getProcessingMemberId());
						result.setCheckStatus("未通過");
						result.setSchoolDemandId(bean.getSchoolDemandId());
						processingMemberDAO.update(result);
					}
				}
				result.setMemberId(bean.getMemberId());
				result.setSchoolDemandId(bean.getSchoolDemandId());
				result.setProcessingMemberId(bean.getProcessingMemberId());
				result.setCheckTime(new java.util.Date(System.currentTimeMillis()));
				result.setCheckStatus("已通過");
				result = processingMemberDAO.update(result);
				if (result != null) {
					sDBean = schoolDemandDAO.findByPrimaryKey(bean
							.getSchoolDemandId());
					sDBean.setDemandStatus("洽談完成");
					sDBean = schoolDemandDAO.update(sDBean);
					if (sDBean != null) {
						fBean.setSchoolId(sDBean.getSchoolId());
						fBean.setMemberId(bean.getMemberId());
						fBean.setSchoolDemandId(sDBean.getSchoolDemandId());
						fBean.setTitle(sDBean.getActivityTopic());
						fBean.setFrontCoverName("default.jpg");
						fBean.setFrontCover(GlobalService.convertInputStreamToByteArray(is));
						fBean.setFrontCoverLength(image.length());
						fBean.setProjAbstract("完整計畫");
						fBean.setContent(sDBean.getContent());
						fBean.setLocation(sDBean.getActivityLocation());
						fBean.setActivityStartTime(new java.util.Date(System
								.currentTimeMillis()));
						fBean.setActivityEndTime(new java.util.Date(System
								.currentTimeMillis()));
						fBean.setEstMember(0);
						fBean.setBudget(0);
						fBean.setCreateDate(result.getCheckTime());
						fBean.setProjStatus("洽談中");
						fullProjDAO.insert(fBean);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("圖片有問題");
		}
		return result;
	}

	public ProcessingMemberBean disagree(ProcessingMemberBean bean) {
		List<ProcessingMemberBean> list = null;
		List<ProcessingMemberBean> temp = null;

		ProcessingMemberBean result = null;
		if (bean != null) {
			bean.setProcessingMemberId(bean.getProcessingMemberId());
			bean.setCheckStatus("未通過");
			result = processingMemberDAO.update(bean);
			if(result != null){
				
			}
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

package model.service;

import global.GlobalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FullProjBean;
import model.MemberBean;
import model.MissionBoardBean;
import model.ParticipatorBean;
import model.dao.FullProjDAOJdbc;
import model.dao.MemberDAOJdbc;
import model.dao.MissionBoardDAOJdbc;
import model.dao.ParticipatorDAOJdbc;
import model.dao.SchoolDAOJdbc;
import model.dao.interfaces.FullProjDAO;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.MissionBoardDAO;
import model.dao.interfaces.ParticipatorDAO;
import model.dao.interfaces.SchoolDAO;

public class FullProjService
{
	private FullProjDAO fullProjDAO = null;
	private MemberDAO memberDAO = null;
	private SchoolDAO schoolDAO = null;
	private MissionBoardDAO missionBoardDAO = null;
	private ParticipatorDAO participatorDAO = null;
	
	public FullProjService()
	{
		fullProjDAO = new FullProjDAOJdbc();
		memberDAO = new MemberDAOJdbc();
		schoolDAO = new SchoolDAOJdbc();
		missionBoardDAO = new MissionBoardDAOJdbc();
		participatorDAO = new ParticipatorDAOJdbc();
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
				MemberBean memberBean = memberDAO.select(bean.getMemberId());
				bean.setMemberBean(memberBean);
				bean.setBase64String(GlobalService.convertByteArrayToBase64String(bean.getFrontCoverName(),bean.getFrontCover()));
				
				int fullProjId = bean.getFullProjId();
				List<ParticipatorBean> participatorBeans = new ArrayList<ParticipatorBean>();
				for(ParticipatorBean participatorBean : participatorDAO.selectByFullProjId(fullProjId))
				{
					if(participatorBean.getParticipateStatus().equals("已通過"))
					{
						participatorBeans.add(participatorBean);
					}
				}
				Map<String,List<ParticipatorBean>> participatorBeanMap = new HashMap<String,List<ParticipatorBean>>();
				participatorBeanMap.put("pending",participatorBeans);
				bean.setParticipatorMap(participatorBeanMap);
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
					// 學校資料
					temp.setSchoolBean(schoolDAO.findByPrimaryKey(temp.getSchoolId()));
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public List<FullProjBean> displaySchoolFullProjProjByChat(FullProjBean bean)
	{
		List<FullProjBean> result = new ArrayList<FullProjBean>();
		
		if(bean != null)
		{
			// 先查詢 該學校的所有完整計畫
			List<FullProjBean> temps = fullProjDAO.selectBySchoolId(bean.getSchoolId());
			for(FullProjBean temp : temps)
			{
				if(temp.getProjStatus().equals("洽談中"))
				{
					temp.setMemberBean(memberDAO.select(temp.getMemberId()));
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public List<FullProjBean> displayPersonalFullProjByParticipate(FullProjBean bean)
	{
		List<FullProjBean> result = new ArrayList<FullProjBean>();
		
		if(bean != null)
		{
			// 先查詢 該會員的所有完整計畫 且 招募中
			List<FullProjBean> temps = fullProjDAO.selectByMemberId(bean.getMemberId());
			for(FullProjBean temp : temps)
			{
				if(temp.getProjStatus().equals("招募中"))
				{
					List<ParticipatorBean> participatorBeans = new ArrayList<ParticipatorBean>();
					// 單一計畫 參予過的所有人 包含拒絕  找出要審核的
					for(ParticipatorBean participatorBean : participatorDAO.selectByFullProjId(temp.getFullProjId()))
					{
						if(participatorBean.getParticipateStatus().equals("待審核"))
						{
							MemberBean memberBean = memberDAO.select(participatorBean.getMemberId());
							participatorBean.setMemberBean(memberBean);
							participatorBeans.add(participatorBean);
						}
					}
					Map<String,List<ParticipatorBean>> participatorBeanMap = new HashMap<String,List<ParticipatorBean>>();
					participatorBeanMap.put("pending",participatorBeans);
					temp.setParticipatorMap(participatorBeanMap);
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
			if(result != null)
			{
				MemberBean memberBean = memberDAO.select(result.getMemberId());
				result.setMemberBean(memberBean);
				result.setBase64String(GlobalService.convertByteArrayToBase64String(result.getFrontCoverName(),result.getFrontCover()));
			
				// 找出該計畫的申請人
				List<ParticipatorBean> participatorByPending = new ArrayList<ParticipatorBean>();
				List<ParticipatorBean> participatorByPass = new ArrayList<ParticipatorBean>();
				for(ParticipatorBean participatorBean : participatorDAO.selectByFullProjId(fullProjId))
				{
					if(participatorBean.getParticipateStatus().equals("待審核"))
					{
						participatorByPending.add(participatorBean);
					}
					
					if(participatorBean.getParticipateStatus().equals("已通過"))
					{
						participatorByPass.add(participatorBean);
					}
				}
				
				Map<String,List<ParticipatorBean>> temp = new HashMap<String,List<ParticipatorBean>>();
				temp.put("pending",participatorByPending);
				temp.put("pass",participatorByPass);
				result.setParticipatorMap(temp);
			}
		}
		return result;
	}
	public FullProjBean updateFullProj(FullProjBean bean)
	{
		FullProjBean result = null;
		
		if (bean != null) 
		{
			// 先select 抓齊所有資料 在對使用者的資料做修改
			FullProjBean temp = fullProjDAO.findByPrimaryKey(bean.getFullProjId());
			System.out.println(temp);
			if(temp != null)
			{
				temp.setTitle(bean.getTitle());
				temp.setProjAbstract(bean.getProjAbstract());
				temp.setContent(bean.getContent());
				temp.setLocation(bean.getLocation());
				temp.setActivityStartTime(bean.getActivityStartTime());
				temp.setActivityEndTime(bean.getActivityEndTime());
				temp.setEstMember(bean.getEstMember());
				temp.setBudget(bean.getBudget());
				temp.setOrgArchitecture(bean.getOrgArchitecture());
				
				// 前端使用者有做更圖，才修改，否則沿用舊的
				if(bean.getFrontCover() != null)
				{
					temp.setFrontCoverName(bean.getFrontCoverName());
					temp.setFrontCover(bean.getFrontCover());
					temp.setFrontCoverLength(bean.getFrontCoverLength());
				}
				
				result = fullProjDAO.update(temp);
			}
		}
		return result;
	}
	
	public boolean schoolConfirm(FullProjBean bean)
	{
		if(bean != null)
		{
			FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(bean.getFullProjId());
			
			if(fullProjBean != null)
			{
				fullProjBean.setSchoolConfirm(true);
				fullProjDAO.update(fullProjBean);
				return true;
			}
		}
		return false;
	}
	
	public boolean memberConfirm(FullProjBean bean)
	{
		if(bean != null)
		{
			FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(bean.getFullProjId());
			
			if(fullProjBean != null)
			{
				fullProjBean.setCreateDate(new java.util.Date(System.currentTimeMillis()));
				fullProjBean.setMemberConfirm(true);
				fullProjBean.setProjStatus("招募中");
				fullProjDAO.update(fullProjBean);
				
				MissionBoardBean missionBoardBean = new MissionBoardBean();
				missionBoardBean.setFullProjId(fullProjBean.getFullProjId());
				missionBoardBean.setName(fullProjBean.getTitle());
				missionBoardBean.setMissionSetNum(0);
				missionBoardDAO.insert(missionBoardBean);
				
				return true;
			}
		}
		return false;
	}
	
	public String getDeadline(java.util.Date activityStartTime){
		String result = null;
		
		if(activityStartTime != null){
			Calendar c = Calendar.getInstance();
			c.setTime(activityStartTime);
			c.add(Calendar.MONTH, -2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf.format(c.getTime());
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		FullProjService service = new FullProjService();
		System.out.println(service.displayFullProjAll());
	}

}

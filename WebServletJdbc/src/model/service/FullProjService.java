package model.service;

import global.GlobalService;

import java.util.ArrayList;
import java.util.List;

import model.FullProjBean;
import model.MemberBean;
import model.ParticipatorBean;
import model.dao.FullProjDAOJdbc;
import model.dao.MemberDAOJdbc;
import model.dao.MissionBoardDAOJdbc;
import model.dao.ParticipatorDAOJdbc;
import model.dao.interfaces.FullProjDAO;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.MissionBoardDAO;
import model.dao.interfaces.ParticipatorDAO;

public class FullProjService
{
	private FullProjDAO fullProjDAO = null;
	private MemberDAO memberDAO = null;
	private MissionBoardDAO missionBoardDAO = null;
	private ParticipatorDAO participatorDAO = null;
	
	public FullProjService()
	{
		fullProjDAO = new FullProjDAOJdbc();
		memberDAO = new MemberDAOJdbc();
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
	
	public List<FullProjBean> displayPersonalFullProjProjByParticipate(FullProjBean bean)
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
					temp.setParticipatorBean(participatorBeans);
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
			}
		}
		return result;
	}
	public FullProjBean updateFullProj(FullProjBean bean)
	{
		FullProjBean result = null;
		
		if (bean != null) 
		{
			// 先selete 抓齊所有資料 在對使用者的資料做修改
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
				
				
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		FullProjService service = new FullProjService();
		System.out.println(service.displayFullProjAll());
	}

}

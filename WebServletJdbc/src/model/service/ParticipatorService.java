package model.service;

import java.util.ArrayList;
import java.util.List;

import model.FullProjBean;
import model.ParticipatorBean;
import model.dao.FullProjDAOJdbc;
import model.dao.ParticipatorDAOJdbc;
import model.dao.interfaces.FullProjDAO;
import model.dao.interfaces.ParticipatorDAO;

public class ParticipatorService
{
	private ParticipatorDAO participatorDAO;
	private FullProjDAO fullProjDAO;
	
	public ParticipatorService()
	{
		participatorDAO = new ParticipatorDAOJdbc();
		fullProjDAO = new FullProjDAOJdbc();
	}

	public ParticipatorBean participate(ParticipatorBean bean)
	{
		ParticipatorBean result = null;
		if(bean != null)
		{
			int fullProjId = bean.getFullProjId();
			int memberId = bean.getMemberId();
			java.util.Date activityStartTime = bean.getActivityStartTime();
			java.util.Date activityEndTime = bean.getActivityEndTime();
			
			// 找出該計畫 有參加過的會員 
			for(ParticipatorBean temp : participatorDAO.selectByFullProjId(fullProjId))
			{
				if(temp.getMemberId() == memberId && (temp.getParticipateStatus().equals("待審核") || temp.getParticipateStatus().equals("已通過")))
				{
					System.out.println("申請過了");
					return null;
				}
			}
			
			// 檢查是否跟其他活動有衝突
			// 找出該發起者 所有參加過的資料 且 要已通過(代表已參加計畫)
			for(ParticipatorBean temp:participatorDAO.selectByMemberId(memberId))
			{
				java.util.Date tempStartTime = temp.getActivityStartTime();
				java.util.Date tempEndTime = temp.getActivityEndTime();
				
				if(temp.getParticipateStatus().equals("已通過"))
				{
					// 衝突一 
					if(tempStartTime.getTime() >= activityStartTime.getTime() && tempEndTime.getTime() <= activityEndTime.getTime())
						return null;
					
					// 衝突二
					if(tempStartTime.getTime() <= activityStartTime.getTime() && tempEndTime.getTime() >= activityEndTime.getTime())
						return null;
					
					// 衝突三
					if(tempStartTime.getTime() <= activityEndTime.getTime() && tempEndTime.getTime() >= activityEndTime.getTime() )
						return null;
					
					// 衝突四
					if(tempStartTime.getTime() <= activityStartTime.getTime() && tempEndTime.getTime() >= activityStartTime.getTime())
						return null;
				}
			}
			
			// 預設資料
			bean.setParticipateStatus("待審核");
			bean.setCheckTime(null);
			bean.setIsParticipate(null);
			result = participatorDAO.insert(bean);
			
		}
		
		return result;
	}
	
	public boolean cancelParticipator(ParticipatorBean bean)
	{
		if(bean != null)
		{
			int participatorId = bean.getParticipatorId();
			
			// 先對 該參加人表格 select 取出該筆資料
			ParticipatorBean participatorBean = participatorDAO.findByPrimaryKey(participatorId);
			participatorBean.setCheckTime(new java.util.Date(System.currentTimeMillis()));
			participatorBean.setParticipateStatus("未通過");
			participatorBean = participatorDAO.update(participatorBean);
			
			if(participatorBean != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public List<ParticipatorBean> dispalyParticipator(ParticipatorBean bean)
	{
		List<ParticipatorBean> result = new ArrayList<ParticipatorBean>();
		if(bean != null)
		{
			// 找出該會員申請過的資料
			int memberId = bean.getMemberId();
			for(ParticipatorBean temp: participatorDAO.selectByMemberId(memberId))
			{
				if(temp.getParticipateStatus().equals("待審核"))
				{
					// join 計畫 才能有計畫名稱
					int fullProjId = temp.getFullProjId();
					FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(fullProjId);
					temp.setFullProjBean(fullProjBean);
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public List<ParticipatorBean> dispalyFullProjByParticipator(ParticipatorBean bean) 
	{
		List<ParticipatorBean> result = new ArrayList<ParticipatorBean>();
		if(bean != null)
		{
			// 找出該會員申請過的資料
			int memberId = bean.getMemberId();
			for(ParticipatorBean temp: participatorDAO.selectByMemberId(memberId))
			{
				if(temp.getParticipateStatus().equals("已通過"))
				{
					// join 計畫 才能有計畫名稱
					int fullProjId = temp.getFullProjId();
					FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(fullProjId);
					temp.setFullProjBean(fullProjBean);
					result.add(temp);
				}
			}
		}
		return result;
	}

	public boolean agreeParticipator(ParticipatorBean bean)
	{
		if(bean != null)
		{
			
			int participatorId = bean.getParticipatorId();
			// 先對該 處理 select
			ParticipatorBean participatorBean = participatorDAO.findByPrimaryKey(participatorId);
			participatorBean.setCheckTime(new java.util.Date(System.currentTimeMillis()));
			participatorBean.setParticipateStatus("已通過");
			participatorBean = participatorDAO.update(participatorBean);
			
			if(participatorBean != null)
			{
				// 修改完成時 對該 memberId 參予的其他計畫 待審核的 如衝突直接取消
				int memberId = participatorBean.getMemberId();
				
				// 被審核通過的活動點
				java.util.Date tempStartTime = participatorBean.getActivityStartTime();
				java.util.Date tempEndTime = participatorBean.getActivityEndTime();
				
				List<ParticipatorBean> memberParticipator = participatorDAO.selectByMemberId(memberId);
				// 找出該會員 其他待審核的參加記錄
				for(ParticipatorBean temp : memberParticipator)
				{
					// 找出 所有待審核時間 對 剛申請的檢查是否有衝突
					if(temp.getParticipateStatus().equals("待審核"))
					{
						// 抓資料庫 待審核的活動時間
						java.util.Date activityStartTime = temp.getActivityStartTime();
						java.util.Date activityEndTime = temp.getActivityEndTime();
						
						// 衝突一 
						if(tempStartTime.getTime() >= activityStartTime.getTime() && tempEndTime.getTime() <= activityEndTime.getTime())
						{
							temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
							temp.setParticipateStatus("未通過");
							participatorDAO.update(temp);
						}
													
						// 衝突二
						if(tempStartTime.getTime() <= activityStartTime.getTime() && tempEndTime.getTime() >= activityEndTime.getTime())
						{
							temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
							temp.setParticipateStatus("未通過");
							participatorDAO.update(temp);
						}
						
						// 衝突三
						if(tempStartTime.getTime() <= activityEndTime.getTime() && tempEndTime.getTime() >= activityEndTime.getTime() )
						{
							temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
							temp.setParticipateStatus("未通過");
							participatorDAO.update(temp);
						}
						
						// 衝突四
						if(tempStartTime.getTime() <= activityStartTime.getTime() && tempEndTime.getTime() >= activityStartTime.getTime())
						{
							temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
							temp.setParticipateStatus("未通過");
							participatorDAO.update(temp);
						}
					}
				}
				
				// 找出該計畫的招募情況 如果已滿 同計畫要一併取消
				int fullProjId = participatorBean.getFullProjId();
				FullProjBean fullProjBean = fullProjDAO.findByPrimaryKey(fullProjId);
				int estMember = fullProjBean.getEstMember();
				
				List<ParticipatorBean> pass = new ArrayList<ParticipatorBean>();
				List<ParticipatorBean> fullProjParticipator = participatorDAO.selectByFullProjId(fullProjId);
				for(ParticipatorBean temp : fullProjParticipator)
				{
					if(temp.getParticipateStatus().equals("已通過"))
					{
						pass.add(temp);
					}
				}
				
				// 人數已招滿
				if(pass.size() == estMember)
				{
					// 如果還有待審核 全取消
					for(ParticipatorBean temp : fullProjParticipator)
					{
						if(temp.getParticipateStatus().equals("待審核"))
						{
							temp.setCheckTime(new java.util.Date(System.currentTimeMillis()));
							temp.setParticipateStatus("未通過");
							participatorDAO.update(temp);
						}
					}
					
					// 因為已經招募完 把完整計畫改成 進行中
					fullProjBean.setProjStatus("進行中");
					fullProjDAO.update(fullProjBean);
				}
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{

	}


}

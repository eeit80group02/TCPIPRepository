package model.service;

import java.util.ArrayList;
import java.util.List;

import model.ParticipatorBean;
import model.dao.ParticipatorDAOJdbc;
import model.dao.interfaces.ParticipatorDAO;

public class ParticipatorService
{
	private ParticipatorDAO participatorDAO;
	
	public ParticipatorService()
	{
		participatorDAO = new ParticipatorDAOJdbc();
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
	public static void main(String[] args)
	{

	}

}

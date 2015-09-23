package model;

import java.io.Serializable;

public class ParticipatorBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer participatorId;				// 流水號
	private Integer fullProjId;    				// 完整計畫 FK 
	private Integer memberId;      				// 會員編號 FK
	private java.util.Date activityStartTime;   // 完整計畫 活動時間(起)
	private java.util.Date activityEndTime;     // 完整計畫 活動時間(迄)
	private String participateStatus;           // 審核狀態
	private java.util.Date checkTime;           // 審核通過時間
	private String isParticipate;               // 是否參加
	
	private MemberBean memberBean;              // 參加人資料

	public ParticipatorBean()
	{
	}

	public Integer getParticipatorId()
	{
		return participatorId;
	}

	public void setParticipatorId(Integer participatorId)
	{
		this.participatorId = participatorId;
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	public java.util.Date getActivityStartTime()
	{
		return activityStartTime;
	}

	public void setActivityStartTime(java.util.Date activityStartTime)
	{
		this.activityStartTime = activityStartTime;
	}

	public java.util.Date getActivityEndTime()
	{
		return activityEndTime;
	}

	public void setActivityEndTime(java.util.Date activityEndTime)
	{
		this.activityEndTime = activityEndTime;
	}

	public String getParticipateStatus()
	{
		return participateStatus;
	}

	public void setParticipateStatus(String participateStatus)
	{
		this.participateStatus = participateStatus;
	}

	public java.util.Date getCheckTime()
	{
		return checkTime;
	}

	public void setCheckTime(java.util.Date checkTime)
	{
		this.checkTime = checkTime;
	}

	public String getIsParticipate()
	{
		return isParticipate;
	}

	public void setIsParticipate(String isParticipate)
	{
		this.isParticipate = isParticipate;
	}

	public MemberBean getMemberBean()
	{
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean)
	{
		this.memberBean = memberBean;
	}

	@Override
	public String toString()
	{
		return "ParticipatorBean [participatorId=" + participatorId + ", fullProjId=" + fullProjId + ", memberId=" + memberId + ", activityStartTime=" + activityStartTime + ", activityEndTime=" + activityEndTime + ", participateStatus="
				+ participateStatus + ", checkTime=" + checkTime + ", isParticipate=" + isParticipate + "]";
	}
}

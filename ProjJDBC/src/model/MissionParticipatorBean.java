package model;

import java.io.Serializable;

public class MissionParticipatorBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer missionParticipatorId;    	// 流水號
	private Integer missionId;  				// 任務編號   FK
	private Integer memberId;      				// 參與者(協助任務執行的人) FK

	public MissionParticipatorBean()
	{
	}

	public Integer getMissionParticipatorId()
	{
		return missionParticipatorId;
	}

	public void setMissionParticipatorId(Integer missionParticipatorId)
	{
		this.missionParticipatorId = missionParticipatorId;
	}

	public Integer getMissionId()
	{
		return missionId;
	}

	public void setMissionId(Integer missionId)
	{
		this.missionId = missionId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	@Override
	public String toString()
	{
		return "MissionParticipatorBean [missionParticipatorId=" + missionParticipatorId + ", missionId=" + missionId + ", memberId=" + memberId + "]";
	}
	
} 

package model;

import java.io.Serializable;

public class MissionBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer missionId;          // 任務編號 PK
	private Integer missionSetId;       // 任務集編號 FK
	private String name;            	// 任務名稱
	private Integer	host;               // 執行者(主要負責執行的人) FK 會員編號	
	private java.util.Date endTime; 	// 執行任務的截止時間
	private	String missionPriority;    // 執行任務的優先次序
	private	Integer missionPosition;    // 擺在哪個指定的位置(任務順序上下)
	private	String missionStatus;   	// 任務進行狀態(進行中,已完成)
	private	Integer mainMissionId;   // 主任務編號(「有值」的時候就是子任務) FK
	
	public MissionBean()
	{
	}

	public Integer getMissionId()
	{
		return missionId;
	}

	public void setMissionId(Integer missionId)
	{
		this.missionId = missionId;
	}

	public Integer getMissionSetId()
	{
		return missionSetId;
	}

	public void setMissionSetId(Integer missionSetId)
	{
		this.missionSetId = missionSetId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getHost()
	{
		return host;
	}

	public void setHost(Integer host)
	{
		this.host = host;
	}

	public java.util.Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(java.util.Date endTime)
	{
		this.endTime = endTime;
	}

	public String getMissionPriority()
	{
		return missionPriority;
	}

	public void setMissionPriority(String missionPriority)
	{
		this.missionPriority = missionPriority;
	}

	public Integer getMissionPosition()
	{
		return missionPosition;
	}

	public void setMissionPosition(Integer missionPosition)
	{
		this.missionPosition = missionPosition;
	}

	public String getMissionStatus()
	{
		return missionStatus;
	}

	public void setMissionStatus(String missionStatus)
	{
		this.missionStatus = missionStatus;
	}

	public Integer getMainMissionId()
	{
		return mainMissionId;
	}

	public void setMainMissionId(Integer mainMissionId)
	{
		this.mainMissionId = mainMissionId;
	}

	@Override
	public String toString()
	{
		return "MissionBean [missionId=" + missionId + ", missionSetId=" + missionSetId + ", name=" + name + ", host=" + host + ", endTime=" + endTime + ", missionPriority=" + missionPriority + ", missionPosition=" + missionPosition + ", missionStatus="
				+ missionStatus + ", mainMissionId=" + mainMissionId + "]";
	}

}

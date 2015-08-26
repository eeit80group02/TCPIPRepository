package model;

import java.util.List;

public class MissionBean 
{
	private int missionBoardId;     // 任務集編號 FK
	private int missionId;          // 任務編號 PK
	private String name;            // 任務名稱
	private int	host;               // 執行者(主要負責執行的人) FK 會員編號	
	private java.util.Date endTime; // 執行任務的截止時間
	private	int missionPriority;    // 執行任務的優先次序
	private	int belongMissionSet;   // 屬於哪個任務集(關聯到任務集編號)(指任務集編號 左右) FK	
	private	int missionPosition;    // 擺在哪個指定的位置(任務順序上下)
	private	String missionStatus;   // 任務進行狀態(進行中,已完成)
	private	int mainMissionSetId;   // 主任務編號(「有值」的時候就是子任務) FK
	
	public int getMissionBoardId()
	{
		return missionBoardId;
	}
	public void setMissionBoardId(int missionBoardId)
	{
		this.missionBoardId = missionBoardId;
	}
	public int getMissionId()
	{
		return missionId;
	}
	public void setMissionId(int missionId)
	{
		this.missionId = missionId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getHost()
	{
		return host;
	}
	public void setHost(int host)
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
	public int getMissionPriority()
	{
		return missionPriority;
	}
	public void setMissionPriority(int missionPriority)
	{
		this.missionPriority = missionPriority;
	}
	public int getBelongMissionSet()
	{
		return belongMissionSet;
	}
	public void setBelongMissionSet(int belongMissionSet)
	{
		this.belongMissionSet = belongMissionSet;
	}
	public int getMissionPosition()
	{
		return missionPosition;
	}
	public void setMissionPosition(int missionPosition)
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
	public int getMainMissionSetId()
	{
		return mainMissionSetId;
	}
	public void setMainMissionSetId(int mainMissionSetId)
	{
		this.mainMissionSetId = mainMissionSetId;
	}
	@Override
	public String toString()
	{
		return "MissionBean [missionBoardId=" + missionBoardId + ", missionId=" + missionId + ", name=" + name + ", host=" + host + ", endTime=" + endTime + ", missionPriority=" + missionPriority + ", belongMissionSet=" + belongMissionSet
				+ ", missionPosition=" + missionPosition + ", missionStatus=" + missionStatus + ", mainMissionSetId=" + mainMissionSetId + "]";
	}
}

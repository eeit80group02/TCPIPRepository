package model;

import java.io.Serializable;

public class MissionBoardBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer missionBoardId;	// 任務版流水號
	private Integer fullProjId;		// 完整計畫編號 FK	
	private String name;         	// 計畫名稱
	private Integer missionSetNum;	// 任務集數量
	
	public MissionBoardBean()
	{
	}

	public Integer getMissionBoardId()
	{
		return missionBoardId;
	}

	public void setMissionBoardId(Integer missionBoardId)
	{
		this.missionBoardId = missionBoardId;
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getMissionSetNum()
	{
		return missionSetNum;
	}

	public void setMissionSetNum(Integer missionSetNum)
	{
		this.missionSetNum = missionSetNum;
	}

	@Override
	public String toString()
	{
		return "MissionBoardBean [missionBoardId=" + missionBoardId + ", fullProjId=" + fullProjId + ", name=" + name + ", missionSetNum=" + missionSetNum + "]";
	}
	
}

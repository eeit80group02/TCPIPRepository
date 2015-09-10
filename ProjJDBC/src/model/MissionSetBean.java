package model;

import java.io.Serializable;

public class MissionSetBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer missionSetId;		// 任務集編號 PK
	private Integer missionBoardId;		// 任務版編號 FK
	private String name;        	 	// 任務集名稱
	private Integer missionSetOrder;	// 任務集順序
	
	public MissionSetBean()
	{
	}

	public Integer getMissionSetId()
	{
		return missionSetId;
	}

	public void setMissionSetId(Integer missionSetId)
	{
		this.missionSetId = missionSetId;
	}

	public Integer getMissionBoardId()
	{
		return missionBoardId;
	}

	public void setMissionBoardId(Integer missionBoardId)
	{
		this.missionBoardId = missionBoardId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getMissionSetOrder()
	{
		return missionSetOrder;
	}

	public void setMissionSetOrder(Integer missionSetOrder)
	{
		this.missionSetOrder = missionSetOrder;
	}

	@Override
	public String toString()
	{
		return "MissionSetBean [missionSetId=" + missionSetId + ", missionBoardId=" + missionBoardId + ", name=" + name + ", missionSetOrder=" + missionSetOrder + "]";
	}
	
}

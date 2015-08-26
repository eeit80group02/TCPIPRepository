package model;

public class MissionSetBean 
{
	private int missionBoardId;	     // 任務版編號 FK
	private int missionSetId;    	 // 任務集編號 PK
	private String name;        	 // 任務集名稱
	private int missionSetOrder; 	 // 任務集順序
	public int getMissionBoardId()
	{
		return missionBoardId;
	}
	public void setMissionBoardId(int missionBoardId)
	{
		this.missionBoardId = missionBoardId;
	}
	public int getMissionSetId()
	{
		return missionSetId;
	}
	public void setMissionSetId(int missionSetId)
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
	public int getMissionSetOrder()
	{
		return missionSetOrder;
	}
	public void setMissionSetOrder(int missionSetOrder)
	{
		this.missionSetOrder = missionSetOrder;
	}
	@Override
	public String toString()
	{
		return "MissionSetBean [missionBoardId=" + missionBoardId + ", missionSetId=" + missionSetId + ", name=" + name + ", missionSetOrder=" + missionSetOrder + "]";
	}
}

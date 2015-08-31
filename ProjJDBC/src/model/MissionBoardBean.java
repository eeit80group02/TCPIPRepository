package model;

public class MissionBoardBean 
{
	private int missionBoardId;  // 任務版流水號
	private int fullProjId;      // 完整計畫編號 FK	
	private String name;         //	計畫名稱
	private int missionSetNum;	 // 任務集數量
	
	public int getMissionBoardId()
	{
		return missionBoardId;
	}
	public void setMissionBoardId(int missionBoardId)
	{
		this.missionBoardId = missionBoardId;
	}
	public int getFullProjId()
	{
		return fullProjId;
	}
	public void setFullProjId(int fullProjId)
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
	public int getMissionSetNum()
	{
		return missionSetNum;
	}
	public void setMissionSetNum(int missionSetNum)
	{
		this.missionSetNum = missionSetNum;
	}
	
	@Override
	public String toString()
	{
		return "MissionBoardBean [missionBoardId=" + missionBoardId + ", fullProjId=" + fullProjId + ", name=" + name + ", missionSetNum=" + missionSetNum + "]";
	}
}

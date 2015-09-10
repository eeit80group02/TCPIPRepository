package model;

import java.io.Serializable;

public class ProcessingProjBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer processingProjId;	// 流水號 PK
	private Integer primaryProjId;   	// 計畫需求編號 FK
	private Integer schoolId;  			// 會員編號 FK
	private java.util.Date checkTime;   // 審核時間 (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
	private String checkStatus;			// 審核狀態(已通過 未通過 待審核)
	
	public ProcessingProjBean()
	{
	}

	public Integer getProcessingProjId()
	{
		return processingProjId;
	}

	public void setProcessingProjId(Integer processingProjId)
	{
		this.processingProjId = processingProjId;
	}

	public Integer getPrimaryProjId()
	{
		return primaryProjId;
	}

	public void setPrimaryProjId(Integer primaryProjId)
	{
		this.primaryProjId = primaryProjId;
	}

	public Integer getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
	}

	public java.util.Date getCheckTime()
	{
		return checkTime;
	}

	public void setCheckTime(java.util.Date checkTime)
	{
		this.checkTime = checkTime;
	}

	public String getCheckStatus()
	{
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus)
	{
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString()
	{
		return "ProcessingProjBean [processingProjId=" + processingProjId + ", primaryProjId=" + primaryProjId + ", schoolId=" + schoolId + ", checkTime=" + checkTime + ", checkStatus=" + checkStatus + "]";
	}
}

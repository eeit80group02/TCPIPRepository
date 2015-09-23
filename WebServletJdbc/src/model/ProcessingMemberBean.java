package model;


import java.io.Serializable;
import java.util.List;

public class ProcessingMemberBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer processingMemberId;	// 流水號
	private Integer schoolDemandId; 	// 計畫需求編號 FK
	private Integer memberId; 			// 會員編號 FK
	private java.util.Date checkTime; 	// 審核時間(指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
	private String checkStatus;			// 審核狀態(已通過 未通過 待審核)
	private MemberBean memberBean;
	
	
	public ProcessingMemberBean()
	{
	}

	public Integer getProcessingMemberId()
	{
		return processingMemberId;
	}

	public void setProcessingMemberId(Integer processingMemberId)
	{
		this.processingMemberId = processingMemberId;
	}

	public Integer getSchoolDemandId()
	{
		return schoolDemandId;
	}

	public void setSchoolDemandId(Integer schoolDemandId)
	{
		this.schoolDemandId = schoolDemandId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
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

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	@Override
	public String toString()
	{
		return "ProcessingMemberBean [processingMemberId=" + processingMemberId + ", schoolDemandId=" + schoolDemandId + ", memberId=" + memberId + ", checkTime=" + checkTime + ", checkStatus=" + checkStatus + ", memberBean="+ memberBean + "]";
	}
}

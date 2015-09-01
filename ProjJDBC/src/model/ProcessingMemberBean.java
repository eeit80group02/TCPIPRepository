package model;

public class ProcessingMemberBean
{
	private int schoolDemandId;     	// 計畫需求編號 FK
	private int memberId;        	    //會員編號 FK
	private java.util.Date datetime;    // (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
	public int getSchoolDemandId() {
		return schoolDemandId;
	}
	public void setSchoolDemandId(int schoolDemandId) {
		this.schoolDemandId = schoolDemandId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public java.util.Date getDatetime() {
		return datetime;
	}
	public void setDatetime(java.util.Date datetime) {
		this.datetime = datetime;
	}
	
	@Override
	public String toString() {
		return "ProcessingMemberBean [schoolDemandId=" + schoolDemandId
				+ ", memberId=" + memberId + ", datetime=" + datetime + "]";
	}
}


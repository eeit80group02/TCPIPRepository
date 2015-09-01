package model;

public class ProcessingProjBean 
{
	private int primaryProjId;   		// 計畫需求編號 FK
	private int schoolId;  			    // 會員編號 FK
	private java.util.Date checkTime;   // 審核時間 (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
	public int getPrimaryProjId() {
		return primaryProjId;
	}
	public void setPrimaryProjId(int primaryProjId) {
		this.primaryProjId = primaryProjId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public java.util.Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(java.util.Date checkTime) {
		this.checkTime = checkTime;
	}
	
	@Override
	public String toString() {
		return "ProcessingProjBean [primaryProjId=" + primaryProjId
				+ ", schoolId=" + schoolId + ", checkTime=" + checkTime + "]";
	}
}

package model;

public class ProjModifyBean
{
	private int fullProjId;	       		  // 完整計畫編號 FK
	private int schoolId;           	  // 學校編號 FK
	private String schoolMessage;	    	  // 學校留言
	private java.util.Date schoolMessageTime; // 學校留言時間
	private int memberId;    	          // 會員編號(發起者) FK
	private String memberMessage;	          // 會員留言 
	private java.util.Date memberMessageTime;    // 會員留言時間
	public int getFullProjId() {
		return fullProjId;
	}
	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolMessage() {
		return schoolMessage;
	}
	public void setSchoolMessage(String schoolMessage) {
		this.schoolMessage = schoolMessage;
	}
	public java.util.Date getSchoolMessageTime() {
		return schoolMessageTime;
	}
	public void setSchoolMessageTime(java.util.Date schoolMessageTime) {
		this.schoolMessageTime = schoolMessageTime;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberMessage() {
		return memberMessage;
	}
	public void setMemberMessage(String memberMessage) {
		this.memberMessage = memberMessage;
	}
	public java.util.Date getMemberMessageTime() {
		return memberMessageTime;
	}
	public void setMemberMessageTime(java.util.Date memberMessageTime) {
		this.memberMessageTime = memberMessageTime;
	}
	@Override
	public String toString() {
		return "ProjModifyBean [fullProjId=" + fullProjId + ", schoolId="
				+ schoolId + ", schoolMessage=" + schoolMessage
				+ ", schoolMessageTime=" + schoolMessageTime + ", memberId="
				+ memberId + ", memberMessage=" + memberMessage
				+ ", memberMessageTime=" + memberMessageTime + "]";
	}
	
}

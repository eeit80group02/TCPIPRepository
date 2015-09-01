package model;

public class MissionMessageBean 
{
	private int missionMessageId;           // 計畫編號(完整計畫編號) FK
	private int missionId;               	// 任務編號 FK
	private int memberId;                   // 留言者編號(留言者的會員編號) FK
	private String content;                 // 留言內容
	private java.util.Date messageTime;     // 留言時間
	public int getMissionMessageId() {
		return missionMessageId;
	}
	public void setMissionMessageId(int missionMessageId) {
		this.missionMessageId = missionMessageId;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(java.util.Date messageTime) {
		this.messageTime = messageTime;
	}
	@Override
	public String toString() {
		return "MissionMessageBean [missionMessageId=" + missionMessageId
				+ ", missionId=" + missionId + ", memberId=" + memberId
				+ ", content=" + content + ", messageTime=" + messageTime + "]";
	}
}

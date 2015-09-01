package model;

public class MissionParticipatorBean 
{
	private int missionParticipatorId;    	// 流水號
	private int missionId;  				// 任務編號   FK
	private int memberId;      				// 參與者(協助任務執行的人) FK
	public int getMissionParticipatorId() {
		return missionParticipatorId;
	}
	public void setMissionParticipatorId(int missionParticipatorId) {
		this.missionParticipatorId = missionParticipatorId;
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
	@Override
	public String toString() {
		return "MissionParticipatorBean [missionParticipatorId="
				+ missionParticipatorId + ", missionId=" + missionId
				+ ", memberId=" + memberId + "]";
	}
} 

package model;

public class TrackProjBean {
	private int fullProjId; // 完整計畫編號 FK
	private int memberId; // 會員編號 FK

	@Override
	public String toString() {
		return "TrackProjBean [fullProjId=" + fullProjId + ", memberId=" + memberId + "]";
	}

	public int getFullProjId() {
		return fullProjId;
	}

	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}

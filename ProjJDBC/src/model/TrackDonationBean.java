package model;

public class TrackDonationBean {
	private int donationId; // 捐獻編號 FK
	private int memberId; // 會員編號 FK

	@Override
	public String toString() {
		return "TrackDonationBean [donationId=" + donationId + ", memberId=" + memberId + "]";
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}

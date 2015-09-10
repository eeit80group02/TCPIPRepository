package model;

import java.io.Serializable;

public class TrackDonationBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer trackDonationId;	// 流水號
	private Integer donationId; 		// 捐獻編號 FK
	private Integer memberId; 			// 會員編號 FK
	
	public TrackDonationBean()
	{
	}

	public Integer getTrackDonationId()
	{
		return trackDonationId;
	}

	public void setTrackDonationId(Integer trackDonationId)
	{
		this.trackDonationId = trackDonationId;
	}

	public Integer getDonationId()
	{
		return donationId;
	}

	public void setDonationId(Integer donationId)
	{
		this.donationId = donationId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	@Override
	public String toString()
	{
		return "TrackDonationBean [trackDonationId=" + trackDonationId + ", donationId=" + donationId + ", memberId=" + memberId + "]";
	}
}

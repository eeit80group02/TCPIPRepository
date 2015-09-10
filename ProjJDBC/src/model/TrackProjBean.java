package model;

import java.io.Serializable;

public class TrackProjBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer trackProjId;		// 流水號
	private Integer fullProjId; 		// 完整計畫編號 FK
	private Integer memberId;			// 會員編號 FK
	
	public TrackProjBean()
	{
	}

	public Integer getTrackProjId()
	{
		return trackProjId;
	}

	public void setTrackProjId(Integer trackProjId)
	{
		this.trackProjId = trackProjId;
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	@Override
	public String toString()
	{
		return "TrackProjBean [trackProjId=" + trackProjId + ", fullProjId=" + fullProjId + ", memberId=" + memberId + "]";
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

}

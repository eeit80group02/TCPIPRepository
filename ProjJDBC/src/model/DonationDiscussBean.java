package model;

import java.io.Serializable;

public class DonationDiscussBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer donationDiscussId;			// 問與答流水號
	private Integer donationId; 				// 捐獻編號(對應到【捐獻】表格) FK
	private Integer memberId; 					// 會員編號(提問人的會員編號) FK
	private String memberMessage; 				// 會員留言(有意願捐獻者問的問題)
	private java.util.Date memberMessageTime;	// 會員留言時間
	private Integer schoolId; 					// 學校編號(回覆問題的學校編號) FK
	private String schoolMessage; 				// 學校留言(學校回覆捐獻者的問題)
	private java.util.Date schoolMessageTime; 	// 學校留言時間
	
	public DonationDiscussBean()
	{
	}

	public Integer getDonationDiscussId()
	{
		return donationDiscussId;
	}

	public void setDonationDiscussId(Integer donationDiscussId)
	{
		this.donationDiscussId = donationDiscussId;
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

	public String getMemberMessage()
	{
		return memberMessage;
	}

	public void setMemberMessage(String memberMessage)
	{
		this.memberMessage = memberMessage;
	}

	public java.util.Date getMemberMessageTime()
	{
		return memberMessageTime;
	}

	public void setMemberMessageTime(java.util.Date memberMessageTime)
	{
		this.memberMessageTime = memberMessageTime;
	}

	public Integer getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
	}

	public String getSchoolMessage()
	{
		return schoolMessage;
	}

	public void setSchoolMessage(String schoolMessage)
	{
		this.schoolMessage = schoolMessage;
	}

	public java.util.Date getSchoolMessageTime()
	{
		return schoolMessageTime;
	}

	public void setSchoolMessageTime(java.util.Date schoolMessageTime)
	{
		this.schoolMessageTime = schoolMessageTime;
	}

	@Override
	public String toString()
	{
		return "DonationDiscussBean [donationDiscussId=" + donationDiscussId + ", donationId=" + donationId + ", memberId=" + memberId + ", memberMessage=" + memberMessage + ", memberMessageTime=" + memberMessageTime + ", schoolId=" + schoolId
				+ ", schoolMessage=" + schoolMessage + ", schoolMessageTime=" + schoolMessageTime + "]";
	}

}

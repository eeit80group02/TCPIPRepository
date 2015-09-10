package model;

import java.io.Serializable;

public class ProjModifyBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer projModifyId;			  // 流水號 PK
	private Integer fullProjId;	       		  // 完整計畫編號 FK
	private Integer schoolId;           	  // 學校編號 FK
	private String schoolMessage;	    	  // 學校留言
	private java.util.Date schoolMessageTime; // 學校留言時間
	private Integer memberId;    	          // 會員編號(發起者) FK
	private String memberMessage;	          // 會員留言 
	private java.util.Date memberMessageTime; // 會員留言時間
	
	public ProjModifyBean()
	{
	}

	public Integer getProjModifyId()
	{
		return projModifyId;
	}

	public void setProjModifyId(Integer projModifyId)
	{
		this.projModifyId = projModifyId;
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
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

	@Override
	public String toString()
	{
		return "ProjModifyBean [projModifyId=" + projModifyId + ", fullProjId=" + fullProjId + ", schoolId=" + schoolId + ", schoolMessage=" + schoolMessage + ", schoolMessageTime=" + schoolMessageTime + ", memberId=" + memberId + ", memberMessage="
				+ memberMessage + ", memberMessageTime=" + memberMessageTime + "]";
	}
}

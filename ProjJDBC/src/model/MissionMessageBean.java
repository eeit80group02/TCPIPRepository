package model;

import java.io.Serializable;

public class MissionMessageBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer missionMessageId; 		// 任務留言編號 PK
	private Integer missionId; 				// 任務編號 FK
	private Integer memberId; 				// 留言者編號(留言者的會員編號) FK
	private String content; 				// 留言內容
	private java.util.Date messageTime; 	// 留言時間
	
	public MissionMessageBean()
	{
	}

	public Integer getMissionMessageId()
	{
		return missionMessageId;
	}

	public void setMissionMessageId(Integer missionMessageId)
	{
		this.missionMessageId = missionMessageId;
	}

	public Integer getMissionId()
	{
		return missionId;
	}

	public void setMissionId(Integer missionId)
	{
		this.missionId = missionId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public java.util.Date getMessageTime()
	{
		return messageTime;
	}

	public void setMessageTime(java.util.Date messageTime)
	{
		this.messageTime = messageTime;
	}

	@Override
	public String toString()
	{
		return "MissionMessageBean [missionMessageId=" + missionMessageId + ", missionId=" + missionId + ", memberId=" + memberId + ", content=" + content + ", messageTime=" + messageTime + "]";
	}

}

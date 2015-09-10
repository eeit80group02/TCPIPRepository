package model;

import java.io.Serializable;

public class SchoolDemandBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Integer schoolDemandId; 	// 計畫需求編號 PK identity
	private Integer schoolId; 			// 學校編號 FK
	private Integer participant; 		// 預計參與的學生人數
	private String activityTopic; 		// 活動主題(指學校希望志工規劃的主題)
	private String activityLocation; 	// 活動地點(非必填)
	private String activitySuitable; 	// 活動適合對象(指學校希望志工來帶領的人的程度)
	private String activityHost; 		// 活動負責人(學校方負責此項計畫的聯絡人)
	private String activityContact; 	// 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
	private java.util.Date createDate; 	// 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
	private String content; 			// 需求內容(1000字?)
	private String demandStatus;		// 計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
	
	public SchoolDemandBean()
	{
	}

	public Integer getSchoolDemandId()
	{
		return schoolDemandId;
	}

	public void setSchoolDemandId(Integer schoolDemandId)
	{
		this.schoolDemandId = schoolDemandId;
	}

	public Integer getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
	}

	public Integer getParticipant()
	{
		return participant;
	}

	public void setParticipant(Integer participant)
	{
		this.participant = participant;
	}

	public String getActivityTopic()
	{
		return activityTopic;
	}

	public void setActivityTopic(String activityTopic)
	{
		this.activityTopic = activityTopic;
	}

	public String getActivityLocation()
	{
		return activityLocation;
	}

	public void setActivityLocation(String activityLocation)
	{
		this.activityLocation = activityLocation;
	}

	public String getActivitySuitable()
	{
		return activitySuitable;
	}

	public void setActivitySuitable(String activitySuitable)
	{
		this.activitySuitable = activitySuitable;
	}

	public String getActivityHost()
	{
		return activityHost;
	}

	public void setActivityHost(String activityHost)
	{
		this.activityHost = activityHost;
	}

	public String getActivityContact()
	{
		return activityContact;
	}

	public void setActivityContact(String activityContact)
	{
		this.activityContact = activityContact;
	}

	public java.util.Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate)
	{
		this.createDate = createDate;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getDemandStatus()
	{
		return demandStatus;
	}

	public void setDemandStatus(String demandStatus)
	{
		this.demandStatus = demandStatus;
	}

	@Override
	public String toString()
	{
		return "SchoolDemandBean [schoolDemandId=" + schoolDemandId + ", schoolId=" + schoolId + ", participant=" + participant + ", activityTopic=" + activityTopic + ", activityLocation=" + activityLocation + ", activitySuitable=" + activitySuitable
				+ ", activityHost=" + activityHost + ", activityContact=" + activityContact + ", createDate=" + createDate + ", content=" + content + ", demandStatus=" + demandStatus + "]";
	}

}

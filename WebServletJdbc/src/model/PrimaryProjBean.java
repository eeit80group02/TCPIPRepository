package model;

import java.io.Serializable;
import java.util.List;

public class PrimaryProjBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer primaryProjId;             	// identity
	private Integer memberId;               	// 會員編號
	private String title;               		// 初步計畫 名稱
	private String frontCoverName;     			// 封面 檔名
	private byte[] frontCover;        		  	// 封面 圖片
	private Long frontCoverLength;      		// 封面 圖片 長度
	private String projAbstract;        		// 計畫摘要
	private String content;             		// 計畫內容
	private String idealPlace;          		// 理想地點
	private java.util.Date activityStartTime;   // 預計活動時間(起)
	private java.util.Date activityEndTime;     // 預計活動時間(迄)
	private Integer demandNum;              	// 預計參予人數
	private Integer budget;                 	// 預算
	private java.util.Date createDate;   		// 建立日期
	private String projStatus;          		// 狀態
	
	private String base64String;				// 圖片
	private List<ProcessingProjBean> processingProjBean;	// 存計畫被關聯的 ProcessingProj
	private MemberBean memberBean;				// 會員詳細資料
	
	public PrimaryProjBean()
	{
	}
	public Integer getPrimaryProjId()
	{
		return primaryProjId;
	}
	public void setPrimaryProjId(Integer primaryProjId)
	{
		this.primaryProjId = primaryProjId;
	}
	public Integer getMemberId()
	{
		return memberId;
	}
	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getFrontCoverName()
	{
		return frontCoverName;
	}
	public void setFrontCoverName(String frontCoverName)
	{
		this.frontCoverName = frontCoverName;
	}
	public byte[] getFrontCover()
	{
		return frontCover;
	}
	public void setFrontCover(byte[] frontCover)
	{
		this.frontCover = frontCover;
	}
	public Long getFrontCoverLength()
	{
		return frontCoverLength;
	}
	public void setFrontCoverLength(Long frontCoverLength)
	{
		this.frontCoverLength = frontCoverLength;
	}
	public String getProjAbstract()
	{
		return projAbstract;
	}
	public void setProjAbstract(String projAbstract)
	{
		this.projAbstract = projAbstract;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getIdealPlace()
	{
		return idealPlace;
	}
	public void setIdealPlace(String idealPlace)
	{
		this.idealPlace = idealPlace;
	}
	public java.util.Date getActivityStartTime()
	{
		return activityStartTime;
	}
	public void setActivityStartTime(java.util.Date activityStartTime)
	{
		this.activityStartTime = activityStartTime;
	}
	public java.util.Date getActivityEndTime()
	{
		return activityEndTime;
	}
	public void setActivityEndTime(java.util.Date activityEndTime)
	{
		this.activityEndTime = activityEndTime;
	}
	public Integer getDemandNum()
	{
		return demandNum;
	}
	public void setDemandNum(Integer demandNum)
	{
		this.demandNum = demandNum;
	}
	public Integer getBudget()
	{
		return budget;
	}
	public void setBudget(Integer budget)
	{
		this.budget = budget;
	}
	public java.util.Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate)
	{
		this.createDate = createDate;
	}
	public String getProjStatus()
	{
		return projStatus;
	}
	public void setProjStatus(String projStatus)
	{
		this.projStatus = projStatus;
	}

	public String getBase64String()
	{
		return base64String;
	}
	public void setBase64String(String base64String)
	{
		this.base64String = base64String;
	}
	
	public List<ProcessingProjBean> getProcessingProjBean()
	{
		return processingProjBean;
	}
	public void setProcessingProjBean(List<ProcessingProjBean> processingProjBean)
	{
		this.processingProjBean = processingProjBean;
	}
	public MemberBean getMemberBean()
	{
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean)
	{
		this.memberBean = memberBean;
	}
	@Override
	public String toString()
	{
		return "PrimaryProjBean [primaryProjId=" + primaryProjId + ", memberId=" + memberId + ", title=" + title + ", frontCoverName=" + frontCoverName + ", frontCoverLength=" + frontCoverLength + ", projAbstract=" + projAbstract + ", content=" + content
				+ ", idealPlace=" + idealPlace + ", activityStartTime=" + activityStartTime + ", activityEndTime=" + activityEndTime + ", demandNum=" + demandNum + ", budget=" + budget + ", createDate=" + createDate + ", projStatus=" + projStatus + "]";
	}
	
}

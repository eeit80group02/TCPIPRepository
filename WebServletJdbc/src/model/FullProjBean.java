package model;

import java.io.Serializable;
import java.util.List;

public class FullProjBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer fullProjId;             		// 完整計畫 PK 流水
	private Integer primaryProjId;         			// 初步計畫 FK
	private Integer schoolDemandId;          		// 學校需求 FK *命名可能有問題
	private Integer memberId;                		// 發起人     FK
	private Integer schoolId;                		// 學校編號 FK
	private String title;             	 			// 完整計畫名稱
	private String frontCoverName;   	 			// 完整計畫封面 圖片檔名
	private byte[] frontCover;      	 			// 完整計畫封面 圖片
	private Long frontCoverLength;   	 			// 完整計畫封面 圖片長度		
	private String projAbstract;     	 			// 完整計畫摘要(封面指到後的文字)
	private String content;          	 			// 完整計畫內容
	private String location;	     	 			// 活動地點
	private java.util.Date activityStartTime;  		// 活動時間(起)	
	private java.util.Date activityEndTime;  		// 活動時間(訖)	
	private Integer estMember;           			// 預計招募人數 
	private Integer budget;             		    // 活動預算
	private java.util.Date createDate;				// 建立日期(完整計畫發布的日期)
	private String projStatus;       				// 計畫狀態(招募中;已失敗;已完成)	
	private String orgArchitecture;	 				// 成員架構(文字敘述)
	private String projFileName;          			// pdf檔名
	private byte[] projFile;	             		// pdf
	private Long projFileLength;          			// pdf檔案長度
	private Integer reviews;			 			// 評論
	private String reviewsContent;   				// 評論內容
	private Boolean schoolConfirm;             		// 學校確認狀態(同意、預設null T or F)	
	private Boolean memberConfirm;               	// 發起人確認狀態(同意、預設null)
	
	private String base64String;					// base64字串
	private MemberBean memberBean;					// 會員資料
	private List<ParticipatorBean> participatorBeans;	// 參加人集合
	public FullProjBean()
	{
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public Integer getPrimaryProjId()
	{
		return primaryProjId;
	}

	public void setPrimaryProjId(Integer primaryProjId)
	{
		this.primaryProjId = primaryProjId;
	}

	public Integer getSchoolDemandId()
	{
		return schoolDemandId;
	}

	public void setSchoolDemandId(Integer schoolDemandId)
	{
		this.schoolDemandId = schoolDemandId;
	}

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	public Integer getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
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

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
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

	public Integer getEstMember()
	{
		return estMember;
	}

	public void setEstMember(Integer estMember)
	{
		this.estMember = estMember;
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

	public String getOrgArchitecture()
	{
		return orgArchitecture;
	}

	public void setOrgArchitecture(String orgArchitecture)
	{
		this.orgArchitecture = orgArchitecture;
	}

	public String getProjFileName()
	{
		return projFileName;
	}

	public void setProjFileName(String projFileName)
	{
		this.projFileName = projFileName;
	}

	public byte[] getProjFile()
	{
		return projFile;
	}

	public void setProjFile(byte[] projFile)
	{
		this.projFile = projFile;
	}

	public Long getProjFileLength()
	{
		return projFileLength;
	}

	public void setProjFileLength(Long projFileLength)
	{
		this.projFileLength = projFileLength;
	}

	public Integer getReviews()
	{
		return reviews;
	}

	public void setReviews(Integer reviews)
	{
		this.reviews = reviews;
	}

	public String getReviewsContent()
	{
		return reviewsContent;
	}

	public void setReviewsContent(String reviewsContent)
	{
		this.reviewsContent = reviewsContent;
	}

	public Boolean getSchoolConfirm()
	{
		return schoolConfirm;
	}

	public void setSchoolConfirm(Boolean schoolConfirm)
	{
		this.schoolConfirm = schoolConfirm;
	}

	public Boolean getMemberConfirm()
	{
		return memberConfirm;
	}

	public String getBase64String()
	{
		return base64String;
	}

	public void setBase64String(String base64String)
	{
		this.base64String = base64String;
	}

	public void setMemberConfirm(Boolean memberConfirm)
	{
		this.memberConfirm = memberConfirm;
	}

	public MemberBean getMemberBean()
	{
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean)
	{
		this.memberBean = memberBean;
	}

	public List<ParticipatorBean> getParticipatorBeans()
	{
		return participatorBeans;
	}

	public void setParticipatorBeans(List<ParticipatorBean> participatorBeans)
	{
		this.participatorBeans = participatorBeans;
	}

	@Override
	public String toString()
	{
		return "FullProjBean [fullProjId=" + fullProjId + ", primaryProjId=" + primaryProjId + ", schoolDemandId=" + schoolDemandId + ", memberId=" + memberId + ", schoolId=" + schoolId + ", title=" + title + ", frontCoverName=" + frontCoverName
				+ ", frontCoverLength=" + frontCoverLength + ", projAbstract=" + projAbstract + ", content=" + content + ", location=" + location + ", activityStartTime=" + activityStartTime + ", activityEndTime=" + activityEndTime + ", estMember="
				+ estMember + ", budget=" + budget + ", createDate=" + createDate + ", projStatus=" + projStatus + ", orgArchitecture=" + orgArchitecture + ", projFileName=" + projFileName + ", projFileLength=" + projFileLength + ", reviews=" + reviews
				+ ", reviewsContent=" + reviewsContent + ", schoolConfirm=" + schoolConfirm + ", memberConfirm=" + memberConfirm + "]";
	}

}
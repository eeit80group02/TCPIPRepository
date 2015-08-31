package model;

import java.util.Arrays;

public class FullProjBean
{
	private int fullProjId;             		// 完整計畫 PK 流水
	private int primaryProjId;         			// 初步計畫 FK
	private int schoolDemandId;          		// 學校需求 FK *命名可能有問題
	private int memberId;                		// 發起人     FK
	private int schoolId;                		// 學校編號 FK
	private String name;             	 		// 完整計畫名稱
	private String frontCoverName;   	 		// 完整計畫封面 圖片檔名
	private byte[] frontCover;      	 		// 完整計畫封面 圖片
	private long frontCoverLength;   	 		// 完整計畫封面 圖片長度		
	private String projAbstract;     	 		// 完整計畫摘要(封面指到後的文字)
	private String content;          	 		// 完整計畫內容
	private String location;	     	 		// 活動地點
	private java.util.Date activityStartTime;   // 活動時間(起)	
	private java.util.Date activityEndTime;  	// 活動時間(訖)	
	private int estMember;           			// 預計招募人數 
	private int budget;             		    // 活動預算
	private java.util.Date createDate;			// 建立日期(完整計畫發布的日期)
	private String projStatus;       			// 計畫狀態(招募中;已失敗;已完成)	
	private String orgArchitecture;	 			// 成員架構(文字敘述)
	private String projFileName;          		// pdf檔名
	private byte[] projFile;	             // pdf
	private long projFileLength;          		// pdf檔案長度
	private int reviews;			 			// 評論
	private int missionBoardId;	     			// 任務板編號(相關任務協作)
	private String reviewsContent;   			// 評論內容
	private String schoolConfirm;               // 學校確認狀態(同意、預設null)	
	private String memberConfirm;               // 發起人確認狀態(同意、預設null)
	public int getFullProjId() {
		return fullProjId;
	}
	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}
	public int getPrimaryProjId() {
		return primaryProjId;
	}
	public void setPrimaryProjId(int primaryProjId) {
		this.primaryProjId = primaryProjId;
	}
	public int getSchoolDemandId() {
		return schoolDemandId;
	}
	public void setSchoolDemandId(int schoolDemandId) {
		this.schoolDemandId = schoolDemandId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrontCoverName() {
		return frontCoverName;
	}
	public void setFrontCoverName(String frontCoverName) {
		this.frontCoverName = frontCoverName;
	}
	public byte[] getFrontCover() {
		return frontCover;
	}
	public void setFrontCover(byte[] frontCover) {
		this.frontCover = frontCover;
	}
	public long getFrontCoverLength() {
		return frontCoverLength;
	}
	public void setFrontCoverLength(long frontCoverLength) {
		this.frontCoverLength = frontCoverLength;
	}
	public String getProjAbstract() {
		return projAbstract;
	}
	public void setProjAbstract(String projAbstract) {
		this.projAbstract = projAbstract;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public java.util.Date getActivityStartTime() {
		return activityStartTime;
	}
	public void setActivityStartTime(java.util.Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	public java.util.Date getActivityEndTime() {
		return activityEndTime;
	}
	public void setActivityEndTime(java.util.Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	public int getEstMember() {
		return estMember;
	}
	public void setEstMember(int estMember) {
		this.estMember = estMember;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public String getProjStatus() {
		return projStatus;
	}
	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}
	public String getOrgArchitecture() {
		return orgArchitecture;
	}
	public void setOrgArchitecture(String orgArchitecture) {
		this.orgArchitecture = orgArchitecture;
	}
	public String getProjFileName() {
		return projFileName;
	}
	public void setProjFileName(String projFileName) {
		this.projFileName = projFileName;
	}
	public byte[] getProjFile() {
		return projFile;
	}
	public void setProjFile(byte[] projFile) {
		this.projFile = projFile;
	}
	public long getProjFileLength() {
		return projFileLength;
	}
	public void setProjFileLength(long projFileLength) {
		this.projFileLength = projFileLength;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public int getMissionBoardId() {
		return missionBoardId;
	}
	public void setMissionBoardId(int missionBoardId) {
		this.missionBoardId = missionBoardId;
	}
	public String getReviewsContent() {
		return reviewsContent;
	}
	public void setReviewsContent(String reviewsContent) {
		this.reviewsContent = reviewsContent;
	}
	public String getSchoolConfirm() {
		return schoolConfirm;
	}
	public void setSchoolConfirm(String schoolConfirm) {
		this.schoolConfirm = schoolConfirm;
	}
	public String getMemberConfirm() {
		return memberConfirm;
	}
	public void setMemberConfirm(String memberConfirm) {
		this.memberConfirm = memberConfirm;
	}
	@Override
	public String toString() {
		return "FullProjBean [fullProjId=" + fullProjId + ", initProjId="
				+ primaryProjId + ", schoolDemandId=" + schoolDemandId
				+ ", memberId=" + memberId + ", schoolId=" + schoolId
				+ ", name=" + name + ", frontCoverName=" + frontCoverName
				+ ", frontCover=" + Arrays.toString(frontCover)
				+ ", frontCoverLength=" + frontCoverLength + ", projAbstract="
				+ projAbstract + ", content=" + content + ", location="
				+ location + ", activityStartTime=" + activityStartTime
				+ ", activityEndTime=" + activityEndTime + ", estMember="
				+ estMember + ", budget=" + budget + ", createDate="
				+ createDate + ", projStatus=" + projStatus
				+ ", orgArchitecture=" + orgArchitecture + ", projFileName="
				+ projFileName + ", projFileStorage="
				+ Arrays.toString(projFile) + ", projFileLength="
				+ projFileLength + ", reviews=" + reviews + ", missionBoardId="
				+ missionBoardId + ", reviewsContent=" + reviewsContent
				+ ", schoolConfirm=" + schoolConfirm + ", memberConfirm="
				+ memberConfirm + "]";
	}
	
}

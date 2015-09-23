package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class DonationBeanDuplicate implements Serializable {
	private int donationId; // 捐獻編號(流水號)(只要物品規格不同，視為兩筆) PK*
	private int schoolId; // 學校編號 FK
	// add
	private String schoolName; // 學校名稱
	private String donationStatus; // 捐獻是否完成*
	private String supplyName; // 物資名稱
	private int originalDemandNumber; // 原始輸入需求數量(數量)
	private String originalDemandUnit; // 原始輸入需求數量(單位)
	private int demandNumber; // 現在需求數量及單位(數量)
	// add
	private int donateAmount; // 捐獻數量

	private String size; // 尺寸規格(物品的大小>長*寬*高)
	private String demandContent; // 需求說明(為什麼需要這項物資)
	private String supplyStatus; // 物資狀態(全新/二手/不拘)
	
	private java.util.Date demandTime; // *募集提出需求時間(物品開始募集時間)(即刻上架)
	private java.util.Date expireTime; // *募集截止時間(物品結束募集時間)(當日0:00下架)
	private String imageName; // 圖片檔名*
	private byte[] imageFile; // 圖片(需要的物品的圖片)*
	private long imageLength; // 圖片長度*
	private String remark; // 備註(可以填寫額外的訊息)
	
	
	
	public DonationBeanDuplicate(int donationId, int schoolId,
			String schoolName, String donationStatus, String supplyName,
			int originalDemandNumber, String originalDemandUnit,
			int demandNumber, int donateAmount, String size,
			String demandContent, String supplyStatus, Date demandTime,
			Date expireTime, String imageName, byte[] imageFile,
			long imageLength, String remark) {
		super();
		this.donationId = donationId;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.donationStatus = donationStatus;
		this.supplyName = supplyName;
		this.originalDemandNumber = originalDemandNumber;
		this.originalDemandUnit = originalDemandUnit;
		this.demandNumber = demandNumber;
		this.donateAmount = donateAmount;
		this.size = size;
		this.demandContent = demandContent;
		this.supplyStatus = supplyStatus;
		this.demandTime = demandTime;
		this.expireTime = expireTime;
		this.imageName = imageName;
		this.imageFile = imageFile;
		this.imageLength = imageLength;
		this.remark = remark;
	}

	public DonationBeanDuplicate() {
		
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDonationStatus() {
		return donationStatus;
	}

	public void setDonationStatus(String donationStatus) {
		this.donationStatus = donationStatus;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public int getOriginalDemandNumber() {
		return originalDemandNumber;
	}

	public void setOriginalDemandNumber(int originalDemandNumber) {
		this.originalDemandNumber = originalDemandNumber;
	}

	public String getOriginalDemandUnit() {
		return originalDemandUnit;
	}

	public void setOriginalDemandUnit(String originalDemandUnit) {
		this.originalDemandUnit = originalDemandUnit;
	}

	public int getDemandNumber() {
		return demandNumber;
	}

	public void setDemandNumber(int demandNumber) {
		this.demandNumber = demandNumber;
	}

	public int getDonateAmount() {
		return donateAmount;
	}

	public void setDonateAmount(int donateAmount) {
		this.donateAmount = donateAmount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDemandContent() {
		return demandContent;
	}

	public void setDemandContent(String demandContent) {
		this.demandContent = demandContent;
	}

	public String getSupplyStatus() {
		return supplyStatus;
	}

	public void setSupplyStatus(String supplyStatus) {
		this.supplyStatus = supplyStatus;
	}

	public java.util.Date getDemandTime() {
		return demandTime;
	}

	public void setDemandTime(java.util.Date demandTime) {
		this.demandTime = demandTime;
	}

	public java.util.Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}

	public long getImageLength() {
		return imageLength;
	}

	public void setImageLength(long imageLength) {
		this.imageLength = imageLength;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "DonationBeanDuplicate [donationId=" + donationId
				+ ", schoolId=" + schoolId + ", schoolName=" + schoolName
				+ ", donationStatus=" + donationStatus + ", supplyName="
				+ supplyName + ", originalDemandNumber=" + originalDemandNumber
				+ ", originalDemandUnit=" + originalDemandUnit
				+ ", demandNumber=" + demandNumber + ", donateAmount="
				+ donateAmount + ", size=" + size + ", demandContent="
				+ demandContent + ", supplyStatus=" + supplyStatus
				+ ", demandTime=" + demandTime + ", expireTime=" + expireTime
				+ ", imageName=" + imageName + ", imageFile="
				+ Arrays.toString(imageFile) + ", imageLength=" + imageLength
				+ ", remark=" + remark + "]";
	}
}

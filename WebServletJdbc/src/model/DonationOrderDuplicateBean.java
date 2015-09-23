package model;

import java.io.Serializable;

public class DonationOrderDuplicateBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer donationOrderId;			// 捐獻訂單 PK
	// new
	private Integer donationId;					
	private Integer donationAmount;				
	
	private Integer memberId; 					// 會員編號 FK
	private String name; 						// 寄件人姓名(由欲捐獻會員填寫)
	private String address; 					// 地址(由欲捐獻會員填寫)
	private String phone; 						// 電話(由欲捐獻會員填寫)
	private String cellPhone; 					// 手機(由欲捐獻會員填寫)
	private String email; 						// E-mail(由欲捐獻會員填寫)
	private java.util.Date pickTime;			// 收件時間(由欲捐獻會員填寫)
	private java.util.Date donationOederDate;	// 訂單建立時間
	private String dealId; 						// 交易編號(出貨單號)
	
	public DonationOrderDuplicateBean()
	{
	}

	public Integer getDonationOrderId() {
		return donationOrderId;
	}

	public void setDonationOrderId(Integer donationOrderId) {
		this.donationOrderId = donationOrderId;
	}

	public Integer getDonationId() {
		return donationId;
	}

	public void setDonationId(Integer donationId) {
		this.donationId = donationId;
	}

	public Integer getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Integer donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getPickTime() {
		return pickTime;
	}

	public void setPickTime(java.util.Date pickTime) {
		this.pickTime = pickTime;
	}

	public java.util.Date getDonationOederDate() {
		return donationOederDate;
	}

	public void setDonationOederDate(java.util.Date donationOederDate) {
		this.donationOederDate = donationOederDate;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DonationOrderDuplicateBean [donationOrderId=" + donationOrderId
				+ ", donationId=" + donationId + ", donationAmount="
				+ donationAmount + ", memberId=" + memberId + ", name=" + name
				+ ", address=" + address + ", phone=" + phone + ", cellPhone="
				+ cellPhone + ", email=" + email + ", pickTime=" + pickTime
				+ ", donationOederDate=" + donationOederDate + ", dealId="
				+ dealId + "]";
	}
}

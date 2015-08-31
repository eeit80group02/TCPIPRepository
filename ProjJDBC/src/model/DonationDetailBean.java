package model;

public class DonationDetailBean
{
	private int donationDetailId;	// 捐獻明細 PK
	private int donationId; 		// 捐獻編號 FK
	private int memberId; 			// 會員編號 FK
	private java.util.Date pickTime;// 收件時間(由欲捐獻會員填寫)
	private String name; 			// 寄件人姓名(由欲捐獻會員填寫)
	private String address; 		// 地址(由欲捐獻會員填寫)
	private String phone; 			// 電話(由欲捐獻會員填寫)
	private String cellPhone; 		// 手機(由欲捐獻會員填寫)
	private String email; 			// E-mail(由欲捐獻會員填寫)
	private int donationAmount; 	// 會員捐贈數量(數量)
	private String dealId; 			// 交易編號(出貨單號)

	public int getDonationDetailId()
	{
		return donationDetailId;
	}

	public void setDonationDetailId(int donationDetailId)
	{
		this.donationDetailId = donationDetailId;
	}

	public int getDonationId()
	{
		return donationId;
	}

	public void setDonationId(int donationId)
	{
		this.donationId = donationId;
	}

	public int getMemberId()
	{
		return memberId;
	}

	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}

	public java.util.Date getPickTime()
	{
		return pickTime;
	}

	public void setPickTime(java.util.Date pickTime)
	{
		this.pickTime = pickTime;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCellPhone()
	{
		return cellPhone;
	}

	public void setCellPhone(String cellPhone)
	{
		this.cellPhone = cellPhone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getDonationAmount()
	{
		return donationAmount;
	}

	public void setDonationAmount(int donationAmount)
	{
		this.donationAmount = donationAmount;
	}

	public String getDealId()
	{
		return dealId;
	}

	public void setDealId(String dealId)
	{
		this.dealId = dealId;
	}

	@Override
	public String toString()
	{
		return "DonationDetailBean [donationDetailId=" + donationDetailId + ", donationId=" + donationId + ", memberId=" + memberId + ", pickTime=" + pickTime + ", name=" + name + ", address=" + address + ", phone=" + phone + ", cellPhone=" + cellPhone
				+ ", email=" + email + ", donationAmount=" + donationAmount + ", dealId=" + dealId + "]";
	}

}

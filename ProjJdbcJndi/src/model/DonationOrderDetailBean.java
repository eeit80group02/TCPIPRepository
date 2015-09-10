package model;

import java.io.Serializable;

public class DonationOrderDetailBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer donationOrderDetailId;	// 捐獻明細(流水號)
	private Integer donationOederId;		// 捐獻訂單編號
	private Integer donationId;				// 捐獻編號
	private String supplyName;				// 捐獻物品名稱
	private Integer donationAmount;			// 會員捐贈數量(數量)
	
	public DonationOrderDetailBean()
	{
		
	}

	public Integer getDonationOrderDetailId()
	{
		return donationOrderDetailId;
	}

	public void setDonationOrderDetailId(Integer donationOrderDetailId)
	{
		this.donationOrderDetailId = donationOrderDetailId;
	}

	public Integer getDonationOederId()
	{
		return donationOederId;
	}

	public void setDonationOederId(Integer donationOederId)
	{
		this.donationOederId = donationOederId;
	}

	public Integer getDonationId()
	{
		return donationId;
	}

	public void setDonationId(Integer donationId)
	{
		this.donationId = donationId;
	}

	public String getSupplyName()
	{
		return supplyName;
	}

	public void setSupplyName(String supplyName)
	{
		this.supplyName = supplyName;
	}

	public Integer getDonationAmount()
	{
		return donationAmount;
	}

	public void setDonationAmount(Integer donationAmount)
	{
		this.donationAmount = donationAmount;
	}

	@Override
	public String toString()
	{
		return "DonationOrderDetailBean [donationOrderDetailId=" + donationOrderDetailId + ", donationOederId=" + donationOederId + ", donationId=" + donationId + ", supplyName=" + supplyName + ", donationAmount=" + donationAmount + "]";
	}
	
}

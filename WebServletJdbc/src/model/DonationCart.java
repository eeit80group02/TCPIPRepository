package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DonationCart {
	private Map<Integer,DonationBeanDuplicate> cart = new LinkedHashMap<>();
	
	public DonationCart() {
	}

	public Map<Integer,DonationBeanDuplicate> getContent() {
		return cart;
	}
	
	public void remove() {
		cart = null;
		cart = new LinkedHashMap<>();
	}
	
	// insert
	public boolean insertDonationToCart(DonationBeanDuplicate donationBeanDuplicate) {
		int donationId = donationBeanDuplicate.getDonationId();
		if (cart.get(donationId) == null) {
			cart.put(donationId, donationBeanDuplicate);
			return true;
		} else {
			return false;
		}
	}
	
	// update
	public boolean updateDonation(int donationId, DonationBeanDuplicate donationBeanDuplicate) {
		if (cart.get(donationId) != null) {
			cart.remove(donationId);
			cart.put(donationId, donationBeanDuplicate);
			return true;
		}
		return false;
	}
	// delete
	public boolean deleteDonation(int donationId) {
		if (cart.get(donationId) != null) {
			cart.remove(donationId);
			return true;
		}
		return false;
	}
	
	public boolean modifyQty(int donationId, int newQty) {
		if (cart.get(donationId) != null) {
			DonationBeanDuplicate donationBeanDuplicate = cart.get(donationId);
			// 判斷是否大於原始需求量
			if (donationBeanDuplicate.getDemandNumber() >= newQty) {
				donationBeanDuplicate.setDonateAmount(newQty);
				return true;
			}
		}
		return false;
	}
}

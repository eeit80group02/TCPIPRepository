package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DonationCart {
	private Map<Integer,DonationBeanDuplicate> cart;
	
	public DonationCart() {
		cart = new LinkedHashMap<>();
	}
	
	public List<String> getDonationIdList() {
		List<String> itemList = new ArrayList<>();
		Set<Integer> s = cart.keySet();
		for(Integer i : s) {
			itemList.add(i.toString());
		}
		return itemList;
	}
	
	public String getDonationIdString() {
		String idString = "";
		Set<Integer> s = cart.keySet();
		for(Integer i : s) {
			idString += i+"@";
		}
		return idString;
	}

	public Map<Integer,DonationBeanDuplicate> getContent() {
		return cart;
	}
	
	public boolean remove() {
		cart.clear();
		System.out.println("清除購物車所有品項");
		return true;
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
			System.out.println("remove donationId= "+donationId);
			cart.remove(donationId);
			
			Set<Integer> i = cart.keySet();
			for (Integer s : i) {
				System.out.println("in delete's cart= "+ s);
			}
			
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

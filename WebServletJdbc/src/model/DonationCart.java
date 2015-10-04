package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.dao.SchoolDAOJdbc;
import model.dao.interfaces.SchoolDAO;

public class DonationCart {
	private Map<Integer,DonationBeanDuplicate> cart;
	
	public DonationCart() {
		cart = new LinkedHashMap<>();
	}
	// 
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
			DonationBeanDuplicate d = cart.get(donationId);
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
			
//			Set<Integer> i = cart.keySet();
//			for (Integer s : i) {
//				System.out.println("in delete's cart= "+ s);
//			}
			
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
	
	// 帳單處理
	// MAP 轉 LIST
	public List<DonationBeanDuplicate> getList(){
		Set<Integer> sets = cart.keySet();
		List<DonationBeanDuplicate> list = new ArrayList<>();
		for(Integer i : sets) {
			DonationBeanDuplicate dbd = cart.get(i);
			list.add(dbd);
		}
		return list;
	}
	
	// 取得捐獻物(多)的schoolId(一)
	public Set<Integer> getSchoolIdSet(){
		Set<Integer> sets = new HashSet<>();
		List<DonationBeanDuplicate> list = this.getList();
		for(DonationBeanDuplicate d : list) {
			int schoolId = d.getSchoolId();
			sets.add(schoolId);
		}
		return sets;
	}
	// 取得多間學校各自的需求
	public List<DonationBillBean> getDonationOrderBySchool(){
		// 學校id
		Set<Integer> sets = this.getSchoolIdSet();
//		System.out.println("sets "+sets);
		// 購物車所有物品
		List<DonationBeanDuplicate> list = this.getList();
		// 找出學校資料
		SchoolDAO dao = new SchoolDAOJdbc();
		
		// 包裝Bean
		List<DonationBillBean> billList = new ArrayList<>();
		List<DonationBeanDuplicate> dbdList;
		DonationBillBean billBean;
		
		for(Integer i : sets) {
			dbdList = new ArrayList<>();
			
			SchoolBean sBean = dao.findByPrimaryKey(i);
			// 資料轉換
			if (sBean == null) {
				System.out.println("查無相關資料");
				return null;
			}
			
			billBean = new DonationBillBean();
			billBean.setSchoolId(sBean.getSchoolId());
			billBean.setName(sBean.getName());
			billBean.setPhone(sBean.getPhone());
			billBean.setAddressDistrict(sBean.getAddressDistrict());
			billBean.setAddressComplete(sBean.getAddressComplete());
			billBean.setUrl(sBean.getUrl());
			billBean.setAboutMe(sBean.getAboutMe());
			
			for(DonationBeanDuplicate d : list) {
				if(i == d.getSchoolId()) {
//					System.out.println("i= "+i+", d.getSchoolId= "+d.getSchoolId());
					// 單一學校的單一捐獻需求
					dbdList.add(d);
				}
			}
			// 單一學校資料與全部捐獻需求
			billBean.setDbdList(dbdList);
			// 所有學校資料與所有捐獻需求
			billList.add(billBean);
		}
		
//		for(DonationBillBean d : billList) {
//			System.out.println("schoolData = "+d);
//			List<DonationBeanDuplicate> items = d.getDbdList();
//			for(DonationBeanDuplicate ds : items){
//				System.out.println("oneOfAll = "+ds);
//			}
//		}
		
		return billList;
	}
	
	// 將購物車依照schoolId作為分類
	public Map<Integer, DonationBillBean> getContentOfMap(){
		 Map<Integer, DonationBillBean> map = new  LinkedHashMap<>();
		List<DonationBillBean> list = this.getDonationOrderBySchool();
		for(DonationBillBean d : list) {
			map.put(d.getSchoolId(), d);
		}
		return map;
	}
	// 傳回其中一間學校的捐獻資料
	public DonationBillBean getDonationOfOneSchool(int schoolId){
//		System.out.println("in@@schoolId="+schoolId);
		DonationBillBean dBean = null;
		
		List<DonationBillBean> list = this.getDonationOrderBySchool();
//		System.out.println("list = "+list);
		for(DonationBillBean d : list) {
//			System.out.println("99uuuu"+d.getSchoolId());
			if(d.getSchoolId() == schoolId) {
				dBean = d;
			}
		}
//		System.out.println("==================");
//		Map<Integer, DonationBillBean> map = this.getContentOfMap();
//		Set<Integer> sets = map.keySet();
//		System.out.println("schoolId11601 = "+schoolId);
//		dBean = map.get(schoolId);
//		for(Integer i : sets) {
//			System.out.println("I = "+i+", schoolId = "+schoolId);
//			if(i == schoolId) {
//				System.out.println("I = "+i+", schoolId = "+schoolId);
//				dBean = map.get(i);
//			}
//		}
//		System.out.println("***dBean = "+dBean);
		return dBean;
	}
	// 取得同間學校的需求
	public DonationBillBean getOneSchoolDeamnd(int schoolId){
		DonationCart cart = new DonationCart();
		Map<Integer, DonationBillBean> map = cart.getContentOfMap();
		DonationBillBean bill = map.get(schoolId);
		return bill;
	}
	
	// 結帳後刪除部分暫存 
	public boolean deleteDonationOfOneSchool(int schoolId){
		DonationBillBean bill = this.getDonationOfOneSchool(schoolId);
		List<DonationBeanDuplicate> list = bill.getDbdList();
		for(DonationBeanDuplicate d : list) {
			cart.remove(d.getDonationId());
		}
		//....
		return true;
	}
}


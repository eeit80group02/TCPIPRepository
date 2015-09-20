package model.service;

import java.util.ArrayList;
import java.util.List;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.SchoolBean;
import model.SchoolService;
import model.dao.DonationDAOJdbc;
import model.dao.SchoolDAOJdbc;
import model.dao.interfaces.DonationDAO;

public class DonationSearchService {
	
	public List<DonationBeanDuplicate> searchByStatus(String supplyStatus){
		DonationBeanDuplicate dbd;
		DonationDAO donationDAO = new DonationDAOJdbc();
		
		SchoolDAOJdbc schoolDAO;
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		List<DonationBean> odbList = donationDAO.getAll();
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否")) {
				if(supplyStatus.equals("1")) {
					dbd = new DonationBeanDuplicate();
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					
					// 依 SchoolId取出SchoolName
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					if (sBean != null) {
						// 存取SchoolName
						dbd.setSchoolName(sBean.getName());
					} else {
						System.out.println("系統錯誤");
						return null;
					}
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設會員的捐獻數量為1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandContent(odb.getDemandContent());
					dbd.setSupplyStatus(odb.getSupplyStatus());
					
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setImageName(odb.getImageName());
					dbd.setImageFile(odb.getImageFile());
					dbd.setImageLength(odb.getImageLength());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);//16->18
					
//					dbd = new DonationBeanDuplicate();
//					schoolDAO = new SchoolDAOJdbc();
//					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//					String schoolName = sBean.getName();
//	
//					dbd.setDonationId(odb.getDonationId());
//					dbd.setSchoolId(odb.getSchoolId());
//					// 設定 schoolName
//					dbd.setSchoolName(schoolName);
//					dbd.setDonationStatus(odb.getDonationStatus());
//					dbd.setSupplyName(odb.getSupplyName());
//					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//					dbd.setDemandNumber(odb.getDemandNumber());
//					// 預設為 1
//					dbd.setDonateAmount(1);
//					dbd.setSize(odb.getSize());
//					dbd.setDemandTime(odb.getDemandTime());
//					dbd.setExpireTime(odb.getExpireTime());
//					dbd.setRemark(odb.getRemark());
//					dbdList.add(dbd);
					
				} else if(supplyStatus.equals("2") && odb.getSupplyStatus().equals("全新")) {
					dbd = new DonationBeanDuplicate();
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					
					// 依 SchoolId取出SchoolName
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					if (sBean != null) {
						// 存取SchoolName
						dbd.setSchoolName(sBean.getName());
					} else {
						System.out.println("系統錯誤");
						return null;
					}
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設會員的捐獻數量為1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandContent(odb.getDemandContent());
					dbd.setSupplyStatus(odb.getSupplyStatus());
					
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setImageName(odb.getImageName());
					dbd.setImageFile(odb.getImageFile());
					dbd.setImageLength(odb.getImageLength());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);//16->18
					
//					dbd = new DonationBeanDuplicate();
//					schoolDAO = new SchoolDAOJdbc();
//					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//					String schoolName = sBean.getName();
//					
//					dbd.setDonationId(odb.getDonationId());
//					dbd.setSchoolId(odb.getSchoolId());
//					// 設定 schoolName
//					dbd.setSchoolName(schoolName);
//					dbd.setDonationStatus(odb.getDonationStatus());
//					dbd.setSupplyName(odb.getSupplyName());
//					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//					dbd.setDemandNumber(odb.getDemandNumber());
//					// 預設為 1
//					dbd.setDonateAmount(1);
//					dbd.setSize(odb.getSize());
//					dbd.setDemandTime(odb.getDemandTime());
//					dbd.setExpireTime(odb.getExpireTime());
//					dbd.setRemark(odb.getRemark());
//					dbdList.add(dbd);
					
				} else if(supplyStatus.equals("3") && odb.getSupplyStatus().equals("二手")) {
					dbd = new DonationBeanDuplicate();
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					
					// 依 SchoolId取出SchoolName
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					if (sBean != null) {
						// 存取SchoolName
						dbd.setSchoolName(sBean.getName());
					} else {
						System.out.println("系統錯誤");
						return null;
					}
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設會員的捐獻數量為1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandContent(odb.getDemandContent());
					dbd.setSupplyStatus(odb.getSupplyStatus());
					
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setImageName(odb.getImageName());
					dbd.setImageFile(odb.getImageFile());
					dbd.setImageLength(odb.getImageLength());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);//16->18
					
//					dbd = new DonationBeanDuplicate();
//					schoolDAO = new SchoolDAOJdbc();
//					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//					String schoolName = sBean.getName();
//					
//					dbd.setDonationId(odb.getDonationId());
//					dbd.setSchoolId(odb.getSchoolId());
//					// 設定 schoolName
//					dbd.setSchoolName(schoolName);
//					dbd.setDonationStatus(odb.getDonationStatus());
//					dbd.setSupplyName(odb.getSupplyName());
//					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//					dbd.setDemandNumber(odb.getDemandNumber());
//					// 預設為 1
//					dbd.setDonateAmount(1);
//					dbd.setSize(odb.getSize());
//					dbd.setDemandTime(odb.getDemandTime());
//					dbd.setExpireTime(odb.getExpireTime());
//					dbd.setRemark(odb.getRemark());
//					dbdList.add(dbd);
				}
			}
		}
		return dbdList;
	}
	public List<DonationBeanDuplicate> searchSchoolByStatus(String supplyStatus, int schoolId){
		DonationBeanDuplicate dbd;
		DonationDAO donationDAO = new DonationDAOJdbc();
		
		SchoolDAOJdbc schoolDAO;
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		List<DonationBean> odbList = donationDAO.getAll();
		for(DonationBean odb : odbList) {
			if (odb.getSchoolId() == schoolId) {
				if (odb.getDonationStatus().equals("否")) {
					if(supplyStatus.equals("1")) {
						dbd = new DonationBeanDuplicate();
						dbd.setDonationId(odb.getDonationId());
						dbd.setSchoolId(odb.getSchoolId());
						
						// 依 SchoolId取出SchoolName
						schoolDAO = new SchoolDAOJdbc();
						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
						if (sBean != null) {
							// 存取SchoolName
							dbd.setSchoolName(sBean.getName());
						} else {
							System.out.println("系統錯誤");
							return null;
						}
						dbd.setDonationStatus(odb.getDonationStatus());
						dbd.setSupplyName(odb.getSupplyName());
						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
						dbd.setDemandNumber(odb.getDemandNumber());
						// 預設會員的捐獻數量為1
						dbd.setDonateAmount(1);
						dbd.setSize(odb.getSize());
						dbd.setDemandContent(odb.getDemandContent());
						dbd.setSupplyStatus(odb.getSupplyStatus());
						
						dbd.setDemandTime(odb.getDemandTime());
						dbd.setExpireTime(odb.getExpireTime());
						dbd.setImageName(odb.getImageName());
						dbd.setImageFile(odb.getImageFile());
						dbd.setImageLength(odb.getImageLength());
						dbd.setRemark(odb.getRemark());
						dbdList.add(dbd);//16->18
						
//						dbd = new DonationBeanDuplicate();
//						schoolDAO = new SchoolDAOJdbc();
//						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//						String schoolName = sBean.getName();
//		
//						dbd.setDonationId(odb.getDonationId());
//						dbd.setSchoolId(odb.getSchoolId());
//						// 設定 schoolName
//						dbd.setSchoolName(schoolName);
//						dbd.setDonationStatus(odb.getDonationStatus());
//						dbd.setSupplyName(odb.getSupplyName());
//						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//						dbd.setDemandNumber(odb.getDemandNumber());
//						// 預設為 1
//						dbd.setDonateAmount(1);
//						dbd.setSize(odb.getSize());
//						dbd.setDemandTime(odb.getDemandTime());
//						dbd.setExpireTime(odb.getExpireTime());
//						dbd.setRemark(odb.getRemark());
//						dbdList.add(dbd);
						
					} else if(supplyStatus.equals("2") && odb.getSupplyStatus().equals("全新")) {
						dbd = new DonationBeanDuplicate();
						dbd.setDonationId(odb.getDonationId());
						dbd.setSchoolId(odb.getSchoolId());
						
						// 依 SchoolId取出SchoolName
						schoolDAO = new SchoolDAOJdbc();
						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
						if (sBean != null) {
							// 存取SchoolName
							dbd.setSchoolName(sBean.getName());
						} else {
							System.out.println("系統錯誤");
							return null;
						}
						dbd.setDonationStatus(odb.getDonationStatus());
						dbd.setSupplyName(odb.getSupplyName());
						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
						dbd.setDemandNumber(odb.getDemandNumber());
						// 預設會員的捐獻數量為1
						dbd.setDonateAmount(1);
						dbd.setSize(odb.getSize());
						dbd.setDemandContent(odb.getDemandContent());
						dbd.setSupplyStatus(odb.getSupplyStatus());
						
						dbd.setDemandTime(odb.getDemandTime());
						dbd.setExpireTime(odb.getExpireTime());
						dbd.setImageName(odb.getImageName());
						dbd.setImageFile(odb.getImageFile());
						dbd.setImageLength(odb.getImageLength());
						dbd.setRemark(odb.getRemark());
						dbdList.add(dbd);//16->18
						
//						dbd = new DonationBeanDuplicate();
//						schoolDAO = new SchoolDAOJdbc();
//						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//						String schoolName = sBean.getName();
//						
//						dbd.setDonationId(odb.getDonationId());
//						dbd.setSchoolId(odb.getSchoolId());
//						// 設定 schoolName
//						dbd.setSchoolName(schoolName);
//						dbd.setDonationStatus(odb.getDonationStatus());
//						dbd.setSupplyName(odb.getSupplyName());
//						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//						dbd.setDemandNumber(odb.getDemandNumber());
//						// 預設為 1
//						dbd.setDonateAmount(1);
//						dbd.setSize(odb.getSize());
//						dbd.setDemandTime(odb.getDemandTime());
//						dbd.setExpireTime(odb.getExpireTime());
//						dbd.setRemark(odb.getRemark());
//						dbdList.add(dbd);
						
					} else if(supplyStatus.equals("3") && odb.getSupplyStatus().equals("二手")) {
						dbd = new DonationBeanDuplicate();
						dbd.setDonationId(odb.getDonationId());
						dbd.setSchoolId(odb.getSchoolId());
						
						// 依 SchoolId取出SchoolName
						schoolDAO = new SchoolDAOJdbc();
						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
						if (sBean != null) {
							// 存取SchoolName
							dbd.setSchoolName(sBean.getName());
						} else {
							System.out.println("系統錯誤");
							return null;
						}
						dbd.setDonationStatus(odb.getDonationStatus());
						dbd.setSupplyName(odb.getSupplyName());
						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
						dbd.setDemandNumber(odb.getDemandNumber());
						// 預設會員的捐獻數量為1
						dbd.setDonateAmount(1);
						dbd.setSize(odb.getSize());
						dbd.setDemandContent(odb.getDemandContent());
						dbd.setSupplyStatus(odb.getSupplyStatus());
						
						dbd.setDemandTime(odb.getDemandTime());
						dbd.setExpireTime(odb.getExpireTime());
						dbd.setImageName(odb.getImageName());
						dbd.setImageFile(odb.getImageFile());
						dbd.setImageLength(odb.getImageLength());
						dbd.setRemark(odb.getRemark());
						dbdList.add(dbd);//16->18
						
//						dbd = new DonationBeanDuplicate();
//						schoolDAO = new SchoolDAOJdbc();
//						SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//						String schoolName = sBean.getName();
//						
//						dbd.setDonationId(odb.getDonationId());
//						dbd.setSchoolId(odb.getSchoolId());
//						// 設定 schoolName
//						dbd.setSchoolName(schoolName);
//						dbd.setDonationStatus(odb.getDonationStatus());
//						dbd.setSupplyName(odb.getSupplyName());
//						dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//						dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//						dbd.setDemandNumber(odb.getDemandNumber());
//						// 預設為 1
//						dbd.setDonateAmount(1);
//						dbd.setSize(odb.getSize());
//						dbd.setDemandTime(odb.getDemandTime());
//						dbd.setExpireTime(odb.getExpireTime());
//						dbd.setRemark(odb.getRemark());
//						dbdList.add(dbd);
					}
				}
			}
		}
		return dbdList;
	}
	
	public List<DonationBeanDuplicate> searchByOriginalDemandNumber(){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByODNumber();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否")) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
				
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
			}
		}
		return dbdList;
	}
	
	public List<DonationBeanDuplicate> searchSchoolByOriginalDemandNumber(int schoolId){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByODNumber();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
			}
//		for(DonationBean odb : odbList) {
//			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
//			}
		}
		return dbdList;
	}
	
	public List<DonationBeanDuplicate> searchByExpiretime(){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByExpiretime();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否")) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
			}
//		for(DonationBean odb : odbList) {
//			if (odb.getDonationStatus().equals("否")) {
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
//			}
		}
		return dbdList;
	}
	public List<DonationBeanDuplicate> searchSchoolByExpiretime(int schoolId){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByExpiretime();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
			}
//		for(DonationBean odb : odbList) {
//			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
//			}
		}
		return dbdList;
	}
	public List<DonationBeanDuplicate> searchByDemandtime(){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByDemandtime();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否")) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
			}
//		for(DonationBean odb : odbList) {
//			if (odb.getDonationStatus().equals("否")) {
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
//			}
		}
		return dbdList;
	}
	public List<DonationBeanDuplicate> searchSchoolByDemandtime(int schoolId){
		DonationBeanDuplicate dbd;
		DonationDAOJdbc donationDAO = new DonationDAOJdbc();
		List<DonationBean> odbList = donationDAO.getAllByDemandtime();
		
		List<DonationBeanDuplicate> dbdList = new ArrayList<>();
		SchoolDAOJdbc schoolDAO;
		for(DonationBean odb : odbList) {
			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
				dbd = new DonationBeanDuplicate();
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				
				// 依 SchoolId取出SchoolName
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				if (sBean != null) {
					// 存取SchoolName
					dbd.setSchoolName(sBean.getName());
				} else {
					System.out.println("系統錯誤");
					return null;
				}
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設會員的捐獻數量為1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandContent(odb.getDemandContent());
				dbd.setSupplyStatus(odb.getSupplyStatus());
				
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setImageName(odb.getImageName());
				dbd.setImageFile(odb.getImageFile());
				dbd.setImageLength(odb.getImageLength());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);//16->18
			}
//		for(DonationBean odb : odbList) {
//			if (odb.getDonationStatus().equals("否") && odb.getSchoolId() == schoolId) {
//				dbd = new DonationBeanDuplicate();
//				schoolDAO = new SchoolDAOJdbc();
//				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
//				String schoolName = sBean.getName();
//				
//				dbd.setDonationId(odb.getDonationId());
//				dbd.setSchoolId(odb.getSchoolId());
//				// 設定 schoolName
//				dbd.setSchoolName(schoolName);
//				dbd.setDonationStatus(odb.getDonationStatus());
//				dbd.setSupplyName(odb.getSupplyName());
//				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
//				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
//				dbd.setDemandNumber(odb.getDemandNumber());
//				// 預設為 1
//				dbd.setDonateAmount(1);
//				dbd.setSize(odb.getSize());
//				dbd.setDemandTime(odb.getDemandTime());
//				dbd.setExpireTime(odb.getExpireTime());
//				dbd.setRemark(odb.getRemark());
//				dbdList.add(dbd);
//			}
		}
		return dbdList;
	}
	
}

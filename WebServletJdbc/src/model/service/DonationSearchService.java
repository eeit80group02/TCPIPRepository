package model.service;

import java.util.ArrayList;
import java.util.List;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.SchoolBean;
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
				if(supplyStatus.equals("1") && odb.getSupplyStatus().equals("不拘")) {
					dbd = new DonationBeanDuplicate();
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					String schoolName = sBean.getName();
	
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					// 設定 schoolName
					dbd.setSchoolName(schoolName);
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設為 1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);
					
				} else if(supplyStatus.equals("2") && odb.getSupplyStatus().equals("全新")) {
					dbd = new DonationBeanDuplicate();
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					String schoolName = sBean.getName();
					
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					// 設定 schoolName
					dbd.setSchoolName(schoolName);
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設為 1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);
					
				} else if(supplyStatus.equals("3") && odb.getSupplyStatus().equals("二手")) {
					dbd = new DonationBeanDuplicate();
					schoolDAO = new SchoolDAOJdbc();
					SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
					String schoolName = sBean.getName();
					
					dbd.setDonationId(odb.getDonationId());
					dbd.setSchoolId(odb.getSchoolId());
					// 設定 schoolName
					dbd.setSchoolName(schoolName);
					dbd.setDonationStatus(odb.getDonationStatus());
					dbd.setSupplyName(odb.getSupplyName());
					dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
					dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
					dbd.setDemandNumber(odb.getDemandNumber());
					// 預設為 1
					dbd.setDonateAmount(1);
					dbd.setSize(odb.getSize());
					dbd.setDemandTime(odb.getDemandTime());
					dbd.setExpireTime(odb.getExpireTime());
					dbd.setRemark(odb.getRemark());
					dbdList.add(dbd);
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
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				String schoolName = sBean.getName();
				
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				// 設定 schoolName
				dbd.setSchoolName(schoolName);
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設為 1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);
			}
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
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				String schoolName = sBean.getName();
				
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				// 設定 schoolName
				dbd.setSchoolName(schoolName);
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設為 1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);
			}
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
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				String schoolName = sBean.getName();
				
				dbd.setDonationId(odb.getDonationId());
				dbd.setSchoolId(odb.getSchoolId());
				// 設定 schoolName
				dbd.setSchoolName(schoolName);
				dbd.setDonationStatus(odb.getDonationStatus());
				dbd.setSupplyName(odb.getSupplyName());
				dbd.setOriginalDemandNumber(odb.getOriginalDemandNumber());
				dbd.setOriginalDemandUnit(odb.getOriginalDemandUnit());
				dbd.setDemandNumber(odb.getDemandNumber());
				// 預設為 1
				dbd.setDonateAmount(1);
				dbd.setSize(odb.getSize());
				dbd.setDemandTime(odb.getDemandTime());
				dbd.setExpireTime(odb.getExpireTime());
				dbd.setRemark(odb.getRemark());
				dbdList.add(dbd);
			}
		}
		return dbdList;
	}
}

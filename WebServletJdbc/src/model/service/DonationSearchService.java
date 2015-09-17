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
			if(supplyStatus.equals("1") && odb.getSupplyStatus().equals("不拘")) {
				dbd = new DonationBeanDuplicate();
				schoolDAO = new SchoolDAOJdbc();
				SchoolBean sBean = schoolDAO.findByPrimaryKey(odb.getSchoolId());
				String schoolName = sBean.getName();
				System.out.println("schoolName "+schoolName);
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
				System.out.println("不拘");
				
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
				System.out.println("全新");
				
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
				System.out.println("二手");
				
			}
		}

		return dbdList;
	}
}

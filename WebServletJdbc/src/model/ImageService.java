package model;

import model.dao.DonationDAOJdbc;
import model.dao.MemberDAOJdbc;

public class ImageService {
	private MemberDAOJdbc memberDAO;
	DonationDAOJdbc donationDAO;
//	public ImageHolder findMemberImage(String account) {
//		ImageHolder result = null;
//		if (account != null) {
//			// select one
//			memberDAO = new MemberDAOJdbc();
//			result = memberDAO.select(account);
//		} else {
//			//...
//		}
//		return result;
//	} 
	
	public ImageHolder findDonationImage(int donationId, int schoolId) {
		ImageHolder result = new ImageHolder();
		DonationBean donationBean = new DonationBean();
			// select one
			donationDAO = new DonationDAOJdbc();
			donationBean = donationDAO.findByPrimaryKey(donationId, schoolId);
//			System.out.println(donationBean.getDonationId()+"@"+donationBean.getSchoolId());
			result.setContent(donationBean.getImageFile());
			result.setName(donationBean.getImageName());
			
		return result;
	} 
}

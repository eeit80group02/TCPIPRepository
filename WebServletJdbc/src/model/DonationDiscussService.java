package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;

import model.dao.DonationDiscussDAOJdbc;
import model.dao.MemberDAOJdbc;
import model.dao.interfaces.MemberDAO;
import model.service.MemberService;

public class DonationDiscussService {
	private DonationDiscussDAOJdbc donationDiscussDAOjdbc;
	
	public JSONArray saveMemberMessages(String textarea, int donationId, int memberId, int schoolId) {
		JSONArray jsonArray = null;
//		DonationDiscussBean result;
		
		donationDiscussDAOjdbc = new DonationDiscussDAOJdbc();
		DonationDiscussBean donationDiscussBean = new DonationDiscussBean();
		donationDiscussBean.setDonationId(donationId);
		donationDiscussBean.setMemberId(memberId);
		donationDiscussBean.setSchoolId(schoolId);
		donationDiscussBean.setMemberMessage(textarea);
		donationDiscussBean.setMemberMessageTime(new Date());
		// 新增會員留言
		donationDiscussBean = donationDiscussDAOjdbc.insert(donationDiscussBean);
		int pk = 0;
		if (donationDiscussBean != null) {
			// 取出PK鍵執行查詢
			pk = donationDiscussBean.getDonationDiscussId();
		}
		DonationDiscussBean discussBean = donationDiscussDAOjdbc.findByPrimaryKey(pk);
		jsonArray = new JSONArray();
		jsonArray.add(discussBean.getMemberId().toString());
		jsonArray.add(discussBean.getMemberMessage().toString());
		jsonArray.add(discussBean.getMemberMessageTime().toString());
		return jsonArray;
	}
	
	public boolean saveSchoolMessages(DonationDiscussBean schoolMessagesBean) {

		// 先取出會員留言的Bean
		donationDiscussDAOjdbc = new DonationDiscussDAOJdbc();
		DonationDiscussBean memberMessagesBean = donationDiscussDAOjdbc.findByPrimaryKey(schoolMessagesBean.getDonationDiscussId());
		
		// 放入學校留言及時間
		memberMessagesBean.setSchoolId(schoolMessagesBean.getSchoolId());
		memberMessagesBean.setSchoolMessage(schoolMessagesBean.getSchoolMessage());
		memberMessagesBean.setSchoolMessageTime(new Date());
		
		DonationDiscussBean endDiscussBean = donationDiscussDAOjdbc.update(memberMessagesBean);
		if (endDiscussBean != null) {
			return true;
		}
		return false;
	}
	
	public List<DonationDiscussBeanDuplicate> getOneDonationAllMessages(int donationId) {
		donationDiscussDAOjdbc = new DonationDiscussDAOJdbc();
		List<DonationDiscussBean> discussList = donationDiscussDAOjdbc.getAll();
		
		List<DonationDiscussBeanDuplicate> discussListDublicate = new ArrayList<>();
		DonationDiscussBeanDuplicate donationDiscussBeanDuplicate;
		
		// 取出留言與 donationId相同的留言包裝成list
		MemberDAO dao = new MemberDAOJdbc();
		List<MemberBean> memberList = dao.select();
		// 資料交換
		for (DonationDiscussBean d : discussList) {
			if (d.getDonationId() == donationId) {
				donationDiscussBeanDuplicate = new DonationDiscussBeanDuplicate();
				donationDiscussBeanDuplicate.setDonationDiscussId(d.getDonationDiscussId());
				donationDiscussBeanDuplicate.setDonationId(d.getDonationId());
				donationDiscussBeanDuplicate.setMemberId(d.getMemberId());
				// 封裝memberName資料
				for (MemberBean m : memberList) {
					if (m.getMemberId() == d.getMemberId()) {
						donationDiscussBeanDuplicate.setMemberName(m.getLastName()+m.getFirstName());
					}
				}
				donationDiscussBeanDuplicate.setMemberMessage(d.getMemberMessage());
				donationDiscussBeanDuplicate.setMemberMessageTime(d.getMemberMessageTime());
				donationDiscussBeanDuplicate.setSchoolId(d.getSchoolId());
				donationDiscussBeanDuplicate.setSchoolMessageTime(d.getSchoolMessageTime());
				donationDiscussBeanDuplicate.setSchoolMessage(d.getSchoolMessage());
				// 撈會員資料庫
				discussListDublicate.add(donationDiscussBeanDuplicate);
			}
		}
		return discussListDublicate;
	}
}

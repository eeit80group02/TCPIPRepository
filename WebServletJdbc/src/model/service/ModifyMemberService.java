package model.service;

import java.io.IOException;
import java.util.List;

import model.MemberBean;
import model.dao.MemberDAOJdbc;

public class ModifyMemberService {
	private MemberDAOJdbc dao;

	public ModifyMemberService(){
		this.dao = new MemberDAOJdbc();
	}
	
	//修改會員資料功能
	synchronized public int isModified(int memberId, String idNumber, String gender, int recommendCount, String account, String accountStatus, java.util.Date registerTime, byte[] password, String lastName, String firstName, String phone, String cellPhone,
			java.util.Date birthday, String email, String address, byte[] picture, String pictureName, long pictureLength) throws IOException {
		int result = 0;
		
		MemberBean bean = new MemberBean();
		bean.setMemberId(memberId);
		//假如密碼有修改
		if(password != null){
			bean.setPassword(password);
		}
		bean.setLastName(lastName);
		bean.setFirstName(firstName);
		bean.setPhone(phone);
		bean.setCellPhone(cellPhone);
		bean.setBirthday(birthday);
		bean.setEmail(email);
		bean.setAddress(address);
		bean.setIdNumber(idNumber);
		bean.setGender(gender);
		bean.setRecommendCount(recommendCount);
		bean.setAccount(account);
		bean.setAccountStatus(accountStatus);
		bean.setRegisterTime(registerTime);
		
		//假如圖片有修改
		if(picture != null){
			bean.setPicture(picture);
			bean.setPictureName(pictureName);
			bean.setPictureLength(pictureLength);
		}
		
		if(this.dao.update(bean) != null){
			result = 1;
		} else {
			System.out.println("ModifyMemberService新增資料不成功!");
		}
		
		return result;
	}
	

	public static void main(String[] args) {

	}
}

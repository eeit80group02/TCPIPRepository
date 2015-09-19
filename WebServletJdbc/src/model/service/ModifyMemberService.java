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
	synchronized public int isModified(byte[] password, String lastName, String firstName, String phone, String cellPhone,
			java.util.Date birthday, String email, String address, byte[] picture, String pictureName, long pictureLength) throws IOException {
		int result = 0;
		
		MemberBean bean = new MemberBean();
		bean.setPassword(password);
		bean.setLastName(lastName);
		bean.setFirstName(firstName);
		bean.setPhone(phone);
		bean.setCellPhone(cellPhone);
		bean.setBirthday(birthday);
		bean.setEmail(email);
		bean.setAddress(address);
		bean.setPicture(picture);
		bean.setPictureName(pictureName);
		bean.setPictureLength(pictureLength);
		
		if(this.dao.insert(bean) != null){
			result = 1;
		}
		
		return result;
	}
	

	public static void main(String[] args) {

	}
}

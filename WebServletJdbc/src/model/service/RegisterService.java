package model.service;

import java.io.IOException;
import java.util.List;

import model.MemberBean;
import model.dao.MemberDAOJdbc;

public class RegisterService {
	private MemberDAOJdbc dao;
	
	public RegisterService(){
		this.dao = new MemberDAOJdbc();
	}
	
	//檢查帳號和是否已經存在
	synchronized public boolean accountExists(String account) throws IOException {
		boolean exist = false; // 檢查id是否已經存在
		List<MemberBean> beans = this.dao.select();
		for(MemberBean bean: beans){
			if(bean.getAccount().trim().equals(account.trim())){
				exist = true;
			}
		}
		return exist;
	}
	
	//檢查信箱和是否已經存在	
	synchronized public boolean emailExists(String email) throws IOException {
		boolean exist = false; // 檢查id是否已經存在
		List<MemberBean> beans = this.dao.select();
		for(MemberBean bean: beans){
			if(bean.getEmail().trim().equals(email.trim())){
				exist = true;
			}
		}
		return exist;
	}
	
	//儲存會員資料進資料庫
	synchronized public int saveMember(String account, byte[] password, String lastName, 
			String firstName, String idNumber,String gender, String phone, String cellPhone,
			java.util.Date birthday, String email, java.sql.Timestamp registerTime, int recommendCount,String address,
			byte[] picture, String pictureName, long pictureLength, String accountStatus) throws IOException{
		
		int result = 0;
		MemberBean bean = new MemberBean();
		bean.setAccount(account);
		bean.setPassword(password);
		bean.setLastName(lastName);
		bean.setFirstName(firstName);
		bean.setGender(gender);
		bean.setPhone(phone);
		bean.setCellPhone(cellPhone);
		bean.setBirthday(birthday);
		bean.setEmail(email);
		bean.setRegisterTime(registerTime);
		bean.setAddress(address);
		bean.setPicture(picture);
		bean.setPictureName(pictureName);
		bean.setPictureLength(pictureLength);
		
		//一開始寫死的被推薦次數(DB內也會有預設值)
		bean.setRecommendCount(recommendCount);
		
		//一開始寫死的帳號狀態(DB內也會有預設值)
		bean.setAccountStatus(accountStatus);
		
		//暫時寫死的idNumber
		bean.setIdNumber(idNumber);
		
		if(this.dao.insert(bean) != null){
			result = 1;
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args){
		
	}
}

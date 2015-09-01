package model;

import java.util.Arrays;
import java.util.Date;

public class MemberBean 
{
	private int memberId;             			// 會員編號 PK
	private String lastName;             		// 姓氏
	private String firstName;            		// 名字
	private String idNumber;             		// 身分證字號
	private String phone;             			// 電話（手機電話二者選一）
	private String cellPhone;             		// 手機(手機電話二者選一)
	private java.util.Date birthday;            // 生日
	
	private String address;             		// 地址
	private String gender;             			// 性別
	private String email;             			// E-mail(要驗證)
	private String pitctureName;                // 照片檔名
	private byte[] pitcture;             		// 照片(大頭照)
	private long pitctureLength;                // 照片長度
	private java.util.Date registerTime;        // 註冊日期
	private int recommendCount;             	// 被推薦總次數(預設給0)
	private String account;             		// 帳號（英文字母'數字）（不允許底線跟英文句點）
	private byte[] password;             		// 密碼（英文字母'數字）（不允許底線跟英文句點）
	private String accountStatus;             	// 帳號狀態(啟用/停用/待認證)
	
	public MemberBean(){
		
	}
	
	public MemberBean(int memberId, String lastName, String firstName,
			String idNumber, String phone, String cellPhone, Date birthday,
			String address, String gender, String email, String pitctureName,
			byte[] pitcture, long pitctureLength, Date registerTime,
			int recommendCount, String account, byte[] password,
			String accountStatus) {
//		super();
		this.memberId = memberId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.idNumber = idNumber;
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.birthday = birthday;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.pitctureName = pitctureName;
		this.pitcture = pitcture;
		this.pitctureLength = pitctureLength;
		this.registerTime = registerTime;
		this.recommendCount = recommendCount;
		this.account = account;
		this.password = password;
		this.accountStatus = accountStatus;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPitctureName() {
		return pitctureName;
	}
	public void setPitctureName(String pitctureName) {
		this.pitctureName = pitctureName;
	}
	public byte[] getPitcture() {
		return pitcture;
	}
	public void setPitcture(byte[] pitcture) {
		this.pitcture = pitcture;
	}
	public long getPitctureLength() {
		return pitctureLength;
	}
	public void setPitctureLength(long pitctureLength) {
		this.pitctureLength = pitctureLength;
	}
	public java.util.Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}
	public int getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", idNumber=" + idNumber
				+ ", phone=" + phone + ", cellPhone=" + cellPhone
				+ ", birthday=" + birthday + ", address=" + address
				+ ", gender=" + gender + ", email=" + email + ", pitctureName="
				+ pitctureName + ", pitcture=" + Arrays.toString(pitcture)
				+ ", pitctureLength=" + pitctureLength + ", registerTime="
				+ registerTime + ", recommendCount=" + recommendCount
				+ ", account=" + account + ", password="
				+ Arrays.toString(password) + ", accountStatus="
				+ accountStatus + "]";
	}
}

	
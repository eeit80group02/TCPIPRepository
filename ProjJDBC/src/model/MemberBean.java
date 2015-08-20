package model;

public class MemberBean 
{
	private int memberId;             //  會員編號 PK
	private String lastName;             //  *姓氏
	private String firstName;             //  *名字
	private String idNumber;             //  *身分證字號
	private String phone;             //  *電話（手機電話二者選一）
	private String cellPhone;             //  手機(手機電話二者選一)
	private java.util.Date birthday;             //  *生日
	private String address;             //  *地址
	private String gender;             //  性別
	private String email;             //  E-mail(要驗證)
	private byte[] pitcture;             //  照片(大頭照)
	private java.util.Date registerTime;             //  註冊日期
	private int RecommendCount;             //  *被推薦總次數(預設給0)
	private String account;             //  帳號（英文字母'數字）（不允許底線跟英文句點）
	private byte[] password;             //  密碼（英文字母'數字）（不允許底線跟英文句點）
	private String accountStatus;             //  帳號狀態(啟用/停用/待認證)

}

	
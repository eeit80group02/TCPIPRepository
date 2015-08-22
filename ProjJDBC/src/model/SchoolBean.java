package model;

public class SchoolBean
{
	private int schoolId;				// 學校編號(教育部學校代碼)(帳號) PK
	private String name;				// 學校名稱#
	private String phone;				// 學校行政電話總機#
	private String addressDistrict;		// 學校地址(縣市)
	private String addressComplete;		// 學校地址(完整)	
	private String url;					// 學校網址#
	private String frontCoverName;		// 學校圖片 檔名
	private Byte[] frontCover;			// 學校圖片#(封面)(817px*358px)
	private long frontCoverLength;		// 學校圖片 檔名長度
	private String aboutMe;				// 關於我
	private String managerEmail;		// 開通帳號的聯絡人E-mail 
	private String projectManager;		// 開通帳號的聯絡人姓名
	private String accountContact;		// 開通帳號的聯絡人電話(留學校完整電話+分機)
	private Byte[] password;			// 密碼(英文+數字(不分大小寫)不給特殊字元)	
	private String accountStatus;		// 帳號狀態(已啟用/待認證/預設)(前台只顯示預設；待認證及已啟用者不顯示)	

}

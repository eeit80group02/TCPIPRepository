package model;

import java.io.Serializable;
import java.util.Arrays;

public class SchoolBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer schoolId;			// 學校編號(教育部學校代碼)(帳號) PK
	private String name;				// 學校名稱#
	private String phone;				// 學校行政電話總機#
	private String addressDistrict; 	// 學校地址(縣市)
	private String addressComplete;	 	// 學校地址(完整)
	private String url; 				// 學校網址#
	private String frontCoverName; 		// 學校圖片 檔名
	private byte[] frontCover; 			// 學校圖片#(封面)(817px*358px)
	private Long frontCoverLength; 		// 學校圖片 檔名長度
	private String aboutMe; 			// 關於我
	private String managerEmail; 		// 開通帳號的聯絡人E-mail
	private String projectManager; 		// 開通帳號的聯絡人姓名
	private String accountContact; 		// 開通帳號的聯絡人電話(留學校完整電話+分機)
	private byte[] password; 			// 密碼(英文+數字(不分大小寫)不給特殊字元)
	private String accountStatus; 		// 帳號狀態(已啟用/待認證/預設)(前台只顯示預設；待認證及已啟用者不顯示)
	
	public Integer getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAddressDistrict()
	{
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict)
	{
		this.addressDistrict = addressDistrict;
	}

	public String getAddressComplete()
	{
		return addressComplete;
	}

	public void setAddressComplete(String addressComplete)
	{
		this.addressComplete = addressComplete;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getFrontCoverName()
	{
		return frontCoverName;
	}

	public void setFrontCoverName(String frontCoverName)
	{
		this.frontCoverName = frontCoverName;
	}

	public byte[] getFrontCover()
	{
		return frontCover;
	}

	public void setFrontCover(byte[] frontCover)
	{
		this.frontCover = frontCover;
	}

	public Long getFrontCoverLength()
	{
		return frontCoverLength;
	}

	public void setFrontCoverLength(Long frontCoverLength)
	{
		this.frontCoverLength = frontCoverLength;
	}

	public String getAboutMe()
	{
		return aboutMe;
	}

	public void setAboutMe(String aboutMe)
	{
		this.aboutMe = aboutMe;
	}

	public String getManagerEmail()
	{
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail)
	{
		this.managerEmail = managerEmail;
	}

	public String getProjectManager()
	{
		return projectManager;
	}

	public void setProjectManager(String projectManager)
	{
		this.projectManager = projectManager;
	}

	public String getAccountContact()
	{
		return accountContact;
	}

	public void setAccountContact(String accountContact)
	{
		this.accountContact = accountContact;
	}

	public byte[] getPassword()
	{
		return password;
	}

	public void setPassword(byte[] password)
	{
		this.password = password;
	}

	public String getAccountStatus()
	{
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}

	public String getBeanName()
	{
		return "school";
	}
	
	@Override
	public String toString()
	{
		return "SchoolBean [schoolId=" + schoolId + ", name=" + name + ", phone=" + phone + ", addressDistrict=" + addressDistrict + ", addressComplete=" + addressComplete + ", url=" + url + ", frontCoverName=" + frontCoverName + ", frontCoverLength="
				+ frontCoverLength + ", aboutMe=" + aboutMe + ", managerEmail=" + managerEmail + ", projectManager=" + projectManager + ", accountContact=" + accountContact + ", password=" + Arrays.toString(password) + ", accountStatus=" + accountStatus
				+ "]";
	}
}

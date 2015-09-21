package model.service;

import java.io.IOException;
import java.sql.Types;

import model.MemberBean;
import model.SchoolBean;
import model.dao.SchoolDAOJdbc;

public class ModifySchoolService {
	private SchoolDAOJdbc dao;

	public ModifySchoolService() {
		this.dao = new SchoolDAOJdbc();
	}

	// 修改學校資料功能
	synchronized public int isModified(String name, String phone, String addressDistrict, String addressComplete,
			String url, String frontCoverName, byte[] frontCover, long frontCoverLength, String aboutMe,
			String managerEmail, String projectManager, String accountContact, byte[] password, String accountStatus,
			int schoolId) throws IOException {
		int result = 0;

		SchoolBean bean = new SchoolBean();

		bean.setPassword(password);
		bean.setName(name);
		bean.setPhone(phone);
		bean.setAddressDistrict(addressDistrict);
		bean.setAddressComplete(addressComplete);
		bean.setUrl(url);

		bean.setAboutMe(aboutMe);
		bean.setManagerEmail(managerEmail);
		bean.setProjectManager(projectManager);
		bean.setAccountContact(accountContact);
		bean.setAccountStatus(accountStatus);
		bean.setSchoolId(schoolId);

		// 假如圖片有修改
		if (frontCover != null && frontCoverName!= null) {
			bean.setFrontCover(frontCover);
			bean.setFrontCoverName(frontCoverName);
			bean.setFrontCoverLength(frontCoverLength);
		} else {
			bean.setFrontCover(frontCover);
			bean.setFrontCoverName(frontCoverName);
			bean.setFrontCoverLength(frontCoverLength);
		}

		if (this.dao.update(bean) != null) {
			result = 1;
		} else {
			System.out.println("ModifyMemberService新增資料不成功!");
		}

		return result;
	}

	public static void main(String[] args) {

	}
}

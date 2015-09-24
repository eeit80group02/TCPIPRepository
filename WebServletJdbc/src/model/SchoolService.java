package model;

import java.util.List;

import model.dao.SchoolDAOJdbc;
import model.dao.interfaces.SchoolDAO;

public class SchoolService {
	private SchoolDAO dao = new SchoolDAOJdbc();
	public SchoolBean getSchoolData(int schoolId){
		SchoolBean schoolBean;
		schoolBean = dao.findByPrimaryKey(schoolId);
		if (schoolBean != null) {
			return schoolBean;
		}
		return null;
	}
	public int getSchoolIdByName(String schoolName) {
		System.out.println("@schoolName "+schoolName);
		List<SchoolBean> list = dao.getAll();
		int schoolId = 0;
		for(SchoolBean s : list) {
			if(s.getName().equals(schoolName)) {
				schoolId = s.getSchoolId();
				System.out.println("*@@schoolId "+schoolId);
			}
		}
		return schoolId;
	}
}

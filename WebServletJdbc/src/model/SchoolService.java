package model;

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
}

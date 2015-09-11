package model.dao.interfaces;

import java.util.List;

import model.GradeStudentBean;

public interface GradeStudentDAO
{

	public List<GradeStudentBean> getAll();

	public GradeStudentBean findByPrimaryKey(int schoolId,int anniversary);

	public GradeStudentBean insert(GradeStudentBean bean);

	public GradeStudentBean update(GradeStudentBean bean);

	public boolean delete(int schoolId,int anniversary);

}
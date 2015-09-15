package model.service;

import java.util.Arrays;

import model.MemberBean;
import model.SchoolBean;
import model.dao.MemberDAOJdbc;
import model.dao.SchoolDAOJdbc;
import model.dao.interfaces.MemberDAO;
import model.dao.interfaces.SchoolDAO;

public class LoginService
{
	private MemberDAO memberDAO;
	private SchoolDAO schoolDAO;
	
	public LoginService()
	{
		memberDAO = new MemberDAOJdbc();
		schoolDAO = new SchoolDAOJdbc();
	}
	
	public MemberBean memberLogin(String account,String password)
	{
		// 檢查是否 未輸入
		if(account != null && account.trim().length() != 0 && password != null && password.trim().length() != 0)
		{
			MemberBean bean = memberDAO.selectAccount(account);
			if(bean != null)
			{
				byte[] pwd = bean.getPassword();
				if(Arrays.equals(pwd,password.getBytes()))
				{
					return bean;
				}
			}
		}
		return null;
	}
	
	public SchoolBean schoolLogin(int schoolId,String password)
	{
		// 檢查是否 未輸入
		if(schoolId > 0 && password != null && password.trim().length() != 0)
		{
			SchoolBean bean = schoolDAO.findByPrimaryKey(schoolId);
			if(bean != null)
			{
				
				byte[] pwd = bean.getPassword();
				if(Arrays.equals(pwd,password.getBytes()))
				{
					return bean;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		LoginService service = new LoginService();
//		System.out.println(service.memberLogin("eeit8038","eeit8038"));
		System.out.println(service.schoolLogin(11503,"passwords"));
	}
}

package model.service;

import model.MemberBean;
import model.dao.MemberDAOJdbc;
import model.dao.interfaces.MemberDAO;

public class MemberService
{
	private MemberDAO memberDAO = null;
	
	public MemberService()
	{
		memberDAO = new MemberDAOJdbc();
	}
	
	public MemberBean checkEmail(String email)
	{
		MemberBean result = null;
		
		if(email != null && email.trim().length() != 0)
		{
			result = memberDAO.selectEmail(email);
		}
		return result;
	}
	
	public MemberBean checkAccount(String Account)
	{
		MemberBean result = null;
		
		if(Account != null && Account.trim().length() != 0)
		{
			result = memberDAO.selectAccount(Account);
		}
		return result;
	}
	
	public MemberBean checkIdNumber(String IdNumber)
	{
		MemberBean result = null;
		
		if(IdNumber != null && IdNumber.trim().length() != 0)
		{
			result = memberDAO.selectIdNumber(IdNumber);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		MemberService service = new MemberService();
		System.out.println(service.checkEmail("eeit8025@org.com"));
		System.out.println(service.checkAccount("eeit8028"));
		System.out.println(service.checkIdNumber("G121900927"));
	}
}

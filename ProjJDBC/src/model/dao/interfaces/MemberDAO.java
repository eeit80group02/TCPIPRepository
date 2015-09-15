package model.dao.interfaces;

import java.util.List;

import model.MemberBean;

public interface MemberDAO
{

	public MemberBean insert(MemberBean bean);

	public MemberBean update(MemberBean bean);

	public boolean delete(int id);

	public MemberBean select(int id);

	public List<MemberBean> select();

	public MemberBean selectAccount(String account);

	public MemberBean selectEmail(String Email);

	public MemberBean selectIdNumber(String idNumber);

}
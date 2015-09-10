package model.dao;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MemberBean;

public class MemberDAOJdbc
{
	private static final String SELECT_BY_PK = "SELECT memberId,lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus,identityCode FROM Member WHERE memberId = ?";
	private static final String SELECT_ALL = "SELECT memberId,lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus,identityCode FROM Member";
	private static final String INSERT = "INSERT INTO Member (lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE Member set lastName = ?,firstName = ?,idNumber = ?,phone = ?,cellPhone = ?,birthday = ?,address = ?,gender = ?,email = ?,pictureName=?, picture = ?,pictureLength = ?,registerTime=?, recommendCount = ?,account = ?,password = ?,accountStatus = ? WHERE memberId = ?";
	private static final String DELETE = "DELETE FROM Member WHERE memberId = ?";

	private DataSource datasource;

	public MemberDAOJdbc()
	{
		try
		{
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup(GlobalService.JNDI);
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public MemberBean insert(MemberBean bean)
	{
		MemberBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setString(1,bean.getLastName());
				pstmt.setString(2,bean.getFirstName());
				pstmt.setString(3,bean.getIdNumber());
				if(bean.getPhone() != null)
				{
					pstmt.setString(4,bean.getPhone());
				}
				else
				{
					pstmt.setNull(4,Types.NVARCHAR);
				}

				if(bean.getCellPhone() != null)
				{
					pstmt.setString(5,bean.getCellPhone());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}

				pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getBirthday().getTime()));
				pstmt.setString(7,bean.getAddress());
				pstmt.setString(8,bean.getGender());
				pstmt.setString(9,bean.getEmail());
				pstmt.setString(10,bean.getPictureName());
				pstmt.setBytes(11,bean.getPicture());
				pstmt.setLong(12,bean.getPictureLength());
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getRegisterTime().getTime()));
				pstmt.setInt(14,bean.getRecommendCount());
				pstmt.setString(15,bean.getAccount());
				pstmt.setBytes(16,bean.getPassword());
				pstmt.setString(17,bean.getAccountStatus());

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = select(key.getInt(1));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public MemberBean update(MemberBean bean)
	{
		MemberBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setString(1,bean.getLastName());
				pstmt.setString(2,bean.getFirstName());
				pstmt.setString(3,bean.getIdNumber());
				
				if(bean.getPhone() != null)
				{
					pstmt.setString(4,bean.getPhone());
				}
				else
				{
					pstmt.setNull(4,Types.NVARCHAR);
				}

				if(bean.getCellPhone() != null)
				{
					pstmt.setString(5,bean.getCellPhone());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}
				
				pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getBirthday().getTime()));
				pstmt.setString(7,bean.getAddress());
				pstmt.setString(8,bean.getGender());
				pstmt.setString(9,bean.getEmail());
				pstmt.setString(10,bean.getPictureName());
				pstmt.setBytes(11,bean.getPicture());
				pstmt.setLong(12,bean.getPictureLength());
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getRegisterTime().getTime()));
				pstmt.setInt(14,bean.getRecommendCount());
				pstmt.setString(15,bean.getAccount());
				pstmt.setBytes(16,bean.getPassword());
				pstmt.setString(17,bean.getAccountStatus());
				pstmt.setInt(18,bean.getMemberId());

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = select(bean.getMemberId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(int id)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,id);
			int num = pstmt.executeUpdate();
			if(num == 1)
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}

	public MemberBean select(int id)
	{
		MemberBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					result = new MemberBean();

					result.setMemberId(rs.getInt("memberId"));
					result.setLastName(rs.getString("LastName"));
					result.setFirstName(rs.getString("FirstName"));
					result.setIdNumber(rs.getString("IdNumber"));
					result.setPhone(rs.getString("Phone"));
					result.setCellPhone(rs.getString("CellPhone"));
					result.setBirthday(rs.getDate("Birthday"));
					result.setAddress(rs.getString("Address"));
					result.setGender(rs.getString("Gender"));
					result.setEmail(rs.getString("Email"));
					result.setPictureName(rs.getString("PictureName"));
					result.setPicture(rs.getBytes("Picture"));
					result.setPictureLength(rs.getLong("PictureLength"));
					result.setRegisterTime(rs.getDate("RegisterTime"));
					result.setRecommendCount(rs.getInt("RecommendCount"));
					result.setAccount(rs.getString("Account"));
					result.setPassword(rs.getBytes("Password"));
					result.setAccountStatus(rs.getString("AccountStatus"));
					result.setIdentityCode(rs.getString("identityCode"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	public List<MemberBean> select()
	{
		List<MemberBean> result = new ArrayList<MemberBean>();
		MemberBean bean = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new MemberBean();

				bean.setMemberId(rs.getInt("memberId"));
				bean.setLastName(rs.getString("LastName"));
				bean.setFirstName(rs.getString("FirstName"));
				bean.setIdNumber(rs.getString("IdNumber"));
				bean.setPhone(rs.getString("Phone"));
				bean.setCellPhone(rs.getString("CellPhone"));
				bean.setBirthday(rs.getDate("Birthday"));
				bean.setAddress(rs.getString("Address"));
				bean.setGender(rs.getString("Gender"));
				bean.setEmail(rs.getString("Email"));
				bean.setPictureName(rs.getString("PictureName"));
				bean.setPicture(rs.getBytes("Picture"));
				bean.setPictureLength(rs.getLong("PictureLength"));
				bean.setRegisterTime(rs.getDate("RegisterTime"));
				bean.setRecommendCount(rs.getInt("RecommendCount"));
				bean.setAccount(rs.getString("Account"));
				bean.setPassword(rs.getBytes("Password"));
				bean.setAccountStatus(rs.getString("AccountStatus"));
				bean.setIdentityCode(rs.getString("identityCode"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws Exception
	{
		// insert
		MemberDAOJdbc dao = new MemberDAOJdbc();
		
		MemberBean bean1 = new MemberBean();
//		bean1.setMemberId(null);
		bean1.setLastName("鋼鐵808080");
		bean1.setFirstName("人");
		bean1.setIdNumber("F55667788");
		bean1.setPhone("66316666");
		bean1.setCellPhone(null);
		bean1.setBirthday(new SimpleDateFormat("yyyy/MM/dd").parse("1985/08/08"));
		bean1.setAddress("台北市大安區復興南路一段390號2樓");
		bean1.setGender("男");
		bean1.setEmail("eeit80@orz.tw");
		
		File file = new File("image/member/member01.jpg"); 
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean1.setPictureName(file.getName());
			bean1.setPicture(GlobalService.convertInputStreamToByteArray(fis));
			bean1.setPictureLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		bean1.setRegisterTime(new java.util.Date(System.currentTimeMillis()));
		bean1.setRecommendCount(0);
		bean1.setAccount("eeit8080");
		bean1.setPassword("eeit8080".getBytes());
		bean1.setAccountStatus("啟用");
		bean1 = dao.insert(bean1);
		System.out.println(bean1);
		
		System.out.println("----------------------------------------------");

		// update
		MemberBean bean2 = new MemberBean();
		bean2.setMemberId(2);
		bean2.setLastName("鋼鐵878787");
		bean2.setFirstName("人");
		bean2.setIdNumber("F55667788");
		bean2.setPhone("66316666");
		bean2.setCellPhone("66661366");
		bean2.setBirthday(new SimpleDateFormat("yyyy/MM/dd").parse("1985/02/08"));
		bean2.setAddress("台北市大安區復興南路一段390號2樓");
		bean2.setGender("男");
		bean2.setEmail("eeit80@orz.tw");
		
		file = new File("image/member/member02.jpg"); 
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean2.setPictureName(file.getName());
			bean2.setPicture(GlobalService.convertInputStreamToByteArray(fis));
			bean2.setPictureLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		bean2.setRegisterTime(new java.util.Date(System.currentTimeMillis()));
		bean2.setRecommendCount(0);
		bean2.setAccount("eeit8080");
		bean2.setPassword("eeit8080".getBytes());
		bean2.setAccountStatus("停用");
		bean2 = dao.update(bean2);
		System.out.println(bean2);
		
		System.out.println("----------------------------------------------");

		// delete
		boolean count = dao.delete(1);
		System.out.println(count);
		System.out.println("----------------------------------------------");

		// select_pk
		MemberBean bean4 = new MemberBean();
		bean4 = dao.select(2);
		System.out.println(bean4);
		System.out.println("----------------------------------------------");

		// select_all
		List<MemberBean> list = dao.select();
		System.out.println(list);
	}
}

package model.dao;

import global.GlobalService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.MemberBean;

public class MemberDAOJdbc
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	// JNDI
//	private DataSource dataSource;
//	public MemberDAOJdbc()
//	{
//		try
//		{
//			Context ctx = new InitialContext();
//			this.dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/TCPIPServer");
//		}
//		catch(NamingException e)
//		{
//			e.printStackTrace();
//		}
//	}

	private static final String SELECT_BY_PK = "SELECT memberId,lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus FROM Member WHERE memberId = ?";
	private static final String SELECT_ALL = "SELECT memberId,lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus FROM Member";
	private static final String INSERT = "INSERT INTO Member (lastName,firstName,idNumber,phone,cellPhone,birthday,address,gender,email,pictureName,picture,pictureLength,registerTime,recommendCount,account,password,accountStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE Member set lastName = ?,firstName = ?,idNumber = ?,phone = ?,cellPhone = ?,birthday = ?,address = ?,gender = ?,email = ?,pictureName=?, picture = ?,pictureLength = ?,registerTime=?, recommendCount = ?,account = ?,password = ?,accountStatus = ? WHERE memberId = ?";
	private static final String DELETE = "DELETE FROM Member WHERE memberId = ?";

	public MemberBean insert(MemberBean bean)
	{
		MemberBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				if(bean.getLastName() != null)
				{
					pstmt.setString(1,bean.getLastName());
				}
				else
				{
					pstmt.setNull(1,Types.NVARCHAR);
				}

				if(bean.getFirstName() != null)
				{
					pstmt.setString(2,bean.getFirstName());
				}
				else
				{
					pstmt.setNull(2,Types.NVARCHAR);
				}

				if(bean.getIdNumber() != null)
				{
					pstmt.setString(3,bean.getIdNumber());
				}
				else
				{
					pstmt.setNull(3,Types.NVARCHAR);
				}

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

				if(bean.getBirthday() != null)
				{
					pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getBirthday().getTime()));
				}
				else
				{
					pstmt.setNull(6,Types.TIMESTAMP);
				}

				if(bean.getAddress() != null)
				{
					pstmt.setString(7,bean.getAddress());
				}
				else
				{
					pstmt.setNull(7,Types.NVARCHAR);
				}

				if(bean.getGender() != null)
				{
					pstmt.setString(8,bean.getGender());
				}
				else
				{
					pstmt.setNull(8,Types.NVARCHAR);
				}

				if(bean.getEmail() != null)
				{
					pstmt.setString(9,bean.getEmail());
				}
				else
				{
					pstmt.setNull(9,Types.NVARCHAR);
				}

				if(bean.getPictureName() != null)
				{
					pstmt.setString(10,bean.getPictureName());
				}
				else
				{
					pstmt.setNull(10,Types.NVARCHAR);
				}

				if(bean.getPicture() != null)
				{
					pstmt.setBytes(11,bean.getPicture());
				}
				else
				{
					pstmt.setNull(11,Types.VARBINARY);
				}

				if(bean.getPictureLength() != null)
				{
					pstmt.setLong(12,bean.getPictureLength());
				}
				else
				{
					pstmt.setNull(12,Types.BIGINT);
				}

				if(bean.getRegisterTime() != null)
				{
					pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getRegisterTime().getTime()));
				}
				else
				{
					pstmt.setNull(13,Types.TIMESTAMP);
				}

				if(bean.getRecommendCount() != null)
				{
					pstmt.setInt(14,bean.getRecommendCount());
				}
				else
				{
					pstmt.setNull(14,Types.INTEGER);
				}

				if(bean.getAccount() != null)
				{
					pstmt.setString(15,bean.getAccount());
				}
				else
				{
					pstmt.setNull(15,Types.NVARCHAR);
				}

				if(bean.getPassword() != null)
				{
					pstmt.setBytes(16,bean.getPassword());
				}
				else
				{
					pstmt.setNull(16,Types.VARBINARY);
				}

				if(bean.getAccountStatus() != null)
				{
					pstmt.setString(17,bean.getAccountStatus());
				}
				else
				{
					pstmt.setNull(17,Types.NVARCHAR);
				}

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						int pk = 0;
						if(key.next())
						{
							pk = key.getInt(1);
						}
						result = select(pk);
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
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{

				if(bean.getLastName() != null)
				{
					pstmt.setString(1,bean.getLastName());
				}
				else
				{
					pstmt.setNull(1,Types.NVARCHAR);
				}

				if(bean.getFirstName() != null)
				{
					pstmt.setString(2,bean.getFirstName());
				}
				else
				{
					pstmt.setNull(2,Types.NVARCHAR);
				}

				if(bean.getIdNumber() != null)
				{
					pstmt.setString(3,bean.getIdNumber());
				}
				else
				{
					pstmt.setNull(3,Types.NVARCHAR);
				}

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

				if(bean.getBirthday() != null)
				{
					pstmt.setTimestamp(6,new java.sql.Timestamp(bean.getBirthday().getTime()));
				}
				else
				{
					pstmt.setNull(6,Types.TIMESTAMP);
				}

				if(bean.getAddress() != null)
				{
					pstmt.setString(7,bean.getAddress());
				}
				else
				{
					pstmt.setNull(7,Types.NVARCHAR);
				}

				if(bean.getGender() != null)
				{
					pstmt.setString(8,bean.getGender());
				}
				else
				{
					pstmt.setNull(8,Types.NVARCHAR);
				}

				if(bean.getEmail() != null)
				{
					pstmt.setString(9,bean.getEmail());
				}
				else
				{
					pstmt.setNull(9,Types.NVARCHAR);
				}

				if(bean.getPictureName() != null)
				{
					pstmt.setString(10,bean.getPictureName());
				}
				else
				{
					pstmt.setNull(10,Types.NVARCHAR);
				}

				if(bean.getPicture() != null)
				{
					pstmt.setBytes(11,bean.getPicture());
				}
				else
				{
					pstmt.setNull(11,Types.VARBINARY);
				}

				if(bean.getPictureLength() != null)
				{
					pstmt.setLong(12,bean.getPictureLength());
				}
				else
				{
					pstmt.setNull(12,Types.BIGINT);
				}

				if(bean.getRegisterTime() != null)
				{
					pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getRegisterTime().getTime()));
				}
				else
				{
					pstmt.setNull(13,Types.TIMESTAMP);
				}

				if(bean.getRecommendCount() != null)
				{
					pstmt.setInt(14,bean.getRecommendCount());
				}
				else
				{
					pstmt.setNull(14,Types.INTEGER);
				}

				if(bean.getAccount() != null)
				{
					pstmt.setString(15,bean.getAccount());
				}
				else
				{
					pstmt.setNull(15,Types.NVARCHAR);
				}

				if(bean.getPassword() != null)
				{
					pstmt.setBytes(16,bean.getPassword());
				}
				else
				{
					pstmt.setNull(16,Types.VARBINARY);
				}

				if(bean.getAccountStatus() != null)
				{
					pstmt.setString(17,bean.getAccountStatus());
				}
				else
				{
					pstmt.setNull(17,Types.NVARCHAR);
				}

				if(bean.getMemberId() != null)
				{
					pstmt.setInt(18,bean.getMemberId());
				}
				else
				{
					pstmt.setNull(18,Types.INTEGER);
				}

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
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
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
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					result = new MemberBean();
					
					if(rs.getObject("memberId") != null)
					{
						result.setMemberId(rs.getInt("memberId"));
					}
					else
					{
						result.setMemberId((Integer)rs.getObject("memberId"));
					}
					
					if(rs.getObject("LastName") != null)
					{
						result.setLastName(rs.getString("LastName"));
					}
					else
					{
						result.setLastName((String)rs.getObject("LastName"));
					}
					
					if(rs.getObject("FirstName") != null)
					{
						result.setFirstName(rs.getString("FirstName"));
					}
					else
					{
						result.setFirstName((String)rs.getObject("FirstName"));
					}
					
					if(rs.getObject("IdNumber") != null)
					{
						result.setIdNumber(rs.getString("IdNumber"));
					}
					else
					{
						result.setIdNumber((String)rs.getObject("IdNumber"));
					}
					
					if(rs.getObject("Phone") != null)
					{
						result.setPhone(rs.getString("Phone"));
					}
					else
					{
						result.setPhone((String)rs.getObject("Phone"));
					}
	
					if(rs.getObject("CellPhone") != null)
					{
						result.setCellPhone(rs.getString("CellPhone"));
					}
					else
					{
						result.setCellPhone((String)rs.getObject("CellPhone"));
					}
					
					if(rs.getObject("Birthday") != null)
					{
						result.setBirthday(rs.getDate("Birthday"));
					}
					else
					{
						result.setBirthday((java.util.Date)rs.getObject("Birthday"));
					}
					
					if(rs.getObject("Address") != null)
					{
						result.setAddress(rs.getString("Address"));
					}
					else
					{
						result.setAddress((String)rs.getObject("Address"));
					}
					
					if(rs.getObject("Gender") != null)
					{
						result.setGender(rs.getString("Gender"));
					}
					else
					{
						result.setGender((String)rs.getObject("Gender"));
					}
					
					if(rs.getObject("Email") != null)
					{
						result.setEmail(rs.getString("Email"));
					}
					else
					{
						result.setEmail((String)rs.getObject("Email"));
					}
					
					if(rs.getObject("PictureName") != null)
					{
						result.setPictureName(rs.getString("PictureName"));
					}
					else
					{
						result.setPictureName((String)rs.getObject("PictureName"));
					}
					
					if(rs.getObject("Picture") != null)
					{
						result.setPicture(rs.getBytes("Picture"));
					}
					else
					{
						result.setPicture((byte[])rs.getObject("Picture"));
					}
					
					if(rs.getObject("PictureLength") != null)
					{
						result.setPictureLength(rs.getLong("PictureLength"));
					}
					else
					{
						result.setPictureLength((Long)rs.getObject("PictureLength"));
					}
					
					if(rs.getObject("RegisterTime") != null)
					{		
						result.setRegisterTime(rs.getDate("RegisterTime"));
					}
					else
					{
						result.setRegisterTime((java.util.Date)rs.getObject("RegisterTime"));
					}
					
					if(rs.getObject("RecommendCount") != null)
					{
						result.setRecommendCount(rs.getInt("RecommendCount"));
					}
					else
					{
						result.setRecommendCount((Integer)rs.getObject("RecommendCount"));
					}
					
					if(rs.getObject("Account") != null)
					{
						result.setAccount(rs.getString("Account"));
					}
					else
					{
						result.setAccount((String)rs.getObject("Account"));
					}
					
					if(rs.getObject("Password") != null)
					{
						result.setPassword(rs.getBytes("Password"));
					}
					else
					{
						result.setPassword((byte[])rs.getObject("Password"));
					}
					
					if(rs.getObject("AccountStatus") != null)
					{
						result.setAccountStatus(rs.getString("AccountStatus"));
					}
					else
					{
						result.setAccountStatus((String)rs.getObject("AccountStatus"));
					}
				}
			}
			catch(Exception e)
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
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);)
		{
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new MemberBean();
					
					if(rs.getObject("memberId") != null)
					{
						bean.setMemberId(rs.getInt("memberId"));
					}
					else
					{
						bean.setMemberId((Integer)rs.getObject("memberId"));
					}
					
					if(rs.getObject("LastName") != null)
					{
						bean.setLastName(rs.getString("LastName"));
					}
					else
					{
						bean.setLastName((String)rs.getObject("LastName"));
					}
					
					if(rs.getObject("FirstName") != null)
					{
						bean.setFirstName(rs.getString("FirstName"));
					}
					else
					{
						bean.setFirstName((String)rs.getObject("FirstName"));
					}
					
					if(rs.getObject("IdNumber") != null)
					{
						bean.setIdNumber(rs.getString("IdNumber"));
					}
					else
					{
						bean.setIdNumber((String)rs.getObject("IdNumber"));
					}
					
					if(rs.getObject("Phone") != null)
					{
						bean.setPhone(rs.getString("Phone"));
					}
					else
					{
						bean.setPhone((String)rs.getObject("Phone"));
					}
	
					if(rs.getObject("CellPhone") != null)
					{
						bean.setCellPhone(rs.getString("CellPhone"));
					}
					else
					{
						bean.setCellPhone((String)rs.getObject("CellPhone"));
					}
					
					if(rs.getObject("Birthday") != null)
					{
						bean.setBirthday(rs.getDate("Birthday"));
					}
					else
					{
						bean.setBirthday((java.util.Date)rs.getObject("Birthday"));
					}
					
					if(rs.getObject("Address") != null)
					{
						bean.setAddress(rs.getString("Address"));
					}
					else
					{
						bean.setAddress((String)rs.getObject("Address"));
					}
					
					if(rs.getObject("Gender") != null)
					{
						bean.setGender(rs.getString("Gender"));
					}
					else
					{
						bean.setGender((String)rs.getObject("Gender"));
					}
					
					if(rs.getObject("Email") != null)
					{
						bean.setEmail(rs.getString("Email"));
					}
					else
					{
						bean.setEmail((String)rs.getObject("Email"));
					}
					
					if(rs.getObject("PictureName") != null)
					{
						bean.setPictureName(rs.getString("PictureName"));
					}
					else
					{
						bean.setPictureName((String)rs.getObject("PictureName"));
					}
					
					if(rs.getObject("Picture") != null)
					{
						bean.setPicture(rs.getBytes("Picture"));
					}
					else
					{
						bean.setPicture((byte[])rs.getObject("Picture"));
					}
					
					if(rs.getObject("PictureLength") != null)
					{
						bean.setPictureLength(rs.getLong("PictureLength"));
					}
					else
					{
						bean.setPictureLength((Long)rs.getObject("PictureLength"));
					}
					
					if(rs.getObject("RegisterTime") != null)
					{		
						bean.setRegisterTime(rs.getDate("RegisterTime"));
					}
					else
					{
						bean.setRegisterTime((java.util.Date)rs.getObject("RegisterTime"));
					}
					
					if(rs.getObject("RecommendCount") != null)
					{
						bean.setRecommendCount(rs.getInt("RecommendCount"));
					}
					else
					{
						bean.setRecommendCount((Integer)rs.getObject("RecommendCount"));
					}
					
					if(rs.getObject("Account") != null)
					{
						bean.setAccount(rs.getString("Account"));
					}
					else
					{
						bean.setAccount((String)rs.getObject("Account"));
					}
					
					if(rs.getObject("Password") != null)
					{
						bean.setPassword(rs.getBytes("Password"));
					}
					else
					{
						bean.setPassword((byte[])rs.getObject("Password"));
					}
					
					if(rs.getObject("AccountStatus") != null)
					{
						bean.setAccountStatus(rs.getString("AccountStatus"));
					}
					else
					{
						bean.setAccountStatus((String)rs.getObject("AccountStatus"));
					}
					
					result.add(bean);
				}
			}
			catch(Exception e)
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
		try(FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream data = new ByteArrayOutputStream();)
		{
			bean1.setPictureName(file.getName());
			
			byte[] buffer = new byte[1024 * 8];
			int nRead = fis.read(buffer);
			while(nRead != -1)
			{
				data.write(buffer,0,nRead);
				nRead = fis.read(buffer);
			}
			bean1.setPicture(data.toByteArray());
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
		try(FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream data = new ByteArrayOutputStream();)
		{
			bean2.setPictureName(file.getName());
			
			byte[] buffer = new byte[1024 * 8];
			int nRead = fis.read(buffer);
			while(nRead != -1)
			{
				data.write(buffer,0,nRead);
				nRead = fis.read(buffer);
			}
			bean2.setPicture(data.toByteArray());
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

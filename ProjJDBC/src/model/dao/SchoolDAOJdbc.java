package model.dao;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.SchoolBean;
import model.dao.interfaces.SchoolDAO;

public class SchoolDAOJdbc implements SchoolDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_ID = "SELECT schoolId,name,phone,addressDistrict,addressComplete,url,frontCoverName,frontCover,frontCoverLength,aboutMe,managerEmail,projectManager,accountContact,password,accountStatus FROM School WHERE schoolId = ?";
	@Override
	public SchoolBean findByPrimaryKey(int schoolId)
	{
		SchoolBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,schoolId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new SchoolBean();
					result.setSchoolId(rset.getInt("schoolId"));
					result.setName(rset.getString("name"));
					result.setPhone(rset.getString("phone"));
					result.setAddressDistrict(rset.getString("addressDistrict"));
					result.setAddressComplete(rset.getString("addressComplete"));
					result.setUrl(rset.getString("url"));
					result.setFrontCoverName(rset.getString("frontCoverName"));
					result.setFrontCover(rset.getBytes("frontCover"));
					
					if(rset.getObject("frontCoverLength") != null)
					{
						result.setFrontCoverLength(rset.getLong("frontCoverLength"));
					}
					else
					{
						result.setFrontCoverLength((Long)rset.getObject("frontCoverLength"));
					}
					
					result.setAboutMe(rset.getString("aboutMe"));
					result.setManagerEmail(rset.getString("managerEmail"));
					result.setProjectManager(rset.getString("projectManager"));
					result.setAccountContact(rset.getString("accountContact"));
					result.setPassword(rset.getBytes("password"));
					result.setAccountStatus(rset.getString("accountStatus"));
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

	private static final String SELECT_ALL = "SELECT schoolId,name,phone,addressDistrict,addressComplete,url,frontCoverName,frontCover,frontCoverLength,aboutMe,managerEmail,projectManager,accountContact,password,accountStatus FROM School";
	@Override
	public List<SchoolBean> getAll()
	{
		List<SchoolBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<SchoolBean>();
			while(rset.next())
			{
				SchoolBean bean = new SchoolBean();
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setName(rset.getString("name"));
				bean.setPhone(rset.getString("phone"));
				bean.setAddressDistrict(rset.getString("addressDistrict"));
				bean.setAddressComplete(rset.getString("addressComplete"));
				bean.setUrl(rset.getString("url"));
				bean.setFrontCoverName(rset.getString("frontCoverName"));
				bean.setFrontCover(rset.getBytes("frontCover"));
				
				if(rset.getObject("frontCoverLength") != null)
				{
					bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
				}
				else
				{
					bean.setFrontCoverLength((Long)rset.getObject("frontCoverLength"));
				}
				
				bean.setAboutMe(rset.getString("aboutMe"));
				bean.setManagerEmail(rset.getString("managerEmail"));
				bean.setProjectManager(rset.getString("projectManager"));
				bean.setAccountContact(rset.getString("accountContact"));
				bean.setPassword(rset.getBytes("password"));
				bean.setAccountStatus(rset.getString("accountStatus"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "INSERT INTO School (schoolId,name,phone,addressDistrict,addressComplete,url,frontCoverName,frontCover,frontCoverLength,aboutMe,managerEmail,projectManager,accountContact,password,accountStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public SchoolBean insert(SchoolBean bean)
	{
		SchoolBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setString(2,bean.getName());
				pstmt.setString(3,bean.getPhone());
				pstmt.setString(4,bean.getAddressDistrict());
				pstmt.setString(5,bean.getAddressComplete());
				pstmt.setString(6,bean.getUrl());
				pstmt.setString(7,bean.getFrontCoverName());
				pstmt.setBytes(8,bean.getFrontCover());
				
				if(bean.getFrontCoverLength() != null)
				{
					pstmt.setLong(9,bean.getFrontCoverLength());
				}
				else
				{
					pstmt.setNull(9,Types.BIGINT);
				}
				
				pstmt.setString(10,bean.getAboutMe());
				pstmt.setString(11,bean.getManagerEmail());
				pstmt.setString(12,bean.getProjectManager());
				pstmt.setString(13,bean.getAccountContact());
				pstmt.setBytes(14,bean.getPassword());
				pstmt.setString(15,bean.getAccountStatus());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getSchoolId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String UPDATE = "UPDATE School SET name = ?,phone = ?,addressDistrict = ?,addressComplete = ?, url = ?,frontCoverName = ?,frontCover = ?,frontCoverLength = ?,aboutMe = ?,managerEmail = ?,projectManager = ?,accountContact = ?,password = ?,accountStatus = ? where schoolId = ?";
	@Override
	public SchoolBean update(SchoolBean bean)
	{
		SchoolBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setString(1,bean.getName());
				pstmt.setString(2,bean.getPhone());
				pstmt.setString(3,bean.getAddressDistrict());
				pstmt.setString(4,bean.getAddressComplete());
				pstmt.setString(5,bean.getUrl());
				pstmt.setString(6,bean.getFrontCoverName());
				pstmt.setBytes(7,bean.getFrontCover());

				if(bean.getFrontCoverLength() != null)
				{
					pstmt.setLong(8,bean.getFrontCoverLength());
				}
				else
				{
					pstmt.setNull(8,Types.BIGINT);
				}

				pstmt.setString(9,bean.getAboutMe());
				pstmt.setString(10,bean.getManagerEmail());
				pstmt.setString(11,bean.getProjectManager());
				pstmt.setString(12,bean.getAccountContact());
				pstmt.setBytes(13,bean.getPassword());
				pstmt.setString(14,bean.getAccountStatus());
				pstmt.setInt(15,bean.getSchoolId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = findByPrimaryKey(bean.getSchoolId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM school WHERE schoolId = ?";
	@Override
	public boolean delete(int schoolId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,schoolId);
			int i = pstmt.executeUpdate();
			if(i == 1)
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

	public static void main(String[] args)
	{
		SchoolDAO dao = new SchoolDAOJdbc();
//		List<SchoolBean> beans = dao.getAll();
//		System.out.println(beans.size());
//		SchoolBean bean = dao.findByPrimaryKey(11503);
//		System.out.println(bean);

//		SchoolBean bean = new SchoolBean();
//		bean.setSchoolId(1);
//		bean.setName("神笑");
//		bean.setPhone("6631666");
//		bean.setAddressDistrict("高");
//		bean.setAddressComplete("雄");
//		bean.setPassword("p@sswo0d".getBytes());
//		bean.setAccountStatus("待認證");
//		System.out.println(dao.insert(bean));
		
		
		SchoolBean bean2 = dao.findByPrimaryKey(1);
		bean2.setUrl("http://orz.com");
		File file = new File("image/member/member01.jpg");
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean2.setFrontCoverName(file.getName());
			bean2.setFrontCover(GlobalService.convertInputStreamToByteArray(fis));
			bean2.setFrontCoverLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		bean2.setAboutMe("新開的");
		bean2.setManagerEmail("orz@yahoo");
		bean2.setProjectManager("我是校長");
		bean2.setAccountContact("校長的電話在這");
		bean2.setAccountStatus("啟用");
		
//		System.out.println(dao.update(bean2));
//		System.out.println(dao.update("資策會","0123456789","[03]桃園市","台北市大安區資策會","http://www.tcpip.com",null,bytes,l,null,null,null,null,bytes,null,11500));
		System.out.println(dao.delete(1));
	}
}

package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DonationDiscussBean;

public class DonationDiscussDAOjdbc
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_PRYMARY_KEY = "SELECT donationDiscussId,donationId,memberId,memberMessage,memberMessageTime,schoolId,schoolMessage,schoolMessageTime FROM DonationDiscuss WHERE donationDiscussId = ?";
	private static final String GET_ALL = "SELECT donationDiscussId,donationId,memberId,memberMessage,memberMessageTime,schoolId,schoolMessage,schoolMessageTime FROM DonationDiscuss";
	private static final String INSERT = "INSERT INTO DonationDiscuss(donationId,memberId,memberMessage,memberMessageTime,schoolId,schoolMessage,schoolMessageTime) VALUES(?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE DonationDiscuss SET donationId = ?,memberId = ?,memberMessage = ?,memberMessageTime = ?,schoolId = ?,schoolMessage = ?,schoolMessageTime = ? WHERE donationDiscussId = ?";
	private static final String DELETE = "DELETE FROM DonationDiscuss WHERE donationDiscussId = ?";

	public DonationDiscussBean findByPrimaryKey(int donationDiscussId)
	{
		DonationDiscussBean bean = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);)
		{
			pstmt.setInt(1,donationDiscussId);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new DonationDiscussBean();
					bean.setDonationDiscussId(rs.getInt("donationDiscussId"));
					bean.setDonationId(rs.getInt("donationId"));
					
					bean.setMemberId(rs.getInt("memberId"));
					bean.setMemberMessage(rs.getString("memberMessage"));
					bean.setMemberMessageTime(rs.getTimestamp("memberMessageTime"));

					if(rs.getObject("schoolId") != null)
					{
						bean.setSchoolId(rs.getInt("schoolId"));
					}
					else
					{
						bean.setSchoolId((Integer)rs.getObject("schoolId"));
					}
					bean.setSchoolMessage(rs.getString("schoolMessage"));
					bean.setSchoolMessageTime(rs.getTimestamp("schoolMessageTime"));
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
		return bean;
	}

	public List<DonationDiscussBean> getAll()
	{
		List<DonationDiscussBean> resultList = new ArrayList<DonationDiscussBean>();
		DonationDiscussBean bean = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationDiscussBean();
				bean.setDonationDiscussId(rs.getInt("donationDiscussId"));
				bean.setDonationId(rs.getInt("donationId"));
				
				bean.setMemberId(rs.getInt("memberId"));
				bean.setMemberMessage(rs.getString("memberMessage"));
				bean.setMemberMessageTime(rs.getTimestamp("memberMessageTime"));

				if(rs.getObject("schoolId") != null)
				{
					bean.setSchoolId(rs.getInt("schoolId"));
				}
				else
				{
					bean.setSchoolId((Integer)rs.getObject("schoolId"));
				}
				bean.setSchoolMessage(rs.getString("schoolMessage"));
				bean.setSchoolMessageTime(rs.getTimestamp("schoolMessageTime"));
				resultList.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return resultList;
	}

	public DonationDiscussBean insert(DonationDiscussBean bean)
	{
		DonationDiscussBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getDonationId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setString(3,bean.getMemberMessage());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getMemberMessageTime().getTime()));
				
				if(bean.getSchoolId() != null)
				{
					pstmt.setInt(5,bean.getSchoolId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getSchoolMessage() != null)
				{
					pstmt.setString(6,bean.getSchoolMessage());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				
				if(bean.getSchoolMessageTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getSchoolMessageTime().getTime()));
				}
				else
				{
					pstmt.setNull(7,Types.TIMESTAMP);
				}
				
				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					ResultSet key = pstmt.getGeneratedKeys();
					if(key.next())
					{
						result = findByPrimaryKey(key.getInt(1));
					}
					System.out.println("insert success");
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public DonationDiscussBean update(DonationDiscussBean bean)
	{
		DonationDiscussBean result = null;

		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{

				pstmt.setInt(1,bean.getDonationId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setString(3,bean.getMemberMessage());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getMemberMessageTime().getTime()));
				
				if(bean.getSchoolId() != null)
				{
					pstmt.setInt(5,bean.getSchoolId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getSchoolMessage() != null)
				{
					pstmt.setString(6,bean.getSchoolMessage());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				
				if(bean.getSchoolMessageTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getSchoolMessageTime().getTime()));
				}
				else
				{
					pstmt.setNull(7,Types.TIMESTAMP);
				}
				
				pstmt.setInt(8,bean.getDonationDiscussId());
				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					System.out.println("update success");
					result = findByPrimaryKey(bean.getDonationDiscussId());
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(int donationId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,donationId);
			int count = pstmt.executeUpdate();
			if(count == 1)
			{
				System.out.println("delete success");
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
		DonationDiscussDAOjdbc daojdbc = new DonationDiscussDAOjdbc();
		/** INSERT OK **/
		DonationDiscussBean bean1 = new DonationDiscussBean();
		bean1.setDonationId(1);
		bean1.setMemberId(null);
		bean1.setMemberMessage(null);
		bean1.setMemberMessageTime(null);
		bean1.setSchoolId(null);
		bean1.setSchoolMessage(null);
		bean1.setSchoolMessageTime(null);
		bean1 = daojdbc.insert(bean1);
		System.out.println(bean1);

		/** UPDATE OK **/
		DonationDiscussBean bean2 = new DonationDiscussBean();
		bean2.setDonationDiscussId(2);
		bean2.setDonationId(1);
		bean2.setMemberId(1);
		bean2.setMemberMessage("hellojjjjj1");
		bean2.setMemberMessageTime(new Date());
//		bean2.setSchoolId(21215);
//		bean2.setSchoolMessage("worldjjjjjj11");
//		bean2.setSchoolMessageTime(new Date());
		daojdbc.update(bean2);

		/** DELETE OK **/
		boolean count = daojdbc.delete(100);
		System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY OK **/
		DonationDiscussBean bean4 = new DonationDiscussBean();
		bean4 = daojdbc.findByPrimaryKey(1);
		System.out.println(bean4);

		/** GET_ALL OK **/
		List<DonationDiscussBean> list = daojdbc.getAll();
		System.out.println();
		for(DonationDiscussBean bean5 : list)
		{
			System.out.println(bean5);
		}

	}
}

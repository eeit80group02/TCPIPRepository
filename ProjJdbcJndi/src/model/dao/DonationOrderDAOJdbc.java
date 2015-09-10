package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.DonationOrderBean;

public class DonationOrderDAOJdbc
{
	private DataSource datasource;

	public DonationOrderDAOJdbc()
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
	
	private static final String INSERT = "INSERT INTO DonationOeder(memberId,name,address,phone,cellPhone,email,pickTime,donationOederDate,dealId) VALUES (?,?,?,?,?,?,?,?,?)";
	public DonationOrderBean insert(DonationOrderBean bean)
	{
		DonationOrderBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getMemberId());
				pstmt.setString(2,bean.getName());
				pstmt.setString(3,bean.getAddress());
				pstmt.setString(4,bean.getPhone());
				pstmt.setString(5,bean.getCellPhone());
				pstmt.setString(6,bean.getEmail());
				pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getPickTime().getTime()));
				pstmt.setTimestamp(8,new java.sql.Timestamp(bean.getDonationOederDate().getTime()));

				if(bean.getDealId() != null)
				{
					pstmt.setString(9,bean.getDealId());
				}
				else
				{
					pstmt.setNull(9,Types.NVARCHAR);
				}

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = findByPrimaryKey(key.getInt(1));
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
	
	private static final String DELETE = "DELETE FROM DonationOeder WHERE donationOederId = ?";
	public boolean delete(int id)
	{
		boolean result = false;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,id);
			int num = pstmt.executeUpdate();
			if(num == 1)
			{
				result = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String UPDATE = "UPDATE DonationOeder SET memberId = ?,name = ?,address = ?,phone = ?,cellPhone = ?,email = ?,pickTime = ?,donationOederDate = ?,dealId = ? WHERE donationOederId = ?";
	public DonationOrderBean update(DonationOrderBean bean)
	{
		DonationOrderBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getMemberId());
				pstmt.setString(2,bean.getName());
				pstmt.setString(3,bean.getAddress());
				pstmt.setString(4,bean.getPhone());
				pstmt.setString(5,bean.getCellPhone());
				pstmt.setString(6,bean.getEmail());
				pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getPickTime().getTime()));
				pstmt.setTimestamp(8,new java.sql.Timestamp(bean.getDonationOederDate().getTime()));

				if(bean.getDealId() != null)
				{
					pstmt.setString(9,bean.getDealId());
				}
				else
				{
					pstmt.setNull(9,Types.NVARCHAR);
				}

				pstmt.setInt(10,bean.getDonationOrderId());
				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = findByPrimaryKey(bean.getDonationOrderId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT donationOederId,memberId,name,address,phone,cellPhone,email,pickTime,donationOederDate,dealId FROM DonationOeder WHERE donationOederId = ?";
	public DonationOrderBean findByPrimaryKey(int id)
	{
		DonationOrderBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new DonationOrderBean();

					result.setDonationOrderId(rs.getInt(1));
					result.setMemberId(rs.getInt(2));
					result.setName(rs.getString(3));
					result.setAddress(rs.getString(4));
					result.setPhone(rs.getString(5));
					result.setCellPhone(rs.getString(6));
					result.setEmail(rs.getString(7));
					result.setPickTime(rs.getTimestamp(8));
					result.setDonationOederDate(rs.getTimestamp(9));
					result.setDealId(rs.getString(10));
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

	private static final String SELECT_ALL = "SELECT donationOederId,memberId,name,address,phone,cellPhone,email,pickTime,donationOederDate,dealId FROM DonationOeder";
	public List<DonationOrderBean> getAll()
	{
		List<DonationOrderBean> result = new ArrayList<DonationOrderBean>();
		DonationOrderBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationOrderBean();
				
				bean.setDonationOrderId(rs.getInt(1));
				bean.setMemberId(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setPhone(rs.getString(5));
				bean.setCellPhone(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setPickTime(rs.getTimestamp(8));
				bean.setDonationOederDate(rs.getTimestamp(9));
				bean.setDealId(rs.getString(10));
				
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args)
	{
		DonationOrderDAOJdbc dao = new DonationOrderDAOJdbc();
		
		// findByPrimaryKey
		DonationOrderBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
		
		// select
		List<DonationOrderBean> selectBead;
		selectBead = dao.getAll();
		System.out.println(selectBead);
		
		// insert
		DonationOrderBean insertData = new DonationOrderBean();
		DonationOrderBean insertBean;
		insertData.setMemberId(7);
		insertData.setName("張寶");
		insertData.setAddress("大安區復興南路一段390號");
		insertData.setPhone("66316666");
		insertData.setCellPhone("0966315566");
		insertData.setEmail("Orz@org.com");
		insertData.setPickTime(GlobalService.convertStringToDate("2015-08-09"));
		insertData.setDonationOederDate(new java.util.Date(System.currentTimeMillis()));
		insertData.setDealId(null);
		insertBean = dao.insert(insertData);
		System.out.println(insertBean);
		
		// update
		DonationOrderBean updateData = new DonationOrderBean();
		DonationOrderBean updateBean;
		updateData.setDonationOrderId(1);
		updateData.setMemberId(7);
		updateData.setName("張寶了");
		updateData.setAddress("大安區復興南路一段490號");
		updateData.setPhone("66316666");
		updateData.setCellPhone("0966315566");
		updateData.setEmail("Orz@org.com");
		updateData.setPickTime(GlobalService.convertStringToDate("2015-08-09"));
		updateData.setDonationOederDate(new java.util.Date(System.currentTimeMillis()));
		updateData.setDealId("x12345");
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
		
		// delete
		boolean delete = dao.delete(100);
		System.out.println("Delete : " + delete);
	}
}

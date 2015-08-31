package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DonationDetailBean;

public class DonationDetailDAOJdbc
{
	private static final String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String INSERT = "INSERT INTO DonationDetail(donationId,memberId,pickTime,name,address,phone,cellPhone,email,donationAmount,dealId) VALUES (?,?,?,?,?,?,?,?,?,?)";
	public DonationDetailBean insert(DonationDetailBean bean)
	{
		DonationDetailBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1,bean.getDonationId());
			pstmt.setInt(2,bean.getMemberId());
			pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getPickTime().getTime()));
			pstmt.setString(4,bean.getName());
			pstmt.setString(5,bean.getAddress());
			pstmt.setString(6,bean.getPhone());
			pstmt.setString(7,bean.getCellPhone());
			pstmt.setString(8,bean.getEmail());
			pstmt.setInt(9,bean.getDonationAmount());
			pstmt.setString(10,bean.getDealId());
			int num = pstmt.executeUpdate();
			if(num == 1)
			{
				try(ResultSet key = pstmt.getGeneratedKeys();)
				{
					int pk = 0;
					if(key.next())
						pk = key.getInt(1);
					
					result = findByPrimaryKey(pk);
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

		return result;
	}
	
	private static final String DELETE = "DELETE FROM DonationDetail WHERE donationDetailId = ?";
	public boolean delete(int id)
	{
		boolean result = false;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String UPDATE = "UPDATE DonationDetail SET donationId = ?,memberId = ?,pickTime = ?,name = ?,address = ?,phone=?,cellPhone=?,email = ?,donationAmount = ?,dealId = ? WHERE donationDetailId = ?";
	public DonationDetailBean update(DonationDetailBean bean)
	{
		DonationDetailBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getDonationId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setTimestamp(3,new java.sql.Timestamp(bean.getPickTime().getTime()));
				pstmt.setString(4,bean.getName());
				pstmt.setString(5,bean.getAddress());
				pstmt.setString(6,bean.getPhone());
				pstmt.setString(7,bean.getCellPhone());
				pstmt.setString(8,bean.getEmail());
				pstmt.setInt(9,bean.getDonationAmount());
				pstmt.setString(10,bean.getDealId());
				pstmt.setInt(11,bean.getDonationDetailId());
				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = findByPrimaryKey(bean.getDonationDetailId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return result;
	}
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT donationDetailId,donationId,memberId,pickTime,name,address,phone,cellPhone,email,donationAmount,dealId FROM DonationDetail WHERE donationDetailId = ?";
	public DonationDetailBean findByPrimaryKey(int id)
	{
		DonationDetailBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new DonationDetailBean();
					result.setDonationDetailId(rs.getInt(1));
					result.setDonationId(rs.getInt(2));
					result.setMemberId(rs.getInt(3));
					result.setPickTime(rs.getTimestamp(4));
					result.setName(rs.getString(5));
					result.setAddress(rs.getString(6));
					result.setPhone(rs.getString(7));
					result.setCellPhone(rs.getString(8));
					result.setEmail(rs.getString(9));
					result.setDonationAmount(rs.getInt(10));
					result.setDealId(rs.getString(11));
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

	private static final String SELECT_ALL = "SELECT donationDetailId,donationId,memberId,pickTime,name,address,phone,cellPhone,email,donationAmount,dealId FROM DonationDetail";
	public List<DonationDetailBean> getAll()
	{
		List<DonationDetailBean> result = new ArrayList<DonationDetailBean>();
		DonationDetailBean bean = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);)
		{
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new DonationDetailBean();
					bean.setDonationDetailId(rs.getInt(1));
					bean.setDonationId(rs.getInt(2));
					bean.setMemberId(rs.getInt(3));
					bean.setPickTime(rs.getTimestamp(4));
					bean.setName(rs.getString(5));
					bean.setAddress(rs.getString(6));
					bean.setPhone(rs.getString(7));
					bean.setCellPhone(rs.getString(8));
					bean.setEmail(rs.getString(9));
					bean.setDonationAmount(rs.getInt(10));
					bean.setDealId(rs.getString(11));
					
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
	public static void main(String[] args)
	{
		DonationDetailDAOJdbc dao = new DonationDetailDAOJdbc();
		
		// findByPrimaryKey
		DonationDetailBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
		
		// select
		List<DonationDetailBean> selectBead;
		selectBead = dao.getAll();
		System.out.println(selectBead);
		
		// insert
		DonationDetailBean insertData = new DonationDetailBean();
		DonationDetailBean insertBean;
		insertData.setDonationId(1);
		insertData.setMemberId(7);
		insertData.setPickTime(new java.util.Date());
		insertData.setName("大神在此");
		insertData.setAddress("小安");
		insertData.setPhone(null);
		insertData.setCellPhone(null);
		insertData.setEmail(null);
		insertData.setDonationAmount(5);
		insertData.setDealId(null);
		insertBean = dao.insert(insertData);
		System.out.println(insertBean);
		
		// update
		DonationDetailBean updateData = new DonationDetailBean();
		DonationDetailBean updateBean;
		updateData.setDonationDetailId(7);
		updateData.setDonationId(1);
		updateData.setMemberId(7);
		updateData.setPickTime(new java.util.Date());
		updateData.setName("中神在此");
		updateData.setAddress("大安");
		updateData.setPhone("123456789");
		updateData.setCellPhone(null);
		updateData.setEmail(null);
		updateData.setDonationAmount(10);
		updateData.setDealId(null);
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
		
		// delete
		boolean delete = dao.delete(2);
		System.out.println("Delete : " + delete);
	}
}

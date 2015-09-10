package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.DonationOrderDetailBean;

public class DonationOrderDetailDAOJdbc
{
	private DataSource datasource;

	public DonationOrderDetailDAOJdbc()
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
	
	private static final String INSERT = "INSERT INTO DonationOederDetail(donationOederId,donationId,supplyName,donationAmount) VALUES (?,?,?,?)";
	public DonationOrderDetailBean insert(DonationOrderDetailBean bean)
	{
		DonationOrderDetailBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getDonationOederId());
				pstmt.setInt(2,bean.getDonationId());
				pstmt.setString(3,bean.getSupplyName());
				pstmt.setInt(4,bean.getDonationAmount());

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
					catch(SQLException e)
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
	
	private static final String DELETE = "DELETE FROM DonationOederDetail WHERE donationOrderDetailId = ?"; 
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
	
	private static final String UPDATE = "UPDATE DonationOederDetail SET donationOederId = ?,donationId = ?,supplyName = ?,donationAmount = ? WHERE donationOrderDetailId = ?";
	public DonationOrderDetailBean update(DonationOrderDetailBean bean)
	{
		DonationOrderDetailBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getDonationOederId());
				pstmt.setInt(2,bean.getDonationId());
				pstmt.setString(3,bean.getSupplyName());
				pstmt.setInt(4,bean.getDonationAmount());
				pstmt.setInt(5,bean.getDonationOrderDetailId());
				
				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = findByPrimaryKey(bean.getDonationOrderDetailId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT donationOrderDetailId,donationOederId,donationId,supplyName,donationAmount FROM DonationOederDetail WHERE donationOrderDetailId = ?";
	public DonationOrderDetailBean findByPrimaryKey(int id)
	{
		DonationOrderDetailBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new DonationOrderDetailBean();
					result.setDonationOrderDetailId(rs.getInt(1));
					result.setDonationOederId(rs.getInt(2));
					result.setDonationId(rs.getInt(3));
					result.setSupplyName(rs.getString(4));
					result.setDonationAmount(rs.getInt(5));
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
	
	private static final String SELECT_ALL = "SELECT donationOrderDetailId,donationOederId,donationId,supplyName,donationAmount FROM DonationOederDetail";
	public List<DonationOrderDetailBean> getAll()
	{
		List<DonationOrderDetailBean> result = new ArrayList<DonationOrderDetailBean>();
		DonationOrderDetailBean bean = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DonationOrderDetailBean();
				bean.setDonationOrderDetailId(rs.getInt(1));
				bean.setDonationOederId(rs.getInt(2));
				bean.setDonationId(rs.getInt(3));
				bean.setSupplyName(rs.getString(4));
				bean.setDonationAmount(rs.getInt(5));
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
		DonationOrderDetailDAOJdbc dao = new DonationOrderDetailDAOJdbc();
		
		// Insert
		DonationOrderDetailBean insertBean = new DonationOrderDetailBean();
		insertBean.setDonationOederId(1);
		insertBean.setDonationId(1);
		insertBean.setSupplyName("尺");
		insertBean.setDonationAmount(5);
		insertBean = dao.insert(insertBean);
		System.out.println(insertBean);
		
		// findByPrimaryKey
		DonationOrderDetailBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
		
		// select
		List<DonationOrderDetailBean> selectBead;
		selectBead = dao.getAll();
		System.out.println(selectBead);
		
		// delete
		boolean delete = dao.delete(100);
		System.out.println("Delete : " + delete);
		
		// update
		DonationOrderDetailBean updateData = new DonationOrderDetailBean();
		DonationOrderDetailBean updateBean;
		updateData.setDonationOrderDetailId(2);
		updateData.setDonationOederId(1);
		updateData.setDonationId(1);
		updateData.setSupplyName("尺2");
		updateData.setDonationAmount(2);
		updateBean = dao.update(updateData);
		System.out.println(updateBean);
	}
}

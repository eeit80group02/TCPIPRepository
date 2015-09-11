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

import model.TrackDonationBean;
import model.dao.interfaces.TrackDonationDAO;

public class TrackDonationDAOJdbc implements TrackDonationDAO
{
	private DataSource datasource;

	public TrackDonationDAOJdbc()
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
	
	private static final String SELECT_BY_ID = "SELECT trackDonationId,donationId,memberId FROM trackdonation WHERE trackDonationId = ?";
	@Override
	public TrackDonationBean findByPrimaryKey(int trackDonationId)
	{
		TrackDonationBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,trackDonationId);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next())
			{
				result = new TrackDonationBean();
				result.setTrackDonationId(rset.getInt("trackDonationId"));
				result.setDonationId(rset.getInt("donationId"));
				result.setMemberId(rset.getInt("memberId"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_ALL = "SELECT trackDonationId,donationId,memberId FROM trackdonation";
	@Override
	public List<TrackDonationBean> getAll()
	{
		List<TrackDonationBean> result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<TrackDonationBean>();
			while(rset.next())
			{
				TrackDonationBean bean = new TrackDonationBean();
				bean.setTrackDonationId(rset.getInt("trackDonationId"));
				bean.setDonationId(rset.getInt("donationId"));
				bean.setMemberId(rset.getInt("memberId"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "INSERT INTO trackdonation (donationId, memberId) values (?, ?)";
	@Override
	public TrackDonationBean insert(TrackDonationBean bean)
	{
		TrackDonationBean result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1,bean.getDonationId());
			pstmt.setInt(2,bean.getMemberId());

			int i = pstmt.executeUpdate();
			if(i == 1)
			{
				ResultSet key = pstmt.getGeneratedKeys();
				if(key.next())
				{
					result = this.findByPrimaryKey(key.getInt(1));
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "UPDATE trackdonation SET donationId = ?, memberId = ? WHERE trackDonationId = ?";
	@Override
	public TrackDonationBean update(TrackDonationBean bean)
	{
		TrackDonationBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getDonationId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setInt(3,bean.getTrackDonationId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getTrackDonationId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM trackdonation WHERE trackDonationId = ?";
	@Override
	public boolean delete(int trackDonationId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,trackDonationId);
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
		TrackDonationDAO dao = new TrackDonationDAOJdbc();
		List<TrackDonationBean> beans = dao.getAll();
		System.out.println(beans);
		TrackDonationBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);

		TrackDonationBean bean1 = new TrackDonationBean();
//		bean1.setTrackDonationId(1);
		bean1.setDonationId(1);
		bean1.setMemberId(2);
//		System.out.println(dao.insert(bean1));
//		System.out.println(dao.update(bean1));
		System.out.println(dao.delete(1));
	}
}

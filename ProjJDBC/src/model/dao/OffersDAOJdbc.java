package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OffersBean;
import model.dao.interfaces.OffersDAO;

public class OffersDAOJdbc implements OffersDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_ALL = "select * from Offers ";
	@Override
	public List<OffersBean> getAll()
	{
		List<OffersBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<OffersBean>();
			while(rset.next())
			{
				OffersBean bean = new OffersBean();
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setRoom(rset.getBoolean("room"));
				bean.setPlace(rset.getBoolean("place"));
				bean.setFood(rset.getBoolean("food"));
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "SELECT schoolDemandId,room,place,food FROM Offers WHERE schoolDemandId =?";
	@Override
	public OffersBean findByPrimaryKey(int schoolDemandId)
	{
		OffersBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,schoolDemandId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				while(rset.next())
				{
					result = new OffersBean();
					result.setSchoolDemandId(rset.getInt("schoolDemandId"));
					result.setRoom(rset.getBoolean("room"));
					result.setPlace(rset.getBoolean("place"));
					result.setFood(rset.getBoolean("food"));
					return result;
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

	private static final String INSERT = "insert into Offers (schoolDemandId, room, place, food) values (?,?,?,?)";
	@Override
	public OffersBean insert(OffersBean bean)
	{
		OffersBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{

				pstmt.setInt(1,bean.getSchoolDemandId());
				pstmt.setBoolean(2,bean.getRoom());
				pstmt.setBoolean(3,bean.getPlace());
				pstmt.setBoolean(4,bean.getFood());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = findByPrimaryKey(bean.getSchoolDemandId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String UPDATE = "UPDATE Offers SET room = ?,place = ?,food = ? WHERE schoolDemandId = ?";
	@Override
	public OffersBean update(OffersBean bean)
	{
		OffersBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setBoolean(1,bean.getRoom());
				pstmt.setBoolean(2,bean.getPlace());
				pstmt.setBoolean(3,bean.getFood());
				pstmt.setInt(4,bean.getSchoolDemandId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getSchoolDemandId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM Offers WHERE schoolDemandId = ?";
	@Override
	public boolean delete(int schoolDemandId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,schoolDemandId);
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
		OffersDAO jdbc = new OffersDAOJdbc();
		OffersBean bean = new OffersBean();
		bean.setSchoolDemandId(2);
		bean.setRoom(false);
		bean.setPlace(false);
		bean.setFood(true);
//		System.out.println(jdbc.insert(bean));
//		System.out.println(jdbc.getAll());
//		System.out.println(jdbc.findByPrimaryKey(2));
		System.out.println(jdbc.update(bean));
		System.out.println(jdbc.delete(1));
	}
}

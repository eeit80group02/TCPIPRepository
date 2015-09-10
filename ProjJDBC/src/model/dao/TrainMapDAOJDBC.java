package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrainMapBean;

public class TrainMapDAOJDBC
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	public static void main(String[] args)
	{
		TrainMapDAOJDBC dao = new TrainMapDAOJDBC();
		List<TrainMapBean> beans = dao.getAll();
		System.out.println(beans);
		TrainMapBean bean = dao.findByPrimaryKey("臺北站");
		System.out.println(bean);

		bean.setName("海科館站");
		System.out.println(dao.insert(bean));
		System.out.println(dao.update("平溪站(平溪線)","海科館站"));
		System.out.println(dao.delete("平溪站(平溪線)"));
	}

	private static final String SELECT_BY_ID = "select name from trainmap where name = ?";
	public TrainMapBean findByPrimaryKey(String name)
	{
		TrainMapBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setString(1,name);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new TrainMapBean();
					result.setName(rset.getString("name"));
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

	private static final String SELECT_ALL = "select name from trainmap";
	public List<TrainMapBean> getAll()
	{
		List<TrainMapBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<TrainMapBean>();
			while(rset.next())
			{
				TrainMapBean bean = new TrainMapBean();
				bean.setName(rset.getString("name"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into trainmap (name) values (?)";

	public TrainMapBean insert(TrainMapBean bean)
	{
		TrainMapBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			pstmt.setString(1,bean.getName());

			int i = pstmt.executeUpdate();
			if(i == 1)
			{
				result = this.findByPrimaryKey(bean.getName());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update trainmap set name = ? where name = ?";

	public TrainMapBean update(String newName,String name)
	{
		TrainMapBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement stmt = conn.prepareStatement(UPDATE);)
		{
			stmt.setString(1,newName);

			stmt.setString(2,name);

			int i = stmt.executeUpdate();
			if(i == 1)
			{
				result = new TrainMapBean();
				result.setName(newName);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	private static final String DELETE = "delete from trainmap where name = ?";
	public boolean delete(String name)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement stmt = conn.prepareStatement(DELETE);)
		{
			stmt.setString(1,name);
			int i = stmt.executeUpdate();
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
}

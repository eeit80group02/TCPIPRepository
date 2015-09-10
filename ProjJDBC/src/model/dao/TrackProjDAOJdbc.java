package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrackProjBean;

public class TrackProjDAOJdbc
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_ID = "SELECT trackProjId,fullProjId,memberId FROM TrackProj WHERE trackProjId = ?";
	public TrackProjBean findByPrimaryKey(int trackProjId)
	{
		TrackProjBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,trackProjId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new TrackProjBean();
					result.setTrackProjId(rset.getInt("trackProjId"));
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setMemberId(rset.getInt("memberId"));
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

	private static final String SELECT_ALL = "SELECT trackProjId,fullProjId,memberId FROM TrackProj";
	public List<TrackProjBean> getAll()
	{
		List<TrackProjBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<TrackProjBean>();
			while(rset.next())
			{
				TrackProjBean bean = new TrackProjBean();
				bean.setTrackProjId(rset.getInt("trackProjId"));
				bean.setFullProjId(rset.getInt("fullProjId"));
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

	private static final String INSERT = "INSERT INTO Trackproj (fullProjId, memberId) values (?, ?)";
	public TrackProjBean insert(TrackProjBean bean)
	{
		TrackProjBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getFullProjId());
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
		}
		return result;
	}

	private static final String UPDATE = "UPDATE Trackproj SET fullProjId = ?, memberId = ? WHERE trackProjId = ?";

	public TrackProjBean update(TrackProjBean bean)
	{
		TrackProjBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setInt(3,bean.getTrackProjId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getTrackProjId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM Trackproj WHERE trackProjId = ?";
	public boolean delete(int trackProjId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,trackProjId);
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
		TrackProjDAOJdbc dao = new TrackProjDAOJdbc();
		List<TrackProjBean> beans = dao.getAll();
		System.out.println(beans);
		TrackProjBean bean = dao.findByPrimaryKey(1);
		System.out.println(bean);

		TrackProjBean bean1 = new TrackProjBean();
		bean1.setTrackProjId(1);
		bean1.setFullProjId(1);
		bean1.setMemberId(1);
//		System.out.println(dao.insert(bean1));
//		System.out.println(dao.update(bean1));
		System.out.println(dao.delete(1));
	}
}

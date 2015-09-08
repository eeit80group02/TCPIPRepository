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
import java.util.ArrayList;
import java.util.List;

import model.ActivityHighlightBean;

public class ActivityHighlightDAOJdbc
{

	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_BY_PRYMARY_KEY = "SELECT fullProjId,memberId,frontCoverName,frontCover,frontCoverLength,vedioURL,content FROM ActivityHighlight WHERE fullProjId = ?";
	private static final String GET_ALL = "SELECT fullProjId,memberId,frontCoverName,frontCover,frontCoverLength,vedioURL,content FROM ActivityHighlight";
	private static final String INSERT = "INSERT INTO ActivityHighlight (fullProjId,memberId,frontCoverName,frontCover,frontCoverLength,vedioURL,content) values (?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE ActivityHighlight SET memberId = ?,frontCoverName = ?,frontCover = ?,frontCoverLength = ?,vedioURL = ?,content = ? WHERE fullProjId = ?";
	private static final String DELETE = "DELETE FROM ActivityHighlight WHERE fullProjId = ?";

	public ActivityHighlightBean findByPrimaryKey(int fullProjId)
	{
		ActivityHighlightBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);)
		{
			pstmt.setInt(1,fullProjId);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new ActivityHighlightBean();
					result.setFullProjId(rs.getInt("FullProjId"));
					result.setMemberId(rs.getInt("MemberId"));
					result.setFrontCoverName(rs.getString("frontCoverName"));
					result.setFrontCover(rs.getBytes("frontCover"));
					result.setFrontCoverLength(rs.getLong("frontCoverLength"));

					if(rs.getObject("VedioURL") != null)
					{
						result.setVedioURL(rs.getString("VedioURL"));
					}
					else
					{
						result.setVedioURL((String)rs.getObject("VedioURL"));
					}
					result.setContent(rs.getString("Content"));
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

	public List<ActivityHighlightBean> getAll()
	{
		List<ActivityHighlightBean> result = new ArrayList<ActivityHighlightBean>();
		ActivityHighlightBean bean = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL);)
		{
			try(ResultSet rs = pstmt.executeQuery();)
			{
				while(rs.next())
				{
					bean = new ActivityHighlightBean();

					bean.setFullProjId(rs.getInt("FullProjId"));
					bean.setMemberId(rs.getInt("MemberId"));
					bean.setFrontCoverName(rs.getString("frontCoverName"));
					bean.setFrontCover(rs.getBytes("frontCover"));
					bean.setFrontCoverLength(rs.getLong("frontCoverLength"));

					if(rs.getObject("VedioURL") != null)
					{
						bean.setVedioURL(rs.getString("VedioURL"));
					}
					else
					{
						bean.setVedioURL((String)rs.getObject("VedioURL"));
					}
					
					bean.setContent(rs.getString("Content"));
					result.add(bean);
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

	public ActivityHighlightBean insert(ActivityHighlightBean bean)
	{
		ActivityHighlightBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{

				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getMemberId());
				pstmt.setString(3,bean.getFrontCoverName());
				pstmt.setBytes(4,bean.getFrontCover());
				pstmt.setLong(5,bean.getFrontCoverLength());

				if(bean.getVedioURL() != null)
				{
					pstmt.setString(6,bean.getVedioURL());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}

				pstmt.setString(7,bean.getContent());

				int num = pstmt.executeUpdate();

				if(num == 1)
				{
					result = findByPrimaryKey(bean.getFullProjId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public ActivityHighlightBean update(ActivityHighlightBean bean)
	{
		ActivityHighlightBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE))
			{

				pstmt.setInt(1,bean.getMemberId());
				pstmt.setString(2,bean.getFrontCoverName());
				pstmt.setBytes(3,bean.getFrontCover());
				pstmt.setLong(4,bean.getFrontCoverLength());

				if(bean.getVedioURL() != null)
				{
					pstmt.setString(5,bean.getVedioURL());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}

				pstmt.setString(6,bean.getContent());
				pstmt.setInt(7,bean.getFullProjId());

				int num = pstmt.executeUpdate();
				if(num == 1)
				{
					result = findByPrimaryKey(bean.getFullProjId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(int fullProjId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,fullProjId);
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

	public static void main(String[] args)
	{
		ActivityHighlightDAOJdbc dao = new ActivityHighlightDAOJdbc();
		
		// insert
		ActivityHighlightBean bean1 = new ActivityHighlightBean();
		bean1.setFullProjId(1);
		bean1.setMemberId(1);
		
		File file = new File("image/member/member01.jpg"); 
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean1.setFrontCoverName(file.getName());
			bean1.setFrontCover(GlobalService.convertInputStreamToByteArray(fis));
			bean1.setFrontCoverLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		bean1.setVedioURL("http://tw.yahoo.com");
		bean1.setContent("測試.......");
		bean1 = dao.insert(bean1);
		System.out.println(bean1);
		
		// update
		ActivityHighlightBean bean2 = new ActivityHighlightBean();
		bean2.setFullProjId(2);
		bean2.setMemberId(2);
		
		file = new File("image/member/member02.jpg"); 
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

		bean2.setVedioURL("http://www.google.com");
		bean2.setContent("測試.......測試.......");
		bean2 = dao.update(bean2);
		System.out.println(bean2);

		// delete
		boolean count = dao.delete(0);
		System.out.println(count);
		
		// select_FK
		ActivityHighlightBean bean4 = dao.findByPrimaryKey(1);
		System.out.println(bean4);

		// select_all
		List<ActivityHighlightBean> bean5 = dao.getAll();
		System.out.println(bean5);
	}
}

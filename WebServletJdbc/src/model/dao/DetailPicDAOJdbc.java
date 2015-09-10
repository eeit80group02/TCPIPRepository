package model.dao;

import global.GlobalService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

import model.DetailPicBean;

public class DetailPicDAOJdbc
{
	private static final String SELECT_BY_PRYMARY_KEY = "SELECT fullProjId,imageName,image,imageLength,imageDescribe FROM DetailPic WHERE fullProjId = ? AND imageName = ?";
	private static final String GET_ALL = "SELECT fullProjId,imageName,image,imageLength,imageDescribe FROM DetailPic";
	private static final String INSERT = "INSERT INTO DetailPic (fullProjId, imageName, image, imageLength, imageDescribe) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE DetailPic SET imageName = ?,image = ?,imageLength = ?,imageDescribe = ? WHERE fullProjId = ? AND imageName = ?";
	private static final String DELETE = "DELETE FROM DetailPic WHERE fullProjId = ? AND imageName = ?";

	private DataSource datasource;
	
	public DetailPicDAOJdbc()
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
	
	public DetailPicBean findByPrimaryKey(int fullProjId,String imageName)
	{
		DetailPicBean bean = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PRYMARY_KEY);)
		{
			pstmt.setInt(1,fullProjId);
			pstmt.setString(2,imageName);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					bean = new DetailPicBean();
					bean.setFullProjId(rs.getInt("fullProjId"));
					bean.setImageName(rs.getString("imageName"));
					bean.setImage(rs.getBytes("image"));
					bean.setImageLength(rs.getLong("imageLength"));
					bean.setImageDescribe(rs.getString("imageDescribe"));
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

	public List<DetailPicBean> getAll()
	{
		List<DetailPicBean> resultlist = new ArrayList<DetailPicBean>();
		DetailPicBean bean = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next())
			{
				bean = new DetailPicBean();
				bean.setFullProjId(rs.getInt("fullProjId"));
				bean.setImageName(rs.getString("imageName"));
				bean.setImage(rs.getBytes("image"));
				bean.setImageLength(rs.getLong("imageLength"));
				bean.setImageDescribe(rs.getString("imageDescribe"));
				resultlist.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultlist;
	}

	public DetailPicBean insert(DetailPicBean bean)
	{
		DetailPicBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setString(2,bean.getImageName());
				pstmt.setBytes(3,bean.getImage());
				pstmt.setLong(4,bean.getImageLength());
				if(bean.getImageDescribe() != null)
				{
					pstmt.setString(5,bean.getImageDescribe());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}
				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					result = findByPrimaryKey(bean.getFullProjId(),bean.getImageName());
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

	public DetailPicBean update(DetailPicBean bean)
	{
		DetailPicBean result = null;

		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setString(1,bean.getImageName());
				pstmt.setBytes(2,bean.getImage());
				pstmt.setLong(3,bean.getImageLength());
				if(bean.getImageDescribe() != null)
				{
					pstmt.setString(4,bean.getImageDescribe());
				}
				else
				{
					pstmt.setNull(4,Types.NVARCHAR);
				}
				pstmt.setInt(5,bean.getFullProjId());
				pstmt.setString(6,bean.getImageName());
				

				int count = pstmt.executeUpdate();
				if(count == 1)
				{
					System.out.println("update success");
					result = findByPrimaryKey(bean.getFullProjId(),bean.getImageName());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(int fullProjId,String imageName)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,fullProjId);
			pstmt.setString(2,imageName);

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
		DetailPicDAOJdbc daojdbc = new DetailPicDAOJdbc();
		/** INSERT OK **/
		
		DetailPicBean bean1 = new DetailPicBean();
		bean1.setFullProjId(2);
		
		File file = new File("image/primaryProj/primaryProj01.jpg");
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean1.setImageName(file.getName());
			bean1.setImage(GlobalService.convertInputStreamToByteArray(fis));
			bean1.setImageLength(file.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		bean1.setImageDescribe(null);
		bean1 = daojdbc.insert(bean1);
		System.out.println(bean1);
		
		/** UPDATE OK **/
		DetailPicBean bean2 = new DetailPicBean();
		bean2.setFullProjId(2);
		file = new File("image/primaryProj/primaryProj01.jpg");
		bean2.setImageName(file.getName());
		try(FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();)
		{
			byte[] buffer = new byte[1024 * 8];
			
			int nRead = fis.read(buffer);
			while(nRead != -1)
			{
				baos.write(buffer,0,nRead);
				nRead = fis.read(buffer);
			}
			bean2.setImage(baos.toByteArray());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		bean2.setImageLength(file.length());
		bean2.setImageDescribe(null);
		bean2 = daojdbc.update(bean2);
		System.out.println(bean2);
		
		/** DELETE OK **/
//		boolean count = daojdbc.delete(1,"primaryProj01.jpg");
//		System.out.println(count);

		/** SELECT_BY_PRYMARY_KEY **/
		DetailPicBean bean4 = new DetailPicBean();
		bean4 = daojdbc.findByPrimaryKey(1,"primaryProj01.jpg");
		System.out.println(bean4);

		/** GET_ALL OK **/
		List<DetailPicBean> list = daojdbc.getAll();
		System.out.println();
		for(DetailPicBean bean5 : list)
		{
			System.out.println(bean5);
		}
	}
}

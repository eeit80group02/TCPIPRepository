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

import model.ReviewsBean;
import model.dao.interfaces.ReviewsDAO;

public class ReviewsDAOJdbc implements ReviewsDAO
{
	private DataSource datasource;

	public ReviewsDAOJdbc()
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
	
	private static final String SELECT_ALL = "SELECT reviewsId,fullProjId,referMemberId,referedMemberId,isReviews,content FROM Reviews";
	@Override
	public List<ReviewsBean> getAll()
	{
		List<ReviewsBean> result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ReviewsBean>();
			while(rset.next())
			{
				ReviewsBean bean = new ReviewsBean();
				bean.setReviewsId(rset.getInt("reviewsId"));
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setReferMemberId(rset.getInt("referMemberId"));
				bean.setReferedMemberId(rset.getInt("referedMemberId"));
				
				if(rset.getObject("isReviews") != null)
				{
					bean.setIsReviews(rset.getBoolean("isReviews"));
				}
				else
				{
					bean.setIsReviews((Boolean)rset.getObject("isReviews"));
				}
				
				bean.setContent(rset.getString("content"));
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "SELECT reviewsId,fullProjId,referMemberId,referedMemberId,isReviews,content FROM Reviews WHERE reviewsId = ?";
	@Override
	public ReviewsBean findByPrimaryKey(int reviewsId)
	{
		ReviewsBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,reviewsId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ReviewsBean();
					result.setReviewsId(rset.getInt("reviewsId"));
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setReferMemberId(rset.getInt("referMemberId"));
					result.setReferedMemberId(rset.getInt("referedMemberId"));
					
					if(rset.getObject("isReviews") != null)
					{
						result.setIsReviews(rset.getBoolean("isReviews"));
					}
					else
					{
						result.setIsReviews((Boolean)rset.getObject("isReviews"));
					}
					result.setContent(rset.getString("content"));
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

	private static final String INSERT = "INSERT INTO Reviews (fullProjId,referMemberId,referedMemberId,isReviews,content) VALUES (?,?,?,?,?)";
	@Override
	public ReviewsBean insert(ReviewsBean bean)
	{
		ReviewsBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getReferMemberId());
				pstmt.setInt(3,bean.getReferedMemberId());
				
				if(bean.getIsReviews() != null)
				{
					pstmt.setBoolean(4,bean.getIsReviews());
				}
				else
				{
					pstmt.setNull(4,Types.BOOLEAN);
				}
				
				if(bean.getContent() != null)
				{
					pstmt.setString(5,bean.getContent());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}
				
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					ResultSet key = pstmt.getGeneratedKeys();
					if(key.next())
					{
						result = findByPrimaryKey(key.getInt(1));
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

	private static final String UPDATE = "UPDATE Reviews SET fullProjId = ?,referMemberId = ?,referedMemberId = ?,isReviews = ?,content = ? WHERE reviewsId = ?";
	@Override
	public ReviewsBean update(ReviewsBean bean)
	{
		ReviewsBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getReferMemberId());
				pstmt.setInt(3,bean.getReferedMemberId());

				if(bean.getIsReviews() != null)
				{
					pstmt.setBoolean(4,bean.getIsReviews());
				}
				else
				{
					pstmt.setNull(4,Types.BOOLEAN);
				}

				if(bean.getContent() != null)
				{
					pstmt.setString(5,bean.getContent());
				}
				else
				{
					pstmt.setNull(5,Types.NVARCHAR);
				}

				pstmt.setInt(6,bean.getReviewsId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getReviewsId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM Reviews WHERE reviewsId = ?";
	@Override
	public boolean delete(int reviewsId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);)
		{
			stmt.setInt(1,reviewsId);
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

	public static void main(String[] args)
	{
		ReviewsDAO jdbc = new ReviewsDAOJdbc();
		ReviewsBean bean = new ReviewsBean();
		bean.setFullProjId(1);
		bean.setReferMemberId(1);
		bean.setReferedMemberId(2);
		bean.setIsReviews(null);
		bean.setContent(null);
		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.getAll());
		System.out.println(jdbc.findByPrimaryKey(1));
		ReviewsBean bean2 = new ReviewsBean();
		bean2.setReviewsId(2);
		bean2.setFullProjId(1);
		bean2.setReferMemberId(1);
		bean2.setReferedMemberId(2);
		bean2.setIsReviews(false);
		bean2.setContent("不于置評");
		System.out.println(jdbc.update(bean2));
		System.out.println(jdbc.delete(1));

	}
}

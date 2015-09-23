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

import model.ProjDiscusBean;
import model.dao.interfaces.ProjDiscusDAO;

public class ProjDiscusDAOJdbc implements ProjDiscusDAO
{
	private DataSource datasource;

	public ProjDiscusDAOJdbc()
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
	
	private static final String SELECT_ALL = "SELECT projDiscussId,fullProjId,questionMemberId,questionMemberContent,questionMemberTime,answerMemberId,answerMemberContent,answerMemberTime FROM ProjDiscuss";
	@Override
	public List<ProjDiscusBean> getAll()
	{
		List<ProjDiscusBean> result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ProjDiscusBean>();
			while(rset.next())
			{
				ProjDiscusBean bean = new ProjDiscusBean();
				bean.setProjDiscusId(rset.getInt("projDiscussId"));
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setQuestionMemberId(rset.getInt("questionMemberId"));
				bean.setQuestionMemberContent(rset.getString("questionMemberContent"));
				bean.setQuestionMemberTime(rset.getTimestamp("questionMemberTime"));
				
				if(rset.getObject("answerMemberId") != null)
				{
					bean.setAnswerMemberId(rset.getInt("answerMemberId"));
				}
				else
				{
					bean.setAnswerMemberId((Integer)rset.getObject("answerMemberId"));
				}
				
				bean.setAnswerMemberContent(rset.getString("answerMemberContent"));
				bean.setAnswerMemberTime(rset.getTimestamp("answerMemberTime"));
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "SELECT projDiscussId,fullProjId,questionMemberId,questionMemberContent,questionMemberTime,answerMemberId,answerMemberContent,answerMemberTime FROM ProjDiscuss WHERE projDiscussId = ?";
	@Override
	public ProjDiscusBean findByPrimaryKey(int projDiscussId)
	{
		ProjDiscusBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,projDiscussId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ProjDiscusBean();
					result.setProjDiscusId(rset.getInt("projDiscussId"));
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setQuestionMemberId(rset.getInt("questionMemberId"));
					result.setQuestionMemberContent(rset.getString("questionMemberContent"));
					result.setQuestionMemberTime(rset.getTimestamp("questionMemberTime"));
					
					if(rset.getObject("answerMemberId") != null)
					{
						result.setAnswerMemberId(rset.getInt("answerMemberId"));
					}
					else
					{
						result.setAnswerMemberId((Integer)rset.getObject("answerMemberId"));
					}
					
					result.setAnswerMemberContent(rset.getString("answerMemberContent"));
					result.setAnswerMemberTime(rset.getTimestamp("answerMemberTime"));
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

	private static final String INSERT = "INSERT INTO ProjDiscuss (fullProjId,questionMemberId,questionMemberContent,questionMemberTime,answerMemberId,answerMemberContent,answerMemberTime) VALUES (?,?,?,?,?,?,?)";
	@Override
	public ProjDiscusBean insert(ProjDiscusBean bean)
	{
		ProjDiscusBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getQuestionMemberId());
				pstmt.setString(3,bean.getQuestionMemberContent());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getQuestionMemberTime().getTime()));
				
				if(bean.getAnswerMemberId() != null)
				{
					pstmt.setInt(5,bean.getAnswerMemberId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getAnswerMemberContent() != null)
				{
					pstmt.setString(6,bean.getAnswerMemberContent());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				if(bean.getAnswerMemberTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getAnswerMemberTime().getTime()));
				}
				else
				{
					pstmt.setNull(7,Types.TIMESTAMP);
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

	private static final String UPDATE = "UPDATE ProjDiscuss SET fullProjId = ?,questionMemberId = ?,questionMemberContent = ?,questionMemberTime = ?,answerMemberId = ?,answerMemberContent = ?,answerMemberTime = ? WHERE projDiscussId = ?";
	@Override
	public ProjDiscusBean update(ProjDiscusBean bean)
	{
		ProjDiscusBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				pstmt.setInt(2,bean.getQuestionMemberId());
				pstmt.setString(3,bean.getQuestionMemberContent());
				pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getQuestionMemberTime().getTime()));
				
				if(bean.getAnswerMemberId() != null)
				{
					pstmt.setInt(5,bean.getAnswerMemberId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getAnswerMemberContent() != null)
				{
					pstmt.setString(6,bean.getAnswerMemberContent());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				if(bean.getAnswerMemberTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getAnswerMemberTime().getTime()));
				}
				else
				{
					pstmt.setNull(7,Types.TIMESTAMP);
				}
				
				pstmt.setInt(8,bean.getProjDiscusId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getProjDiscusId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	private static final String SELECT_BY_FULLPROJID = "SELECT projDiscussId,fullProjId,questionMemberId,questionMemberContent,questionMemberTime,answerMemberId,answerMemberContent,answerMemberTime FROM ProjDiscuss WHERE fullProjId = ?";
	@Override
	public List<ProjDiscusBean> selectByFullProjId(int fullProjId)
	{
		List<ProjDiscusBean> result = new ArrayList<ProjDiscusBean>();
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_FULLPROJID);)
		{
			pstmt.setInt(1,fullProjId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				while(rset.next())
				{
					ProjDiscusBean bean = new ProjDiscusBean();
					bean.setProjDiscusId(rset.getInt("projDiscussId"));
					bean.setFullProjId(rset.getInt("fullProjId"));
					bean.setQuestionMemberId(rset.getInt("questionMemberId"));
					bean.setQuestionMemberContent(rset.getString("questionMemberContent"));
					bean.setQuestionMemberTime(rset.getTimestamp("questionMemberTime"));
					
					if(rset.getObject("answerMemberId") != null)
					{
						bean.setAnswerMemberId(rset.getInt("answerMemberId"));
					}
					else
					{
						bean.setAnswerMemberId((Integer)rset.getObject("answerMemberId"));
					}
					
					bean.setAnswerMemberContent(rset.getString("answerMemberContent"));
					bean.setAnswerMemberTime(rset.getTimestamp("answerMemberTime"));
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

	private static final String DELETE = "DELETE FROM ProjDiscuss WHERE projDiscussId = ?";
	@Override
	public boolean delete(int projDiscussId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,projDiscussId);
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
		ProjDiscusDAO dao = new ProjDiscusDAOJdbc();
		
		// insert
		ProjDiscusBean bean = new ProjDiscusBean();
		bean.setFullProjId(1);
		bean.setQuestionMemberId(1);
		bean.setQuestionMemberContent("你好 我想問...");
		bean.setQuestionMemberTime(new java.util.Date(System.currentTimeMillis()));
		System.out.println(dao.insert(bean));

		// select pk
		System.out.println(dao.findByPrimaryKey(1));
		
		// select all
		System.out.println(dao.getAll());
		
		// delete
		System.out.println(dao.delete(1));
		
		// 修改
		ProjDiscusBean bean2 = new ProjDiscusBean();
		bean2.setProjDiscusId(3);
		bean2.setFullProjId(1);
		bean2.setQuestionMemberId(1);
		bean2.setQuestionMemberContent("你好 我想問...");
		bean2.setQuestionMemberTime(new java.util.Date(System.currentTimeMillis()));
		bean2.setAnswerMemberId(7);
		bean2.setAnswerMemberContent("是可以的");
		bean2.setAnswerMemberTime(new java.util.Date(System.currentTimeMillis()));
		System.out.println(dao.update(bean2));
	}
}

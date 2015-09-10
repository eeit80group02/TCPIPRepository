package model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.ProjModifyBean;

public class ProjModifyDAOJdbc
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_ALL = "SELECT projModifyId,fullProjId,schoolId,schoolMessage,schoolMessageTime,memberId,memberMessage,memberMessageTime FROM ProjModify";
	public List<ProjModifyBean> getAll()
	{
		List<ProjModifyBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<ProjModifyBean>();
			while(rset.next())
			{
				ProjModifyBean bean = new ProjModifyBean();
				bean.setProjModifyId(rset.getInt("projModifyId"));
				bean.setFullProjId(rset.getInt("fullProjId"));
				
				if(rset.getObject("schoolId") != null)
				{
					bean.setSchoolId(rset.getInt("schoolId"));
				}
				else
				{
					bean.setSchoolId((Integer)rset.getObject("schoolId"));
				}
				
				bean.setSchoolMessage(rset.getString("schoolMessage"));
				bean.setSchoolMessageTime(rset.getTimestamp("schoolMessageTime"));
				
				if(rset.getObject("memberId") != null)
				{
					bean.setMemberId(rset.getInt("memberId"));
				}
				else
				{
					bean.setMemberId((Integer)rset.getObject("memberId"));
				}
				
				bean.setMemberMessage(rset.getString("memberMessage"));
				bean.setMemberMessageTime(rset.getTimestamp("memberMessageTime"));
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "SELECT projModifyId,fullProjId,schoolId,schoolMessage,schoolMessageTime,memberId,memberMessage,memberMessageTime FROM ProjModify WHERE projModifyId = ?";
	public ProjModifyBean findByPrimaryKey(int projModifyId)
	{
		ProjModifyBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,projModifyId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new ProjModifyBean();
					result.setProjModifyId(rset.getInt("projModifyId"));
					result.setFullProjId(rset.getInt("fullProjId"));
					
					if(rset.getObject("schoolId") != null)
					{
						result.setSchoolId(rset.getInt("schoolId"));
					}
					else
					{
						result.setSchoolId((Integer)rset.getObject("schoolId"));
					}
					
					result.setSchoolMessage(rset.getString("schoolMessage"));
					result.setSchoolMessageTime(rset.getTimestamp("schoolMessageTime"));
					
					if(rset.getObject("memberId") != null)
					{
						result.setMemberId(rset.getInt("memberId"));
					}
					else
					{
						result.setMemberId((Integer)rset.getObject("memberId"));
					}
					
					result.setMemberMessage(rset.getString("memberMessage"));
					result.setMemberMessageTime(rset.getTimestamp("memberMessageTime"));
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

	private static final String INSERT = "INSERT INTO ProjModify (fullProjId,schoolId,schoolMessage,schoolMessageTime,memberId,memberMessage,memberMessageTime) VALUES (?,?,?,?,?,?,?)";
	public ProjModifyBean insert(ProjModifyBean bean)
	{
		ProjModifyBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				
				if(bean.getSchoolId() != null)
				{
					pstmt.setInt(2,bean.getSchoolId());
				}
				else
				{
					pstmt.setNull(2,Types.INTEGER);
				}
				
				if(bean.getSchoolMessage() != null)
				{
					pstmt.setString(3,bean.getSchoolMessage());
				}
				else
				{
					pstmt.setNull(3,Types.NVARCHAR);
				}
				
				if(bean.getSchoolMessageTime() != null)
				{
					pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getSchoolMessageTime().getTime()));
				}
				else
				{
					pstmt.setNull(4,Types.TIMESTAMP);
				}
				
				if(bean.getMemberId() != null)
				{
					pstmt.setInt(5,bean.getMemberId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getMemberMessage() != null)
				{
					pstmt.setString(6,bean.getMemberMessage());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				
				if(bean.getMemberMessageTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getMemberMessageTime().getTime()));
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

	private static final String UPDATE = "UPDATE ProjModify SET fullProjId = ?,schoolId = ?,schoolMessage = ?,schoolMessageTime = ?,memberId = ?,memberMessage = ?,memberMessageTime = ? WHERE projModifyId = ?";
	public ProjModifyBean update(ProjModifyBean bean)
	{
		ProjModifyBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getFullProjId());
				
				if(bean.getSchoolId() != null)
				{
					pstmt.setInt(2,bean.getSchoolId());
				}
				else
				{
					pstmt.setNull(2,Types.INTEGER);
				}
				
				if(bean.getSchoolMessage() != null)
				{
					pstmt.setString(3,bean.getSchoolMessage());
				}
				else
				{
					pstmt.setNull(3,Types.NVARCHAR);
				}
				
				if(bean.getSchoolMessageTime() != null)
				{
					pstmt.setTimestamp(4,new java.sql.Timestamp(bean.getSchoolMessageTime().getTime()));
				}
				else
				{
					pstmt.setNull(4,Types.TIMESTAMP);
				}
				
				if(bean.getMemberId() != null)
				{
					pstmt.setInt(5,bean.getMemberId());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}
				
				if(bean.getMemberMessage() != null)
				{
					pstmt.setString(6,bean.getMemberMessage());
				}
				else
				{
					pstmt.setNull(6,Types.NVARCHAR);
				}
				
				if(bean.getMemberMessageTime() != null)
				{
					pstmt.setTimestamp(7,new java.sql.Timestamp(bean.getMemberMessageTime().getTime()));
				}
				else
				{
					pstmt.setNull(7,Types.TIMESTAMP);
				}
				
				pstmt.setInt(8,bean.getProjModifyId());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getProjModifyId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM ProjModify WHERE projModifyId = ?";
	public boolean delete(int projModifyId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,projModifyId);
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
		ProjModifyDAOJdbc dao = new ProjModifyDAOJdbc();
		
		// insert
//		ProjModifyBean bean1 = new ProjModifyBean();
//		ProjModifyBean bean2 = new ProjModifyBean();
//		bean1.setFullProjId(1);
//		bean1.setMemberId(7);
//		bean1.setMemberMessage("那個建議改XX");
//		bean1.setMemberMessageTime(new java.util.Date(System.currentTimeMillis()));
//		
//		bean2.setFullProjId(1);
//		bean2.setSchoolId(11601);
//		bean2.setSchoolMessage("Ok 不是問題");
//		bean2.setSchoolMessageTime(new java.util.Date(System.currentTimeMillis()));
//		System.out.println(dao.insert(bean1));
//		System.out.println(dao.insert(bean2));
		
		// select pk
		System.out.println(dao.findByPrimaryKey(1));
		
		// select
		System.out.println(dao.getAll());
		
		// delete
		System.out.println(dao.delete(1));
		
		// update
		ProjModifyBean bean3 = new ProjModifyBean();
		bean3.setProjModifyId(3);
		bean3.setFullProjId(1);
		bean3.setSchoolId(11601);
		bean3.setSchoolMessage("不是問題");
		bean3.setSchoolMessageTime(new java.util.Date(System.currentTimeMillis()));
		System.out.println(dao.update(bean3));
		
		
		

	}
}

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

import model.SchoolDemandBean;

public class SchoolDemandDAOJdbc
{
	private DataSource datasource;

	public SchoolDemandDAOJdbc()
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
	
	private static final String SELECT_BY_ID = "SELECT schoolDemandId,schoolId,participant,activityTopic,activityLocation,activitySuitable,activityHost,activityContact,createDate,content,demandStatus FROM SchoolDemand WHERE schoolDemandId = ?";
	public SchoolDemandBean findByPrimaryKey(int schoolDemandId)
	{
		SchoolDemandBean result = null;

		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,schoolDemandId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new SchoolDemandBean();
					result.setSchoolDemandId(rset.getInt("schoolDemandId"));
					result.setSchoolId(rset.getInt("schoolId"));
					result.setParticipant(rset.getInt("participant"));
					result.setActivityTopic(rset.getString("activityTopic"));
					result.setActivityLocation(rset.getString("activityLocation"));
					result.setActivitySuitable(rset.getString("activitySuitable"));
					result.setActivityHost(rset.getString("activityHost"));
					result.setActivityContact(rset.getString("activityContact"));
					result.setCreateDate(rset.getTimestamp("createDate"));
					result.setContent(rset.getString("content"));
					result.setDemandStatus(rset.getString("demandStatus"));
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

	private static final String SELECT_ALL = "SELECT schoolDemandId,schoolId,participant,activityTopic,activityLocation,activitySuitable,activityHost,activityContact,createDate,content,demandStatus FROM SchoolDemand";
	public List<SchoolDemandBean> getAll()
	{
		List<SchoolDemandBean> result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<SchoolDemandBean>();
			while(rset.next())
			{
				SchoolDemandBean bean = new SchoolDemandBean();
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setParticipant(rset.getInt("participant"));
				bean.setActivityTopic(rset.getString("activityTopic"));
				bean.setActivityLocation(rset.getString("activityLocation"));
				bean.setActivitySuitable(rset.getString("activitySuitable"));
				bean.setActivityHost(rset.getString("activityHost"));
				bean.setActivityContact(rset.getString("activityContact"));
				bean.setCreateDate(rset.getTimestamp("createDate"));
				bean.setContent(rset.getString("content"));
				bean.setDemandStatus(rset.getString("demandStatus"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "INSERT INTO schooldemand (schoolId,participant,activityTopic,activityLocation,activitySuitable,activityHost,activityContact,createDate,content,demandStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
	public SchoolDemandBean insert(SchoolDemandBean bean)
	{
		SchoolDemandBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setInt(2,bean.getParticipant());
				pstmt.setString(3,bean.getActivityTopic());
				pstmt.setString(4,bean.getActivityLocation());
				pstmt.setString(5,bean.getActivitySuitable());
				pstmt.setString(6,bean.getActivityHost());
				pstmt.setString(7,bean.getActivityContact());
				pstmt.setTimestamp(8,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				pstmt.setString(9,bean.getContent());
				pstmt.setString(10,bean.getDemandStatus());

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

	private static final String UPDATE = "UPDATE Schooldemand SET schoolId = ?,participant = ?,activityTopic = ?,activityLocation = ?,activitySuitable = ?,activityHost = ?,activityContact = ?,createDate = ?,content = ?,demandStatus = ? WHERE schoolDemandId = ?";
	public SchoolDemandBean update(SchoolDemandBean bean)
	{
		SchoolDemandBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setInt(2,bean.getParticipant());
				pstmt.setString(3,bean.getActivityTopic());
				pstmt.setString(4,bean.getActivityLocation());
				pstmt.setString(5,bean.getActivitySuitable());
				pstmt.setString(6,bean.getActivityHost());
				pstmt.setString(7,bean.getActivityContact());
				pstmt.setTimestamp(8,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				pstmt.setString(9,bean.getContent());
				pstmt.setString(10,bean.getDemandStatus());
				pstmt.setInt(11,bean.getSchoolDemandId());

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

	private static final String DELETE = "DELETE FROM schooldemand WHERE schoolDemandId = ?";
	public boolean delete(int schoolDemandId)
	{
		try(Connection conn = datasource.getConnection();
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
		SchoolDemandDAOJdbc dao = new SchoolDemandDAOJdbc();
//		List<SchoolDemandBean> beans = dao.getAll();
//		System.out.println(beans);
//		SchoolDemandBean bean = dao.findByPrimaryKey(1);
//		System.out.println(bean);

//		SchoolDemandBean bean1 = new SchoolDemandBean();
//		bean1.setSchoolId(11503);
//		bean1.setParticipant(20);
//		bean1.setActivityTopic("偏鄉教育計劃");
//		bean1.setActivityLocation("高雄學校");
//		bean1.setActivitySuitable("具有熱誠的志工");
//		bean1.setActivityHost("田園老師");
//		bean1.setActivityContact("66316666");
//		bean1.setCreateDate(new java.util.Date(System.currentTimeMillis()));
//		bean1.setContent("一千字需求內容");
//		bean1.setDemandStatus("待洽談");
//		System.out.println(dao.insert(bean1));
		
//		System.out.println(dao.delete(1));
		
		SchoolDemandBean bean2 = new SchoolDemandBean();
		bean2.setSchoolDemandId(2);
		bean2.setSchoolId(11503);
		bean2.setParticipant(33);
		bean2.setActivityTopic("偏鄉教計劃");
		bean2.setActivityLocation("高學校");
		bean2.setActivitySuitable("具有志工");
		bean2.setActivityHost("老師");
		bean2.setActivityContact("6666");
		bean2.setCreateDate(new java.util.Date(System.currentTimeMillis()));
		bean2.setContent("一內容");
		bean2.setDemandStatus("洽談");
		
		System.out.println(dao.update(bean2));
	}
}

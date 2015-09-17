package model.dao;

import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.FullProjBean;
import model.dao.interfaces.FullProjDAO;

public class FullProjDAOJdbc implements FullProjDAO
{
	private DataSource datasource;

	public FullProjDAOJdbc()
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
	
	private static final String SELECT_ALL = "SELECT fullProjId,primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm FROM FullProj";
	@Override
	public List<FullProjBean> getAll()
	{
		List<FullProjBean> result = null;
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<FullProjBean>();
			while(rset.next())
			{
				FullProjBean bean = new FullProjBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setPrimaryProjId(rset.getInt("primaryProjId"));
				
				if(rset.getObject("schoolDemandId") != null)
				{
					bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				}
				else
				{
					bean.setSchoolDemandId((Integer)rset.getObject("schoolDemandId"));
				}
				
				if(rset.getObject("memberId") != null)
				{
					bean.setMemberId(rset.getInt("memberId"));
				}
				else
				{
					bean.setMemberId((Integer)rset.getObject("memberId"));
				}
				
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setTitle(rset.getString("title"));
				bean.setFrontCoverName(rset.getString("frontCoverName"));
				bean.setFrontCover(rset.getBytes("frontCover"));
				bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
				bean.setProjAbstract(rset.getString("projAbstract"));
				bean.setContent(rset.getString("content"));
				bean.setLocation(rset.getString("location"));
				bean.setActivityStartTime(rset.getTimestamp("activityStartTime"));
				bean.setActivityEndTime(rset.getTimestamp("activityEndTime"));
				bean.setEstMember(rset.getInt("estMember"));
				bean.setBudget(rset.getInt("budget"));
				bean.setCreateDate(rset.getTimestamp("createDate"));
				bean.setProjStatus(rset.getString("projStatus"));
				bean.setOrgArchitecture(rset.getString("orgArchitecture"));
				bean.setProjFileName(rset.getString("projFileName"));
				bean.setProjFile(rset.getBytes("projFile"));
				
				if(rset.getObject("projFileLength") != null)
				{
					bean.setProjFileLength(rset.getLong("projFileLength"));
				}
				else
				{
					bean.setProjFileLength((Long)rset.getObject("projFileLength"));
				}
				
				if(rset.getObject("reviews") != null)
				{
					bean.setReviews(rset.getInt("reviews"));
				}
				else
				{
					bean.setReviews((Integer)rset.getObject("reviews"));
				}
				
				bean.setReviewsContent(rset.getString("reviewsContent"));
				
				if(rset.getObject("schoolConfirm") != null)
				{
					bean.setSchoolConfirm(rset.getBoolean("schoolConfirm"));
				}
				else
				{
					bean.setSchoolConfirm((Boolean)rset.getObject("schoolConfirm"));
				}
				
				if(rset.getObject("memberConfirm") != null)
				{
					bean.setMemberConfirm(rset.getBoolean("memberConfirm"));
				}
				else
				{
					bean.setMemberConfirm((Boolean)rset.getObject("memberConfirm"));
				}
				
				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "SELECT fullProjId,primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm FROM FullProj WHERE fullProjId = ?";
	@Override
	public FullProjBean findByPrimaryKey(int fullProjId)
	{
		FullProjBean result = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,fullProjId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new FullProjBean();
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setPrimaryProjId(rset.getInt("primaryProjId"));
					
					if(rset.getObject("schoolDemandId") != null)
					{
						result.setSchoolDemandId(rset.getInt("schoolDemandId"));
					}
					else
					{
						result.setSchoolDemandId((Integer)rset.getObject("schoolDemandId"));
					}
					
					if(rset.getObject("memberId") != null)
					{
						result.setMemberId(rset.getInt("memberId"));
					}
					else
					{
						result.setMemberId((Integer)rset.getObject("memberId"));
					}
					
					result.setSchoolId(rset.getInt("schoolId"));
					result.setTitle(rset.getString("title"));
					result.setFrontCoverName(rset.getString("frontCoverName"));
					result.setFrontCover(rset.getBytes("frontCover"));
					result.setFrontCoverLength(rset.getLong("frontCoverLength"));
					result.setProjAbstract(rset.getString("projAbstract"));
					result.setContent(rset.getString("content"));
					result.setLocation(rset.getString("location"));
					result.setActivityStartTime(rset.getTimestamp("activityStartTime"));
					result.setActivityEndTime(rset.getTimestamp("activityEndTime"));
					result.setEstMember(rset.getInt("estMember"));
					result.setBudget(rset.getInt("budget"));
					result.setCreateDate(rset.getTimestamp("createDate"));
					result.setProjStatus(rset.getString("projStatus"));
					result.setOrgArchitecture(rset.getString("orgArchitecture"));
					result.setProjFileName(rset.getString("projFileName"));
					result.setProjFile(rset.getBytes("projFile"));
					
					if(rset.getObject("projFileLength") != null)
					{
						result.setProjFileLength(rset.getLong("projFileLength"));
					}
					else
					{
						result.setProjFileLength((Long)rset.getObject("projFileLength"));
					}
					
					if(rset.getObject("reviews") != null)
					{
						result.setReviews(rset.getInt("reviews"));
					}
					else
					{
						result.setReviews((Integer)rset.getObject("reviews"));
					}
					
					result.setReviewsContent(rset.getString("reviewsContent"));
					
					if(rset.getObject("schoolConfirm") != null)
					{
						result.setSchoolConfirm(rset.getBoolean("schoolConfirm"));
					}
					else
					{
						result.setSchoolConfirm((Boolean)rset.getObject("schoolConfirm"));
					}
					
					if(rset.getObject("memberConfirm") != null)
					{
						result.setMemberConfirm(rset.getBoolean("memberConfirm"));
					}
					else
					{
						result.setMemberConfirm((Boolean)rset.getObject("memberConfirm"));
					}
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

	private static final String INSERT = "INSERT INTO FullProj (primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public FullProjBean insert(FullProjBean bean)
	{
		FullProjBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				if(bean.getPrimaryProjId() != null)
				{
					pstmt.setInt(1,bean.getPrimaryProjId());
				}
				else
				{
					pstmt.setNull(1,Types.INTEGER);
				}
				
				if(bean.getSchoolDemandId() != null)
				{
					pstmt.setInt(2,bean.getSchoolDemandId());
				}
				else
				{
					pstmt.setNull(2,Types.INTEGER);
				}
				pstmt.setInt(3,bean.getMemberId());
				pstmt.setInt(4,bean.getSchoolId());
				pstmt.setString(5,bean.getTitle());
				pstmt.setString(6,bean.getFrontCoverName());
				pstmt.setBytes(7,bean.getFrontCover());
				pstmt.setLong(8,bean.getFrontCoverLength());
				pstmt.setString(9,bean.getProjAbstract());
				pstmt.setString(10,bean.getContent());
				
				if(bean.getLocation() != null)
				{
					pstmt.setString(11,bean.getLocation());
				}
				else
				{
					pstmt.setNull(11,Types.NVARCHAR);
				}
				
				pstmt.setTimestamp(12,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setInt(14,bean.getEstMember());
				pstmt.setInt(15,bean.getBudget());
				
				if(bean.getCreateDate() != null)
				{
					pstmt.setTimestamp(16,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				}
				else
				{
					pstmt.setNull(16,Types.TIMESTAMP);
				}
				
				pstmt.setString(17,bean.getProjStatus());
				
				if(bean.getOrgArchitecture() != null)
				{
					pstmt.setString(18,bean.getOrgArchitecture());
				}
				else
				{
					pstmt.setNull(18,Types.NVARCHAR);
				}
				
				if(bean.getProjFileName() != null)
				{
					pstmt.setString(19,bean.getProjFileName());
				}
				else
				{
					pstmt.setNull(19,Types.NVARCHAR);
				}
				
				if(bean.getProjFile() != null)
				{
					pstmt.setBytes(20,bean.getProjFile());
				}
				else
				{
					pstmt.setNull(20,Types.VARBINARY);
				}
				
				if(bean.getProjFileLength() != null)
				{
					pstmt.setLong(21,bean.getProjFileLength());
				}
				else
				{
					pstmt.setNull(21,Types.BIGINT);
				}
				
				if(bean.getReviews() != null)
				{
					pstmt.setInt(22,bean.getReviews());
				}
				else
				{
					pstmt.setNull(22,Types.INTEGER);
				}
				
				if(bean.getReviewsContent() != null)
				{
					pstmt.setString(23,bean.getReviewsContent());
				}
				else
				{
					pstmt.setNull(23,Types.NVARCHAR);
				}
				
				if(bean.getSchoolConfirm() != null)
				{
					pstmt.setBoolean(24,bean.getSchoolConfirm());
				}
				else
				{
					pstmt.setNull(24,Types.NVARCHAR);
				}
				
				if(bean.getMemberConfirm() != null)
				{
					pstmt.setBoolean(25,bean.getMemberConfirm());
				}
				else
				{
					pstmt.setNull(25,Types.NVARCHAR);
				}
				
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = this.findByPrimaryKey(key.getInt(1));
						}
					}
					catch(SQLException e)
					{
						e.printStackTrace();
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

	private static final String UPDATE = "UPDATE FullProj SET primaryProjId = ?,schoolDemandId = ?,memberId = ?,schoolId = ?,title = ?,frontCoverName = ?,frontCover = ?,frontCoverLength = ?,projAbstract = ?,content = ?,location = ?,activityStartTime = ?,activityEndTime = ?,estMember = ?,budget = ?,createDate = ?,projStatus = ?,orgArchitecture = ?,projFileName = ?,projFile = ?,projFileLength = ?,reviews = ?,reviewsContent = ?,schoolConfirm = ?,memberConfirm = ? WHERE fullProjId = ?";
	@Override
	public FullProjBean update(FullProjBean bean)
	{
		FullProjBean result = null;
		if(bean != null)
		{
			try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				if(bean.getPrimaryProjId() != null)
				{
					pstmt.setInt(1,bean.getPrimaryProjId());
				}
				else
				{
					pstmt.setNull(1,Types.INTEGER);
				}
				
				if(bean.getSchoolDemandId() != null)
				{
					pstmt.setInt(2,bean.getSchoolDemandId());
				}
				else
				{
					pstmt.setNull(2,Types.INTEGER);
				}
				pstmt.setInt(3,bean.getMemberId());
				pstmt.setInt(4,bean.getSchoolId());
				pstmt.setString(5,bean.getTitle());
				pstmt.setString(6,bean.getFrontCoverName());
				pstmt.setBytes(7,bean.getFrontCover());
				pstmt.setLong(8,bean.getFrontCoverLength());
				pstmt.setString(9,bean.getProjAbstract());
				pstmt.setString(10,bean.getContent());
				
				if(bean.getLocation() != null)
				{
					pstmt.setString(11,bean.getLocation());
				}
				else
				{
					pstmt.setNull(11,Types.NVARCHAR);
				}
				
				pstmt.setTimestamp(12,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setInt(14,bean.getEstMember());
				pstmt.setInt(15,bean.getBudget());
				
				if(bean.getCreateDate() != null)
				{
					pstmt.setTimestamp(16,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				}
				else
				{
					pstmt.setNull(16,Types.TIMESTAMP);
				}
				
				pstmt.setString(17,bean.getProjStatus());
				
				if(bean.getOrgArchitecture() != null)
				{
					pstmt.setString(18,bean.getOrgArchitecture());
				}
				else
				{
					pstmt.setNull(18,Types.NVARCHAR);
				}
				
				if(bean.getProjFileName() != null)
				{
					pstmt.setString(19,bean.getProjFileName());
				}
				else
				{
					pstmt.setNull(19,Types.NVARCHAR);
				}
				
				if(bean.getProjFile() != null)
				{
					pstmt.setBytes(20,bean.getProjFile());
				}
				else
				{
					pstmt.setNull(20,Types.VARBINARY);
				}
				
				if(bean.getProjFileLength() != null)
				{
					pstmt.setLong(21,bean.getProjFileLength());
				}
				else
				{
					pstmt.setNull(21,Types.BIGINT);
				}
				
				if(bean.getReviews() != null)
				{
					pstmt.setInt(22,bean.getReviews());
				}
				else
				{
					pstmt.setNull(22,Types.INTEGER);
				}
				
				if(bean.getReviewsContent() != null)
				{
					pstmt.setString(23,bean.getReviewsContent());
				}
				else
				{
					pstmt.setNull(23,Types.NVARCHAR);
				}
				
				if(bean.getSchoolConfirm() != null)
				{
					pstmt.setBoolean(24,bean.getSchoolConfirm());
				}
				else
				{
					pstmt.setNull(24,Types.NVARCHAR);
				}
				
				if(bean.getMemberConfirm() != null)
				{
					pstmt.setBoolean(25,bean.getMemberConfirm());
				}
				else
				{
					pstmt.setNull(25,Types.NVARCHAR);
				}
				
				pstmt.setInt(26,bean.getFullProjId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getFullProjId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM FullProj WHERE fullProjId = ?";
	@Override
	public boolean delete(int fullProjId)
	{
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,fullProjId);
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

	private static final String SELECT_BY_MEMBERID = "SELECT fullProjId,primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm FROM FullProj WHERE memberId = ?";
	@Override
	public List<FullProjBean> selectByMemberId(int memberId)
	{
		List<FullProjBean> result = new ArrayList<FullProjBean>();
		FullProjBean bean = null;
		
		try(Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_MEMBERID);)
		{
			pstmt.setInt(1,memberId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				while(rset.next())
				{
					bean = new FullProjBean();
					bean.setFullProjId(rset.getInt("fullProjId"));
					bean.setPrimaryProjId(rset.getInt("primaryProjId"));
					
					if(rset.getObject("schoolDemandId") != null)
					{
						bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
					}
					else
					{
						bean.setSchoolDemandId((Integer)rset.getObject("schoolDemandId"));
					}
					
					if(rset.getObject("memberId") != null)
					{
						bean.setMemberId(rset.getInt("memberId"));
					}
					else
					{
						bean.setMemberId((Integer)rset.getObject("memberId"));
					}
					
					bean.setSchoolId(rset.getInt("schoolId"));
					bean.setTitle(rset.getString("title"));
					bean.setFrontCoverName(rset.getString("frontCoverName"));
					bean.setFrontCover(rset.getBytes("frontCover"));
					bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
					bean.setProjAbstract(rset.getString("projAbstract"));
					bean.setContent(rset.getString("content"));
					bean.setLocation(rset.getString("location"));
					bean.setActivityStartTime(rset.getTimestamp("activityStartTime"));
					bean.setActivityEndTime(rset.getTimestamp("activityEndTime"));
					bean.setEstMember(rset.getInt("estMember"));
					bean.setBudget(rset.getInt("budget"));
					bean.setCreateDate(rset.getTimestamp("createDate"));
					bean.setProjStatus(rset.getString("projStatus"));
					bean.setOrgArchitecture(rset.getString("orgArchitecture"));
					bean.setProjFileName(rset.getString("projFileName"));
					bean.setProjFile(rset.getBytes("projFile"));
					
					if(rset.getObject("projFileLength") != null)
					{
						bean.setProjFileLength(rset.getLong("projFileLength"));
					}
					else
					{
						bean.setProjFileLength((Long)rset.getObject("projFileLength"));
					}
					
					if(rset.getObject("reviews") != null)
					{
						bean.setReviews(rset.getInt("reviews"));
					}
					else
					{
						bean.setReviews((Integer)rset.getObject("reviews"));
					}
					
					bean.setReviewsContent(rset.getString("reviewsContent"));
					
					if(rset.getObject("schoolConfirm") != null)
					{
						bean.setSchoolConfirm(rset.getBoolean("schoolConfirm"));
					}
					else
					{
						bean.setSchoolConfirm((Boolean)rset.getObject("schoolConfirm"));
					}
					
					if(rset.getObject("memberConfirm") != null)
					{
						bean.setMemberConfirm(rset.getBoolean("memberConfirm"));
					}
					else
					{
						bean.setMemberConfirm((Boolean)rset.getObject("memberConfirm"));
					}
					
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

	public static void main(String[] args)
	{
		FullProjDAO jdbc = new FullProjDAOJdbc();
		FullProjBean bean = new FullProjBean();
//		bean.setFullProjId(4);
		bean.setPrimaryProjId(1);
		bean.setMemberId(1);
		bean.setSchoolId(11503);
		bean.setTitle("神之計畫");
		
		File file = new File("image/primaryProj/primaryProj01.jpg");
		try(FileInputStream fis = new FileInputStream(file);)
		{
			bean.setFrontCoverName(file.getName());
			bean.setFrontCover(GlobalService.convertInputStreamToByteArray(fis));
			bean.setFrontCoverLength(file.length());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		bean.setProjAbstract("hahahaha神來也");
		bean.setContent("神道此一遊");
		bean.setLocation(null);
		try
		{
			bean.setActivityStartTime(GlobalService.convertStringToDate("2015-08-08"));
			bean.setActivityEndTime(GlobalService.convertStringToDate("2015-08-20"));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		bean.setEstMember(20);
		bean.setBudget(90000);
		bean.setCreateDate(null);
		bean.setProjStatus("洽談中");
		bean.setOrgArchitecture(null);
		bean.setProjFileName(null);
		bean.setProjFile(null);
		bean.setProjFileLength(null);
		bean.setReviews(null);
		bean.setReviewsContent(null);
		bean.setSchoolConfirm(null);
		bean.setMemberConfirm(null);
		
//		bean.setPrimaryProjId(1);
//		bean.setMemberId(1);
//		bean.setSchoolId(11503);
//		bean.setTitle("神之計畫");
//		
//		File file = new File("image/primaryProj/primaryProj01.jpg");
//		try(FileInputStream fis = new FileInputStream(file);)
//		{
//			bean.setFrontCoverName(file.getName());
//			bean.setFrontCover(GlobalService.convertInputStreamToByteArray(fis));
//			bean.setFrontCoverLength(file.length());
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		bean.setProjAbstract("hahahaha神來也");
//		bean.setContent("神道此一遊");
//		bean.setLocation("高雄");
//		bean.setActivityStartTime(GlobalService.convertStringToDate("2015-08-08"));
//		bean.setActivityEndTime(GlobalService.convertStringToDate("2015-08-20"));
//		bean.setEstMember(20);
//		bean.setBudget(90000);
//		bean.setCreateDate(new java.util.Date(System.currentTimeMillis()));
//		bean.setProjStatus("洽談中");
//		bean.setOrgArchitecture("活動 激動");
//		
//		file = new File("image/primaryProj/primaryProj02.jpg");
//		try(FileInputStream fis = new FileInputStream(file);)
//		{
//			bean.setProjFileName(file.getName());
//			bean.setProjFile(GlobalService.convertInputStreamToByteArray(fis));
//			bean.setProjFileLength(file.length());
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//
//		bean.setReviews(0);
//		bean.setReviewsContent("很爛");
//		bean.setSchoolConfirm(true);
//		bean.setMemberConfirm(false);
		
//		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.update(bean));
//		byte[] b = {1,2,3};
//		System.out.println(jdbc.update(1,2,1,999999,"嘿嘿嘿",null,b,111,null,null,null,null,null,0,0,null,null,null,null,b,0,0,1,null,null,null,17));
//		System.out.println(jdbc.delete(1));
//		System.out.println(jdbc.getAll());
//		System.out.println(jdbc.findByPrimaryKey(1));
	}
}

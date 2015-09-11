package model.dao;

/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 20:41
 * 
 */
import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PrimaryProjBean;
import model.dao.interfaces.PrimaryProjDAO;

public class PrimaryProjDAOJdbc implements PrimaryProjDAO
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	// Select by ID
	private static final String SELECT_BY_ID = "SELECT primaryProjId,memberId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus FROM PrimaryProj WHERE primaryProjId = ?";

	@Override
	public PrimaryProjBean findByPrimaryKey(int primaryProjId)
	{
		PrimaryProjBean result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,primaryProjId);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				if(rset.next())
				{
					result = new PrimaryProjBean();
					result.setPrimaryProjId(rset.getInt("primaryProjId"));
					result.setMemberId(rset.getInt("memberId"));
					result.setTitle(rset.getString("title"));
					result.setFrontCoverName(rset.getString("frontCoverName"));
					result.setFrontCover(rset.getBytes("frontCover"));
					result.setFrontCoverLength(rset.getLong("frontCoverLength"));
					result.setProjAbstract(rset.getString("projAbstract"));
					result.setContent(rset.getString("content"));
					result.setIdealPlace(rset.getString("idealPlace"));
					result.setActivityStartTime(rset.getTimestamp("activityStartTime"));
					result.setActivityEndTime(rset.getTimestamp("activityEndTime"));
					result.setDemandNum(rset.getInt("demandNum"));
					result.setBudget(rset.getInt("budget"));
					result.setCreateDate(rset.getTimestamp("createDate"));
					result.setProjStatus(rset.getString("projStatus"));
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

	// Select ALL ----->getAll(){}
	private static final String SELECT_ALL = "SELECT primaryProjId,memberId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus FROM PrimaryProj";

	@Override
	public List<PrimaryProjBean> getAll()
	{
		List<PrimaryProjBean> result = null;

		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<PrimaryProjBean>();
			while(rset.next())
			{
				PrimaryProjBean bean = new PrimaryProjBean();
				bean.setPrimaryProjId(rset.getInt("primaryProjId"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setTitle(rset.getString("title"));
				bean.setFrontCoverName(rset.getString("frontCoverName"));
				bean.setFrontCover(rset.getBytes("frontCover"));
				bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
				bean.setProjAbstract(rset.getString("projAbstract"));
				bean.setContent(rset.getString("content"));
				bean.setIdealPlace(rset.getString("idealPlace"));
				bean.setActivityStartTime(rset.getTimestamp("activityStartTime"));
				bean.setActivityEndTime(rset.getTimestamp("activityEndTime"));
				bean.setDemandNum(rset.getInt("demandNum"));
				bean.setBudget(rset.getInt("budget"));
				bean.setCreateDate(rset.getTimestamp("createDate"));
				bean.setProjStatus(rset.getString("projStatus"));

				result.add(bean);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	// 新增 --------> insert(){}
	private static final String INSERT = "INSERT INTO PrimaryProj(memberId,title,frontCoverName,frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public PrimaryProjBean insert(PrimaryProjBean bean)
	{
		PrimaryProjBean result = null;
		
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);)
			{
				// pstmt.setInt(1, bean.getPrimaryProjId());
				pstmt.setInt(1,bean.getMemberId());
				pstmt.setString(2,bean.getTitle());
				pstmt.setString(3,bean.getFrontCoverName());
				pstmt.setBytes(4,bean.getFrontCover());
				pstmt.setLong(5,bean.getFrontCoverLength());
				pstmt.setString(6,bean.getProjAbstract());
				pstmt.setString(7,bean.getContent());
				pstmt.setString(8,bean.getIdealPlace());
				pstmt.setTimestamp(9,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(10,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setInt(11,bean.getDemandNum());
				pstmt.setInt(12,bean.getBudget());
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				pstmt.setString(14,bean.getProjStatus());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					try(ResultSet key = pstmt.getGeneratedKeys();)
					{
						if(key.next())
						{
							result = findByPrimaryKey(key.getInt(1));
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

	// 修改 -------->update(){}
	private static final String UPDATE = "UPDATE PrimaryProj SET memberId = ?,title = ?,frontCoverName = ?,frontCover = ?,frontCoverLength = ?,projAbstract = ?, content=?,idealPlace = ?,activityStartTime = ?,activityEndTime = ?,demandNum = ?,budget = ?,createDate = ?,projStatus = ? WHERE primaryProjId = ?";
	@Override
	public PrimaryProjBean update(PrimaryProjBean bean)
	{
		PrimaryProjBean result = null;

		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				pstmt.setInt(1,bean.getMemberId());
				pstmt.setString(2,bean.getTitle());
				pstmt.setString(3,bean.getFrontCoverName());
				pstmt.setBytes(4,bean.getFrontCover());
				pstmt.setLong(5,bean.getFrontCoverLength());
				pstmt.setString(6,bean.getProjAbstract());
				pstmt.setString(7,bean.getContent());
				pstmt.setString(8,bean.getIdealPlace());
				pstmt.setTimestamp(9,new java.sql.Timestamp(bean.getActivityStartTime().getTime()));
				pstmt.setTimestamp(10,new java.sql.Timestamp(bean.getActivityEndTime().getTime()));
				pstmt.setInt(11,bean.getDemandNum());
				pstmt.setInt(12,bean.getBudget());
				pstmt.setTimestamp(13,new java.sql.Timestamp(bean.getCreateDate().getTime()));
				pstmt.setString(14,bean.getProjStatus());
				pstmt.setInt(15,bean.getPrimaryProjId());

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getPrimaryProjId());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	// 刪除 ------> delete(){}
	private static final String DELETE = "DELETE FROM PrimaryProj WHERE primaryProjId = ?";
	@Override
	public boolean delete(int primaryProjId)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,primaryProjId);
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

	public static void main(String[] args) throws Exception
	{
		PrimaryProjDAO dao = new PrimaryProjDAOJdbc();
		// findByPrimaryKey
//		PrimaryProjBean bean = dao.findByPrimaryKey(1);
//		System.out.println(bean);

		// select All for Test 查詢全部
//		List<PrimaryProjBean> beans = dao.getAll();
//		for(PrimaryProjBean b : beans)
//		{
//			System.out.println(b);
//		}

		// insert 新增
		PrimaryProjBean bean1 = new PrimaryProjBean();
//		bean1.setPrimaryProjId(2); //資料庫有設計IDENTITY(1,1)所以這行不用加
		bean1.setMemberId(6);
		bean1.setTitle("餐餐都有麥當當");
		File file = new File("image/primaryProj/primaryProj01.jpg");
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
		bean1.setProjAbstract("摘要（Abstract）又稱文摘或提要。它是以簡明扼要的文句，將某種文獻的主要內容，正確無誤地摘錄出來，使讀者於最短的時間內，得知原著的大意。");
		bean1.setContent("初步計畫的內文檔案內容會比摘要多很多.......");
		bean1.setIdealPlace("新竹尖石鄉");
		bean1.setActivityStartTime(GlobalService.convertStringToDate("2015-10-10"));
		bean1.setActivityEndTime(GlobalService.convertStringToDate("2015-10-17"));
		bean1.setDemandNum(30);
		bean1.setBudget(20000);
		bean1.setCreateDate(new java.util.Date(System.currentTimeMillis()));
		bean1.setProjStatus("洽談失敗");
		System.out.println(dao.insert(bean1));

		// update 更新
		PrimaryProjBean bean2 = new PrimaryProjBean();
		bean2.setPrimaryProjId(2);
		bean2.setMemberId(6);
		bean2.setTitle("餐餐都肯德基");
		file = new File("image/primaryProj/primaryProj01.jpg");
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
		bean2.setProjAbstract("摘要（Abstract）又稱文摘或提要。它是以簡明扼要的文句，將某種文獻的主要內容，正確無誤地摘錄出來，使讀者於最短的時間內，得知原著的大意。");
		bean2.setContent("初步計畫的內文檔案內容會比摘要多很多.......");
		bean2.setIdealPlace("新竹尖石鄉");
		bean2.setActivityStartTime(GlobalService.convertStringToDate("2015-10-10"));
		bean2.setActivityEndTime(GlobalService.convertStringToDate("2015-10-17"));
		bean2.setDemandNum(30);
		bean2.setBudget(20000);
		bean2.setCreateDate(new java.util.Date(System.currentTimeMillis()));
		bean2.setProjStatus("洽談失敗");
		System.out.println(dao.update(bean2));
		
		System.out.println(dao.delete(4));

	}

}

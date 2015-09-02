package model.dao;
/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 20:41
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ParticipatorBean;
import model.PrimaryProjBean;

public class PrimaryProjDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	//Select by ID
	private static final String SELECT_BY_ID =
			"select * from PrimaryProj where primaryProjId=?";
	public PrimaryProjBean findByPrimaryKey(int primaryProjId) {
		PrimaryProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, primaryProjId);
			rset = pstmt.executeQuery();
			if(rset.next()){
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
				result.setActivityStartTime(rset.getDate("activityStartTime"));
				result.setActivityEndTime(rset.getDate("activityEndTime"));
				result.setDemandNum(rset.getInt("demandNum"));
				result.setBudget(rset.getInt("budget"));
				result.setCreateDate(rset.getDate("createDate"));
				result.setProjStatus(rset.getString("projStatus"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//Select ALL  ----->getAll(){}
	private static final String SELECT_ALL = "select * from PrimaryProj";
	
	public List<PrimaryProjBean> getAll() {
		List<PrimaryProjBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rset = pstmt.executeQuery();
			result = new ArrayList<PrimaryProjBean>();
			while(rset.next()){
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
				bean.setActivityStartTime(rset.getDate("activityStartTime"));
				bean.setActivityEndTime(rset.getDate("activityEndTime"));
				bean.setDemandNum(rset.getInt("demandNum"));
				bean.setBudget(rset.getInt("budget"));
				bean.setCreateDate(rset.getDate("createDate"));
				bean.setProjStatus(rset.getString("projStatus"));
				
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
		
	//新增  --------> insert(){}
	private static final String INSERT =
			"insert into PrimaryProj (memberId, title, frontCoverName, frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	                                                                                                   long          String     String   String    java.util.Date    java.util.Date  int     int     ava.util.Date  String
	public PrimaryProjBean insert(PrimaryProjBean bean) {
		PrimaryProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			if(bean != null){
//				pstmt.setInt(1, bean.getPrimaryProjId());
				pstmt.setInt(1, bean.getMemberId());
				pstmt.setString(2, bean.getTitle());
				pstmt.setString(3, bean.getFrontCoverName());
				pstmt.setBytes(4, bean.getFrontCover());
				pstmt.setLong(5, bean.getFrontCoverLength());
				pstmt.setString(6, bean.getProjAbstract());
				pstmt.setString(7, bean.getContent());
				pstmt.setString(8, bean.getIdealPlace());
				//日期格式轉換
				java.util.Date startTime = bean.getActivityStartTime();
				if(startTime != null){
					long temp = startTime.getTime();
					pstmt.setTimestamp(9, new java.sql.Timestamp(temp));
				} else {
					pstmt.setTimestamp(9, null);
				}
				//日期格式轉換
				java.util.Date endTime = bean.getActivityEndTime();
				if(endTime != null){
					long temp = endTime.getTime();
					pstmt.setTimestamp(10, new java.sql.Timestamp(temp));
				} else {
					pstmt.setTimestamp(10, null);
				}
				pstmt.setInt(11, bean.getDemandNum());
				pstmt.setInt(12, bean.getBudget());
				//日期格式轉換
				java.util.Date createTime = bean.getCreateDate();
				if(createTime != null){
					long temp = createTime.getTime();
					pstmt.setTimestamp(13, new java.sql.Timestamp(temp));
				} else {
					pstmt.setTimestamp(13, null);
				}
				pstmt.setString(14, bean.getProjStatus());
				
				int i = pstmt.executeUpdate();
				if(i == 1){
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	//修改 -------->update(){}
	private static final String UPDATE =
			"update PrimaryProj set memberId=?, title=?, frontCoverName=?, frontCover=?, frontCoverLength=?, projAbstract=?, content=?, idealPlace=?, activityStartTime=?, activityEndTime=?, demandNum=?, budget=?, createDate=?, projStatus=? "
			+ "where primaryProjId=?";
	
	public PrimaryProjBean update(int memberId, String title, String frontCoverName,byte[] frontCover, long frontCoverLength, String projAbstract, String content, String idealPlace, java.util.Date activityStartTime, java.util.Date activityEndTime, int demandNum,
			int budget, java.util.Date createDate, String projStatus, int primaryProjId){
		
		PrimaryProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			
			pstmt.setInt(1, memberId);
			pstmt.setString(2, title);
			pstmt.setString(3, frontCoverName);
			pstmt.setBytes(4, frontCover);
			pstmt.setLong(5, frontCoverLength);
			pstmt.setString(6, projAbstract);
			pstmt.setString(7, content);
			pstmt.setString(8, idealPlace);
			//日期格式轉換
			if(activityStartTime != null){
				long temp = activityStartTime.getTime();
				pstmt.setTimestamp(9, new java.sql.Timestamp(temp));
			} else {
				pstmt.setTimestamp(9, null);
			}
			//日期格式轉換
			if(activityEndTime != null){
				long temp = activityEndTime.getTime();
				pstmt.setTimestamp(10, new java.sql.Timestamp(temp));
			} else {
				pstmt.setTimestamp(10, null);
			}
			pstmt.setInt(11, demandNum);
			pstmt.setInt(12, budget);
			//日期格式轉換
			if(createDate != null){
				long temp = createDate.getTime();
				pstmt.setTimestamp(13, new java.sql.Timestamp(temp));
			} else {
				pstmt.setTimestamp(13, null);
			}
			pstmt.setString(14, projStatus);
			pstmt.setInt(15, primaryProjId);
			
			int i = pstmt.executeUpdate();
			if(i == 1){
				result = this.findByPrimaryKey(primaryProjId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//刪除  ------> delete(){}
	private static final String DELETE =
		"delete from PrimaryProj where primaryProjId=?";
	
	public boolean delete(PrimaryProjBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, bean.getPrimaryProjId());
			int i = pstmt.executeUpdate();
			if(i == 1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
		
		
	public static void main(String[] args) throws Exception {
		PrimaryProjDAOJdbc service = new PrimaryProjDAOJdbc();
/* 		//findByPrimaryKey
		PrimaryProjDAOJdbc service = new PrimaryProjDAOJdbc();
		PrimaryProjBean bean = service.findByPrimaryKey(1);
		System.out.println("bean:" + bean);
*/
				
/*		//select All for Test 查詢全部
		List<PrimaryProjBean> beans =  service.getAll();
		for(PrimaryProjBean bean : beans){
			System.out.println("bean:" + bean);
		}
*/
		
/*
		//insert 新增
		PrimaryProjBean bean1 = new PrimaryProjBean();
//		bean1.setPrimaryProjId(2); //資料庫有設計IDENTITY(1,1)所以這行不用加
		bean1.setMemberId(6);
		bean1.setTitle("餐餐都有麥當當");
		bean1.setFrontCoverName("初步計畫封面名稱");
		bean1.setFrontCoverLength(11111111);
		bean1.setProjAbstract("摘要（Abstract）又稱文摘或提要。它是以簡明扼要的文句，將某種文獻的主要內容"
				+ "，正確無誤地摘錄出來，使讀者於最短的時間內，得知原著的大意。");
		bean1.setContent("初步計畫的內文檔案內容會比摘要多很多.......");
		bean1.setIdealPlace("新竹尖石鄉");
		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String theDate1 = "2015-5-22 18:21:52";
		bean1.setActivityStartTime(sdf.parse(theDate1));
		String theDate2 = "2015-5-28 21:28:11";
		bean1.setActivityEndTime(sdf.parse(theDate2));
		bean1.setDemandNum(30);
		bean1.setBudget(20000);
		String theDate3 = "2015-1-13 05:55:01";
		bean1.setCreateDate(sdf.parse(theDate3));
		bean1.setProjStatus("洽談失敗");
		System.out.println(service.insert(bean1));
*/
		
/*
		//update 更新
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = "2015-04-15 05:05:05";
		String date2 = "2015-05-01 18:21:32";
		String date3 = "2015-01-28 19:54:12";
		PrimaryProjBean updateResult = service.update(5, "大俠愛吃漢堡飽", "計畫封面名稱", null, 123456, "填寫摘要的地方", "填寫很長的內文的地方", "台東都蘭國小", sdf.parse(date1), sdf.parse(date2), 21, 300000, sdf.parse(date3), "洽談失敗", 4);
		System.out.println(updateResult);
*/
		
/*
		//delete 刪除
		PrimaryProjBean bean2 = new PrimaryProjBean();
		bean2.setPrimaryProjId(4);
		System.out.println(service.delete(bean2));
*/
	}

}

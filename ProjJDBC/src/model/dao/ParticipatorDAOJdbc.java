package model.dao;

/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ParticipatorBean;

public class ParticipatorDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
//SQL 指令
	//Select by ID
	private static final String SELECT_BY_ID =
			"select * from Participator where fullProjId=? and memberId=?";
	
	public ParticipatorBean findByPrimaryKey(int fullProjId, int memberId){
		ParticipatorBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			
			pstmt.setInt(1, fullProjId);
			pstmt.setInt(2, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = new ParticipatorBean();
				result.setFullProjId(rset.getInt("fullProjId"));
				result.setMemberId(rset.getInt("memberId"));
				result.setActivityStartTime(rset.getDate("activityStartTime"));
				result.setActivityEndTime(rset.getDate("activityEndTime"));
				result.setParticipateStatus(rset.getString("participateStatus"));
				result.setCheckTime(rset.getDate("checkTime"));
				result.setIsParticipate(rset.getString("isParticipate"));
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
	private static final String SELECT_ALL =
			"select * from Participator";
	
	public List<ParticipatorBean> getAll(){
		List<ParticipatorBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ParticipatorBean>();
			while(rset.next()){
				ParticipatorBean bean = new ParticipatorBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setActivityStartTime(rset.getDate("activityStartTime"));
				bean.setActivityEndTime(rset.getDate("activityEndTime"));
				bean.setParticipateStatus(rset.getString("participateStatus"));
				bean.setCheckTime(rset.getDate("checkTime"));
				bean.setIsParticipate(rset.getString("isParticipate"));
				
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
			"insert into Participator (fullProjId, memberId, activityStartTime, activityEndTime, participateStatus,checkTime,isParticipate)"
			+ " values (?, ?, ?, ?, ?, ?, ?)";
	
	public ParticipatorBean insert(ParticipatorBean bean){
		ParticipatorBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			if(bean != null){
				pstmt.setInt(1, bean.getFullProjId());
				pstmt.setInt(2, bean.getMemberId());
				//java.util.Date transfer java.sql.Date
				java.util.Date startTime = bean.getActivityStartTime();
				if(startTime != null){
					long tempTime = startTime.getTime();
					pstmt.setDate(3, new java.sql.Date(tempTime));
				} else {
					pstmt.setDate(3, null);
				}
				//java.util.Date transfer java.sql.Date
				java.util.Date endTime = bean.getActivityEndTime();
				if(endTime != null){
					long tempTime = endTime.getTime();
					pstmt.setDate(4, new java.sql.Date(tempTime));
				} else {
					pstmt.setDate(4, null);
				}
				pstmt.setString(5, bean.getParticipateStatus());
				//java.util.Date transfer java.sql.Date
				java.util.Date checkTime = bean.getCheckTime();
				if(checkTime != null){
					long tempTime = checkTime.getTime();
					pstmt.setDate(6, new java.sql.Date(tempTime));
				} else {
					pstmt.setDate(6, null);
				}
				pstmt.setString(7, bean.getIsParticipate());
				int i = pstmt.executeUpdate();
				if(i==1){
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
			"update Participator set activityStartTime=?, activityEndTime=?, participateStatus=?, checkTime=?, isParticipate=? "
			+ "where fullProjId=? and memberId=?";
	
	public ParticipatorBean update(java.util.Date activityStartTime, java.util.Date activityEndTime, 
			String participateStatus, java.util.Date checkTime,String isParticipate, int fullProjId, int memberId){
		ParticipatorBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			if(activityStartTime != null){
				long tempTime = activityStartTime.getTime();
				pstmt.setDate(1, new java.sql.Date(tempTime));
			} else {
				pstmt.setDate(1, null);
			}
			
			if(activityEndTime != null){
				long tempTime = activityEndTime.getTime();
				pstmt.setDate(2, new java.sql.Date(tempTime));
			} else {
				pstmt.setDate(2, null);
			}
			pstmt.setString(3, participateStatus);
			
			if(checkTime != null){
				long tempTime = checkTime.getTime();
				pstmt.setDate(4, new java.sql.Date(tempTime));
			} else {
				pstmt.setDate(4, null);
			}
			
			pstmt.setString(5, isParticipate);
			pstmt.setInt(6, fullProjId);
			pstmt.setInt(7, memberId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
			if(i == 1){
				result = this.findByPrimaryKey(fullProjId, memberId);
				
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
			"delete from Participator where fullProjId=? and memberId=?";
	
	public boolean delete(int fullProjId, int memberId) throws Exception{
		try (
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(DELETE);){
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 4);
			int i = pstmt.executeUpdate();
			if(i == 1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//測試檔	
	public static void main(String[] args) throws Exception{
		ParticipatorDAOJdbc service = new ParticipatorDAOJdbc();
 
/*		//findByPrimaryKey for Test 查詢單一筆資料
		ParticipatorBean bean = service.findByPrimaryKey(1, 3);
		System.out.println("bean:" + bean);
*/
		

/*		//select All for Test 查詢全部
		List<ParticipatorBean> beans =  service.getAll();
		for(ParticipatorBean bean : beans){
			System.out.println("bean:" + bean);
		}
*/
		

/*		//		insert 新增
		ParticipatorBean bean1 = new ParticipatorBean();
		bean1.setFullProjId(1);
		bean1.setMemberId(4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String theDate = "2013-4-12";
		bean1.setActivityStartTime(sdf.parse(theDate));
		bean1.setActivityEndTime(sdf.parse(theDate));
		bean1.setParticipateStatus("待審核");
		bean1.setCheckTime(sdf.parse(theDate));
		bean1.setIsParticipate("否");
		System.out.println(service.insert(bean1));
*/

/*		//		update 更新
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2014-02-13";
		String date2 = "2014-04-23";
		String date3 = "2014-07-11";
		ParticipatorBean updateResult = service.update(sdf.parse(date1), sdf.parse(date2), "同時間內已經參與其他計畫", sdf.parse(date3), "是", 1, 4);
		System.out.println(updateResult);
*/
		
/*		//		delete 刪除
		System.out.println(service.delete(1, 4));

 */
	}
}

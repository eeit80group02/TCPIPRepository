package model.dao;
/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 修改日期: 第一次修改 2015-09-02 21:21
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
import model.ProcessingProjBean;

public class ProcessingProjDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	//Select by ID
	private static final String SELECT_BY_ID =
			"select * from ProcessingProj where primaryProjId=? and schoolId=?";
	
	public ProcessingProjBean findByPrimaryKey(int primaryProjId, int schoolId) {
		ProcessingProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, primaryProjId);
			pstmt.setInt(2, schoolId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = new ProcessingProjBean();
				result.setPrimaryProjId(rset.getInt("primaryProjId"));
				result.setSchoolId(rset.getInt("schoolId"));
				result.setCheckTime(rset.getDate("checkTime"));
			}
		} catch (Exception e) {
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
	private static final String SELECT_ALL = "select * from ProcessingProj ";
	
	public List<ProcessingProjBean> getAll() {
		List<ProcessingProjBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ProcessingProjBean>();
			while(rset.next()){
				ProcessingProjBean bean = new ProcessingProjBean();
				bean.setPrimaryProjId(rset.getInt("primaryProjId"));
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setCheckTime(rset.getDate("checkTime"));
				result.add(bean);
			}
		} catch (Exception e) {
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
			"insert into ProcessingProj  (primaryProjId, schoolId, checkTime) values (?, ?, ?)";
	
	public ProcessingProjBean insert(ProcessingProjBean bean) throws Exception{
		ProcessingProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			if(bean != null){
				pstmt.setInt(1, bean.getPrimaryProjId());
				pstmt.setInt(2, bean.getSchoolId());
				//java.util.Date transfer java.sql.Date
				java.util.Date ckTime = bean.getCheckTime();
				if(ckTime != null){
					long tempTime = ckTime.getTime();
					pstmt.setTimestamp(3, new java.sql.Timestamp(tempTime));
				} else {
					pstmt.setTimestamp(3, null);
				}
				int i = pstmt.executeUpdate();
				if(i==1){
					result = bean;
				}
			}
		} catch (Exception e) {
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
			"update ProcessingProj  set checkTime=? where primaryProjId=? and schoolId=?";
	
	public ProcessingProjBean update(java.util.Date checkTime, int primaryProjId, int schoolId) throws Exception{
		ProcessingProjBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			//日期格式轉換
			if(checkTime != null){
				long tempTime = checkTime.getTime();
				pstmt.setTimestamp(1, new java.sql.Timestamp(tempTime));
			} else {
				pstmt.setTimestamp(1, null);
			
			}
			pstmt.setInt(2, primaryProjId);
			pstmt.setInt(3, schoolId);
			int i = pstmt.executeUpdate();
			if(i == 1){
				result = this.findByPrimaryKey(primaryProjId, schoolId);
				
			}
		} catch (Exception e) {
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
			"delete from ProcessingProj  where primaryProjId=? and schoolId=?";
	
	public boolean delete(int primaryProjId, int schoolId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, primaryProjId);
			pstmt.setInt(2, schoolId);
			int i = pstmt.executeUpdate();
			if(i == 1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		ProcessingProjDAOJdbc service = new ProcessingProjDAOJdbc();
/*		
		//findByPrimaryKey for Test 查詢單一筆資料
		ProcessingProjBean bean = service.findByPrimaryKey(1, 14672);
		System.out.println("bean:" + bean);
*/
		
/*
		//select All for Test 查詢全部
		List<ProcessingProjBean> beans =  service.getAll();
		for(ProcessingProjBean bean : beans){
			System.out.println("bean:" + bean);
		}
*/
		
/*
		//		insert 新增
		ProcessingProjBean bean1 = new ProcessingProjBean();
		bean1.setPrimaryProjId(3);
		bean1.setSchoolId(14731);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String theDate = "2015-4-12 21:20:35";
		bean1.setCheckTime(sdf.parse(theDate));
		
		System.out.println(service.insert(bean1));
*/

/*		
		//		update 更新
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = "2015-02-13 06:21:21";
		ProcessingProjBean updateResult = service.update(sdf.parse(date1), 3, 14731);
		System.out.println(updateResult);
*/

/*		
		//		delete 刪除
		System.out.println(service.delete(3, 14731));
*/
	}
}

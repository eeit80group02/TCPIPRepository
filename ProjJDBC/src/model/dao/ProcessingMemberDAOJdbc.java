package model.dao;
/*
 * 編寫者: Z.Y
 * 測試日期: 2015/08/31
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ParticipatorBean;
import model.ProcessingMemberBean;

public class ProcessingMemberDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	//Select by ID
	private static final String SELECT_BY_ID =
		"select * from ProcessingMember where schoolDemandId=? and memberId=?";
	
	public ProcessingMemberBean findByPrimaryKey(int schoolDemandId, int memberId) {
		ProcessingMemberBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			
			pstmt.setInt(1, schoolDemandId);
			pstmt.setInt(2, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = new ProcessingMemberBean();
				result.setSchoolDemandId(rset.getInt("schoolDemandId"));
				result.setMemberId(rset.getInt("memberId"));
				result.setDatetime(rset.getDate("checkTime"));
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
	private static final String SELECT_ALL = "select * from ProcessingMember";
	
	public List<ProcessingMemberBean> getAll() throws Exception{
		List<ProcessingMemberBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rset = pstmt.executeQuery();
			result = new ArrayList<ProcessingMemberBean>();
			while(rset.next()){
				ProcessingMemberBean bean = new ProcessingMemberBean();
				bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
				bean.setMemberId(rset.getInt("memberId"));
				bean.setDatetime(rset.getDate("checkTime"));
				
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
		"insert into ProcessingMember (schoolDemandId, memberId, checkTime) values (?, ?, ?)";
	
	public ProcessingMemberBean insert(ProcessingMemberBean bean) throws Exception{
		ProcessingMemberBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			if(bean != null){
				pstmt.setInt(1, bean.getSchoolDemandId());
				pstmt.setInt(2, bean.getMemberId());
				//日期轉換
				java.util.Date dateTime = bean.getDatetime();
				if( dateTime != null){
					long temp = dateTime.getTime();
					pstmt.setDate(3, new java.sql.Date(temp));
				} else {
					pstmt.setDate(3, null);
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
		"update ProcessingMember set checkTime=? where schoolDemandId=? and memberId=?";
	
	public ProcessingMemberBean update( java.util.Date checkTime, int schoolDemandId, int memberId) throws Exception{
		ProcessingMemberBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			if(checkTime != null){
				long temp = checkTime.getTime();
				pstmt.setDate(1, new java.sql.Date(temp));
			} else {
				pstmt.setDate(1, null);
			}
			pstmt.setInt(2, schoolDemandId);
			pstmt.setInt(3, memberId);
			int i = pstmt.executeUpdate();
			if(i == 1){
				result = this.findByPrimaryKey(schoolDemandId, memberId);
				
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
		"delete from ProcessingMember where schoolDemandId=? and memberId=?";
	
	public boolean delete(int schoolDemandId, int memberId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, schoolDemandId);
			pstmt.setInt(2, memberId);
			int i = pstmt.executeUpdate();
			if(i == 1){
				return true;
			}
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
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
	
	//測試
	public static void main(String[] args) throws Exception {
		ProcessingMemberDAOJdbc service = new ProcessingMemberDAOJdbc();
/*		
		//findByPrimaryKey for Test 查詢單一筆資料
		ProcessingMemberBean bean = service.findByPrimaryKey(1, 4);
		System.out.println("bean:" + bean);
*/
		
/*
		//select All for Test 查詢全部
		List<ProcessingMemberBean> beans =  service.getAll();
		for(ProcessingMemberBean bean : beans){
			System.out.println("bean:" + bean);
		}
*/
		
/*
		//		insert 新增
		ProcessingMemberBean bean1 = new ProcessingMemberBean();
		bean1.setSchoolDemandId(1);
		bean1.setMemberId(2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String theDate = "2015-4-12";
		bean1.setDatetime(sdf.parse(theDate));
		
		System.out.println(service.insert(bean1));
*/

/*		
		//		update 更新
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2015-02-13";
		ProcessingMemberBean updateResult = service.update(sdf.parse(date1), 3, 7);
		System.out.println(updateResult);
*/

/*		
		//		delete 刪除
		System.out.println(service.delete(1, 4));
*/
	}

}

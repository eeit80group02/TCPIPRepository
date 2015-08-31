package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FullProjBean;

public class FullProjDAOJdbc {		
	
		public static void main(String[] args) {
			FullProjDAOJdbc jdbc = new FullProjDAOJdbc();
			FullProjBean bean = new FullProjBean();
			bean.setName("哈樓");
			bean.setPrimaryProjId(1);
			bean.setSchoolDemandId(2);
			bean.setMemberId(1);
			bean.setSchoolId(999999);
			bean.setMissionBoardId(1);
			//System.out.println(jdbc.insert(bean));
			byte[] b = {1,2,3};
			System.out.println(jdbc.update(1, 2, 1, 999999, "嘿嘿嘿", null, b, 111, null, null, null, null, null, 0, 0, null, null, null, null, b, 0, 0, 1, null, null, null, 17));
			System.out.println(jdbc.delete(17));
			System.out.println(jdbc.getAll());
			System.out.println(jdbc.findByPrimaryKey(15));
		}
		
		private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
		private static final String USERNAME = "sa";
		private static final String PASSWORD = "sa123456";
		
		private static final String SELECT_ALL = "select * from FullProj ";
		public List<FullProjBean> getAll(){
			List<FullProjBean> result = null;
			try (
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
				
				result = new ArrayList<FullProjBean>();
				while(rset.next()) {
					FullProjBean bean = new FullProjBean();
					bean.setFullProjId(rset.getInt("fullProjId"));
					bean.setPrimaryProjId(rset.getInt("primaryProjId"));
					bean.setSchoolDemandId(rset.getInt("schoolDemandId"));
					bean.setMemberId(rset.getInt("memberId"));
					bean.setSchoolId(rset.getInt("schoolId"));
					bean.setName(rset.getString("name"));
					bean.setFrontCoverName(rset.getString("frontCoverName"));
					bean.setFrontCover(rset.getBytes("frontCover"));
					bean.setFrontCoverLength(rset.getLong("frontCoverLength"));
					bean.setProjAbstract(rset.getString("projAbstract"));
					bean.setContent(rset.getString("content"));
					bean.setLocation(rset.getString("location"));
					bean.setActivityStartTime(rset.getDate("activityStartTime"));
					bean.setActivityEndTime(rset.getDate("activityEndTime"));
					bean.setEstMember(rset.getInt("estMember"));
					bean.setBudget(rset.getInt("budget"));
					bean.setCreateDate(rset.getDate("createDate"));
					bean.setProjStatus(rset.getString("projStatus"));
					bean.setOrgArchitecture(rset.getString("orgArchitecture"));
					bean.setProjFileName(rset.getString("projFileName"));
					bean.setProjFile(rset.getBytes("projFile"));
					bean.setProjFileLength(rset.getInt("projFileLength"));
					bean.setReviews(rset.getInt("reviews"));
					bean.setMissionBoardId(rset.getInt("missionBoardId"));
					bean.setReviewsContent(rset.getString("reviewsContent"));
					bean.setSchoolConfirm(rset.getString("schoolConfirm"));
					bean.setMemberConfirm(rset.getString("memberConfirm"));		
					result.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		private static final String SELECT_BY_ID = "select * from FullProj where fullProjId =?";
		public FullProjBean findByPrimaryKey(int fullProjId){
			FullProjBean result = null;
			ResultSet rset =null;
			try (
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
				stmt.setInt(1, fullProjId);
				rset = stmt.executeQuery();
				while(rset.next()) {
					result = new FullProjBean();
					result.setFullProjId(rset.getInt("fullProjId"));
					result.setSchoolDemandId(rset.getInt("schoolDemandId"));
					result.setMemberId(rset.getInt("memberId"));
					result.setSchoolId(rset.getInt("schoolId"));
					result.setName(rset.getString("name"));
					result.setFrontCoverName(rset.getString("frontCoverName"));
					result.setFrontCover(rset.getBytes("frontCover"));
					result.setFrontCoverLength(rset.getLong("frontCoverLength"));
					result.setProjAbstract(rset.getString("projAbstract"));
					result.setContent(rset.getString("content"));
					result.setLocation(rset.getString("location"));
					result.setActivityStartTime(rset.getDate("activityStartTime"));
					result.setActivityEndTime(rset.getDate("activityEndTime"));
					result.setEstMember(rset.getInt("estMember"));
					result.setBudget(rset.getInt("budget"));
					result.setCreateDate(rset.getDate("createDate"));
					result.setProjStatus(rset.getString("projStatus"));
					result.setOrgArchitecture(rset.getString("orgArchitecture"));
					result.setProjFileName(rset.getString("projFileName"));
					result.setProjFile(rset.getBytes("projFile"));
					result.setProjFileLength(rset.getInt("projFileLength"));
					result.setReviews(rset.getInt("reviews"));
					result.setMissionBoardId(rset.getInt("missionBoardId"));
					result.setReviewsContent(rset.getString("reviewsContent"));
					result.setSchoolConfirm(rset.getString("schoolConfirm"));
					result.setMemberConfirm(rset.getString("memberConfirm"));		
					return result;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rset!=null) {
					try {
						rset.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}
		
		private static final String INSERT = "insert into FullProj (primaryProjId, schoolDemandId, memberId, schoolId, name,"
																   +"frontCoverName, frontCover, frontCoverLength, projAbstract, content,"
																   +"location,activityStartTime, activityEndTime, estMember, budget, "
																   +"createDate,projStatus, orgArchitecture, projFileName, projFile,"
																   +"projFileLength, reviews, missionBoardId, reviewsContent, schoolConfirm,"
																   + "memberConfirm) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)"; 
		public FullProjBean insert(FullProjBean bean) {
			FullProjBean result = null;
			try(
					Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);) {
				if(bean!=null) {
					result = new FullProjBean();
					stmt.setInt(1, bean.getPrimaryProjId());
					stmt.setInt(2, bean.getSchoolDemandId());
					stmt.setInt(3, bean.getMemberId());
					stmt.setInt(4, bean.getSchoolId());
					stmt.setString(5, bean.getName());
					stmt.setString(6, bean.getFrontCoverName());
					stmt.setBytes(7, bean.getFrontCover());
					stmt.setLong(8, bean.getFrontCoverLength());
					stmt.setString(9, bean.getProjAbstract());
					stmt.setString(10, bean.getContent());
					stmt.setString(11, bean.getLocation());
					java.util.Date make1 = bean.getActivityStartTime();
					if(make1!=null){
						stmt.setDate(12, new java.sql.Date(make1.getTime()));
					} else{
						stmt.setDate(12, null);
					}
					java.util.Date make2 = bean.getActivityEndTime();
					if(make2!=null){
						stmt.setDate(13, new java.sql.Date(make2.getTime()));
					} else{
						stmt.setDate(13, null);
					}
					stmt.setInt(14, bean.getEstMember());
					stmt.setInt(15, bean.getBudget());
					java.util.Date make3 = bean.getCreateDate();
					if(make3!=null){
						stmt.setDate(16, new java.sql.Date(make3.getTime()));
					} else{
						stmt.setDate(16, null);
					}
					stmt.setString(17, bean.getProjStatus());
					stmt.setString(18, bean.getOrgArchitecture());
					stmt.setString(19, bean.getProjFileName());
					stmt.setBytes(20, bean.getProjFile());
					stmt.setLong(21, bean.getProjFileLength());
					stmt.setInt(22, bean.getReviews());
					stmt.setInt(23, bean.getMissionBoardId());
					stmt.setString(24, bean.getReviewsContent());
					stmt.setString(25, bean.getSchoolConfirm());
					stmt.setString(26, bean.getMemberConfirm());
					int i = stmt.executeUpdate();
					if(i==1) {
						ResultSet key = stmt.getGeneratedKeys();
						if(key.next()){
							bean.setFullProjId(key.getInt(1));
						}
						result = bean;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

		private static final String UPDATE =
				"update FullProj set primaryProjId=?, schoolDemandId=?, memberId=?, schoolId=?, name=?,"
								+"frontCoverName=?, frontCover=?, frontCoverLength=?, projAbstract=?,"
								+ "content=?, location=?, activityStartTime=?, activityEndTime=?, estMember=?,"
								+ "budget=?, createDate=?, projStatus=?, orgArchitecture=?, projFileName=?,"
								+ "projFile=?, projFileLength=?, reviews=?, missionBoardId=?, reviewsContent=?,"
								+ "schoolConfirm=?, memberConfirm=? where fullProjId=?";


		public FullProjBean update(int primaryProjId, int schoolDemandId, int memberId, int schoolId, String name,String frontCoverName,
								   byte[] frontCover, long frontCoverLength, String projAbstract, String content, String location,
								   java.util.Date activityStartTime, java.util.Date activityEndTime, int estMember, int budget, java.util.Date createDate,
								   String projStatus, String orgArchitecture, String projFileName, byte[] projFile, int projFileLength,
								   int reviews, int missionBoardId, String reviewsContent, String schoolConfirm, String memberConfirm, int fullProjId) {
			FullProjBean result = null;
			try(
					Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
				stmt.setInt(1, primaryProjId);
				stmt.setInt(2, schoolDemandId);
				stmt.setInt(3, memberId);
				stmt.setInt(4, schoolId);
				stmt.setString(5, name);
				stmt.setString(6, frontCoverName);
				stmt.setBytes(7, frontCover);
				stmt.setLong(8, frontCoverLength);
				stmt.setString(9, projAbstract);
				stmt.setString(10, content);
				stmt.setString(11, location);
				if(activityStartTime!=null){
					stmt.setDate(12, new java.sql.Date(activityStartTime.getTime()));
				}else{
					stmt.setDate(12, null);
				}
				if(activityEndTime!=null){
					stmt.setDate(13, new java.sql.Date(activityEndTime.getTime()));
				}else{
					stmt.setDate(13, null);
				}
				stmt.setInt(14, estMember);
				stmt.setInt(15, budget);
				if(createDate!=null){
					stmt.setDate(16, new java.sql.Date(createDate.getTime()));
				}else{
					stmt.setDate(16, null);
				}
				stmt.setString(17, projStatus);
				stmt.setString(18, orgArchitecture);
				stmt.setString(19, projFileName);
				stmt.setBytes(20, projFile);
				stmt.setInt(21, projFileLength);
				stmt.setInt(22, reviews);
				stmt.setInt(23, missionBoardId);
				stmt.setString(24, reviewsContent);
				stmt.setString(25, schoolConfirm);
				stmt.setString(26, memberConfirm);
				stmt.setInt(27, fullProjId);
							

				int i = stmt.executeUpdate();
				if(i==1) {
					result = this.findByPrimaryKey(fullProjId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		private static final String DELETE =
				"delete from FullProj where fullProjId=?";
		public boolean delete(int fullProjId) {
			try(
					Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
				stmt.setInt(1, fullProjId);
				int i = stmt.executeUpdate();
				if(i==1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	
	
}

package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjDiscusBean;
import model.ProjModifyBean;

public class ProjDiscusDAOjdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";

	private static final String SELECT_ALL = "select * from ProjModify ";

	public List<ProjDiscusBean> getAll() {
		List<ProjDiscusBean> result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,
				PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {

			result = new ArrayList<ProjDiscusBean>();
			while (rset.next()) {
				ProjDiscusBean bean = new ProjDiscusBean();
				bean.setFullProjId(rset.getInt("fullProjId"));
				bean.setQuestionId(rset.getInt("questionId"));
				bean.setQuestionMemberId(rset.getInt("questionMemberId"));
				bean.setQuestionMemberContent(rset
						.getString("questionMemberContent"));
				bean.setQuestionMemberTime(rset.getDate("questionMemberTime"));
				bean.setAnswerMemberContent(rset
						.getString("answerMemberContent"));
				bean.setAnswerMemberTime(rset.getDate("answerMemberTime"));
				bean.setAnswerMemberId(rset.getInt("answerMemberId"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_ID = "select * from ProjDiscus where fullProjId =? and questionId=? and questionMemberId=?";

	public ProjDiscusBean findByPrimaryKey(int fullProjId, int questionId,
			int questionMemberId) {
		ProjDiscusBean result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,
				PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, questionId);
			stmt.setInt(3, questionMemberId);
			rset = stmt.executeQuery();
			while (rset.next()) {
				result.setFullProjId(rset.getInt("fullProjId"));
				result.setQuestionId(rset.getInt("questionId"));
				result.setQuestionMemberId(rset.getInt("questionMemberId"));
				result.setQuestionMemberContent(rset
						.getString("questionMemberContent"));
				result.setQuestionMemberTime(rset.getDate("questionMemberTime"));
				result.setAnswerMemberContent(rset
						.getString("answerMemberContent"));
				result.setAnswerMemberTime(rset.getDate("answerMemberTime"));
				result.setAnswerMemberId(rset.getInt("answerMemberId"));
				return result;
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
		}
		return result;
	}

	private static final String INSERT = "insert into ProjDiscus (fullProjId, questionId, questionMemberId, questionMemberContent, questionMemberTime,"
			+ "answerMemberContent, answerMemberTime, answerMemberId) values (?,?,?,?,?,?,?,?)";

	public ProjDiscusBean insert(ProjDiscusBean bean) {
		ProjDiscusBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,
				PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if (bean != null) {
				stmt.setInt(1, bean.getFullProjId());
				stmt.setInt(2, bean.getQuestionId());
				stmt.setInt(3, bean.getQuestionMemberId());
				stmt.setString(4, bean.getQuestionMemberContent());
				java.util.Date make1 = bean.getQuestionMemberTime();
				if (make1 != null) {
					stmt.setDate(5, new java.sql.Date(make1.getTime()));
				} else {
					stmt.setDate(5, null);
				}
				stmt.setString(6, bean.getAnswerMemberContent());
				java.util.Date make2 = bean.getAnswerMemberTime();
				if (make2 != null) {
					stmt.setDate(7, new java.sql.Date(make2.getTime()));
				} else {
					stmt.setDate(7, null);
				}
				stmt.setInt(8, bean.getAnswerMemberId());
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update ProjDiscus set questionMemberContent=?, questionMemberTime=?, answerMemberContent=?, answerMemberTime=?, answerMemberId=? "
			+ "where fullProjId=? and questionId=? and questionMemberId=?";

	public ProjDiscusBean update(String questionMemberContent, java.util.Date questionMemberTime, String answerMemberContent,
			 java.util.Date answerMemberTime, int answerMemberId, int fullProjId, int questionId, int questionMemberId) {
		ProjDiscusBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,
				PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, questionMemberContent);
			stmt.setDate(2, new java.sql.Date(questionMemberTime.getTime()));
			stmt.setString(3, answerMemberContent);
			stmt.setDate(4, new java.sql.Date(answerMemberTime.getTime()));
			stmt.setInt(5, answerMemberId);
			stmt.setInt(6, fullProjId);
			stmt.setInt(7, questionId);
			stmt.setInt(8, questionMemberId);
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.findByPrimaryKey(fullProjId, questionId, questionMemberId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String DELETE = "delete from ProjModify where fullProjId=? and questionId=? and questionMemberId=?";
	
	public boolean delete(int fullProjId, int questionId, int questionMemberId) {
		try(
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setInt(1, fullProjId);
			stmt.setInt(2, questionId);
			stmt.setInt(3, questionMemberId);
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

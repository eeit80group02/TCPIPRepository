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

import model.GradeStudentBean;

public class GradeStudentDAOJdbc
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String SELECT_ALL = "SELECT schoolId,anniversary,elementaryFirst,elementarySecond,elementaryThird,elementaryFourth,elementaryFifth,elementarySixth,juniorFirst,juniorSecond,juniorThird FROM GradeStudent";

	public List<GradeStudentBean> getAll()
	{
		List<GradeStudentBean> result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = pstmt.executeQuery();)
		{
			result = new ArrayList<GradeStudentBean>();
			while(rset.next())
			{
				GradeStudentBean bean = new GradeStudentBean();
				bean.setSchoolId(rset.getInt("schoolId"));
				bean.setAnniversary(rset.getInt("anniversary"));

				if(rset.getObject("elementaryFirst") != null)
				{
					bean.setElementaryFirst(rset.getInt("elementaryFirst"));
				}
				else
				{
					bean.setElementaryFirst((Integer)rset.getObject("elementaryFirst"));
				}

				if(rset.getObject("elementarySecond") != null)
				{
					bean.setElementarySecond(rset.getInt("elementarySecond"));
				}
				else
				{
					bean.setElementarySecond((Integer)rset.getObject("elementarySecond"));
				}

				if(rset.getObject("elementaryThird") != null)
				{
					bean.setElementaryThird(rset.getInt("elementaryThird"));
				}
				else
				{
					bean.setElementaryThird((Integer)rset.getObject("elementaryThird"));
				}
				if(rset.getObject("elementaryFourth") != null)
				{
					bean.setElementaryFourth(rset.getInt("elementaryFourth"));
				}
				else
				{
					bean.setElementaryFourth((Integer)rset.getObject("elementaryFourth"));
				}
				if(rset.getObject("elementaryFifth") != null)
				{
					bean.setElementaryFifth(rset.getInt("elementaryFifth"));
				}
				else
				{
					bean.setElementaryFifth((Integer)rset.getObject("elementaryFifth"));
				}

				if(rset.getObject("elementarySixth") != null)
				{
					bean.setElementarySixth(rset.getInt("elementarySixth"));
				}
				else
				{
					bean.setElementarySixth((Integer)rset.getObject("elementarySixth"));
				}

				if(rset.getObject("juniorFirst") != null)
				{
					bean.setJuniorFirst(rset.getInt("juniorFirst"));
				}
				else
				{
					bean.setJuniorFirst((Integer)rset.getObject("juniorFirst"));
				}

				if(rset.getObject("juniorSecond") != null)
				{
					bean.setJuniorSecond(rset.getInt("juniorSecond"));
				}
				else
				{
					bean.setJuniorSecond((Integer)rset.getObject("juniorSecond"));
				}

				if(rset.getObject("juniorThird") != null)
				{
					bean.setJuniorThird(rset.getInt("juniorThird"));
				}
				else
				{
					bean.setJuniorThird((Integer)rset.getObject("juniorThird"));
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

	private static final String SELECT_BY_ID = "SELECT schoolId,anniversary,elementaryFirst,elementarySecond,elementaryThird,elementaryFourth,elementaryFifth,elementarySixth,juniorFirst,juniorSecond,juniorThird FROM GradeStudent WHERE schoolId = ? AND anniversary = ?";

	public GradeStudentBean findByPrimaryKey(int schoolId,int anniversary)
	{
		GradeStudentBean result = null;
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID);)
		{
			pstmt.setInt(1,schoolId);
			pstmt.setInt(2,anniversary);
			try(ResultSet rset = pstmt.executeQuery();)
			{
				while(rset.next())
				{
					result = new GradeStudentBean();
					result.setSchoolId(rset.getInt("schoolId"));
					result.setAnniversary(rset.getInt("anniversary"));

					if(rset.getObject("elementaryFirst") != null)
					{
						result.setElementaryFirst(rset.getInt("elementaryFirst"));
					}
					else
					{
						result.setElementaryFirst((Integer)rset.getObject("elementaryFirst"));
					}

					if(rset.getObject("elementarySecond") != null)
					{
						result.setElementarySecond(rset.getInt("elementarySecond"));
					}
					else
					{
						result.setElementarySecond((Integer)rset.getObject("elementarySecond"));
					}

					if(rset.getObject("elementaryThird") != null)
					{
						result.setElementaryThird(rset.getInt("elementaryThird"));
					}
					else
					{
						result.setElementaryThird((Integer)rset.getObject("elementaryThird"));
					}
					if(rset.getObject("elementaryFourth") != null)
					{
						result.setElementaryFourth(rset.getInt("elementaryFourth"));
					}
					else
					{
						result.setElementaryFourth((Integer)rset.getObject("elementaryFourth"));
					}
					if(rset.getObject("elementaryFifth") != null)
					{
						result.setElementaryFifth(rset.getInt("elementaryFifth"));
					}
					else
					{
						result.setElementaryFifth((Integer)rset.getObject("elementaryFifth"));
					}

					if(rset.getObject("elementarySixth") != null)
					{
						result.setElementarySixth(rset.getInt("elementarySixth"));
					}
					else
					{
						result.setElementarySixth((Integer)rset.getObject("elementarySixth"));
					}

					if(rset.getObject("juniorFirst") != null)
					{
						result.setJuniorFirst(rset.getInt("juniorFirst"));
					}
					else
					{
						result.setJuniorFirst((Integer)rset.getObject("juniorFirst"));
					}

					if(rset.getObject("juniorSecond") != null)
					{
						result.setJuniorSecond(rset.getInt("juniorSecond"));
					}
					else
					{
						result.setJuniorSecond((Integer)rset.getObject("juniorSecond"));
					}

					if(rset.getObject("juniorThird") != null)
					{
						result.setJuniorThird(rset.getInt("juniorThird"));
					}
					else
					{
						result.setJuniorThird((Integer)rset.getObject("juniorThird"));
					}
				}
			}
			catch(Exception e)
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

	private static final String INSERT = "INSERT INTO GradeStudent(schoolId,anniversary,elementaryFirst,elementarySecond,elementaryThird,elementaryFourth,elementaryFifth,elementarySixth,juniorFirst,juniorSecond,juniorThird) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	public GradeStudentBean insert(GradeStudentBean bean)
	{
		GradeStudentBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{

				pstmt.setInt(1,bean.getSchoolId());
				pstmt.setInt(2,bean.getAnniversary());

				if(bean.getElementaryFirst() != null)
				{
					pstmt.setInt(3,bean.getElementaryFirst());
				}
				else
				{
					pstmt.setNull(3,Types.INTEGER);
				}

				if(bean.getElementarySecond() != null)
				{
					pstmt.setInt(4,bean.getElementarySecond());
				}
				else
				{
					pstmt.setNull(4,Types.INTEGER);
				}

				if(bean.getElementaryThird() != null)
				{
					pstmt.setInt(5,bean.getElementaryThird());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}

				if(bean.getElementaryFourth() != null)
				{
					pstmt.setInt(6,bean.getElementaryFourth());
				}
				else
				{
					pstmt.setNull(6,Types.INTEGER);
				}

				if(bean.getElementaryFifth() != null)
				{
					pstmt.setInt(7,bean.getElementaryFifth());
				}
				else
				{
					pstmt.setNull(7,Types.INTEGER);
				}

				if(bean.getElementarySixth() != null)
				{
					pstmt.setInt(8,bean.getElementarySixth());
				}
				else
				{
					pstmt.setNull(8,Types.INTEGER);
				}

				if(bean.getJuniorFirst() != null)
				{
					pstmt.setInt(9,bean.getJuniorFirst());
				}
				else
				{
					pstmt.setNull(9,Types.INTEGER);
				}

				if(bean.getJuniorSecond() != null)
				{
					pstmt.setInt(10,bean.getJuniorSecond());
				}
				else
				{
					pstmt.setNull(10,Types.INTEGER);
				}
				if(bean.getJuniorThird() != null)
				{
					pstmt.setInt(11,bean.getJuniorThird());
				}
				else
				{
					pstmt.setNull(11,Types.INTEGER);
				}

				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = findByPrimaryKey(bean.getSchoolId(),bean.getAnniversary());
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String UPDATE = "UPDATE GradeStudent SET elementaryFirst = ?,elementarySecond = ?,elementaryThird = ?,elementaryFourth = ?,elementaryFifth = ?,elementarySixth = ?,juniorFirst = ?,juniorSecond = ?,juniorThird = ? WHERE schoolId = ? AND anniversary = ?";

	public GradeStudentBean update(GradeStudentBean bean)
	{
		GradeStudentBean result = null;
		if(bean != null)
		{
			try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);)
			{
				if(bean.getElementaryFirst() != null)
				{
					pstmt.setInt(1,bean.getElementaryFirst());
				}
				else
				{
					pstmt.setNull(1,Types.INTEGER);
				}

				if(bean.getElementarySecond() != null)
				{
					pstmt.setInt(2,bean.getElementarySecond());
				}
				else
				{
					pstmt.setNull(2,Types.INTEGER);
				}

				if(bean.getElementaryThird() != null)
				{
					pstmt.setInt(3,bean.getElementaryThird());
				}
				else
				{
					pstmt.setNull(3,Types.INTEGER);
				}

				if(bean.getElementaryFourth() != null)
				{
					pstmt.setInt(4,bean.getElementaryFourth());
				}
				else
				{
					pstmt.setNull(4,Types.INTEGER);
				}

				if(bean.getElementaryFifth() != null)
				{
					pstmt.setInt(5,bean.getElementaryFifth());
				}
				else
				{
					pstmt.setNull(5,Types.INTEGER);
				}

				if(bean.getElementarySixth() != null)
				{
					pstmt.setInt(6,bean.getElementarySixth());
				}
				else
				{
					pstmt.setNull(6,Types.INTEGER);
				}

				if(bean.getJuniorFirst() != null)
				{
					pstmt.setInt(7,bean.getJuniorFirst());
				}
				else
				{
					pstmt.setNull(7,Types.INTEGER);
				}

				if(bean.getJuniorSecond() != null)
				{
					pstmt.setInt(8,bean.getJuniorSecond());
				}
				else
				{
					pstmt.setNull(8,Types.INTEGER);
				}
				if(bean.getJuniorThird() != null)
				{
					pstmt.setInt(9,bean.getJuniorThird());
				}
				else
				{
					pstmt.setNull(9,Types.INTEGER);
				}
				
				pstmt.setInt(10,bean.getSchoolId());
				pstmt.setInt(11,bean.getAnniversary());
				int i = pstmt.executeUpdate();
				if(i == 1)
				{
					result = this.findByPrimaryKey(bean.getSchoolId(),bean.getAnniversary());
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM GradeStudent WHERE schoolId = ? AND anniversary = ?";

	public boolean delete(int schoolId,int anniversary)
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE);)
		{
			pstmt.setInt(1,schoolId);
			pstmt.setInt(2,anniversary);
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
		GradeStudentDAOJdbc jdbc = new GradeStudentDAOJdbc();
		GradeStudentBean bean = new GradeStudentBean();
		bean.setSchoolId(11503);
		bean.setAnniversary(101);
		bean.setElementaryFirst(126);
		bean.setElementarySecond(111);
		bean.setElementaryThird(107);
		bean.setElementaryFourth(113);
		bean.setElementaryFifth(100);
		bean.setElementarySixth(107);

		GradeStudentBean bean2 = new GradeStudentBean();
		bean2.setSchoolId(11503);
		bean2.setAnniversary(100);
		bean2.setElementaryFirst(126);
		bean2.setElementarySecond(111);
		bean2.setElementaryThird(107);
		bean2.setElementaryFourth(113);
		bean2.setElementaryFifth(100);
		bean2.setJuniorFirst(777);
		System.out.println(jdbc.insert(bean));
		System.out.println(jdbc.findByPrimaryKey(11503,103));
		System.out.println(jdbc.update(bean2));
		System.out.println(jdbc.delete(21503,100));
		System.out.println(jdbc.getAll().size());

	}
}

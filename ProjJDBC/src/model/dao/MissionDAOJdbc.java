package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import model.MissionBean;

public class MissionDAOJdbc
{
	private static final String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=TCPIP";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String FIND_BY_PRIMARYKEY = "SELECT missionId,missionSetId,name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionSetId FROM Mission WHERE missionId = ?";
	public MissionBean findByPrimaryKey(int id)
	{
		MissionBean result = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(FIND_BY_PRIMARYKEY);)
		{
			pstmt.setInt(1,id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next())
				{
					result = new MissionBean();
					result.setMissionId(rs.getInt(1));
					result.setMissionSetId(rs.getInt(2));
					result.setName(rs.getString(3));
					result.setHost(rs.getInt(4));
					result.setEndTime(rs.getDate(5));
					result.setMissionPriority(rs.getInt(6));
					result.setMissionPosition(rs.getInt(7));
					result.setMissionStatus(rs.getString(8));
					result.setMainMissionSetId(rs.getInt(9));
				}
			}
			catch(Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String[] args[])
	{
		MissionDAOJdbc dao = new MissionDAOJdbc();
		 
		// findByPrimaryKey
		MissionBean findByPKBean;
		findByPKBean = dao.findByPrimaryKey(1);
		System.out.println(findByPKBean);
	}
}

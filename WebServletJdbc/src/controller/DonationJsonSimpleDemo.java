package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.sql.*;

@WebServlet("/DonationJsonSimpleDemo")
public class DonationJsonSimpleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=TCPIP";
		String query = "select name from school where name like  ?";
		String keyword = request.getParameter("term");
		System.out.println("keyword "+keyword);
		keyword = "%" + keyword + "%";
		try{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(url, "sa", "sa123456");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			
			rs = stmt.executeQuery();
			JSONArray list = new JSONArray();
			 while (rs.next())
			 {
				 list.add(rs.getString(1));
			 }
			 out.print(list.toJSONString());
			 System.out.println("@@");
			 System.out.println("list "+list);
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		}
		finally{
			if(rs != null){
			   try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("搜尋時出現錯誤 1");
			}
			}
			if(stmt != null){
			 try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("搜尋時出現錯誤 2");
			}
			}
			if(conn != null){
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

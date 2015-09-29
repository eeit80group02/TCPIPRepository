package _init;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import global.GlobalService;
@WebServlet("/fakeInfos.do")
public class InsertFakeInfos extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("projAbstract");
		
		String updateToDataBase = "update fullproj set content=? where fullProjId=?";
		
		
		try{
			Context context = new InitialContext();
			
			DataSource datasorce = (DataSource)context.lookup(GlobalService.JNDI);
			Connection conn = datasorce.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(updateToDataBase);
			pstmt.setString(1, content);
			pstmt.setInt(2, 13);
			pstmt.execute();
			
			pstmt.close();
			conn.close();
			
		}catch(SQLException | NamingException e){
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
}

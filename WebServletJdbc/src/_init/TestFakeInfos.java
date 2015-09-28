package _init;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/fakes.show")
public class TestFakeInfos extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		try{
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup(GlobalService.JNDI);
			Connection conn = datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select content from fulProj");
			ResultSet rs = pstmt.executeQuery();
			List<String> list = new ArrayList<String>();
			
			while(rs.next()){
				
				String result = rs.getString(1);
				list.add(result);
			}
			
			request.setAttribute("testresult", list);
			request.getRequestDispatcher("/error/testFakeInfos.jsp").forward(request, response);
			return;
		}catch(SQLException | NamingException e){
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}

package donation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/GetCityServlet")
public class GetCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.init
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String city = request.getParameter("city");
		System.out.println("city="+city);
		
		// 1.Send Get request header to server.
		//   Get the response Html page.
		HttpPost httpPost = new HttpPost("https://www.e-can.com.tw/CityService.asmx/GetAll");
		httpPost.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
		httpPost.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpPost.addHeader("Cache-Control", "no-cache");
		httpPost.addHeader("Connection", "keep-alive");
		httpPost.addHeader("Pragma", "no-cache");
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Host", "www.e-can.com.tw");
		httpPost.addHeader("Referer", "https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpPost.addHeader("User-Agent", "Mozilla");
		httpPost.addHeader("X-Requested-With","XMLHttpRequest");
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("city", city);
		System.out.println("json="+jsonObj);
		String jsonString = jsonObj.toString();
		StringEntity se = new StringEntity(jsonString, HTTP.UTF_8); 
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httpPost.setEntity(se);
		CloseableHttpResponse resp = httpclient.execute(httpPost);
		
		// show server response status > GET 200 OK
		System.out.println(resp.getStatusLine());
		
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		HttpEntity entity = resp.getEntity();
		// show entity
		// System.out.println("entity="+entity);

		String json = EntityUtils.toString(resp.getEntity());
//		 show html page
		 System.out.println(json);
		 
		JSONObject jo = null;
		try {
			jo = (JSONObject) new JSONParser().parse(json);
			System.out.println(jo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jo);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
	

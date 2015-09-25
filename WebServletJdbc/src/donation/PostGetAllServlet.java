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
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/PostGetAllServlet")
public class PostGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.init
		String CAPTCHA = request.getParameter("CAPTCHA");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("https://www.e-can.com.tw/PregetService.asmx/GetAll");
		httpPost.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
		httpPost.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpPost.addHeader("Connection", "Keep-Alive");
		httpPost.addHeader("Host", "www.e-can.com.tw");
		httpPost.addHeader("Referer","https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpPost.addHeader("User-Agent", "Mozilla");
		
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		StringBuilder sb = new StringBuilder();
		sb.append("CAPTCHA="+CAPTCHA+"; ");
		for (int i = 1; i < cookies.length; i++) {
			javax.servlet.http.Cookie c = cookies[i];
			sb.append(c.getName() + "=" + c.getValue() + "; ");
			System.out.println(c.getName() + "=" + c.getValue());
		}
		System.out.println("StringBulider = "+sb.toString() + "\n\n");
		httpPost.addHeader("Cookie",sb.toString());
		
		JSONObject jo = new JSONObject();
		jo.put("preget_dt", "2015-09-16");
		StringEntity postingString = new StringEntity(jo.toJSONString());
		httpPost.setEntity(postingString);
		httpPost.setHeader("Content-type", "application/json");
		
		CloseableHttpResponse resp = httpClient.execute(httpPost);
		System.out.println(resp.getStatusLine());
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		
		String jsonString = EntityUtils.toString(resp.getEntity());		
		JSONObject respJo = null;
		try {
			respJo = (JSONObject) new JSONParser().parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.addHeader("Content-Type", "application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(respJo);
		out.flush();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
	

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class GetGoogleAnalyticsJavaScriptServlet
 */
@WebServlet("/GetGoogleAnalyticsJavaScriptServlet.js")
public class GetGoogleAnalyticsJavaScriptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// 1.Get ga.js from google
		System.out.println("==========Send request to google analytics for ga.js==========");
		HttpGet  httpGet = new HttpGet("http://www.google-analytics.com/ga.js");
		httpGet.addHeader("Referer", "https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpGet.addHeader("Accept", "*/*");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate");
		httpGet.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.addHeader("Connection", "Keep-Alive");
		httpGet.addHeader("Host", "ssl.google-analytics.com");
		httpGet.addHeader("User-Agent", "Mozilla");
		CloseableHttpResponse resp = httpClient.execute(httpGet);
		System.out.println();
		
		System.out.println(resp.getStatusLine());
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		
		// 2.get response entity and send as javascript to donation.jsp
		HttpEntity entity = resp.getEntity();		
		String ga = EntityUtils.toString(resp.getEntity());		
		int placeholder = ga.indexOf("He()?!1:!0;")+11;
		System.out.println("offset is "+placeholder);
		String gaFixed = new StringBuilder(ga).insert(placeholder, "document.cookie=a+'='+b+'; ';").toString();
//		System.out.println("ga.js: \n"+gaFixed+"\n\n");
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(gaFixed);
		

		resp.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

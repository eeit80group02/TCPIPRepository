package idChecker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

//import sun.misc.BASE64Encoder;

@WebServlet("/GetIdCheckerCaptchaServlet")
public class GetIdCheckerCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.init
		String captchaURL = null;
		String captchaKey = null;
		String captchaImage = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		
		// 1.Send Get request header to server.
		//   Get the response Html page.
		HttpGet httpGet = new HttpGet("https://www.ris.gov.tw/307");
		httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate");
		httpGet.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.addHeader("Connection", "Keep-Alive");
		httpGet.addHeader("Host", "www.ris.gov.tw");
		httpGet.addHeader("User-Agent", "Mozilla");
		CloseableHttpResponse resp = httpClient.execute(httpGet);
		
		// show server response status > GET 200 OK
		System.out.println(resp.getStatusLine());
		
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		HttpEntity entity = resp.getEntity();
		// show entity
		// System.out.println("entity="+entity);

		String html = EntityUtils.toString(resp.getEntity());
		// show html page
		// System.out.println(html);
		
		// 2.Use Jsoup to parse html page.
		//   Select cssString to get captchaURL and captchaKey source.
		Document htmlDoc = Jsoup.parse(html);
		Elements elements = htmlDoc.select("script");
		captchaURL = "https://www.ris.gov.tw" + elements.get(4).toString().substring(1111, 1176) + "&time="
				+ String.valueOf(System.currentTimeMillis());
		captchaKey = elements.get(4).toString().substring(1144, 1176);
		
		// show URL and KEY
		System.out.println("captchaURL=" + captchaURL);
		System.out.println("captchaKEY=" + captchaKey);

		// 3.Send GET request to get the captchaImage source.
		//   Encode source to base64 String.
		httpGet = new HttpGet(captchaURL + "&time=" + String.valueOf(System.currentTimeMillis()));
		httpGet.addHeader("Referer", "https://www.ris.gov.tw/id_card/");
		httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate");
		httpGet.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.addHeader("Connection", "Keep-Alive");
		httpGet.addHeader("Cookie", "HttpOnly; HttpOnly");
		httpGet.addHeader("Host", "www.ris.gov.tw");
		httpGet.addHeader("User-Agent", "Mozilla");
		resp = httpClient.execute(httpGet);
		System.out.println(resp.getStatusLine());
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		entity = resp.getEntity();
		InputStream instream = entity.getContent();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bytes = new byte[instream.available()];
		int reads = instream.read();
		while (reads != -1) {
			baos.write(reads);
			reads = instream.read();
		}
		bytes = baos.toByteArray();

//		captchaImage = "data:image/png;base64," + new BASE64Encoder().encode(bytes);
		// show captchaImage of base64 code
		// System.out.println(captchaImage);
		EntityUtils.consume(entity);

		resp.close();
		
		// 4.Use Json format to wrap url, key and source string.
		//	 Then send response to ajax request from index.jsp	 
		JSONObject jo = new JSONObject();
		jo.put("captchaURL", captchaURL);
		jo.put("captchaKey", captchaKey);
		jo.put("captchaImage", captchaImage);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jo);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
	

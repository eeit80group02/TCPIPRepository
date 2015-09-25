package donation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sun.misc.BASE64Encoder;

@WebServlet("/GetDonationInfoServlet")
public class GetDonationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.init
		String captchaURL = null;
		String captchaImage = null;
		BasicCookieStore cookieStore = new BasicCookieStore();
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		// 1.Send Get request header to server.
		// Get the response Html page.
		System.out.println("==========Send Request to e-can server==========");
		HttpGet httpGet = new HttpGet("https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate");
		httpGet.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.addHeader("Connection", "Keep-Alive");
		httpGet.addHeader("Host", "www.e-can.com.tw");
		httpGet.addHeader("User-Agent", "Mozilla");
		CloseableHttpResponse resp = httpClient.execute(httpGet);
		System.out.println();

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
		// Select cssString to get captchaURL and captchaKey source.
		Document htmlDoc = Jsoup.parse(html);
		Elements elementEventTarget = htmlDoc.select("#__EVENTTARGET");
		Elements elementEventArgument = htmlDoc.select("#__EVENTARGUMENT");
		Elements elementViewState = htmlDoc.select("#__VIEWSTATE");
		Elements elementViewStateGenerrator = htmlDoc.select("#__VIEWSTATEGENERATOR");
		Elements elementddlGetdate = htmlDoc.select("#ddlGetdate > option");
		// info for post later
		String __EVENTTARGET = elementEventTarget.val();
		String __EVENTARGUMENT = elementEventArgument.val();
		String __VIEWSTATE = elementViewState.val();
		String __VIEWSTATEGENERATOR = elementViewStateGenerrator.val();
		int count = 0;
		JSONObject joOption = new JSONObject();
		for (Element e : elementddlGetdate) {
			joOption.put(count++, e.toString());
		}
		System.out.println("joOption = " +joOption);
		
		Elements elementCaptcha = htmlDoc.select("#captcha");
		System.out.println(elementCaptcha.attr("src"));
		captchaURL = "https://www.e-can.com.tw/" + elementCaptcha.attr("src");

		// show URL
		System.out.println("captchaURL=" + captchaURL);

		// 3.Send GET request to get the captchaImage source.
		// Encode source to base64 String.
		System.out.println("==========Send request to e-can for captcha image==========");
		httpGet = new HttpGet(captchaURL);
		httpGet.addHeader("Referer", "https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate");
		httpGet.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.addHeader("Connection", "Keep-Alive");
		httpGet.addHeader("Host", "www.e-can.com.tw");
		httpGet.addHeader("User-Agent", "Mozilla");
		resp = httpClient.execute(httpGet);
		System.out.println();

		List<Cookie> cookies = cookieStore.getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println("- " + cookies.get(i).toString());
			}
		}
		System.out.println("cookieName= " + cookies.get(0).getName());
		System.out.println("cookieValue= " + cookies.get(0).getValue());
		System.out.println();

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

		captchaImage = "data:image/png;base64," + new BASE64Encoder().encode(bytes);
		// show captchaImage of base64 code
		// System.out.println(captchaImage);
		EntityUtils.consume(entity);

		// 4.Use Json format to wrap url, key and source string.
		// Then send response to ajax request from index.jsp
		JSONObject jo = new JSONObject();
		jo.put("__EVENTTARGET", __EVENTTARGET);
		jo.put("__EVENTARGUMENT", __EVENTARGUMENT);
		jo.put("__VIEWSTATE", __VIEWSTATE);
		jo.put("__VIEWSTATEGENERATOR", __VIEWSTATEGENERATOR);
		jo.put("captchaURL", captchaURL);
		jo.put("captchaImage", captchaImage);
		jo.put(cookies.get(0).getName(), cookies.get(0).getValue());
		String bothJson = "["+jo+","+joOption+"]";		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8"); 
		PrintWriter out = response.getWriter();
		out.print(bothJson);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

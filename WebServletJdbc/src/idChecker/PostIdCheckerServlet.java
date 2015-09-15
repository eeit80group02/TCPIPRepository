package idChecker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@WebServlet("/PostIdCheckerServlet")
public class PostIdCheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.init
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// 1.Get parameter value from jsp
		String idnum = request.getParameter("idnum");
		String applyTWY = request.getParameter("applyTWY");
		String applyMM = request.getParameter("applyMM");
		String applyDD = request.getParameter("applyDD");
		String siteId = request.getParameter("siteId");
		String applyReason = request.getParameter("applyReason");
		String captchaInput = request.getParameter("captchaInput");
		String captchaKey = request.getParameter("captchaKey");
		
		// 2.Set post send to server
		HttpPost httpPost = new HttpPost("https://www.ris.gov.tw/id_card/query");
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
		httpPost.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpPost.addHeader("Cookie","HttpOnly; HttpOnly");
		httpPost.addHeader("Connection", "Keep-Alive");
		httpPost.addHeader("Host", "www.ris.gov.tw");
		httpPost.addHeader("Referer","https://www.ris.gov.tw/id_card/");
		httpPost.addHeader("User-Agent", "Mozilla");
		
		// Define NameValuePair for request query parameter
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("captchaKey", captchaKey));
		nvps.add(new BasicNameValuePair("idnum", idnum));
		nvps.add(new BasicNameValuePair("applyTWY", applyTWY));
		nvps.add(new BasicNameValuePair("applyMM", applyMM));
		nvps.add(new BasicNameValuePair("applyDD", applyDD));
		nvps.add(new BasicNameValuePair("siteId", siteId));
		nvps.add(new BasicNameValuePair("applyReason", applyReason));
		nvps.add(new BasicNameValuePair("captchaInput", captchaInput));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse resp = httpClient.execute(httpPost);
		
		// 3.Get response status and headers
		//   Parse result html String into Jsoup
		System.out.println(resp.getStatusLine());
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		HttpEntity entity = resp.getEntity();
		String html = EntityUtils.toString(resp.getEntity());		
		Document htmlDoc = Jsoup.parse(html);
		
		// 4.Find result content and response index.jsp to show success or not
		Elements e = htmlDoc.select("table.wwResult tr td");
		System.out.println("Element="+e.last().text());
		String resultString = e.last().text();
		if(resultString.equalsIgnoreCase("國民身分證資料與檔存資料相符。")){
//			System.out.println("身分驗證正確!");
			response.setHeader("Content-Type", "text/plain; charset=UTF-8");
		    response.setHeader("success", "yes");
		    PrintWriter writer = response.getWriter();
		    request.getSession().setAttribute("sucidnum", idnum);
		    writer.write("身分驗證正確!");
		    writer.close();
		} else{
//			System.out.println("驗證資料有誤!");
			response.setHeader("Content-Type", "text/plain; charset=UTF-8");
		    response.setHeader("success", "yes");
		    PrintWriter writer = response.getWriter();
		    writer.write("驗證資料有誤!");
		    writer.close();
		}

	}

}

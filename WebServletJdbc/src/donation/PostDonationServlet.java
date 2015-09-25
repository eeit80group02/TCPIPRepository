package donation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@WebServlet("/PostDonationServlet")
public class PostDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0.init
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 1.Get parameter value from jsp
		String __EVENTTARGET = request.getParameter("__EVENTTARGET");
		String __EVENTARGUMENT = request.getParameter("__EVENTARGUMENT");
		String __VIEWSTATE = request.getParameter("__VIEWSTATE");
		String __VIEWSTATEGENERATOR = request.getParameter("__VIEWSTATEGENERATOR");
		String ddlpkgCount = request.getParameter("ddlpkgCount");
		String ddlGetdate = request.getParameter("ddlGetdate");
		String chkTrimtime = request.getParameter("chkTrimtime");
		String chkSpec = request.getParameter("chkSpec");
		String txtOcname = request.getParameter("txtOcname");
		String ddlOcname_ex = request.getParameter("ddlOcname_ex");
		String ddlCity = request.getParameter("ddlCity");
		String ddlArea = request.getParameter("ddlArea");
		String hidArea = request.getParameter("hidArea");
		String txtPostno = request.getParameter("txtPostno");
		String txtOaddress = request.getParameter("txtOaddress");
		String txtOtel = request.getParameter("txtOtel");
		String txtOmobile = request.getParameter("txtOmobile");
		String txtOemail = request.getParameter("txtOemail");
		String chkSame = request.getParameter("chkSame");
		String txtGcname = request.getParameter("txtGcname");
		String ddlGcname_ex = request.getParameter("ddlGcname_ex");
		String ddlCity1 = request.getParameter("ddlCity1");
		String ddlArea1 = request.getParameter("ddlArea1");
		String hidArea1 = request.getParameter("hidArea1");
		String txtPostno1 = request.getParameter("txtPostno1");
		String txtGaddress = request.getParameter("txtGaddress");
		String txtGtel = request.getParameter("txtGtel");
		String txtGmobile = request.getParameter("txtGmobile");
		String txtPkgexp = request.getParameter("txtPkgexp");
		String ddlPkgtype01 = request.getParameter("ddlPkgtype01");
		String txtPkgremark = request.getParameter("txtPkgremark");
		String chkAgree = request.getParameter("chkAgree");
		String CAPTCHA = request.getParameter("CAPTCHA");
		String btnSend = request.getParameter("btnSend");

		// check variable value
		System.out.println("__EVENTTARGET=" + __EVENTTARGET);
		System.out.println("__EVENTARGUMENT=" + __EVENTARGUMENT);
		System.out.println("__VIEWSTATE=" + __VIEWSTATE);
		System.out.println("__VIEWSTATEGENERATOR=" + __VIEWSTATEGENERATOR);
		System.out.println("ddlpkgCount=" + ddlpkgCount);
		System.out.println("ddlGetdate=" + ddlGetdate);
		System.out.println(chkTrimtime + "=on");
		System.out.println(chkSpec + "=on");
		System.out.println("txtOcname=" + txtOcname);
		System.out.println("ddlOcname_ex=" + ddlOcname_ex);
		System.out.println("ddlCity=" + ddlCity);
		System.out.println("ddlArea=" + ddlArea);
		System.out.println("hidArea=" + hidArea);
		System.out.println("txtPostno=" + txtPostno);
		System.out.println("txtOaddress=" + txtOaddress);
		System.out.println("txtOtel=" + txtOtel);
		System.out.println("txtOmobile=" + txtOmobile);
		System.out.println("txtOemail=" + txtOemail);
		System.out.println("chkSame=" + chkSame);
		System.out.println("txtGcname=" + txtGcname);
		System.out.println("ddlGcname_ex=" + ddlGcname_ex);
		System.out.println("ddlCity1=" + ddlCity1);
		System.out.println("ddlArea1=" + ddlArea1);
		System.out.println("hidArea1=" + hidArea1);
		System.out.println("txtPostno1=" + txtPostno1);
		System.out.println("txtGaddress=" + txtGaddress);
		System.out.println("txtGtel=" + txtGtel);
		System.out.println("txtGmobile=" + txtGmobile);
		System.out.println("txtPkgexp=" + txtPkgexp);
		System.out.println("ddlPkgtype01=" + ddlPkgtype01);
		System.out.println("txtPkgremark=" + txtPkgremark);
		System.out.println("chkAgree=" + chkAgree);
		System.out.println("CAPTCHA=" + CAPTCHA);
		System.out.println("btnSend=" + btnSend);
		System.out.println("==========END OF VAILDATE==========");

		// 2.Set Post Header
		HttpPost httpPost = new HttpPost("https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
		httpPost.addHeader("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpPost.addHeader("Connection", "Keep-Alive");
		httpPost.addHeader("Host", "www.e-can.com.tw");
		httpPost.addHeader("Referer", "https://www.e-can.com.tw/reservationUNMember_online.aspx");
		httpPost.addHeader("User-Agent", "Mozilla");

		Cookie[] cookies = request.getCookies();
		StringBuilder sb = new StringBuilder();
		sb.append("CAPTCHA=" + CAPTCHA + "; ");
		for (int i = 1; i < cookies.length; i++) {
			Cookie c = cookies[i];
			sb.append(c.getName() + "=" + c.getValue() + "; ");
			System.out.println(c.getName() + "=" + c.getValue());
		}
		System.out.println("StringBulider = " + sb.toString() + "\n\n");
		httpPost.addHeader("Cookie", sb.toString());

		// Define NameValuePair for request query parameter
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("__EVENTTARGET", __EVENTTARGET));
		nvps.add(new BasicNameValuePair("__EVENTARGUMENT", __EVENTARGUMENT));
		nvps.add(new BasicNameValuePair("__VIEWSTATE", __VIEWSTATE));
		nvps.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", __VIEWSTATEGENERATOR));
		nvps.add(new BasicNameValuePair("ddlpkgCount", ddlpkgCount));
		nvps.add(new BasicNameValuePair("ddlGetdate", ddlGetdate));
		nvps.add(new BasicNameValuePair(chkTrimtime, "on"));
		nvps.add(new BasicNameValuePair(chkSpec, "on"));
		nvps.add(new BasicNameValuePair("txtOcname", txtOcname));
		nvps.add(new BasicNameValuePair("ddlOcname_ex", ddlOcname_ex));
		nvps.add(new BasicNameValuePair("ddlCity", ddlCity));
		nvps.add(new BasicNameValuePair("ddlArea", ddlArea));
		nvps.add(new BasicNameValuePair("hidArea", hidArea));
		nvps.add(new BasicNameValuePair("txtPostno", txtPostno));
		nvps.add(new BasicNameValuePair("txtOaddress", txtOaddress));
		nvps.add(new BasicNameValuePair("txtOtel", txtOtel));
		nvps.add(new BasicNameValuePair("txtOmobile", txtOmobile));
		nvps.add(new BasicNameValuePair("txtOemail", txtOemail));
		nvps.add(new BasicNameValuePair("chkSame", chkSame));
		nvps.add(new BasicNameValuePair("txtGcname", txtGcname));
		nvps.add(new BasicNameValuePair("ddlGcname_ex", ddlGcname_ex));
		nvps.add(new BasicNameValuePair("ddlCity1", ddlCity1));
		nvps.add(new BasicNameValuePair("ddlArea1", ddlArea1));
		nvps.add(new BasicNameValuePair("hidArea1", hidArea1));
		nvps.add(new BasicNameValuePair("txtPostno1", txtPostno1));
		nvps.add(new BasicNameValuePair("txtGaddress", txtGaddress));
		nvps.add(new BasicNameValuePair("txtGtel", txtGtel));
		nvps.add(new BasicNameValuePair("txtGmobile", txtGmobile));
		nvps.add(new BasicNameValuePair("txtPkgexp", txtPkgexp));
		nvps.add(new BasicNameValuePair("ddlPkgtype01", ddlPkgtype01));
		nvps.add(new BasicNameValuePair("txtPkgremark", txtPkgremark));
		nvps.add(new BasicNameValuePair("chkAgree", chkAgree));
		nvps.add(new BasicNameValuePair("CAPTCHA", CAPTCHA));
		nvps.add(new BasicNameValuePair("btnSend", btnSend));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		// 註解 start
		// send post request
		CloseableHttpResponse resp = httpClient.execute(httpPost);

		// 3.Get response status and headers
		// Parse result html String into Jsoup

		System.out.println(resp.getStatusLine());
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("**********End of Headers********** \n\n");
		HttpEntity entity = resp.getEntity();
		String html = EntityUtils.toString(resp.getEntity());
		System.out.println(html);
		String result = html.substring(html.indexOf("alert") + 7, html.indexOf("alert") + 13);
		if (result.equalsIgnoreCase("網路預約成功")) {
			String orderNumber = html.substring(html.indexOf("您的預約單號") + 7, html.indexOf("');"));
			System.out.println(orderNumber);
			response.setHeader("Content-Type", "text/plain; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write("網路預約成功！ 您的預約單號：" + orderNumber);
			writer.close();
		} else {
			response.setHeader("Content-Type", "text/plain; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write("預約失敗！");
			writer.close();
		}
		// 註解 end
	}

}

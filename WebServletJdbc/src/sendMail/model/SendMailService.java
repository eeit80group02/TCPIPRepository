package sendMail.model;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import global.GlobalService;
import model.dao.MemberDAOJdbc;

public class SendMailService {
private MemberDAOJdbc dao;
	
	public SendMailService(){
		this.dao = new MemberDAOJdbc();
	}
	
	//寄送註冊會員的驗證信(需要欄位: 會員的FirstName, 會員的註冊信箱, 會員註冊時自動產生的identityCode,會員註冊時自動產生的memberId)
	synchronized public boolean sendRegisterMail(int memberId, String firstName, String email, String identityCode) throws UnsupportedEncodingException{
		boolean result = false;
		
		//對會員帳號使用 Base64
		String encodeId = GlobalService.getBase64Encoded(String.valueOf(memberId));
		
		//send mail method-------------------------
		SendMailTLS sendMail = new SendMailTLS();
		sendMail.setUserMail(email);
		//信件主旨
		String subject = "TCPIP-註冊信";
		//信件內容
		Multipart multiPart = new MimeMultipart("alternative");
		MimeBodyPart htmlPart = new MimeBodyPart();
		
		try {
			htmlPart.setContent("<p>親愛的會員"+ firstName +" 您好,<br /> 請點選以下的連結完成認證</p>"
					+ "http://" + GlobalService.HOST + ":8080/" + GlobalService.CONTEXT_PATH + "/RegisterVerification.do?id=" + encodeId + "&code=" + identityCode, "text/html; charset=utf-8");
			multiPart.addBodyPart(htmlPart);
			
			//執行寄送信件的方法
			if(sendMail.sendMail(subject, multiPart)){
				result = true;
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
				
		return result;
	} 
	
	//寄送忘記密碼的驗證信
	synchronized public boolean sendForgotPWMail(String userEmail, int dbMemberId, String dbFirstName, byte[] dbPassword) throws UnsupportedEncodingException{
		boolean result = false;
		
		//資料型態主換
		String memberId = String.valueOf(dbMemberId);
		String password = new String(dbPassword);
		//將使用者的密碼經過base64編碼
		String encodedId = GlobalService.getBase64Encoded(memberId);
		String encodedPassword = GlobalService.getBase64Encoded(password);
		
		
		//寄件主題
		String subject = "TCPIP-重設密碼";
		
		//寄件內容
		Multipart multiPart = new MimeMultipart("alternative");
		MimeBodyPart htmlPart = new MimeBodyPart();
		try {
			htmlPart.setContent("<p>親愛的會員"+ dbFirstName +" 您好,<br /> 請點選以下的連結重新修改您的密碼</p>"
					+ "http://"+ GlobalService.HOST + ":8080/" + GlobalService.CONTEXT_PATH + "/resetPassword.do?user=" + encodedId + "&code=" + encodedPassword, "text/html; charset=utf-8");
			multiPart.addBodyPart(htmlPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		SendMailTLS sendMail = new SendMailTLS();
		sendMail.setUserMail(userEmail);
		if(sendMail.sendMail(subject, multiPart)){
			result = true;
		}
		return result;
	}
	
	
	
	
	// MemberBean 扮演封裝輸入資料的角色
//	MemberBean mb = new MemberBean(account, name, email, bytePW);
//	try {
//		MemberDAO mfio = new MemberDAO();
//		//在DB中insert 一筆記錄
//		mfio.insert(mb);
//		//取出DB內的identityCode
//		MemberBean bean1 = mfio.select(account);
//		String code = bean1.getIdentityCode();
//		System.out.println("ProcessMemberServlet: " + code);
//
//		//對會員帳號使用 Base64
//		Base64.Encoder encoder = Base64.getEncoder();
//		byte[] textByte = account.getBytes("UTF-8");
//		String encodeId = encoder.encodeToString(textByte);
//		
//		//send mail method-------------------------
//		SendMailTLS sendMail = new SendMailTLS();
//		sendMail.setUserMail(email);
//		//信件主旨
//		String subject = "TCPIP-註冊信";
//		//信件內容
//		Multipart multiPart = new MimeMultipart("alternative");
//		MimeBodyPart htmlPart = new MimeBodyPart();
//		
//		htmlPart.setContent("<p>親愛的會員"+ name +" 您好,<br /> 請點選以下的連結完成認證</p>"
//				+ "http://192.168.21.14:8080/SendMail/MemberRegister.do?id=" + encodeId + "&code=" + code, "text/html; charset=utf-8");
//		multiPart.addBodyPart(htmlPart);
//		if(sendMail.sendMail(subject, multiPart)){
//			request.setAttribute("memberBean", mb);
//			// 依照執行的結果挑選適當的view元件，送回相關訊息
//			// 產生 RequestDispatcher 物件 rd
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/register/InsertMemberSuccess.jsp");
//			// 請容器代為呼叫下一棒程式
//			rd.forward(request, response);
//		}
//		return;
//	} catch (MessagingException e) {
//		e.printStackTrace();
//	}
}

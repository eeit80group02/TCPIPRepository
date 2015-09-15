package sendMail.model;
/*
 * class Name: SendMailTLS.java
 * Subject: Send Mail
 * Author: Z.Y.
 * Date: 2015/09/09
 * 
 * The class needs jar files: javaee.jar, mail.jar
 * 
 * */
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailTLS {
	private String userEmail;
	
	public String getUserMail() {
		return userEmail;
	}

	public void setUserMail(String userEmail) {
		this.userEmail = userEmail;
	}
	//接收參數  會員id, 會員名稱, 信件主旨, 會員個別的驗證碼
	public boolean sendMail (String subject, Multipart content){
		boolean result = false;
		final String username = "eeit80group02@gmail.com";
		final String password = "eeit8002";
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			System.out.println("開始準備寄送信件......");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("eeit80group02@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(this.userEmail));
			//信件主題
			message.setSubject(subject);
			//信件內容
			message.setContent(content);
			Transport.send(message);

			System.out.println("伺服器寄送信件成功!!");
			result = true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	
	public static void main(String[] args) {

//		final String username = "eeit80group02@gmail.com";
//		final String password = "eeit8002";
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//
//		try {
//			System.out.println("Done");
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("eeit80group02@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse(userMail));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
	}
}
package register.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import global.GlobalService;
import model.MemberBean;
import model.dao.MemberDAOJdbc;
import model.service.RegisterService;
import sendMail.model.SendMailService;


/*
 * 本程式讀取使用者輸入資料，進行必要的資料轉換，檢查使用者輸入資料，
 * 進行Business Logic運算，依照Business Logic運算結果來挑選適當的畫面
 * 
 */
//在Servlet 3.0中，若要能夠處理瀏覽器送來的HTTP multipart request, 
//我們撰寫的Servlet程式必須以註釋
//『javax.servlet.annotation.MultipartConfig』來加以說明。
//
//MultipartConfig的屬性說明:
//location: 上傳之表單資料與檔案暫時存放在Server端之路徑，此路徑必須存在。
//fileSizeThreshold: 檔案的大小臨界值，超過此臨界值，上傳檔案會用存放在硬碟，
//否則存放在主記憶體。
//maxFileSize: 上傳單一檔案之長度限制，如果超過此數值，Web Container會丟出例外
//maxRequestSize: 上傳所有檔案之總長度限制，如果超過此數值，Web Container會丟出例外
@MultipartConfig(
location="",
fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/register/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register2.jsp---->ProcessMemberServlet.java,Success!!");
		request.setCharacterEncoding("utf-8");//說明傳送到本程式資料的內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errMsg = new HashMap<String, String>();
		// 準備存放註冊成功訊息的Map物件
		Map<String, String> okMsg = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgErr", errMsg); //顯示錯誤訊息
		session.setAttribute("MsgOk", okMsg);  //顯示正常訊息
		//對應資料庫的資料型態
		String account = "";                       //帳號
		String passwordStr = "";                   //密碼
		byte[] password = null;
		String checkStr = "";                      //密碼確認
		byte[] check = null;
		String lastName = "";                      //姓氏
		String firstName = "";                     //名字
		String gender = "";                        //性別
		String phone = "";                         //電話
		String cellPhone = "";                     //手機
		String birthdayStr = "";                   //生日
		java.util.Date birthday = null;
		String email = "";                         //信箱
		String address = "";                       //地址
		//大頭照專區
		byte[] picture = null;                     //上傳的照片檔案
		String pictureName = "";                   //照片名稱
		long pictureLength = 0;                    //照片的長度
		String idNumber = "";                      //身分證字號
		
		//使用者將圖片傳至Server端之inputStream
		InputStream is = null;                     //InputStream
		
		Collection<Part> parts = request.getParts(); //取出HTTP multipart request內所有的parts。"若發生request.getParts() 未定義的錯誤發生,有可能是javamail衝突導致,此時可以把Tomcat的順位往上移看看"
		if(parts != null){
			for(Part p : parts){
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				//1.讀取使用者資料
				if (p.getContentType() == null){
					if(fldName.equals("account")){
						account = value;
//						System.out.println(account);
					} else if (fldName.equals("password")){
						passwordStr = value;
//						System.out.println(passwordStr);
					} else if (fldName.equals("check")) {
						checkStr = value;
//						System.out.println(checkStr);
					} else if (fldName.equals("lastName")){
						lastName = value;
//						System.out.println(lastName);
					} else if (fldName.equals("firstName")) {
						firstName = value;
//						System.out.println(firstName);
					} else if (fldName.equals("gender")){
						gender = value;
//						System.out.println(gender);
					} else if (fldName.equals("idNumber")){
						idNumber = value;
//						System.out.println(idNumber);
					} else if (fldName.equals("phone")){
						cellPhone = value;
//						System.out.println(phone);
					} else if (fldName.equals("cellPhone")){
						cellPhone = value;
//						System.out.println(cellPhone);
					} else if(fldName.equals("birthday")){
						birthdayStr = value;
//						System.out.println(birthdayStr);
					} else if(fldName.equals("email")){
						email = value;
//						System.out.println(email);
					} else if(fldName.equals("address")){
						address = value;
//						System.out.println(address);
					}
				} else {
					pictureName = GlobalService.getFileName(p); //此為圖片檔的檔名
					if(pictureName != null && pictureName.trim().length() > 0){
						if(p.getContentType().equals("image/png") || p.getContentType().equals("image/jpeg")) // file 資料
						{
							pictureName = GlobalService.getFileName(p);  //此為圖片檔的檔名
							pictureLength = p.getSize();
							is = p.getInputStream();
						} else {
							errMsg.put("errorPictureType","請上傳格式為.jpeg, .png之圖檔");
//							System.out.println("請選擇正確格式");
						}
					} else {
						errMsg.put("errorPicture", "圖片為必填");
					}
				}
			}
			
			//2.檢查使用者輸入的資料
			//帳號
			if(account == null || account.trim().length() == 0 ){
				errMsg.put("errorAccountEmpty", "帳號為必填");
			}
			//密碼
			if(passwordStr == null || passwordStr.trim().length() == 0){
				errMsg.put("errorPasswordEmpty", "密碼為必填");
			}
			//密碼確認
			if(checkStr == null || checkStr.trim().length() == 0){
				errMsg.put("errorCheckEmpty", "密碼確認為必填");
			}
			//判斷兩密碼是否相等
			if(passwordStr.trim().length() > 0 && checkStr.trim().length() > 0){
				if (!passwordStr.trim().equals(checkStr.trim())) {
					errMsg.put("errorCheckEmpty", "密碼欄位必須與確認密碼欄位一致");
					errMsg.put("errorPasswordEmpty", "*密碼不一致");
				}
			}
			//姓氏
			if(lastName == null || lastName.trim().length() == 0 ){
				errMsg.put("errorLastNameEmpty", "姓氏為必填");
			}
			//名字
			if(firstName == null || firstName.trim().length() == 0){
				errMsg.put("errorFirstNameEmpty", "名子為必填");
			}
			//性別
			if(gender == null || gender.trim().length() == 0){
				errMsg.put("errorGenderEmpty", "性別為必填");
			}
			//電話
			if((phone == null || phone.trim().length() == 0) && (cellPhone == null || cellPhone.trim().length() == 0)){
				errMsg.put("errPhoneEmpty", "*");
				errMsg.put("errCellPhoneEmpty", "手機或電話其中一欄位為必填");
			}
			//手機
//			if(cellPhone == null || cellPhone.trim().length() == 0){
//				errMsg.put("errCellPhoneEmpty", "手機欄位為必填");
//			}
			//生日
			if(birthdayStr == null || birthdayStr.trim().length() == 0){
				errMsg.put("errorBirthdayStrEmpty", "生日為必填");
			}
			//信箱
			if(email == null || email.trim().length() == 0){
				errMsg.put("errorEmailEmpty", "信箱為必填");
			}
			//地址
			if(address == null || address.trim().length() == 0){
				errMsg.put("errorAddressEmpty", "地址為必填");
			}
			//身分證字號
			if(idNumber == null || idNumber.trim().length() == 0){
				errMsg.put("errorIdNumberEmpty", "身分證為必填");
			}
			//圖片
			if(is != null)
			{
				picture = GlobalService.convertInputStreamToByteArray(is);
				is.close();
			}
			
			//3.進行必要的資料格式轉換
//			java.util.Date birthdayStr  	       生日  e.g 1988-01-01
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(birthdayStr != null && birthdayStr.trim().length() > 0) {
				try {
					birthday = sdf.parse(birthdayStr.trim());
				} catch (ParseException e) {
					e.printStackTrace();
					errMsg.put("errFormat", "日期格式錯誤,應為yyyy-MM-dd");
				}
			}
//			byte[] passwordStr	& checkStr	       密碼
			if(passwordStr != null && checkStr != null){
				password = passwordStr.getBytes();
				check = checkStr.getBytes();
			}
		//if parts == null 則put以下錯誤訊息
		} else {
			errMsg.put("errorTitle", "此表單不是上傳檔案的表單");
		}
		
		
		// 如果有一個以上的必填欄位有錯誤
		if (!errMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("register2.jsp");
			rd.forward(request, response);
			//若以上有任一欄位錯誤則return,停止以下的程式執行
			return;
		}
		
		
		//4.進行Business Logic 運算  (呼叫其它Service)
		//檢查帳號是否存在
			//若不存在則儲存會員資料
			//並且發送驗證信件
		
		try {
			RegisterService rs = new RegisterService();
			if(rs.accountExists(account)){
				errMsg.put("errorAccountExists", "該帳號已被註冊，請更換新的帳號");
				System.out.println("該帳號已被註冊，請更換新的帳號");
			}
			if(rs.emailExists(email)){
				errMsg.put("errorEmailExists", "該信箱已被註冊，請更換新的信箱");
				System.out.println("該信箱已被註冊，請更換新的信箱");
			}
			//假如帳號和信箱都沒被使用過則進行儲存會員的動作
			if(!rs.accountExists(account) && !rs.emailExists(email)){
				//產生會員的註冊時間(insert所需)
				java.sql.Timestamp registerTime = new java.sql.Timestamp(new java.util.Date().getTime());
				
				//被推薦次數(insert所需)
				int recommendCount = 0;
				//帳號狀態(insert所需)
				String accountStatus = "待審核";
				
				int result = rs.saveMember(account, password, lastName, firstName, idNumber, gender, phone, cellPhone,
						birthday, email, registerTime, recommendCount, address, picture, pictureName, pictureLength,accountStatus);
				//該會員儲存進資料庫成功
				if(result == 1){
					//儲存註冊會員資料成功後呼叫寄信的service,寄發註冊認證信
					MemberDAOJdbc dao = new MemberDAOJdbc();
					MemberBean bean = dao.selectAccount(account);
					int memberId = bean.getMemberId();
					firstName = bean.getFirstName();
					email = bean.getEmail();
					String identityCode = bean.getIdentityCode();
					SendMailService sms = new SendMailService();
					if(sms.sendRegisterMail(memberId, firstName, email, identityCode)){
						//假如寄送註冊認證信成功則......
						okMsg.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
						//需先導向一個頁面,並顯示提示訊息e.g.  3秒後倒回首頁
						response.sendRedirect("../register/template.jsp");
						return;
					} else {
						System.out.println("register.controller----->RegisterServlet寄發註冊認證信失敗");
					}
					
				} else {
					//該會員儲存至資料庫失敗
					errMsg.put("InsertError", "新增此筆資料有誤(RegisterServlet)");
				}
				
			}
			
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request
						.getRequestDispatcher("register2.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





  
		// MemberBean 扮演封裝輸入資料的角色
//		MemberBean mb = new MemberBean(account, name, email, bytePW);
//		try {
//			MemberDAO mfio = new MemberDAO();
//			//在DB中insert 一筆記錄
//			mfio.insert(mb);
//			//取出DB內的identityCode
//			MemberBean bean1 = mfio.select(account);
//			String code = bean1.getIdentityCode();
//			System.out.println("ProcessMemberServlet: " + code);
//
//			//對會員ID使用 Base64
//			Base64.Encoder encoder = Base64.getEncoder();
//			byte[] textByte = account.getBytes("UTF-8");
//			String encodeId = encoder.encodeToString(textByte);
//			
//			//send mail method-------------------------
//			SendMailTLS sendMail = new SendMailTLS();
//			sendMail.setUserMail(email);
//			//信件主旨
//			String subject = "TCPIP-註冊信";
//			//信件內容
//			Multipart multiPart = new MimeMultipart("alternative");
//			MimeBodyPart htmlPart = new MimeBodyPart();
//			
//			htmlPart.setContent("<p>親愛的會員"+ name +" 您好,<br /> 請點選以下的連結完成認證</p>"
//					+ "http://192.168.21.14:8080/SendMail/MemberRegister.do?id=" + encodeId + "&code=" + code, "text/html; charset=utf-8");
//			multiPart.addBodyPart(htmlPart);
//			if(sendMail.sendMail(subject, multiPart)){
//				request.setAttribute("memberBean", mb);
//				// 依照執行的結果挑選適當的view元件，送回相關訊息
//				// 產生 RequestDispatcher 物件 rd
//				RequestDispatcher rd = request
//						.getRequestDispatcher("/register/InsertMemberSuccess.jsp");
//				// 請容器代為呼叫下一棒程式
//				rd.forward(request, response);
//			}
//			return;
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
	}
}

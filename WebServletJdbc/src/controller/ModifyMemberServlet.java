package controller;

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
import model.service.ModifyMemberService;
@MultipartConfig(
location="",
fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/personal/modifyMember.do")
public class ModifyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/personal.jsp call ModifyMemberServlet success!!");
		request.setCharacterEncoding("utf-8");
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errMsg = new HashMap<String, String>();
		// 準備存放註冊成功訊息的Map物件
		Map<String, String> okMsg = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgErr", errMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOk", okMsg); // 顯示正常訊息
		MemberBean bean = (MemberBean)session.getAttribute("LoginOK");
		String account = null;                       //帳號
		String gender = null;                        //性別
        String idNumber = null;						 //身分證字號
		java.util.Date registerTime = null;          //註冊日期
		String accountStatus = null;                 //帳戶狀態
		Integer recommendCount = null;               //被推薦次數
		Integer memberId = null;
		String passwordStr = null; // 密碼
		byte[] password = null;
		String checkStr = ""; // 密碼確認
		byte[] check = null;
		String lastName = ""; // 姓氏
		String firstName = ""; // 名字
		String phone = ""; // 室內電話
		String cellPhone = ""; // 手機
		String birthdayStr = ""; // 生日
		java.util.Date birthday = null;
		String email = ""; // 信箱
		String address = ""; // 地址
		// 大頭照專區
		byte[] picture = null; // 上傳的照片檔案
		String pictureName = ""; // 照片名稱
		long pictureLength = 0; // 照片的長度
	
		// 使用者將圖片傳至Server端之inputStream
		InputStream is = null; // InputStream

		Collection<Part> parts = request.getParts(); // 取出HTTP multipart request內所有的parts。"若發生request.getParts() 未定義的錯誤發生,有可能是javamail衝突導致,此時可以把Tomcat的順位往上移看看"
		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1.讀取使用者資料
				if (p.getContentType() == null) {
					if (fldName.equals("password")) {
						passwordStr = value;
//						 System.out.println(passwordStr);
					} else if (fldName.equals("check")) {
						checkStr = value;
//						 System.out.println(checkStr);
					} else if (fldName.equals("lastName")) {
						lastName = value;
//						 System.out.println(lastName);
					} else if (fldName.equals("firstName")) {
						firstName = value;
//						 System.out.println(firstName);
					} else if (fldName.equals("phone")) {
						cellPhone = value;
//						 System.out.println(phone);
					} else if (fldName.equals("cellPhone")) {
						cellPhone = value;
//						 System.out.println(cellPhone);
					} else if (fldName.equals("birthday")) {
						birthdayStr = value;
//						 System.out.println(birthdayStr);
					} else if (fldName.equals("email")) {
						email = value;
//						 System.out.println(email);
					} else if (fldName.equals("address")) {
						address = value;
//						 System.out.println(address);
					}
				} else {
					pictureName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (pictureName != null && pictureName.trim().length() > 0) {
						if (p.getContentType().equals("image/png") || p.getContentType().equals("image/jpeg")){ // file 資料
							pictureName = GlobalService.getFileName(p); // 此為圖片檔的檔名
							pictureLength = p.getSize();
							is = p.getInputStream();
						} else {
							errMsg.put("errorPictureType", "請上傳格式為.jpeg, .png之圖檔");
							System.out.println("請選擇正確格式");
						}
					} else {
						pictureName = bean.getPictureName();
						picture = bean.getPicture();
						pictureLength = bean.getPictureLength();
					}
				}
			}

//			 2.檢查使用者輸入的資料
			// 判斷兩密碼是否相等
			if (passwordStr.trim().length() > 0 && checkStr.trim().length() > 0) {
				if (!passwordStr.trim().equals(checkStr.trim())) {
					errMsg.put("errorCheckEmpty", "密碼欄位必須與確認密碼欄位一致");
					errMsg.put("errorPasswordEmpty", "*密碼不一致");
				}
			}
			// 姓氏
			if (lastName == null || lastName.trim().length() == 0) {
				errMsg.put("errorLastNameEmpty", "姓氏為必填");
			}
			// 名字
			if (firstName == null || firstName.trim().length() == 0) {
				errMsg.put("errorFirstNameEmpty", "名子為必填");
			}
			// 電話
			if ((phone == null || phone.trim().length() == 0)
					&& (cellPhone == null || cellPhone.trim().length() == 0)) {
				errMsg.put("errPhoneEmpty", "*");
				errMsg.put("errCellPhoneEmpty", "手機或電話其中一欄位為必填");
			}
			// 手機
			// if(cellPhone == null || cellPhone.trim().length() == 0){
			// errMsg.put("errCellPhoneEmpty", "手機欄位為必填");
			// }
			// 生日
			if (birthdayStr == null || birthdayStr.trim().length() == 0) {
				errMsg.put("errorBirthdayStrEmpty", "生日為必填");
			}
			// 信箱
			if (email == null || email.trim().length() == 0) {
				errMsg.put("errorEmailEmpty", "信箱為必填");
			}
			// 地址
			if (address == null || address.trim().length() == 0) {
				errMsg.put("errorAddressEmpty", "地址為必填");
			}
			// 圖片
			if (is != null) {
				picture = GlobalService.convertInputStreamToByteArray(is);
				is.close();
			}

			// 3.進行必要的資料格式轉換
			// java.util.Date birthdayStr 生日 e.g 1988-01-01
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (birthdayStr != null && birthdayStr.trim().length() > 0) {
				try {
					birthday = sdf.parse(birthdayStr.trim());
				} catch (ParseException e) {
					e.printStackTrace();
					errMsg.put("errFormat", "日期格式錯誤,應為yyyy-MM-dd");
				}
			}
			// byte[] passwordStr & checkStr 密碼
			if (passwordStr != null && checkStr != null) {
				password = passwordStr.getBytes();
				check = checkStr.getBytes();
			}
			
			
		} else {
			errMsg.put("errorTitle", "此表單不是上傳檔案的表單");
		}
		
		// 如果有一個以上的必填欄位有錯誤
		if (!errMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("personal.jsp");
			rd.forward(request, response);
			//若以上有任一欄位錯誤則return,停止以下的程式執行
			return;
		}
		
		//4.進行Business Logic 運算  (呼叫其它Service)
		ModifyMemberService service = new ModifyMemberService();
		memberId = bean.getMemberId();
		idNumber = bean.getIdNumber();
		gender = bean.getGender();
		recommendCount = bean.getRecommendCount();
		account = bean.getAccount();
		accountStatus = bean.getAccountStatus();
		registerTime = bean.getRegisterTime();
		int result = service.isModified(memberId, idNumber, gender, recommendCount, account, accountStatus,  registerTime, password, lastName, firstName, phone, cellPhone,birthday, email, address, picture, pictureName, pictureLength);
		if (result == 1){
			System.out.println("資料修改成功");
			//資料修改成功導向
			response.sendRedirect("../personal/template.jsp");
			return;
		} else {
			//該會員修改資料至資料庫失敗
			errMsg.put("InsertError", "新增此筆資料有誤(RegisterServlet)");
		}
		
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		if (!errMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request
					.getRequestDispatcher("personal.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	public static void main(String[] args) {

	}
}

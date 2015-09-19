package controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import global.GlobalService;

@WebServlet("/personal/modifyMember.do")
public class ModifyMemberServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/personal/modifyMember.do call ModifyMember success!!");
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
		// 對應資料庫的資料型態
		String passwordStr = ""; // 密碼
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
		String idNumber = ""; // 身分證字號

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
						// System.out.println(passwordStr);
					} else if (fldName.equals("check")) {
						checkStr = value;
						// System.out.println(checkStr);
					} else if (fldName.equals("lastName")) {
						lastName = value;
						// System.out.println(lastName);
					} else if (fldName.equals("firstName")) {
						firstName = value;
						// System.out.println(firstName);
					} else if (fldName.equals("phone")) {
						cellPhone = value;
						// System.out.println(phone);
					} else if (fldName.equals("cellPhone")) {
						cellPhone = value;
						// System.out.println(cellPhone);
					} else if (fldName.equals("birthday")) {
						birthdayStr = value;
						// System.out.println(birthdayStr);
					} else if (fldName.equals("email")) {
						email = value;
						// System.out.println(email);
					} else if (fldName.equals("address")) {
						address = value;
						// System.out.println(address);
					}
				} else {
					pictureName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (pictureName != null && pictureName.trim().length() > 0) {
						if (p.getContentType().equals("image/png") || p.getContentType().equals("image/jpeg")) // file
																												// 資料
						{
							pictureName = GlobalService.getFileName(p); // 此為圖片檔的檔名
							pictureLength = p.getSize();
							is = p.getInputStream();
						} else {
							errMsg.put("errorPictureType", "請上傳格式為.jpeg, .png之圖檔");
							// System.out.println("請選擇正確格式");
						}
					} else {
						errMsg.put("errorPicture", "圖片為必填");
					}
				}
			}

			// 2.檢查使用者輸入的資料
			// 密碼
			if (passwordStr == null || passwordStr.trim().length() == 0) {
				errMsg.put("errorPasswordEmpty", "密碼為必填");
			}
			// 密碼確認
			if (checkStr == null || checkStr.trim().length() == 0) {
				errMsg.put("errorCheckEmpty", "密碼確認為必填");
			}
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
			// 身分證字號
			if (idNumber == null || idNumber.trim().length() == 0) {
				errMsg.put("errorIdNumberEmpty", "身分證為必填");
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

	}

	public static void main(String[] args) {

	}
}

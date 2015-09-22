package controller;

import java.io.File;
import java.io.FileInputStream;
/*
 * 類型: servlet
 * 功能: 修改學校資料
 * 
 */
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
import model.SchoolBean;
import model.service.ModifySchoolService;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
@WebServlet("/school/modifySchool.do")
public class ModifySchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/schoolupdate.jsp call ModifySchoolServlet success!!");
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
		SchoolBean bean = (SchoolBean) session.getAttribute("school");
		
		Integer schoolId = null;			// 學校編號(教育部學校代碼)(帳號) PK
		String name = null;				// 學校名稱#
		String phone = null;				// 學校行政電話總機#
		String addressDistrict = null; 	// 學校地址(縣市)
		String addressComplete = null;	 	// 學校地址(完整)
		String url = null; 				// 學校網址#
		String aboutMe = null; 			// 關於我
		String managerEmail = null; 		// 開通帳號的聯絡人E-mail
		String projectManager = null; 		// 開通帳號的聯絡人姓名
		String accountContact = null; 		// 開通帳號的聯絡人電話(留學校完整電話+分機)
		byte[] password = null; 			// 密碼(英文+數字(不分大小寫)不給特殊字元)
		String passwordStr = null;         // 密碼
		byte[] check = null;
		String checkStr = "";             // 密碼確認
		String accountStatus = null; 		// 帳號狀態(已啟用/待認證/預設)(前台只顯示預設；待認證及已啟用者不顯示)
		
		// 大頭照專區
		byte[] frontCover = null; 			// 學校圖片#(封面)(817px*358px)
		String frontCoverName = null; // 學校圖片 檔名
		Long frontCoverLength = null; 		// 學校圖片 檔名長度

		// 使用者將圖片傳至Server端之inputStream
		InputStream is = null; // InputStream

		Collection<Part> parts = request.getParts(); // 取出HTTP multipart request內所有的parts。"若發生request.getParts() 未定義的錯誤發生,有可能是javamail衝突導致,此時可以把Tomcat的順位往上移看看"
		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1.讀取會員資料
				if (p.getContentType() == null) {
					if (fldName.equals("password")) {
						passwordStr = value;
//						 System.out.println("學校密碼:" + passwordStr);
					} else if (fldName.equals("check")) {
						checkStr = value;
//						 System.out.println("確認密碼:" + checkStr);
					} else if (fldName.equals("phone")) {       // 學校行政電話總機#
						phone = value;
//						 System.out.println("電話總機:" + phone);
					} else if (fldName.equals("addressDistrict")) {   // 學校地址(縣市)
						addressDistrict = value;
//						 System.out.println("學校地址(縣市):" + addressDistrict);
					} else if (fldName.equals("addressComplete")) {    // 學校地址(完整)
						addressComplete = value;
//						 System.out.println("學校地址(完整):" + addressComplete);
					} else if (fldName.equals("url")) {    // 學校網址#
						url = value;
//						 System.out.println("學校網址:" + url);
					} else if (fldName.equals("content")) {   // 關於我
						aboutMe = value;
//						 System.out.println("關於我:" + aboutMe);
					} else if (fldName.equals("managerEmail")) {  // 開通帳號的聯絡人E-mail
						managerEmail = value;
//						 System.out.println("聯絡人Email:" + managerEmail);
					} else if (fldName.equals("projectManager")) {  // 開通帳號的聯絡人姓名
						projectManager = value;
//						 System.out.println("聯絡人姓名:" + projectManager);
					} else if (fldName.equals("accountContact")) {  // 開通帳號的聯絡人電話(留學校完整電話+分機)
						accountContact = value;
//						 System.out.println("聯絡人電話:" + accountContact);
					} else if (fldName.equals("schoolId")) {  // 學校編號(教育部學校代碼)(帳號) PK
						schoolId = Integer.valueOf(value);
//						 System.out.println("學校編號:" + schoolId);
					} else if (fldName.equals("name")) {  // 學校名稱#
						name = value;
//						System.out.println("學校名稱:" + name);
					}
					
				} else {
					frontCoverName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (frontCoverName != null && frontCoverName.trim().length() > 0) {
						if (p.getContentType().equals("image/png") || p.getContentType().equals("image/jpeg")) { // file
																													// 資料
							frontCoverName = GlobalService.getFileName(p); // 此為圖片檔的檔名
							frontCoverLength = p.getSize();
							is = p.getInputStream();
						} else {
							errMsg.put("errorPictureType", "請上傳格式為.jpeg, .png之圖檔");
							System.out.println("請選擇正確格式");
						}
					} else {                  
						File file = new File("C:\\Users\\Student\\git\\TCPIPRepository\\WebServletJdbc\\image\\school\\default.jpg");
						is  = new FileInputStream(file);
						frontCoverName = file.getName();
						frontCoverLength = file.length();
					}
				}
			}

			// 2.檢查使用者輸入的資料
			// 判斷兩密碼是否相等
			if (passwordStr.trim().length() > 0 || checkStr.trim().length() > 0) {
				if (!passwordStr.trim().equals(checkStr.trim())) {
					errMsg.put("errorCheckEmpty", "密碼欄位必須與確認密碼欄位一致");
					errMsg.put("errorPasswordEmpty", "*密碼不一致");
				}
			}
			// 行政電話總機
			if (phone == null || phone.trim().length() == 0) {
				errMsg.put("errorPhoneEmpty", "行政電話總機為必填");
			}
			// 學校地址(縣市)
			if (addressDistrict == null || addressDistrict.trim().length() == 0) {
				errMsg.put("errorAddressDistrictEmpty", "學校地址(縣市)為必填");
			}
			// 學校地址(完整)
			if (addressComplete == null || addressComplete.trim().length() == 0) {
				errMsg.put("errorAddressCompleteEmpty", "學校地址(完整)為必填");
			}
			// 圖片
			if (is != null) {
				frontCover = GlobalService.convertInputStreamToByteArray(is);
				is.close();
			}
			//關於我
			if(aboutMe.length()>140){
				errMsg.put("textAreaLimit", "字數限制為140字以內");
			}
			

			// 3.進行必要的資料格式轉換
			// byte[] passwordStr & checkStr 密碼
			if (passwordStr != null && checkStr != null && passwordStr.trim().length() > 0 && checkStr.trim().length() > 0) {
				password = passwordStr.getBytes();
				check = checkStr.getBytes();
			}

		} else {
			errMsg.put("errorTitle", "此表單不是上傳檔案的表單");
		}

		// 如果有一個以上的必填欄位有錯誤
		if (!errMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("schoolupdate.jsp");
			rd.forward(request, response);
			// 若以上有任一欄位錯誤則return,停止以下的程式執行
			return;
		}

		// 4.進行Business Logic 運算 (呼叫其它Service)
		ModifySchoolService service = new ModifySchoolService();
		if(password == null || check == null){
			password = bean.getPassword();
		}
		if(accountStatus == null){
			accountStatus = bean.getAccountStatus();
		}
		
		int result = service.isModified(name, phone, addressDistrict, addressComplete, url, frontCoverName,
				frontCover, frontCoverLength, aboutMe, managerEmail, projectManager, accountContact, password, accountStatus, schoolId);
		if (result == 1) {
			System.out.println("資料修改成功");
			// 資料修改成功導向
			response.sendRedirect(request.getContextPath() + "/school/template.jsp");
			return;
		} else {
			// 該會員修改資料至資料庫失敗
			errMsg.put("InsertError", "新增此筆資料有誤(RegisterServlet)");
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		if (!errMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("schoolupdate.jsp");
			rd.forward(request, response);
			return;
		}

	}

}

package controller;


import global.GlobalService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.DonationBean;
import model.DonationBeanDuplicate;
import model.DonationService;
import model.SchoolBean;

@MultipartConfig(
		location="",
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*500,
		maxRequestSize = 1024*1024*500*5)
//@WebServlet("/DonateServlet")
public class DonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			// 導向登入畫面
		}
		
		// 1.接收資料
		int donationId = 0; 						// 捐獻編號(流水號)(只要物品規格不同，視為兩筆) PK
		String donationIdStr = null; 		

		SchoolBean sBean = (SchoolBean) session.getAttribute("LoginOK");
		int schoolId = sBean.getSchoolId();
		System.out.println("schoolId: "+schoolId);
		
		// 預設為否
		String donationStatus = "否"; 				// 捐獻是否完成
		String supplyName = null; 					// 物資名稱
		int originalDemandNumber = 0; 				// 原始輸入需求數量(數量)
		String originalDemandNumberStr = null; 	
		
		String originalDemandUnit = null; 			// 原始輸入需求數量(單位)
		int demandNumber = 0; 						// 現在需求數量及單位(數量)

		String size = null; 						// 尺寸規格
		String demandContent = null; 				// 需求說明(為什麼需要這項物資)
		String supplyStatus = null; 				// 物資狀態(全新/二手/不拘)
		
		// 系統預設
		java.util.Date demandTime = null; 			// 募集提出需求時間(物品開始募集時間)(即刻上架)
		java.util.Date expireTime = null; 			// 募集截止時間(物品結束募集時間)(當日0:00下架)
		
		String imageName = null; 					// 圖片檔名
		byte[] imageFile = null; 					// 圖片(需要的物品的圖片)
		long imageLength = 0; 						// 圖片長度
		String remark = null; 						// 備註(可以填寫額外的訊息)
		
		String choice = request.getParameter("hidden");
		
		InputStream is = null;
		String mimeType = null;
		Map<String,String> errorMsgs = new HashMap<>();
		request.setAttribute("errorMap", errorMsgs);
		Map<String,String> saveOK = new HashMap<>();
		request.setAttribute("saveOK", saveOK);
		
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			for(Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				if (p.getContentType() == null) {
					if(fldName.equals("donationId")) {
						if(!choice.equals("insert")){
							donationIdStr = value;
						}
						
					} else if(fldName.equals("supplyName")) {
						supplyName = value;
					} else if(fldName.equals("originalDemandNumber")) {
						originalDemandNumberStr = value;
					} else if(fldName.equals("originalDemandUnit")) {
						originalDemandUnit = value;
					} else if(fldName.equals("size")) {
						size = value;
					} else if(fldName.equals("demandContent")) {
						demandContent = value;
					} else if(fldName.equals("supplyStatus")) {
						if (choice.equals("insert")) {
							if (Integer.parseInt(value) == 1) {
							supplyStatus = "不拘";
							} else if(Integer.parseInt(value) == 2) {
								supplyStatus = "全新";
							} else if(Integer.parseInt(value) == 3) {
								supplyStatus = "二手";
							} 
						} else if(choice.equals("update")) {
							supplyStatus = value;
						}
						
					} else if(fldName.equals("remark")) {
						remark = value;
					} 
					
				} else {
					mimeType = p.getContentType();
					imageName = GlobalService.getFileName(p);
					imageLength = p.getSize();
					is = p.getInputStream();
					if (choice.equals("insert") && imageLength == 0) {
						errorMsgs.put("errorImageFile", "新增需求時，請上傳一張圖片");
						System.out.println("請上傳一張圖片");
					}
				}
			}
		}

		// 2.驗證資料
		if (schoolId == 0) {
			errorMsgs.put("errorSchoolId", "系統須帶入schoolId");
		}
		if (!choice.equals("delete")) {
			if(supplyName == null || supplyName.trim().length() == 0) {
				errorMsgs.put("errorSupplyName", "請輸入需求名稱");
			}
			if(originalDemandNumberStr == null || originalDemandNumberStr.trim().length() == 0) {
				errorMsgs.put("errorOriginalDemandNumber", "請輸入需求數量");
			}
			if(originalDemandUnit == null || originalDemandUnit.trim().length() == 0) {
				errorMsgs.put("errorOriginalDemandUnit", "請輸入需求單位");
			}
			if(size == null || size.trim().length() == 0) {
				errorMsgs.put("errorSize", "請輸入尺寸規格(物品的大小,長*寬*高)");
			}
			if(demandContent == null || demandContent.trim().length() == 0) {
				errorMsgs.put("errorDemandContent", "請輸入需求說明(為什麼需要這項物資)");
			}
			if(supplyStatus == null || supplyStatus.trim().length() == 0) {
				errorMsgs.put("errorSupplyStatus", "物資狀態(全新/二手/不拘)");
			} 
		}
		if(!choice.equals("insert")) {
			if(donationIdStr == null || donationIdStr.trim().length() == 0) {
				errorMsgs.put("errorDonationIdStr", "系統須帶入donationId");
			} 
		} 
		if (!errorMsgs.isEmpty()) {
			request.setAttribute("errorMap", errorMsgs);
			RequestDispatcher rd = request.getRequestDispatcher("ErrorAction.jsp");
			rd.forward(request, response);
			return;
		}

		// 3.資料轉換
		if (!choice.equals("delete")) {
			originalDemandNumber = Integer.parseInt(originalDemandNumberStr);
		}
		if (choice.equals("update") || choice.equals("delete")) {
			donationId = Integer.parseInt(donationIdStr);
		}

		// 輸入需求等於剩餘需求，依學校更新而產生的Bean
		DonationBean donationBean = new DonationBean();
		donationBean.setDonationId(donationId);
		donationBean.setSchoolId(schoolId);
		donationBean.setDonationStatus(donationStatus);
		donationBean.setSupplyName(supplyName);
		donationBean.setOriginalDemandNumber(originalDemandNumber);
		donationBean.setOriginalDemandUnit(originalDemandUnit);
		donationBean.setDemandNumber(originalDemandNumber);
		donationBean.setSize(size);
		donationBean.setDemandContent(demandContent);
		donationBean.setSupplyStatus(supplyStatus);
		
		// 系統設定時間
		if (!choice.equals("delete")) {
			if (choice.equals("insert")){
				demandTime = new Date(System.currentTimeMillis());
				System.out.println("demandTime: "+demandTime);
				donationBean.setDemandTime(demandTime);
				// 時間運算，預計三個月後截止
				Calendar cDate = Calendar.getInstance();
				cDate.add(Calendar.MONTH, 3);
				expireTime = cDate.getTime();
				System.out.println("expireTime: "+expireTime);
				donationBean.setExpireTime(expireTime);
				// 圖片處理
				byte[] image = GlobalService.convertInputStreamToByteArray(is);
				donationBean.setImageName(imageName);
				donationBean.setImageFile(image);
				donationBean.setImageLength(imageLength);
				donationBean.setRemark(remark);
			}
			// 更新時有傳圖片
			if (choice.equals("update") && imageLength != 0) {
				// 圖片處理
				byte[] image = GlobalService.convertInputStreamToByteArray(is);
				donationBean.setImageName(imageName);
				donationBean.setImageFile(image);
				donationBean.setImageLength(imageLength);
				donationBean.setRemark(remark);
			} else {
				donationBean.setImageLength(imageLength);
				donationBean.setRemark(remark);
			}
		}
		
		
		if (choice.equals("insert")) {
			// 4.永續層存取
			DonationService service = new DonationService();
			donationBean = service.saveDemand(donationBean);
			if (donationBean == null) {
				errorMsgs.put("Fail", "物資需求新增失敗");
				System.out.println("物資需求新增失敗");
			} else {
				saveOK.put("Success", "物資需求新增成功");
				System.out.println("物資需求新增成功");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("ErrorAction.jsp");
				rd.forward(request, response);
				return;
			}
				 	
			List<DonationBeanDuplicate> list = service.findOneAllDemands(donationBean.getSchoolId());
//			request.setAttribute("OneAllDemands", list);
			session.setAttribute("OneAllDemands", list);
			
			is.close();
			// 5.挑選適當畫面
//			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndBySchool.jsp");
//			rd.forward(request, response);
//			return;
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath()+"/donation/AllDeamndBySchool.jsp"));
			return;
			
		} else if(choice.equals("update")) {
			// 4.永續層存取
			DonationService service = new DonationService();
			DonationBean donationBeanUpdate = service.UpdateOneDemandBySchool(donationBean);
			if (donationBeanUpdate == null) {
				errorMsgs.put("Fail", "物資需求更新失敗");
				System.out.println("物資需求更新失敗");
			} else {
				saveOK.put("Success", "物資需求更新成功");
				System.out.println("物資需求更新成功");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("ErrorAction.jsp");
				rd.forward(request, response);
				return;
			}
				 	
			List<DonationBeanDuplicate> list = service.findOneAllDemands(donationBeanUpdate.getSchoolId());
			request.setAttribute("OneAllDemands", list);

			is.close();
			// 5.挑選適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndBySchool.jsp");
			rd.forward(request, response);
			return;
			
		} else if (choice.equals("delete")) {
			// 4.永續層存取
			DonationService service = new DonationService();
			boolean result = service.deleteDemand(donationId, schoolId);
			
			if (result != true) {
				errorMsgs.put("Fail", "物資需求刪除失敗");
				System.out.println("物資需求刪除失敗");
			} else {
				saveOK.put("Success", "物資需求刪除成功");
				System.out.println("物資需求刪除成功");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("ErrorAction.jsp");
				rd.forward(request, response);
				return;
			}
			
			List<DonationBeanDuplicate> list = service.findOneAllDemands(donationBean.getSchoolId());
			request.setAttribute("OneAllDemands", list);
			
			// 5.挑選適當畫面
			RequestDispatcher rd = request.getRequestDispatcher("AllDeamndBySchool.jsp");
			rd.forward(request, response);
			return;
		}
	}
}

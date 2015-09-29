package init;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import global.GlobalService;

public class InsertDonation {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Donation (schoolId, donationStatus, supplyName, originalDemandNumber, originalDemandUnit, demandNumber, size, demandContent, supplyStatus, demandTime, expireTime, imageName, imageFile, imageLength, remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start() {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			
			// 第一筆資料
			pstmt.setInt(1, 64632); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "各式包包"); // 物資名稱
			pstmt.setInt(4, 140); // 原始輸入需求
			pstmt.setString(5, "個"); // 原始輸入需求單位
			pstmt.setInt(6, 140); // 現在需求數量
			pstmt.setString(7, "不拘"); // 尺寸規格(物品的大
			pstmt.setString(8, "提供低收入戶或新入學的孩童使用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-11 10:20").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-11 10:20").getTime()));

			File file = new File("image/Donation/donation01.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "因近期為開學期間，希望各位捐贈者能踴躍捐獻"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二筆資料
			pstmt.setInt(1, 64632); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "呼拉圈"); // 物資名稱
			pstmt.setInt(4, 70); // 原始輸入需求
			pstmt.setString(5, "個"); // 原始輸入需求單位
			pstmt.setInt(6, 70); // 現在需求數量
			pstmt.setString(7, "不拘"); // 尺寸規格(物品的大
			pstmt.setString(8, "提供學生體育課使用"); // 需求說明(為什
			pstmt.setString(9, "不拘"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-10-21 18:11").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2016-01-21 18:11").getTime()));

			file = new File("image/Donation/donation02.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "因設備老舊，許多體育設備不敷使用，希望各界善心人士提供呼拉圈供孩童上課使用"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第三筆資料
			pstmt.setInt(1, 64632); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "奇異筆、麥克筆"); // 物資名稱
			pstmt.setInt(4, 50); // 原始輸入需求
			pstmt.setString(5, "隻"); // 原始輸入需求單位
			pstmt.setInt(6, 50); // 現在需求數量
			pstmt.setString(7, "粗"); // 尺寸規格(物品的大
			pstmt.setString(8, "下鄉絕育資料、行政資料標記號"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-07-01 14:30").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-10-01 14:30").getTime()));

			file = new File("image/Donation/donation03.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "期望整合不同領域的專業資源，帶給偏鄉孩童完整的教育"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第四筆資料
			pstmt.setInt(1, 64632); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "投影機"); // 物資名稱
			pstmt.setInt(4, 10); // 原始輸入需求
			pstmt.setString(5, "台"); // 原始輸入需求單位
			pstmt.setInt(6, 10); // 現在需求數量
			pstmt.setString(7, "高解析HD"); // 尺寸規格(物品的大
			pstmt.setString(8, "志工活動中與上課使用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-21 12:30").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-21 12:30").getTime()));

			file = new File("image/Donation/donation04.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "堪用，無缺零件"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第五筆資料
			pstmt.setInt(1, 64632); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "手風琴"); // 物資名稱
			pstmt.setInt(4, 8); // 原始輸入需求
			pstmt.setString(5, "台"); // 原始輸入需求單位
			pstmt.setInt(6, 8); // 現在需求數量
			pstmt.setString(7, "不拘"); // 尺寸規格(物品的大
			pstmt.setString(8, "服務使用者音樂課使用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-18 15:35").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-18 15:35").getTime()));

			file = new File("image/Donation/donation05.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "此為大型物資超出物流載運限制，如欲捐贈請直接聯絡社福機構"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第六筆資料
			pstmt.setInt(1, 44658); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "折疊桌"); // 物資名稱
			pstmt.setInt(4, 20); // 原始輸入需求
			pstmt.setString(5, "張"); // 原始輸入需求單位
			pstmt.setInt(6, 20); // 現在需求數量
			pstmt.setString(7, "不拘"); // 尺寸規格(物品的大
			pstmt.setString(8, "舉辦活動用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-07-29 12:11").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-10-29 12:11").getTime()));

			file = new File("image/Donation/donation06.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "耐用好收納佳"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第七筆資料
			pstmt.setInt(1, 44658); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "礦泉水"); // 物資名稱
			pstmt.setInt(4, 30); // 原始輸入需求
			pstmt.setString(5, "箱"); // 原始輸入需求單位
			pstmt.setInt(6, 30); // 現在需求數量
			pstmt.setString(7, "600cc"); // 尺寸規格(物品的大
			pstmt.setString(8, "校園園遊會"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-12-01 14:11").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2016-03-01 14:11").getTime()));

			file = new File("image/Donation/donation07.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "希望能募集一些礦泉水或運動飲料提供協助的志工朋友，避免在活動中發生中暑狀況"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第八筆資料
			pstmt.setInt(1, 44658); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "耳溫槍"); // 物資名稱
			pstmt.setInt(4, 10); // 原始輸入需求
			pstmt.setString(5, "隻"); // 原始輸入需求單位
			pstmt.setInt(6, 10); // 現在需求數量
			pstmt.setString(7, "一般市售耳溫槍"); // 尺寸規格(物品的大
			pstmt.setString(8, "量體溫使用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-07-31 14:30").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-01 14:30").getTime()));

			file = new File("image/Donation/donation08.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "學校保健室需要使用"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第九筆資料
			pstmt.setInt(1, 44658); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "防蚊液"); // 物資名稱
			pstmt.setInt(4, 10); // 原始輸入需求
			pstmt.setString(5, "箱"); // 原始輸入需求單位
			pstmt.setInt(6, 10); // 現在需求數量
			pstmt.setString(7, "高解析HD"); // 尺寸規格(物品的大
			pstmt.setString(8, "夏季蚊蟲較多，預防疾病傳染"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-25 13:38").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-25 13:38").getTime()));

			file = new File("image/Donation/donation09.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "進入夏季蚊蟲增多，希望可以募得一些防蚊蟲叮咬物品，謝謝"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十筆資料
			pstmt.setInt(1, 44658); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "鞋子"); // 物資名稱
			pstmt.setInt(4, 30); // 原始輸入需求
			pstmt.setString(5, "雙"); // 原始輸入需求單位
			pstmt.setInt(6, 30); // 現在需求數量
			pstmt.setString(7, "兒童"); // 尺寸規格(物品的大
			pstmt.setString(8, "供偏鄉孩童開學有新鞋穿"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-07-15 16:35").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-10-15 16:35").getTime()));

			file = new File("image/Donation/donation10.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "耐用，好穿，最好是有氣墊的款式"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十一筆資料
			pstmt.setInt(1, 94735);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "運貨用板車");// supplyName
			pstmt.setInt(4, 40);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 40);// demandNumber
			pstmt.setString(7, "長度不超過150公分");// size
			pstmt.setString(8, "搬運大型物品時需要，例如：講桌");// demandContent
			pstmt.setString(9, "二手");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-16 17:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-16 17:55").getTime()));
			pstmt.setString(15, "無");// remark

			file = new File("image/Donation/donation11.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十二筆資料
			pstmt.setInt(1, 94735);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "電風扇");// supplyName
			pstmt.setInt(4, 10);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 10);// demandNumber
			pstmt.setString(7, "14吋");// size
			pstmt.setString(8, "教室風扇數量不夠");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-18 17:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-18 17:55").getTime()));
			pstmt.setString(15, "品牌不限");// remark

			file = new File("image/Donation/donation12.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十三筆資料
			pstmt.setInt(1, 94735);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "3號電池");// supplyName
			pstmt.setInt(4, 100);// originalDemandNumber
			pstmt.setString(5, "顆");// originalDemandUnit
			pstmt.setInt(6, 50);// demandNumber
			pstmt.setString(7, "3號電池");// size
			pstmt.setString(8, "作物裡實驗需要");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-16 17:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-16 17:55").getTime()));
			pstmt.setString(15, "盡量以大廠牌的電池為主");// remark

			file = new File("image/Donation/donation13.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十四筆資料
			pstmt.setInt(1, 94735);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "75度酒精");// supplyName
			pstmt.setInt(4, 18);// originalDemandNumber
			pstmt.setString(5, "瓶");// originalDemandUnit
			pstmt.setInt(6, 18);// demandNumber
			pstmt.setString(7, "900cc");// size
			pstmt.setString(8, "保健室需要，以及消毒用");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-16 17:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-16 17:55").getTime()));
			pstmt.setString(15, "酒精屬易然物品，請小心包裝！");// remark

			file = new File("image/Donation/donation14.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 第十五筆資料
			pstmt.setInt(1, 154705);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "血壓機");// supplyName
			pstmt.setInt(4, 2);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 18);// demandNumber
			pstmt.setString(7, "一般規格");// size
			pstmt.setString(8, "保健室缺少血壓機");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-16 13:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-16 13:55").getTime()));
			pstmt.setString(15, "無");// remark
			
			file = new File("image/Donation/donation15.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 第十六筆資料
			pstmt.setInt(1, 154705);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "延長線");// supplyName
			pstmt.setInt(4, 10);// originalDemandNumber
			pstmt.setString(5, "條");// originalDemandUnit
			pstmt.setInt(6, 10);// demandNumber
			pstmt.setString(7, "5米～10米");// size
			pstmt.setString(8, "教室連接電腦的延長線數量不夠");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-16 10:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-16 10:55").getTime()));
			pstmt.setString(15, "三孔或兩孔延長線都可以！感謝！");// remark
			
			file = new File("image/Donation/donation16.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 第十七筆資料
			pstmt.setInt(1, 144628);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "室內拖鞋");// supplyName
			pstmt.setInt(4, 50);// originalDemandNumber
			pstmt.setString(5, "雙");// originalDemandUnit
			pstmt.setInt(6, 50);// demandNumber
			pstmt.setString(7, "M或L");// size
			pstmt.setString(8, "圖書館內需要");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-20 13:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-20 13:55").getTime()));
			pstmt.setString(15, "本校圖書館需穿著館內提供的拖鞋，以保持圖書館內部整潔。");// remark
			
			file = new File("image/Donation/donation17.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 第十八筆資料
			pstmt.setInt(1, 144628);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "掃把");// supplyName
			pstmt.setInt(4, 25);// originalDemandNumber
			pstmt.setString(5, "支");// originalDemandUnit
			pstmt.setInt(6, 25);// demandNumber
			pstmt.setString(7, "塑膠掃把");// size
			pstmt.setString(8, "掃把太舊");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-20 12:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-20 12:55").getTime()));
			pstmt.setString(15, "無");// remark
			
			file = new File("image/Donation/donation18.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Donation新增成功");
	}

	public static void main(String[] args) {
		InsertDonation.start();
	}
}

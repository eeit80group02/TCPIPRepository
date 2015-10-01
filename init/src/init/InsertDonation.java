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
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			// try start
			// 第一筆資料(14659 新北市 市立野柳國小)
			pstmt.setInt(1, 14659); // 學校編號 FK
			pstmt.setString(2, "否"); // 捐獻是否完成
			pstmt.setString(3, "各式包包"); // 物資名稱
			pstmt.setInt(4, 140); // 原始輸入需求
			pstmt.setString(5, "個"); // 原始輸入需求單位
			pstmt.setInt(6, 140); // 現在需求數量
			pstmt.setString(7, "不拘"); // 尺寸規格(物品的大
			pstmt.setString(8, "提供低收入戶或新入學的孩童使用"); // 需求說明(為什
			pstmt.setString(9, "全新"); // 物資狀態(全新/二手/不拘)

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setDate(10, new java.sql.Date(sdf.parse("2015-08-11 10:20").getTime()));
			pstmt.setDate(11, new java.sql.Date(sdf.parse("2015-11-11 10:20").getTime()));

			File file = new File("image/Donation/donation01.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName()); // 圖片檔名
				pstmt.setBinaryStream(13, fis, file.length()); // 圖片(需要的物品的圖片)
				pstmt.setLong(14, file.length()); // 圖片長度
				pstmt.setString(15, "因近期為開學期間，希望各位捐贈者能踴躍捐獻。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二筆資料(14659 新北市 市立野柳國小)
			pstmt.setInt(1, 14659); // 學校編號 FK
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
				pstmt.setString(15, "因設備老舊，許多體育設備不敷使用，希望各界善心人士提供呼拉圈供孩童上課使用。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第三筆資料(14659 新北市 市立野柳國小)
			pstmt.setInt(1, 14659); // 學校編號 FK
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
				pstmt.setString(15, "期望整合不同領域的專業資源，帶給偏鄉孩童完整的教育。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第四筆資料(14659 新北市 市立野柳國小)
			pstmt.setInt(1, 14659); // 學校編號 FK
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
				pstmt.setString(15, "堪用，無缺零件。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第五筆資料(14659 新北市 市立野柳國小)
			pstmt.setInt(1, 14659); // 學校編號 FK
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
				pstmt.setString(15, "此為大型物資超出物流載運限制，如欲捐贈請直接聯絡社福機構。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第六筆資料(54696 苗栗縣 縣立新開國小)
			pstmt.setInt(1, 54696); // 學校編號 FK
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
				pstmt.setString(15, "耐用好收納佳～"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第七筆資料(54696 苗栗縣 縣立新開國小)
			pstmt.setInt(1, 54696); // 學校編號 FK
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
				pstmt.setString(15, "希望能募集一些礦泉水或運動飲料提供協助的志工朋友，避免在活動中發生中暑狀況。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第八筆資料(54696 苗栗縣 縣立新開國小)
			pstmt.setInt(1, 54696); // 學校編號 FK
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

			// 第九筆資料(54696 苗栗縣 縣立新開國小)
			pstmt.setInt(1, 54696); // 學校編號 FK
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
				pstmt.setString(15, "進入夏季蚊蟲增多，希望可以募得一些防蚊蟲叮咬物品，謝謝！"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十筆資料(54696 苗栗縣 縣立新開國小)
			pstmt.setInt(1, 54696); // 學校編號 FK
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
				pstmt.setString(15, "耐用、好穿，最好是有氣墊的款式。"); // 備註(可以填寫額外的訊息)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十一筆資料(74751 彰化縣 縣立頂庄國小)
			pstmt.setInt(1, 74751);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "運貨用板車");// supplyName
			pstmt.setInt(4, 40);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 40);// demandNumber
			pstmt.setString(7, "約60公分*40公分");// size
			pstmt.setString(8, "日常用品移位需要，例如：講桌、便當籃");// demandContent
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

			// 第十二筆資料(74751 彰化縣 縣立頂庄國小)
			pstmt.setInt(1, 74751);// schoolId
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
			pstmt.setString(15, "讓作息活動可以更舒適，增進學生學習。");// remark

			file = new File("image/Donation/donation12.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十三筆資料(74751 彰化縣 縣立頂庄國小)
			pstmt.setInt(1, 74751);// schoolId
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
			pstmt.setString(15, "盡量以大廠牌的電池為主。");// remark

			file = new File("image/Donation/donation13.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第十四筆資料(74751 彰化縣 縣立頂庄國小)
			pstmt.setInt(1, 74751);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "75%酒精");// supplyName
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

			// 第十五筆資料(154705 花蓮縣 縣立奇美國小)
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

			// 第十六筆資料(154705 花蓮縣 縣立奇美國小)
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

			// 第十七筆資料(134519 屏東縣 縣立萬巒國中)
			pstmt.setInt(1, 134519);// schoolId
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

			// 第十八筆資料(134519 屏東縣 縣立萬巒國中)
			pstmt.setInt(1, 134519);// schoolId
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

			// 第十九筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "封箱膠帶");// supplyName
			pstmt.setInt(4, 90);// originalDemandNumber
			pstmt.setString(5, "卷");// originalDemandUnit
			pstmt.setInt(6, 90);// demandNumber
			pstmt.setString(7, "一般封箱膠帶");// size
			pstmt.setString(8, "防止颱風破壞玻璃");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-08-20 12:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-11-20 12:55").getTime()));
			pstmt.setString(15, "無");// remark

			file = new File("image/Donation/donation19.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "是");// donationStatus
			pstmt.setString(3, "電視機");// supplyName
			pstmt.setInt(4, 1);// originalDemandNumber
			pstmt.setString(5, "台");// originalDemandUnit
			pstmt.setInt(6, 0);// demandNumber
			pstmt.setString(7, "32吋以上");// size
			pstmt.setString(8, "行政會議室使用");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-06-20 12:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-09-20 12:55").getTime()));
			pstmt.setString(15, "螢幕壞了，行政電腦輸出重要設備！");// remark

			file = new File("image/Donation/donation20.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十一筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "是");// donationStatus
			pstmt.setString(3, "椅子");// supplyName
			pstmt.setInt(4, 100);// originalDemandNumber
			pstmt.setString(5, "張");// originalDemandUnit
			pstmt.setInt(6, 20);// demandNumber
			pstmt.setString(7, "塑膠椅子");// size
			pstmt.setString(8, "辦大型活動時需要");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-06-20 10:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-09-20 10:55").getTime()));
			pstmt.setString(15, "園遊會、家長日，讓外賓休息用。");// remark

			file = new File("image/Donation/donation21.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十二筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "時鐘");// supplyName
			pstmt.setInt(4, 12);// originalDemandNumber
			pstmt.setString(5, "個");// originalDemandUnit
			pstmt.setInt(6, 8);// demandNumber
			pstmt.setString(7, "一般時鐘");// size
			pstmt.setString(8, "實驗需要");// demandContent
			pstmt.setString(9, "二手");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-20 10:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-20 10:55").getTime()));
			pstmt.setString(15, "壁掛式時鐘，不要數字鐘。");// remark

			file = new File("image/Donation/donation22.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十三筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "空白紙張");// supplyName
			pstmt.setInt(4, 15);// originalDemandNumber
			pstmt.setString(5, "包");// originalDemandUnit
			pstmt.setInt(6, 15);// demandNumber
			pstmt.setString(7, "500張一包");// size
			pstmt.setString(8, "辦公室使用");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-22 10:55").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-22 10:55").getTime()));
			pstmt.setString(15, "紙張大小 A4、A3、B5 皆可。");// remark

			file = new File("image/Donation/donation23.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十四筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "衛生紙");// supplyName
			pstmt.setInt(4, 30);// originalDemandNumber
			pstmt.setString(5, "包");// originalDemandUnit
			pstmt.setInt(6, 30);// demandNumber
			pstmt.setString(7, "一般規格");// size
			pstmt.setString(8, "學生用餐時需要");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-27 10:58").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-27 10:58").getTime()));
			pstmt.setString(15, "無");// remark

			file = new File("image/Donation/donation24.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十五筆資料(94522 雲林縣 縣立宜梧國中)
			pstmt.setInt(1, 94522);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "頸繩(識別證帶)");// supplyName
			pstmt.setInt(4, 50);// originalDemandNumber
			pstmt.setString(5, "條");// originalDemandUnit
			pstmt.setInt(6, 10);// demandNumber
			pstmt.setString(7, "成人型");// size
			pstmt.setString(8, "製作訪客證");// demandContent
			pstmt.setString(9, "不拘");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-09-26 10:28").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2015-12-26 10:28").getTime()));
			pstmt.setString(15, "訪客進入校園時需配戴訪客證。");// remark

			file = new File("image/Donation/donation25.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 第二十六筆資料(124542 高雄市 市立那瑪夏國中)
			pstmt.setInt(1, 124542);// schoolId
			pstmt.setString(2, "否");// donationStatus
			pstmt.setString(3, "大型塑膠袋");// supplyName
			pstmt.setInt(4, 50);// originalDemandNumber
			pstmt.setString(5, "包");// originalDemandUnit
			pstmt.setInt(6, 50);// demandNumber
			pstmt.setString(7, "50*60公分");// size
			pstmt.setString(8, "各教室的垃圾桶使用");// demandContent
			pstmt.setString(9, "全新");// supplyStatus
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setTimestamp(10, new java.sql.Timestamp(sdf.parse("2015-10-01 10:58").getTime()));
			pstmt.setTimestamp(11, new java.sql.Timestamp(sdf.parse("2016-01-01 10:58").getTime()));
			pstmt.setString(15, "標準垃圾桶適用即可。");// remark

			file = new File("image/Donation/donation26.png");
			try (FileInputStream fis = new FileInputStream(file);) {
				pstmt.setString(12, file.getName());// imageName
				pstmt.setBinaryStream(13, fis, file.length());// imageFile
				pstmt.setLong(14, file.length());// imageLength
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// try end
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Donation新增成功");
	}

	public static void main(String[] args) {
		InsertDonation.start();
	}
}

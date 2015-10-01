package init;
/*
 * 本程式作用:新增數筆"初步計畫"之資料於資料庫
 * 
 */
import global.GlobalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class InsertPrimaryProj
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO PrimaryProj (memberId, title, frontCoverName, frontCover,frontCoverLength,projAbstract,content,idealPlace,activityStartTime,activityEndTime,demandNum,budget,createDate,projStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static void start()
	{
		StringBuilder content = new StringBuilder();
 		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
 	 			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
 	 		{
 				// 第一筆資料  ======================================================================
 				pstmt.setInt(1,7);				// memberId 發起者
 				pstmt.setString(2,"造神計畫");		// title    計畫名稱
 				
 				//計畫封面圖片載入
 				File file = new File("image/primaryProj/primaryProj01.jpg");
 				try(FileInputStream fis = new FileInputStream(file);)
 				{
 					pstmt.setString(3,file.getName());			// frontCoverName
 					pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
 					pstmt.setLong(5,file.length());					// frontCoverLength
 	
 					pstmt.setString(6,"幫助偏遠學校使用辦公室軟體應用");		// projAbstract 計畫摘要
 					pstmt.setString(7,"Word...Office軟體應用");		// content 計畫內容
 					pstmt.setString(8,"台中");						// idealPlace
 					
 					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
 					pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015/08/08").getTime()));  // activityStartTime
 					pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015/08/15").getTime())); // activityEndTime
 					
 					pstmt.setInt(11,20);  		// demandNum 志工人數
 					pstmt.setInt(12,200000);   	// budget
 					
 					pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015/05/28").getTime()));  //  createDate
 					pstmt.setString(14,"待洽談");  // projStatus
 					
 					pstmt.executeUpdate();
 				}
 				catch(Exception e)
 				{
 					e.printStackTrace();
 				}
 	
 				
 				// 第二筆資料  ======================================================================
 				pstmt.setInt(1,4);				// memberId 發起者
 				pstmt.setString(2,"關懷偏鄉熱血團");		// title    計畫名稱
 				
 				//計畫封面圖片載入
 				file = new File("image/primaryProj/primaryProj02.jpg");
 				try(FileInputStream fis = new FileInputStream(file);)
 				{
 					pstmt.setString(3,file.getName());				// frontCoverName
 					pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
 					pstmt.setLong(5,file.length());					// frontCoverLength
 	
 					pstmt.setString(6,"一群有理想、抱負的資策會畢業學員，具有充分的資訊技術及教學能力，希望在資訊能力上能帶領偏鄉兒童拉近資訊時代必備的能力。"); // projAbstract 計畫摘要
 					pstmt.setString(7,"我們安排基礎程式語言、scratch的教學...");		// content 計畫內容
 					pstmt.setString(8,"嘉義市");						// idealPlace
 					
 					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
 					pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015/7/1").getTime()));  // activityStartTime
 					pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015/7/15").getTime())); // activityEndTime
 					
 					pstmt.setInt(11,20);  		// demandNum 志工人數
 					pstmt.setInt(12,90000);   	// budget
 					
 					pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015/05/28").getTime()));  //  createDate
 					pstmt.setString(14,"待洽談");  // projStatus
 					
 					pstmt.executeUpdate();
 				}
 				catch(Exception e)
 			{
 					e.printStackTrace();
 				}
			// 第三筆資料  ======================================================================
			pstmt.setInt(1,8);							// memberId 發起者
			pstmt.setString(2,"亞成鳥青少年野地教育計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"每個人心中都有亮光，不一定被看見。 四天的陪伴，我們帶領青少年走入美麗的山林，遠離熟悉的生活。過程中，當面對困難和挑戰，我們說：「沒關係，這一段路我們陪你一起走」當有了跨越的勇氣，一切，也不再那麼困難。"); // projAbstract 計畫摘要
				
				File contentFile = new File("primaryContent/1.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content
				pstmt.setString(8,"台中市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-11-01").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-11-04").getTime())); // activityEndTime
				
				pstmt.setInt(11,12);  		// demandNum 志工人數
				pstmt.setInt(12,150000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-05-28").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第四筆資料  ======================================================================
			pstmt.setInt(1,8);						// memberId 發起者
			pstmt.setString(2,"友善生活實踐計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"2015年新化龍燈農藥廠事件的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？我們相信，在這塊土地上，一定還有堅持對環境友善的農民，以及默默為綠色環境努力的人們，我們期望，透過小農徵文比賽，讓這些友善環境的故事被看見，為這片土地帶來美好的滋養。更期盼，藉由小農徵文比賽、友善環境人文講座、友善綠藝市集、農事體驗小旅行…的舉辦，為這片土地盡一份心力。現在，想邀請你，支持我們的理念與行動，和我們共同邁向夢想中的友善環境。"); // projAbstract 計畫摘要
				
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/2.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容
				pstmt.setString(8,"台南市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-11-06").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-11-12").getTime())); // activityEndTime
				
				pstmt.setInt(11,18);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-06-02").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第五筆資料  ======================================================================
			pstmt.setInt(1,1);				// memberId 發起者
			pstmt.setString(2,"來自小漁村的台灣代表隊-國際參賽募資計劃");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj05.png");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"漁村的小孩不知道什麼是「夢想」，起初我們提供一個有點心吃的活動，對他們來說已經非常滿足。 「練習飛盤」這件事對於隊上大多數的孩子來說，是第一次學習如何把事情做好，我們也不斷地教導：「不管做什麼都要很專心，剩下的老師們來想辦法。」 九年過去，孩子們很努力的達到設定的目標，我們的努力終究還是不足，需要更多人的幫助與支持。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/3.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容
				
				pstmt.setString(8,"屏東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-10-15").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-10-21").getTime())); // activityEndTime
				
				pstmt.setInt(11,11);  		// demandNum 志工人數
				pstmt.setInt(12,300000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-07-31").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第六筆資料  ======================================================================
			pstmt.setInt(1,8);				// memberId 發起者
			pstmt.setString(2,"徐超斌方舟教室夢想計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"臺東縣的最南端達仁鄉，有一位超人醫師徐超斌，將自家改建成方舟教室，提供孩子們課輔、才藝、母語等課程。來自全台各院校的方向：D夥伴，為徐醫師所感動，與部落孩子們約定年年一起在方舟教室渡過每個特別的暑假。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/4.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"臺東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-12-31").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2016-01-03").getTime())); // activityEndTime
				
				pstmt.setInt(11,15);  		// demandNum 志工人數
				pstmt.setInt(12,100000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-05-07").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第七筆資料  ======================================================================
			pstmt.setInt(1,2);				// memberId 發起者
			pstmt.setString(2,"方舟計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj07.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"經過近一年的規劃、半年的募資，現在方舟計畫將進入募資的最後一天，希望能與你一起完成這通往起點的最後一哩路。改修福山教會，建立一個「方舟」，給部落居民與孩子一個棲身之所，一個舒適的環境，讓這裡成為孩子們的心靈殿堂。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/5.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"宜蘭縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-11-10").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-11-17").getTime())); // activityEndTime
				
				pstmt.setInt(11,7);  		// demandNum 志工人數
				pstmt.setInt(12,7700000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-08-04").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第八筆資料  ======================================================================
			pstmt.setInt(1,3);				// memberId 發起者
			pstmt.setString(2,"台南康家百年聚落光芒計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj08.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"隨著台灣工商社會的發展，許多人出外到都市打拼，使得農村人口高齡化，青壯人口外移，造成農村聚落逐漸沒落的現象。台南市新化區礁坑仔社區就是這樣一個老聚落，這在老聚落裡面，百年歷史的老厝正逐漸崩壞凋零，許多動人故事與美好事物隨著老人家過世而消失，這些都是台灣社會共同的無形財產，一旦流失就再也找不回來，台灣的根是長在農村的土地上，保存我們的根是刻不容緩的事，期待透過點燈與音樂會找回我們忘記的回憶。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/6.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"台南市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-12-23").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-12-27").getTime())); // activityEndTime
				
				pstmt.setInt(11,17);  		// demandNum 志工人數
				pstmt.setInt(12,90000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2014-11-16").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第九筆資料  ======================================================================
			pstmt.setInt(1,4);				// memberId 發起者
			pstmt.setString(2,"讓親愛部落學童音樂種子發芽");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj09.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"親愛村~夢想成為提琴村，一群人正努力朝這夢想前進，親愛部落的學童，每天放學努力練琴，假日下山認真學習樂器，目前有十個學生就讀草屯國中音樂班，但一學期一個人73400的學費，不是山區家庭能負擔，希望藉由大家的愛來幫助孩子們一圓音樂夢。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/7.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"南投縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-12-21").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-12-27").getTime())); // activityEndTime
				
				pstmt.setInt(11,20);  		// demandNum 志工人數
				pstmt.setInt(12,850000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-11-28").getTime()));
				pstmt.setString(14,"洽談失敗");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第十筆資料  ======================================================================
			pstmt.setInt(1,5);				// memberId 發起者
			pstmt.setString(2,"全台募殼計劃");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj10.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"你有在海邊撿過貝殼嗎？因爲環境的破壞，加上遊客的撿拾，這十幾年來螺貝殼持續減少。所以沒有螺貝殼可以藏身的寄居蟹，只好背著垃圾殼趴趴走，變成沿海難民。這些寄居蟹需要你的支持。寄居蟹有家，只要我們願意行動。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/8.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"屏東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2016-04-01").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2016-04-08").getTime())); // activityEndTime
				
				pstmt.setInt(11,10);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-11-10").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十一筆資料  ======================================================================
			pstmt.setInt(1,6);				// memberId 發起者
			pstmt.setString(2,"電池女孩繪集計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj11.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"我們是群醫學生。在因緣際會下，接觸了重症兒童關懷協會的病童們。由他們的真實經歷發想，我們創作了名為電池女孩的繪本，傳遞生命中渺小卻重要的希望。希望透過義賣繪本和募款，能長期幫助協會與病童。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/9.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"花蓮縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-04-08").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-04-14").getTime())); // activityEndTime
				
				pstmt.setInt(11,21);  		// demandNum 志工人數
				pstmt.setInt(12,150000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-11-10").getTime()));
				pstmt.setString(14,"洽談失敗");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第十二筆資料  ======================================================================
			pstmt.setInt(1,8);				// memberId 發起者
			pstmt.setString(2,"新竹縣早療據點募資計劃");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj12.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"我們是新竹縣職能治療師公會，對於0~6歲學齡前發展遲緩的孩子，我們透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。103年，我們進入了新竹縣6個醫療缺乏鄉鎮、19所幼稚園及數個家庭開始了發掘遲緩兒並提供早期療育的工作。現在，因為先/後天的弱勢與經費不足，有100多位孩子將無法取得早療補助資格而中斷療育；因此我們計劃使用FlyingV募資平台來給予協助。"); // projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("primaryContent/10.txt");
				try(BufferedReader br = new BufferedReader(new FileReader(contentFile));)
				{
					String buffer = br.readLine();
					while(buffer != null)
					{
						content.append(buffer);
						buffer = br.readLine();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				pstmt.setString(7,content.toString());			// content 計畫內容				pstmt.setString(8,"新竹縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2016-05-23").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2016-05-28").getTime())); // activityEndTime
				
				pstmt.setInt(11,10);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-01-03").getTime()));
				pstmt.setString(14,"待洽談");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("初步計畫資料 新增完成");
	}
	
	public static void main(String[] args)
	{
		InsertPrimaryProj.start();
	}
}

package init;
/*
 * 本程式作用:新增數筆"初步計畫"之資料於資料庫
 * 
 */
import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
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
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			// 第三筆資料  ======================================================================
			pstmt.setInt(1,7);							// memberId 發起者
			pstmt.setString(2,"亞成鳥青少年野地教育計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			File file = new File("image/primaryProj/primaryProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"每個人心中都有亮光，不一定被看見。 四天的陪伴，我們帶領青少年走入美麗的山林，遠離熟悉的生活。過程中，當面對困難和挑戰，我們說：「沒關係，這一段路我們陪你一起走」當有了跨越的勇氣，一切，也不再那麼困難。"); // projAbstract 計畫摘要
				pstmt.setString(7,"");		// content 計畫內容
				pstmt.setString(8,"台中市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-08-21").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-08-30").getTime())); // activityEndTime
				
				pstmt.setInt(11,12);  		// demandNum 志工人數
				pstmt.setInt(12,150000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-04-28").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第四筆資料  ======================================================================
			pstmt.setInt(1,7);				// memberId 發起者
			pstmt.setString(2,"友善生活實踐計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"2014年新化龍燈農藥廠事件的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？我們相信，在這塊土地上，一定還有堅持對環境友善的農民，以及默默為綠色環境努力的人們，我們期望，透過小農徵文比賽，讓這些友善環境的故事被看見，為這片土地帶來美好的滋養。更期盼，藉由小農徵文比賽、友善環境人文講座、友善綠藝市集、農事體驗小旅行…的舉辦，為這片土地盡一份心力。現在，想邀請你，支持我們的理念與行動，和我們共同邁向夢想中的友善環境。"); // projAbstract 計畫摘要
				pstmt.setString(7,"美麗的家園大目降(TAVOCAN)意為\"山林之地\"，為平埔族語，我們的祖先說，這是一個擁有山林之美的地方。在被隔絕的深山中，一個人沒有辦法輕易放棄。除了靠自己的雙腳走出去，沒有一個辦法可以立刻讓人回到溫暖的被窩或舒適的家。\n2014年4月，龍燈農藥廠事件對台南新化、關廟地區的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？");		// content 計畫內容
				pstmt.setString(8,"台南市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2014-11-01").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2014-11-11").getTime())); // activityEndTime
				
				pstmt.setInt(11,18);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2014-07-28").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
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
				pstmt.setString(7,"九年前，一份期盼藉運動陶冶孩子品格的心志，九年後，成了孩子代表台灣出國比賽的機會。鹽洲，一個屏東鄉下的傳統小漁村，住著許多來自弱勢家庭的孩子，單親，隔代教養，外籍新住民子女…等等。\n擔心弱勢家庭的孩子可能得不到良好的關照，教會裡的家長們於是從日本引進了躲避飛盤運動，並在飛盤課前結合品格教育，希望養成運動風氣，減少孩子週末沒事在外遊盪的情形，更打造孩子們的好品格。「品格飛盤營」因此誕生，沒想到這樣一辦，就是9年。\n久而久之，發現孩子們慢慢轉變，例如面對裁判誤判，或是比賽落後，他們的專注度都不會改變，也不會抱怨，雖然沒有到教會聚會，反倒用口號互相打氣：「感謝主」。\n「你們的學生彷彿是在上帝翅膀下成長出來的孩子，感覺好奇妙。」其他隊伍的老師對鹽洲教會孩子的表現，感到非常驚訝");		// content 計畫內容
				pstmt.setString(8,"屏東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-09-21").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-09-27").getTime())); // activityEndTime
				
				pstmt.setInt(11,11);  		// demandNum 志工人數
				pstmt.setInt(12,300000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-05-20").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第六筆資料  ======================================================================
			pstmt.setInt(1,2);				// memberId 發起者
			pstmt.setString(2,"徐超斌方舟教室夢想計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"臺東縣的最南端達仁鄉，有一位超人醫師徐超斌，將自家改建成方舟教室，提供孩子們課輔、才藝、母語等課程。來自全台各院校的方向：D夥伴，為徐醫師所感動，與部落孩子們約定年年一起在方舟教室渡過每個特別的暑假。"); // projAbstract 計畫摘要
				pstmt.setString(7,"我們是方向：D團隊，在臺東縣最南端的達仁鄉，部落超人醫師徐超斌籌建的方舟教室裡，年年舉辦暑期夢想營隊。讓部落孩子們從玩樂中學習、探索自我潛能。方向：D團隊名稱中的字母D正是Direction的開頭，我們期許與孩子們一同勾勒屬於未來方向的藍圖，也希望每個參與的孩子，結束後能帶著：D的笑臉回家。\n兩年前，我們懷抱著18歲甫從高中畢業的滿腔熱血，想做點什麼回饋社會。偶然契機下，得知有位部落醫生徐超斌，捨棄大醫院主治醫師的高薪，回鄉從事部落巡迴醫療。因醫療資源匱乏，他必須日夜看診，就診的部落老少全年不曾間歇。幾年前徐醫師更因過勞，而致中風半身癱瘓。但他沒有放棄，休養後繼續巡迴看診，高明的醫術讓他單手仍能熟稔的操作手術刀。徐醫師不僅醫病犀利，更將許多想法帶進部落，是部落孩子們眼中的「超人醫生」，而這位超人四處奔波募集資源組建一間南迴醫院的腳步更從來沒停止過。去年，在FlyingV平台上也成功達成一段里程碑。\n徐醫師將自宅改建為方舟教室，讓部落的孩子們下課之後有地方可以寫作業，也有義工媽媽料理晚餐。部落孩子們下課回家後，往往家長仍在工作，徐醫師醫生解決了孩子在外胡亂解決晚餐的問題，也確保孩子在完成作業後才開始玩樂。他更號召部落年輕人回鄉，為孩子們開設才藝課程(吉他、鼓..等等)，也尋訪部落有志之士，讓孩子在方舟教室得以學習母語、傳統舞蹈。因為部落的需要，方舟教室開始從土坂開始，在台坂、新化…等部落也陸續建立，不論大小，理念皆相同。");		// content 計畫內容
				pstmt.setString(8,"臺東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-08-30").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-09-06").getTime())); // activityEndTime
				
				pstmt.setInt(11,15);  		// demandNum 志工人數
				pstmt.setInt(12,100000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-05-07").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第七筆資料  ======================================================================
			pstmt.setInt(1,5);				// memberId 發起者
			pstmt.setString(2,"方舟計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj07.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"經過近一年的規劃、半年的募資，現在方舟計畫將進入募資的最後一天，希望能與你一起完成這通往起點的最後一哩路。改修福山教會，建立一個「方舟」，給部落居民與孩子一個棲身之所，一個舒適的環境，讓這裡成為孩子們的心靈殿堂。"); // projAbstract 計畫摘要
				pstmt.setString(7,"【福山部落：方舟計畫】\n我是林慶台，我是一位牧師，也是一位木雕師傅。「莫那魯道」只是一個曾經，為神奉獻則是永久的志業，所以，我選擇離開鎂光燈的生活，回到部落。\n從南澳來到烏來的福山，我看見許多的青春，卻也看見更多的問題，那股原住民存在的血液在我心中燃燒。把我的所能貢獻給部落，是我的使命。當我就任牧師，自請至福山赴任後，真正深入了解，才發現狀況比我想像的還要嚴重。\n福山的美是動人心魄的，離城市一個小時多的車程，就有風光明媚的自然山水、但相較於景色的美好，在人文面卻傷痕累累，傳統的耆老制度在遷村和政策的影響下早已被破壞，逐漸淡薄的祖靈信仰也難敵經濟困窘的影響，許多家庭面臨社會、道德、健康等多方面的困境，已經失去正常的生活樣貌，這些問題最直接連帶影響的，是孩子。");		// content 計畫內容
				pstmt.setString(8,"宜蘭縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2013-11-10").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2013-11-17").getTime())); // activityEndTime
				
				pstmt.setInt(11,7);  		// demandNum 志工人數
				pstmt.setInt(12,7700000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-08-04").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第八筆資料  ======================================================================
			pstmt.setInt(1,6);				// memberId 發起者
			pstmt.setString(2,"台南康家百年聚落光芒計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj08.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"隨著台灣工商社會的發展，許多人出外到都市打拼，使得農村人口高齡化，青壯人口外移，造成農村聚落逐漸沒落的現象。台南市新化區礁坑仔社區就是這樣一個老聚落，這在老聚落裡面，百年歷史的老厝正逐漸崩壞凋零，許多動人故事與美好事物隨著老人家過世而消失，這些都是台灣社會共同的無形財產，一旦流失就再也找不回來，台灣的根是長在農村的土地上，保存我們的根是刻不容緩的事，期待透過點燈與音樂會找回我們忘記的回憶。"); // projAbstract 計畫摘要
				pstmt.setString(7,"失根的我們?\n我們的根，長在老人家記憶的土壤上，\n如果我們沒將這些記憶保留下來，那我們是誰? \n尋根，3月5日元宵點燈，與我們一起照亮台南康家百年聚落。\n忙碌的生活步調中，我們都一直為了實踐理想向前邁進，但是在出外打拼的時候，有些家鄉的故事正隨著老人家離開，而逐漸消逝。早年的農村孕育了台灣的根基，隨著經濟的起飛，高樓的築起，而我們也淹沒在水泥牆中…。\n「賀啦!賀啦!抹凳企啊!」(好啦!好啦!要回去了!) \n家人的呼喚聲不斷，但回家的日子總是一延再延，老人家的離開，農村聚落的失守，當所謂的功成名就時，慕然回首，我們已失去了根，也忘了回家的路。\n遺落的山城，康家百年聚落\n就像台灣許多被遺忘的聚落一樣，這裡是個幾乎荒廢的舊山城，聚落中所有家戶皆姓康，獨特的地理位置(深藏在淺山山谷之中)，擁有豐富的人文歷史背景，聚落的建築特色。家戶門坊上映刻著〝京兆〞二字，憶述康家於清朝時期為皇族的過往，不難想像康家聚落百年前的繁華鼎盛，但那曾經的美好，卻不敵時光的變遷，如今，只能存在族人的心中。");		// content 計畫內容
				pstmt.setString(8,"台南市");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-02-23").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-02-27").getTime())); // activityEndTime
				
				pstmt.setInt(11,17);  		// demandNum 志工人數
				pstmt.setInt(12,90000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2014-11-16").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第九筆資料  ======================================================================
			pstmt.setInt(1,5);				// memberId 發起者
			pstmt.setString(2,"讓親愛部落學童音樂種子發芽");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj09.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"親愛村~夢想成為提琴村，一群人正努力朝這夢想前進，親愛部落的學童，每天放學努力練琴，假日下山認真學習樂器，目前有十個學生就讀草屯國中音樂班，但一學期一個人73400的學費，不是山區家庭能負擔，希望藉由大家的愛來幫助孩子們一圓音樂夢。"); // projAbstract 計畫摘要
				pstmt.setString(7,"親愛村介紹\n親愛村位於海拔900公尺的南投山區，鄰近奧萬大，部落村民為原住民，一半泰雅族，一半賽德克族，親愛村得天獨厚，擁有孕育提琴村的天然條件~製琴與演奏。\n提琴的木材絕大部分是楓木，而親愛村正是位於楓林區，親愛村擁有三種台灣原生種的楓木，部落村人學習製琴已一年，將來有一天會以台灣楓木製作出台灣的提琴。\n親愛國小位於親愛村，從2008年起，學校學童開始學習演奏弦樂，至今已經五年，五年來學生們每天放學留在學校練習弦樂，假日下山學習樂器，到2013年終於交出一個精彩的成績，親愛國小的第一支弦樂團，也是台灣有史以來第一支由原住民組成的絃樂團，拿下全國學生音樂大賽南投縣初賽冠軍。\n親愛村雖擁有成為提琴村天然條件，製琴的環境以及原住民天生的音樂天分，但卻缺乏雄厚的財力來栽培。\n親愛國小兩位老師王子建與陳珮文五年來不放棄的努力栽培學生，一個教製琴，一個教音樂，為的是希望將來有一天，親愛村成為台灣的提琴村。部落村人人人會製琴，人人會拉琴~");		// content 計畫內容
				pstmt.setString(8,"南投縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2014-02-21").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2014-02-27").getTime())); // activityEndTime
				
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
			pstmt.setInt(1,6);				// memberId 發起者
			pstmt.setString(2,"全台募殼計劃");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj10.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"你有在海邊撿過貝殼嗎？因爲環境的破壞，加上遊客的撿拾，這十幾年來螺貝殼持續減少。所以沒有螺貝殼可以藏身的寄居蟹，只好背著垃圾殼趴趴走，變成沿海難民。這些寄居蟹需要你的支持。寄居蟹有家，只要我們願意行動。"); // projAbstract 計畫摘要
				pstmt.setString(7,"家中的角落是否還留著某個沙灘的貝殼呢？還記得小時候塑膠盒中，從路邊買回來一隻十幾元的無辜寄居蟹嗎？因爲環境的破壞，加上遊客的撿拾，這十幾年來寄居蟹賴以為生的螺貝殼持續減少，也造成寄居蟹數量的減低，而由於寄居蟹的腹部相當脆弱，必須藉由堅硬的殼來保護自己，所以沒有螺貝殼可以藏身的寄居蟹，只好背著塑膠空瓶、玻璃瓶蓋趴趴走，變成沿海難民。\n雖然很多人都看過台灣寄居蟹背著塑膠瓶蓋的畫面，但對這些議題卻沒有全面性的了解，也欠缺整合性的社會行動相應；目前，民間雖有環保團體自發性發起還殼給寄居蟹的活動，但活動大多局限於地域性宣傳，造成寄送螺貝殼的過程中無形增加碳足跡。\n在過去還殼活動與各界人士對談中，我們發現了一些問題：大家雖然知道寄居蟹沒有殼，也很想幫助缺殼的寄居蟹，卻不知道離家最近的募殼站在哪，也不知道怎樣的殼適合寄居蟹居住，不清楚如何清洗收集到的殼等問題……。因為缺乏這些後續資訊的建構，因此大家缺少相對應的行動，於是我們建立網絡平台，期待將各地關心寄居蟹的資源整合。");		// content 計畫內容
				pstmt.setString(8,"屏東縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2014-04-01").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2014-04-08").getTime())); // activityEndTime
				
				pstmt.setInt(11,10);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2013-11-10").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十一筆資料  ======================================================================
			pstmt.setInt(1,2);				// memberId 發起者
			pstmt.setString(2,"電池女孩繪集計畫");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj11.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"我們是群醫學生。在因緣際會下，接觸了重症兒童關懷協會的病童們。由他們的真實經歷發想，我們創作了名為電池女孩的繪本，傳遞生命中渺小卻重要的希望。希望透過義賣繪本和募款，能長期幫助協會與病童。"); // projAbstract 計畫摘要
				pstmt.setString(7,"我們是誰\n我們是群醫學生。在社會重擔壓上我們肩頭前，努力睜大雙眼、張開雙臂，用心感受環境中的酸甜苦辣。比起一般人，我們何其有幸也何其不幸地，能更頻繁接觸這些撼動人心的點滴時刻，或許感人，或許傷悲。\n這個故事由醫院重症病童的真實經歷發想，經過多次錘鍊與反芻，化成一個稍嫌沉重，但也帶著些許輕盈的色彩的夢想:我們希望透過繪本，傳遞生命的故事，串聯那些瑣碎卻十分重要的希望。\n故事從頭說起……\n2013年2月，為了籌備進醫院實習前的白袍典禮，我們開始和社團法人中華民國長期住院重症兒童關懷協會合作拍攝一部影片。在影片中，我們用自己創作的繪本故事---電池女孩，將兩個看似疏遠的生命連結在一起，期待能帶領我們克服生命中的困難和挑戰。然而，影片拍攝結束後，總覺得無法將這股生命的力量傳達出去，我們開始構想更多的可能性。\n電池女孩有個夢\n拍攝影片的階段任務完成後，我們將自己創作的繪集義賣並舉辦募款活動，希望能夠長期協助重症兒童關懷協會，讓重症兒童們得到更妥善的照顧，也希望能讓更多的人認識這個故事，看見被遺忘的角落。期待透過繪本，將場景由醫院投射到讀著的生命中，再將這分關懷傳遞給病童、給整個社會。");		// content 計畫內容
				pstmt.setString(8,"花蓮縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2014-04-08").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2014-04-14").getTime())); // activityEndTime
				
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
			pstmt.setInt(1,7);				// memberId 發起者
			pstmt.setString(2,"新竹縣早療據點募資計劃");		// title    計畫名稱
			
			//計畫封面圖片載入
			file = new File("image/primaryProj/primaryProj12.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(3,file.getName());				// frontCoverName
				pstmt.setBinaryStream(4,fis,file.length()); 	// frontCover
				pstmt.setLong(5,file.length());					// frontCoverLength

				pstmt.setString(6,"我們是新竹縣職能治療師公會，對於0~6歲學齡前發展遲緩的孩子，我們透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。103年，我們進入了新竹縣6個醫療缺乏鄉鎮、19所幼稚園及數個家庭開始了發掘遲緩兒並提供早期療育的工作。現在，因為先/後天的弱勢與經費不足，有100多位孩子將無法取得早療補助資格而中斷療育；因此我們計劃使用FlyingV募資平台來給予協助。"); // projAbstract 計畫摘要
				pstmt.setString(7,"我們是新竹縣職能治療師公會，對於0~6歲學齡前發展遲緩(註1)的孩子，我們透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。103年，我們爭取到衛服部社家署的一個專案計劃，進入了新竹縣6個醫療缺乏鄉鎮、19所幼稚園及數個家庭開始了發掘遲緩兒並提供早期療育(註2)的工作。\n這一年，我們踏入了共用里民活動中心的幼稚園，感受到牆壁是鐵皮、地板是水泥地的家有多冷，也看見孩子唯一的玩具就是爸爸揀破爛做回收後剩下的瓶罐紙屑的畫面。\n同時，還發掘了120位需要早期療育的發展遲緩兒，這些孩子必須要到經由衛福部認可的\"兒童發展聯合評估中心\"完成聯合評估並取得發展遲緩的證明，才能申請每個月3000元的早療補助款。\n然而這些孩子的家庭組成多以外籍配偶、隔代教養、單親、身心障礙…等弱勢組成，他們不一定理解早期療育對孩子的重要性，也不一定知道可以或是如何申請療育補助，更沒有足夠的經濟能力來預付前2個月的治療費用(註3)。目前，120位孩子中僅有10位完成評估取得新竹縣早療補助的資格，這表示至少有100位以上孩子的療育是無法延續下去的。\n透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。\n_____________________________\n註1、什麼是發展遲緩兒：\n為六歲以前兒童因腦神經生理疾病或心理社會環境因素，所導致之生理、智能、語言溝通、情緒、社會性及生活技能等發展障礙之兒童。其引起之障礙類別包括肢體障礙、智能障礙、視覺障礙、聽覺障礙、語言障礙、自閉症、平衡機能障礙、身體病弱、學習障礙、情緒障礙及多重障礙。(台大新竹分院早期療育中心)\n註2、什麼是早期療育：\n在學前的「早期療育」(簡稱早療)，是對零至~六歲的特殊兒童即時給予合適的醫療和教育處理，提供多項的整合性服務，正確有效的解決孩子在成長過程中的各項困難，並預防發展狀況的惡化。(中華民國腦性痲痹協會)\n註3、什麼是療育補助、如何申請：\n此計劃中的早療補助款為新竹縣政府為鼓勵給發展遲緩兒接受早期療育而設立的補助款，詳情請查閱修正新竹縣發展遲緩兒童早期療育費用補助實施要點。通常用治療費用收據提出申請後，補助款會需要2個月的時間才能匯入受補助兒童的帳戶中。");		// content 計畫內容
				pstmt.setString(8,"新竹縣");						// idealPlace
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				pstmt.setTimestamp(9,new java.sql.Timestamp(sdf.parse("2015-05-23").getTime()));  // activityStartTime
				pstmt.setTimestamp(10,new java.sql.Timestamp(sdf.parse("2015-05-28").getTime())); // activityEndTime
				
				pstmt.setInt(11,10);  		// demandNum 志工人數
				pstmt.setInt(12,50000);   	// budget
				
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setTimestamp(13,new java.sql.Timestamp(sdf.parse("2015-01-03").getTime()));
				pstmt.setString(14,"洽談完成");  // projStatus
				
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

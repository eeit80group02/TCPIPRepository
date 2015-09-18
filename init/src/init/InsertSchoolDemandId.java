package init;
/*
 * 本程式作用:新增數筆"學校需求"之資料於資料庫
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;

import global.GlobalService;

public class InsertSchoolDemandId {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	
	private static final String INSERT = "INSERT INTO SchoolDemand (schoolId,participant,activityTopic,activityLocation,activitySuitable,activityHost,activityContact,createDate,"
			+ "content,demandStatus ) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	
	public static void start(){
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);)
			{
				// 第一筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,44642);					    // schoolId 學校編號
					pstmt.setInt(2,32);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"垃圾清理物資-採購計劃");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"宜蘭縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"天真活潑的小朋友們");	    // activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"吳凱啟");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0986-545-432");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2013/08/11").getTime()));
					pstmt.setString(9,"東澳‧粉鳥林漁港\n東澳灣．粉鳥林漁港位在宜蘭縣南澳鄉，為東澳灣的最南端，彎弧形的海灣由沙灘及交研所組成，湛藍的山海景緻盡收眼底，耳邊傳來海浪陣陣拍打岩岸的聲響，站在烏巖角上方的蘇花公路轉彎處，景色最為迷人。粉鳥林漁港早期有許多鴿子群聚於此，而鴿子的台灣稱為粉鳥，因此被稱為「粉鳥林漁港」，此漁港捕獲豆腐鯊的數量為台灣之最，不僅海天美景宜人，還有多種生鮮魚類，許多釣客也相當喜愛到此垂釣。(文章來源：玩全台灣旅遊網)\n為什麼需要募集採購垃圾袋的經費呢?\n粉鳥林是一個很美的小漁港，在過去訪客不多，垃圾也不多的時候，港邊的環境整理，皆由當地的海巡駐所人員自掏腰包，購買垃圾清潔袋，掃把等器材，並在非值班的時間，自發性的來整理環境垃圾。\n但隨著假日遊客增加，垃圾也隨之增加！造成原本美麗的小漁港慢慢變樣了！！而由於粉鳥林地處偏遠的東澳灣，當地政府的環保單位，沒有人力定期來整理清掃垃圾。\n而當地住民或海巡駐人員，雖有人有心願意就近協助整理環境，卻無力負擔購買垃圾清潔袋，掃把等耗材！");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第二筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,94738);					    // schoolId 學校編號
					pstmt.setInt(2,50);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"讓教育沒有距離");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"雲林縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"需要課輔的小朋友們");	    // activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"林茂成");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0988-462-432");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2014/04/12").getTime()));
					pstmt.setString(9,"一個念頭\n一個小故事，但其中卻含括了許多偏鄉學子正面臨到的問題，我們相信只要願意努力，教育其實可以改變一個人的未來，但伴隨著社會的M型化，台灣教育資源也逐漸的邁向M型化，教育資源的差距甚至高達16倍。教育應該是公平的，當一個學生想要透過學習來改變自己的未來時，我們不該用不公平的教育資源去限制他們的成長，\"學習\"不該是如此沉重的負擔。\n一群夥伴\n大學時期我們都憑著自己的一股熱血與熱情，帶著準備好的知識和我們的學習歷程，到這些需要我們的教學現場，希望能帶給這些孩子們更多的資源，在與孩子們的教學相長的過程中，從學期初的陌生害怕到學期末的互相信任，其實看到孩子們因為我們而成長、茁壯心裡是滿滿的感動。但是，我們終究必須面對的是，當一個學期或是營期的結束，志工服務同時也告一段落。每次到了分別的時候就會思考說當我們離開了，他們怎麼辦?所以這也促使團隊開始去想如何才能達到永續性的服務，也就是說，除了回憶之外還有什麼方法是就算我們離開了，我們想要帶給他們的東西還能永遠留在他們身邊?");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第三筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,24672);					    // schoolId 學校編號
					pstmt.setInt(2,30);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"偏鄉科學創意教學深耕計畫");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"宜蘭縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"教育資源匱乏的學童們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"李銓德");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0981-454-698");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2015/03/24").getTime()));
					pstmt.setString(9,"翻山越嶺，深入中央山脈的深處，以知識傳道的教育行者，將科學的智慧放入背包，為偏鄉的孩子，帶來一場場驚聲連連的科學知識盛宴。\n我是田園老師，每學期走訪上百所的偏鄉學校，為孩子們帶來一場場精彩的科學課。Vstory 報導：他雖然不是學校教師，卻一學期走訪超過140所偏鄉學校\n一學期教導超過 8000 位偏鄉孩童，源於一場八八水災\n2009 年莫拉克颱風所帶來的八八水災，重創了許多山區原住民的部落，除了財產的損失外，「教育」也深受其影響。當大人們忙著重建滿目瘡痍的家園，無心兼顧孩子們的學習時，教育更顯得力不從心⋯⋯。\n為了讓家長老師能夠有更多的心力重建家園，當時我把孩子們集中在大禮堂，在部落心靈嚴重受創的天災之後，給孩子們上一堂科學課。\n用生動有趣的科學知識，幫助孩子們透過學習，找回笑容、也找回自信。也因此，深耕偏鄉科學教育的千里藍圖，逐漸在我的足下展開，短短數年間學校間口耳相傳及他鄉的校長積極的聯絡下…由一開始的3所學校，擴增為155所，都是偏遠資源缺乏的學校。\n這六年來我每學期走訪於六縣市40個鄉鎮之間，接觸了15個原住民族群，我用自己的眼睛看到的、耳朵聽到的、雙腳走到的，皆是偏鄉對於科學教育資源的渴望！因此我毅然決然地持續走在這條科學道路上，於是點成線、線成面，6個縣市155所學校，織成我的偏鄉科學教育深耕地圖！");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第四筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,164639);					    // schoolId 學校編號
					pstmt.setInt(2,47);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"【將軍國小暑期服務】美人魚現身將軍嶼");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"澎湖縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"教育資源匱乏的學童們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"蜀德浩");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0912-288-492");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2015/03/27").getTime()));
					pstmt.setString(9,"為什麼選擇將軍嶼?\n偏鄉國小的物質資源非常充足，但缺乏正式教師的長期陪伴，澎湖縣望安鄉將軍嶼的將軍國小，五年換五個導師，校內面臨缺乏正式教師的窘況，目前校內只有一位正式導師。因此今年暑假，已有五年歷史的澎湖團隊，秉持著「短期陪伴，長期傳承」的理念，將前往將軍國小，帶給當地孩童一個有意義的暑假。\n愛、希望、勇氣、陪伴\n我們以「愛、希望、勇氣、陪伴」做為團隊的四大理念，呈現給當地居民，讓他們勇於表達愛，對夢想懷抱希望，在遇到挫折時，能有勇氣站起來，全心全意的陪伴與照顧，讓他們感受到我們的真誠，並以延續性服務的心態，留給將軍嶼居民最好的印象。");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				// 第五筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,34718);					    // schoolId 學校編號
					pstmt.setInt(2,28);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"小小的心願，大大的力量");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"桃園市");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"有著小小心願的小朋友們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"丁奉");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0952-388-970");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2014/01/10").getTime()));
					pstmt.setString(9,"ღ每一段影片都來自不同的心願，背後藏著動人的故事ღ\n此片是一位「五歲雍雍的真實故事」，我們讓雍雍抱到了爸爸。從小到大雍雍記憶中的爸爸就是隔著玻璃面孔，說不到幾句話就不見了，不曉得什麼是父愛?不曉得什麼是爸爸擁抱的溫度?不曉得什麼時候爸爸能陪在自己的身邊?每個人都有犯錯的時候，藉由自己的錯，導正孩子，勿走上不歸路。\nღ期待寶寶的心願ღ\n/心願卡是這樣來的\n每個孩子心中都有一個小小的心願，對你我來說也許平凡，但對那許許多多沒有爸爸、沒有媽媽的失親兒來說，卻是彌足珍貴。每張心願卡上的心願都來自不同的感人故事。本會將建構起平台，讓孩子許願，使企業或民眾能透過平台來完成孩子的心願，民眾也將獲得回饋，讓這份愛能獲得延續。\n/因為有你，才能完成期待寶寶的心願\n想起最初......看著孩子滿心期待寫下屬於自己的願望，每一次實現願望就很害怕能否接著再完成下一個願望?孩子的心願，因為有你......你能有更多的笑容ⓁⓄⓋⒺ☺");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第六筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,144623);					    // schoolId 學校編號
					pstmt.setInt(2,28);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"幫台東天琪幼兒園的孩子籌一個月學費");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"台東縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"幫助小朋友籌得學費");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"張昭");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0933-985-903");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2014/03/15").getTime()));
					pstmt.setString(9,"1963年於台東成立的「尚武會院」，基於孩童教育需要，附設「天琪幼稚園」。長期以來，支持貧童的教育，就算必須由教職員自願減薪來補貼全園支出，讓孩子們有好的受教環境，也在所不惜。\n天主教私立天琪幼兒園主任沈秀惠表示，二十多年來，園方好幾次面臨經營困難，都是靠聖十字架慈愛修女會補助，勉強度過難關。但是這幾年修女會已經無法再出資補助，有意要結束經營。瑞士籍院長宋玉潔修女到處奔波籌錢，甚至向遠在瑞士的親友們募款，為的就是一股「孩子的教育不能中斷」的信念。\n宋玉潔修女：\n「一定要給小孩子教育，才有機會脫離貧困，未來才有希望。」\n宋玉潔修女自願奉召來台服務35年，曾獲得2013年第23屆的醫療奉獻獎。宋修女始終秉持「哪裡需要我，就往那裡去」的精神，默默為後山貧困及原住民學子貢獻心力。即使自己是個癌症病人，也拒絕返回瑞士聖十字架慈愛修女總院療養，寧願將餘生分享給更多需要幫助的人。");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第七筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,213511);					    // schoolId 學校編號
					pstmt.setInt(2,30);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"與一群孩子的午後約定");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"台南市");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"需要伴讀的小朋友們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"蔡瑁");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0939-370-492");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2014/03/23").getTime()));
					pstmt.setString(9,"用故事的奧妙和美味的甜點，再佐以一點點大哥哥大姊姊的愛，讓晨光課輔班的孩童培養對閱讀的興趣。今天，我們要為孩子帶來一個不一樣的下午茶時光！\nChapter1：重拾被遺忘的喜悅\n從前從前，書本一直是兒童成長最好的朋友，但自從書本被貼上升學的標籤之後 再也撕不下來，一切都不一樣了…\n閱讀，早已在升學導向的台灣走了調，許多人在考試壓力的催逼下，對閱讀失去了興致。應付課內的教科書都來不及了，哪還有時間去閱讀其他的書籍？這樣的教育體制，使我們漸漸忘卻讀書的真諦，忘記了閱讀到一本好書的感覺。\n舉辦這次活動，我們要的其實很簡單，我們希望讓下一代的孩子，有機會不要再向我們一樣，只是為了升學而讀書，而是因為書中的奧秘和驚奇，真正地愛上閱讀。\nChapter2：閱讀晨光　擺脫拘束\n有一群孩童，想接觸書的溫暖…\n晨光家園弱勢兒童課輔班裡，許多孩童從小就沒有機會，聽到爸爸或媽媽說床邊故事的聲音，讓書本能成為他們成長的一部份，迎之而來的卻是讀不完的課本和繁重的考試。這是教育的現實，但對孩子而言，似乎少了些什麼。\nChapter3：為愛朗讀　你我的午後約定\n今天，我們想要讓他們有機會體驗到，閱讀所帶來的真正喜悅。因此我們團隊決定為他們募集書本，並撥出一天，帶著自製的點心，和我們所準備的故事，陪伴他們度過一個不一樣的閱讀時光。\n要將喜愛讀書的種子重新撒在他們心中，我們能做的不多，只是盡我們所能，用愛陪伴他們悅讀(to be continued…) \n");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談中");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				// 第八筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,74654);					    // schoolId 學校編號
					pstmt.setInt(2,37);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"團結就是保護海洋的力量");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"彰化縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"關懷台灣海洋的學童們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"蔡倫");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0938-327-110");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2014/03/23").getTime()));
					pstmt.setString(9,"我們是一群來自彰化的國小三年級學生。經過老師的分享，我們知道海洋面臨了許多危機，也知道早已有許多人為這片海洋貢獻了自己的力量。十分謝謝他們！感謝之餘，我們也想要加入守護的行列，透過雙手，展現我們對於保護海洋的團結力。\n台灣島是從海底誕生的，四面環海的台灣，海洋是我們最寶貴的資產。中央研究院動物研究所張崑雄教授曾說：「少了海洋的台灣，就像離了水的魚。」一語道盡了我們對海洋的依賴。人類從海洋中獲取所需，但卻未能給予相應的回饋和感謝，反而是無止盡的傷害。\n2009年聯合國大會指定6月8日為世界海洋日。同年起，海洋計畫團體與世界海洋網絡都為每年海洋日訂一個主題，邀請世界各地的人民一起參與活動。\n2014年的主題為「團結就是保護海洋的力量」（Together we have the power to protect the ocean）我們決定一起響應世界海洋日，希望我們的小小行動，能進一步喚起更多人對海洋的關懷與思考。");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第九筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,114720);					    // schoolId 學校編號
					pstmt.setInt(2,20);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"流浪毛小孩的【鍾】心期盼");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"臺南市");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"關懷流浪狗的學童們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"林育程");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0973-248-832");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2015/05/22").getTime()));
					pstmt.setString(9,"鍾媽媽狗園摘要：\n20年前，鍾媽媽在一次偶然的機緣下，發現一隻不會走(受傷)的流浪狗⋯⋯，漸漸地，鍾媽媽收養了越來越多需要幫助的狗兒⋯⋯。光陰似箭，鍾媽媽現在已經是68歲的鍾奶奶了，由於鍾奶奶沒有足夠的錢來醫療本身的糖尿病，因此導致雙眼失明⋯⋯。\n這幾年，一切僅靠鍾爺爺獨立照顧狗園100多隻狗兒希望藉由各位的力量，募集到必須的費用：鍾爺爺與鍾奶奶的醫療及狗場的飼料費用。\n為什麼需要大家的幫助？\n20年前，鍾媽媽在一次偶然的機緣下，發現一隻不會走(受傷)的小狗，於是鍾媽媽決定將狗狗帶回去照顧，購買飼料、看醫生，照顧得十分用心。\n漸漸地，鍾媽媽收養了越來越多需要幫助的狗兒。為了狗狗的吃飯及健康問題，長期變賣家當、機器 換取狗糧與生活費，但是，鍾奶奶雙眼失明，再也看不到心愛的狗狗了⋯⋯。失明前，鍾奶奶靠撿資源回收，剩菜剩飯給狗兒，若狗狗吃不完再自己吃，現在已經沒辦法了。幾年來，若不是許多善心人士的幫助，狗園早已斷糧⋯⋯\n這幾年，一切僅靠鍾爺爺獨立照顧狗園100多隻狗兒。狗園沒有半個義工,沒有任何的關注,隱居山林默默照顧百餘隻毛孩子，殊不知其實鍾爺爺與鍾奶奶也是需要被照顧的弱勢家庭。曾經，鍾奶奶告訴我們，鍾奶奶發發現水溝有狗狗困住，已經看不太清楚的她仍奮不顧身的進去救狗狗，鍾奶奶愛狗的心，讓人感動不已...。\n此外，最近(103.8)鍾爺爺被診斷出得到 疝氣(脫腸、墜腸)，必須去醫院開刀治療，相信一切都會很順利的。鍾爺爺和鍾奶奶，真的很需要大家的幫助..。\n");            //content 需求內容(1000字?)
					pstmt.setString(10,"待洽談");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
					pstmt.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// 第十筆資料  ======================================================================
				try
				{
					pstmt.setInt(1,154506);					    // schoolId 學校編號
					pstmt.setInt(2,48);  	                    // participant 預計參與的學生人數
					pstmt.setString(3,"還土地一片自然募資計劃");	// activityTopicPicture 活動主題(指學校希望志工規劃的主題)
					pstmt.setString(4,"花蓮縣");			        // activityLocation 活動地點(非必填)
					pstmt.setString(5,"關懷高山環境熱愛大自然的學童們");	// activitySuitable 參與本活動的學生狀態
					pstmt.setString(6,"馬師憲");		            // activityHost 活動負責人(學校方負責此項計畫的聯絡人)
					pstmt.setString(7,"0988-853-442");		    // activityContact 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
//					pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));	// createDate 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					pstmt.setTimestamp(8,new java.sql.Timestamp(sdf.parse("2015/01/19").getTime()));
					pstmt.setString(9,"從初踏雪山的美麗，到見證玉山的壯麗；\n從看到土地真貌的心疼，到撫平山林傷口的脆弱。我們將號召眾人淨山的過程，希望以空拍機不同視角拍一部紀錄片，觀者可透過畫面一同感受台灣高山的壯麗與哀愁，更能看見淨山者們的精神與希望。從淨山開始，從心裡出發，慢慢發揚光大，我們正傳遞著一個精神—淨愛高山。\n動機: \n一個偶然機會攀登雪山，如影隨形的除了美景，更多的是覆蓋在箭竹叢、隱藏在山莊旁的垃圾，那些被忽略的土地商，他們多半都有淒慘的模樣，實際目睹高山難解的垃圾問題，數量非常驚人，卻像被遺忘似的灑落在那...早期登山人處理垃圾方式，是焚燒以及掩埋，但是隨著登山人數倍增，這樣的處理方式，對土地帶來沈重的負擔。");            //content 需求內容(1000字?)
					pstmt.setString(10,"洽談完成");	            //demandStatus  計畫狀態(待洽談、洽談中、洽談完成、洽談失敗)
					
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
		
		System.out.println("學校需求計畫資料 新增完成");
	}
	
	
	public static void main(String[] args){
		InsertSchoolDemandId.start();
	}
}

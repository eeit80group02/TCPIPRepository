package init;
/*
 * 本程式作用:新增數筆"完整計畫"之資料於資料庫
 * 
 */
import global.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;

public class InsertFullProj
{
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;
	
	private static final String INSERT = "INSERT INTO FullProj (primaryProjId,schoolDemandId,memberId,schoolId,title,frontCoverName,frontCover,frontCoverLength,"
							+ "projAbstract,content,location,activityStartTime,activityEndTime,estMember,budget,createDate,projStatus,orgArchitecture,"
							+ "projFileName,projFile,projFileLength,reviews,reviewsContent,schoolConfirm,memberConfirm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void start()
	{
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			// 第一筆資料  ======================================================================
			pstmt.setInt(1,1);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,7);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"造神計畫");			// title 計畫名稱
			File file = new File("image/primaryProj/primaryProj01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"幫助偏遠學校使用辦公室軟體應用");		// projAbstract 計畫摘要
				pstmt.setString(10,"Word...Office軟體應用");		// content 計畫內容
				pstmt.setNull(11,Types.NVARCHAR);				// location 活動確定地點
				
				pstmt.setString(12,"2015/08/08");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/08/15");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,20);							// estMember  活動志工人數
				pstmt.setInt(15,200000);						// budget 活動預算
		
				pstmt.setNull(16,Types.TIMESTAMP);				// createDate  建立日期
				pstmt.setString(17,"洽談中");				    // projStatus  計畫狀態  
				pstmt.setNull(18,Types.NVARCHAR);				// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setNull(24,Types.NVARCHAR);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setNull(25,Types.NVARCHAR);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第二筆資料  ======================================================================
			pstmt.setInt(1,3);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,5);					// memberId 會員編號
			pstmt.setInt(4,94664);				// schoolId 學校編號
			pstmt.setString(5,"亞成鳥青少年野地教育計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"每個人心中都有亮光，不一定被看見。 四天的陪伴，我們帶領青少年走入美麗的山林，遠離熟悉的生活。過程中，當面對困難和挑戰，我們說：「沒關係，這一段路我們陪你一起走」當有了跨越的勇氣，一切，也不再那麼困難。");		// projAbstract 計畫摘要
				pstmt.setString(10,"在被隔絕的深山中，一個人沒有辦法輕易放棄。除了靠自己的雙腳走出去，沒有一個辦法可以立刻讓人回到溫暖的被窩或舒適的家。\n我們認為這些孩子們需要的，其實是一個能夠脫離他們混亂日常的機會。孩子們在深山中，有機會忘去種種的負面情緒，讓自己的心靜下來，不去煩惱家中或學校的種種壓力，探索自己內心的需求，去看到不一樣的事物，而長天數的登山給了他們一個機會去脫離這些處境。登山在精神與體力上的挑戰，讓他們沒有空閒去煩惱這些事，而有機會跳出許多的束縛與負面的情緒，讓他們能敞開心胸面對更多不一樣的事物。\n我們是一群喜歡登山的山友，希望除了自己爬山很快樂之外，一直思考還可以為台灣做些甚麼。偶然在接觸到野地教育後，我們看到了山對孩子們的影響。\n我們從2010年開始與安置機構合作，由我們志工提供登山裝備，並帶機構的孩子登山，平均每年會辦4 -6個梯次的活動，每個梯次會在台灣山區進行4至7天的野地教育成長課程，並另於行前與行後進行單日的準備與分享課程。除此之外我們也會對志工進行無論是登山的訓練，或是野地教育的訓練。");		// content 計畫內容
				pstmt.setString(11,"台中市");				// location 活動確定地點
				
				pstmt.setString(12,"2015/05/21");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/07/21");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,12);							// estMember  活動志工人數
				pstmt.setInt(15,150000);						// budget 活動預算
		
//				pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015-05-10").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24, true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第三筆資料  ======================================================================
			pstmt.setInt(1,4);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,7);					// memberId 會員編號
			pstmt.setInt(4,94744);				// schoolId 學校編號
			pstmt.setString(5,"友善生活實踐計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"2014年新化龍燈農藥廠事件的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？我們相信，在這塊土地上，一定還有堅持對環境友善的農民，以及默默為綠色環境努力的人們，我們期望，透過小農徵文比賽，讓這些友善環境的故事被看見，為這片土地帶來美好的滋養。更期盼，藉由小農徵文比賽、友善環境人文講座、友善綠藝市集、農事體驗小旅行…的舉辦，為這片土地盡一份心力。現在，想邀請你，支持我們的理念與行動，和我們共同邁向夢想中的友善環境。");		// projAbstract 計畫摘要
				pstmt.setString(10,"美麗的家園大目降(TAVOCAN)意為\"山林之地\"，為平埔族語，我們的祖先說，這是一個擁有山林之美的地方。在被隔絕的深山中，一個人沒有辦法輕易放棄。除了靠自己的雙腳走出去，沒有一個辦法可以立刻讓人回到溫暖的被窩或舒適的家。\n2014年4月，龍燈農藥廠事件對台南新化、關廟地區的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？\n大目降的願望\n「台灣的農業一定需要農藥。」這家全球第八大農藥廠這麼說。我們的生活與命運，是否要讓農藥廠或財團來決定? \n我們相信，在這塊土地上，一定有堅持對環境友善的農民，以及默默為綠色環境努力的人們。我們期望，讓這些友善環境的故事，為這片土地帶來美好的滋養。\n於是，盼望藉由找出這些與土地相依的故事，讓你、我為這片土地盡一份心力……。\n除此之外，我們還想為這片土地做更多...... \n友善人文講座\n頒獎後舉辦友善人文講座，播放自然農法相關紀錄片，交請專家、作家，以「友善大地」、「自然農法」、「農村生活體驗」為主題進行演講。");		// content 計畫內容
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2014/10/16");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/12/14");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,28);							// estMember  活動志工人數
				pstmt.setInt(15,50000);						// budget 活動預算
		
//							pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2014/08/28").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動組-企畫組-隊輔組-總務組-美宣組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setInt(22,4);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setString(23,"認真負責");		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24, true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第四筆資料  ======================================================================
			pstmt.setInt(1,5);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,154689);				// schoolId 學校編號
			pstmt.setString(5,"來自小漁村的台灣代表隊-國際參賽募資計劃");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj05.png");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"漁村的小孩不知道什麼是「夢想」，起初我們提供一個有點心吃的活動，對他們來說已經非常滿足。 「練習飛盤」這件事對於隊上大多數的孩子來說，是第一次學習如何把事情做好，我們也不斷地教導：「不管做什麼都要很專心，剩下的老師們來想辦法。」 九年過去，孩子們很努力的達到設定的目標，我們的努力終究還是不足，需要更多人的幫助與支持。");		// projAbstract 計畫摘要
				pstmt.setString(10,"九年前，一份期盼藉運動陶冶孩子品格的心志，九年後，成了孩子代表台灣出國比賽的機會。鹽洲，一個屏東鄉下的傳統小漁村，住著許多來自弱勢家庭的孩子，單親，隔代教養，外籍新住民子女…等等。\n擔心弱勢家庭的孩子可能得不到良好的關照，教會裡的家長們於是從日本引進了躲避飛盤運動，並在飛盤課前結合品格教育，希望養成運動風氣，減少孩子週末沒事在外遊盪的情形，更打造孩子們的好品格。「品格飛盤營」因此誕生，沒想到這樣一辦，就是9年。\n久而久之，發現孩子們慢慢轉變，例如面對裁判誤判，或是比賽落後，他們的專注度都不會改變，也不會抱怨，雖然沒有到教會聚會，反倒用口號互相打氣：「感謝主」。\n「你們的學生彷彿是在上帝翅膀下成長出來的孩子，感覺好奇妙。」其他隊伍的老師對鹽洲教會孩子的表現，感到非常驚訝\n就像是用飛盤來打躲避球！躲避飛盤受歡迎的主要原因是：上手容易、趣味性高、男女不拘、非常安全、過程緊湊、 戰況激烈。全日本躲避飛盤公開賽已舉行超過五屆，而台灣是繼日本之後第二個推廣的國家，美國目前也已開始推展這項運動。\n鹽洲飛盤營社團成員從小學一年級到高中生都有，每到周日就是練習時間，從原本的打發時間，到最後變成專業的訓練，更找來了國家A級教練進行特訓，就是要讓孩子們知道，不論做甚麼，都要努力認真！飛盤營對孩子們來說，早已不只是一項運動，而是動力、情感寄託和不可或缺的珍貴存在。");		// content 計畫內容
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/07/28");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/09/07");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,18);							// estMember  活動志工人數
				pstmt.setInt(15,300000);						// budget 活動預算
		
//										pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/07/01").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24, true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第五筆資料  ======================================================================
			pstmt.setInt(1,6);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,2);					// memberId 會員編號
			pstmt.setInt(4,144671);				// schoolId 學校編號
			pstmt.setString(5,"徐超斌方舟教室夢想計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"臺東縣的最南端達仁鄉，有一位超人醫師徐超斌，將自家改建成方舟教室，提供孩子們課輔、才藝、母語等課程。來自全台各院校的方向：D夥伴，為徐醫師所感動，與部落孩子們約定年年一起在方舟教室渡過每個特別的暑假。");		// projAbstract 計畫摘要
				pstmt.setString(10,"我們是方向：D團隊，在臺東縣最南端的達仁鄉，部落超人醫師徐超斌籌建的方舟教室裡，年年舉辦暑期夢想營隊。讓部落孩子們從玩樂中學習、探索自我潛能。方向：D團隊名稱中的字母D正是Direction的開頭，我們期許與孩子們一同勾勒屬於未來方向的藍圖，也希望每個參與的孩子，結束後能帶著：D的笑臉回家。\n兩年前，我們懷抱著18歲甫從高中畢業的滿腔熱血，想做點什麼回饋社會。偶然契機下，得知有位部落醫生徐超斌，捨棄大醫院主治醫師的高薪，回鄉從事部落巡迴醫療。因醫療資源匱乏，他必須日夜看診，就診的部落老少全年不曾間歇。幾年前徐醫師更因過勞，而致中風半身癱瘓。但他沒有放棄，休養後繼續巡迴看診，高明的醫術讓他單手仍能熟稔的操作手術刀。徐醫師不僅醫病犀利，更將許多想法帶進部落，是部落孩子們眼中的「超人醫生」，而這位超人四處奔波募集資源組建一間南迴醫院的腳步更從來沒停止過。去年，在FlyingV平台上也成功達成一段里程碑。\n徐醫師將自宅改建為方舟教室，讓部落的孩子們下課之後有地方可以寫作業，也有義工媽媽料理晚餐。部落孩子們下課回家後，往往家長仍在工作，徐醫師醫生解決了孩子在外胡亂解決晚餐的問題，也確保孩子在完成作業後才開始玩樂。他更號召部落年輕人回鄉，為孩子們開設才藝課程(吉他、鼓..等等)，也尋訪部落有志之士，讓孩子在方舟教室得以學習母語、傳統舞蹈。因為部落的需要，方舟教室開始從土坂開始，在台坂、新化…等部落也陸續建立，不論大小，理念皆相同。\n[方向：D與孩子們的大夢]\n方向：D團隊已邁入第三個年頭，以第一年的土坂部落作為據點，第二年我們前進新化部落，今年將再延伸到南星部落。應著孩子們的需要，方向：D團隊不斷擴張，搭乘方向：D夢想號的孩子們也從最初的30名，直至今年的80人。\n我們也與方舟教室的孩子們約定：每年的暑假，方向：D的大哥哥、大姊姊們都會再回來，並帶來新的、特別的、有趣的課程。每年的課程具有連貫性，循序漸進的引導孩子們挖掘自己內心的夢想，我們相信，只有持續的耕耘，才能真正帶給孩子們收穫，也才能陪著孩子們成長。只要部落有需要，方向：D將永遠、永續經營下去。");		// content 計畫內容
				pstmt.setString(11,"臺東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/07/07");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/07/30");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,25);							// estMember  活動志工人數
				pstmt.setInt(15,100000);						// budget 活動預算
		
//													pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/08/21").getTime()));				// createDate  建立日期
				pstmt.setString(17,"洽談中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"總召-活動紀錄組-募款行政組-教案課程組-隊輔組-活動策畫組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setInt(22,5);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setString(23,"活潑外向、熱心助人");		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24, true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,false);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第六筆資料  ======================================================================
			pstmt.setInt(1,7);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,5);					// memberId 會員編號
			pstmt.setInt(4,24510);				// schoolId 學校編號
			pstmt.setString(5,"方舟計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj07.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"經過近一年的規劃、半年的募資，現在方舟計畫將進入募資的最後一天，希望能與你一起完成這通往起點的最後一哩路。改修福山教會，建立一個「方舟」，給部落居民與孩子一個棲身之所，一個舒適的環境，讓這裡成為孩子們的心靈殿堂。");		// projAbstract 計畫摘要
				pstmt.setString(10,"【福山部落：方舟計畫】\n我是林慶台，我是一位牧師，也是一位木雕師傅。「莫那魯道」只是一個曾經，為神奉獻則是永久的志業，所以，我選擇離開鎂光燈的生活，回到部落。\n從南澳來到烏來的福山，我看見許多的青春，卻也看見更多的問題，那股原住民存在的血液在我心中燃燒。把我的所能貢獻給部落，是我的使命。當我就任牧師，自請至福山赴任後，真正深入了解，才發現狀況比我想像的還要嚴重。\n福山的美是動人心魄的，離城市一個小時多的車程，就有風光明媚的自然山水、但相較於景色的美好，在人文面卻傷痕累累，傳統的耆老制度在遷村和政策的影響下早已被破壞，逐漸淡薄的祖靈信仰也難敵經濟困窘的影響，許多家庭面臨社會、道德、健康等多方面的困境，已經失去正常的生活樣貌，這些問題最直接連帶影響的，是孩子。\n我親眼看見家庭的習慣反映在孩子的行為上，缺少正面的知識教育，又在負面環境的耳濡目染下，不只是消極的想法，甚至用偏激的行動反抗社會的不公義，這樣的惡性循環從家庭開始逐步蔓延到族人們的心靈。如果繼續惡化，這裡會是一個沒有祖先生命的地方。\n我相信這裡的孩子並不壞，只是沒有人告訴他們怎麼去防備被負面的價值觀影響。年輕的生命，也需要有一個方向。過去，上帝引領我走出27歲以前的黑暗封閉，我也希望能透過教會的力量，讓他們認識上帝，重新認識生命，找到回家的路。\n在我到任前，福山教會已有年餘沒有牧師，興建於數十年前的建物本身也年久失修不敷使用，狹小擁擠的空間僅能堪堪禮拜，卻無法讓當地人在這裡學習，一起成長。所以我的夢想是能改修福山教會，建立一個「方舟」，以挪亞給世人最後一次的救贖為意象，給孩子一個棲身之所，一個舒適的環境，就像方舟帶領世人度過大洪水的災難一樣，讓這裡成為孩子們的心靈殿堂。\n◎上帝派了一群人來幫助我們\n方舟計畫不能只是一個夢想，更是一個要被完成的計畫。我有木工的專業，在福山的宿舍是自己動手打造，但整修教堂的規模和需求都不只於此，需要更多更專業的技術和協助，才能完成。從到任開始，在各個演講和餐敘的場合裡，每當談到這個想法，都有許多朋友願意為此出一份力，但幾個月的時間過去，在最關鍵的建築設計上，卻遍尋不著能提供幫手的夥伴。在一次偶然的機會下，我在長期協助福山部落的家扶基金會處認識了flyingV團隊，短短幾十分鐘的討論，卻讓我重新燃起了完成的希望。\n從上山實際了解需求、在網路號召專業人士的投入、再到實際上山測繪和製作平面和立體模型，短短幾十天內，包含建築師、產品設計師、水電工程師、環保建材商、相關學系的教授和更多更多願意支持這個計畫的朋友陸續加入。\n上帝不只聽見了我的聲音，更派了一群人來協助我們。\n◎方舟的輪廓\n教堂，猶如一隻方舟，獨立於山谷之間。\n教堂位於福山部落山坡邊上，面向東南方，俯視南勢溪支流；四周群山提供冬日北風的屏障，背後山勢則是午後炎熱西曬的遮蔭。");		// content 計畫內容
				pstmt.setString(11,"宜蘭縣");				// location 活動確定地點
				
				pstmt.setString(12,"2013/10/24");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/05/30");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,30);							// estMember  活動志工人數
				pstmt.setInt(15,7700000);						// budget 活動預算
		
//																pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2013/10/04").getTime()));				// createDate  建立日期
				pstmt.setString(17,"洽談中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,false);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,false);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第七筆資料  ======================================================================
			pstmt.setInt(1,8);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,6);					// memberId 會員編號
			pstmt.setInt(4,114619);				// schoolId 學校編號
			pstmt.setString(5,"台南康家百年聚落光芒計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj08.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"隨著台灣工商社會的發展，許多人出外到都市打拼，使得農村人口高齡化，青壯人口外移，造成農村聚落逐漸沒落的現象。台南市新化區礁坑仔社區就是這樣一個老聚落，這在老聚落裡面，百年歷史的老厝正逐漸崩壞凋零，許多動人故事與美好事物隨著老人家過世而消失，這些都是台灣社會共同的無形財產，一旦流失就再也找不回來，台灣的根是長在農村的土地上，保存我們的根是刻不容緩的事，期待透過點燈與音樂會找回我們忘記的回憶。");		// projAbstract 計畫摘要
				pstmt.setString(10,"失根的我們?\n我們的根，長在老人家記憶的土壤上，\n如果我們沒將這些記憶保留下來，那我們是誰? \n尋根，3月5日元宵點燈，與我們一起照亮台南康家百年聚落。\n忙碌的生活步調中，我們都一直為了實踐理想向前邁進，但是在出外打拼的時候，有些家鄉的故事正隨著老人家離開，而逐漸消逝。早年的農村孕育了台灣的根基，隨著經濟的起飛，高樓的築起，而我們也淹沒在水泥牆中…。\n「賀啦!賀啦!抹凳企啊!」(好啦!好啦!要回去了!) \n家人的呼喚聲不斷，但回家的日子總是一延再延，老人家的離開，農村聚落的失守，當所謂的功成名就時，慕然回首，我們已失去了根，也忘了回家的路。\n遺落的山城，康家百年聚落\n就像台灣許多被遺忘的聚落一樣，這裡是個幾乎荒廢的舊山城，聚落中所有家戶皆姓康，獨特的地理位置(深藏在淺山山谷之中)，擁有豐富的人文歷史背景，聚落的建築特色。家戶門坊上映刻著〝京兆〞二字，憶述康家於清朝時期為皇族的過往，不難想像康家聚落百年前的繁華鼎盛，但那曾經的美好，卻不敵時光的變遷，如今，只能存在族人的心中。\n為何回到故鄉?\n『或許是對土地的情感，或是對阿公的情感轉移，看著年邁的老人家，獨自守著家園，有的還需要辛苦栽種作物到鄰近的新化林場販售以維持生計，年輕的我，想著我能為他們做些什麼？賺更多的錢幫助大家嗎？很天真，無能無力的我，真的曾經這麼想。我想這或許就是老天爺的安排，幾年的時間離開新化、離開家鄉，一路的跌跌撞撞，歷經的磨練與苦難，十年了，我空著一雙手，但是我想回家，回頭看這一切，我懂了為什麼走這一遭，我知道我有能力為這片土地、人們做些什麼了，原來，「心」能帶我到任何地方，依著我的努力與初衷，我相信。』\n---------蘇莞婷。康家聚落後代；拾荒流工作室成員\n小時候，康家百年聚落就像我的遊樂場，阿公、阿嬤親切的招喚，還有童年玩伴，燃起了火把大家就會齊聚，穿個這條走廊推開那道門，整個聚落都是我們的尋寶區，再多的歡樂都隨蹴可及，而今聚落的蕭條，與枯守在部落的老人家，如同破落的遊樂場，沒有了歡笑，沒有了生命與表情。於是，今年元宵，我們將為康家聚落點起一盞盞希望的燈，讓康家後代們找到回家的路。\n我們是「拾荒流工作室」，同時也是新化社區營造協會，更是「大目降綠色環境陣線」的發起組織。我們要做的事情很多，而守護這塊土地的使命與決心，迫使我們拼命的勇敢，「拾荒」是我們的志業，我們認為把別人覺得不重要的人、事、物拾起，重新塑造它的價值，是我們熱情與原動力的來源，讓「拾荒」這件事成為一種運動，也讓整個社會可以更好，我們不敢說自己是「社會企業」，但我們努力往這條路邁進，並帶著許多偏鄉聚落人們的冀望一直前進。\n其實我們一直在關心這座靜謐的山城，努力地想改變現況...自100年開始我們就進入聚落，發現文物不斷流失，舊有的記憶，隨著老人家的離去而消失…有些事再不做就來不及了!! \n我「回家」了，時間還是不停的流逝，那天，當我還埋頭在工作、計畫中，原本還算硬朗的外公，無聲無息的倒下……，這一切都不在我們預期的規劃中，無奈的是老人家的生命、健康與快樂是沒辦法規劃的。\n所以我們行動!!我們希望可以讓更多遊子找到回家的路，我們希望更多人可以開始關心、照顧守在家鄉裡持續等待的那些老人家。");		// content 計畫內容
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015/01/16");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/03/16");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,35);							// estMember  活動志工人數
				pstmt.setInt(15,90000);						// budget 活動預算
		
//																			pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2014/12/20").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第八筆資料  ======================================================================
			pstmt.setInt(1,10);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,6);					// memberId 會員編號
			pstmt.setInt(4,134656);				// schoolId 學校編號
			pstmt.setString(5,"全台募殼計劃");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj10.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"你有在海邊撿過貝殼嗎？因爲環境的破壞，加上遊客的撿拾，這十幾年來螺貝殼持續減少。所以沒有螺貝殼可以藏身的寄居蟹，只好背著垃圾殼趴趴走，變成沿海難民。這些寄居蟹需要你的支持。寄居蟹有家，只要我們願意行動。");		// projAbstract 計畫摘要
				pstmt.setString(10,"家中的角落是否還留著某個沙灘的貝殼呢？還記得小時候塑膠盒中，從路邊買回來一隻十幾元的無辜寄居蟹嗎？因爲環境的破壞，加上遊客的撿拾，這十幾年來寄居蟹賴以為生的螺貝殼持續減少，也造成寄居蟹數量的減低，而由於寄居蟹的腹部相當脆弱，必須藉由堅硬的殼來保護自己，所以沒有螺貝殼可以藏身的寄居蟹，只好背著塑膠空瓶、玻璃瓶蓋趴趴走，變成沿海難民。\n雖然很多人都看過台灣寄居蟹背著塑膠瓶蓋的畫面，但對這些議題卻沒有全面性的了解，也欠缺整合性的社會行動相應；目前，民間雖有環保團體自發性發起還殼給寄居蟹的活動，但活動大多局限於地域性宣傳，造成寄送螺貝殼的過程中無形增加碳足跡。\n在過去還殼活動與各界人士對談中，我們發現了一些問題：大家雖然知道寄居蟹沒有殼，也很想幫助缺殼的寄居蟹，卻不知道離家最近的募殼站在哪，也不知道怎樣的殼適合寄居蟹居住，不清楚如何清洗收集到的殼等問題……。因為缺乏這些後續資訊的建構，因此大家缺少相對應的行動，於是我們建立網絡平台，期待將各地關心寄居蟹的資源整合。\n接著，在訪談專家與研究資料收集中，我們前往美麗的屏東後灣，拜訪後灣募殼活動發起人楊美雲，經過這幾年來的努力，後灣的寄居蟹缺殼一事已較廣為人知，目前也有固定數量的民眾會寄殼給後灣，這讓我們不禁想到：「民眾是否也有將殼寄給其他缺殼的寄居蟹，為他們布置一個舒適的家呢？」所以我們又拜訪了發起桃園新屋海灘還殼活動的教育推廣學會，理事長王派鋒告訴我們，新屋海灘寄居蟹目前非常需要一個家；而遠在綠島的寄居蟹們，近年來也面臨無殼可換的窘境……。\n這些寄居蟹需要你的支持。寄居蟹有家，只要我們願意行動。我們了解，大家並非不關心生態，只是缺乏完整的資訊管道，只要建立一個完整的資訊管道，就能告訴大家這些觀念：「將家裡從海灘撿來的貝殼歸還自然、將餐廳吃完的螺殼回收利用，清洗後再寄至全台各地的收殼所。」\n我們希望由全台募集三萬個殼，讓各地寄居蟹缺殼的資訊，藉由網路資源，整合為一個資訊平台，號召你我一同動員，參與還殼給寄居蟹、寄居蟹返家運動。");		// content 計畫內容
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2013/12/09");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/02/17");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);		// estMember  活動志工人數
				pstmt.setInt(15,50000);		// budget 活動預算
		
//																						pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2013/09/20").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第九筆資料  ======================================================================
			pstmt.setInt(1,12);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,7);					// memberId 會員編號
			pstmt.setInt(4,44502);				// schoolId 學校編號
			pstmt.setString(5,"新竹縣早療據點募資計劃");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj12.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"我們是新竹縣職能治療師公會，對於0~6歲學齡前發展遲緩的孩子，我們透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。103年，我們進入了新竹縣6個醫療缺乏鄉鎮、19所幼稚園及數個家庭開始了發掘遲緩兒並提供早期療育的工作。現在，因為先/後天的弱勢與經費不足，有100多位孩子將無法取得早療補助資格而中斷療育；因此我們計劃使用FlyingV募資平台來給予協助。");		// projAbstract 計畫摘要
				pstmt.setString(10,"我們是新竹縣職能治療師公會，對於0~6歲學齡前發展遲緩(註1)的孩子，我們透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。103年，我們爭取到衛服部社家署的一個專案計劃，進入了新竹縣6個醫療缺乏鄉鎮、19所幼稚園及數個家庭開始了發掘遲緩兒並提供早期療育(註2)的工作。\n這一年，我們踏入了共用里民活動中心的幼稚園，感受到牆壁是鐵皮、地板是水泥地的家有多冷，也看見孩子唯一的玩具就是爸爸揀破爛做回收後剩下的瓶罐紙屑的畫面。\n同時，還發掘了120位需要早期療育的發展遲緩兒，這些孩子必須要到經由衛福部認可的\"兒童發展聯合評估中心\"完成聯合評估並取得發展遲緩的證明，才能申請每個月3000元的早療補助款。\n然而這些孩子的家庭組成多以外籍配偶、隔代教養、單親、身心障礙…等弱勢組成，他們不一定理解早期療育對孩子的重要性，也不一定知道可以或是如何申請療育補助，更沒有足夠的經濟能力來預付前2個月的治療費用(註3)。目前，120位孩子中僅有10位完成評估取得新竹縣早療補助的資格，這表示至少有100位以上孩子的療育是無法延續下去的。\n透過遊戲來引導孩子學習策略並提供家長和老師建議，使發展遲緩的孩子可以獲得最大的學習及生活獨立性。\n_____________________________\n註1、什麼是發展遲緩兒：\n為六歲以前兒童因腦神經生理疾病或心理社會環境因素，所導致之生理、智能、語言溝通、情緒、社會性及生活技能等發展障礙之兒童。其引起之障礙類別包括肢體障礙、智能障礙、視覺障礙、聽覺障礙、語言障礙、自閉症、平衡機能障礙、身體病弱、學習障礙、情緒障礙及多重障礙。(台大新竹分院早期療育中心)\n註2、什麼是早期療育：\n在學前的「早期療育」(簡稱早療)，是對零至~六歲的特殊兒童即時給予合適的醫療和教育處理，提供多項的整合性服務，正確有效的解決孩子在成長過程中的各項困難，並預防發展狀況的惡化。(中華民國腦性痲痹協會)\n註3、什麼是療育補助、如何申請：\n此計劃中的早療補助款為新竹縣政府為鼓勵給發展遲緩兒接受早期療育而設立的補助款，詳情請查閱修正新竹縣發展遲緩兒童早期療育費用補助實施要點。通常用治療費用收據提出申請後，補助款會需要2個月的時間才能匯入受補助兒童的帳戶中。\n我們要做到\n1、輔導家長申請早療補助。\n與學校老師、社工合作，透過到宅訪視，輔導家長來協助發展遲緩兒取得療育補助資格。\n2、成立代墊基金。\n預先墊付已取得補助資格，但經濟困難無法預先支付治療費用的家庭，等到縣府補助款發放後再歸還即可。\n3、永續地協助。\n每年持續發掘遲緩兒並協助取得補助資格，讓計劃朝永續的方向努力。\n____________________________\n時程規劃：\n最低經費需求及運用\n我們預估100個家庭中，至少有1/3的家庭無力預先支付頭2個月的治療費用，每個月的補助為3,000元，兩個月為6,000元。因此預估代墊基金至少為204,000元。考量代墊基金不會同時支出，且每一筆代墊款在2個月後即可回補，所以預估總金額的60%，122,400元作為預備金即可。  因此，我們希望第一年至少可以募集到122,400元，並有更多的款項則能支付專業人員的訪視、行政及其他費用支出。");		// content 計畫內容
				pstmt.setString(11,"新竹縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/02/20");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/04/17");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);		// estMember  活動志工人數
				pstmt.setInt(15,50000);		// budget 活動預算
		
//																									pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/02/11").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setInt(22,5);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);					// primaryProjId 初步計畫編號
			pstmt.setInt(2,1);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,5);					// memberId 會員編號
			pstmt.setInt(4,44642);				// schoolId 學校編號
			pstmt.setString(5,"垃圾清理物資-採購計劃");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"粉鳥林漁港 環境整理物資採購計劃，有錢出錢，有力出力！資源互助，讓美麗的小漁港，永遠美麗！");		// projAbstract 計畫摘要
				pstmt.setString(10,"東澳‧粉鳥林漁港\n東澳灣．粉鳥林漁港位在宜蘭縣南澳鄉，為東澳灣的最南端，彎弧形的海灣由沙灘及交研所組成，湛藍的山海景緻盡收眼底，耳邊傳來海浪陣陣拍打岩岸的聲響，站在烏巖角上方的蘇花公路轉彎處，景色最為迷人。粉鳥林漁港早期有許多鴿子群聚於此，而鴿子的台灣稱為粉鳥，因此被稱為「粉鳥林漁港」，此漁港捕獲豆腐鯊的數量為台灣之最，不僅海天美景宜人，還有多種生鮮魚類，許多釣客也相當喜愛到此垂釣。(文章來源：玩全台灣旅遊網)\n為什麼需要募集採購垃圾袋的經費呢?\n粉鳥林是一個很美的小漁港，在過去訪客不多，垃圾也不多的時候，港邊的環境整理，皆由當地的海巡駐所人員自掏腰包，購買垃圾清潔袋，掃把等器材，並在非值班的時間，自發性的來整理環境垃圾。\n但隨著假日遊客增加，垃圾也隨之增加！造成原本美麗的小漁港慢慢變樣了！！而由於粉鳥林地處偏遠的東澳灣，當地政府的環保單位，沒有人力定期來整理清掃垃圾。\n而當地住民或海巡駐人員，雖有人有心願意就近協助整理環境，卻無力負擔購買垃圾清潔袋，掃把等耗材！為什麼我們想發起這個活動? \n我非常喜歡大海，常一個人遠從台北開車到粉鳥林垂釣。而每次到那後，總會隨手整理一下港邊的垃圾。久而久之，也與當地人有些認識及互動。從一次次的閒聊中，能深刻感受到當地居民對這環境的熱愛，但從言語中也有透露出一些無能為力。(下圖：居民的無奈) \n因為，過去的粉鳥林漁港，一個垃圾袋可以用上二個星期，還裝不滿。但現在，一個星期假日，就會產生好幾大袋的垃圾。而大型垃圾袋雖然一個10多元，但當垃圾袋消耗量大時，這些費用對於原本經濟收入就不佳的當地居民，也是沉重的負擔！他們實在沒有能力再自掏腰包了！(下圖：清潔物資的不足) \n大家可以怎麼幫粉鳥林? \n希望藉由這次活動，募集5000元的經費，用來購買10箱大型清潔袋(90x120cm)，及竹掃帚，垃圾夾等用具，供當地居民們清潔使用~~預計可使用半年。專案若成功，我們會將購買品項等相關證明、照片發布在故事記錄並更新在內文中。\n垃圾整理裝袋打包好後，就不會被風吹到海裡，也不會被貓狗抓食，更不會異味飄散。一包包的垃圾們，就可以乖乖地等候鎮公所的清潔車來搬運囉！(當地居民會電話聯絡鎮公所派車來載）");		// content 計畫內容
				pstmt.setString(11,"新竹縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/02/20");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/04/17");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);		// estMember  活動志工人數
				pstmt.setInt(15,50000);		// budget 活動預算
		
//																												pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2013/10/05").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setInt(22,5);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第十一筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,2);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,3);					// memberId 會員編號
			pstmt.setInt(4,94738);				// schoolId 學校編號
			pstmt.setString(5,"讓教育沒有距離");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"我們想讓更多人知道：在台灣的某個角落正有著這樣的一群孩子，當我們曾經靠著教育去改變未來，靠著努力學習去翻轉人生，才發現教育資源的差距是如此遙遠！而我們想利用線上教學平台\"讓教育沒有距離\"！");		// projAbstract 計畫摘要
				pstmt.setString(10,"一個念頭\n一個小故事，但其中卻含括了許多偏鄉學子正面臨到的問題，我們相信只要願意努力，教育其實可以改變一個人的未來，但伴隨著社會的M型化，台灣教育資源也逐漸的邁向M型化，教育資源的差距甚至高達16倍。教育應該是公平的，當一個學生想要透過學習來改變自己的未來時，我們不該用不公平的教育資源去限制他們的成長，\"學習\"不該是如此沉重的負擔。\n一群夥伴\n大學時期我們都憑著自己的一股熱血與熱情，帶著準備好的知識和我們的學習歷程，到這些需要我們的教學現場，希望能帶給這些孩子們更多的資源，在與孩子們的教學相長的過程中，從學期初的陌生害怕到學期末的互相信任，其實看到孩子們因為我們而成長、茁壯心裡是滿滿的感動。但是，我們終究必須面對的是，當一個學期或是營期的結束，志工服務同時也告一段落。每次到了分別的時候就會思考說當我們離開了，他們怎麼辦?所以這也促使團隊開始去想如何才能達到永續性的服務，也就是說，除了回憶之外還有什麼方法是就算我們離開了，我們想要帶給他們的東西還能永遠留在他們身邊?\n在我們團隊裡不乏當過課輔志工、家教、補習班、教程的同學。在教學的過程當中，其實都有一些心得和想法，特別是對一些在學習上屬於低成就的孩子。透過觀察，我們發現導致他們學習問題存在的主要原因在於最初的基礎沒有打好。就像是疊積木一樣當越疊越高，如果地基不穩，就會造成越來越明顯的搖晃。當一個較大外力或是壓力的施壓下，就像是一個艱澀的問題或是一張寫不出來的考卷，這積木就會在一瞬間瓦解，伴隨著瓦解的是學習的樂趣和意願。\n在這樣的情況下，如果家裡的經濟能力許可，或許可以請家教幫孩子找出學習上基礎不穩的地方，彌補回那些空洞不穩的積木，但如果這件事情發生在經濟資源相對弱勢的學生上，那誰能幫他們補回這些空缺的知識基礎。\n我們不斷的思考著能用甚麼方式去解決這個問題。當我們看了許多的資料以及和學校老師們討論過後，我們決定透過教學影片線上教學的方式，將教學影片和教材系統化，讓學生可以藉由家裡或是學校的電腦，連上網路，到我們所編製的教材影片區找到自己不會的地方，把不會的知識空缺給補上。\n一個計畫\n我們成立  LIS-learning is sharing透過LIS線上教學平台，期望去解決兩個問題\n1.台灣教育資源失衡: \n台灣的教育資源無論是在校內或是校外，因為地域性、經濟條件、家庭因素…等等，造成了教育資源相當程度的不均衡，也因此LIS線上教學平台上面的所有教學內容都是採用創用CC授權的概念免費開放，我們希望所有的學生都能擁有一份屬於他們的學習資源。\n2.學生缺乏學習動機: \n在台灣這種考試導向的學習環境中，越來越多的學生因為考試帶來的挫折，或是制式化的教學方式，喪失了學習的動機或是有逃避學習念頭產生。但學習其實是可以很有趣的，我們希望透過我們的教學影片，讓學生重新找回學習的動力。也期望學習不再因為地域、家境、資源…，而有所差距；學習不因為考試而失去了原本與日常生活的關聯性和有趣的本質。");		// content 計畫內容
				pstmt.setString(11,"雲林縣");				// location 活動確定地點
				
				pstmt.setString(12,"2014/07/06");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/09/01");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,20);		// estMember  活動志工人數
				pstmt.setInt(15,100000);		// budget 活動預算
		
//																															pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2014/06/13").getTime()));				// createDate  建立日期
				pstmt.setString(17,"洽談中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,false);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十二筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,3);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,6);					// memberId 會員編號
			pstmt.setInt(4,24672);				// schoolId 學校編號
			pstmt.setString(5,"偏鄉科學創意教學深耕計畫");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"由2009 年八八水災重建計畫的一堂科學課程為起點，自此翻山越嶺，深入中央山脈的深處，為科學教育資源乾涸的偏鄉部落，挹注科學知識的活水。六年來每學期走訪於六縣市40個鄉鎮之間，接觸了15個原住民族群，用生動有趣的科學課程，幫助孩子們透過學習，找回笑容、也找回自信。");		// projAbstract 計畫摘要
				pstmt.setString(10,"翻山越嶺，深入中央山脈的深處，以知識傳道的教育行者，將科學的智慧放入背包，為偏鄉的孩子，帶來一場場驚聲連連的科學知識盛宴。\n我是田園老師，每學期走訪上百所的偏鄉學校，為孩子們帶來一場場精彩的科學課。Vstory 報導：他雖然不是學校教師，卻一學期走訪超過140所偏鄉學校\n一學期教導超過 8000 位偏鄉孩童，源於一場八八水災\n2009 年莫拉克颱風所帶來的八八水災，重創了許多山區原住民的部落，除了財產的損失外，「教育」也深受其影響。當大人們忙著重建滿目瘡痍的家園，無心兼顧孩子們的學習時，教育更顯得力不從心⋯⋯。\n為了讓家長老師能夠有更多的心力重建家園，當時我把孩子們集中在大禮堂，在部落心靈嚴重受創的天災之後，給孩子們上一堂科學課。\n用生動有趣的科學知識，幫助孩子們透過學習，找回笑容、也找回自信。也因此，深耕偏鄉科學教育的千里藍圖，逐漸在我的足下展開，短短數年間學校間口耳相傳及他鄉的校長積極的聯絡下…由一開始的3所學校，擴增為155所，都是偏遠資源缺乏的學校。\n這六年來我每學期走訪於六縣市40個鄉鎮之間，接觸了15個原住民族群，我用自己的眼睛看到的、耳朵聽到的、雙腳走到的，皆是偏鄉對於科學教育資源的渴望！因此我毅然決然地持續走在這條科學道路上，於是點成線、線成面，6個縣市155所學校，織成我的偏鄉科學教育深耕地圖！我到訪的學校，都位處窮山僻壤中、交通不便，幾乎與世隔絕。在這樣的情況下大部分要自己自足，資源、教育、人才都不易進出，當然無法帶給深山孩子們豐厚的教育資源，文化刺激又少，山中的孩子與都市生活的孩子們落差愈來愈大，也愈來愈沒有自信⋯⋯\n因為深山漁村就業機會少，父母常常因為工作不能待在家，甚至必須到外地去打零工來養家糊口，只能靠祖父母照顧，甚至是「大孩子」帶「小孩子」，孩子無法擁有功能正常的家庭。\n由於地域偏遠，在交通不便、出入危險性高，且加給微薄的限制下，偏鄉的教師流動率非常高。許多有熱忱的教師，也因這些現實的因素而無法長期留在部落服務。因此學校人手不足，造成教師的工作負載大，嚴重壓縮教學品質與學習效果，雖然每位老師都能夠上科學課程，但真正有科學專業背景的教師卻不多，造就了以教師手冊「照本宣科」的教學方式，孩子們對科學知識的渴望因此無法被滿足，久而久之，好奇心被扼殺，求知慾也被抑制了。");		// content 計畫內容
				pstmt.setString(11,"宜蘭縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/06/10");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/08/24");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,14);		// estMember  活動志工人數
				pstmt.setInt(15,500000);		// budget 活動預算
		
//																																		pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/05/14").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十三筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,4);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,164639);				// schoolId 學校編號
			pstmt.setString(5,"【將軍國小暑期服務】美人魚現身將軍嶼");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"這個暑假，已有五年歷史的澎湖團隊將前往澎湖縣將軍嶼的將軍國小，進行志工服務，偏鄉地區的小學缺乏正式教師陪伴，我們秉持著「短期陪伴，長期傳承」的理念，希望能帶給當地孩童一個有意義的暑假。");		// projAbstract 計畫摘要
				pstmt.setString(10,"為什麼選擇將軍嶼?\n偏鄉國小的物質資源非常充足，但缺乏正式教師的長期陪伴，澎湖縣望安鄉將軍嶼的將軍國小，五年換五個導師，校內面臨缺乏正式教師的窘況，目前校內只有一位正式導師。因此今年暑假，已有五年歷史的澎湖團隊，秉持著「短期陪伴，長期傳承」的理念，將前往將軍國小，帶給當地孩童一個有意義的暑假。\n愛、希望、勇氣、陪伴\n我們以「愛、希望、勇氣、陪伴」做為團隊的四大理念，呈現給當地居民，讓他們勇於表達愛，對夢想懷抱希望，在遇到挫折時，能有勇氣站起來，全心全意的陪伴與照顧，讓他們感受到我們的真誠，並以延續性服務的心態，留給將軍嶼居民最好的印象。如何實踐我們的理念?\n透過生動有趣的教案內容，將四大理念貫穿在教案當中，讓小朋友對課程產生興趣，以下是我們的教案舉例。\n一、   愛—我的家人\n1.    活動方式：透過學習單與畫圖的方式，讓小朋友與家人有更多的接觸與互動，還有讓小朋友對家人說出自己的想法。\n2.    活動目標：現代人生活忙碌與家人相聚的時間極少，透過此活動，增加家庭互動，增進彼此感情。\n二、   希望—風箏DIY\n1.    活動方式：在風箏上著色或加上插畫，完成風箏後，依照組別，分別由隊輔帶到戶外空曠處放風箏。\n2.    活動目標：透過親手製作風箏，將風箏喻為夢想，讓小朋友勇敢逐夢。\n三、   勇氣—信任遊戲\n1.    活動方式：若干人圍成一圈，任一小朋友站在圓圈之中，站在圓內的小朋友，必須戴上眼罩，向任何方向倒去。圓圈周圍的小朋友，必須接住倒下的人，不能讓其跌倒，由小朋友輪流擔任中心，於活動結束後做反思。\n2.    活動目標：透過遊戲，從信任與被信任中，感受到團隊合作與溫暖的情誼。\n四、   陪伴―社區陪伴\n1.    活動方式：每天陪伴小隊員從活動地點回家，路途中隊輔們會一併進行環境清潔。與社區的老人或者長輩聊天，也希望帶領小隊員更了解自己家中的長輩，共同聆聽長輩的故事。並於2015/7/21進行淨灘活動，為將軍嶼做環境保護。\n2.    活動目標：讓團隊與社區居民有更多的互動機會，進而在陪伴的過程中，了解將軍嶼的生活文化。\n希望達到的成效\n一、實踐教育目的：\n我們設計的教案以卡通為主題，旨在提高當地小朋友的參與意願，再透過遊戲性的教學方式，讓他們在快樂中學習，跳脫傳統的教學模式，達成我們的教學目的。\n二、陪伴關懷：\n關懷是認識彼此的開始，與當地居民零距離交談，讓居民認識我們團隊，也讓我們深刻了解將軍嶼的生活環境、社會文化。\n三、提高英語興趣：\n短期的英語教育無法提高學生的英文能力，但我們希望，能帶起他們對英語的興趣，並了解國際語言的重要性。");		// content 計畫內容
				pstmt.setString(11,"澎湖縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/06/12");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/07/15");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,18);		// estMember  活動志工人數
				pstmt.setInt(15,40000);		// budget 活動預算
		
//																																					pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/05/12").getTime()));				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十四筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,5);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,6);					// memberId 會員編號
			pstmt.setInt(4,34718);				// schoolId 學校編號
			pstmt.setString(5,"小小的心願，大大的力量");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand05.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"一位五歲孩子的心願 - 雍雍的真實故事。我們將用愛串聯，用大家的愛心跟孩子的心願交換，您完成孩子的心願，我們將回贈您一個小小禮物，讓這個愛持續並圓滿，讓彼此的愛永遠大家的心中，也讓「希望」，帶著孩子們更有勇氣的往前走，讓所有的夢想希望都飛翔。");		// projAbstract 計畫摘要
				pstmt.setString(10,"ღ每一段影片都來自不同的心願，背後藏著動人的故事ღ\n此片是一位「五歲雍雍的真實故事」，我們讓雍雍抱到了爸爸。從小到大雍雍記憶中的爸爸就是隔著玻璃面孔，說不到幾句話就不見了，不曉得什麼是父愛?不曉得什麼是爸爸擁抱的溫度?不曉得什麼時候爸爸能陪在自己的身邊?每個人都有犯錯的時候，藉由自己的錯，導正孩子，勿走上不歸路。\nღ期待寶寶的心願ღ\n/心願卡是這樣來的\n每個孩子心中都有一個小小的心願，對你我來說也許平凡，但對那許許多多沒有爸爸、沒有媽媽的失親兒來說，卻是彌足珍貴。每張心願卡上的心願都來自不同的感人故事。本會將建構起平台，讓孩子許願，使企業或民眾能透過平台來完成孩子的心願，民眾也將獲得回饋，讓這份愛能獲得延續。\n/因為有你，才能完成期待寶寶的心願\n想起最初......看著孩子滿心期待寫下屬於自己的願望，每一次實現願望就很害怕能否接著再完成下一個願望?孩子的心願，因為有你......你能有更多的笑容ⓁⓄⓋⒺ☺\n/黃色小鴨 夢想實現\n經過統計整合後，數百數的小朋友最想來一趟黃色小鴨之旅，102/10/19舉辦孩子的願望—黃色小鴨夢想實現活動，帶著小朋友及家長一同前往高雄，讓他們看見了黃色小鴨，也讓他們搭上渡輪遊一圈，藉由此次的活動完成孩子的心願，也達成親子互動關係。\n為了充實弱勢孩童的暑期生活，舉辦心靈成長營，小朋友在充滿歡樂及學習才藝的氣份度過漫長的暑期生活，本次活動共22天，每一天有不同的課程，有弟子規、法律常識、陶藝、烹飪、園藝等等，在活動的過程中看到每一位期待寶寶收穫良多，看著每一位小朋友開心的模樣，讓我們心裡更加喜悅。在結束時，還有小朋友依依不捨的，也代表此次活動圓滿成功，因為帶領過這些期待寶寶們，讓我們知道舉辦活動部是一個人而是群體的團結與配合。");		// content 計畫內容
				pstmt.setString(11,"桃園市");				// location 活動確定地點
				
				pstmt.setString(12,"2014/04/07");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/06/02");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);		// estMember  活動志工人數
				pstmt.setInt(15,50000);		// budget 活動預算
		
//																																					pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2014/03/11").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-隊輔組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			// 第十六筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,6);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,7);					// memberId 會員編號
			pstmt.setInt(4,144623);				// schoolId 學校編號
			pstmt.setString(5,"幫台東天琪幼兒園的孩子籌一個月學費");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"教育，孩子才有機會脫貧。台東大武鄕的這所幼兒園有近8成的孩子無法繳交學雜費，看到這裡，原因您應該知道了！他們大多來自家境不好的家庭。但，修女們並沒有放棄這些5、6歲的小朋友。因此，我們應該也要支持這些自願減薪，甚至無薪的聖母媽媽們。省下一支超商冰淇淋，一件衣服，一杯手搖飲料的錢，讓教育改變他們的人生。");		// projAbstract 計畫摘要
				pstmt.setString(10,"1963年於台東成立的「尚武會院」，基於孩童教育需要，附設「天琪幼稚園」。長期以來，支持貧童的教育，就算必須由教職員自願減薪來補貼全園支出，讓孩子們有好的受教環境，也在所不惜。\n天主教私立天琪幼兒園主任沈秀惠表示，二十多年來，園方好幾次面臨經營困難，都是靠聖十字架慈愛修女會補助，勉強度過難關。但是這幾年修女會已經無法再出資補助，有意要結束經營。瑞士籍院長宋玉潔修女到處奔波籌錢，甚至向遠在瑞士的親友們募款，為的就是一股「孩子的教育不能中斷」的信念。\n宋玉潔修女：\n「一定要給小孩子教育，才有機會脫離貧困，未來才有希望。」\n宋玉潔修女自願奉召來台服務35年，曾獲得2013年第23屆的醫療奉獻獎。宋修女始終秉持「哪裡需要我，就往那裡去」的精神，默默為後山貧困及原住民學子貢獻心力。即使自己是個癌症病人，也拒絕返回瑞士聖十字架慈愛修女總院療養，寧願將餘生分享給更多需要幫助的人。四十多年來，修女們除了深入部落社區，從事人道關懷服務工作外，同時提供貧困、問題家庭與學習障礙孩童之啟蒙教育園地，並實施原住民青少年文化成長與課業輔導等課程。此地區大部分居民為排灣族人，由於天然環境的限制，工作機會少，謀生不易，大多數學童的家庭繳不起學費。幼兒園長期獨力承擔，終究面臨資源不足之困境，亟待外界的支援。\n每個月四十萬的基本支出讓宋玉潔院長備感艱辛。兩年前所有教職員，一起自願減薪兩成到三成，用這五、六萬元來支付水電開銷、修繕教室、購買教具文具和孩子們的點心。\n現在，天琪幼兒園真的需要一些幫助，為這些孩子籌募一個月的學費。在能力範圍內，透過一點點的力量，希望能多少分擔留在修女們身上的負擔。");		// content 計畫內容
				pstmt.setString(11,"台東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2014/05/26");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/06/08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);		// estMember  活動志工人數
				pstmt.setInt(15,18500);		// budget 活動預算
		
	//																																								pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setNull(16,Types.INTEGER);				// createDate  建立日期
				pstmt.setString(17,"已失敗");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,false);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第十七筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,8);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,4);					// memberId 會員編號
			pstmt.setInt(4,74654);				// schoolId 學校編號
			pstmt.setString(5,"團結就是保護海洋的力量");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand07.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"我們是一群來自彰化的國小三年級學生，我們想要透過自己的一雙手，展現我們對於保護海洋的團結力。每個人的改變都是一個發散的漣漪，期待這些好的的影響力可以一圈一圈的擴散出去。");		// projAbstract 計畫摘要
				pstmt.setString(10,"我們是一群來自彰化的國小三年級學生。經過老師的分享，我們知道海洋面臨了許多危機，也知道早已有許多人為這片海洋貢獻了自己的力量。十分謝謝他們！感謝之餘，我們也想要加入守護的行列，透過雙手，展現我們對於保護海洋的團結力。\n台灣島是從海底誕生的，四面環海的台灣，海洋是我們最寶貴的資產。中央研究院動物研究所張崑雄教授曾說：「少了海洋的台灣，就像離了水的魚。」一語道盡了我們對海洋的依賴。人類從海洋中獲取所需，但卻未能給予相應的回饋和感謝，反而是無止盡的傷害。\n2009年聯合國大會指定6月8日為世界海洋日。同年起，海洋計畫團體與世界海洋網絡都為每年海洋日訂一個主題，邀請世界各地的人民一起參與活動。\n2014年的主題為「團結就是保護海洋的力量」（Together we have the power to protect the ocean）我們決定一起響應世界海洋日，希望我們的小小行動，能進一步喚起更多人對海洋的關懷與思考。\n【募資所得的使用】\n募資所得的一小部分將會運用在上述活動的執行，扣除手繪明信片的紙材費及寄送明信片的郵資、信封等費用後，剩餘金額將捐款至【台灣環境資訊協會】及【黑潮海洋文教基金會】等環境公益組織。\n◎台灣環境資訊協會\n台灣環境資訊協會是獨立、不隸屬任何黨派、企業或個人的公益組織。旨在藉由環境資訊的交流與環境信託的推動，關懷環境、參與行動，以建構「人」與「自然」之間的和諧關係。（摘錄自網站介紹）\n◎黑潮海洋文教基金會\n黑潮海洋文教基金會於1998年成立，從鯨豚調查記錄工作為開端，進而以「關懷台灣海洋環境、生態與文化」為宗旨，盼匯集台灣愛好海洋民眾的心力，如同一股陸地上的黑潮洋流，共同以穩定、溫暖、堅持的態度，傳達與實踐海洋保育理念，期待讓大家親近、認識而珍惜海洋。（摘錄自網站介紹）");		// content 計畫內容
				pstmt.setString(11,"彰化縣");				// location 活動確定地點
				
				pstmt.setString(12,"2014/05/08");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2014/06/05");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,13);		// estMember  活動志工人數
				pstmt.setInt(15,5000);		// budget 活動預算
		
	//																																								pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				pstmt.setNull(16,Types.INTEGER);				// createDate  建立日期
				pstmt.setString(17,"洽談中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,false);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第十八筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setInt(2,10);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,5);					// memberId 會員編號
			pstmt.setInt(4,154506);				// schoolId 學校編號
			pstmt.setString(5,"還土地一片自然募資計劃");			// title 計畫名稱
			file = new File("image/schoolDemand/schoolDemand08.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"一趟雪山讓我們發現，爬山的意義不該是一昧追求攻頂而丟棄垃圾造成山林負擔，淨山讓我們重新發現爬山另一個意義，開始想為了這片土地的付出、對社會的回饋，坐而言不如起而行，希望我們對於這份良善意念的堅持能感染更多人！");		// projAbstract 計畫摘要
				pstmt.setString(10,"從初踏雪山的美麗，到見證玉山的壯麗；\n從看到土地真貌的心疼，到撫平山林傷口的脆弱。我們將號召眾人淨山的過程，希望以空拍機不同視角拍一部紀錄片，觀者可透過畫面一同感受台灣高山的壯麗與哀愁，更能看見淨山者們的精神與希望。從淨山開始，從心裡出發，慢慢發揚光大，我們正傳遞著一個精神—淨愛高山。\n動機: \n一個偶然機會攀登雪山，如影隨形的除了美景，更多的是覆蓋在箭竹叢、隱藏在山莊旁的垃圾，那些被忽略的土地商，他們多半都有淒慘的模樣，實際目睹高山難解的垃圾問題，數量非常驚人，卻像被遺忘似的灑落在那...早期登山人處理垃圾方式，是焚燒以及掩埋，但是隨著登山人數倍增，這樣的處理方式，對土地帶來沈重的負擔。\n下山後我們開始省思，當百岳成為迷思，爬山的意義不該是一昧追求攻頂而隨意棄置垃圾造成山林負擔，於是我們開始淨山，用自己的力量，一步步把垃圾帶下來。\n淨山讓我們發現爬山的另一種意義，從前為了賞景而上山，現在我們是為了淨山而上山，而每一個淨山經驗，都讓我們重新發現爬山另一個意義，淨山除了觀光休閒之外，它其實也可以是「衝擊與改變一個人的過程」，它可以顛覆你以往的思想，重新讓你認識自己和環境的關係。\n國內從事淨山活動，以針對中央山脈深處的高山地帶，由於清理難度與代價相當高，發起淨山的寥寥可數，因此我們選定高山作為執行的方向，並希望以空拍機不同視角拍一部紀錄片。\n我們會將號召眾人淨山的過程，利用影像、文字紀錄成影片以及編輯成書，觀者可透過影片及書本一同感受台灣高山的壯麗與哀愁，看見淨山者們的精神與希望，更能傳遞對於環境的省思。");		// content 計畫內容
				pstmt.setString(11,"花蓮縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015/04/16");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/06/15");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,25);		// estMember  活動志工人數
				pstmt.setInt(15,100000);		// budget 活動預算
		
	//																																								pstmt.setTimestamp(13,new java.sql.Timestamp(System.currentTimeMillis()));  //  createDate
				SimpleDateFormat sdf = new SimpleDateFormat();
				pstmt.setTimestamp(16,new java.sql.Timestamp(sdf.parse("2015/03/01").getTime()));				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"活動發起人-活動總召-活動組-企畫組-總務組");		// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);		// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);		// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);			// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);		// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.INTEGER);		// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
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
	}
	
	
	public static void main(String[] args)
	{
		InsertFullProj.start();
	}

}

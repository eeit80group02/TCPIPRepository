package init;
/*
 * 本程式作用:新增數筆"完整計畫"之資料於資料庫
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
import java.sql.SQLException;
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
		StringBuilder content = new StringBuilder();
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT);)
		{
			// 第一筆資料  ======================================================================
			pstmt.setInt(1,3);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"亞成鳥青少年野地教育計畫");			// title 計畫名稱
			File file = new File("image/primaryProj/primaryProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"每個人心中都有亮光，不一定被看見。 四天的陪伴，我們帶領青少年走入美麗的山林，遠離熟悉的生活。過程中，當面對困難和挑戰，我們說：「沒關係，這一段路我們陪你一起走」當有了跨越的勇氣，一切，也不再那麼困難。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台中市葵海農場");				// location 活動確定地點
				
				pstmt.setString(12,"2015/11/01");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/11/04");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,12);							// estMember  活動志工人數
				pstmt.setInt(15,150000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組:3人</p><p>活動組:5人</p><p>教學組:4人</p>");				// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第二筆資料  ======================================================================
			pstmt.setInt(1,4);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"友善生活實踐計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"2015年新化龍燈農藥廠事件的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？我們相信，在這塊土地上，一定還有堅持對環境友善的農民，以及默默為綠色環境努力的人們，我們期望，透過小農徵文比賽，讓這些友善環境的故事被看見，為這片土地帶來美好的滋養。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015/11/06");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/11/12");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,18);							// estMember  活動志工人數
				pstmt.setInt(15,50000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>總務組 6人</p><p>器材組 3人</p><p>執秘 3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第三筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setInt(2,9);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,114720);				// schoolId 學校編號
			pstmt.setString(5,"流浪毛小孩的【鍾】心期盼");			// title 計畫名稱
			file = new File("image/fullProj/fullProj01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"20年前，鍾媽媽在一次偶然的機緣下，發現一隻不會走(受傷)的流浪狗⋯⋯，漸漸地，鍾媽媽收養了越來越多需要幫助的狗兒⋯⋯。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/1.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"臺南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015-12-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-12-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,6);							// estMember  活動志工人數
				pstmt.setInt(15,50000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>活動組3人</p><p>機動組3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第四筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setInt(2,4);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,164639);				// schoolId 學校編號
			pstmt.setString(5,"【將軍國小暑期服務】美人魚現身將軍嶼");			// title 計畫名稱
			file = new File("image/fullProj/fullProj02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"偏鄉國小的物質資源非常充足，但缺乏正式教師的長期陪伴，澎湖縣望安鄉將軍嶼的將軍國小，已有五年歷史的澎湖團隊，秉持著「短期陪伴，長期傳承」的理念，帶給當地孩童一個有意義的暑假。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/2.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"澎湖縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-16");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-21");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,15);							// estMember  活動志工人數
				pstmt.setInt(15,70000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>總務組 6人</p><p>器材組 3人</p><p>執秘 3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第五筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setInt(2,2);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,94738);				// schoolId 學校編號
			pstmt.setString(5,"讓教育沒有距離");			// title 計畫名稱
			file = new File("image/fullProj/fullProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"一個念頭 一個小故事，但其中卻含括了許多偏鄉學子正面臨到的問題，我們相信只要願意努力，教育其實可以改變一個人的未來，但伴隨著社會的M型化，台灣教育資源也逐漸的邁向M型化，教育資源的差距甚至高達16倍");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/3.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"雲林縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-11-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-11-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);							// estMember  活動志工人數
				pstmt.setInt(15,15000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>教學組 4人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第六筆資料  ======================================================================
			pstmt.setInt(1,5);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"來自小漁村的台灣代表隊-國際參賽募資計劃");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj05.png");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"漁村的小孩不知道什麼是「夢想」，起初我們提供一個有點心吃的活動，對他們來說已經非常滿足。 「練習飛盤」這件事對於隊上大多數的孩子來說，是第一次學習如何把事情做好");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-15");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-21");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,11);							// estMember  活動志工人數
				pstmt.setInt(15,300000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>活動組 3人</p><p>機動組 4人</p><p>教學組 3人</p><p>執秘 1人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第七筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setInt(2,7);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,213511);				// schoolId 學校編號
			pstmt.setString(5,"與一群孩子的午後約定");			// title 計畫名稱
			file = new File("image/fullProj/fullProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"我們是來自國立交通大學傳播與科技學系三年級的同學。三個大學生，憑著一股熱情，想盡一己之力，為社會中的部分弱勢族群貢獻一點心力。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/4.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-15");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-17");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,4);							// estMember  活動志工人數
				pstmt.setInt(15,99999);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>無</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
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
			pstmt.setInt(1,6);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"徐超斌方舟教室夢想計畫");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"臺東縣的最南端達仁鄉，有一位超人醫師徐超斌，將自家改建成方舟教室，提供孩子們課輔、才藝、母語等課程。來自全台各院校的方向：D夥伴，為徐醫師所感動，與部落孩子們約定年年一起在方舟教室渡過每個特別的暑假。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-12-31");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2016-01-03");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,15);							// estMember  活動志工人數
				pstmt.setInt(15,100000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 5人</p><p>活動組 5人</p><p>教學組 5人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
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
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setInt(2,3);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,24672);				// schoolId 學校編號
			pstmt.setString(5,"偏鄉科學創意教學深耕計畫");			// title 計畫名稱
			file = new File("image/fullProj/fullProj05.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"翻山越嶺，深入中央山脈的深處，以知識傳道的教育行者，將科學的智慧放入背包，為偏鄉的孩子，帶來一場場驚聲連連的科學知識盛宴。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/5.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"宜蘭縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-11-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-11-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);							// estMember  活動志工人數
				pstmt.setInt(15,946500);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"招募中");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>教學組3人</p><p>機動組3人</p><p>活動組4人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 花絮
			// 第一筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"A");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"每個人心中都有亮光，不一定被看見。 四天的陪伴，我們帶領青少年走入美麗的山林，遠離熟悉的生活。過程中，當面對困難和挑戰，我們說：「沒關係，這一段路我們陪你一起走」當有了跨越的勇氣，一切，也不再那麼困難。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台中市葵海農場");				// location 活動確定地點
				
				pstmt.setString(12,"2015/11/01");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/11/04");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,12);							// estMember  活動志工人數
				pstmt.setInt(15,150000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組:3人</p><p>活動組:5人</p><p>教學組:4人</p>");				// orgArchitecture  成員架構
				
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第二筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);		// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"B");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"2015年新化龍燈農藥廠事件的衝擊，讓我們再度省思人與土地的關係，以及我們想要過什麼樣的生活？我們相信，在這塊土地上，一定還有堅持對環境友善的農民，以及默默為綠色環境努力的人們，我們期望，透過小農徵文比賽，讓這些友善環境的故事被看見，為這片土地帶來美好的滋養。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015/11/06");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015/11/12");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,18);							// estMember  活動志工人數
				pstmt.setInt(15,50000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>總務組 6人</p><p>器材組 3人</p><p>執秘 3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第三筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);		// schoolDemandId 學校需求編號
			pstmt.setInt(3,8);					// memberId 會員編號
			pstmt.setInt(4,114720);				// schoolId 學校編號
			pstmt.setString(5,"C");				// title 計畫名稱
			file = new File("image/fullProj/fullProj01.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"20年前，鍾媽媽在一次偶然的機緣下，發現一隻不會走(受傷)的流浪狗⋯⋯，漸漸地，鍾媽媽收養了越來越多需要幫助的狗兒⋯⋯。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/1.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"臺南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015-12-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-12-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,6);							// estMember  活動志工人數
				pstmt.setInt(15,50000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>活動組3人</p><p>機動組3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第四筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);		// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,164639);				// schoolId 學校編號
			pstmt.setString(5,"D");			// title 計畫名稱
			file = new File("image/fullProj/fullProj02.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"偏鄉國小的物質資源非常充足，但缺乏正式教師的長期陪伴，澎湖縣望安鄉將軍嶼的將軍國小，已有五年歷史的澎湖團隊，秉持著「短期陪伴，長期傳承」的理念，帶給當地孩童一個有意義的暑假。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/2.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"澎湖縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-16");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-21");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,15);							// estMember  活動志工人數
				pstmt.setInt(15,70000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>總務組 6人</p><p>器材組 3人</p><p>執秘 3人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第五筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);				// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,94738);				// schoolId 學校編號
			pstmt.setString(5,"E");			// title 計畫名稱
			file = new File("image/fullProj/fullProj03.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"一個念頭 一個小故事，但其中卻含括了許多偏鄉學子正面臨到的問題，我們相信只要願意努力，教育其實可以改變一個人的未來，但伴隨著社會的M型化，台灣教育資源也逐漸的邁向M型化，教育資源的差距甚至高達16倍");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/3.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"雲林縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-11-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-11-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);							// estMember  活動志工人數
				pstmt.setInt(15,15000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 3人</p><p>活動組 3人</p><p>教學組 4人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第六筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"F");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj05.png");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"漁村的小孩不知道什麼是「夢想」，起初我們提供一個有點心吃的活動，對他們來說已經非常滿足。 「練習飛盤」這件事對於隊上大多數的孩子來說，是第一次學習如何把事情做好");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-15");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-21");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,11);							// estMember  活動志工人數
				pstmt.setInt(15,300000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>活動組 3人</p><p>機動組 4人</p><p>教學組 3人</p><p>執秘 1人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
				pstmt.setBoolean(24,true);				// schoolConfirm  學校確認狀態(同意、預設null)
				pstmt.setBoolean(25,true);				// memberConfirm  發起人確認狀態(同意、預設null) TorF
				
				pstmt.executeUpdate();
				//
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// 第七筆資料  ======================================================================
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);				// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,213511);				// schoolId 學校編號
			pstmt.setString(5,"G");			// title 計畫名稱
			file = new File("image/fullProj/fullProj04.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"我們是來自國立交通大學傳播與科技學系三年級的同學。三個大學生，憑著一股熱情，想盡一己之力，為社會中的部分弱勢族群貢獻一點心力。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/4.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"台南市");				// location 活動確定地點
				
				pstmt.setString(12,"2015-10-15");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-10-17");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,4);							// estMember  活動志工人數
				pstmt.setInt(15,99999);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>無</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
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
			pstmt.setNull(1,Types.INTEGER);					// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);  	// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,11601);				// schoolId 學校編號
			pstmt.setString(5,"H");			// title 計畫名稱
			file = new File("image/primaryProj/primaryProj06.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"臺東縣的最南端達仁鄉，有一位超人醫師徐超斌，將自家改建成方舟教室，提供孩子們課輔、才藝、母語等課程。來自全台各院校的方向：D夥伴，為徐醫師所感動，與部落孩子們約定年年一起在方舟教室渡過每個特別的暑假。");		// projAbstract 計畫摘要
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"屏東縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-12-31");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2016-01-03");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,15);							// estMember  活動志工人數
				pstmt.setInt(15,100000);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>機動組 5人</p><p>活動組 5人</p><p>教學組 5人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
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
			pstmt.setNull(1,Types.INTEGER);  	// primaryProjId 初步計畫編號
			pstmt.setNull(2,Types.INTEGER);					// schoolDemandId 學校需求編號
			pstmt.setInt(3,1);					// memberId 會員編號
			pstmt.setInt(4,24672);				// schoolId 學校編號
			pstmt.setString(5,"i");			// title 計畫名稱
			file = new File("image/fullProj/fullProj05.jpg");
			try(FileInputStream fis = new FileInputStream(file);)
			{
				pstmt.setString(6,file.getName());	// frontCoverName 計畫封面檔名
				pstmt.setBinaryStream(7,fis,file.length());	// frontCover 計畫封面檔案大小
				pstmt.setLong(8,file.length());		// frontCoverLength 計畫封面檔案長度
				
				pstmt.setString(9,"翻山越嶺，深入中央山脈的深處，以知識傳道的教育行者，將科學的智慧放入背包，為偏鄉的孩子，帶來一場場驚聲連連的科學知識盛宴。");		// projAbstract 計畫摘要
				content.delete(0,content.length());
				File contentFile = new File("fullProjContent/5.txt");
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
				
				pstmt.setString(10,content.toString());			// content
				pstmt.setString(11,"宜蘭縣");				// location 活動確定地點
				
				pstmt.setString(12,"2015-11-03");				//activityStartTime 活動開始時間
				pstmt.setString(13,"2015-11-08");				//activityEndTime  活動結束時間
				
				pstmt.setInt(14,10);							// estMember  活動志工人數
				pstmt.setInt(15,946500);						// budget 活動預算
		
				pstmt.setString(16,"2015/10/02");				// createDate  建立日期
				pstmt.setString(17,"已完成");				    // projStatus  計畫狀態  
				pstmt.setString(18,"<p>教學組3人</p><p>機動組3人</p><p>活動組4人</p>");				// orgArchitecture  成員架構
				pstmt.setNull(19,Types.NVARCHAR);				// projFileName  完整計畫檔名(pdf)
				pstmt.setNull(20,Types.VARBINARY);				// projFile  完整計畫檔案(上傳完整計畫的pdf檔)
				pstmt.setNull(21,Types.BIGINT);					// projFileLength  檔案長度(pdf)
				
				pstmt.setNull(22,Types.INTEGER);				// reviews  評價分數(學校評價)(滿分5分)
				pstmt.setNull(23,Types.NVARCHAR);				// reviewsContent 評價內容(指學校給社團的評價內容)
				
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
		System.out.println("完整計畫新增完成");
	}
	
	
	public static void main(String[] args)
	{
		InsertFullProj.start();
	}

}

package model;

public class FullProjBean
{
	private int fullProjId;             		// 完整計畫 PK 流水
	private int initProjId;          			// 初步計畫 FK
	private int schoolDemandId;          		// 學校需求 FK *命名可能有問題
	private int memberId;                		// 發起人     FK
	private int schoolId;                		// 學校編號 FK
	private String name;             	 		// 完整計畫名稱
	private String frontCoverName;   	 		// 完整計畫封面 圖片檔名
	private byte[] frontCover;      	 		// 完整計畫封面 圖片
	private long frontCoverLength;   	 		// 完整計畫封面 圖片長度		
	private String projAbstract;     	 		// 完整計畫摘要(封面指到後的文字)
	private String content;          	 		// 完整計畫內容
	private String location;	     	 		// 活動地點
	private java.util.Date activityStartTime;   // 活動時間(起)	
	private java.util.Date activityEndTime;  	// 活動時間(訖)	
	private int estMember;           			// 預計招募人數 
	private int budget;             		    // 活動預算
	private java.util.Date createDate;			// 建立日期(完整計畫發布的日期)
	private String projStatus;       			// 計畫狀態(招募中;已失敗;已完成)	
	private String orgArchitecture;	 			// 成員架構(文字敘述)
	private String pdfName;          			// pdf檔名
	private byte[] pdf;	             			// pdf
	private long pdfLength;          			// pdf檔案長度
	private int reviews;			 			// 評論
	private int missionBoardId;	     			// 任務板編號(相關任務協作) FK
	private String reviewsContent;   			// 評論內容
	private String schoolConfirm;               // 學校確認狀態(同意、預設null)	
	private String memberConfirm;               // 發起人確認狀態(同意、預設null)
}

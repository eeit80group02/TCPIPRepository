package model;

public class PrimaryProjBean
{
	private int primaryProjId;             // identity
	private int memberId;               // 會員編號
	private String title;               // 初步計畫 名稱
	private String frontCoverName;      // 封面 檔名
	private byte[] frontCover;          // 封面 圖片
	private long frontCoverLength;      // 封面 圖片 長度
	private String projAbstract;        // 計畫摘要
	private String content;             // 計畫內容
	private String idealPlace;          // 理想地點
	private java.util.Date activityStartTime;      // 預計活動時間(起)
	private java.util.Date activityEndTime;     // 預計活動時間(迄)
	private int demandNum;              // 預計參予人數
	private int budget;                 // 預算
	private java.util.Date createDate;   // 建立日期
	private String projStatus;          // 狀態
}

package model;

public class SchoolDemandBean 
{
	private int schooldemandid;      	 // 計畫需求編號 PK identity
	private int schoolId;            	 // 學校編號 FK
	private int participant;             // 預計參與的學生人數
	private String activityTopicPicture; // 活動主題(指學校希望志工規劃的主題)
	private String activityLocation;     // 活動地點(非必填)
	private String activitySuitable;     // 活動適合對象(指學校希望志工來帶領的人的程度)
	private String activityHost;         // 活動負責人(學校方負責此項計畫的聯絡人)
	private String activityContact;      // 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式)
	private java.util.Date createDate;   // 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間
	private String content;              // 需求內容(1000字?)
}



package model;

public class ParticipatorBean
{
	private int fullProjId;    					// 完整計畫 FK 
	private int memberId;      					// 會員編號 FK
	private java.util.Date activityStartTime;   // 完整計畫 活動時間(起)
	private java.util.Date activityEndTime;     // 完整計畫 活動時間(迄)
	private String participateStatus;           // 審核狀態
	private java.util.Date checkTime;           // 審核通過時間
	private String isParticipate;               // 是否參加
}

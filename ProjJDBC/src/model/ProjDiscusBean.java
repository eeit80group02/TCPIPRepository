package model;

public class ProjDiscusBean 
{
	private int fullProjId;                     // 完整計畫編號	
	private int questionId;                     // 問題編號
	private int questionMemberId;               // 提問者編號(提問人的會員編號)	
	private String questionMemberContent;       // 提問問題內容(會員提問)	
	private java.util.Date questionMemberTime;  // 提問問題時間	
	private String answerMemberContent;         // 回覆問題的內容(活動發起人回覆問題)	
	private java.util.Date answerMemberTime;    // 回覆問題的時間	
	private int answerMemberId;                 // 回覆問題者(會員編號-活動發起人)	
}

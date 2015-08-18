package model;

public class MissionMessageBoardBean 
{
	private int fullProjId;                 // 計畫編號(完整計畫編號) FK
	private int missionSetId;               // 任務編號 FK
	private int memberId;                   // 留言者編號(留言者的會員編號) FK
	private String content;                 // 留言內容
	private java.util.Date messageTime;     // 留言時間
}

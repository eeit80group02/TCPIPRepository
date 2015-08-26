package model;

public class MissionMessageBean 
{
	private int MissionMessageId;           // 任務留言編號
	private int missionId;                  // 任務編號 FK
	private int memberId;                   // 留言者編號(留言者的會員編號) FK
	private String content;                 // 留言內容
	private java.util.Date messageTime;     // 留言時間
}

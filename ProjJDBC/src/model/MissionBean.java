package model;

import java.util.List;

public class MissionBean 
{
	private int missionBoardId;         // 任務集編號 FK
	private int missionId;          // 任務編號 PK
	private String name;               // 任務名稱
	private int	host;               // 執行者(主要負責執行的人) FK 會員編號	
	private java.util.Date endTime; // 執行任務的截止時間
	private	int missionPriority;    // 執行任務的優先次序
	private	int belongMissionSet;   // 屬於哪個任務集(關聯到任務集編號)(指任務集編號 左右) FK	
	private	int missionPosition;    // 擺在哪個指定的位置(任務順序上下)
	private	String missionStatus;   // 任務進行狀態(進行中,已完成)
	private	int mainMissionSetId;   // 主任務編號(「有值」的時候就是子任務) FK
	
	private List<MissionParticipatorBean> participator; // 參與者(協助任務執行的人) FK 會員編號
	
	
	
	
	
	
}

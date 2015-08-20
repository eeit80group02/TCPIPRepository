package model;

public class ProcessMemberBean 
{
	private int planId;   				// 計畫需求編號 FK
	private int memberId;  			   // 會員編號 FK
	private java.util.Date checkTime;  // 審核時間 (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
}

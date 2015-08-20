package model;

public class ProcessingProjBean 
{
	private int planId;   				// 計畫需求編號 FK
	private int schoolId;  			    // 會員編號 FK
	private java.util.Date checkTime;   // 審核時間 (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
}

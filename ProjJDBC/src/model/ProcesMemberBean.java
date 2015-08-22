package model;

public class ProcesMemberBean
{
	private int schoolDemandId;     	// 計畫需求編號 FK
	private int memberId;        	    //會員編號 FK
	private java.util.Date datetime;    // (指活動發起人下決定跟哪個學校接洽的那刻)(允許空值，只有洽談成功的學校有值)
}


package model;

public class ProjModifyBean
{
	private int fullProjId;	       		  // 完整計畫編號 FK
	private int schoolId;           	  // 學校編號 FK
	private String schoolMessage;	    	  // 學校留言
	private java.util.Date schoolMessageTime; // 學校留言時間
	private int memberId;    	          // 會員編號(發起者) FK
	private String memberMessage;	          // 會員留言 
	private java.util.Date memberMessageTime;    // 會員留言時間
}

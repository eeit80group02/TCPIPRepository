package model;

public class DonationDiscussBean 
{
	private int donationId;       			  // 捐獻編號(對應到【捐獻】表格) FK
	private String memberMessage;       	  // 會員留言(有意願捐獻者問的問題)
	private java.util.Date memberMessageTime; // 會員留言時間
	private String schoolMessage;             // 學校留言(學校回覆捐獻者的問題)
	private java.util.Date schoolMessageTime; // 學校留言時間
	private int memberId;        	          // 會員編號(提問人的會員編號) FK
	private int schoolId;       		      // 學校編號(回覆問題的學校編號) FK
}








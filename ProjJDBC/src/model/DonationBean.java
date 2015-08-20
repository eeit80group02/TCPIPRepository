package model;

public class DonationBean 
{
	private int donationId;         	 // 捐獻編號(流水號)(只要物品規格不同，視為兩筆) PK
	private int schoolId;          		 // 學校編號 FK
	private String donationStatus; 		 // 捐獻是否完成
	private String supplyName;           // 物資名稱
	private int originalDemandNumber;    // 原始輸入需求數量(數量)
	private String originalDemandUnit;   // 原始輸入需求數量(單位)	
	private int DemandNumber;            // 現在需求數量及單位(數量)	
	private String size;      	         // 尺寸規格(物品的大小>長*寬*高)	
	private String demandContent;        // 需求說明(為什麼需要這項物資)
	private String supplyStatus;         // 物資狀態(全新/二手/不拘)
	private java.util.Date traiseStart;  // 募集提出需求時間(物品開始募集時間)(即刻上架)
	private java.util.Date traiseEnd;    // 募集截止時間(物品結束募集時間)(當日0:00下架)
	private String objPicName;           // 圖片檔名
	private byte[] objPic;               // 圖片(需要的物品的圖片)
	private long objPicLength;           // 圖片長度
	private String remark;               // 備註(可以填寫額外的訊息)
}

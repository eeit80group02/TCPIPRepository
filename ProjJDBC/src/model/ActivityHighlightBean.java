package model;

public class ActivityHighlightBean 
{
	private int fullProjId;      // 完整計畫編號 FK
	private int memberId;        // 會員編號(活動發起人) FK
	private byte[] imageCover;   // 圖片(花絮的封面用的圖片)
	private String vedioURL;     // 影片路徑(嵌入youtube影片的網址-參考flyingV)
	private int articleContent;  // 文章(花絮的內文 - 用ckeditor編輯)
}



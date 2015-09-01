package model;

import java.util.Arrays;

public class ActivityHighlightBean 
{
	private int fullProjId;      	// 完整計畫編號 FK
	private int memberId;        	// 會員編號(活動發起人) FK
	private byte[] imageCover;   	// 圖片(花絮的封面用的圖片)
	private String vedioURL;     	// 影片路徑(嵌入youtube影片的網址-參考flyingV)
	private String content;  	 	// 文章(花絮的內文 - 用ckeditor編輯)
	
	public int getFullProjId() {
		return fullProjId;
	}
	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public byte[] getImageCover() {
		return imageCover;
	}
	public void setImageCover(byte[] imageCover) {
		this.imageCover = imageCover;
	}
	public String getVedioURL() {
		return vedioURL;
	}
	public void setVedioURL(String vedioURL) {
		this.vedioURL = vedioURL;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ActivityHighlightBean [fullProjId=" + fullProjId
				+ ", memberId=" + memberId + ", imageCover="
				+ Arrays.toString(imageCover) + ", vedioURL=" + vedioURL
				+ ", content=" + content + "]";
	}
}



package model.dao;

import java.util.Arrays;

public class ActivityHighlightDAOjdbc
{
	private int fullProjId;      	// 摰閮蝺刻�� FK
	private int memberId;        	// ��蝺刻��(瘣餃�韏瑚犖) FK
	private byte[] imageCover;   	// ����(�蝯桃��������)
	private String vedioURL;     	// 敶梁�楝敺�(撋youtube敶梁��雯��-���lyingV)
	private String content;  	 	// ����(�蝯桃���� - �ckeditor蝺刻摩)
	
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



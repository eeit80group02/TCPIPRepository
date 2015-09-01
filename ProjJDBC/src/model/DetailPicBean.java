package model;

public class DetailPicBean {
	private int fullProjId; // 計畫編號(完整計畫編號) FK
	private String imageName; // 圖片檔名
	private byte[] image; // 圖檔(檔案)
	private long imageLength; // 圖片長度(file)
	private String imageDescribe; // 圖片敘述

	public int getFullProjId() {
		return fullProjId;
	}

	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public long getImageLength() {
		return imageLength;
	}

	public void setImageLength(long imageLength) {
		this.imageLength = imageLength;
	}

	public String getImageDescribe() {
		return imageDescribe;
	}

	public void setImageDescribe(String imageDescribe) {
		this.imageDescribe = imageDescribe;
	}

}

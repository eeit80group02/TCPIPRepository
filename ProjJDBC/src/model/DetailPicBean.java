package model;

import java.io.Serializable;

public class DetailPicBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer fullProjId;		// 計畫編號(完整計畫編號) FK PK
	private String imageName;		// 圖片檔名 PK
	private byte[] image;			// 圖檔(檔案)
	private Long imageLength;		// 圖片長度(file)
	private String imageDescribe;	// 圖片敘述
	
	public DetailPicBean()
	{
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public String getImageName()
	{
		return imageName;
	}

	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}

	public byte[] getImage()
	{
		return image;
	}

	public void setImage(byte[] image)
	{
		this.image = image;
	}

	public Long getImageLength()
	{
		return imageLength;
	}

	public void setImageLength(Long imageLength)
	{
		this.imageLength = imageLength;
	}

	public String getImageDescribe()
	{
		return imageDescribe;
	}

	public void setImageDescribe(String imageDescribe)
	{
		this.imageDescribe = imageDescribe;
	}

	@Override
	public String toString()
	{
		return "DetailPicBean [fullProjId=" + fullProjId + ", imageName=" + imageName + ", imageLength=" + imageLength + ", imageDescribe=" + imageDescribe + "]";
	}

}

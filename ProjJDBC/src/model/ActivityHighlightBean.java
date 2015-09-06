package model;

import java.io.Serializable;
import java.util.Arrays;

public class ActivityHighlightBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer fullProjId;			// 完整計畫編號 FK
	private Integer memberId;        	// 會員編號(活動發起人) FK
	private String frontCoverName;		// 封面圖片檔名
	private byte[] frontCover;			// 圖片(花絮的封面用的圖片)
	private Long frontCoverLength;		// 封面圖片長度
	private String vedioURL;			// 影片路徑(嵌入youtube影片的網址-參考flyingV)
	private String content;				// 文章(花絮的內文 - 用ckeditor編輯)
	
	public ActivityHighlightBean()
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

	public Integer getMemberId()
	{
		return memberId;
	}

	public void setMemberId(Integer memberId)
	{
		this.memberId = memberId;
	}

	public String getFrontCoverName()
	{
		return frontCoverName;
	}

	public void setFrontCoverName(String frontCoverName)
	{
		this.frontCoverName = frontCoverName;
	}

	public byte[] getFrontCover()
	{
		return frontCover;
	}

	public void setFrontCover(byte[] frontCover)
	{
		this.frontCover = frontCover;
	}

	public Long getFrontCoverLength()
	{
		return frontCoverLength;
	}

	public void setFrontCoverLength(Long frontCoverLength)
	{
		this.frontCoverLength = frontCoverLength;
	}

	public String getVedioURL()
	{
		return vedioURL;
	}

	public void setVedioURL(String vedioURL)
	{
		this.vedioURL = vedioURL;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Override
	public String toString()
	{
		return "ActivityHighlightBean [fullProjId=" + fullProjId + ", memberId=" + memberId + ", frontCoverName=" + frontCoverName + ", frontCoverLength=" + frontCoverLength + ", vedioURL=" + vedioURL + ", content=" + content + "]";
	}
	
}
	




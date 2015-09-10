package model;

import java.io.Serializable;

public class ReviewsBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer reviewsId;		  // 流水號 PK
	private int fullProjId;           // 計畫編號(完整計畫編號) FK
	private int referMemberId;        // 會員編號(推薦人) FK
	private int referedMemberId;      // 會員編號(被推薦人) FK
	private Boolean isReviews;		  // 待評價(null) 推薦(T) 不推薦(F)
	private String content;    		  //  評價內容 
	
	public ReviewsBean()
	{
	}

	public Integer getReviewsId()
	{
		return reviewsId;
	}

	public void setReviewsId(Integer reviewsId)
	{
		this.reviewsId = reviewsId;
	}

	public int getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(int fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public int getReferMemberId()
	{
		return referMemberId;
	}

	public void setReferMemberId(int referMemberId)
	{
		this.referMemberId = referMemberId;
	}

	public int getReferedMemberId()
	{
		return referedMemberId;
	}

	public void setReferedMemberId(int referedMemberId)
	{
		this.referedMemberId = referedMemberId;
	}

	public Boolean getIsReviews()
	{
		return isReviews;
	}

	public void setIsReviews(Boolean isReviews)
	{
		this.isReviews = isReviews;
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
		return "ReviewsBean [reviewsId=" + reviewsId + ", fullProjId=" + fullProjId + ", referMemberId=" + referMemberId + ", referedMemberId=" + referedMemberId + ", isReviews=" + isReviews + ", content=" + content + "]";
	}
	
}







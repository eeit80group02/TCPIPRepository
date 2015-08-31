package model;

public class ReviewsBean 
{
	private int fullProjId;           //  計畫編號(完整計畫編號) FK
	private int referMemberId;        //  會員編號(推薦人) FK
	private int referedMemberId;      //  會員編號(被推薦人) FK
	private String content;    //  評價內容 
	public int getFullProjId() {
		return fullProjId;
	}
	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}
	public int getReferMemberId() {
		return referMemberId;
	}
	public void setReferMemberId(int referMemberId) {
		this.referMemberId = referMemberId;
	}
	public int getReferedMemberId() {
		return referedMemberId;
	}
	public void setReferedMemberId(int referedMemberId) {
		this.referedMemberId = referedMemberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReviewsBean [fullProjId=" + fullProjId + ", referMemberId="
				+ referMemberId + ", referedMemberId=" + referedMemberId
				+ ", content=" + content + "]";
	}
	
	
}







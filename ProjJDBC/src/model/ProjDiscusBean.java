package model;

public class ProjDiscusBean 
{
	private int fullProjId;                     // 完整計畫編號	
	private int questionId;                     // 問題編號
	private int questionMemberId;               // 提問者編號(提問人的會員編號)	
	private String questionMemberContent;       // 提問問題內容(會員提問)	
	private java.util.Date questionMemberTime;  // 提問問題時間	
	private String answerMemberContent;         // 回覆問題的內容(活動發起人回覆問題)	
	private java.util.Date answerMemberTime;    // 回覆問題的時間	
	private int answerMemberId;                 // 回覆問題者(會員編號-活動發起人)	
	
	public int getFullProjId() {
		return fullProjId;
	}
	public void setFullProjId(int fullProjId) {
		this.fullProjId = fullProjId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuestionMemberId() {
		return questionMemberId;
	}
	public void setQuestionMemberId(int questionMemberId) {
		this.questionMemberId = questionMemberId;
	}
	public String getQuestionMemberContent() {
		return questionMemberContent;
	}
	public void setQuestionMemberContent(String questionMemberContent) {
		this.questionMemberContent = questionMemberContent;
	}
	public java.util.Date getQuestionMemberTime() {
		return questionMemberTime;
	}
	public void setQuestionMemberTime(java.util.Date questionMemberTime) {
		this.questionMemberTime = questionMemberTime;
	}
	public String getAnswerMemberContent() {
		return answerMemberContent;
	}
	public void setAnswerMemberContent(String answerMemberContent) {
		this.answerMemberContent = answerMemberContent;
	}
	public java.util.Date getAnswerMemberTime() {
		return answerMemberTime;
	}
	public void setAnswerMemberTime(java.util.Date answerMemberTime) {
		this.answerMemberTime = answerMemberTime;
	}
	public int getAnswerMemberId() {
		return answerMemberId;
	}
	public void setAnswerMemberId(int answerMemberId) {
		this.answerMemberId = answerMemberId;
	}
	@Override
	public String toString() {
		return "ProjDiscusBean [fullProjId=" + fullProjId + ", questionId="
				+ questionId + ", questionMemberId=" + questionMemberId
				+ ", questionMemberContent=" + questionMemberContent
				+ ", questionMemberTime=" + questionMemberTime
				+ ", answerMemberContent=" + answerMemberContent
				+ ", answerMemberTime=" + answerMemberTime
				+ ", answerMemberId=" + answerMemberId + "]";
	}
	
}

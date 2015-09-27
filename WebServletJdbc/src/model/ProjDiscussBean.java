package model;

import java.io.Serializable;

public class ProjDiscussBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer projDiscussId;               // 流水編號
	private Integer fullProjId;                 // 完整計畫編號	
	private Integer questionMemberId;           // 提問者編號(提問人的會員編號)	
	private String questionMemberContent;       // 提問問題內容(會員提問)	
	private java.util.Date questionMemberTime;  // 提問問題時間	
	private String answerMemberContent;         // 回覆問題的內容(活動發起人回覆問題)	
	private java.util.Date answerMemberTime;    // 回覆問題的時間	
	private Integer answerMemberId;             // 回覆問題者(會員編號-活動發起人)	
	
	public ProjDiscussBean()
	{
	}

	public Integer getProjDiscussId()
	{
		return projDiscussId;
	}

	public void setProjDiscussId(Integer projDiscussId)
	{
		this.projDiscussId = projDiscussId;
	}

	public Integer getFullProjId()
	{
		return fullProjId;
	}

	public void setFullProjId(Integer fullProjId)
	{
		this.fullProjId = fullProjId;
	}

	public Integer getQuestionMemberId()
	{
		return questionMemberId;
	}

	public void setQuestionMemberId(Integer questionMemberId)
	{
		this.questionMemberId = questionMemberId;
	}

	public String getQuestionMemberContent()
	{
		return questionMemberContent;
	}

	public void setQuestionMemberContent(String questionMemberContent)
	{
		this.questionMemberContent = questionMemberContent;
	}

	public java.util.Date getQuestionMemberTime()
	{
		return questionMemberTime;
	}

	public void setQuestionMemberTime(java.util.Date questionMemberTime)
	{
		this.questionMemberTime = questionMemberTime;
	}

	public String getAnswerMemberContent()
	{
		return answerMemberContent;
	}

	public void setAnswerMemberContent(String answerMemberContent)
	{
		this.answerMemberContent = answerMemberContent;
	}

	public java.util.Date getAnswerMemberTime()
	{
		return answerMemberTime;
	}

	public void setAnswerMemberTime(java.util.Date answerMemberTime)
	{
		this.answerMemberTime = answerMemberTime;
	}

	public Integer getAnswerMemberId()
	{
		return answerMemberId;
	}

	public void setAnswerMemberId(Integer answerMemberId)
	{
		this.answerMemberId = answerMemberId;
	}

	@Override
	public String toString()
	{
		return "ProjDiscusBean [projDiscusId=" + projDiscussId + ", fullProjId=" + fullProjId + ", questionMemberId=" + questionMemberId + ", questionMemberContent=" + questionMemberContent + ", questionMemberTime=" + questionMemberTime
				+ ", answerMemberContent=" + answerMemberContent + ", answerMemberTime=" + answerMemberTime + ", answerMemberId=" + answerMemberId + "]";
	}

}

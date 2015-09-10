package model;

import java.io.Serializable;

public class GradeStudentBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer schoolId;			// 學校編號
	private Integer anniversary;		// 學年度(ex:104)
	private Integer elementaryFirst;	// 年級(一年級)
	private Integer elementarySecond;	// 年級(二年級)
	private Integer elementaryThird; 	// 年級(三年級)
	private Integer elementaryFourth; 	// 年級(四年級)
	private Integer elementaryFifth; 	// 年級(五年級)
	private Integer elementarySixth; 	// 年級(六年級)
	private Integer juniorFirst; 		// 年級(七年級)
	private Integer juniorSecond; 		// 年級(八年級)
	private Integer juniorThird; 		// 年級(九年級)
	
	public GradeStudentBean()
	{
	}
	
	public Integer getSchoolId()
	{
		return schoolId;
	}
	public void setSchoolId(Integer schoolId)
	{
		this.schoolId = schoolId;
	}
	public Integer getAnniversary()
	{
		return anniversary;
	}
	public void setAnniversary(Integer anniversary)
	{
		this.anniversary = anniversary;
	}
	public Integer getElementaryFirst()
	{
		return elementaryFirst;
	}
	public void setElementaryFirst(Integer elementaryFirst)
	{
		this.elementaryFirst = elementaryFirst;
	}
	public Integer getElementarySecond()
	{
		return elementarySecond;
	}
	public void setElementarySecond(Integer elementarySecond)
	{
		this.elementarySecond = elementarySecond;
	}
	public Integer getElementaryThird()
	{
		return elementaryThird;
	}
	public void setElementaryThird(Integer elementaryThird)
	{
		this.elementaryThird = elementaryThird;
	}
	public Integer getElementaryFourth()
	{
		return elementaryFourth;
	}
	public void setElementaryFourth(Integer elementaryFourth)
	{
		this.elementaryFourth = elementaryFourth;
	}
	public Integer getElementaryFifth()
	{
		return elementaryFifth;
	}
	public void setElementaryFifth(Integer elementaryFifth)
	{
		this.elementaryFifth = elementaryFifth;
	}
	public Integer getElementarySixth()
	{
		return elementarySixth;
	}
	public void setElementarySixth(Integer elementarySixth)
	{
		this.elementarySixth = elementarySixth;
	}
	public Integer getJuniorFirst()
	{
		return juniorFirst;
	}
	public void setJuniorFirst(Integer juniorFirst)
	{
		this.juniorFirst = juniorFirst;
	}
	public Integer getJuniorSecond()
	{
		return juniorSecond;
	}
	public void setJuniorSecond(Integer juniorSecond)
	{
		this.juniorSecond = juniorSecond;
	}
	public Integer getJuniorThird()
	{
		return juniorThird;
	}
	public void setJuniorThird(Integer juniorThird)
	{
		this.juniorThird = juniorThird;
	}
	
	@Override
	public String toString()
	{
		return "GradeStudentBean [schoolId=" + schoolId + ", anniversary=" + anniversary + ", elementaryFirst=" + elementaryFirst + ", elementarySecond=" + elementarySecond + ", elementaryThird=" + elementaryThird + ", elementaryFourth="
				+ elementaryFourth + ", elementaryFifth=" + elementaryFifth + ", elementarySixth=" + elementarySixth + ", juniorFirst=" + juniorFirst + ", juniorSecond=" + juniorSecond + ", juniorThird=" + juniorThird + "]";
	}
}

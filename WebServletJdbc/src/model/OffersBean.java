package model;

import java.io.Serializable;

public class OffersBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer schoolDemandId;		// 計畫需求編號 FK pk
	private Boolean room;				// 住宿(1表示提供 0 表示不提供)
	private Boolean place;				// 活動場地(1表示提供 0 表示不提供)
	private Boolean food;				// 伙食(1表示提供 0 表示不提供)
	
	public OffersBean()
	{
	}

	public Integer getSchoolDemandId()
	{
		return schoolDemandId;
	}

	public void setSchoolDemandId(Integer schoolDemandId)
	{
		this.schoolDemandId = schoolDemandId;
	}

	public Boolean getRoom()
	{
		return room;
	}

	public void setRoom(Boolean room)
	{
		this.room = room;
	}

	public Boolean getPlace()
	{
		return place;
	}

	public void setPlace(Boolean place)
	{
		this.place = place;
	}

	public Boolean getFood()
	{
		return food;
	}

	public void setFood(Boolean food)
	{
		this.food = food;
	}

	@Override
	public String toString()
	{
		return "OffersBean [schoolDemandId=" + schoolDemandId + ", room=" + room + ", place=" + place + ", food=" + food + "]";
	}

}

package model;

import java.io.Serializable;

public class TrainMapBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name; // 火車站名稱

	public TrainMapBean()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "TrainMapBean [name=" + name + "]";
	}
}

package model;

public class TrainMapBean {
	private String name; // 火車站名稱

	@Override
	public String toString() {
		return "TrainMapBean [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

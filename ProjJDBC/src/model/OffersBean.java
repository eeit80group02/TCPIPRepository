package model;

public class OffersBean 
{

	private int schoolDemandId;       //  計畫需求編號 FK
	private boolean room;     // 住宿(1表示提供 0 表示不提供)
	private boolean place;    // 活動場地(1表示提供 0 表示不提供)
	private boolean food;     // 伙食(1表示提供 0 表示不提供)

	public int getSchoolDemandId() {
		return schoolDemandId;
	}
	public void setSchoolDemandId(int schoolDemandId) {
		this.schoolDemandId = schoolDemandId;
	}
	public boolean isRoom() {
		return room;
	}
	public void setRoom(boolean room) {
		this.room = room;
	}
	public boolean isPlace() {
		return place;
	}
	public void setPlace(boolean place) {
		this.place = place;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "OffersBean [schoolDemandId=" + schoolDemandId + ", room="
				+ room + ", place=" + place + ", food=" + food + "]";
	}
	
}

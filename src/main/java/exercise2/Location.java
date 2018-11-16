package exercise2;

import java.io.Serializable;

public class Location implements Serializable {
	private final String local;
	private final String building;

	public Location(String local, String building) {
		this.local = local;
		this.building = building;
	}

	public String getLocal() {
		return local;
	}

	public String getBuilding() {
		return building;
	}
}

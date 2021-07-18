package demo.Patientproducer;

import com.google.gson.Gson;

public class AmbulanceInfo {
// If patient in or not, uniq id, coords , if true genrate condn
	private String vehicleId;
	private boolean inpatient;
	private String Case;

public AmbulanceInfo() {
		
	}


	public AmbulanceInfo(String vehicleId, boolean inpatient, String case1, Location location) {
		
		this.vehicleId = vehicleId;
		this.inpatient = inpatient;
		Case = case1;
		this.location = location;
	}

	
	
	public String getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}


	public boolean isInpatient() {
		return inpatient;
	}


	public void setInpatient(boolean inpatient) {
		this.inpatient = inpatient;
	}


	public String getCase() {
		return Case;
	}


	public void setCase(String case1) {
		Case = case1;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	private Location location;


	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

class Location {
	private double lat;
	private double lon;

	public Location(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
package bean;

import java.sql.Timestamp;
/**
 * Author Vold
 */
public class Earthquake {
	private int id;
	private Timestamp UTC_date;
	private float latitude;
	private float longitude;
	private float depth;
	private float magnitude;
	private String region;
	
	public Earthquake() {
	}
	/**
	 * This method is to encapsulate the Earthquake information
	 * @param id
	 * @param UTC_date
	 * @param latitude
	 * @param longitude
	 * @param depth
	 * @param magnitude
	 * @param region
	 */
	public Earthquake(int id, 
			Timestamp UTC_date, 
			float latitude, 
			float longitude, 
			float depth, 
			float magnitude,
			String region)throws Exception{
		this.id = id;
		this.UTC_date = UTC_date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.depth = depth;
		this.magnitude = magnitude;
		this.region = region;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return UTC_date
	 */
	public Timestamp getUTC_date() {
		return UTC_date;
	}
	/**
	 * @param UTC_date
	 */
	public void setUTC_date(Timestamp UTC_date) throws java.lang.IllegalArgumentException {
		this.UTC_date = UTC_date;
	}
	/**
	 * @return UTC_date
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return depth
	 */
	public float getDepth() {
		return depth;
	}
	/**
	 * @param depth
	 */
	public void setDepth(float depth) {
		this.depth = depth;
	}
	/**
	 * @return magnitude
	 */
	public float getMagnitude() {
		return magnitude;
	}
	/**
	 * @param magnitude
	 */
	public void setMagnitude(float magnitude) {
		this.magnitude = magnitude;
	}
	/**
	 * @return region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
}

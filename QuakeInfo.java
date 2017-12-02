package project;

public class QuakeInfo {
	private String id;
	private String UTC_date;
	private String latitude;
	private String longitude;
	private String depth;
	private String magnitude;
	private String region;
	public  QuakeInfo(String id,String UTC_date,String latitude
			,String longitude,String depth,String magnitude,String region){
		//用于获取和创建新的地震数据
		this.id = id;
		this.UTC_date = UTC_date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.depth = depth;
		this.magnitude = magnitude;
		this.region = region;
	}
	public String getId() {
		return id;
	}
	public void setId(String splitString) {
		this.id = splitString;
	}
	public String getUTC_date() {
		return UTC_date;
	}
	public void setUTC_date(String uTC_date) {
		UTC_date = uTC_date;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}

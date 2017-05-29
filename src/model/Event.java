package model;

import java.util.Date;
public class Event {
	private int id;
	private String title;
	private String description;
	private String type;
	private java.sql.Date startTime;
	private java.sql.Date endTime;
	private int maximumRegistrations;
	private boolean remainder;
	private int activity_id;
	private int person_id;
	private int location_id;

	public Event(){

	}
	public Event(String title, String description, java.sql.Date sqlDate, java.sql.Date sqlDate1, int maxReg, int activity_Id, int person_Id, int location_Id) {
	}

	public Event(int id, String title, String description,  java.sql.Date startTime, java.sql.Date endTime, int maximumRegistrations, int activity_id, int person_id, int location_id) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maximumRegistrations = maximumRegistrations;
		this.activity_id = activity_id;
		this.person_id = person_id;
		this.location_id = location_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public java.sql.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Date startTime) {
		this.startTime = startTime;
	}

	public java.sql.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.sql.Date endTime) {
		this.endTime = endTime;
	}

	public int getMaximumRegistrations() {
		return maximumRegistrations;
	}

	public void setMaximumRegistrations(int maximumRegistrations) {
		this.maximumRegistrations = maximumRegistrations;
	}

	public boolean isRemainder() {
		return remainder;
	}

	public void setRemainder(boolean remainder) {
		this.remainder = remainder;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", type='" + type + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", maximumRegistrations=" + maximumRegistrations +
				", remainder=" + remainder +
				", activity_id=" + activity_id +
				", person_id=" + person_id +
				", location_id=" + location_id +
				'}';
	}
}

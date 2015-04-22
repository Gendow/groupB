package event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
	public String location;
	private String creator;
	private String description;
	private String timeStamp;
	private String title;
	private String category;
	private List<String> helpers = new ArrayList<String>();
	private int eventID;
	private String status;
	static AtomicInteger nextId = new AtomicInteger();
	
	public Event(String strTitle, String strLocation, String strDescription, String strCategory){
		this.title = strTitle;
		this.location = strLocation;
		this.description = strDescription;
		this.category = strCategory;
		this.eventID = nextId.incrementAndGet();
		this.timeStamp = setTimeStamp();
		this.status = "In progress";
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public String setTimeStamp() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyy, HH:mm:ss");
		Date dateOfCreation = Calendar.getInstance().getTime();
		String reportDate = df.format(dateOfCreation);
		return reportDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String type) {
		this.category = type;
	}

	public void addHelper(String helpingPerson){
		helpers.add(helpingPerson);
	}

	public String getHelper() {
		String assignedHelpers = "";
		
		for (int i = 0; i < helpers.size(); i++) {
			String forprint = helpers.get(i);
			assignedHelpers = assignedHelpers + forprint.toString() + " ";
		}
		return assignedHelpers;
	}
	
	public String getEvent() {
		return location + description;
	}
	
	public String getAttributes() {
		return getTitle() + " \t\t  " + getLocation() + " \t \t " + getCategory();
	}

	public void addDescription(String extraDescription) {
		setDescription(getDescription() + "\n\n" + "[UPDATE] " + setTimeStamp() + ":\n" + extraDescription);
	}
	
	public String getEventID() {
		return Integer.toString(eventID);
	}

	public void setStatus(String status) {
		this.status = status;
		
	}

	public String getStatus() {
		return status;
	}
}

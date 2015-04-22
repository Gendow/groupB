package event;

import java.util.ArrayList;
import java.util.List;

public class EventList {

	public static List<Event> listOfEvents = new ArrayList<Event>();
	
	public EventList() {
	}

	public void addEvent(Event newEvent) {
		listOfEvents.add(newEvent);		
	}

	public static List<Event> getEventList() {
		return listOfEvents;
	}

	public static void deleteEvent(Event newEvent) {
		listOfEvents.remove(newEvent);
	}
	
	public List<Event> filterEvents(String location) {
		List<Event> resultList = new ArrayList<Event>();
		for (int i=0; i<listOfEvents.size(); i++) {
			if (getEventList().get(i).getLocation().equals(location)) {
				resultList.add(getEventList().get(i));
			}
		}
		return resultList;
	}
}

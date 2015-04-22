package test;

import event.Event;
import event.EventList;
import junit.framework.TestCase;

public class EventListTest extends TestCase {

	public void testEventListCreation() {
		EventList eventList = new EventList();
		assertNotNull(eventList);
	}
	
	public void testAddEvent() {
		Event newEvent = new Event("Rony", "Wageningen", "Hotboy112", "Fire");
		EventList eventList = new EventList();
		eventList.addEvent(newEvent);
		assertEquals(newEvent, EventList.getEventList().get(0));
	}
	
	public void testDeleteEvent(){
		Event newEvent = new Event("Rony", "Wageningen", "Hotboy112", "Fire");
		EventList eventList = new EventList();
		eventList.addEvent(newEvent);
		EventList.deleteEvent(newEvent);
		assertTrue(EventList.getEventList().isEmpty());
	}

	public EventList testFilter() {
		Event newEvent1 = new Event("Rony", "Wageningen", "Hotboy112", "Fire");
		Event newEvent2 = new Event("Andronikos", "Wageningen", "Hotb23oy112", "Tsunami");
		Event newEvent3 = new Event("Rony", "Wageningen", "Hotboy112", "Damage");
//		newEvent1.setLocation("Wageningen");
//		newEvent2.setLocation("Wageningen");
//		newEvent3.setLocation("Arnhem");
		EventList eventList = new EventList();
		eventList.addEvent(newEvent1);
		eventList.addEvent(newEvent2);
		eventList.addEvent(newEvent3);
		assertEquals("Wageningen", eventList.filterEvents("Wageningen").get(0).getLocation());
		return eventList;
	}
	
	public static EventList testGetEventList() {
		Event newEvent1 = new Event("Rony", "Wageningen", "Hotboy112", "Fire");
		Event newEvent2 = new Event("Andronikos", "Wageningen", "Hotb23oy112", "Tsunami");
		Event newEvent3 = new Event("Najib", "Ede", "eating duck", "Earthquake");
//		newEvent1.setLocation("Wageningen");
//		newEvent2.setLocation("Wageningen");
//		newEvent3.setLocation("Arnhem");
		EventList eventList = new EventList();
		eventList.addEvent(newEvent1);
		eventList.addEvent(newEvent2);
		eventList.addEvent(newEvent3);
		assertNotNull(EventList.getEventList());
		return eventList;
	}
}

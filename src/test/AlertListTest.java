package test;

import java.math.BigDecimal;

import event.EventList;
import event.GovAgencyAlert;
import event.AlertList;
import junit.framework.TestCase;

public class AlertListTest extends TestCase {
	

	private static BigDecimal latitude = new BigDecimal("1.25");
	private static BigDecimal longitude = new BigDecimal("1.44");

	public void testAlertListCreation() {
		AlertList alertList = new AlertList();
		assertNotNull(alertList);
	}
	
	public void testAddAlert() {
		GovAgencyAlert newGovAgencyAlert = new GovAgencyAlert("toxic plume", latitude, longitude, 300);
		AlertList alertList = new AlertList();
		alertList.add(newGovAgencyAlert);
		assertEquals(newGovAgencyAlert, alertList.get(0));
	}
	
	public void testDeleteEvent(){
		GovAgencyAlert newGovAgencyAlert = new GovAgencyAlert("toxic plume", latitude, longitude, 300);
		AlertList<GovAgencyAlert> alertList = new AlertList<GovAgencyAlert>();
		alertList.add(newGovAgencyAlert);
		alertList.remove(newGovAgencyAlert);
		assertTrue(EventList.getEventList().isEmpty());
	}
	
	public void testGetAlertList() {
		BigDecimal latitude2 = new BigDecimal("1.36");
		BigDecimal latitude3 = new BigDecimal("1.46");
		BigDecimal longitude2 = new BigDecimal("1.55");
		BigDecimal longitude3 = new BigDecimal("1.78");
		GovAgencyAlert newGovAgencyAlert1 = new GovAgencyAlert("toxic plume", latitude, longitude, 300);
		GovAgencyAlert newGovAgencyAlert2 = new GovAgencyAlert("toxic plume", latitude2, longitude2, 300);
		GovAgencyAlert newGovAgencyAlert3 = new GovAgencyAlert("toxic plume", latitude3, longitude3, 300);
		AlertList<GovAgencyAlert> alertList = new AlertList<GovAgencyAlert>();
		alertList.add(newGovAgencyAlert1);
		alertList.add(newGovAgencyAlert2);
		alertList.add(newGovAgencyAlert3);
		assertNotNull(alertList);
	}
}

/**
this.description = description;
this.latitude = latitude;
this.longitude = longitude;
this.radius = radius;
*/
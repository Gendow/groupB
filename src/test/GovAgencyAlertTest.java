package test;

import java.math.BigDecimal;

import junit.framework.TestCase;
import event.GovAgencyAlert;

public class GovAgencyAlertTest extends TestCase {
	
	public void testCreateAlert(){
		BigDecimal latitude = new BigDecimal("10.12345");
		BigDecimal longitude = new BigDecimal("11.11111");
		GovAgencyAlert newAlert = new GovAgencyAlert("Danger", latitude, longitude, 5000);
		assertNotNull(newAlert);
	}
}

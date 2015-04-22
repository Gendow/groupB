package test;

import java.util.ArrayList;
import java.util.List;

import useraccount.Journalist;
import useraccount.UserList;
import junit.framework.TestCase;

public class JournalistTest extends TestCase {
	
	UserList userList = new UserList();
	List<String> capabilities = new ArrayList<String>();
	
	public void testCreateJournalist() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		assertNotNull(newJournalist);
	}
	
	public void testFirstName() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualFirstName = newJournalist.getFirstName();
		assertEquals("Sam", actualFirstName);
	}
	
	public void testLastName() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualLastName = newJournalist.getLastName();
		assertEquals("Smith", actualLastName);
	}
	
	public void testGender() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualGender = newJournalist.getGender();
		assertEquals("male", actualGender);
	}
	
	public void testDateOfBirth() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualDateOfBirth = newJournalist.getDateOfBirth();
		assertEquals("01/01/1980", actualDateOfBirth);
	}
	
	public void testLocation() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualLocation = newJournalist.getLocation();
		assertEquals("Hoogstraat 27, Wageningen", actualLocation);
	}

	public void testOrganization() {
		Journalist newJournalist = new Journalist("journalist", "password", null, capabilities, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		String actualOrganization = newJournalist.getOrganization();
		assertEquals("BBC", actualOrganization);
	}
}

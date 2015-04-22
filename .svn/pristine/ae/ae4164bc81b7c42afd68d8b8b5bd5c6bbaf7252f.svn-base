package test;

import java.util.ArrayList;
import java.util.List;

import useraccount.Citizen;
import useraccount.UserList;
import junit.framework.TestCase;

public class CitizenTest extends TestCase {
	
	UserList userList = new UserList();
	List<String> capabilities = new ArrayList<String>();
	
	public void testCreateCitizen() {
		Citizen myCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		assertNotNull(myCitizen);
	}
	
	public void testFirstName() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		String actualFirstName = newCitizen.getFirstName();
		assertEquals("John", actualFirstName);
	}
	
	public void testLastName() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		String actualLastName = newCitizen.getLastName();
		assertEquals("Johnson", actualLastName);
	}
	
	public void testGender() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		String actualGender = newCitizen.getGender();
		assertEquals("male", actualGender);
	}
	
	public void testDateOfBirth() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		String actualDateOfBirth = newCitizen.getDateOfBirth();
		assertEquals("01/01/1970", actualDateOfBirth);
	}
	
	public void testLocation() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		String actualLocation = newCitizen.getLocation();
		assertEquals("Hoogstraat 25, Wageningen", actualLocation);
	}
	
	public void testAge() {
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		int actualAge = newCitizen.getAge();
		assertEquals(45, actualAge);
	}
	
	public void testCapabilities() {
		capabilities.add("First Aid Certificate");
		Citizen newCitizen = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/12/1970", "Hoogstraat 25, Wageningen");
		assertEquals("First Aid Certificate", newCitizen.getCapabilities().get(0));
	}
}

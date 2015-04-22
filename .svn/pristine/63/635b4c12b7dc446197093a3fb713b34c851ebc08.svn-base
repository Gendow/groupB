package test;

import java.util.Calendar;
import java.util.Date;
import useraccount.User;
import useraccount.UserList;
import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	UserList userList = new UserList();
	
	public void testCreateAccount() {
		User newAccount = new User("user", "password", null);
		assertNotNull(newAccount);
	}
	
	
	public void testPassword() {
		User newAccount = new User("user", "password", null);
		String actualPassword = newAccount.getPassword();
		assertEquals("password", actualPassword);
	}
	
	public void testGetCreationDate(){
		Calendar calendar = Calendar.getInstance();
		Date testTime = calendar.getTime();
		User newAccount = new User("user", "mypassword", null);
		newAccount.setCreationDate(testTime);
		assertEquals(testTime, newAccount.getCreationDate());
	}
}

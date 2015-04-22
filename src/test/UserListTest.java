package test;

import java.util.ArrayList;
import java.util.List;

import useraccount.Citizen;
import useraccount.UserList;
import junit.framework.TestCase;

public class UserListTest extends TestCase {
	
	List<String> capabilities = new ArrayList<String>();
	
	public void testCreateAccountSystem() {
		UserList account = new UserList();
		assertNotNull(account);
	}
	
	public void testAddUser() {
		UserList userList = new UserList();
		Citizen newUser = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newUser);
		assertEquals(newUser, userList.listOfUsers.get(0));
	}
	
	public void testDeleteUser() {
		UserList userList = new UserList();
		Citizen newUser = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newUser);
		userList.deleteUser(newUser);
		assertTrue(userList.listOfUsers.isEmpty());
	}
	
	public void testAddTwoUsers() {
		UserList userList = new UserList();
		Citizen newUserOne = new Citizen("citizen", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newUserOne);
		Citizen newUserTwo = new Citizen("journalist", "password", null, capabilities, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newUserTwo);
		assertEquals("journalist", newUserTwo.getUserName());
	}
}

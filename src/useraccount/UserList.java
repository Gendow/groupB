package useraccount;

import java.util.ArrayList;
import java.util.List;

public class UserList {

	public List<User> listOfUsers = new ArrayList<User>();
	
	public UserList() {
		listOfUsers = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		listOfUsers.add(user);		
	}
	
	public void deleteUser(User user) {
		this.listOfUsers.remove(user);		
	}
}

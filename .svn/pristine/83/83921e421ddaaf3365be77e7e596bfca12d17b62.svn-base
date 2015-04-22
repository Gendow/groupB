package useraccount;

import java.util.Date;

import useraccount.UserList;

public class User {
	
	protected String userName;
	protected String password;
	protected Date creationDate;
	
	public User(String userName,
				String password,
				Date creationDate) {
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
	}


	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() >= 8) {
			this.password = password;
		} else {
			System.out.println("password is too short");
		}
	}	
	
	public final Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}

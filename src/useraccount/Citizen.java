package useraccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Citizen extends User {

	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private int age;
	private String location;
	private List<String> capabilities = new ArrayList<String>();
	
	public Citizen(String userName,
				String password,
				Date creationDate,
				List<String> capabilities,
				String firstName,
				String lastName,
				String gender,
				String dateOfBirth,
				String location) {
		super(userName, password, creationDate);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.capabilities = capabilities;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getAge() {
		age = setAge(this.dateOfBirth);
		return age;
	}

	public int setAge(String dateOfBirth) {
		String dob = dateOfBirth;
		
		Date date = new Date();
		
		int dayDOB = Integer.parseInt(dob.substring(0, 2));
		int monthDOB = Integer.parseInt(dob.substring(3, 5));
		int yearDOB = Integer.parseInt(dob.substring(6, 10));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		int thisYear = Integer.parseInt(dateFormat.format(date));

		dateFormat = new SimpleDateFormat("MM");
		int thisMonth = Integer.parseInt(dateFormat.format(date));

		dateFormat = new SimpleDateFormat("dd");
		int thisDay = Integer.parseInt(dateFormat.format(date));
		
		int age = thisYear - yearDOB;
		
		if (thisMonth < monthDOB) {
			age = age - 1;
		}
		
		if (thisMonth == monthDOB && thisDay < dayDOB) {
			age = age - 1;
		}
		
		return age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<String> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(List<String> capabilities) {
		this.capabilities = capabilities;
	}
}

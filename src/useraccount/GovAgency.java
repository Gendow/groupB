package useraccount;

import java.util.Date;

public class GovAgency extends User {
	
	private String agencyName;
	private String location;
	
	public GovAgency(String userName,
			String password,
			Date creationDate,
			String agencyName,
			String location) {
		super(userName, password, creationDate);
		this.agencyName = agencyName;
		this.location = location;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

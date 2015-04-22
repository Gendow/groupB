package server;

import java.awt.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import useraccount.Citizen;
import useraccount.Journalist;
import useraccount.UserList;
import event.Event;

public class TestGetDataForCitizenFromTable
{

	// database URL
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	private static UserList userList;
	private static Citizen citizen;
	private static Journalist journalist;

	// launch the application
	public static void main(String args[]) throws ParseException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String username = "groupb";
		String pass = "pcroom66";
		userList = new UserList(); 
			
		// connect to database books and query database
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
		
		try	{
		// establish connection to database
		connection = DriverManager.getConnection(DATABASE_URL, username, pass);
		
		// create Statement for querying database
		statement = connection.createStatement();
		/*
		//perform insert
		String newInsert = "INSERT INTO `disapp`.`userList` (`userID`, `userName`, `password`, `creationDate`, `firstName`, `lastName`, `gender`, `dateOfBirth`, `age`, `location`,   `capabilities`,           `organization`)"
				+          "VALUES                          ('000005', 'citizen',  'yoepie',   '2015-04-20',   'steef',     'dam',      'male',   '01/01/1970',  23,  'Bennekom',   'Rope Expert Specialist', '')";
		
		System.out.println(newInsert);
		statement.executeUpdate(newInsert);
		 
		// delete record
		String newDelete = "DELETE FROM `disapp`.`userList` WHERE userID = 000001";
		statement.executeUpdate(newDelete);
		*/
		
		// query database
		resultSet = statement.executeQuery("SELECT * FROM userList");
		
		// process query results
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numberOfColumns = metaData.getColumnCount();
		System.out.println("Data from Table:\n");
		
		for ( int i = 1; i <= numberOfColumns; i++ )
			System.out.printf( "%-10s\t", metaData.getColumnName(i));
		System.out.println();
		int z = 0;
	
		while (resultSet.next())
		{
				//System.out.printf("%-10s\t", resultSet.getObject(i));
			String userName = resultSet.getObject("userName").toString();
			String password = resultSet.getObject("password").toString();
				
			String start_dt = resultSet.getObject("creationDate").toString();
			DateFormat formatter = new SimpleDateFormat("MM-dd-yy"); 
			Date date = (Date)formatter.parse(start_dt);

				
			Date creationDate = date;
				
				
			String firstName = resultSet.getObject("firstName").toString();
			String lastName = resultSet.getObject("lastName").toString();
			String gender = resultSet.getObject("gender").toString();
			String dateOfBirth = resultSet.getObject("dateOfBirth").toString();
			String location = resultSet.getObject("location").toString();
			String organization = resultSet.getObject("organization").toString();
				
			String[] capabilitiesSplit = resultSet.getObject("capabilities").toString().split(",");
				
			
	
			
			ArrayList<String> capabilities = new ArrayList<String>();
			
			for (String item : capabilitiesSplit) {
				item = item.replace("[", "");
				item = item.replace("]", "");
				capabilities.add(item);	//citizen.setCapabilities(item);
			}
			if (organization.isEmpty()) {
				citizen = new Citizen(userName, password, date, capabilities, firstName, lastName, gender, dateOfBirth, location);
				userList.addUser(citizen);
			} else {
				journalist = new Journalist(userName, password, date, capabilities, firstName, lastName, gender, dateOfBirth, location, organization);
				userList.addUser(journalist);
			}
			
			System.out.println(userList.listOfUsers.get(z).getUserName());
			System.out.println(((Citizen) userList.listOfUsers.get(z)).getCapabilities());
			System.out.println(((Citizen) userList.listOfUsers.get(z)).getCreationDate());
			if (userList.listOfUsers.get(z).getClass().equals("class useraccount.Journalist")){
				System.out.println(((Journalist) userList.listOfUsers.get(z)).getOrganization());
			}
			z = z + 1;
		}
	}
	
	catch (SQLException sqlException)
	{
		sqlException.printStackTrace();
	}
	finally
	{ 
		try
		{
		resultSet.close();
		statement.close();
		connection.close();
		} // end try
		catch ( Exception exception )
		{
		exception.printStackTrace();
		} // end catch
		} // end finally
	}
}

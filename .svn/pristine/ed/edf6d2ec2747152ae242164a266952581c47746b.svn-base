package server;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import event.Event;

public class TestGetDataFromTable
{

	// database URL
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	private static Event event;

	// launch the application
	public static void main(String args[]){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String username = "groupb";
		String pass = "pcroom66";
			
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
	
		while (resultSet.next())
		{
			for ( int i = 1; i <= numberOfColumns; i++ ) {
				System.out.printf("%-10s\t", resultSet.getObject(i));
				String location = resultSet.getObject(10).toString();
				event = new Event(null, null, null, null);
				event.setLocation(location);
			}
			System.out.println();
			System.out.println(event.getLocation());
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

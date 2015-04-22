package server;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import event.Event;
import event.EventList;

public class EventListFromDataBase
{

	// database URL
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	public static EventList eventList;
	private static Event event;

	// launch the application
	public static void main(String args[]) throws ParseException{
		testEventListFromDB();
	}

	public static void testEventListFromDB() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String username = "groupb";
		String pass = "pcroom66";
		eventList = new EventList(); 
			
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
		
		// query database
		resultSet = statement.executeQuery("SELECT * FROM eventList");
		
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
			String eventID = resultSet.getObject("eventID").toString();
			String title = resultSet.getObject("title").toString();
				
//			String start_dt = resultSet.getObject("timeStamp").toString();
//			DateFormat formatter = new SimpleDateFormat("MM-dd-yy"); 
//			Date date = (Date)formatter.parse(start_dt);
//			Date creationDate = date;
			String location = resultSet.getObject("location").toString();
			String category = resultSet.getObject("category").toString();
			String creator = resultSet.getObject("creator").toString();
			String status = resultSet.getObject("status").toString();
			String description = resultSet.getObject("description").toString();
				
			String[] helpersSplit = resultSet.getObject("helpers").toString().split(",");
				
			
	
			
			ArrayList<String> helpers = new ArrayList<String>();
			
			for (String item : helpersSplit) {
				item = item.replace("[", "");
				item = item.replace("]", "");
				helpers.add(item);	//citizen.setCapabilities(item);
			}
				event = new Event(title, location, description, category);
				eventList.addEvent(event);
			
			System.out.println(eventList.listOfEvents.get(z).getTitle());
			System.out.println((eventList.listOfEvents.get(z)).getLocation());
			System.out.println((eventList.listOfEvents.get(z)).getDescription());
			
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

package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	String username = "groupb";
	String pass = "pcroom66";
	
	// keep track of database connection status
	private boolean connectedToDatabase = false;
	
	// constructor initializes resultSet and obtains its meta data object;
	// determines number of rows
	public ResultSetTableModel( String url, String username,
	String password, String query ) throws SQLException
	{
	// connect to database
	connection = DriverManager.getConnection( DATABASE_URL, username, pass );
	
	// create Statement to query database
	statement = connection.createStatement(
	ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY );
	// update database connection status
	connectedToDatabase = true;
	
	// set query and execute it
	setQuery( query );
	 } // end constructor ResultSetTableModel

	 // get class that represents column type
	public Class getColumnClass( int column ) throws IllegalStateException
	{
		// ensure database connection is available
		if ( !connectedToDatabase )
		throw new IllegalStateException( "Not Connected to Database" );
		
		// determine Java class of column
		try
		{
			String className = metaData.getColumnClassName( column + 1 );
			// return Class object that represents className
			return Class.forName( className );
		}// end try
		catch ( Exception exception )
		{
		exception.printStackTrace();
		} // end catch
		
		return Object.class; // if problems occur above, assume type Object
		} // end method getColumnClass
		
		// get number of columns in ResultSet
		public int getColumnCount() throws IllegalStateException
		{
			// ensure database connection is available
			if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );
			
			// determine number of columns
			try
			{
			return metaData.getColumnCount();
			} // end try
			catch ( SQLException sqlException )
			 {
			 sqlException.printStackTrace();
			} // end catch
			return 0;// if problems occur above, return 0 for number of columns
			} // end method getColumnCount
			
		// get name of a particular column in ResultSet
		public String getColumnName( int column ) throws IllegalStateException
		{
			// ensure database connection is available
			if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );
			
			 // determine column name
			try
			{
			return metaData.getColumnName( column + 1 );
			} // end try
			catch ( SQLException sqlException )
			{
			sqlException.printStackTrace();
			} // end catch
			
			 return ""; // if problems, return empty string for column name
		} // end method getColumnName
		
		// return number of rows in ResultSet
		public int getRowCount() throws IllegalStateException
		{
			// ensure database connection is available
			if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );
		
			return numberOfRows;
			} // end method getRowCount
			
			// obtain value in particular row and column
		public Object getValueAt( int row, int column )
				throws IllegalStateException
			{
			// ensure database connection is available
			if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );
			
			// obtain a value at specified ResultSet row and column
			try
			{
				resultSet.absolute( row + 1 );
				return resultSet.getObject( column + 1 );
			}// end try
			catch ( SQLException sqlException )
			{
			sqlException.printStackTrace();
		}// end catch
			return ""; // if problems, return empty string object
	}// end method getValueAt
	
		// set new database query string
	public void setQuery(String query) 
		throws SQLException, IllegalStateException
		{
			// ensure database connection is available
			if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );
			
			// specify query and execute it
			if (query.split(" ")[0].equals("DELETE") || query.split(" ")[0].equals("INSERT") || query.split(" ")[0].equals("UPDATE")) {
				statement.executeUpdate(query);
				resultSet = statement.executeQuery("SELECT * FROM userList");
			} else if (query.split(" ")[0].equals("SELECT")) {
				resultSet = statement.executeQuery( query );
			} else {
				statement.execute(query);
				resultSet = statement.executeQuery("SELECT * FROM userList");
			}

			//resultSet = statement.executeQuery( query );
			
			// obtain meta data for ResultSet
			metaData = resultSet.getMetaData();
			// determine number of rows in ResultSet
			resultSet.last(); // move to last row
			numberOfRows = resultSet.getRow(); // get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} // end method setQuery
		
		// close Statement and Connection
		public void disconnectFromDatabase()
		{
		if ( connectedToDatabase )
		{
		// close Statement and Connection
		try
		{
		resultSet.close();
		statement.close();
		connection.close();
		} // end try
		catch ( SQLException sqlException )
		{
		sqlException.printStackTrace();
		} // end catch
		finally // update database connection status
		{
		connectedToDatabase = false;
		} // end finally
		} // end if
		} // end method disconnectFromDatabase
		
			
}

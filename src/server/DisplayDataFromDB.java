package server;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DisplayDataFromDB extends JPanel {

	
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	String username = "groupb";
	String pass = "pcroom66";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	static final String DEFAULT_QUERY = "SELECT * FROM userList";
	private ResultSetTableModel tableModel;
	private JTextArea queryArea;
	protected DefaultRowSorter<TableModel, Integer> sorter;
	/**
	 * Create the panel.
	 */
	public DisplayDataFromDB() {

		
		
		// connect to database books and query database
	try {
        // The newInstance() call is a work around for some
        // broken Java implementations

        Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception ex) {
        // handle the error
    }
	// create ResultSetTableModel and display database table
	try
	{
		
		// create TableModel for results of query SELECT * FROM comments
		tableModel = new ResultSetTableModel( DATABASE_URL,
		username, pass, DEFAULT_QUERY );	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500, 0};
		gridBagLayout.rowHeights = new int[]{56, 188, 38, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// set up JTextArea in which user types queries
		queryArea = new JTextArea( DEFAULT_QUERY, 3, 100 );
		queryArea.setWrapStyleWord( true );
		queryArea.setLineWrap( true );
		
		JScrollPane scrollPane = new JScrollPane( queryArea,
		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		
		// set up JButton for submitting queries
		JButton submitButton = new JButton( "Submit Query" );
		
		// create Box to manage placement of queryArea and
		// submitButton in GUI
		Box boxNorth = Box.createHorizontalBox();
		boxNorth.add( scrollPane );
		boxNorth.add( submitButton );
		
		// place GUI components on content pane
		GridBagConstraints gbc_boxNorth = new GridBagConstraints();
		gbc_boxNorth.fill = GridBagConstraints.BOTH;
		gbc_boxNorth.insets = new Insets(0, 0, 5, 0);
		gbc_boxNorth.gridx = 0;
		gbc_boxNorth.gridy = 0;
		add( boxNorth, gbc_boxNorth );
		
		// create event listener for submitButton
		submitButton.addActionListener(
	
		 new ActionListener()
		 {
		// pass query to table model
		public void actionPerformed( ActionEvent event )
		{
		// perform a new query
		try
		 {
			tableModel.setQuery( queryArea.getText() );
	}
	catch ( SQLException sqlException2 )
	{
	JOptionPane.showMessageDialog( null,
	sqlException2.getMessage(), "Database error",
	JOptionPane.ERROR_MESSAGE );
	
	// try to recover from invalid user query
	// by executing default query
	try
	{
		tableModel.setQuery( DEFAULT_QUERY );
		queryArea.setText( DEFAULT_QUERY );
	} //end try
	catch ( SQLException sqlException21 )
	{
	JOptionPane.showMessageDialog( null,
	sqlException21.getMessage(), "Database error",
	JOptionPane.ERROR_MESSAGE );
	
	// ensure database connection is closed
	tableModel.disconnectFromDatabase();
	System.exit( 1 ); // terminate application
	 } // end inner catch
	} // end outer catch
} // end actionPerformed
} // end ActionListener inner class
); // end call to addActionListener
		
		
				// create JTable based on the tableModel
				JTable resultTable = new JTable( tableModel ); 
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(0, 0, 5, 0);
				gbc.gridx = 0;
				gbc.gridy = 1;
				JScrollPane scrollPane_1 = new JScrollPane( resultTable );
				add( scrollPane_1, gbc );
				resultTable.setRowSorter( sorter );
		
		JLabel filterLabel = new JLabel( "Filter:" );
		final JTextField filterText = new JTextField();
		JButton filterButton = new JButton( "Apply Filter" );
		Box boxSouth = Box.createHorizontalBox();
		
		boxSouth.add( filterLabel );
		boxSouth.add( filterText );
		boxSouth.add( filterButton );
		GridBagConstraints gbc_boxSouth = new GridBagConstraints();
		gbc_boxSouth.fill = GridBagConstraints.BOTH;
		gbc_boxSouth.gridx = 0;
		gbc_boxSouth.gridy = 2;
		add( boxSouth, gbc_boxSouth );
		
		// create listener for filterButton
	filterButton.addActionListener(
	new ActionListener()
	 {
		// pass filter text to listener
		public void actionPerformed( ActionEvent e )
		{
		String text = filterText.getText();
	
		if ( text.length() == 0 )
		sorter.setRowFilter( null );
		else
		{
		try
		{
			sorter.setRowFilter(
					RowFilter.regexFilter( text ) );
		} //end try
		catch ( PatternSyntaxException pse )
		{
			JOptionPane.showMessageDialog( null,
					 "Bad regex pattern", "Bad regex pattern",
					 JOptionPane.ERROR_MESSAGE );
			} // end catch
		} // end else
		} // end method actionPerfomed
		} // end annonymous inner class
		); // end call to addActionLister
	
	
	final TableRowSorter< TableModel > sorter =
			new TableRowSorter< TableModel >( tableModel );
			setSize( 540, 291 ); // set window size
			setVisible( true ); // display window
		} // end try
		catch ( SQLException sqlException )
		{
		JOptionPane.showMessageDialog( null, sqlException.getMessage(),
		"Database error", JOptionPane.ERROR_MESSAGE );
		
		// ensure database connection is closed
		tableModel.disconnectFromDatabase();
		
		System.exit( 1 ); // terminate application
		} //end catch
		
	// dispose of window when user quits application (this overrides
	// the default of HIDE_ON_CLOSE)
	//setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	
	
	// ensure database connection is closed when user quits application
	/*addWindowListener(
	
			new WindowAdapter()
			{
				// disconnect from database and exit when window has closed
				public void windowClosed( WindowEvent event )
				{
				tableModel.disconnectFromDatabase();
				System.exit( 0 );
				} // end method windowClosed
			} // end WindowAdapter inner class
		
			); // end call to addWindowListener
			*/
	} // end DisplayQueryResults constructor
	
	// execute application
	public static void main( String args[] )
	 {
		new DisplayDataFromDB();
	} // end main
	} // end class DisplayQueryResults

	



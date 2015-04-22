package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import event.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import useraccount.Citizen;
import useraccount.GovAgency;
import useraccount.Journalist;
import useraccount.User;
import useraccount.UserList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textPassword;
	private JButton btnLogIn;
	private JButton btnCancel;
	private JLabel lblShowError;
	private final JLabel label = new JLabel("New label");
	private JButton btnRegister;
	private static MainFrame mainFrame;
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	private String checkedUserName;

	List<String> capabilities = new ArrayList<String>();
	private String setUserName;
	static UserList userList = new UserList();
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn(userList, mainFrame);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LogIn(UserList userList, MainFrame mainFrame) {
		
		this.userList = userList;
		this.mainFrame = mainFrame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{85, 85, 85};
		gbl_contentPane.rowHeights = new int[]{20, 20, 20, 0, 20, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblLogIn = new GridBagConstraints();
		gbc_lblLogIn.gridwidth = 4;
		gbc_lblLogIn.insets = new Insets(0, 0, 15, 0);
		gbc_lblLogIn.gridx = 0;
		gbc_lblLogIn.gridy = 0;
		contentPane.add(lblLogIn, gbc_lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.anchor = GridBagConstraints.WEST;
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 1;
		contentPane.add(lblUserName, gbc_lblUserName);
		
		textUserName = new JTextField();
		GridBagConstraints gbc_textUserName = new GridBagConstraints();
		gbc_textUserName.gridwidth = 2;
		gbc_textUserName.insets = new Insets(5, 5, 5, 5);
		gbc_textUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUserName.gridx = 1;
		gbc_textUserName.gridy = 1;
		contentPane.add(textUserName, gbc_textUserName);
		textUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(5, 5, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		textPassword = new JTextField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.insets = new Insets(5, 5, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 1;
		gbc_textPassword.gridy = 2;
		contentPane.add(textPassword, gbc_textPassword);
		textPassword.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCancelLogIn();
			}
		});
		
		lblShowError = new JLabel("");
		GridBagConstraints gbc_lblShowError = new GridBagConstraints();
		gbc_lblShowError.anchor = GridBagConstraints.WEST;
		gbc_lblShowError.gridwidth = 2;
		gbc_lblShowError.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowError.gridx = 1;
		gbc_lblShowError.gridy = 3;
		contentPane.add(lblShowError, gbc_lblShowError);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRegister();
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.weightx = 1.0;
		gbc_btnRegister.insets = new Insets(0, 0, 0, 0);
		gbc_btnRegister.anchor = GridBagConstraints.SOUTH;
		gbc_btnRegister.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegister.gridx = 0;
		gbc_btnRegister.gridy = 4;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.SOUTH;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 0);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 4;
		contentPane.add(btnCancel, gbc_btnCancel);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					handleLogIn();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.anchor = GridBagConstraints.SOUTH;
		gbc_btnLogIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogIn.gridx = 2;
		gbc_btnLogIn.gridy = 4;
		contentPane.add(btnLogIn, gbc_btnLogIn);
	}

	protected void handleRegister() {
		CreateUser createUser = new CreateUser(userList);
	}

	/** go to the Welcome User screen;
	 * Currently, it creates a new window on top of the Main Menu window
	 * @throws ParseException 
	 */
	protected void handleLogIn() throws ParseException {
		
		// Start the database section to insert new user
		Connection connection = null;
		Statement statement1 = null;
		Statement statement2 = null;
		Statement statement3 = null;
		ResultSet resultSet = null;
		ResultSet checkPass = null;
		ResultSet userResults = null;
		String username = "groupb";
		String pass = "pcroom66";
					
		// connect to database books and query database
		try {
		    // The newInstance() call is a work around for some
		    // broken Java implementations

		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		      System.out.println("Coonection did not work");
		}
				
		try	{
		// establish connection to database
		connection = DriverManager.getConnection(DATABASE_URL, username, pass);
		
		// create Statement for querying database
		statement1 = connection.createStatement();
		
		// query database
		resultSet = statement1.executeQuery("SELECT userName FROM userList");
		
		//try {
		while (resultSet.next())
		{
			checkedUserName = resultSet.getObject(1).toString();
			if (checkedUserName.equals(textUserName.getText())){
				setUserName = checkedUserName;
				break;
			}
		}
		//} catch (Exception e) {System.out.println("Wrong username");}	
			
		System.out.println(setUserName);
		
		statement2 = connection.createStatement();
		checkPass = statement2.executeQuery(String.format("SELECT password FROM `disapp`.`userList` WHERE userName = '%s'", checkedUserName));
		
		if (setUserName != null && !setUserName.isEmpty()){
			while (checkPass.next())
			{
				String checkedPass = checkPass.getObject(1).toString();
				if (checkedPass.equals(textPassword.getText())) {
					System.out.println("First password check");
					System.out.println(checkPass.getObject(1).toString());
					System.out.println("Second password check");
					System.out.println(checkPass.getObject(1).toString());
					
					statement3 = connection.createStatement();
					userResults = statement3.executeQuery(String.format("SELECT * FROM `disapp`.`userList` WHERE userName = '%s'", checkedUserName));
					while (userResults.next()) {
						String userName = userResults.getObject("userName").toString();
						String password = userResults.getObject("password").toString();
						String start_dt = userResults.getObject("creationDate").toString();
						DateFormat formatter = new SimpleDateFormat("MM-dd-yy");
						Date date = (Date)formatter.parse(start_dt);
						Date creationDate = date;
						String firstName = userResults.getObject("firstName").toString();
						String lastName = userResults.getObject("lastName").toString();
						String gender = userResults.getObject("gender").toString();
						String dateOfBirth = userResults.getObject("dateOfBirth").toString();
						String location = userResults.getObject("location").toString();
						String organization = userResults.getObject("organization").toString();
						String agencyName = userResults.getObject("agencyName").toString();
						String[] capabilitiesSplit = userResults.getObject("capabilities").toString().split(",");
						ArrayList<String> capabilities = new ArrayList<String>();
					
						for (String item : capabilitiesSplit) {
							item = item.replace("[", "");
							item = item.replace("]", "");
							capabilities.add(item);	//citizen.setCapabilities(item);
						}
	
						if (organization.isEmpty() && agencyName.isEmpty()) {
							Citizen citizen = new Citizen(userName, password, date, capabilities, firstName, lastName, gender, dateOfBirth, location);
							System.out.println(citizen);
							this.mainFrame.loggedInUser = citizen;
						} else if (!organization.isEmpty()) 
							{
							Journalist journalist = new Journalist(userName, password, date, capabilities, firstName, lastName, gender, dateOfBirth, location, organization);
							this.mainFrame.loggedInUser = journalist;
							System.out.println(journalist);
						} else {
							GovAgency govAgency = new GovAgency(userName, password, date, agencyName, location);
							this.mainFrame.loggedInUser = govAgency;
							System.out.println(govAgency);
						}
					}
				userResults.close();
				statement3.close();
			}
		}
		} else { lblShowError.setText("UserName and/or password incorrect");}
		checkPass.close();
		statement2.close();
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
			statement1.close();
			connection.close();
			dispose();
			mainFrame.redraw();
		} // end try
		catch ( Exception exception )
		{
			exception.printStackTrace();
		} // end catch
	} // end finally
}

	
		/*
		boolean trueID = false;
		
		for (User users : this.userList.listOfUsers){

			if (users.getUserName().equals(textUserName.getText()) &&
					users.getPassword().equals(textPassword.getText())) {
					trueID = true;
					
					this.mainFrame.loggedInUser = users;
					
					if (textUserName.getText().equals("admin") && textPassword.getText().equals("123456")){
						mainFrame.userType = "class useraccount.Admin";
					} else {
						mainFrame.userType = users.getClass().toString();
					}
					dispose();
					mainFrame.redraw();
			}
		}
		
		if (trueID == false){
			lblShowError.setText("UserName and/or password incorrect");
		}
		*/
	
	protected void handleCancelLogIn() {
		dispose();
	}
}

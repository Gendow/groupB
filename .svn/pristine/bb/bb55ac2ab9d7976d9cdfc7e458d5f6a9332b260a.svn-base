package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;

import event.Event;
import useraccount.Citizen;
import useraccount.Journalist;
import useraccount.UserList;

public class CreateUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxUserType;
	private JTextField textFieldUserName;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPassword;
	private JTextField textFieldLocation;
	private JTextField textFieldOrganization;
	private JLabel lblOrganization;
	private JLabel lblShowError;
	private JCheckBox  chckbxFirstAid;
	private JCheckBox  chckbxERO;
	private JCheckBox  chckbxRAS;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox<String> comboBoxDay;
	private JComboBox<String> comboBoxMonth;
	private JComboBox<String> comboBoxYear;
	private static UserList userList;
	private String gender;
	private JLabel lblNewLabel;
	static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/disapp";
	private static Event event;
	
	public CreateUser(UserList userList) {
		
		this.userList = userList;
		
		setModal(true);
		setBounds(100, 100, 600, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{90, 100, 100, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblIWantTo = new JLabel("Register as");
			GridBagConstraints gbc_lblIWantTo = new GridBagConstraints();
			gbc_lblIWantTo.weightx = 1.0;
			gbc_lblIWantTo.anchor = GridBagConstraints.EAST;
			gbc_lblIWantTo.insets = new Insets(5, 5, 5, 5);
			gbc_lblIWantTo.gridx = 0;
			gbc_lblIWantTo.gridy = 0;
			contentPanel.add(lblIWantTo, gbc_lblIWantTo);
		}
		{
			comboBoxUserType = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxUserType = new GridBagConstraints();
			gbc_comboBoxUserType.weightx = 1.0;
			gbc_comboBoxUserType.gridwidth = 3;
			gbc_comboBoxUserType.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxUserType.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxUserType.gridx = 1;
			gbc_comboBoxUserType.gridy = 0;
			contentPanel.add(comboBoxUserType, gbc_comboBoxUserType);
			comboBoxUserType.addItem("");
			comboBoxUserType.addItem("Citizen");
			comboBoxUserType.addItem("Journalist");
			comboBoxUserType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
			        organizationVisibility(cb);
				}
			});
		}
		{
			JLabel lblUserName = new JLabel("User name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.weightx = 1.0;
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(5, 5, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 1;
			contentPanel.add(lblUserName, gbc_lblFirstName);
		}
		{
			textFieldUserName = new JTextField();
			GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
			gbc_textFieldUserName.weightx = 1.0;
			gbc_textFieldUserName.gridwidth = 3;
			gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUserName.gridx = 1;
			gbc_textFieldUserName.gridy = 1;
			contentPanel.add(textFieldUserName, gbc_textFieldUserName);
			textFieldUserName.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.weightx = 1.0;
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(5, 5, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 2;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			textFieldFirstName = new JTextField();
			GridBagConstraints gbc_textFieldFirstName = new GridBagConstraints();
			gbc_textFieldFirstName.weightx = 1.0;
			gbc_textFieldFirstName.gridwidth = 3;
			gbc_textFieldFirstName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldFirstName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldFirstName.gridx = 1;
			gbc_textFieldFirstName.gridy = 2;
			contentPanel.add(textFieldFirstName, gbc_textFieldFirstName);
			textFieldFirstName.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last name");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.weightx = 1.0;
			gbc_lblLastName.anchor = GridBagConstraints.EAST;
			gbc_lblLastName.insets = new Insets(5, 5, 5, 5);
			gbc_lblLastName.gridx = 0;
			gbc_lblLastName.gridy = 3;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			textFieldLastName = new JTextField();
			GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
			gbc_textFieldLastName.weightx = 1.0;
			gbc_textFieldLastName.gridwidth = 3;
			gbc_textFieldLastName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLastName.gridx = 1;
			gbc_textFieldLastName.gridy = 3;
			contentPanel.add(textFieldLastName, gbc_textFieldLastName);
			textFieldLastName.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.weightx = 1.0;
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.insets = new Insets(5, 5, 5, 5);
			gbc_lblPassword.gridx = 0;
			gbc_lblPassword.gridy = 4;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			textFieldPassword = new JTextField();
			GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
			gbc_textFieldPassword.weightx = 1.0;
			gbc_textFieldPassword.gridwidth = 3;
			gbc_textFieldPassword.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPassword.gridx = 1;
			gbc_textFieldPassword.gridy = 4;
			contentPanel.add(textFieldPassword, gbc_textFieldPassword);
			textFieldPassword.setColumns(10);
		}
		{
			JLabel lblCapabilities = new JLabel("Capabilities");
			GridBagConstraints gbc_lblCapabilities = new GridBagConstraints();
			gbc_lblCapabilities.weightx = 1.0;
			gbc_lblCapabilities.anchor = GridBagConstraints.EAST;
			gbc_lblCapabilities.insets = new Insets(5, 5, 5, 5);
			gbc_lblCapabilities.gridx = 0;
			gbc_lblCapabilities.gridy = 5;
			contentPanel.add(lblCapabilities, gbc_lblCapabilities);
		}
		{
			chckbxFirstAid = new JCheckBox("First Aid Certificate");
			GridBagConstraints gbc_chckbxFirstAid = new GridBagConstraints();
			gbc_chckbxFirstAid.anchor = GridBagConstraints.WEST;
			gbc_chckbxFirstAid.weightx = 1.0;
			gbc_chckbxFirstAid.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxFirstAid.gridx = 1;
			gbc_chckbxFirstAid.gridy = 5;
			contentPanel.add(chckbxFirstAid, gbc_chckbxFirstAid);
		}
		{
			chckbxERO = new JCheckBox("Emergency Response Officer");
			GridBagConstraints gbc_chckbxEro = new GridBagConstraints();
			gbc_chckbxEro.anchor = GridBagConstraints.WEST;
			gbc_chckbxEro.weightx = 1.0;
			gbc_chckbxEro.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxEro.gridx = 2;
			gbc_chckbxEro.gridy = 5;
			contentPanel.add(chckbxERO, gbc_chckbxEro);
		}
		{
			chckbxRAS = new JCheckBox("Rope access specialist");
			GridBagConstraints gbc_chckbxFireFighter = new GridBagConstraints();
			gbc_chckbxFireFighter.anchor = GridBagConstraints.WEST;
			gbc_chckbxFireFighter.weightx = 1.0;
			gbc_chckbxFireFighter.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxFireFighter.gridx = 3;
			gbc_chckbxFireFighter.gridy = 5;
			contentPanel.add(chckbxRAS, gbc_chckbxFireFighter);
		}
		{
			JLabel lblGender = new JLabel("Gender");
			GridBagConstraints gbc_lblGender = new GridBagConstraints();
			gbc_lblGender.weightx = 1.0;
			gbc_lblGender.anchor = GridBagConstraints.EAST;
			gbc_lblGender.insets = new Insets(5, 5, 5, 5);
			gbc_lblGender.gridx = 0;
			gbc_lblGender.gridy = 6;
			contentPanel.add(lblGender, gbc_lblGender);
		}
		ButtonGroup genderGroup = new ButtonGroup();
		{
			rdbtnMale = new JRadioButton("Male");
			GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
			gbc_rdbtnMale.weightx = 1.0;
			gbc_rdbtnMale.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMale.gridx = 1;
			gbc_rdbtnMale.gridy = 6;
			genderGroup.add(rdbtnMale);
			contentPanel.add(rdbtnMale, gbc_rdbtnMale);
			rdbtnMale.setSelected(true);
		}
		{
			rdbtnFemale = new JRadioButton("Female");
			GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
			gbc_rdbtnFemale.weightx = 1.0;
			gbc_rdbtnFemale.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnFemale.gridx = 2;
			gbc_rdbtnFemale.gridy = 6;
			genderGroup.add(rdbtnFemale);
			contentPanel.add(rdbtnFemale, gbc_rdbtnFemale);
		}
	    {
			JLabel lblDateOfBirth = new JLabel("Date of birth");
			GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
			gbc_lblDateOfBirth.weightx = 1.0;
			gbc_lblDateOfBirth.anchor = GridBagConstraints.EAST;
			gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
			gbc_lblDateOfBirth.gridx = 0;
			gbc_lblDateOfBirth.gridy = 7;
			contentPanel.add(lblDateOfBirth, gbc_lblDateOfBirth);
		}
		{
			comboBoxDay = new JComboBox();
			comboBoxDay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JComboBox day = e.getSource()
				}
			});
			GridBagConstraints gbc_comboBoxDay = new GridBagConstraints();
			gbc_comboBoxDay.weightx = 1.0;
			gbc_comboBoxDay.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxDay.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxDay.gridx = 1;
			gbc_comboBoxDay.gridy = 7;
			contentPanel.add(comboBoxDay, gbc_comboBoxDay);
			comboBoxDay.addItem("day");
			for (int i = 1; i <= 31; i++) {
				comboBoxDay.addItem(String.format("%02d", i));	
			}
						
		}
		{
			comboBoxMonth = new JComboBox();
			GridBagConstraints gbc_comboBoxMonth = new GridBagConstraints();
			gbc_comboBoxMonth.weightx = 1.0;
			gbc_comboBoxMonth.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxMonth.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxMonth.gridx = 2;
			gbc_comboBoxMonth.gridy = 7;
			contentPanel.add(comboBoxMonth, gbc_comboBoxMonth);
			comboBoxMonth.addItem("month");
			for (int i = 1; i <= 12; i++) {
				comboBoxMonth.addItem(String.format("%02d", i));	
			}
		}
		{
			comboBoxYear = new JComboBox();
			GridBagConstraints gbc_comboBoxYear = new GridBagConstraints();
			gbc_comboBoxYear.weightx = 1.0;
			gbc_comboBoxYear.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxYear.gridx = 3;
			gbc_comboBoxYear.gridy = 7;
			contentPanel.add(comboBoxYear, gbc_comboBoxYear);
			comboBoxYear.addItem("year");
			for (int i = 2010; i >= 1900; i--) {
				comboBoxYear.addItem(Integer.toString(i));	
			}
		}
		{
			JLabel lblLocation = new JLabel("Location");
			GridBagConstraints gbc_lblLocation = new GridBagConstraints();
			gbc_lblLocation.weightx = 1.0;
			gbc_lblLocation.anchor = GridBagConstraints.EAST;
			gbc_lblLocation.insets = new Insets(5, 5, 5, 5);
			gbc_lblLocation.gridx = 0;
			gbc_lblLocation.gridy = 8;
			contentPanel.add(lblLocation, gbc_lblLocation);
		}
		{
			textFieldLocation = new JTextField();
			GridBagConstraints gbc_textFieldLocation = new GridBagConstraints();
			gbc_textFieldLocation.weightx = 1.0;
			gbc_textFieldLocation.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldLocation.gridwidth = 3;
			gbc_textFieldLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLocation.gridx = 1;
			gbc_textFieldLocation.gridy = 8;
			contentPanel.add(textFieldLocation, gbc_textFieldLocation);
			textFieldLocation.setColumns(10);
		}
		{
			lblOrganization = new JLabel("Organization");
			GridBagConstraints gbc_lblOrganization = new GridBagConstraints();
			gbc_lblOrganization.weightx = 1.0;
			gbc_lblOrganization.anchor = GridBagConstraints.EAST;
			gbc_lblOrganization.insets = new Insets(5, 5, 5, 5);
			gbc_lblOrganization.gridx = 0;
			gbc_lblOrganization.gridy = 9;
			contentPanel.add(lblOrganization, gbc_lblOrganization);
		}
		{
			textFieldOrganization = new JTextField();
			GridBagConstraints gbc_textFieldOrganization = new GridBagConstraints();
			gbc_textFieldOrganization.weightx = 1.0;
			gbc_textFieldOrganization.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldOrganization.gridwidth = 3;
			gbc_textFieldOrganization.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOrganization.gridx = 1;
			gbc_textFieldOrganization.gridy = 9;
			contentPanel.add(textFieldOrganization, gbc_textFieldOrganization);
			textFieldOrganization.setColumns(10);
		}
		{
			lblShowError = new JLabel("");
			GridBagConstraints gbc_lblShowError = new GridBagConstraints();
			gbc_lblShowError.gridwidth = 3;
			gbc_lblShowError.insets = new Insets(5, 5, 5, 5);
			gbc_lblShowError.gridx = 1;
			gbc_lblShowError.gridy = 10;
			contentPanel.add(lblShowError, gbc_lblShowError);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						handleOK(comboBoxUserType);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}	
		
		setVisible(true);
	}
	
	protected void handleOK(JComboBox cb) {
		if (textFieldUserName.getText().isEmpty() ||
			textFieldFirstName.getText().isEmpty() ||
			textFieldLastName.getText().isEmpty() ||
			textFieldPassword.getText().isEmpty() ||			
			textFieldLocation.getText().isEmpty()) {
				lblShowError.setText("Fill in all the fields");			
		} else if ((String)cb.getSelectedItem() == "Citizen") {
			String userName = textFieldUserName.getText();
			String firstName = textFieldFirstName.getText();
			String lastName = textFieldLastName.getText();
			String password = textFieldPassword.getText();			
			List<String> capabilities = new ArrayList<String>(); 		
			if (chckbxFirstAid.isSelected() == true) {
				capabilities.add("First Aid");
			}
			if (chckbxERO.isSelected() == true) {
				capabilities.add("ERO");
			}
			if (chckbxRAS.isSelected() == true) {
				capabilities.add("Rope access specialist");
			}
			
			if (rdbtnMale.isSelected() == true) {
				gender = "Male";
			}
			if (rdbtnFemale.isSelected() == true) {
				gender = "Female";
			}
			String dateOfBirth = convertDateOfBirth();
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			int thisYear = Integer.parseInt(dateFormat.format(currentDate));

			dateFormat = new SimpleDateFormat("MM");
			int thisMonth = Integer.parseInt(dateFormat.format(currentDate));

			dateFormat = new SimpleDateFormat("dd");
			int thisDay = Integer.parseInt(dateFormat.format(currentDate));
			String creationDate = thisYear + "-0" + thisMonth + "-" + thisDay;
			System.out.println(creationDate);
			String location = textFieldLocation.getText();
			Citizen citizen = new Citizen(userName, password, currentDate, capabilities, firstName, lastName, gender, dateOfBirth, location);
			citizen.setAge(convertDateOfBirth());
			userList.addUser(citizen);
			
			// Start the database section to insert new user
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
	            System.out.println("Coonection did not work");
	        }
			
			try	{
			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, username, pass);
			
			// create Statement for querying database
			statement = connection.createStatement();
			
			//perform insert
			String newInsert = String.format("INSERT INTO `disapp`.`userList` (`userName`, `password`, `creationDate`, `firstName`, `lastName`, `gender`, `dateOfBirth`, `age`, `location`,   `capabilities`, `organization`)"
					+          "VALUES                                        ('%s',         '%s',        '%s',              '%s',          '%s',         '%s',       '%s',            50,     '%s',           '%s',             '')", userName,   password,  creationDate, firstName,   lastName,   gender,   dateOfBirth,          location,     capabilities);
			System.out.println(creationDate);
			
			statement.executeUpdate(newInsert);
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			finally
			{ 
				try
				{
				statement.close();
				connection.close();
				} // end try
				catch (Exception exception)
				{
				exception.printStackTrace();
				} // end catch
			} // end finally
			
			// end database section
			dispose();
		} else if ((String)cb.getSelectedItem() == "Journalist") {
			String userName = textFieldUserName.getText();
			String firstName = textFieldFirstName.getText();
			String lastName = textFieldLastName.getText();
			String password = textFieldPassword.getText();			
			List<String> capabilities = new ArrayList<String>(); 		
			if (chckbxFirstAid.isSelected() == true) {
				capabilities.add("First Aid Certificate");
			}
			if (chckbxERO.isSelected() == true) {
				capabilities.add("Emergency Response Officer");
			}
			if (chckbxRAS.isSelected() == true) {
				capabilities.add("Rope access specialist");
			}
			
			if (rdbtnMale.isSelected() == true) {
				gender = "Male";
			}
			if (rdbtnFemale.isSelected() == true) {
				gender = "Female";
			}
			String dateOfBirth = convertDateOfBirth();
			Date currentDate = new Date();
			String location = textFieldLocation.getText();
			String organization = textFieldOrganization.getText();
			Journalist journalist = new Journalist(userName, password, currentDate, capabilities, firstName, lastName, gender, dateOfBirth, location, organization);
			journalist.setAge(convertDateOfBirth());
			userList.addUser(journalist);
			dispose();			
		}		
	}

	private String convertDateOfBirth() {
		String day = (String) comboBoxDay.getSelectedItem();
		String month = (String) comboBoxMonth.getSelectedItem();
		String year = (String) comboBoxYear.getSelectedItem();
		String DOB = day + "/" + month + "/" + year;		
		return DOB;
	}

	private void organizationVisibility(JComboBox cb) {
		if ((String)cb.getSelectedItem() == "Citizen"){
        	textFieldOrganization.setVisible(false);
        	lblOrganization.setText("");
        } else {
        	textFieldOrganization.setVisible(true);
        	lblOrganization.setText("Organization");
        	}
	}
}

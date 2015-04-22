package gui;
//TO DO:This need to be converted into a Jpanel so it can be used on the main frame.
//now that this is a JPanel, buttons ok and cancel do not work properly.

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import useraccount.Citizen;
import useraccount.Journalist;
import useraccount.UserList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestPanelCreateUser extends JPanel {
	
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxUserType;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPassword;
	private JTextField textFieldLocation;
	private JTextField textFieldOrganization;
	private JLabel lblOrganization;
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
	/**
	 * Create the panel.
	 */
	public TestPanelCreateUser(UserList userList) {
		setBounds(100, 100, 550, 320);
		setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 100, 100, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
			JLabel lblFirstName = new JLabel("First name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.weightx = 1.0;
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(5, 5, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 1;
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
			gbc_textFieldFirstName.gridy = 1;
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
			gbc_lblLastName.gridy = 2;
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
			gbc_textFieldLastName.gridy = 2;
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
			gbc_lblPassword.gridy = 3;
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
			gbc_textFieldPassword.gridy = 3;
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
			gbc_lblCapabilities.gridy = 4;
			contentPanel.add(lblCapabilities, gbc_lblCapabilities);
		}
		{
			chckbxFirstAid = new JCheckBox("First Aid Certificate");
			GridBagConstraints gbc_chckbxFirstAid = new GridBagConstraints();
			gbc_chckbxFirstAid.anchor = GridBagConstraints.WEST;
			gbc_chckbxFirstAid.weightx = 1.0;
			gbc_chckbxFirstAid.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxFirstAid.gridx = 1;
			gbc_chckbxFirstAid.gridy = 4;
			contentPanel.add(chckbxFirstAid, gbc_chckbxFirstAid);
		}
		{
			chckbxERO = new JCheckBox("Emergency Response Officer");
			GridBagConstraints gbc_chckbxEro = new GridBagConstraints();
			gbc_chckbxEro.anchor = GridBagConstraints.WEST;
			gbc_chckbxEro.weightx = 1.0;
			gbc_chckbxEro.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxEro.gridx = 2;
			gbc_chckbxEro.gridy = 4;
			contentPanel.add(chckbxERO, gbc_chckbxEro);
		}
		{
			chckbxRAS = new JCheckBox("Rope access specialist");
			GridBagConstraints gbc_chckbxFireFighter = new GridBagConstraints();
			gbc_chckbxFireFighter.anchor = GridBagConstraints.WEST;
			gbc_chckbxFireFighter.weightx = 1.0;
			gbc_chckbxFireFighter.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxFireFighter.gridx = 3;
			gbc_chckbxFireFighter.gridy = 4;
			contentPanel.add(chckbxRAS, gbc_chckbxFireFighter);
		}
		{
			JLabel lblGender = new JLabel("Gender");
			GridBagConstraints gbc_lblGender = new GridBagConstraints();
			gbc_lblGender.weightx = 1.0;
			gbc_lblGender.anchor = GridBagConstraints.EAST;
			gbc_lblGender.insets = new Insets(5, 5, 5, 5);
			gbc_lblGender.gridx = 0;
			gbc_lblGender.gridy = 5;
			contentPanel.add(lblGender, gbc_lblGender);
		}
		ButtonGroup genderGroup = new ButtonGroup();
		{
			rdbtnMale = new JRadioButton("Male");
			GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
			gbc_rdbtnMale.weightx = 1.0;
			gbc_rdbtnMale.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMale.gridx = 1;
			gbc_rdbtnMale.gridy = 5;
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
			gbc_rdbtnFemale.gridy = 5;
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
			gbc_lblDateOfBirth.gridy = 6;
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
			gbc_comboBoxDay.gridy = 6;
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
			gbc_comboBoxMonth.gridy = 6;
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
			gbc_comboBoxYear.gridy = 6;
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
			gbc_lblLocation.gridy = 7;
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
			gbc_textFieldLocation.gridy = 7;
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
			gbc_lblOrganization.gridy = 8;
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
			gbc_textFieldOrganization.gridy = 8;
			contentPanel.add(textFieldOrganization, gbc_textFieldOrganization);
			textFieldOrganization.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			add(buttonPane, BorderLayout.SOUTH);
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
						System.exit(0);
					}

					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}	
	}
	
	protected void handleOK(JComboBox cb) {
		if ((String)cb.getSelectedItem() == "Citizen") {
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
			String location = textFieldLocation.getText();
			UserList userList = new UserList();
			Citizen citizen = new Citizen(userList, password, currentDate, capabilities, firstName, lastName, gender, dateOfBirth, location);
			citizen.setAge(convertDateOfBirth());
			userList.addUser(citizen);
			System.exit(0);
			System.out.println(((Citizen) userList.listOfUsers.get(0)).getAge());
		} else if ((String)cb.getSelectedItem() == "Journalist") {
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
			UserList userList = new UserList();
			Journalist journalist = new Journalist(userList, password, currentDate, capabilities, firstName, lastName, gender, dateOfBirth, location, organization);
			journalist.setAge(convertDateOfBirth());
			userList.addUser(journalist);
			System.exit(0);
		} else {
			
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



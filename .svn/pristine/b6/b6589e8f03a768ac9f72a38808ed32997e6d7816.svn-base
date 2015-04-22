package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import useraccount.GovAgency;
import useraccount.UserList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class CreateGovAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textGovAgencyName;
	private JTextField textUserName;
	private JTextField textPassword;
	private JTextField textLocation;
	private UserList userList;
	private AccountSystem accountSystem;
	
	/**
	 * Create the dialog.
	 */
	public CreateGovAccount(UserList userList, AccountSystem accountSystem) {
		
		this.userList = userList;
		this.accountSystem = accountSystem;
		
		setModal(true);
		setBounds(100, 100, 450, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblGovernmentAgencyName = new JLabel("Government Agency name");
			GridBagConstraints gbc_lblGovernmentAgencyName = new GridBagConstraints();
			gbc_lblGovernmentAgencyName.anchor = GridBagConstraints.EAST;
			gbc_lblGovernmentAgencyName.insets = new Insets(5, 5, 5, 5);
			gbc_lblGovernmentAgencyName.gridx = 0;
			gbc_lblGovernmentAgencyName.gridy = 0;
			contentPanel.add(lblGovernmentAgencyName, gbc_lblGovernmentAgencyName);
		}
		{
			textGovAgencyName = new JTextField();
			GridBagConstraints gbc_textGovAgencyName = new GridBagConstraints();
			gbc_textGovAgencyName.insets = new Insets(5, 5, 5, 5);
			gbc_textGovAgencyName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textGovAgencyName.gridx = 1;
			gbc_textGovAgencyName.gridy = 0;
			contentPanel.add(textGovAgencyName, gbc_textGovAgencyName);
			textGovAgencyName.setColumns(10);
		}
		{
			JLabel lblUserName = new JLabel("User name");
			GridBagConstraints gbc_lblUserName = new GridBagConstraints();
			gbc_lblUserName.anchor = GridBagConstraints.EAST;
			gbc_lblUserName.insets = new Insets(5, 5, 5, 5);
			gbc_lblUserName.gridx = 0;
			gbc_lblUserName.gridy = 1;
			contentPanel.add(lblUserName, gbc_lblUserName);
		}
		{
			textUserName = new JTextField();
			GridBagConstraints gbc_textUserName = new GridBagConstraints();
			gbc_textUserName.insets = new Insets(5, 5, 5, 5);
			gbc_textUserName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textUserName.gridx = 1;
			gbc_textUserName.gridy = 1;
			contentPanel.add(textUserName, gbc_textUserName);
			textUserName.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.insets = new Insets(5, 5, 5, 5);
			gbc_lblPassword.gridx = 0;
			gbc_lblPassword.gridy = 2;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			textPassword = new JTextField();
			GridBagConstraints gbc_textPassword = new GridBagConstraints();
			gbc_textPassword.insets = new Insets(5, 5, 5, 5);
			gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_textPassword.gridx = 1;
			gbc_textPassword.gridy = 2;
			contentPanel.add(textPassword, gbc_textPassword);
			textPassword.setColumns(10);
		}
		{
			JLabel lblLocation = new JLabel("Location");
			GridBagConstraints gbc_lblLocation = new GridBagConstraints();
			gbc_lblLocation.anchor = GridBagConstraints.EAST;
			gbc_lblLocation.insets = new Insets(5, 5, 5, 5);
			gbc_lblLocation.gridx = 0;
			gbc_lblLocation.gridy = 3;
			contentPanel.add(lblLocation, gbc_lblLocation);
		}
		{
			textLocation = new JTextField();
			GridBagConstraints gbc_textLocation = new GridBagConstraints();
			gbc_textLocation.insets = new Insets(5, 5, 5, 5);
			gbc_textLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_textLocation.gridx = 1;
			gbc_textLocation.gridy = 3;
			contentPanel.add(textLocation, gbc_textLocation);
			textLocation.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleOKEvent();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}	
		setVisible(true);
	}
	
	protected void handleCancel() {
		dispose();
	}

	protected void handleOKEvent() {
		String govAgencyName = textGovAgencyName.getText();
		String userName = textUserName.getText();
		String password = textPassword.getText();
		String location = textLocation.getText();
		Date creationDate = new Date();
		GovAgency govAgency = new GovAgency(userName, password, creationDate, govAgencyName, location);
		userList.addUser(govAgency);
		accountSystem.refreshList(userList);
		dispose();
	}
}

package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import useraccount.Citizen;
import useraccount.UserList;

public class AccountSystemTester extends JFrame {

	private AccountSystem accountSystem;
	
	static List<String> capabilities = new ArrayList<String>();
	static UserList userList = new UserList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Citizen newUserOne = new Citizen("citizen1", "password", null, capabilities, "John",
				"Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newUserOne);
		Citizen newUserTwo = new Citizen("citizen2", "password", null, capabilities, "Sam",
				"Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen");
		userList.addUser(newUserTwo);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSystemTester frame = new AccountSystemTester();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println(userList.listOfUsers.size());
	}

	/**
	 * Create the frame.
	 */
	public AccountSystemTester() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		accountSystem = new AccountSystem(userList);
		setContentPane(accountSystem);
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import useraccount.Citizen;
import useraccount.GovAgency;
import useraccount.Journalist;
import useraccount.User;
import useraccount.UserList;

import java.awt.GridBagLayout;

public class MainFrame extends JFrame {

	static JPanel contentPane;
	public static UserList userList;
	public WindowCardLayoutInitial intPanel;
	public User loggedInUser;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setMinimumSize(frame.getMinimumSize());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		userList = new UserList();
		Citizen Admin = new Citizen("admin", "123456", null, null, "Ad", "Min", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(Admin);
		Citizen newCitizen = new Citizen("citizen", "password", null, null, "John", "Johnson", "male", "01/01/1970", "Hoogstraat 25, Wageningen");
		userList.addUser(newCitizen);
		Journalist newJournalist = new Journalist("journalist", "password", null, null, "Sam", "Smith", "male", "01/01/1980", "Hoogstraat 27, Wageningen", "BBC");
		userList.addUser(newJournalist);
		GovAgency govAgency = new GovAgency("Gov Agency", "mypassword", null, "Police", "Wageningen");
		userList.addUser(govAgency);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		intPanel = new WindowCardLayoutInitial(this);

		setBounds(100, 100, 655, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		add(contentPane);
		GridBagLayout gridBagLayout = (GridBagLayout) intPanel.getLayout();
		gridBagLayout.rowHeights = new int[] {0, 0, 0};

		contentPane.invalidate();
		contentPane.removeAll();

		contentPane.add(intPanel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void redraw() {
	
		if (loggedInUser == null){
			contentPane.removeAll();
			contentPane.add(intPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		} else if (!loggedInUser.getUserName().equals("admin") && loggedInUser.getClass().toString().equals("class useraccount.Citizen") || !loggedInUser.getUserName().equals("admin") && loggedInUser.getClass().toString().equals("class useraccount.Journalist")) {
			contentPane.invalidate();
			contentPane.removeAll();
			WindowCardLayoutUser userPanel = new WindowCardLayoutUser(this);
			contentPane.add(userPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		} else if (loggedInUser.getUserName().equals("admin")) {
			//contentPane.invalidate();
			contentPane.removeAll();
			WindowCardLayoutAdmin adminPanel = new WindowCardLayoutAdmin(this);
			contentPane.add(adminPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		} else if (loggedInUser.getClass().toString().equals("class useraccount.GovAgency")) {
			contentPane.invalidate();
			contentPane.removeAll();
			WindowCardLayoutGov govPanel = new WindowCardLayoutGov(this);
			contentPane.add(govPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
}

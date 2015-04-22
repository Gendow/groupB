package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WelcomeUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeUser frame = new WelcomeUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{34, 97, 101, 0, 0};
		gbl_contentPane.rowHeights = new int[]{68, 21, 67, 23, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogOut();
			}
		});
		
		JButton btnCheckEvents = new JButton("Check Events");
		btnCheckEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleGetEvents();
			}
		});
		
		JLabel lblWelcomeUser = new JLabel("Welcome User");
		lblWelcomeUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblWelcomeUser = new GridBagConstraints();
		gbc_lblWelcomeUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcomeUser.gridwidth = 2;
		gbc_lblWelcomeUser.gridx = 1;
		gbc_lblWelcomeUser.gridy = 1;
		contentPane.add(lblWelcomeUser, gbc_lblWelcomeUser);
		GridBagConstraints gbc_btnCheckEvents = new GridBagConstraints();
		gbc_btnCheckEvents.fill = GridBagConstraints.BOTH;
		gbc_btnCheckEvents.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckEvents.gridx = 1;
		gbc_btnCheckEvents.gridy = 3;
		contentPane.add(btnCheckEvents, gbc_btnCheckEvents);
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogOut.fill = GridBagConstraints.BOTH;
		gbc_btnLogOut.gridx = 2;
		gbc_btnLogOut.gridy = 3;
		contentPane.add(btnLogOut, gbc_btnLogOut);
	}

	/** go to the Log In screen;
	 * Currently, it creates a new window on top of the Main Menu window
	 */
	protected void handleLogOut() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu mainMenu = new MainMenu();
					mainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** go to the Events screen;
	 * Currently, it does not do anything
	 */
	protected void handleGetEvents() {
		// go to the events gui
	}
}

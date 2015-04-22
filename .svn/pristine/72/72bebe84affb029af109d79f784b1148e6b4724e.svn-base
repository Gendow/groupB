package gui;

import java.awt.BorderLayout;
import java.awt.Container; // evt weg - 2015-04-07
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	//private Container host; //evt weg - 2015-04-07

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
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
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogIn();
			}
		});
		
		JButton btnCheckEvents = new JButton("Check Events");
		btnCheckEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleGetEvents();
			}
		});
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblMainMenu = new GridBagConstraints();
		gbc_lblMainMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMainMenu.gridwidth = 2;
		gbc_lblMainMenu.gridx = 1;
		gbc_lblMainMenu.gridy = 1;
		contentPane.add(lblMainMenu, gbc_lblMainMenu);
		GridBagConstraints gbc_btnCheckEvents = new GridBagConstraints();
		gbc_btnCheckEvents.fill = GridBagConstraints.BOTH;
		gbc_btnCheckEvents.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckEvents.gridx = 1;
		gbc_btnCheckEvents.gridy = 3;
		contentPane.add(btnCheckEvents, gbc_btnCheckEvents);
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogIn.fill = GridBagConstraints.BOTH;
		gbc_btnLogIn.gridx = 2;
		gbc_btnLogIn.gridy = 3;
		contentPane.add(btnLogIn, gbc_btnLogIn);
	}

	/** go to the Log In screen;
	 * Currently, it creates a new window on top of the Main Menu window
	 */
	protected void handleLogIn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn logIn = new LogIn();
					logIn.setVisible(true);
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

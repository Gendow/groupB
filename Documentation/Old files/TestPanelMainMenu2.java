package gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Insets;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPanelMainMenu2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public TestPanelMainMenu2() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{51, 51, 51, 51, 146, 103, 51, 0};
		gridBagLayout.rowHeights = new int[]{21, 0, 156, 0, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMainMenu = new GridBagConstraints();
		gbc_lblMainMenu.gridwidth = 5;
		gbc_lblMainMenu.anchor = GridBagConstraints.NORTH;
		gbc_lblMainMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMainMenu.gridx = 1;
		gbc_lblMainMenu.gridy = 1;
		add(lblMainMenu, gbc_lblMainMenu);
		
		JButton btnCheckEvents = new JButton("Check Events");
		btnCheckEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleGetEvents();
			}

		});
		GridBagConstraints gbc_btnCheckEvents = new GridBagConstraints();
		gbc_btnCheckEvents.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckEvents.gridx = 1;
		gbc_btnCheckEvents.gridy = 3;
		add(btnCheckEvents, gbc_btnCheckEvents);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogIn();
			}
		});
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogIn.gridx = 5;
		gbc_btnLogIn.gridy = 3;
		add(btnLogIn, gbc_btnLogIn);

	}
	
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

	private void handleGetEvents() {
		// go to events gui
		
	}


}



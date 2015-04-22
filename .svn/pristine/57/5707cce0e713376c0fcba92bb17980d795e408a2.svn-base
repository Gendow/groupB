package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WindowCardLayoutGov extends JPanel implements LogOutButton {
	
	JFrame frame;
	CardLayout cardLayout;
	JPanel upperPanel;
	JPanel bottomPanel1;
	public int panelIndex;
	
	private MainFrame mainFrame;
	
	public WindowCardLayoutGov(final MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{72, 77, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setPreferredSize(new Dimension(600,600));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 2;
		gbc_tabbedPane.anchor = GridBagConstraints.EAST;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.VERTICAL;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		add(tabbedPane, gbc_tabbedPane);
		
		tabbedPane.addTab("Home", bottomPanel1);
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	    JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.invalidate();
		panel.removeAll();
		EventListPanel eventList = new EventListPanel();
		panel.add(eventList);
		panel.revalidate();
		panel.repaint();
	    tabbedPane.setComponentAt(0, panel);
	    
	    tabbedPane.addTab("Alert", bottomPanel1);
	    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	    
	    JButton btnLogOut = new JButton("Log Out");
	    btnLogOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		handleLogOut();
	    	}
	    });
	    GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
	    gbc_btnLogOut.insets = new Insets(0, 0, 0, 5);
	    gbc_btnLogOut.anchor = GridBagConstraints.WEST;
	    gbc_btnLogOut.gridx = 0;
	    gbc_btnLogOut.gridy = 1;
	    add(btnLogOut, gbc_btnLogOut);
	    
	    JButton btnCreateAlert = new JButton("CreateAlert");
	    btnCreateAlert.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		crateAlert();
	    	}


	    });
	    GridBagConstraints gbc_btnCreateAlert = new GridBagConstraints();
	    gbc_btnCreateAlert.anchor = GridBagConstraints.WEST;
	    gbc_btnCreateAlert.gridx = 1;
	    gbc_btnCreateAlert.gridy = 1;
	    add(btnCreateAlert, gbc_btnCreateAlert);
	}

	@Override
	public void handleLogOut() {
		mainFrame.loggedInUser = null;
		mainFrame.redraw();
	}   
	
	private void crateAlert() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GovermentAgencyInterface frame = new GovermentAgencyInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}


package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import useraccount.UserList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WindowCardLayoutInitial extends JPanel {
	
	JFrame frame;
	CardLayout cardLayout;
	JPanel upperPanel;
	JPanel bottomPanel1;
	JPanel bottomPanel2;
	private MainFrame mainFrame;
	
	public WindowCardLayoutInitial(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{77, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setPreferredSize(new Dimension(600,600));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
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
	    
	    tabbedPane.addTab("Map", bottomPanel2);
	    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	    
	    tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int panelIndex = 0;
				if (e.getSource() instanceof JTabbedPane){
					JTabbedPane pane = (JTabbedPane) e.getSource();
					panelIndex = pane.getSelectedIndex();
				}
			//creates the panels according to the tab selection
				
				if (panelIndex == 0) {
					bottomPanel1 = new JPanel();
					bottomPanel1.invalidate();
					bottomPanel1.removeAll();
					EventListPanel eventList = new EventListPanel();
					bottomPanel1.add(eventList);
					bottomPanel1.revalidate();
					bottomPanel1.repaint();
				    tabbedPane.setComponentAt(0, bottomPanel1);
				}
				if (panelIndex == 1) {
					MapPanel map = new MapPanel();
				    tabbedPane.setComponentAt(1, map);
					    
				}

	}  
	});
	    
	    
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn dialog = new LogIn(mainFrame.userList, mainFrame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.anchor = GridBagConstraints.WEST;
		gbc_btnLogIn.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogIn.gridx = 0;
		gbc_btnLogIn.gridy = 1;
		add(btnLogIn, gbc_btnLogIn);
	}        
}

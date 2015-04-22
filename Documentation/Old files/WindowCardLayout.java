package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import useraccount.UserList;

public class WindowCardLayout extends JPanel {

		//creation of elements
				JFrame frame;
				CardLayout cardLayout;
				JPanel upperPanel;
				JPanel bottomPanel1;
				JPanel bottomPanel2;
				JPanel bottomPanel3;
			
				// create as many elements as needed for the number of tabs contained.
				JTabbedPane tabbedPane;
				public int panelIndex;
				private AccountSystem accountSystem;
				static List<String> capabilities = new ArrayList<String>();
				
				static UserList userList = new UserList();
			/**
			 * Create the panel.
			 * @return 
			 */
	public  WindowCardLayout() {
				buildUpperPanel();
				buildWindow();
			}
			private void buildWindow() {
				
					frame= new JFrame();
			        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
			        frame.getContentPane().add(upperPanel);
			        frame.getPreferredSize();
			        frame.pack();
			        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        frame.setVisible(true);
			        frame.setResizable(true);	
			}
			
			private void buildUpperPanel() {
				
					upperPanel = new JPanel();
					
					final JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabPlacement(JTabbedPane.LEFT);
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
					tabbedPane.setPreferredSize(new Dimension(800,800));
					tabbedPane.setBorder(null);
					
					//upperPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
					upperPanel.add(tabbedPane);
					
					// creates the first tab (index 0) and loads the specific panel on it for the first time.
			        tabbedPane.addTab("Home", bottomPanel1);
			        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
			        bottomPanel1 = new JPanel();
					bottomPanel1.invalidate();
					bottomPanel1.removeAll();
					TestPanelMainMenu2 panelTest = new TestPanelMainMenu2();
					bottomPanel1.add(panelTest);
					bottomPanel1.revalidate();
					bottomPanel1.repaint();
					tabbedPane.setComponentAt(0, bottomPanel1);
			      
					// A)to add more tabs 
			        tabbedPane.addTab("AccountSystem", bottomPanel2);
			        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
			        // B)copy, paste and modify the code between brackets A and B. 
			        
			        tabbedPane.addTab("Profile", bottomPanel3);
			        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
			        upperPanel.getPreferredSize();
			        //adding change listener
			        tabbedPane.addChangeListener(new ChangeListener() {

						@Override
						public void stateChanged(ChangeEvent e) {
							if (e.getSource() instanceof JTabbedPane){
								JTabbedPane pane = (JTabbedPane) e.getSource();
								panelIndex = pane.getSelectedIndex();
							}
						//creates the panels according to the tab selection
							
							if (panelIndex == 0) {
								bottomPanel1 = new JPanel();
								bottomPanel1.invalidate();
								bottomPanel1.removeAll();
								TestPanelMainMenu2 panelTest = new TestPanelMainMenu2();
								bottomPanel1.add(panelTest);
								bottomPanel1.revalidate();
								bottomPanel1.repaint();
								tabbedPane.setComponentAt(0, bottomPanel1);
							}
							if (panelIndex == 1) {
								bottomPanel2 = new JPanel();
								bottomPanel2.invalidate();
								bottomPanel2.removeAll();
								accountSystem = new AccountSystem(userList);
								bottomPanel2.add(accountSystem);
								bottomPanel2.revalidate();
								bottomPanel2.repaint();
								tabbedPane.setComponentAt(1, bottomPanel2);
							}
							if (panelIndex == 2) {
								CreateUser dialog = new CreateUser(userList);
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setVisible(true);
								bottomPanel3 = new JPanel();
								bottomPanel3.invalidate();
								bottomPanel3.removeAll();
								//TestPanelCreateUser panelTest = new TestPanelCreateUser(userList);
								//bottomPanel3.add(panelTest);
								bottomPanel3.revalidate();
								bottomPanel3.repaint();
								
								tabbedPane.setComponentAt(2, bottomPanel3);
							}
				}  
				});
			               
			}	
}

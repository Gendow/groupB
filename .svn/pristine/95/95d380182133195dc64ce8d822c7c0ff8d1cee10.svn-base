package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WindowCardLayout1stTry extends JPanel {
	
	//creation of elements
		JFrame frame;
		CardLayout cardLayout;
		JPanel upperPanel;
		JPanel bottomPanel;
		JPanel bottomPanel1;
		JPanel bottomPanel2;
		JPanel bottomPanel3;
		// create as many elements as needed for the number of tabs contained.
		JTabbedPane tabbedPane;
		public int panelIndex;

			
		/**
		 * Create the panel.
		 */
		public WindowCardLayout1stTry() {
			buildUpperPanel();
			buildBottomPanel();
			buildWindow();
		}

		private void buildWindow() {
			frame= new JFrame();
	        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
	        frame.getContentPane().add(upperPanel);
	        frame.getContentPane().add(bottomPanel);
	        frame.getPreferredSize();
	        frame.pack();
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setMinimumSize(frame.getMinimumSize());
	        frame.setResizable(false);
	       
	        
	        
		}
		
		private void buildBottomPanel() {
			bottomPanel = new JPanel();
			//bottomPanel.setBorder(BorderFactory.createTitledBorder("Bottom Pannel"));	
			cardLayout=new CardLayout();
			cardLayout.setVgap(0);
			cardLayout.setHgap(0);
			bottomPanel.setLayout(cardLayout);
			//System.out.println(panelIndex);
			//creates the bottom panel for the first time
			
			bottomPanel.invalidate();
			bottomPanel.removeAll();
			TestPanelMainMenu2 panelTest = new TestPanelMainMenu2();
			bottomPanel.add(panelTest);
			bottomPanel.revalidate();
			bottomPanel.repaint();
			
		}

		private void buildUpperPanel() {
			upperPanel = new JPanel();
			
			
			JTabbedPane tabbedPane = new JTabbedPane();
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setPreferredSize(new Dimension(600,20));
			upperPanel.setSize(getPreferredSize());
			tabbedPane.setBorder(null);
			
			//upperPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
			upperPanel.add(tabbedPane);
			// A)to add more tabs 
	        tabbedPane.addTab("Home", bottomPanel1);
	        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	        // B)copy, paste and modify the code between brackets A and B. 
	        tabbedPane.addTab("Event", bottomPanel2);
	        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
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
					//System.out.println("Panel " + panelIndex);
					bottomPanel.invalidate();
					bottomPanel.removeAll();
					TestPanelMainMenu2 panelTest = new TestPanelMainMenu2();
					bottomPanel.add(panelTest);
					bottomPanel.revalidate();
					bottomPanel.repaint();
				}
				else if (panelIndex == 1) {
					//System.out.println("Panel " + panelIndex);
					bottomPanel.invalidate();
					bottomPanel.removeAll();
					TestPanelCreateUser panelTest1 = new TestPanelCreateUser(null);
					bottomPanel.add(panelTest1);
					bottomPanel.revalidate();
					bottomPanel.repaint();
				}
				
				else if (panelIndex == 2) {
					//System.out.println("Panel " + panelIndex);
					bottomPanel.invalidate();
					bottomPanel.removeAll();
					TestPanelLogIn panelTest2 = new TestPanelLogIn();
					bottomPanel.add(panelTest2);
					bottomPanel.revalidate();
					bottomPanel.repaint();
				// add here the code to show the recently added panel.
					
				}
				}  
				});
	        
		}}
				
			
		



package test;

import gui.MainFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import junit.framework.TestCase;

public class GuiTester extends TestCase {
	
	JPanel contentPane;
	JPanel showPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	public void MainFrame() {
		buildShowPanel();		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		JLabel label = new JLabel("Message");
		contentPane.invalidate();
		contentPane.removeAll();

		contentPane.add(showPanel);
		contentPane.revalidate();
		contentPane.repaint();   
	}

	private void buildShowPanel() {
		showPanel = new JPanel();
		showPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		showPanel.setLayout(new BorderLayout(0, 0));
		assertNotNull(contentPane);
	}	
}

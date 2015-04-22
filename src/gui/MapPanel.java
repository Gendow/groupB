package gui;

import javax.swing.JPanel;

import server.TestGetDataForEventsFromTable;

public class MapPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MapPanel() {
		
		JPanel panel = new JPanel();
		add(panel);
		
        final MapApplet applet = new MapApplet();
        applet.init();
        panel.add(applet);
        applet.revalidate();
        applet.repaint(); 
        try {
			applet.sendGet();
			//MapApplet.sendGet();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}

package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import event.Event;
import event.EventList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.EventListFromDataBase;

public class EventListPanel extends JPanel {
	private JTextField textSearchTerm;
	private int listIndex;
	private JTable table;
	public static String selectedEvent;
	DefaultTableModel myTable = new DefaultTableModel() {
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	/**
	 * Create the panel.
	 */
	public EventListPanel() {
		
		EventListFromDataBase db = new EventListFromDataBase();
	    db.testEventListFromDB();
//		//Creating initial input events 
//		Event event1 = new Event("Roof blown away", "Wageningen", "A part of a house roof has been ripped apart and blown away by the Wind", "Damage");
//		Event event2 = new Event("roundabout flooded", "Wageningen", "Roundabout near the campus is flooded, cars and bike get stuck",	"Flooding");
//		Event event3 = new Event("Wounded cow", "Ede", "Cow seems to be hit by an object and looks several injured but still standing on feet and eating grass like a professional", "Medical");
//		Event event4 = new Event("UFO in city center", "Arnhem", "Aliens putting buildings on fire with a laser beam", "Fire");
//		
//		//Adding events to the EventList
//		EventList.listOfEvents.add(event1);
//		EventList.listOfEvents.add(event2);
//		EventList.listOfEvents.add(event3);
//		EventList.listOfEvents.add(event4);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 246, 0, 0, 0, 206};

		setLayout(gridBagLayout);
		
		JLabel lblSearchLocation = new JLabel("Search location");
		GridBagConstraints gbc_lblSearchLocation = new GridBagConstraints();
		gbc_lblSearchLocation.insets = new Insets(5, 5, 5, 5);
		gbc_lblSearchLocation.anchor = GridBagConstraints.EAST;
		gbc_lblSearchLocation.gridx = 1;
		gbc_lblSearchLocation.gridy = 0;
		add(lblSearchLocation, gbc_lblSearchLocation);
		
		textSearchTerm = new JTextField();
		textSearchTerm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					textSearchTerm.setText("");
				}
				
			}
		});
		GridBagConstraints gbc_textSearchTerm = new GridBagConstraints();
		gbc_textSearchTerm.insets = new Insets(5, 5, 5, 5);
		gbc_textSearchTerm.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSearchTerm.gridx = 2;
		gbc_textSearchTerm.gridy = 0;
		add(textSearchTerm, gbc_textSearchTerm);
		textSearchTerm.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGo();
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(5, 5, 5, 5);
		gbc_btnGo.gridx = 3;
		gbc_btnGo.gridy = 0;
		add(btnGo, gbc_btnGo);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleReset();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(5, 5, 5, 5);
		gbc_btnReset.gridx = 4;
		gbc_btnReset.gridy = 0;
		add(btnReset, gbc_btnReset);
		
		JButton btnReportEvent = new JButton("Report event");
		btnReportEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleReportEvent();
			}
		});
		GridBagConstraints gbc_btnReportEvent = new GridBagConstraints();
		gbc_btnReportEvent.insets = new Insets(5, 5, 5, 5);
		gbc_btnReportEvent.gridx = 5;
		gbc_btnReportEvent.gridy = 0;
		add(btnReportEvent, gbc_btnReportEvent);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.weighty = 2.0;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					table = (JTable) evt.getSource();
					int row = table.getSelectedRow();
					selectedEvent = (String) table.getValueAt(row, 0);
					ViewEvent viewEvent = new ViewEvent();
					handleReset();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(myTable);
		myTable.setColumnIdentifiers(COLUMN_NAMES);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(0).setMaxWidth(20);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(10000);	
		generateTableContent();
	}
	
	/**
	 * Returns events which match the user input search term
	 */
	private void handleGo() {
		if (getTextSearchTerm().equals("")) {
			textSearchTerm.setText("Please provide a city name");
		} else {
			myTable.setRowCount(0);
			for (int i = 0; i < EventListFromDataBase.eventList.listOfEvents.size(); i++) {
				if (getTextSearchTerm().equalsIgnoreCase(EventListFromDataBase.eventList.listOfEvents.get(i).getLocation())) {
					Object [] o = new Object[5];
					o[0] = EventListFromDataBase.eventList.listOfEvents.get(i).getEventID();
					o[1] = EventListFromDataBase.eventList.listOfEvents.get(i).getTitle();
					o[2] = EventListFromDataBase.eventList.listOfEvents.get(i).getLocation();
					o[3] = EventListFromDataBase.eventList.listOfEvents.get(i).getCategory();
					o[4] = EventListFromDataBase.eventList.listOfEvents.get(i).getStatus(); 
					
					myTable.addRow(o);
				}
			}
			if (myTable.getRowCount() == 0) {
				textSearchTerm.setText("No events reported for " + getTextSearchTerm());
			}
		}
			
	}
	
	/**
	 * Resets the list and shows all events in the EventList
	 */
	private void handleReset() {
		textSearchTerm.setText("");
		generateTableContent();
	}

	private void generateTableContent() {
		myTable.setRowCount(0);
		for (int i = 0; i < EventListFromDataBase.eventList.listOfEvents.size(); i++) {
			Object [] o = new Object[5];
			o[0] = EventListFromDataBase.eventList.listOfEvents.get(i).getEventID();
			o[1] = EventListFromDataBase.eventList.listOfEvents.get(i).getTitle();
			o[2] = EventListFromDataBase.eventList.listOfEvents.get(i).getLocation();
			o[3] = EventListFromDataBase.eventList.listOfEvents.get(i).getCategory();
			o[4] = EventListFromDataBase.eventList.listOfEvents.get(i).getStatus(); 

			myTable.addRow(o);
		}
	}
	
	/**
	 * Initiates ReportEventDialog, gets input information from it once submitted by user and adds Event to EventList
	 */
	private void handleReportEvent() {
		ReportEventDialog reportEvent = new ReportEventDialog();

		if (reportEvent.isReportSelected()) {
			String strTitle = reportEvent.getTitle();
			Object strCategory = reportEvent.getCategory();
			String strLocation = reportEvent.getWhereabouts();
			String strDescription = reportEvent.getDescription();

			Event event = new Event(strTitle, strLocation, strDescription, strCategory.toString());

			EventListFromDataBase.eventList.listOfEvents.add(event);

			handleReset();
			
		}
		handleReset();
	}
	
	/**
	 * Retrieves user input from search text field
	 */	
	public String getTextSearchTerm() {
			return textSearchTerm.getText();
	}
	
	private static final String[] COLUMN_NAMES = {
        "ID",
		"Title",
        "Location",
        "Category",
        "Status"
    };
	
	
}

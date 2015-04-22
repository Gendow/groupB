package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import event.Event;
import event.EventList;
import gui.ReportEventDialog;
import gui.ViewEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class testEventListGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSearchTerm;
	private EventList currentResultList;
	private Collection Event;
	public List<Event> eventList = new ArrayList<Event>();
	DefaultListModel previewList = new DefaultListModel();
	DefaultTableModel myTable = new DefaultTableModel() {
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private int listIndex;
	public static String selectedEvent;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testEventListGUI frame = new testEventListGUI();
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
	public testEventListGUI() {

		// EventList eventList = new EventList();

		Event event1 = new Event("Rony", "Wageningen", "Hotboy112", "Fire");
		Event event2 = new Event("Andronikos", "Wageningen", "Hotb23oy112",	"Tsunami");
		Event event3 = new Event("Najib", "Ede", "eating duck", "Earthquake");
		Event event4 = new Event("Isa", "Armhem","eating Chicken, but is a vegetarian", "Storm");
		
		EventList.listOfEvents.add(event1);
		EventList.listOfEvents.add(event2);
		EventList.listOfEvents.add(event3);
		EventList.listOfEvents.add(event4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 315, 57, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblSearchLocation = new JLabel("Search location");
		GridBagConstraints gbc_lblSearchLocation = new GridBagConstraints();
		gbc_lblSearchLocation.insets = new Insets(0, 0, 0, 5);
		gbc_lblSearchLocation.anchor = GridBagConstraints.EAST;
		gbc_lblSearchLocation.gridx = 1;
		gbc_lblSearchLocation.gridy = 0;
		panel.add(lblSearchLocation, gbc_lblSearchLocation);

		textSearchTerm = new JTextField();
		textSearchTerm.setToolTipText("");
		GridBagConstraints gbc_textSearchTerm = new GridBagConstraints();
		gbc_textSearchTerm.insets = new Insets(0, 0, 0, 5);
		gbc_textSearchTerm.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSearchTerm.gridx = 2;
		gbc_textSearchTerm.gridy = 0;
		panel.add(textSearchTerm, gbc_textSearchTerm);
		textSearchTerm.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleGo();
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 0, 5);
		gbc_btnGo.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGo.gridx = 3;
		gbc_btnGo.gridy = 0;
		panel.add(btnGo, gbc_btnGo);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleReset();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 4;
		gbc_btnReset.gridy = 0;
		panel.add(btnReset, gbc_btnReset);

		JButton btnReportEvent = new JButton("Report event");
		btnReportEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleReportEvent();
			}
		});
		GridBagConstraints gbc_btnReportEvent = new GridBagConstraints();
		gbc_btnReportEvent.insets = new Insets(0, 0, 0, 5);
		gbc_btnReportEvent.gridx = 5;
		gbc_btnReportEvent.gridy = 0;
		panel.add(btnReportEvent, gbc_btnReportEvent);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					table = (JTable) evt.getSource();
					int row = table.getSelectedRow();
					selectedEvent = (String) table.getValueAt(row, 0);
					System.out.println(selectedEvent);
					ViewEvent viewEvent = new ViewEvent();
					handleReset();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(myTable);
		myTable.setColumnIdentifiers(COLUMN_NAMES);	
	}

	protected void handleReportEvent() {
		ReportEventDialog reportEvent = new ReportEventDialog();

		if (reportEvent.isReportSelected()) {
			String strTitle = reportEvent.getTitle();
			Object strCategory = reportEvent.getCategory();
			String strLocation = reportEvent.getWhereabouts();
			String strDescription = reportEvent.getDescription();

			Event event = new Event(strTitle, strLocation, strDescription,
					strCategory.toString());

			EventList.listOfEvents.add(event);

			handleReset();		
		}
		handleReset();
	}

	protected void handleReset() {
		myTable.setRowCount(0);
		for (int i = 0; i < EventList.listOfEvents.size(); i++) {
			Object [] o = new Object[4];
			o[0] = EventList.listOfEvents.get(i).getTitle();
			o[1] = EventList.listOfEvents.get(i).getLocation();
			o[2] = EventList.listOfEvents.get(i).getDescription();
			o[3] = EventList.listOfEvents.get(i).getCategory();
			
			System.out.println(o[0]);
			
			myTable.addRow(o);
		}
	}

	protected void handleGo() {
		if (getTextSearchTerm().equals("")) {
			textSearchTerm.setText("Please provide a city name");
		} else {
			myTable.setRowCount(0);
			for (int i = 0; i < EventList.listOfEvents.size(); i++) {
				if (getTextSearchTerm().equalsIgnoreCase(EventList.listOfEvents.get(i).getLocation())) {
					Object [] o = new Object[4];
					o[0] = EventList.listOfEvents.get(i).getTitle();
					o[1] = EventList.listOfEvents.get(i).getLocation();
					o[2] = EventList.listOfEvents.get(i).getDescription();
					o[3] = EventList.listOfEvents.get(i).getCategory();
					
					myTable.addRow(o);
				}
			}
		}
		
		if (myTable.getRowCount()== 0) {
			textSearchTerm.setText("Please press the reset button");
			return;
		}

		if (myTable.getRowCount() == 0) {
			textSearchTerm.setText("No events reported for " + getTextSearchTerm());
		}
	}

	public String getTextSearchTerm() {
		return textSearchTerm.getText();
	}
	
	protected static final String[] COLUMN_NAMES = {
        "Title",
        "Location",
        "Description",
        "Category"
    };
	
	
}

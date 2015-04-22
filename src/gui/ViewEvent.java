package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import event.Event;
import event.EventList;

public class ViewEvent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTitle;
	private JTextField textDate;
	private JTextField textLocation;
	private JTextField textCategory;
	private JTextField textCreator;
	private JTextField textHelpers;
	private JTextArea  textDescription;
	private boolean reportSelected;
	private JButton btnSave;
	private int x;
	private JTextField textAddHelper;
	private JTextField textAddDescription;
	private boolean descriptionIsVisible;
	private boolean helperIsVisible;
	private boolean user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewEvent dialog = new ViewEvent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewEvent() {
		setModal(true);
		
		user = true;
		Event testevent = new Event("Rony", "Wageningen", "Hotboy112", "Fire");	
		
		setBounds(100, 100, 600, 728);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 69, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblTitle = new JLabel("Title");
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.anchor = GridBagConstraints.WEST;
			gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
			gbc_lblTitle.gridx = 1;
			gbc_lblTitle.gridy = 1;
			contentPanel.add(lblTitle, gbc_lblTitle);
		}
		{
			textTitle = new JTextField();
			GridBagConstraints gbc_textTitle = new GridBagConstraints();
			gbc_textTitle.insets = new Insets(5, 5, 5, 0);
			gbc_textTitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textTitle.gridx = 2;
			gbc_textTitle.gridy = 1;
			contentPanel.add(textTitle, gbc_textTitle);
			textTitle.setColumns(10);
			textTitle.setEditable(false);
		}
		{
			JLabel lblDate = new JLabel("Date");
			GridBagConstraints gbc_lblDate = new GridBagConstraints();
			gbc_lblDate.anchor = GridBagConstraints.WEST;
			gbc_lblDate.insets = new Insets(5, 5, 5, 5);
			gbc_lblDate.gridx = 1;
			gbc_lblDate.gridy = 2;
			contentPanel.add(lblDate, gbc_lblDate);
		}
		{
			textDate = new JTextField();
			GridBagConstraints gbc_textDate = new GridBagConstraints();
			gbc_textDate.insets = new Insets(5, 5, 5, 0);
			gbc_textDate.fill = GridBagConstraints.HORIZONTAL;
			gbc_textDate.gridx = 2;
			gbc_textDate.gridy = 2;
			contentPanel.add(textDate, gbc_textDate);
			textDate.setColumns(10);
			textDate.setEditable(false);
		}
		{
			JLabel lblLocation = new JLabel("Location");
			GridBagConstraints gbc_lblLocation = new GridBagConstraints();
			gbc_lblLocation.anchor = GridBagConstraints.WEST;
			gbc_lblLocation.insets = new Insets(5, 5, 5, 5);
			gbc_lblLocation.gridx = 1;
			gbc_lblLocation.gridy = 3;
			contentPanel.add(lblLocation, gbc_lblLocation);
		}
		{
			textLocation = new JTextField();
			GridBagConstraints gbc_textLocation = new GridBagConstraints();
			gbc_textLocation.insets = new Insets(5, 5, 5, 0);
			gbc_textLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_textLocation.gridx = 2;
			gbc_textLocation.gridy = 3;
			contentPanel.add(textLocation, gbc_textLocation);
			textLocation.setColumns(10);
			textLocation.setEditable(false);
		}
		{
			JLabel lblCategory = new JLabel("Category");
			GridBagConstraints gbc_lblCategory = new GridBagConstraints();
			gbc_lblCategory.anchor = GridBagConstraints.WEST;
			gbc_lblCategory.insets = new Insets(5, 5, 5, 5);
			gbc_lblCategory.gridx = 1;
			gbc_lblCategory.gridy = 4;
			contentPanel.add(lblCategory, gbc_lblCategory);
		}
		{
			textCategory = new JTextField();
			GridBagConstraints gbc_textCategory = new GridBagConstraints();
			gbc_textCategory.insets = new Insets(5, 5, 5, 0);
			gbc_textCategory.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCategory.gridx = 2;
			gbc_textCategory.gridy = 4;
			contentPanel.add(textCategory, gbc_textCategory);
			textCategory.setColumns(10);
			textCategory.setEditable(false);
		}
		{
			JLabel lblDescription = new JLabel("Description");
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblDescription.insets = new Insets(5, 5, 5, 5);
			gbc_lblDescription.gridx = 1;
			gbc_lblDescription.gridy = 5;
			contentPanel.add(lblDescription, gbc_lblDescription);
		}
		{
			textDescription = new JTextArea();
			GridBagConstraints gbc_textDescription = new GridBagConstraints();
			gbc_textDescription.insets = new Insets(5, 5, 5, 0);
			gbc_textDescription.fill = GridBagConstraints.BOTH;
			gbc_textDescription.gridx = 2;
			gbc_textDescription.gridy = 5;
			contentPanel.add(textDescription, gbc_textDescription);
			textDescription.setEditable(false);
			textDescription.setLineWrap(true);
		}
		{
			JLabel lblCreator = new JLabel("Creator");
			GridBagConstraints gbc_lblCreator = new GridBagConstraints();
			gbc_lblCreator.anchor = GridBagConstraints.WEST;
			gbc_lblCreator.insets = new Insets(5, 5, 5, 5);
			gbc_lblCreator.gridx = 1;
			gbc_lblCreator.gridy = 6;
			contentPanel.add(lblCreator, gbc_lblCreator);
		}
		{
			textCreator = new JTextField();
			GridBagConstraints gbc_textCreator = new GridBagConstraints();
			gbc_textCreator.insets = new Insets(5, 5, 5, 0);
			gbc_textCreator.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCreator.gridx = 2;
			gbc_textCreator.gridy = 6;
			contentPanel.add(textCreator, gbc_textCreator);
			textCreator.setColumns(10);
			textCreator.setEditable(false);
		}
		{
			JLabel lblHelpers = new JLabel("Helpers");
			GridBagConstraints gbc_lblHelpers = new GridBagConstraints();
			gbc_lblHelpers.anchor = GridBagConstraints.WEST;
			gbc_lblHelpers.insets = new Insets(5, 5, 5, 5);
			gbc_lblHelpers.gridx = 1;
			gbc_lblHelpers.gridy = 7;
			contentPanel.add(lblHelpers, gbc_lblHelpers);
		}
		{
			textHelpers = new JTextField();
			GridBagConstraints gbc_textHelpers = new GridBagConstraints();
			gbc_textHelpers.insets = new Insets(5, 5, 5, 0);
			gbc_textHelpers.fill = GridBagConstraints.HORIZONTAL;
			gbc_textHelpers.gridx = 2;
			gbc_textHelpers.gridy = 7;
			contentPanel.add(textHelpers, gbc_textHelpers);
			textHelpers.setColumns(10);
			textHelpers.setEditable(false);
		}
		{
			textAddDescription = new JTextField();
			GridBagConstraints gbc_textAddDescription = new GridBagConstraints();
			gbc_textAddDescription.insets = new Insets(5, 5, 5, 0);
			gbc_textAddDescription.fill = GridBagConstraints.HORIZONTAL;
			gbc_textAddDescription.gridx = 2;
			gbc_textAddDescription.gridy = 8;
			contentPanel.add(textAddDescription, gbc_textAddDescription);
			textAddDescription.setColumns(10);
			textAddDescription.setVisible(false);
		}
		{
			textAddHelper = new JTextField("");
			GridBagConstraints gbc_textAddHelper = new GridBagConstraints();
			gbc_textAddHelper.insets = new Insets(5, 5, 0, 0);
			gbc_textAddHelper.fill = GridBagConstraints.HORIZONTAL;
			gbc_textAddHelper.gridx = 2;
			gbc_textAddHelper.gridy = 9;
			contentPanel.add(textAddHelper, gbc_textAddHelper);
			textAddHelper.setColumns(10);
			textAddHelper.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{12, 49, 61, 0, 0, 0, 0, 0, 0, 0};
			gbl_buttonPane.rowHeights = new int[]{23, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				{
					JButton AddInfoButton = new JButton("Update");
					if (user == false) {
						AddInfoButton.setVisible(false);
					}
					AddInfoButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							handleAddInfo();
						}
					});
					AddInfoButton.setActionCommand("OK");
					GridBagConstraints gbc_AddInfoButton = new GridBagConstraints();
					gbc_AddInfoButton.anchor = GridBagConstraints.NORTHWEST;
					gbc_AddInfoButton.insets = new Insets(5, 5, 0, 5);
					gbc_AddInfoButton.gridx = 1;
					gbc_AddInfoButton.gridy = 0;
					buttonPane.add(AddInfoButton, gbc_AddInfoButton);
					getRootPane().setDefaultButton(AddInfoButton);
				}
				{
					JButton btnAddHelper = new JButton("Add helper");
					if (user == false) {
						btnAddHelper.setVisible(false);
					}
					btnAddHelper.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							handleAddHelper();
						}
					});
					GridBagConstraints gbc_btnAddHelper = new GridBagConstraints();
					gbc_btnAddHelper.insets = new Insets(5, 5, 0, 5);
					gbc_btnAddHelper.gridx = 2;
					gbc_btnAddHelper.gridy = 0;
					buttonPane.add(btnAddHelper, gbc_btnAddHelper);
				}
				{
					JButton btnDeleteEvent = new JButton("Delete");
					if (user == false) {
						btnDeleteEvent.setVisible(false);
					}
					btnDeleteEvent.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							handleDeleteEvent();
						}
					});
					GridBagConstraints gbc_btnDeleteEvent = new GridBagConstraints();
					gbc_btnDeleteEvent.insets = new Insets(5, 5, 5, 5);
					gbc_btnDeleteEvent.gridx = 3;
					gbc_btnDeleteEvent.gridy = 0;
					buttonPane.add(btnDeleteEvent, gbc_btnDeleteEvent);
				}
			}
			JButton CloseButton = new JButton("Close");
			CloseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					handleClose();
				}
			});
			{
				btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleSave();
					}
				});
				GridBagConstraints gbc_btnSave = new GridBagConstraints();
				gbc_btnSave.insets = new Insets(5, 5, 5, 5);
				gbc_btnSave.gridx = 4;
				gbc_btnSave.gridy = 0;
				buttonPane.add(btnSave, gbc_btnSave);
				btnSave.setVisible(false);
				
			}
			{
				JButton btnReportEventOver = new JButton("Report event over");
				btnReportEventOver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleReportEventOver();
					}
				});
				GridBagConstraints gbc_btnReportEventOver = new GridBagConstraints();
				gbc_btnReportEventOver.insets = new Insets(5, 5, 5, 5);
				gbc_btnReportEventOver.gridx = 6;
				gbc_btnReportEventOver.gridy = 0;
				buttonPane.add(btnReportEventOver, gbc_btnReportEventOver);
			}
			CloseButton.setActionCommand("Cancel");
			GridBagConstraints gbc_CloseButton = new GridBagConstraints();
			gbc_CloseButton.insets = new Insets(5, 5, 0, 5);
			gbc_CloseButton.anchor = GridBagConstraints.NORTHWEST;
			gbc_CloseButton.gridx = 7;
			gbc_CloseButton.gridy = 0;
			buttonPane.add(CloseButton, gbc_CloseButton);
		}
		
		for (int i = 0; i < EventList.listOfEvents.size(); i++) {
			if (EventListPanel.selectedEvent.equals(EventList.listOfEvents.get(i).getEventID())) {
				x = i;
				
				textTitle.setText(EventList.listOfEvents.get(i).getTitle());
				textDate.setText(EventList.listOfEvents.get(i).getTimeStamp());
				textLocation.setText(EventList.listOfEvents.get(i).getLocation());
				textDescription.setText(EventList.listOfEvents.get(i).getDescription());
				textCreator.setText(EventList.listOfEvents.get(i).getCreator());
				textCategory.setText(EventList.listOfEvents.get(i).getCategory());
				textHelpers.setText(EventList.listOfEvents.get(i).getHelper());
			}
			
		}
		setVisible(true);	
	}

	protected void handleReportEventOver() {
		EventList.listOfEvents.get(x).setStatus("Completed");
		handleClose();
	}

	private void handleAddInfo() {
		textAddDescription.setVisible(true);
		descriptionIsVisible = true;
		btnSave.setVisible(true);
		
	}

	private void handleSave() {
		
		if (descriptionIsVisible == true ) {
			if (!textAddDescription.getText().equals("")) {
				String info = textAddDescription.getText();
				EventList.listOfEvents.get(x).addDescription(info);
			}
			descriptionIsVisible = false;
			textAddDescription.setText("");
			textDescription.setText(EventList.listOfEvents.get(x).getDescription());
			textAddDescription.setVisible(false);
		}
		
		if (helperIsVisible == true) {
			if (!textAddHelper.getText().equals("")) {
				String helper = textAddHelper.getText();
				EventList.listOfEvents.get(x).addHelper(helper);
			}
			textAddHelper.setText("");
			textHelpers.setText(EventList.listOfEvents.get(x).getHelper());
			helperIsVisible = false;
			textAddHelper.setVisible(false);
		}
		btnSave.setVisible(false);
	}

	private void handleAddHelper() {
		textAddHelper.setVisible(true);
		helperIsVisible = true;
		btnSave.setVisible(true);
	}

	private void handleDeleteEvent() {
		for (int i = 0; i < EventList.listOfEvents.size(); i++) {
			if (EventListPanel.selectedEvent.equals(EventList.listOfEvents.get(i).getEventID())) {
				EventList.deleteEvent(EventList.listOfEvents.get(i));
			}
		}
		setVisible(false);
	}
	
	private void handleClose() {
		reportSelected = false;
		dispose();
	}
	
	public boolean isReportSelected() {
		return reportSelected;
	}
	
	public String getHelper() {
		return textHelpers.getText();
	}
	
}

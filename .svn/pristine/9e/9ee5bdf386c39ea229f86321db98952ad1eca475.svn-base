package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportEventDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTitle;
	private JTextField textLocation;
	private JTextArea textDescription;
	private boolean reportSelected;
	final JComboBox<String> comboBoxCategory = new JComboBox<String>();

	/**
	 * Create the dialog.
	 */
	public ReportEventDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblReportEvent = new JLabel("Report Event");
			lblReportEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			JLabel lblReportEvent_1 = new JLabel("Report Event");
			lblReportEvent_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblReportEvent_1 = new GridBagConstraints();
			gbc_lblReportEvent_1.gridwidth = 3;
			gbc_lblReportEvent_1.insets = new Insets(5, 5, 5, 5);
			gbc_lblReportEvent_1.gridx = 0;
			gbc_lblReportEvent_1.gridy = 0;
			contentPanel.add(lblReportEvent_1, gbc_lblReportEvent_1);
		}
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
		}
		{
			JLabel lblCategory = new JLabel("Category");
			GridBagConstraints gbc_lblCategory = new GridBagConstraints();
			gbc_lblCategory.anchor = GridBagConstraints.WEST;
			gbc_lblCategory.insets = new Insets(5, 5, 5, 5);
			gbc_lblCategory.gridx = 1;
			gbc_lblCategory.gridy = 2;
			contentPanel.add(lblCategory, gbc_lblCategory);
		}
		GridBagConstraints gbc_lblReportEvent = new GridBagConstraints();
		gbc_lblReportEvent.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblReportEvent.ipady = 1;
		gbc_lblReportEvent.ipadx = 1;
		gbc_lblReportEvent.gridwidth = 2;
		gbc_lblReportEvent.insets = new Insets(5, 5, 5, 5);
		gbc_lblReportEvent.gridx = 2;
		gbc_lblReportEvent.gridy = 2;
		comboBoxCategory.addItem("Fire");
		comboBoxCategory.addItem("Infrastructure");
		comboBoxCategory.addItem("Medical");
		comboBoxCategory.addItem("Damage");
		comboBoxCategory.addItem("Flooding");
		contentPanel.add(comboBoxCategory, gbc_lblReportEvent);
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
		}
		{
			JLabel lblDescription = new JLabel("Description");
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.anchor = GridBagConstraints.WEST;
			gbc_lblDescription.insets = new Insets(5, 5, 0, 5);
			gbc_lblDescription.gridx = 1;
			gbc_lblDescription.gridy = 5;
			contentPanel.add(lblDescription, gbc_lblDescription);
		}
		{
			textDescription = new JTextArea();
			GridBagConstraints gbc_textDescription_1 = new GridBagConstraints();
			gbc_textDescription_1.fill = GridBagConstraints.BOTH;
			gbc_textDescription_1.gridx = 2;
			gbc_textDescription_1.gridy = 5;
			contentPanel.add(textDescription, gbc_textDescription_1);
			textDescription.setLineWrap(true);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnReport = new JButton("Report");
				btnReport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleReportEvent();
					}
				});
				btnReport.setActionCommand("OK");
				buttonPane.add(btnReport);
				getRootPane().setDefaultButton(btnReport);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancel();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		setVisible(true);
	}
	
	protected void handleCancel() {
		reportSelected = false;
		setVisible(false);
	}

	protected void handleReportEvent() {
		reportSelected = true;
		setVisible(false);
	}
	
	public boolean isReportSelected() {
		return reportSelected;
	}
	
	public String getTitle() {
		return textTitle.getText();
	}
	
	public String getDescription() {
		return textDescription.getText();
	}
	
	public String getWhereabouts() {
		return textLocation.getText();
	}
	
	public Object getCategory() {
		return comboBoxCategory.getSelectedItem();
	}
}

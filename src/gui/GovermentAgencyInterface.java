package gui;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import event.GovAgencyAlert;

public class GovermentAgencyInterface extends JDialog {

	private JPanel contentPane;
	private JTextField textLatitude;
	private JTextField textLongitude;
	private JTextField textRadius;
	private GovAgencyAlert alert;
	private JTextArea textDescription;
	
/*
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GovermentAgencyInterface frame = new GovermentAgencyInterface();
				frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
	*/
	
	

	public GovermentAgencyInterface() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{88, 487, 487, 487, 487, 487, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 36, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGovermentAgenciesInterface = new JLabel("Goverment Agencies Interface");
		lblGovermentAgenciesInterface.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGovermentAgenciesInterface.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblGovermentAgenciesInterface = new GridBagConstraints();
		gbc_lblGovermentAgenciesInterface.gridwidth = 4;
		gbc_lblGovermentAgenciesInterface.anchor = GridBagConstraints.NORTH;
		gbc_lblGovermentAgenciesInterface.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGovermentAgenciesInterface.insets = new Insets(0, 0, 5, 5);
		gbc_lblGovermentAgenciesInterface.gridx = 1;
		gbc_lblGovermentAgenciesInterface.gridy = 0;
		contentPane.add(lblGovermentAgenciesInterface, gbc_lblGovermentAgenciesInterface);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		contentPane.add(lblDescription, gbc_lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		final JTextArea textDescription = new JTextArea();
		scrollPane.setViewportView(textDescription);
		
		JLabel lblCoordinates = new JLabel("Coordinates");
		GridBagConstraints gbc_lblCoordinates = new GridBagConstraints();
		gbc_lblCoordinates.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordinates.gridx = 0;
		gbc_lblCoordinates.gridy = 2;
		contentPane.add(lblCoordinates, gbc_lblCoordinates);
		
		JLabel lblLatitude = new JLabel("Latitude");
		GridBagConstraints gbc_lblLatitude = new GridBagConstraints();
		gbc_lblLatitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblLatitude.gridx = 1;
		gbc_lblLatitude.gridy = 2;
		contentPane.add(lblLatitude, gbc_lblLatitude);
		
		textLatitude = new JTextField();
		GridBagConstraints gbc_textLatitude = new GridBagConstraints();
		gbc_textLatitude.insets = new Insets(0, 0, 5, 5);
		gbc_textLatitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLatitude.gridx = 2;
		gbc_textLatitude.gridy = 2;
		contentPane.add(textLatitude, gbc_textLatitude);
		textLatitude.setColumns(10);
		
		JLabel lblLongitude = new JLabel("Longitude");
		GridBagConstraints gbc_lblLongitude = new GridBagConstraints();
		gbc_lblLongitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongitude.gridx = 3;
		gbc_lblLongitude.gridy = 2;
		contentPane.add(lblLongitude, gbc_lblLongitude);
		
		textLongitude = new JTextField();
		GridBagConstraints gbc_textLongitude = new GridBagConstraints();
		gbc_textLongitude.insets = new Insets(0, 0, 5, 5);
		gbc_textLongitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLongitude.gridx = 4;
		gbc_textLongitude.gridy = 2;
		contentPane.add(textLongitude, gbc_textLongitude);
		textLongitude.setColumns(10);
		
		JLabel lblDecimals = new JLabel("decimals");
		GridBagConstraints gbc_lblDecimals = new GridBagConstraints();
		gbc_lblDecimals.anchor = GridBagConstraints.WEST;
		gbc_lblDecimals.insets = new Insets(0, 0, 5, 0);
		gbc_lblDecimals.gridx = 5;
		gbc_lblDecimals.gridy = 2;
		contentPane.add(lblDecimals, gbc_lblDecimals);
		
		JLabel lblRadius = new JLabel("Radius");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 3;
		contentPane.add(lblRadius, gbc_lblRadius);
		
		textRadius = new JTextField();
		GridBagConstraints gbc_textRadius = new GridBagConstraints();
		gbc_textRadius.insets = new Insets(0, 0, 0, 5);
		gbc_textRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRadius.gridx = 1;
		gbc_textRadius.gridy = 3;
		contentPane.add(textRadius, gbc_textRadius);
		textRadius.setColumns(10);
		
		JLabel lblM = new JLabel("m");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.anchor = GridBagConstraints.EAST;
		gbc_lblM.insets = new Insets(0, 0, 0, 5);
		gbc_lblM.gridx = 2;
		gbc_lblM.gridy = 3;
		contentPane.add(lblM, gbc_lblM);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal latitude = new BigDecimal(textLatitude.getText());
				BigDecimal longitude = new BigDecimal(textLongitude.getText());
				int radius = Integer.parseInt(textRadius.getText());
				GovAgencyAlert alert = new GovAgencyAlert(textDescription.getText(), latitude, longitude, radius);
				dispose();			
			}
		});
		GridBagConstraints gbc_btnReport = new GridBagConstraints();
		gbc_btnReport.anchor = GridBagConstraints.SOUTH;
		gbc_btnReport.gridx = 5;
		gbc_btnReport.gridy = 3;
		contentPane.add(btnReport, gbc_btnReport);
	}
}

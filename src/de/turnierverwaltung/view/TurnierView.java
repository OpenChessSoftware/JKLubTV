package de.turnierverwaltung.view;
//JKlubTV - Ein Programm zum verwalten von Schach Turnieren
//Copyright (C) 2015  Martin Schmuck m_schmuck@gmx.net
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import de.turnierverwaltung.model.Turnier;

public class TurnierView extends JPanel {
	public class DateLabelFormatter extends AbstractFormatter {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String datePattern = "dd.MM.yyy";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(
				datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel hauptPanel;
	private JTextField turnierNameTextField;
	private JDatePickerImpl startDatumTextField;
	private JDatePickerImpl endDatumeTextField;
	private JTextField gruppenAnzahlTextField;
	private Turnier turnier;
	private JButton okButton;
	// private JButton cancelButton;
	private String turnierName;
	private String startDatum;
	private String endDatum;
	private int gruppenAnzahl;

	private Properties property;

	/**
	 * Create the dialog.
	 */
	public TurnierView() {
		property = new Properties();
		property.put("text.today", "Heute");
		property.put("text.month", "Monat");
		property.put("text.year", "Jahr");
		gruppenAnzahl = 0;
		int windowWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int windowHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(0, 0, windowWidth, windowHeight);
		;
		setLayout(new FlowLayout());
		setBackground(new Color(249, 222, 112));
		hauptPanel = new JPanel();
		hauptPanel.setLayout(new BoxLayout(hauptPanel, BoxLayout.PAGE_AXIS));
		hauptPanel.setBackground(new Color(249, 222, 112));
		hauptPanel.setVisible(true);
		add(hauptPanel);
		{

			JPanel panel1 = new JPanel();
			panel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panel1.setBackground(new Color(249, 222, 112));
			hauptPanel.add(panel1);
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			{
				JLabel lblTurniername = new JLabel("Turniername");
				panel1.add(lblTurniername);
			}
			{
				turnierNameTextField = new JTextField();
				panel1.add(turnierNameTextField);
				turnierNameTextField.setColumns(10);
			}
		}
		{
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(249, 222, 112));
			hauptPanel.add(panel2);
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
			{
				JLabel label = new JLabel("Start Datum");
				panel2.add(label);
			}
			{
				startDatumTextField = new JDatePickerImpl(new JDatePanelImpl(
						new UtilDateModel(), property),
						new DateLabelFormatter());
				panel2.add(startDatumTextField);
			}
		}
		{
			JPanel panel3 = new JPanel();
			panel3.setBackground(new Color(249, 222, 112));
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
			hauptPanel.add(panel3);

			JLabel lblEndDatum = new JLabel("End Datum");
			panel3.add(lblEndDatum);

			endDatumeTextField = new JDatePickerImpl(new JDatePanelImpl(
					new UtilDateModel(), property), new DateLabelFormatter());
			panel3.add(endDatumeTextField);
		}
		{
			JPanel panel4 = new JPanel();
			panel4.setBackground(new Color(249, 222, 112));
			panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
			hauptPanel.add(panel4);

			JLabel lblAnzahlGruppen = new JLabel("Anzahl Gruppen");
			panel4.add(lblAnzahlGruppen);

			gruppenAnzahlTextField = new JTextField();

			gruppenAnzahlTextField.setColumns(10);
			panel4.add(gruppenAnzahlTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(249, 222, 112));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			hauptPanel.add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);

			}
			String help = "Gruppenanzahl: mindestens 1 bis maximal 15.";
			JPanel helpPanel = new JPanel();
			JTextArea helpText = new JTextArea();
			helpText.setText(help);
			helpText.setEditable(false);
			helpPanel.add(helpText);
			hauptPanel.add(helpPanel);

		}

	}

	public String getEndDatum() {
		return endDatum;
	}

	public String getEndDatumTextField() {
		return endDatumeTextField.getJFormattedTextField().getText();
	}

	public int getGruppenAnzahl() {
		gruppenAnzahl = new Integer(gruppenAnzahlTextField.getText());
		return gruppenAnzahl;
	}

	public JTextField getGruppenAnzahlTextField() {
		return gruppenAnzahlTextField;
	}

	public JPanel getHauptPanel() {
		return hauptPanel;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public String getStartDatum() {
		return startDatum;
	}

	public String getStartDatumTextField() {
		return startDatumTextField.getJFormattedTextField().getText();
	}

	public Turnier getTurnier() {
		return turnier;
	}

	public String getTurnierName() {
		return turnierName;
	}

	public JTextField getTurnierNameTextField() {
		return turnierNameTextField;
	}

	public void setEndDatum(String endDatum) {
		this.endDatum = endDatum;
	}

	public void setEndDatumeTextField(JDatePickerImpl endDatumeTextField) {
		this.endDatumeTextField = endDatumeTextField;
	}

	public void setGruppenAnzahl(int gruppenAnzahl) {
		this.gruppenAnzahl = gruppenAnzahl;
	}

	public void setGruppenAnzahlTextField(JTextField gruppenAnzahlTextField) {
		this.gruppenAnzahlTextField = gruppenAnzahlTextField;
	}

	public void setHauptPanel(JPanel hauptPanel) {
		this.hauptPanel = hauptPanel;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void setStartDatum(String startDatum) {
		this.startDatum = startDatum;
	}

	public void setStartDatumTextField(JDatePickerImpl startDatumTextField) {
		this.startDatumTextField = startDatumTextField;
	}

	public void setTurnier(Turnier turnier) {
		this.turnier = turnier;
	}

	public void setTurnierName(String turnierName) {
		this.turnierName = turnierName;
	}

	public void setTurnierNameTextField(JTextField turnierNameTextField) {
		this.turnierNameTextField = turnierNameTextField;
	}

}
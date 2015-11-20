package de.turnierverwaltung.view;
import java.awt.BorderLayout;
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
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import de.turnierverwaltung.model.SimpleTerminTabelle;
import de.turnierverwaltung.model.TurnierKonstanten;

public class SimpleTerminTabelleView extends JPanel {
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
	private JButton okButton;
	private JButton saveButton;
	private JButton htmlButton;
	private JTable table;
	private JComboBox<String> comboBox;
	private SimpleTerminTabelle simpleTerminTabelle;
	private Properties property;

	public SimpleTerminTabelleView(SimpleTerminTabelle simpleTerminTabelle) {

		this.simpleTerminTabelle = simpleTerminTabelle;
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		table = new JTable(this.simpleTerminTabelle);
		Font fnt = new Font("Arial", Font.PLAIN, 16);
		table.setFont(fnt);
		comboBox = new JComboBox<String>();
		comboBox.addItem(" ");
		comboBox.addItem("0 - 1");
		comboBox.addItem(TurnierKonstanten.PARTIE_REMIS);
		comboBox.addItem("1 - 0");
		comboBox.addItem("- / +");
		comboBox.addItem("+ / -");

		property = new Properties();
		property.put("text.today", "Heute");
		property.put("text.month", "Monat");
		property.put("text.year", "Jahr");

		setColumnWidth();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(20);
		JScrollPane sPane = new JScrollPane();
		sPane.setViewportView(table);
//		JPanel haupt = new JPanel();
//		haupt.setLayout(new BorderLayout());
		JPanel tabelPanel = new JPanel();
//		tabelPanel.setLayout(new BoxLayout(tabelPanel, BoxLayout.PAGE_AXIS));
		tabelPanel.setLayout(new BorderLayout());
		tabelPanel.add(sPane,BorderLayout.CENTER);
		JPanel hinweis = new JPanel();
		hinweis.add(new JLabel(
				"Geben Sie die Ergebnisse direkt in die Zellen ein "
						+ "und klicken Sie dann auf \"Aktualisieren\"."));
		tabelPanel.add(hinweis,BorderLayout.SOUTH);
//		haupt.add(tabelPanel);
		add(tabelPanel,BorderLayout.CENTER);

		setBackground(new Color(249, 222, 112));

		this.setVisible(true);

	}

	@SuppressWarnings("unused")
	private int[] dateStringToInt(String datum) {
		int[] dateInt = new int[3];

		int index = 0;
		for (String zahlenWerte : datum.split("\\.")) {

			dateInt[index] = Integer.parseInt(zahlenWerte);

			index++;

		}
		dateInt[1] = dateInt[1] - 1;
		return dateInt;

	}

	public JButton getHtmlButton() {
		return htmlButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JTable getTable() {
		return table;
	}

	private void setColumnWidth() {

		int columnCount = table.getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			TableColumn c = table.getColumnModel().getColumn(i);
			if (i == 3) {
				c.setCellEditor(new DefaultCellEditor(comboBox));
			}
			

		}

	}

	public void setHtmlButton(JButton htmlButton) {
		this.htmlButton = htmlButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
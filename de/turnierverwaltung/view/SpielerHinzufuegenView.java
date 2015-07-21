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
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SpielerHinzufuegenView extends JDialog {
	/**
		 * 
		 */
	private static final long serialVersionUID = -5642277833139693453L;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldName;
	private JTextField textFieldKuerzel;
	private JTextField textFieldDwz;
	private JPanel buttonPane;
	private JPanel centerPane;
	private JPanel contentPanel;

	// private JButton addSpielerButton;

	public SpielerHinzufuegenView() {
		this.okButton = new JButton("Speichern");
		this.cancelButton = new JButton("Fertig");

		// this.addSpielerButton = new JButton("Spieler hinzuf�gen");
		setTitle("Spieler hinzufügen");
		this.setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// int windowWidth = TurnierKonstanten.WINDOW_WIDTH - 50;
		// int windowHeight = TurnierKonstanten.WINDOW_HEIGHT - 50;
		// setBounds(TurnierKonstanten.WINDOW_WIDTH / 3,
		// TurnierKonstanten.WINDOW_HEIGHT / 3, windowWidth, windowHeight);
		setLocationRelativeTo(null);

		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(249, 222, 112));

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());
		buttonPane.setBackground(new Color(249, 222, 112));
		// buttonPane.add(addSpielerButton);
		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
		spielerPanel();

	}

	public void closeWindow() {
		this.dispose();
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JTextField getTextFieldDwz() {
		return textFieldDwz;
	}

	public JTextField getTextFieldKuerzel() {
		return textFieldKuerzel;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void setTextFieldDwz(JTextField textFieldDwz) {
		this.textFieldDwz = textFieldDwz;
	}

	public void setTextFieldKuerzel(JTextField textFieldKuerzel) {
		this.textFieldKuerzel = textFieldKuerzel;
	}

	public void setTextFieldName(JTextField name) {
		this.textFieldName = name;
	}

	public void spielerPanel() {
		centerPane = new JPanel();
		this.textFieldName = new JTextField(15);
		this.textFieldKuerzel = new JTextField(15);
		this.textFieldDwz = new JTextField(15);
		centerPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPane.setBackground(new Color(249, 222, 112));
		centerPane.add(new JLabel("Name: "));
		centerPane.add(textFieldName);

		centerPane.add(new JLabel("Kürzel: "));
		centerPane.add(textFieldKuerzel);

		centerPane.add(new JLabel("DWZ: "));
		centerPane.add(textFieldDwz);
		contentPanel.add(centerPane);
		contentPanel.add(buttonPane);
		add(contentPanel);
		contentPanel.updateUI();
		setEnabled(true);
		setVisible(true);
		pack();

	}
}

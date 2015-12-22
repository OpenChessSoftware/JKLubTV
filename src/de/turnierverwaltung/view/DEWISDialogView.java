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

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class DEWISDialogView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JPanel dsbPanel;
	private JTextField vereinsSuche;
	private JButton vereinsSucheButton;
	private JButton okButton;
	private JButton cancelButton;
	private JButton updateButton;
	private JPanel buttonPanel;
	private URI dwzdbURI;
	private JButton dwzdbButton;

	/**
	 * Create the dialog.
	 * 
	 * @throws URISyntaxException
	 */
	public DEWISDialogView() throws URISyntaxException {
		this.setAlwaysOnTop(true);
		setTitle("DSB Spielerliste");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		dwzdbURI = new URI("http://www.schachbund.de/verein.html");

		dwzdbButton = new JButton();
		dwzdbButton.setText("<HTML><FONT color=\"#000099\"><U>Vereinssuche (ZPS Nummer)</U></FONT></HTML>");
		// buttonDatePicker.setHorizontalAlignment(SwingConstants.LEFT);
		// buttonDatePicker.setBorderPainted(false);
		dwzdbButton.setOpaque(false);
		// buttonDatePicker.setBackground(Color.WHITE);
		dwzdbButton.setToolTipText(dwzdbURI.toString());
		dwzdbButton.addActionListener(new OpenUrlAction());
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		vereinsSuche = new JTextField(25);
		JPanel suchePanel = new JPanel();
		suchePanel.setLayout(new BoxLayout(suchePanel, BoxLayout.PAGE_AXIS));
		JPanel zeilenPanel = new JPanel();
		zeilenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		zeilenPanel.add(dwzdbButton);
		suchePanel.add(zeilenPanel);
		zeilenPanel = new JPanel();
		zeilenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel vereinsSucheLabel = new JLabel("ZPS Nummer des Vereins: ");
		vereinsSucheButton = new JButton("Suche");
		zeilenPanel.add(vereinsSucheLabel);
		suchePanel.add(zeilenPanel);
		zeilenPanel = new JPanel();
		zeilenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		zeilenPanel.add(vereinsSuche);
		suchePanel.add(zeilenPanel);
		zeilenPanel = new JPanel();
		zeilenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		zeilenPanel.add(vereinsSucheButton);
		suchePanel.add(zeilenPanel);

		contentPanel.add(suchePanel, BorderLayout.NORTH);
		dsbPanel = new JPanel();
		updateButton = new JButton("Update DWZ");
		okButton = new JButton("Einfügen");
		cancelButton = new JButton("Abbrechen");
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(updateButton);

		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
//		buttonPanel.setVisible(false);
		contentPanel.add(dsbPanel, BorderLayout.CENTER);
		contentPanel.add(buttonPanel, BorderLayout.SOUTH);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setEnabled(true);
		setVisible(true);
		pack();
	}

	class OpenUrlAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == dwzdbButton) {
				open(dwzdbURI);
			}

		}

	}

	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				/* TODO: error handling */ }
		} else {
			/* TODO: error handling */ }
	}

	public void closeWindow() {
		this.dispose();
	}

	public JPanel getDsbPanel() {
		return dsbPanel;

	}

	public void setDsbPanel(JPanel dsbPanel) {
		contentPanel.remove(this.dsbPanel);
		this.dsbPanel = dsbPanel;
		contentPanel.add(dsbPanel, BorderLayout.CENTER);
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getVereinsSucheButton() {
		return vereinsSucheButton;
	}

	public void setVereinsSucheButton(JButton vereinsSucheButton) {
		this.vereinsSucheButton = vereinsSucheButton;
	}

	public JTextField getVereinsSuche() {
		return vereinsSuche;
	}

	public void setVereinsSuche(JTextField vereinsSuche) {
		this.vereinsSuche = vereinsSuche;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

}

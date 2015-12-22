package de.turnierverwaltung.controller;
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

import java.awt.Toolkit;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import de.turnierverwaltung.view.InfoView;
import de.turnierverwaltung.view.InfoHomeScreenView;
import de.turnierverwaltung.view.InfoLizenzenView;

public class InfoController {
	private MainControl mainControl;
	private InfoView infoView;
	// private JButton lizenzButton;
	private JTabbedPane lizenzenPane;
	private InfoLizenzenView infoTexteView;
	private InfoHomeScreenView infoHelpView;
	private ImageIcon infoIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/emblem-notice.png")));
	private ImageIcon lizenzenIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/emblem-paragraph.png")));
	/**
	 * @param mainControl
	 */
	public InfoController(MainControl mainControl) {
		this.mainControl = mainControl;
		infoView = new InfoView();
		infoHelpView = new InfoHomeScreenView();
		lizenzenPane = new JTabbedPane();
		infoTexteView = new InfoLizenzenView();
		try {
			lizenzenPane.addTab("Information",infoIcon, infoHelpView.getLizenzText());

			lizenzenPane.addTab("Lizenzen",lizenzenIcon, infoTexteView.getLizenzText());
			infoView.setLizenzenPane(lizenzenPane);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		makeInfoPanel();

	}

	/**
	 * 
	 */
	public void makeInfoPanel() {
		JTabbedPane hauptPanel = this.mainControl.getHauptPanel();
		// hauptPanel.removeAll();
		// this.mainControl.getNaviController().makeNaviPanel();

		hauptPanel.addTab("Info", infoIcon, infoView);
		hauptPanel.updateUI();
		EigenschaftenControl eigenschaftenControl = new EigenschaftenControl(mainControl);
		mainControl.setEigenschaftenControl(eigenschaftenControl);
		eigenschaftenControl.makeeigenschaftenPanel();
	}

}

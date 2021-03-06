package de.turnierverwaltung;

//   JKlubTV - Ein Programm zum verwalten von Schach Turnieren
//    Copyright (C) 2015  Martin Schmuck m_schmuck@gmx.net
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

import java.awt.EventQueue;
//import java.awt.Font;

import javax.swing.UIManager;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertGreen;

import de.turnierverwaltung.control.MainControl;

/**
 * 
 * @author mars
 *
 */
public class Turnierverwaltung {

	public Turnierverwaltung() {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			private MainControl mainControl;

			@Override
			public void run() {
				PlasticLookAndFeel.setPlasticTheme(new DesertGreen());
				PlasticLookAndFeel.setTabStyle(PlasticLookAndFeel.TAB_STYLE_METAL_VALUE);
				System.setProperty("Windows.controlFont", "Segoe UI-plain-15");
				System.setProperty("Plastic.controlFont", "Segoe UI-plain-15");
				try {
					UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
				} catch (Exception e) {
				}
				try {
					setMainControl(new MainControl());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@SuppressWarnings("unused")
			public MainControl getMainControl() {
				return mainControl;
			}

			public void setMainControl(MainControl mainControl) {
				this.mainControl = mainControl;
			}
		});
	}

}

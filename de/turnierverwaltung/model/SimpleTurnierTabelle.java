package de.turnierverwaltung.model;
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
import javax.swing.table.DefaultTableModel;

public class SimpleTurnierTabelle extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int zeile;
	private int spalte;
	private TurnierTabelle turnierTabelle;
	private String tabellenMatrix[][];
	private Object[] rowData;

	public SimpleTurnierTabelle(TurnierTabelle turnierTabelle) {
		super();
		this.turnierTabelle = turnierTabelle;

		this.zeile = this.turnierTabelle.getZeile();
		this.spalte = this.turnierTabelle.getSpalte();
		rowData = new Object[this.spalte];
		tabellenMatrix = this.turnierTabelle.getTabellenMatrix();
		initModelData();
	}

	public int getSpalte() {
		return spalte;
	}

	public int getZeile() {
		return zeile;
	}

	private void initModelData() {

		for (int i = 0; i < spalte; i++) {
			String replacedStr = tabellenMatrix[i][0].replaceAll("<br />", "");
			this.addColumn(replacedStr);
		}

		for (int j = 1; j < zeile; j++) {
			for (int i = 0; i < spalte; i++) {
				rowData[i] = tabellenMatrix[i][j];
			}
			this.addRow(rowData);
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		int spielery = rowIndex;
		int spielerx = columnIndex - 4;
		boolean icE = true;
		if (columnIndex < 4) {
			icE = false;
		}
		if (columnIndex > spalte - 4) {
			icE = false;
		}
		if (spielery == spielerx) {
			icE = false;
		}
		return icE;
	}

	public void setSpalte(int spalte) {
		this.spalte = spalte;
	}

	public void setZeile(int zeile) {
		this.zeile = zeile;
	}
}
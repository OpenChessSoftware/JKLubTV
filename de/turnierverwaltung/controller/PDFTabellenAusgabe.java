package de.turnierverwaltung.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFTabellenAusgabe {

	
	


	/**
	 * Creates a PDF with information about the movies
	 * 
	 * @param filename
	 *            the name of the PDF file that will be created.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createTurnierPdf(String titel, String absolutePath, String[][] tabellenMatrix) {
		// step 1
		Document document = new Document();
		// step 2
		try {
			PdfWriter.getInstance(document, new FileOutputStream(absolutePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 3
		document.open();
		// step 4
		try {
			document.add(new Paragraph(titel));
			document.add(new Paragraph(" "));
			document.add(createTurnierTabelle(tabellenMatrix));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 5
		document.close();
	}

	public void createTerminPdf(String titel ,String absolutePath, String[][] tabellenMatrix) {
		// step 1
		Document document = new Document();
		// step 2
		try {
			PdfWriter.getInstance(document, new FileOutputStream(absolutePath));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 3
		document.open();
		// step 4
		try {
			document.add(new Paragraph(titel));
			document.add(new Paragraph(" "));
			document.add(createTerminTabelle(tabellenMatrix));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 5
		document.close();
	}

	public static PdfPTable createTurnierTabelle(String[][] stringTable) throws DocumentException {
		int spalten = stringTable[0].length;
		int zeilen = stringTable.length;
		for (int i = 0; i < zeilen; i++) {
			String replacedStr = stringTable[i][0].replaceAll("<br />", "");
			stringTable[i][0] = replacedStr;
		}

		PdfPTable table = new PdfPTable(zeilen - 1);
		float[] fl = new float[zeilen - 1];
		fl[0] = 5;
		fl[1] = 2;
		fl[2] = 2;
		for (int i = 0; i < zeilen; i++) {
			if (i > 2 && i < zeilen - 3) {
				fl[i ] = 1;
			}
			if (i >= zeilen - 3) {
				fl[i - 1] = 2;
			}
		}
		Font font = new Font(FontFamily.HELVETICA, 8);

		for (int x = 0; x < spalten; x++) {

			for (int y = 0; y < zeilen; y++) {
				if (y != 1) {
					Phrase ph = new Phrase(stringTable[y][x]);
					ph.setFont(font);
					PdfPCell cell = new PdfPCell(ph);

					table.addCell(cell);
				}
			}

		}
		table.setWidths(fl);

		return table;

	}

	public static PdfPTable createTerminTabelle(String[][] stringTable) throws DocumentException {
		int spalten = stringTable[0].length;
		int zeilen = stringTable.length;
		for (int i = 0; i < zeilen; i++) {
			String replacedStr = stringTable[i][0].replaceAll("<br />", "");
			stringTable[i][0] = replacedStr;
		}

		PdfPTable table = new PdfPTable(zeilen - 1);

		Font font = new Font(FontFamily.HELVETICA, 8);

		for (int x = 0; x < spalten; x++) {

			for (int y = 0; y < zeilen; y++) {
				if (y != 1) {
					Phrase ph = new Phrase(stringTable[y][x]);
					ph.setFont(font);
					PdfPCell cell = new PdfPCell(ph);

					table.addCell(cell);
				}
			}

		}

		return table;

	}

}
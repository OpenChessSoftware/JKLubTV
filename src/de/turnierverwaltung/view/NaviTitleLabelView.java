package de.turnierverwaltung.view;

import java.awt.Color;
import java.awt.Dimension;

public class NaviTitleLabelView extends TitleLabelView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaviTitleLabelView(String title) {
		super(title);
		setFlowLayoutLeft();
		getTitlePanel().setPreferredSize(new Dimension(200, 30));
		setPreferredSize(new Dimension(200, 40));
		setBackground(Color.LIGHT_GRAY);
		updateUI();
	}

}

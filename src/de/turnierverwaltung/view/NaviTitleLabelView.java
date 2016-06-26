package de.turnierverwaltung.view;

import java.awt.FlowLayout;

public class NaviTitleLabelView extends TitleLabelView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaviTitleLabelView(String title) {
		super(title);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setVgap(1);
		getTitlePanel().setLayout(flowLayout);
	}

}

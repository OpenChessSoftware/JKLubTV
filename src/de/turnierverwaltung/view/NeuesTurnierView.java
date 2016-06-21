package de.turnierverwaltung.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NeuesTurnierView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NeuesTurnierView() {
		super();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel(Messages.getString("NeuesTurnierView.0"));
		panel2.add(label);
		panel.add(panel2, BorderLayout.NORTH);
		add(panel);
		updateUI();
	}

}

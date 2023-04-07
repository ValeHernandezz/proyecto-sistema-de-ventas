package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SueldosPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SueldosPanel() {
		setLayout(null);
		
		JPanel panelSueldos = new JPanel();
		panelSueldos.setBounds(0, 0, 798, 550);
		panelSueldos.setBackground(new Color(145, 242, 189));
		add(panelSueldos);
		panelSueldos.setLayout(null);
		
		JLabel labelSueldos = new JLabel("Sueldos");
		labelSueldos.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldos.setFont(new Font("Cambria", Font.BOLD, 40));
		labelSueldos.setBounds(156, 219, 486, 111);
		panelSueldos.add(labelSueldos);

	}

}

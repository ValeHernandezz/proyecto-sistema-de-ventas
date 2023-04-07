package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class AdiosPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdiosPanel() {
		setLayout(null);
		
		JPanel panelAdios = new JPanel();
		panelAdios.setBounds(0, 0, 798, 550);
		panelAdios.setBackground(new Color(145, 242, 189));
		add(panelAdios);
		panelAdios.setLayout(null);
		
		JLabel labelAdios = new JLabel("Adios");
		labelAdios.setBounds(300, 238, 198, 74);
		labelAdios.setFont(new Font("Cambria", Font.BOLD, 40));
		labelAdios.setHorizontalAlignment(SwingConstants.CENTER);
		panelAdios.add(labelAdios);

	}
}

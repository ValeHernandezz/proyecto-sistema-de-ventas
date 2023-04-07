package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentasPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public VentasPanel() {
		setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 798, 550);
		panelVentas.setBackground(new Color(145, 242, 189));
		add(panelVentas);
		panelVentas.setLayout(null);
		
		JLabel labelVentas = new JLabel("Ventas");
		labelVentas.setHorizontalAlignment(SwingConstants.CENTER);
		labelVentas.setFont(new Font("Cambria", Font.BOLD, 40));
		labelVentas.setBounds(156, 219, 486, 111);
		panelVentas.add(labelVentas);

	}

}

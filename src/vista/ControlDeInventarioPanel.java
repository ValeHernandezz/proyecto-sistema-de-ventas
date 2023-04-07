package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class ControlDeInventarioPanel extends JPanel {
	private final JPanel panelControlDeInventario = new JPanel();

	/**
	 * Create the panel.
	 */
	public ControlDeInventarioPanel() {
		setLayout(null);
		panelControlDeInventario.setBounds(0, 0, 798, 550);
		panelControlDeInventario.setBackground(new Color(145, 242, 189));
		add(panelControlDeInventario);
		panelControlDeInventario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Control de Inventario");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 219, 486, 111);
		panelControlDeInventario.add(lblNewLabel);

	}
}

package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BienvenidoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BienvenidoPanel() {
		setLayout(null);
		
		JPanel panelBienvenido = new JPanel();
		panelBienvenido.setBackground(new Color(145, 242, 189));
		panelBienvenido.setBounds(0, 0, 798, 550);
		add(panelBienvenido);
		panelBienvenido.setLayout(null);
		
		JLabel labelBienvenido = new JLabel("Bienvenido");
		labelBienvenido.setBounds(218, 256, 362, 37);
		labelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		labelBienvenido.setFont(new Font("Tahoma", Font.BOLD, 40));
		panelBienvenido.add(labelBienvenido);

	}

}

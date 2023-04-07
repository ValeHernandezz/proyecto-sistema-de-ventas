package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ComprasPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ComprasPanel() {
		setLayout(null);
		
		JPanel panelCompras = new JPanel();
		panelCompras.setBounds(0, 0, 798, 550);
		panelCompras.setBackground(new Color(145, 242, 189));
		add(panelCompras);
		panelCompras.setLayout(null);
		
		JLabel labelCompras = new JLabel("Compras");
		labelCompras.setHorizontalAlignment(SwingConstants.CENTER);
		labelCompras.setFont(new Font("Cambria", Font.BOLD, 40));
		labelCompras.setBounds(156, 219, 486, 111);
		panelCompras.add(labelCompras);

	}

}

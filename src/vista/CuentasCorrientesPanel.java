package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CuentasCorrientesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CuentasCorrientesPanel() {
		setLayout(null);
		
		JPanel panelCuentasCorrientes = new JPanel();
		panelCuentasCorrientes.setBounds(0, 0, 798, 550);
		panelCuentasCorrientes.setBackground(new Color(145, 242, 189));
		add(panelCuentasCorrientes);
		panelCuentasCorrientes.setLayout(null);
		
		JLabel labelCuentasCorrientes = new JLabel("Cuentas Corrientes");
		labelCuentasCorrientes.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuentasCorrientes.setFont(new Font("Cambria", Font.BOLD, 40));
		labelCuentasCorrientes.setBounds(156, 219, 486, 111);
		panelCuentasCorrientes.add(labelCuentasCorrientes);

	}

}

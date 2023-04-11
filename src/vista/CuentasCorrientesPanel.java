package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.helpers.ImagenCuentasCorrientes;

public class CuentasCorrientesPanel extends JPanel {
	
	private ImagenCuentasCorrientes imagenCuentasCorrientes = new ImagenCuentasCorrientes();
	
	/**
	 * Create the panel.
	 */
	public CuentasCorrientesPanel() {
		setLayout(null);
		
		JPanel panelCuentasCorrientes = new JPanel();
		panelCuentasCorrientes.setBounds(0, 0, 798, 550);
		panelCuentasCorrientes.setBackground(Color.decode("#9ED7E2"));
		add(panelCuentasCorrientes);
		panelCuentasCorrientes.setLayout(null);
		
		JLabel labelCuentasCorrientes = new JLabel("Cuentas Corrientes");
		labelCuentasCorrientes.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuentasCorrientes.setFont(new Font("Cambria", Font.BOLD, 40));
		labelCuentasCorrientes.setBounds(156, 75, 486, 111);
		panelCuentasCorrientes.add(labelCuentasCorrientes);
		
		JPanel panelImagenCuentasCorrientes = new JPanel();
		panelImagenCuentasCorrientes.setBounds(198, 206, 402, 215);
		panelCuentasCorrientes.add(panelImagenCuentasCorrientes);
		panelImagenCuentasCorrientes.setLayout(null);
		
		imagenCuentasCorrientes.setBounds(0, 0, 402, 215);
		panelImagenCuentasCorrientes.add(imagenCuentasCorrientes);

	}

}

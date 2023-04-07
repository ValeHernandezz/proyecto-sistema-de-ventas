package vista;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuOperador extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuOperador(MostrarPanel panel) {
		setLayout(null);
		
		JPanel panelMenuOperador = new JPanel();
		panelMenuOperador.setBounds(0, 0, 200, 550);
		panelMenuOperador.setBackground(new Color(117, 236, 164));
		add(panelMenuOperador);
		panelMenuOperador.setLayout(null);
		
		JButton buttonAdios = new JButton("Adios");
		buttonAdios.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonAdios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				
				AdiosPanel adiosPanel = new AdiosPanel();
				adiosPanel.setLocation(0, 0);
				adiosPanel.setSize(798, 550);
				panel.mostrarPanelContent(adiosPanel);
				
			}
		});
		buttonAdios.setBounds(26, 464, 147, 21);
		panelMenuOperador.add(buttonAdios);
		
		JLabel labelMenuOperador = new JLabel("Menú Operador");
		labelMenuOperador.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuOperador.setFont(new Font("Cambria", Font.BOLD, 17));
		labelMenuOperador.setBounds(-19, 57, 238, 44);
		panelMenuOperador.add(labelMenuOperador);
		
		JButton buttonVentas = new JButton("Ventas");
		buttonVentas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				VentasPanel ventasPanel = new VentasPanel();
				ventasPanel.setSize(798, 550);
				ventasPanel.setLocation(0, 0);
				panel.mostrarPanelContent(ventasPanel);
				
			}
		});
		buttonVentas.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonVentas.setBounds(26, 261, 147, 21);
		panelMenuOperador.add(buttonVentas);
		
		JButton buttonCompras = new JButton("Compras");
		buttonCompras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				ComprasPanel comprasPanel = new ComprasPanel();
				comprasPanel.setSize(798, 550);
				comprasPanel.setLocation(0, 0);
				panel.mostrarPanelContent(comprasPanel);
				
			}
		});
		buttonCompras.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCompras.setBounds(26, 212, 147, 21);
		panelMenuOperador.add(buttonCompras);
		
		JButton buttonCuentasCorrientes = new JButton("Cuentas Corrientes");
		buttonCuentasCorrientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				CuentasCorrientesPanel cuentasCorrientesPanel = new CuentasCorrientesPanel();
				cuentasCorrientesPanel.setSize(798, 550);
				cuentasCorrientesPanel.setLocation(0, 0);
				panel.mostrarPanelContent(cuentasCorrientesPanel);
				
			}
		});
		buttonCuentasCorrientes.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCuentasCorrientes.setBounds(26, 309, 147, 21);
		panelMenuOperador.add(buttonCuentasCorrientes);

	}
}

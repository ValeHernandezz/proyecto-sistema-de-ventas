package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuJefe extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuJefe(MostrarPanel panel) {
		setLayout(null);
		
		JPanel panelMenuJefe = new JPanel();
		panelMenuJefe.setBounds(0, 0, 200, 550);
		panelMenuJefe.setBackground(new Color(117, 236, 164));
		add(panelMenuJefe);
		panelMenuJefe.setLayout(null);
		
		JLabel labelMenuJefe = new JLabel("Menú Jefe");
		labelMenuJefe.setFont(new Font("Cambria", Font.BOLD, 17));
		labelMenuJefe.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuJefe.setBounds(-22, 56, 244, 64);
		panelMenuJefe.add(labelMenuJefe);
		
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
		buttonVentas.setBounds(26, 252, 147, 21);
		panelMenuJefe.add(buttonVentas);
		
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
		buttonCompras.setBounds(26, 199, 147, 21);
		panelMenuJefe.add(buttonCompras);
		
		JButton buttonControlDeInventario = new JButton("Control de Inventario");
		buttonControlDeInventario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				ControlDeInventarioPanel controlDeInventarioPanel = new ControlDeInventarioPanel();
				controlDeInventarioPanel.setSize(798, 550);
				controlDeInventarioPanel.setLocation(0, 0);
				panel.mostrarPanelContent(controlDeInventarioPanel);
				
			}
		});
		buttonControlDeInventario.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonControlDeInventario.setBounds(26, 303, 147, 21);
		panelMenuJefe.add(buttonControlDeInventario);
		
		JButton buttonAdios = new JButton("Adios");
		buttonAdios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				AdiosPanel adiosPanel = new AdiosPanel();
				adiosPanel.setSize(798, 550);
				adiosPanel.setLocation(0, 0);
				panel.mostrarPanelContent(adiosPanel);
				
			}
		});
		buttonAdios.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonAdios.setBounds(26, 470, 147, 21);
		panelMenuJefe.add(buttonAdios);

	}
}

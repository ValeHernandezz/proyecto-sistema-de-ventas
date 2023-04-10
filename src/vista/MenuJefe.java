package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Fabrica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuJefe extends JPanel {

	private Fabrica fabrica = new Fabrica();
	
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
		labelMenuJefe.setBounds(-17, 25, 234, 44);
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
		buttonVentas.setBounds(26, 250, 147, 21);
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
		buttonCompras.setBounds(26, 200, 147, 21);
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
		buttonControlDeInventario.setBounds(26, 300, 147, 21);
		panelMenuJefe.add(buttonControlDeInventario);
		
		JButton buttonCerrarSesion = new JButton("Cerrar Sesión");
		buttonCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				fabrica.setoPersonaLogueada(null);
                LoginPanel loginPanel = new LoginPanel(panel);
                loginPanel.setBounds(0, 0, 1028, 570);
                panel.mostrarPanelContent(loginPanel);
                panel.ocultarMenu();
				
			}
		});
		buttonCerrarSesion.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesion.setBounds(26, 500, 147, 21);
		panelMenuJefe.add(buttonCerrarSesion);

	}
}

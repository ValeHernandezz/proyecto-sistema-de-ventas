package vista;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Fabrica;
import clases.Persona;

public class MenuOperador extends JPanel {
	
	private Fabrica fabrica = new Fabrica();
	private Persona oPersona;
	
	/**
	 * Create the panel.
	 */
	public MenuOperador(MostrarPanel panel, Persona oPersona) {
		setLayout(null);
		
		JPanel panelMenuOperador = new JPanel();
		panelMenuOperador.setBounds(0, 0, 200, 550);
		panelMenuOperador.setBackground(Color.decode("#4bb4ca"));
		add(panelMenuOperador);
		panelMenuOperador.setLayout(null);
		
		JButton buttonCerrarSesion = new JButton("Cerrar Sesión");
		buttonCerrarSesion.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				
				fabrica.setoPersonaLogueada(null);
                LoginPanel loginPanel = new LoginPanel(panel);
                loginPanel.setBounds(0, 0, 1028, 570);
                panel.mostrarPanelContent(loginPanel);
                panel.ocultarMenu();
				
			}
		});
		buttonCerrarSesion.setBounds(26, 500, 147, 21);
		panelMenuOperador.add(buttonCerrarSesion);
		
		JLabel labelMenuOperador = new JLabel("Operador de Sección");
		labelMenuOperador.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuOperador.setFont(new Font("Cambria", Font.BOLD, 17));
		labelMenuOperador.setBounds(-19, 25, 238, 44);
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
		buttonVentas.setBounds(26, 250, 147, 21);
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
		buttonCompras.setBounds(26, 200, 147, 21);
		panelMenuOperador.add(buttonCompras);
		
		JLabel labelNombreCompleto = new JLabel(oPersona.getNombreCompleto());
		labelNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreCompleto.setFont(new Font("Cambria", Font.PLAIN, 13));
		labelNombreCompleto.setBounds(10, 80, 180, 13);
		panelMenuOperador.add(labelNombreCompleto);

	}
}

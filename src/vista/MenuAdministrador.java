package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Fabrica;
import clases.Persona;

import java.awt.Color;

public class MenuAdministrador extends JPanel {
	
	private Fabrica fabrica = new Fabrica();
	private Persona oPersona = new Persona();

	/**
	 * Create the panel.
	 */
	public MenuAdministrador(MostrarPanel panel, Persona oPersona) {
		setLayout(null);
		
		JPanel panelMenuAdministrador = new JPanel();
		panelMenuAdministrador.setBackground(Color.decode("#4bb4ca"));
		panelMenuAdministrador.setBounds(0, 0, 200, 550);
		add(panelMenuAdministrador);
		panelMenuAdministrador.setLayout(null);
		
		JLabel labelMenuAdministrador = new JLabel("Administrador");
		labelMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuAdministrador.setFont(new Font("Cambria", Font.BOLD, 23));
		labelMenuAdministrador.setBounds(-19, 25, 238, 44);
		panelMenuAdministrador.add(labelMenuAdministrador);
		
		JButton buttonGestionarPersonal = new JButton("Gestionar Personal");
		buttonGestionarPersonal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				GestionarPersonalPanel gestionarPersonalPanel = new GestionarPersonalPanel();
				gestionarPersonalPanel.setSize(798, 550);
				gestionarPersonalPanel.setLocation(0, 0);
				panel.mostrarPanelContent(gestionarPersonalPanel);				
				
			}
		});
		buttonGestionarPersonal.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonGestionarPersonal.setBounds(26, 425, 147, 21);
		panelMenuAdministrador.add(buttonGestionarPersonal);
		
		JButton buttonCerrarSesión = new JButton("Cerrar Sesión");
		buttonCerrarSesión.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesión.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				fabrica.setoPersonaLogueada(null);
                LoginPanel loginPanel = new LoginPanel(panel);
                loginPanel.setBounds(0, 0, 1028, 570);
                panel.mostrarPanelContent(loginPanel);
                panel.ocultarMenu();
				
			}
		});
		buttonCerrarSesión.setBounds(26, 500, 147, 21);
		panelMenuAdministrador.add(buttonCerrarSesión);
		
		JButton buttonControlDeInventario = new JButton("Control de Inventario");
		buttonControlDeInventario.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonControlDeInventario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				ControlDeInventarioPanel controlDeInventarioPanel = new ControlDeInventarioPanel();
				controlDeInventarioPanel.setSize(798, 550);
				controlDeInventarioPanel.setLocation(0, 0);
				panel.mostrarPanelContent(controlDeInventarioPanel);
				
			}
		});
		buttonControlDeInventario.setBounds(26, 150, 147, 21);
		panelMenuAdministrador.add(buttonControlDeInventario);
		
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
		panelMenuAdministrador.add(buttonVentas);
		
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
		panelMenuAdministrador.add(buttonCompras);
		
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
		buttonCuentasCorrientes.setBounds(26, 300, 147, 21);
		panelMenuAdministrador.add(buttonCuentasCorrientes);
		
		JButton buttonSueldos = new JButton("Sueldos");
		buttonSueldos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				SueldosPanel sueldosPanel = new SueldosPanel();
				sueldosPanel.setSize(798, 550);
				sueldosPanel.setLocation(0, 0);
				panel.mostrarPanelContent(sueldosPanel);
				
			}
		});
		buttonSueldos.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonSueldos.setBounds(26, 350, 147, 21);
		panelMenuAdministrador.add(buttonSueldos);
		
		JLabel labelNombreCompleto = new JLabel(oPersona.getNombreCompleto());
		labelNombreCompleto.setFont(new Font("Cambria", Font.PLAIN, 13));
		labelNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreCompleto.setBounds(10, 80, 180, 13);
		panelMenuAdministrador.add(labelNombreCompleto);

	}
}

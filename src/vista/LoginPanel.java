package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import clases.Fabrica;
import clases.Persona;
import vista.helpers.ImagenLogoApp;
import vista.helpers.ImagenTextura;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {

	private JPanel panelLogin;
	
	private JPanel panelDatos;
	private JPanel panelLogoTipo;
	private JLabel labelIniciarSesion;
	private JLabel labelMail;
	private JTextField textFieldMail;
	private JLabel labelClave;
	private JPasswordField passwordFieldClave;
	private JButton buttonIngresar;

	private ImagenTextura imagenTextura;
	private ImagenLogoApp imagenApp;
	private Fabrica oFabrica = new Fabrica();
	private BienvenidoPanel panelBienvenido;
	private MenuAdministrador menuAdministrador;
	private MenuOperador menuOperador;
	private MenuJefe menuJefe;

	/**
	 * Create the panel.
	 */
	public LoginPanel(MostrarPanel panel) {
		setLayout(null);

		panelLogin = new JPanel();
		panelLogin.setBackground(Color.decode("#d8d8d8"));
		panelLogin.setBounds(0, 0, 1028, 570);
		add(panelLogin);
		panelLogin.setLayout(null);

		panelDatos = new JPanel();
		panelDatos.setBackground(Color.decode("#4bb4ca"));
		panelDatos.setBounds(322, 0, 384, 570);
		panelLogin.add(panelDatos);
		panelDatos.setLayout(null);

		panelLogoTipo = new JPanel();
		panelLogoTipo.setBounds(132, 82, 120, 120);
		panelLogoTipo.setOpaque(false); // Establecer el panel como transparente
		panelDatos.add(panelLogoTipo);
		panelLogoTipo.setLayout(null);
		
		imagenApp = new ImagenLogoApp();
		imagenApp.setBounds(0, 0, 120, 120);
		panelLogoTipo.add(imagenApp);

		labelIniciarSesion = new JLabel("Iniciar Sesión");
		labelIniciarSesion.setBounds(67, 212, 250, 47);
		panelDatos.add(labelIniciarSesion);
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Cambria", Font.BOLD, 40));

		labelMail = new JLabel("Mail");
		labelMail.setBounds(114, 288, 85, 13);
		panelDatos.add(labelMail);
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));

		textFieldMail = new JTextField();
		textFieldMail.setBounds(114, 318, 156, 19);
		panelDatos.add(textFieldMail);
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);

		labelClave = new JLabel("Contraseña");
		labelClave.setBounds(114, 358, 74, 19);
		panelDatos.add(labelClave);
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(114, 388, 156, 19);
		panelDatos.add(passwordFieldClave);
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonIngresar = new JButton("Ingresar");
		buttonIngresar.setBounds(144, 443, 95, 25);
		panelDatos.add(buttonIngresar);
		buttonIngresar.setFont(new Font("Cambria", Font.PLAIN, 15));
		buttonIngresar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String mail = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				if (mail.length() < 7 || clave.length() < 3) {
					JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Persona existePersona = oFabrica.login(mail, clave);

				if (existePersona == null) {
					JOptionPane.showMessageDialog(null, "El correo electrónico o la contraseña ingresados son incorrectos. \nPor favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				panelBienvenido = new BienvenidoPanel();
				panelBienvenido.setSize(798, 550);
				panelBienvenido.setLocation(0, 0);
				panel.mostrarPanelContent(panelBienvenido);

				if (existePersona != null) {

					panel.mostrarMenu();

					if (existePersona.getRol().equals("Administrador del Sistema")) {

						menuAdministrador = new MenuAdministrador(panel, existePersona);
						menuAdministrador.setSize(200, 550);
						menuAdministrador.setLocation(0, 0);
						panel.mostrarPanelMenu(menuAdministrador);
						return;

					}

					if (existePersona.getRol().equals("Operador de Sección")) {

						menuOperador = new MenuOperador(panel, existePersona);
						menuOperador.setSize(200, 550);
						menuOperador.setLocation(0, 0);
						panel.mostrarPanelMenu(menuOperador);
						return;

					}

					if (existePersona.getRol().equals("Jefe de Sección")) {

						menuJefe = new MenuJefe(panel, existePersona);
						menuJefe.setSize(200, 550);
						menuJefe.setLocation(0, 0);
						panel.mostrarPanelMenu(menuJefe);
						return;

					}

					return;

				}

			}
		});
		
		imagenTextura = new ImagenTextura();
		imagenTextura.setBounds(0, 0, 1200, 1200);
		panelLogin.add(imagenTextura);

	}
}

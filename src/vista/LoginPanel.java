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
import vista.helpers.ImagenTextura;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {
	
	private JPanel panelLogin;
	private JPanel panelDatos;
	private JLabel labelIniciarSesion;
	private JLabel labelMail;
	private JTextField textFieldMail;
	private JLabel labelClave;
	private JPasswordField passwordFieldClave;
	private JButton buttonIngresar;
	
	private Fabrica oFabrica = new Fabrica();
	private ImagenTextura imagenTextura = new ImagenTextura();

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

		labelIniciarSesion = new JLabel("Iniciar Sesión");
		labelIniciarSesion.setBounds(67, 149, 250, 47);
		panelDatos.add(labelIniciarSesion);
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Cambria", Font.BOLD, 40));

		labelMail = new JLabel("Mail");
		labelMail.setBounds(114, 225, 85, 13);
		panelDatos.add(labelMail);
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));

		textFieldMail = new JTextField();
		textFieldMail.setBounds(114, 255, 156, 19);
		panelDatos.add(textFieldMail);
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);

		labelClave = new JLabel("Contraseña");
		labelClave.setBounds(114, 295, 74, 19);
		panelDatos.add(labelClave);
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(114, 325, 156, 19);
		panelDatos.add(passwordFieldClave);
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonIngresar = new JButton("Ingresar");
		buttonIngresar.setBounds(144, 380, 95, 25);
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
					JOptionPane.showMessageDialog(null, "No existe la persona", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				BienvenidoPanel panelBienvenido = new BienvenidoPanel();
				panelBienvenido.setSize(798, 550);
				panelBienvenido.setLocation(0, 0);
				panel.mostrarPanelContent(panelBienvenido);

				if (existePersona != null) {

					panel.mostrarMenu();

					if (existePersona.getIdRol() == 1) {
						
						MenuAdministrador menuAdministrador = new MenuAdministrador(panel, existePersona);
						menuAdministrador.setSize(200, 550);
						menuAdministrador.setLocation(0, 0);
						panel.mostrarPanelMenu(menuAdministrador);
						return;

					}

					if (existePersona.getIdRol() == 2) {

						MenuOperador menuOperador = new MenuOperador(panel, existePersona);
						menuOperador.setSize(200, 550);
						menuOperador.setLocation(0, 0);
						panel.mostrarPanelMenu(menuOperador);
						return;

					}

					if (existePersona.getIdRol() == 3) {

						MenuJefe menuJefe = new MenuJefe(panel);
						menuJefe.setSize(200, 550);
						menuJefe.setLocation(0, 0);
						panel.mostrarPanelMenu(menuJefe);
						return;

					}

					return;

				}

			}
		});
		
		imagenTextura.setBounds(0, 0, 1028, 570);
		panelLogin.add(imagenTextura);

	}
}

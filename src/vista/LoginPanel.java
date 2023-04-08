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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {

	private JTextField textFieldMail;
	private Fabrica oFabrica = new Fabrica();
	private JPasswordField passwordFieldClave;

	/**
	 * Create the panel.
	 */
	public LoginPanel(MostrarPanel panel) {
		setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(145, 242, 189));
		panelLogin.setBounds(0, 0, 1008, 550);
		add(panelLogin);
		panelLogin.setLayout(null);

		JPanel panelContenido = new JPanel();
		panelContenido.setBackground(new Color(117, 236, 164));
		panelContenido.setBounds(337, 0, 333, 550);
		panelLogin.add(panelContenido);
		panelContenido.setLayout(null);

		JLabel labelIniciarSesion = new JLabel("Iniciar Sesión");
		labelIniciarSesion.setBounds(31, 175, 271, 29);
		panelContenido.add(labelIniciarSesion);
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Cambria", Font.BOLD, 40));

		JLabel labelMail = new JLabel("Mail");
		labelMail.setBounds(88, 236, 85, 13);
		panelContenido.add(labelMail);
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));

		textFieldMail = new JTextField();
		textFieldMail.setBounds(88, 255, 156, 19);
		panelContenido.add(textFieldMail);
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);

		JLabel labelClave = new JLabel("Contraseña");
		labelClave.setBounds(88, 284, 85, 13);
		panelContenido.add(labelClave);
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(88, 307, 156, 19);
		panelContenido.add(passwordFieldClave);
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));

		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.setBounds(124, 355, 85, 21);
		panelContenido.add(buttonIngresar);
		buttonIngresar.setFont(new Font("Cambria", Font.PLAIN, 13));
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

						MenuJefe menuJefe = new MenuJefe(panel, existePersona);
						menuJefe.setSize(200, 550);
						menuJefe.setLocation(0, 0);
						panel.mostrarPanelMenu(menuJefe);
						return;

					}

					return;

				}

			}
		});

	}
}

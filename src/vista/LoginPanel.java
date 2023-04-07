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
		panelLogin.setBounds(0, 0, 798, 550);
		add(panelLogin);
		panelLogin.setLayout(null);

		JLabel labelIniciarSesion = new JLabel("Iniciar Sesión");
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Cambria", Font.BOLD, 40));
		labelIniciarSesion.setBounds(263, 181, 271, 29);
		panelLogin.add(labelIniciarSesion);

		JLabel labelMail = new JLabel("Mail");
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelMail.setBounds(275, 242, 85, 13);
		panelLogin.add(labelMail);

		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(366, 239, 156, 19);
		panelLogin.add(textFieldMail);
		
		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));
		passwordFieldClave.setBounds(366, 280, 156, 19);
		panelLogin.add(passwordFieldClave);

		JLabel labelClave = new JLabel("Contraseña");
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelClave.setBounds(277, 283, 85, 13);
		panelLogin.add(labelClave);

		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonIngresar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String mail = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				if (mail.length() < 7 || clave.length() < 3) {
					JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {

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

						if (existePersona.getIdRol() == 1) {

							MenuAdministrador menuAdministrador = new MenuAdministrador(panel);
							menuAdministrador.setSize(200, 550);
							menuAdministrador.setLocation(0, 0);
							panel.mostrarPanelMenu(menuAdministrador);
							return;

						}

						if (existePersona.getIdRol() == 2) {

							MenuOperador menuOperador = new MenuOperador(panel);
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

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error en la Base de Datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		buttonIngresar.setBounds(356, 335, 85, 21);
		panelLogin.add(buttonIngresar);

	}
}

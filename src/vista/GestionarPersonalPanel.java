package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Fabrica;
import clases.Persona;
import vista.helpers.Helper;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;

public class GestionarPersonalPanel extends JPanel {
	private JTextField textFieldDocumento;
	private JTextField textFieldNombre1;
	private JTextField textFieldApellido1;
	private JTextField textFieldNombre2;
	private JTextField textFieldApellido2;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;
	private JTextField textFieldMail;
	private JTextField textFieldClave;
	private JComboBox comboBoxRol = new JComboBox();
	private Fabrica fabrica = new Fabrica();
	private JTable table = new JTable();
	private JTextField textFieldBuscar;
	private JComboBox comboBoxFiltroBuscar = new JComboBox();

	/**
	 * Create the panel.
	 * el nico se la come
	 */
	public GestionarPersonalPanel() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(145, 242, 189));
		panel.setBounds(0, 0, 798, 550);
		add(panel);
		panel.setLayout(null);

		JLabel labelGestionarPersonal = new JLabel("Gestionar Personal");
		labelGestionarPersonal.setBounds(156, 10, 486, 56);
		labelGestionarPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		labelGestionarPersonal.setFont(new Font("Cambria", Font.BOLD, 40));
		panel.add(labelGestionarPersonal);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 143, 725, 207);
		panel_1.setBackground(new Color(122, 239, 175));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelDocumento = new JLabel("Documento");
		labelDocumento.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelDocumento.setBounds(35, 20, 94, 13);
		panel_1.add(labelDocumento);

		JLabel labelNombres = new JLabel("Nombres");
		labelNombres.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelNombres.setBounds(35, 53, 94, 13);
		panel_1.add(labelNombres);

		JLabel labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelApellidos.setBounds(35, 86, 94, 25);
		panel_1.add(labelApellidos);

		JLabel labelFechaNacimiento = new JLabel("Fecha de Nacimiento");
		labelFechaNacimiento.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelFechaNacimiento.setBounds(35, 131, 151, 13);
		panel_1.add(labelFechaNacimiento);

		JLabel labelRol = new JLabel("Rol");
		labelRol.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelRol.setBounds(470, 20, 94, 13);
		panel_1.add(labelRol);

		JLabel labelMail = new JLabel("Mail");
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelMail.setBounds(470, 53, 94, 13);
		panel_1.add(labelMail);

		JLabel labelClave = new JLabel("Clave");
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelClave.setBounds(470, 86, 94, 13);
		panel_1.add(labelClave);

		JButton buttonRegistrar = new JButton("Registrar");
		buttonRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();

				boolean esUnaFecha = Helper.comprobarFecha(textFieldDia.getText(), textFieldMes.getText(),
						textFieldAnio.getText());
				if (!esUnaFecha) {
					return;
				}

				int dia = Integer.parseInt(textFieldDia.getText());
				int mes = Integer.parseInt(textFieldMes.getText());
				int anio = Integer.parseInt(textFieldAnio.getText());
				int idRol = comboBoxRol.getSelectedIndex();
				String mail = textFieldMail.getText();
				String clave = textFieldClave.getText();

				if (documento.length() < 6 || nombre1.length() < 3 || apellido1.length() < 3 || apellido2.length() < 3
						|| dia > 31 || mes > 12 || anio > 2005 || anio < 1930 || idRol == 0 || mail.length() < 6
						|| clave.length() < 3) {

					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				boolean esUnDocumento = Helper.esUnDocumento(documento);
				if (!esUnDocumento) {
					return;
				}

				LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

				Persona oPersona = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fechaNacimiento,
						clave, idRol, mail);

				boolean respuesta = fabrica.registrarPersona(oPersona);

				if (respuesta) {

					JOptionPane.showMessageDialog(null, "Se ha ingresado una persona correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
					textFieldDocumento.setText(null);
					return;

				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido ingresar una persona", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

			}
		});
		buttonRegistrar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonRegistrar.setBounds(393, 149, 85, 21);
		panel_1.add(buttonRegistrar);

		JButton buttonModificar = new JButton("Modificar");
		buttonModificar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();

				if (textFieldDia.getText().equals("Día") || textFieldMes.getText().equals("Mes")
						|| textFieldAnio.getText().equals("Año")) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (textFieldDia.getText().equals("") || textFieldMes.getText().equals("")
						|| textFieldAnio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				int dia = Integer.parseInt(textFieldDia.getText());
				int mes = Integer.parseInt(textFieldMes.getText());
				int anio = Integer.parseInt(textFieldAnio.getText());
				int idRol = comboBoxRol.getSelectedIndex();
				String mail = textFieldMail.getText();

				if (documento.length() < 6 || nombre1.length() < 3 || apellido1.length() < 3 || apellido2.length() < 3
						|| dia > 31 || mes > 12 || anio > 2005 || anio < 1930 || idRol == 0 || mail.length() < 6) {

					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

				Persona oPersona = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fechaNacimiento,
						idRol, mail);

				boolean respuesta = fabrica.editarPersona(oPersona);

				if (respuesta) {

					JOptionPane.showMessageDialog(null, "Se ha modificado la persona correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
					textFieldDocumento.setText(null);
					return;

				} else {

					JOptionPane.showMessageDialog(null, "No existe la persona que desea modificar", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

			}
		});
		buttonModificar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonModificar.setBounds(488, 149, 97, 21);
		panel_1.add(buttonModificar);

		JButton buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();

				if (documento.length() < 6) {

					JOptionPane.showMessageDialog(null, "Debe ingresar el Documento de la persona que desea eliminar",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;

				}

				boolean respuesta = fabrica.eliminarPersona(documento);

				if (respuesta) {

					JOptionPane.showMessageDialog(null, "La persona se ha eliminado con éxito", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					textFieldDocumento.setText(null);
					return;

				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar la persona", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

			}
		});
		buttonEliminar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonEliminar.setBounds(595, 149, 85, 21);
		panel_1.add(buttonEliminar);

		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldDocumento.setBounds(185, 17, 96, 19);
		panel_1.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);

		textFieldNombre1 = new JTextField();
		textFieldNombre1.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(185, 50, 96, 19);
		panel_1.add(textFieldNombre1);

		textFieldApellido1 = new JTextField();
		textFieldApellido1.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(185, 89, 96, 19);
		panel_1.add(textFieldApellido1);

		textFieldNombre2 = new JTextField();
		textFieldNombre2.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(307, 50, 96, 19);
		panel_1.add(textFieldNombre2);

		textFieldApellido2 = new JTextField();
		textFieldApellido2.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(307, 89, 96, 19);
		panel_1.add(textFieldApellido2);

		textFieldDia = new JTextField();
		textFieldDia.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDia.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldDia.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {

				if (textFieldDia.getText().equals("Día")) {
					textFieldDia.setForeground(Color.BLACK);
					textFieldDia.setText("");
				}

			}

			public void focusLost(FocusEvent e) {

				if (textFieldDia.getText().isEmpty()) {
					textFieldDia.setForeground(Color.DARK_GRAY);
					textFieldDia.setText("Día");
				}

			}
		});
		textFieldDia.setColumns(10);
		textFieldDia.setBounds(185, 128, 32, 19);
		textFieldDia.setForeground(Color.DARK_GRAY);
		textFieldDia.setText("Día");
		panel_1.add(textFieldDia);

		textFieldMes = new JTextField();
		textFieldMes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMes.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMes.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {

				if (textFieldMes.getText().equals("Mes")) {
					textFieldMes.setForeground(Color.BLACK);
					textFieldMes.setText("");
				}

			}

			public void focusLost(FocusEvent e) {

				if (textFieldMes.getText().isEmpty()) {
					textFieldMes.setForeground(Color.DARK_GRAY);
					textFieldMes.setText("Mes");
				}

			}
		});
		textFieldMes.setColumns(10);
		textFieldMes.setBounds(227, 128, 32, 19);
		textFieldMes.setForeground(Color.DARK_GRAY);
		textFieldMes.setText("Mes");
		panel_1.add(textFieldMes);

		textFieldAnio = new JTextField();
		textFieldAnio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnio.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldAnio.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {

				if (textFieldAnio.getText().equals("Año")) {
					textFieldAnio.setForeground(Color.BLACK);
					textFieldAnio.setText("");
				}

			}

			public void focusLost(FocusEvent e) {

				if (textFieldAnio.getText().isEmpty()) {
					textFieldAnio.setForeground(Color.DARK_GRAY);
					textFieldAnio.setText("Año");
				}

			}
		});
		textFieldAnio.setColumns(10);
		textFieldAnio.setBounds(269, 128, 32, 19);
		textFieldAnio.setForeground(Color.DARK_GRAY);
		textFieldAnio.setText("Año");
		panel_1.add(textFieldAnio);

		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(529, 50, 151, 19);
		panel_1.add(textFieldMail);

		textFieldClave = new JTextField();
		textFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(529, 83, 151, 19);
		panel_1.add(textFieldClave);
		comboBoxRol.setFont(new Font("Cambria", Font.PLAIN, 13));

		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] { "Elige un rol", "Administrador del Sistema",
				"Operador de Sección", "Jefe de Sección" }));
		comboBoxRol.setBounds(529, 16, 151, 21);
		panel_1.add(comboBoxRol);

		JButton buttonLimpiarCampos = new JButton("Limpiar Campos");
		buttonLimpiarCampos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				limpiarCampos();
				textFieldDocumento.setText(null);

			}
		});
		buttonLimpiarCampos.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarCampos.setBounds(35, 164, 136, 21);
		panel_1.add(buttonLimpiarCampos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 396, 725, 129);
		panel.add(scrollPane);

		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Documento", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
						"Fecha de Nacimiento", "Rol", "Mail" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Object.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JPanel panelBuscar = new JPanel();
		panelBuscar.setBounds(36, 77, 725, 56);
		panelBuscar.setBackground(new Color(122, 239, 175));
		panel.add(panelBuscar);
		panelBuscar.setLayout(null);

		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(460, 17, 85, 21);
		panelBuscar.add(buttonBuscar);
		buttonBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String datos = textFieldBuscar.getText();
				String filtros = comboBoxFiltroBuscar.getSelectedItem().toString();
				int indexFiltro = comboBoxFiltroBuscar.getSelectedIndex();

				if (datos.length() < 1) {

					JOptionPane.showMessageDialog(null, "Debe ingresar un dato de la persona que desea buscar", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (indexFiltro == 0) {

					JOptionPane.showMessageDialog(null, "Debe seleccionar un filtro para realizar la búsqueda", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				ArrayList<Persona> listaPersonas = fabrica.buscarPersona(datos, filtros);

				if (listaPersonas.size() != 0) {

					if (!filtros.equals("Documento")) {

						limpiarCamposDeBusqueda();
						TableModelPersona tablaPersonas = new TableModelPersona(listaPersonas);
						table.setModel(tablaPersonas);
						System.out.println("Entro acá");
						return;

					} else {

						for (Persona p : listaPersonas) {

							String dia = String.valueOf(p.getFechaNacimiento().getDayOfMonth());
							String mes = String.valueOf(p.getFechaNacimiento().getMonthValue());
							String anio = String.valueOf(p.getFechaNacimiento().getYear());
							textFieldDocumento.setText(p.getDocumento());
							textFieldNombre1.setText(p.getNombre1());
							textFieldNombre2.setText(p.getNombre2());
							textFieldApellido1.setText(p.getApellido1());
							textFieldApellido2.setText(p.getApellido2());
							textFieldDia.setText(dia);
							textFieldMes.setText(mes);
							textFieldAnio.setText(anio);
							comboBoxRol.setSelectedItem(p.getRol());
							textFieldMail.setText(p.getMail());

						}

					}

				} else {

					JOptionPane.showMessageDialog(null, "No existe la persona que busca", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

			}
		});
		buttonBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));

		comboBoxFiltroBuscar.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione un filtro", "Nombres", "Apellidos", "Documento", "Rol" }));
		comboBoxFiltroBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		comboBoxFiltroBuscar.setBounds(272, 17, 168, 21);
		panelBuscar.add(comboBoxFiltroBuscar);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldBuscar.setBounds(107, 18, 145, 19);
		panelBuscar.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		JLabel labelBuscar = new JLabel("Buscar");
		labelBuscar.setFont(new Font("Cambria", Font.BOLD, 15));
		labelBuscar.setBounds(20, 21, 67, 13);
		panelBuscar.add(labelBuscar);

		JButton buttonLimpiarBusqueda = new JButton("Limpiar Búsqueda");
		buttonLimpiarBusqueda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				textFieldBuscar.setText(null);
				comboBoxFiltroBuscar.setSelectedIndex(0);

			}
		});
		buttonLimpiarBusqueda.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarBusqueda.setBounds(565, 18, 140, 21);
		panelBuscar.add(buttonLimpiarBusqueda);

		JButton buttonMostrarLista = new JButton("Mostrar Lista");
		buttonMostrarLista.setBounds(36, 365, 116, 21);
		panel.add(buttonMostrarLista);
		buttonMostrarLista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				ArrayList<Persona> listaPersonas = fabrica.listarPersonas();

				TableModelPersona tableModelPersona = new TableModelPersona(listaPersonas);
				table.setModel(tableModelPersona);

			}
		});
		buttonMostrarLista.setFont(new Font("Cambria", Font.PLAIN, 13));

		JButton buttonLimpiarTabla = new JButton("Limpiar Tabla");
		buttonLimpiarTabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

				TableModelPersona tableModelPersona = new TableModelPersona(listaPersonas);
				table.setModel(tableModelPersona);

			}
		});
		buttonLimpiarTabla.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarTabla.setBounds(164, 365, 128, 21);
		panel.add(buttonLimpiarTabla);

	}

	public void limpiarCampos() {

		textFieldNombre1.setText(null);
		textFieldNombre2.setText(null);
		textFieldApellido1.setText(null);
		textFieldApellido2.setText(null);
		textFieldDia.setText(null);
		textFieldMes.setText(null);
		textFieldAnio.setText(null);
		comboBoxRol.setSelectedIndex(0);
		textFieldMail.setText(null);
		textFieldClave.setText(null);

	}

	public void limpiarCamposDeBusqueda() {
		textFieldBuscar.setText(null);
		comboBoxFiltroBuscar.setSelectedIndex(0);
	}
}

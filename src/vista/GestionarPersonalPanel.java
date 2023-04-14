package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import clases.*;
import vista.helpers.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.border.EtchedBorder;

public class GestionarPersonalPanel extends JPanel {
	private JPanel panelPrincipal;
	private JLabel labelGestionarPersonal;

	private JPanel panelBuscar;
	private JLabel labelBuscar;
	private JTextField textFieldBuscar;
	private JComboBox comboBoxFiltroBuscar;
	private JButton buttonBuscar;
	private JButton buttonLimpiarBusqueda;

	private JPanel panelDatos;
	private JLabel labelDocumento;
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelFechaNacimiento;
	private JLabel labelRol;
	private JLabel labelMail;
	private JLabel labelClave;
	private JTextField textFieldDocumento;
	private JTextField textFieldNombre1;
	private JTextField textFieldNombre2;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;
	private JComboBox comboBoxRol;
	private JTextField textFieldMail;
	private JPasswordField passwordFieldClave;
	private JButton buttonRegistrar;
	private JButton buttonModificar;
	private JButton buttonEliminar;
	private JButton buttonLimpiarCampos;
	private JLabel labelSlash1;
	private JLabel labelSlash2;

	private JButton buttonMostrarLista;
	private JButton buttonLimpiarTabla;

	private JScrollPane scrollPaneTabla;
	private JTable tabla;

	private Fabrica fabrica = new Fabrica();
	private ArrayList<Persona> listaPersonas;

	/**
	 * Create the panel.
	 */
	public GestionarPersonalPanel() {
		
		this.listaPersonas = fabrica.listarPersonas();
		
		setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.decode("#9ED7E2"));
		panelPrincipal.setBounds(0, 0, 798, 550);
		add(panelPrincipal);
		panelPrincipal.setLayout(null);

		labelGestionarPersonal = new JLabel("Gestionar Personal");
		labelGestionarPersonal.setBounds(156, 16, 486, 36);
		labelGestionarPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		labelGestionarPersonal.setFont(new Font("Cambria", Font.BOLD, 40));
		panelPrincipal.add(labelGestionarPersonal);

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelBuscar.setBounds(36, 68, 725, 56);
		panelBuscar.setBackground(new Color(124, 200, 216));
		panelPrincipal.add(panelBuscar);
		panelBuscar.setLayout(null);

		labelBuscar = new JLabel("Buscar");
		labelBuscar.setFont(new Font("Cambria", Font.BOLD, 15));
		labelBuscar.setBounds(35, 21, 67, 13);
		panelBuscar.add(labelBuscar);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldBuscar.setBounds(107, 18, 145, 19);
		panelBuscar.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		comboBoxFiltroBuscar = new JComboBox();
		comboBoxFiltroBuscar.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione un filtro", "Nombres", "Apellidos", "Documento", "Rol" }));
		comboBoxFiltroBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		comboBoxFiltroBuscar.setBounds(273, 17, 134, 21);
		panelBuscar.add(comboBoxFiltroBuscar);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(432, 17, 85, 21);
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

				boolean esUnNumero = true;
				boolean esUnaCedulaValida = true;

				if (filtros.equals("Documento")) {
					esUnNumero = Helper.esUnDocumento(datos);

					if (!esUnNumero) {
						return;
					}

					esUnaCedulaValida = Helper.validarCedulaUruguaya(datos);
					if (!esUnaCedulaValida) {
						JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}

				}

				ArrayList<Persona> listaPersonas = fabrica.buscarPersona(datos, filtros);

				if (listaPersonas.size() != 0) {
					if (!filtros.equals("Documento")) {

						limpiarCamposDeBusqueda();
						TableModelPersona tablaPersonas = new TableModelPersona(listaPersonas);
						tabla.setModel(tablaPersonas);
						return;

					} else {
						for (Persona p : listaPersonas) {

							limpiarCamposDeBusqueda();
							String dia = String.valueOf(p.getFechaNacimiento().getDayOfMonth());
							String mes = String.valueOf(p.getFechaNacimiento().getMonthValue());
							String anio = String.valueOf(p.getFechaNacimiento().getYear());
							textFieldDocumento.setText(p.getDocumento());
							textFieldDocumento.setEditable(false);
							passwordFieldClave.setEditable(false);
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

		buttonLimpiarBusqueda = new JButton("Limpiar Búsqueda");
		buttonLimpiarBusqueda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				textFieldBuscar.setText(null);
				comboBoxFiltroBuscar.setSelectedIndex(0);

			}
		});
		buttonLimpiarBusqueda.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarBusqueda.setBounds(540, 17, 140, 21);
		panelBuscar.add(buttonLimpiarBusqueda);

		panelDatos = new JPanel();
		panelDatos.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelDatos.setBounds(36, 140, 725, 207);
		panelDatos.setBackground(new Color(124, 200, 216));
		panelPrincipal.add(panelDatos);
		panelDatos.setLayout(null);

		labelDocumento = new JLabel("Documento");
		labelDocumento.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelDocumento.setBounds(35, 20, 94, 13);
		panelDatos.add(labelDocumento);

		labelNombres = new JLabel("Nombres");
		labelNombres.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelNombres.setBounds(35, 55, 94, 13);
		panelDatos.add(labelNombres);

		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelApellidos.setBounds(35, 86, 94, 25);
		panelDatos.add(labelApellidos);

		labelFechaNacimiento = new JLabel("Fecha de Nacimiento");
		labelFechaNacimiento.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelFechaNacimiento.setBounds(35, 131, 151, 13);
		panelDatos.add(labelFechaNacimiento);

		labelRol = new JLabel("Rol");
		labelRol.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelRol.setBounds(470, 20, 94, 13);
		panelDatos.add(labelRol);

		labelMail = new JLabel("Mail");
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelMail.setBounds(470, 55, 94, 13);
		panelDatos.add(labelMail);

		labelClave = new JLabel("Clave");
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelClave.setBounds(470, 92, 94, 13);
		panelDatos.add(labelClave);

		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldDocumento.setBounds(185, 17, 96, 19);
		panelDatos.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);

		textFieldNombre1 = new JTextField();
		textFieldNombre1.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(185, 52, 96, 19);
		panelDatos.add(textFieldNombre1);

		textFieldNombre2 = new JTextField();
		textFieldNombre2.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(307, 52, 96, 19);
		panelDatos.add(textFieldNombre2);

		textFieldApellido1 = new JTextField();
		textFieldApellido1.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(185, 89, 96, 19);
		panelDatos.add(textFieldApellido1);

		textFieldApellido2 = new JTextField();
		textFieldApellido2.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(307, 89, 96, 19);
		panelDatos.add(textFieldApellido2);

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
		panelDatos.add(textFieldDia);

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
		textFieldMes.setBounds(235, 128, 32, 19);
		textFieldMes.setForeground(Color.DARK_GRAY);
		textFieldMes.setText("Mes");
		panelDatos.add(textFieldMes);

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
		textFieldAnio.setBounds(287, 128, 43, 19);
		textFieldAnio.setForeground(Color.DARK_GRAY);
		textFieldAnio.setText("Año");
		panelDatos.add(textFieldAnio);

		comboBoxRol = new JComboBox();
		comboBoxRol.setFont(new Font("Cambria", Font.PLAIN, 13));
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] { "Elige un rol", "Administrador del Sistema",
				"Operador de Sección", "Jefe de Sección" }));
		comboBoxRol.setBounds(529, 16, 151, 21);
		panelDatos.add(comboBoxRol);

		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(529, 52, 151, 19);
		panelDatos.add(textFieldMail);

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));
		passwordFieldClave.setColumns(10);
		passwordFieldClave.setBounds(529, 89, 151, 19);
		panelDatos.add(passwordFieldClave);

		buttonRegistrar = new JButton("Registrar");
		buttonRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();

				int idRol = comboBoxRol.getSelectedIndex();
				String mail = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				if (documento.length() < 6 || nombre1.length() < 3 || apellido1.length() < 3 || apellido2.length() < 3
						|| textFieldDia.equals("Día") || textFieldDia.equals("Mes") || textFieldAnio.equals("Año")
						|| idRol == 0 || mail.length() < 6 || clave.length() < 3) {

					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}
				boolean esUnaFecha = Helper.comprobarFecha(textFieldDia.getText(), textFieldMes.getText(),
						textFieldAnio.getText());
				if (!esUnaFecha) {
					return;
				}
				
				int dia = Integer.parseInt(textFieldDia.getText());
				int mes = Integer.parseInt(textFieldMes.getText());
				int anio = Integer.parseInt(textFieldAnio.getText());
				
				boolean esUnaFechaValida = Helper.esUnaFechaValida(dia, mes, anio);				
				if(!esUnaFechaValida) {
					return;
				}
				
				boolean esUnNumero = true;
				boolean esUnaCedulaValida = true;

				esUnNumero = Helper.esUnDocumento(documento);

				if (!esUnNumero) {
					return;
				}

				esUnaCedulaValida = Helper.validarCedulaUruguaya(documento);
				if (!esUnaCedulaValida) {
					JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

				Persona oPersona = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fechaNacimiento,
						clave, idRol, mail);

				boolean respuesta = fabrica.registrarPersona(oPersona);

				if (respuesta) {
					
					listaPersonas = fabrica.listarPersonas();
					actualizarListaPersonas();
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
		buttonRegistrar.setBounds(395, 164, 85, 21);
		panelDatos.add(buttonRegistrar);

		buttonModificar = new JButton("Editar");
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

				int deseaEditarPersona = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea editar los datos de esta persona?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (deseaEditarPersona == 0) {

					boolean respuesta = fabrica.editarPersona(oPersona);

					if (respuesta) {
						
						listaPersonas = fabrica.listarPersonas();
						actualizarListaPersonas();
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

				} else {

					return;

				}

			}
		});
		buttonModificar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonModificar.setBounds(495, 164, 85, 21);
		panelDatos.add(buttonModificar);

		buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();

				if (documento.length() < 6) {

					JOptionPane.showMessageDialog(null, "Debe ingresar el Documento de la persona que desea eliminar",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;

				}
				
				boolean esUnNumero = true;
				boolean esUnaCedulaValida = true;

				esUnNumero = Helper.esUnDocumento(documento);

				if (!esUnNumero) {
					return;
				}

				esUnaCedulaValida = Helper.validarCedulaUruguaya(documento);
				if (!esUnaCedulaValida) {
					JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				int deseaEliminarPersona = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta persona?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (deseaEliminarPersona == 0) {

					boolean respuesta = fabrica.eliminarPersona(documento);

					if (respuesta) {
						
						listaPersonas = fabrica.listarPersonas();
						actualizarListaPersonas();
						JOptionPane.showMessageDialog(null, "La persona ha sido eliminada con éxito", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
						textFieldDocumento.setText(null);
						return;

					} else {

						JOptionPane.showMessageDialog(null, "No ha sido posible eliminar la persona", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;

					}

				} else {

					return;

				}

			}
		});
		buttonEliminar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonEliminar.setBounds(595, 164, 85, 21);
		panelDatos.add(buttonEliminar);

		buttonLimpiarCampos = new JButton("Limpiar Campos");
		buttonLimpiarCampos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				limpiarCampos();
				textFieldDocumento.setText(null);

			}
		});
		buttonLimpiarCampos.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarCampos.setBounds(35, 164, 136, 21);
		panelDatos.add(buttonLimpiarCampos);

		labelSlash1 = new JLabel("/");
		labelSlash1.setFont(new Font("Cambria", Font.PLAIN, 20));
		labelSlash1.setBounds(220, 131, 21, 13);
		panelDatos.add(labelSlash1);

		labelSlash2 = new JLabel("/");
		labelSlash2.setFont(new Font("Cambria", Font.PLAIN, 20));
		labelSlash2.setBounds(271, 131, 21, 13);
		panelDatos.add(labelSlash2);

		buttonMostrarLista = new JButton("Mostrar Lista");
		buttonMostrarLista.setBounds(36, 363, 116, 21);
		panelPrincipal.add(buttonMostrarLista);
		buttonMostrarLista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				actualizarListaPersonas();

			}
		});
		buttonMostrarLista.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonLimpiarTabla = new JButton("Limpiar Tabla");
		buttonLimpiarTabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

				TableModelPersona tableModelPersona = new TableModelPersona(listaPersonas);
				tabla.setModel(tableModelPersona);

			}
		});
		buttonLimpiarTabla.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarTabla.setBounds(164, 363, 128, 21);
		panelPrincipal.add(buttonLimpiarTabla);

		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(36, 400, 725, 129);
		panelPrincipal.add(scrollPaneTabla);

		tabla = new JTable();
		tabla.setFont(new Font("Cambria", Font.PLAIN, 13));
		tabla.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Documento", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
						"Fecha de Nacimiento", "Rol", "Mail" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Object.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneTabla.setViewportView(tabla);

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
		passwordFieldClave.setText(null);
		textFieldDocumento.setEditable(true);
		passwordFieldClave.setEditable(true);

		if (textFieldDia.getText().isEmpty()) {
			textFieldDia.setForeground(Color.DARK_GRAY);
			textFieldDia.setText("Día");
		}

		if (textFieldMes.getText().isEmpty()) {
			textFieldMes.setForeground(Color.DARK_GRAY);
			textFieldMes.setText("Mes");
		}

		if (textFieldAnio.getText().isEmpty()) {
			textFieldAnio.setForeground(Color.DARK_GRAY);
			textFieldAnio.setText("Año");
		}

	}

	public void limpiarCamposDeBusqueda() {
		textFieldBuscar.setText(null);
		comboBoxFiltroBuscar.setSelectedIndex(0);
	}
	
	public void actualizarListaPersonas() {
		TableModelPersona tableModelPersona = new TableModelPersona(listaPersonas);
		tabla.setModel(tableModelPersona);
	}
}

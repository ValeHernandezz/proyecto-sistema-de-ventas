package vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import clases.Persona;

public class TableModelPersona implements TableModel {

	private ArrayList<Persona> listaPersonas;

	public TableModelPersona(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public int getRowCount() {
		return listaPersonas.size();
	}

	public int getColumnCount() {
		return 8;
	}

	public String getColumnName(int columnIndex) {

		String nombreColumna = null;

		switch (columnIndex) {

		case 0:
			nombreColumna = "Documento";
			break;

		case 1:
			nombreColumna = "Primer Nombre";
			break;

		case 2:
			nombreColumna = "Segundo Nombre";
			break;

		case 3:
			nombreColumna = "Primer Apellido";
			break;

		case 4:
			nombreColumna = "Segundo Apellido";
			break;

		case 5:
			nombreColumna = "Fecha de Nacimiento";
			break;

		case 6:
			nombreColumna = "Rol";
			break;

		case 7:
			nombreColumna = "Mail";
			break;

		}

		return nombreColumna;
		
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Persona oPersona = listaPersonas.get(rowIndex);

		String valor = null;

		switch (columnIndex) {

		case 0:
			valor = oPersona.getDocumento();
			break;

		case 1:
			valor = oPersona.getNombre1();
			break;

		case 2:
			valor = oPersona.getNombre2();
			break;

		case 3:
			valor = oPersona.getApellido1();
			break;

		case 4:
			valor = oPersona.getApellido2();
			break;

		case 5:
			LocalDate fecha = oPersona.getFechaNacimiento();
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fechaFormateada = fecha.format(formateador);
			valor = fechaFormateada;
			break;

		case 6:
			valor = oPersona.getRol();
			break;

		case 7:
			valor = oPersona.getMail();
			break;

		}

		return valor;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	}

	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
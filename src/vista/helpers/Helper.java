package vista.helpers;

import javax.swing.JOptionPane;

public class Helper {

	public static boolean esUnDocumento(String documento) {
		boolean esUnNumero;
		try {
			int numero = Integer.parseInt(documento);
			return esUnNumero = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "No es un documento válido \nEjemplo: 5555555", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			return esUnNumero = false;
		}
	}

	public static boolean comprobarFecha(String dia, String mes, String anio) {

		boolean esUnNumero;

		try {

			int diaEsNumero = Integer.parseInt(dia);
			int mesEsNumero = Integer.parseInt(mes);
			int anioEsNumero = Integer.parseInt(anio);

			return esUnNumero = true;

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida", "Info", JOptionPane.INFORMATION_MESSAGE);
			return esUnNumero = false;

		}

	}

	public static boolean comprobarDatos(String primerNombre, String primerApellido, String fechaNacimiento, String documento, String clave, int idRol, String mail) {
        boolean respuesta;

        if (primerNombre.length() < 3 || primerApellido.length() < 3 || fechaNacimiento == null || documento.length() < 6 || clave.length() < 5 || idRol == 0 || mail.length() < 6) {
            JOptionPane.showMessageDialog(null, "Debe completar los campos", "Info", JOptionPane.INFORMATION_MESSAGE);
            return respuesta = false;
        }

        return respuesta = true;
    }

}

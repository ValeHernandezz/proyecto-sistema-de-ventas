package baseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import clases.Persona;

public class DAOPersona {
	
	private static final Connection conexion = DataBaseManager.getConnection();
	
	private static final String SELECT_PERSONA = "SELECT p.DOCUMENTO, p.NOMBRE1, p.NOMBRE2, p.APELLIDO1, p.APELLIDO2, p.FECHA_NAC, p.MAIL, r.NOMBRE as ROL FROM PERSONAS p JOIN ROLES r ON p.ID_ROL = r.ID_ROL ";
	
	private static final String LOGIN_PERSONA = SELECT_PERSONA + "WHERE MAIL = ? AND CLAVE = ?";

	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS ORDER BY 1";

	private static final String INSERTAR_PERSONA = "INSERT INTO PERSONAS (ID_PERSONA, DOCUMENTO, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NAC, CLAVE, ID_ROL, MAIL) VALUES (SEQ_ID_PERS.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String EDITAR_PERSONA = "UPDATE PERSONAS SET NOMBRE1 = ?, NOMBRE2 = ?, APELLIDO1 = ?, APELLIDO2 = ?, FECHA_NAC = ?, ID_ROL = ?, MAIL = ? WHERE DOCUMENTO = ?";

	private static final String ELIMINAR_PERSONA = "DELETE FROM PERSONAS WHERE DOCUMENTO = ?";

	private static final String LISTAR_PERSONAS = SELECT_PERSONA + "ORDER BY ID_PERSONA";

	private static HashMap<String, String> consultasPersonalizadas;

	public DAOPersona() {
		consultasPersonalizadas = new HashMap<String, String>();
		consultasPersonalizadas.put("Nombres",
				SELECT_PERSONA + "WHERE UPPER (NOMBRE1) LIKE UPPER (?) OR UPPER (NOMBRE2) LIKE UPPER (?) ORDER BY ID_PERSONA");
		consultasPersonalizadas.put("Apellidos",
				SELECT_PERSONA + "WHERE UPPER (APELLIDO1) LIKE UPPER (?) OR UPPER (APELLIDO2) LIKE UPPER (?) ORDER BY ID_PERSONA");
		consultasPersonalizadas.put("Documento",
				SELECT_PERSONA + "WHERE DOCUMENTO = ? ORDER BY ID_PERSONA");
		consultasPersonalizadas.put("Rol",
				SELECT_PERSONA + "WHERE UPPER (r.NOMBRE) LIKE UPPER (?) ORDER BY ID_PERSONA");
	}

	// _____________________________________________________________________________________________________________________
	// MÉTODO PARA COMPROBAR LOS DATOS DEL LOGIN
	public static Persona loginPersona(String mail, String clave) {

		Persona oPersonaExiste = null;

		try {

			PreparedStatement sentencia = conexion.prepareStatement(LOGIN_PERSONA);

			sentencia.setString(1, mail);
			sentencia.setString(2, clave);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				
				oPersonaExiste = getPersonaFromResultSet(resultado);

			}
			
			return oPersonaExiste;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	// _____________________________________________________________________________________________________________________
	// MÉTODO PARA LISTAR LOS REGISTROS DE PERSONA
	public static ArrayList<Persona> findAll() {

		ArrayList<Persona> listaPersonas = new ArrayList<>();

		try {

			PreparedStatement sentencia = conexion.prepareStatement(ALL_PERSONAS);

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {

				Persona oPersona = getPersonaFromResultSet(resultado);

				listaPersonas.add(oPersona);

			}

			return listaPersonas;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

	}

	// _____________________________________________________________________________________________________________________
	// MÉTODO PARA INSERTAR REGISTROS A LA TABLA PERSONA
	public static boolean registrarPersona(Persona oPersona) {

		try {

			PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_PERSONA);

			sentencia.setString(1, oPersona.getDocumento());
			sentencia.setString(2, oPersona.getNombre1());
			sentencia.setString(3, oPersona.getNombre2());
			sentencia.setString(4, oPersona.getApellido1());
			sentencia.setString(5, oPersona.getApellido2());
			sentencia.setDate(6, Date.valueOf(oPersona.getFechaNacimiento()));
			sentencia.setString(7, oPersona.getClave());
			sentencia.setInt(8, oPersona.getIdRol());
			sentencia.setString(9, oPersona.getMail());

			int retorno = sentencia.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}

	// __________________________________________________________________________________________________________________________________________________
	// MÉTODO PARA EDITAR LOS DATOS DE UNA PERSONA DE LA TABLA PERSONA
	public static boolean editarPersona(Persona oPersona) {

		try {

			PreparedStatement sentencia = conexion.prepareStatement(EDITAR_PERSONA);

			sentencia.setString(1, oPersona.getNombre1());
			sentencia.setString(2, oPersona.getNombre2());
			sentencia.setString(3, oPersona.getApellido1());
			sentencia.setString(4, oPersona.getApellido2());
			sentencia.setDate(5, Date.valueOf(oPersona.getFechaNacimiento()));
			sentencia.setInt(6, oPersona.getIdRol());
			sentencia.setString(7, oPersona.getMail());
			sentencia.setString(8, oPersona.getDocumento());

			int retorno = sentencia.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}

	// __________________________________________________________________________________________________________________________________________________
	// MÉTODO PARA ELIMINAR UNA PERSONA (BAJA FÍSICA)
	public static boolean eliminarPersona(String documento) {

		try {

			PreparedStatement sentencia = conexion.prepareStatement(ELIMINAR_PERSONA);

			sentencia.setString(1, documento);

			int retorno = sentencia.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}

	// __________________________________________________________________________________________________________________________________________________
	// MÉTODO PARA OBTENER UNA LISTA CON TODAS LAS PERSONAS DE LA TABLA PERSONA
	public static ArrayList<Persona> listarPersonas() {

		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

		try {

			PreparedStatement sentencia = conexion.prepareStatement(LISTAR_PERSONAS);

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {

				Persona oPersona = getPersonaFromResultSet(resultado);
				listaPersonas.add(oPersona);

			}

			return listaPersonas;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

	}
	
	// __________________________________________________________________________________________________________________________________________________
	// MÉTODO PARA BUSCAR UNA PERSONA
	public ArrayList<Persona> buscarPersona(String datos, String filtro) {
		
		ArrayList<Persona> listaDePersonas = new ArrayList<Persona>();

		if (filtro.equals("Nombres")) {

			try {

				PreparedStatement sentencia = conexion.prepareStatement(consultasPersonalizadas.get("Nombres"));

				sentencia.setString(1, "%" + datos + "%");
				sentencia.setString(2, "%" + datos + "%");

				ResultSet resultado = sentencia.executeQuery();

				while (resultado.next()) {
					Persona oPersona = getPersonaFromResultSet(resultado);
					listaDePersonas.add(oPersona);					
				}

			} catch (SQLException e) {
				e.printStackTrace();
				listaDePersonas = null;
			}

			return listaDePersonas;

		}

		if (filtro.equals("Apellidos")) {

			try {

				PreparedStatement sentencia = conexion.prepareStatement(consultasPersonalizadas.get("Apellidos"));

				sentencia.setString(1, "%" + datos + "%");
				sentencia.setString(2, "%" + datos + "%");

				ResultSet resultado = sentencia.executeQuery();

				while (resultado.next()) {
					Persona oPersona = getPersonaFromResultSet(resultado);
					listaDePersonas.add(oPersona);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				listaDePersonas = null;
			}
			return listaDePersonas;
		}

		if (filtro.equals("Documento")) {

			try {

				PreparedStatement sentencia = conexion.prepareStatement(consultasPersonalizadas.get("Documento"));

				sentencia.setString(1, datos);

				ResultSet resultado = sentencia.executeQuery();

				while (resultado.next()) {
					Persona oPersona = getPersonaFromResultSet(resultado);
					listaDePersonas.add(oPersona);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				listaDePersonas = null;
			}
			return listaDePersonas;
		}

		if (filtro.equals("Rol")) {

			try {

				PreparedStatement sentencia = conexion.prepareStatement(consultasPersonalizadas.get("Rol"));

				sentencia.setString(1, "%" + datos + "%");

				ResultSet resultado = sentencia.executeQuery();

				while (resultado.next()) {
					Persona oPersona = getPersonaFromResultSet(resultado);
					listaDePersonas.add(oPersona);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				listaDePersonas = null;
			}
			return listaDePersonas;
		}
		return null;
	}

	// __________________________________________________________________________________________________________________________________________________
	// MÉTODO PARA OBTENER TODOS LOS DATOS DE UNA PERSONA
	public static Persona getPersonaFromResultSet(ResultSet resultado) throws SQLException {

		String documentoResultado = resultado.getString("DOCUMENTO");
		String nombre1Resultado = resultado.getString("NOMBRE1");
		String nombre2Resultado = resultado.getString("NOMBRE2");
		String apellido1Resultado = resultado.getString("APELLIDO1");
		String apellido2Resultado = resultado.getString("APELLIDO2");
		Date fechaAuxiliar = new Date(resultado.getDate("FECHA_NAC").getTime());
		LocalDate fechaNacimientoResultado = fechaAuxiliar.toLocalDate();
		String rolResultado = resultado.getString("ROL");
		String mailResultado = resultado.getString("MAIL");

		nombre2Resultado = nombre2Resultado != null ? nombre2Resultado : "-"; // Si el segundo nombre está vacío, se ingresa un guión en remplazo.

		Persona oPersona = new Persona(documentoResultado, nombre1Resultado, nombre2Resultado, apellido1Resultado,
				apellido2Resultado, fechaNacimientoResultado, rolResultado, mailResultado);

		return oPersona;

	}

}
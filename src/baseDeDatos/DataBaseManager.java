package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

	private static Connection conexionBaseDeDatos;

	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "SISTEMAVENTAS";
	private static String CLAVE = "SISTEMAVENTAS";

	static {

		conexionBaseDeDatos = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Se encontró el Driver para Oracle DB - La librería necesaria está referenciada");

			try {

				conexionBaseDeDatos = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);

				System.out.println("Conexión creada con éxito, es posible acceder a la base de datos");

			} catch (SQLException e) {

				System.out.println("No se logró instanciar una conexión");
				e.printStackTrace();

			}

		} catch (ClassNotFoundException e) {

			System.out.println("No tienes el driver en tu build-path");
			e.printStackTrace();

		}

	}

	public static Connection getConnection() {
		return conexionBaseDeDatos;

	}
}

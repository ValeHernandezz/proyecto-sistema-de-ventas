package baseDeDatos;

import java.util.ArrayList;

import clases.Persona;

public class FabricaBD {
	
	DAOPersona oDAOPersona;
	
	public FabricaBD() {
		this.oDAOPersona = new DAOPersona();
	}

	public Persona login(String mail, String clave) {

		Persona oPersona = DAOPersona.loginPersona(mail, clave);
		return oPersona;

	}

	public boolean registrarPersona(Persona oPersona) {

		boolean respuesta = DAOPersona.registrarPersona(oPersona);

		return respuesta;

	}
	
	public boolean editarPersona(Persona oPersona) {
		
		boolean respuesta = DAOPersona.editarPersona(oPersona);
		
		return respuesta;
		
	}
	
	public boolean eliminarPersona(String documento) {
		
		boolean respuesta = DAOPersona.eliminarPersona(documento);
		
		return respuesta;
		
	}
	
	public ArrayList<Persona> listarPersonas(){
		
		ArrayList<Persona> listaPersonas = DAOPersona.listarPersonas();
		
		return listaPersonas;
		
	}
	
	public ArrayList<Persona> buscarPersona(String datos, String filtro){
		
		ArrayList<Persona> listaPersonas = oDAOPersona.buscarPersona(datos, filtro);
		
		return listaPersonas;
		
	}

}

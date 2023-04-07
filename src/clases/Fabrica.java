package clases;

import java.util.ArrayList;

import baseDeDatos.DAOPersona;
import baseDeDatos.FabricaBD;

public class Fabrica {
	
	private ArrayList<Persona> listaPersonas;
	private static Persona oPersonaLogueada;
	private FabricaBD oFabricaBD;
	
	public Fabrica() {
		listaPersonas = null;
		oPersonaLogueada = null;
		oFabricaBD = new FabricaBD();
	}
	
	public Persona login(String mail, String clave) {
		
		Persona oPersona = oFabricaBD.login(mail, clave);
		
		if(oPersona != null) {
			setoPersonaLogueada(oPersona);
		}
		
		return oPersona;
		
	}
	
	public boolean registrarPersona(Persona oPersona) {
		
		boolean respuesta = oFabricaBD.registrarPersona(oPersona);
		
		return respuesta;
		
	}
	
	public boolean editarPersona(Persona oPersona) {
		
		boolean respuesta = oFabricaBD.editarPersona(oPersona);
		
		return respuesta;
		
	}
	
	public boolean eliminarPersona(String documento) {
		
		boolean respuesta = oFabricaBD.eliminarPersona(documento);
		
		return respuesta;
		
	}
	
	public ArrayList<Persona> listarPersonas(){
		
		ArrayList<Persona> listaPersonas = oFabricaBD.listarPersonas();
		
		return listaPersonas;
		
	}
	
	public ArrayList<Persona> buscarPersona(String documento) {
		
		ArrayList<Persona> listaPersonas = oFabricaBD.buscarPersona(documento);
		
		return listaPersonas;
		
	}
	
	public ArrayList<Persona> buscarPersona(String datos, String filtro){
		
		ArrayList<Persona> listaPersonas = oFabricaBD.buscarPersona(datos, filtro);
		
		return listaPersonas;
		
	}

	public Persona getoPersonaLogueada() {
		return oPersonaLogueada;
	}

	public void setoPersonaLogueada(Persona oPersonaLogueada) {
		this.oPersonaLogueada = oPersonaLogueada;
	}	

}

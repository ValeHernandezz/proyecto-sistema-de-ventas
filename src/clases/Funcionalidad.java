package clases;

import java.util.ArrayList;

public class Funcionalidad {
	
	private String nombre;
	private String descripcion;
	private ArrayList<Rol> listaRoles;
	
	public Funcionalidad(String nombre, String descripcion, ArrayList<Rol> listaRoles) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaRoles = listaRoles;
	}
	
	public boolean acceso(Persona oPersona) {
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(ArrayList<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public String toString() {
		return "Funcionalidad [nombre=" + nombre + ", descripcion=" + descripcion + ", listaRoles=" + listaRoles + "]";
	}
	
}

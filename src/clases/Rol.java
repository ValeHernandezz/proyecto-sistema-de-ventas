package clases;

import java.util.ArrayList;

public class Rol {
	
	private String nombre;
	private String descripcion;
	private ArrayList<Funcionalidad> listaFuncionalidades;
	
	public Rol(String nombre, String descripcion, ArrayList<Funcionalidad> listaFuncionalidades) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaFuncionalidades = listaFuncionalidades;
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

	public ArrayList<Funcionalidad> getListaFuncionalidades() {
		return listaFuncionalidades;
	}

	public void setListaFuncionalidades(ArrayList<Funcionalidad> listaFuncionalidades) {
		this.listaFuncionalidades = listaFuncionalidades;
	}

	public String toString() {
		return "Rol [nombre=" + nombre + ", descripcion=" + descripcion + ", listaFuncionalidades="
				+ listaFuncionalidades + "]";
	}

}

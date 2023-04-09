package clases;

import java.time.LocalDate;

public class Persona {
	
	private int idPersona;
	private String documento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private LocalDate fechaNacimiento;
	private String clave;
	private int idRol;
	private String mail;
	private String rol;
	
	public Persona(int idPersona, String documento, String nombre1, String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento, String clave, int idRol, String mail) {
		this.idPersona = idPersona;
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
		this.idRol = idRol;
		this.mail = mail;
	}
	
	public Persona(int idPersona, String documento, String nombre1, String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento, int idRol, String mail) {
		this.idPersona = idPersona;
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.idRol = idRol;
		this.mail = mail;
	}
	
	public Persona(String documento, String nombre1, String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento, String clave, int idRol, String mail) {
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
		this.idRol = idRol;
		this.mail = mail;
	}
	
	public Persona(String documento, String nombre1, String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento, String rol, String mail) {
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.setRol(rol);
		this.mail = mail;
	}
	
	public Persona(String documento, String nombre1, String nombre2, String apellido1, String apellido2,
			LocalDate fechaNacimiento, int idRol, String mail) {
		super();
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.idRol = idRol;
		this.mail = mail;
	}

	public Persona() {
		
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getNombreCompleto() {
		return nombre1 + " " + apellido1;
	}
	
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", documento=" + documento + ", nombre1=" + nombre1 + ", nombre2="
				+ nombre2 + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaNacimiento="
				+ fechaNacimiento + ", clave=" + clave + ", idRol=" + idRol + ", mail=" + mail + "]";
	}


}

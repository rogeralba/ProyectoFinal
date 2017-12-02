package logico;

import java.io.Serializable;
import java.util.Date;

public abstract class Empleado implements Serializable{
	private static int code = 0;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String cedula;
	private String direccion;
	private String telefono;
	private int codigointerno;
	private String notamedica;
	private String contrasena;
	private float salario;
	//

	public Empleado(String nombre,String apellido1,String apellido2,String cedula,String direccion,String telefono,String notamedia,float salario,String contrase) {
		code++;
		this.codigointerno = code;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cedula = cedula;
		this.setContrasena(contrase);
		this.direccion = direccion;
		this.telefono = telefono;
		this.notamedica = notamedia;
		this.setSalario(salario);
		
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(int codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getNotamedica() {
		return notamedica;
	}

	public void setNotamedica(String notamedica) {
		this.notamedica = notamedica;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	

}

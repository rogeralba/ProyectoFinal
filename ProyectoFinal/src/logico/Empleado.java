package logico;

import java.util.Date;

public abstract class Empleado{
	private static int code = 0;
	private String Nombre;
	private String Apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private int codigointerno;
	private String notamedica;
	private String contrasena;
	private float salario;
	

	public Empleado(String nombre,String apellido,String cedula,String direccion,String telefono,String notamedia,float salario,String contrase) {
		// TODO Auto-generated constructor stubl
		code++;
		this.codigointerno = code;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.cedula = cedula;
		this.setContrasena(contrase);
		this.direccion = direccion;
		this.telefono = telefono;
		this.notamedica = notamedia;
		this.setSalario(salario);
		
	
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
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

}

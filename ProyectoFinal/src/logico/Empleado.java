package logico;

import java.io.Serializable;
import java.util.Date;

public abstract class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String cedula;
	private String direccion;
	private String telefono;
	private String notamedica;
	private String contrasena;
	private float salario;
	private String fNacimiento;
	private String sexo;
	//

	public Empleado(String codigo, String nombre,String apellido1,String apellido2,String cedula,String direccion,String telefono,String notamedia,float salario,String contrase, String fechanacim, String sexo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cedula = cedula;
		this.setContrasena(contrase);
		this.direccion = direccion;
		this.telefono = telefono;
		this.notamedica = notamedia;
		this.setSalario(salario);
		this.fNacimiento = fechanacim;
		this.sexo = sexo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	

}

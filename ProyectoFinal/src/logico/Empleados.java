package logico;

import java.util.Date;

public abstract class Empleados{
	private String Nombre;
	private String Apellido;
	private String cedula;
	private Date fechanacim;
	private String direccion;
	private String telefono;
	private String codigointerno;
	private String notamedica;
	private float salario;
	

	public Empleados(String nombre,String apellido,String cedula,String direccion,String telefono,String codigoint,String notamedia,Date fechan,float salario) {
		// TODO Auto-generated constructor stubl
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.cedula = cedula;
		this.fechanacim = fechan;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigointerno = codigoint;
		this.notamedica = notamedia;
		this.salario = salario;
		
	
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

	public Date getFechanacim() {
		return fechanacim;
	}

	public void setFechanacim(Date fechanacim) {
		this.fechanacim = fechanacim;
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

	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getNotamedica() {
		return notamedica;
	}

	public void setNotamedica(String notamedica) {
		this.notamedica = notamedica;
	}

}

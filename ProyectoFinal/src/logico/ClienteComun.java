package logico;

import java.util.Date;

public class ClienteComun extends Cliente {
	private String apellido1;
	private String cedula;
	private String apellido2;
	private Date fecNac;
	
	public ClienteComun(String cedula, String nombre, String apellido1,String apellido2, String direccion, String telefono, String email, String id, Date fecNac) {
		super(cedula, nombre, direccion, telefono, email);
		this.cedula = cedula;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecNac = fecNac;
	}

	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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


	public Date getFecNac() {
		return fecNac;
	}


	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	
	
	
	
}

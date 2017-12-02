package logico;


public class ClienteComun extends Cliente {
	private String apellido1;
	private String cedula;
	private String apellido2;
	private String fecNac;
	private String sexo;
	
	public ClienteComun(String codCli, String nombre, String apellido1,String apellido2, String direccion, String telefono, String email, String id,String fecNac,String sexo) {
		super(codCli, nombre, direccion, telefono, email);
		this.cedula = id;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecNac = fecNac;
		this.sexo = sexo;
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


	public String getFecNac() {
		return fecNac;
	}


	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	
}

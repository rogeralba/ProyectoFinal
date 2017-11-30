package logico;

public class ClienteComun extends Cliente {
	private String apellido;
	private String cedula;
	
	public ClienteComun(String cedula, String nombre, String apellido, String direccion, String telefono, String email, String id) {
		super(cedula, nombre, direccion, telefono, email);
		this.cedula = cedula;
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
	
}

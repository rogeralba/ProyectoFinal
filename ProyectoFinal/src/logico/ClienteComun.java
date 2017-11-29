package logico;

public class ClienteComun extends Cliente {
	private String id;
	public ClienteComun(String cedula, String nombre, String apellido, String direccion, String telefono, String email, String id) {
		super(cedula, nombre, apellido, direccion, telefono, email);
		this.id = cedula;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}

package logico;

public class ClienteComun extends Cliente {
	private String cedula;
	public ClienteComun(String id, String nombreC, String direccion, String telefono, String cedula) {
		super(id, nombreC, direccion, telefono);
		this.cedula = cedula;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}

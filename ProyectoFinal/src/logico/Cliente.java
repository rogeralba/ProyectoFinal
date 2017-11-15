package logico;

public class Cliente {
	private String id;
	private String nombreC; //nombre Completo
	private String direccion;
	private String telefono;
	
	public Cliente(String id, String nombreC, String direccion, String telefono){
		this.id = id;
		this.nombreC = nombreC;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
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
	
}
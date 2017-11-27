package logico;

public class ClienteEmpresa extends Cliente{
	private String rnc;
	public ClienteEmpresa(String cedula, String nombre, String apellido, String direccion, String telefono, String email ,String rnc) {
		super(cedula, nombre, apellido ,direccion, telefono, email);
		this.rnc = rnc;
	}
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	
	
}

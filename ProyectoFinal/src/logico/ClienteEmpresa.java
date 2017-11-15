package logico;

public class ClienteEmpresa extends Cliente{
	private String rnc;
	public ClienteEmpresa(String id, String nombreC, String direccion, String telefono, String rnc) {
		super(id, nombreC, direccion, telefono);
		this.rnc = rnc;
	}
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	
	
}

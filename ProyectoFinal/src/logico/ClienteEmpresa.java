package logico;

public class ClienteEmpresa extends Cliente{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rnc;
	
	public ClienteEmpresa(String codCli, String nombre, String direccion, String telefono, String email ,String rnc) {
		super(codCli, nombre,direccion, telefono, email);
		this.rnc = rnc;
	}
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	
	
}

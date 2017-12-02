package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	private String codCli;
	protected String nombre;
	protected String direccion;
	protected String telefono;
	protected String email;
	protected ArrayList<Plan> misPlanes;
	
	public Cliente(String codCli, String nombre, String direccion, String telefono, String email){
		this.codCli = codCli;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		misPlanes = new ArrayList<Plan>();
	}
	
	public void insertarPlan(Plan p){
		misPlanes.add(p);
	}
	

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	
}

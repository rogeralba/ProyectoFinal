package logico;

import java.util.ArrayList;

public class Cliente {
	protected String id;
	protected String nombreC; //nombre Completo
	protected String direccion;
	protected String telefono;
	protected ArrayList<Plan> misPlanes;
	
	public Cliente(String id, String nombreC, String direccion, String telefono){
		this.id = id;
		this.nombreC = nombreC;
		this.direccion = direccion;
		this.telefono = telefono;
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

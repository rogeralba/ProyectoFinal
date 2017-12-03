package logico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Plan implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codPlan;
	private String nombre;
	private int impuestos;
	private float tarifaMensual; // Incluye los impuestos
	private int duracionPlan; //En meses
	private Servicio internet;
	private Servicio telefono;
	private Servicio cable;
	private String descripcion;
	private boolean estado;
	private float instalacion;
	//En caso de que alguno de los servicios no se incluya en el plan, su valor será NULL
	
	
	public Plan(String codPlan, String nombre, int duracionPlan, Servicio internet, Servicio telefono, Servicio cable, String descripcion, boolean estado,int impuestos, float instalacion) {
		super();
		this.codPlan = codPlan;
		this.nombre = nombre;
		this.duracionPlan = duracionPlan;
		this.internet = internet;
		this.telefono = telefono;
		this.cable = cable;
		this.descripcion = descripcion;
		this.estado = estado;
		this.instalacion = instalacion;
		this.impuestos = impuestos;
		setTarifa();
	}
	
	public void setTarifa()
	{
		tarifaMensual = 0;
		if(internet != null)
			tarifaMensual += internet.getTarifa();
		if(telefono != null)
			tarifaMensual += telefono.getTarifa();
		if(cable != null)
			tarifaMensual += cable.getTarifa();
	}
	
	public void setImpuestos()
	{
		impuestos = 0;
		if(internet != null)
			impuestos += internet.getImpuestos();
		if(telefono != null)
			tarifaMensual += telefono.getImpuestos();
		if(cable != null)
			tarifaMensual += cable.getImpuestos();
	}
	
	
	
	public String getCodPlan() {
		return codPlan;
	}
	
	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}
	public float getTarifaMensual() {
		return tarifaMensual;
	}
	public void setTarifaMensual(float tarifaMensual) {
		this.tarifaMensual = tarifaMensual;
	}
	public int getDuracionPlan() {
		return duracionPlan;
	}
	public void setDuracionPlan(int duracionPlan) {
		this.duracionPlan = duracionPlan;
	}
	public Servicio getInternet() {
		return internet;
	}
	public void setInternet(Servicio internet) {
		this.internet = internet;
	}
	public Servicio getTelefono() {
		return telefono;
	}
	public void setTelefono(Servicio telefono) {
		this.telefono = telefono;
	}
	public Servicio getCable() {
		return cable;
	}
	public void setCable(Servicio cable) {
		this.cable = cable;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public float getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(float instalacion) {
		this.instalacion = instalacion;
	}
	
	
	
	

}

package logico;

public class Plan {
	private String codPlan;
	private String nombre;
	private float impuestos;
	private float tarifaMensual; // Incluye los impuestos
	private int duracionPlan; //En meses
	private Servicio internet;
	private Servicio telefono;
	private Servicio cable;
	private String descripcion;
	//En caso de que alguno de los servicios no se incluya en el plan, su valor será NULL
	
	
	public Plan(String codPlan, String nombre, float impuestos, float tarifaMensual, int duracionPlan, Servicio internet, Servicio telefono, Servicio cable, String descripcion) {
		super();
		this.codPlan = codPlan;
		this.nombre = nombre;
		this.impuestos = impuestos;
		this.tarifaMensual = tarifaMensual;
		this.duracionPlan = duracionPlan;
		this.internet = internet;
		this.telefono = telefono;
		this.cable = cable;
		this.descripcion = descripcion;
	}
	
	public void setTarifa()
	{
		tarifaMensual = 0;
		if(internet != null)
			tarifaMensual += internet.getTarifa() + internet.getImpuestos();
		if(telefono != null)
			tarifaMensual += telefono.getTarifa() + telefono.getImpuestos();
		if(cable != null)
			tarifaMensual += cable.getTarifa() + cable.getImpuestos();
		
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
	public float getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(float impuestos) {
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
	
	
	
	

}

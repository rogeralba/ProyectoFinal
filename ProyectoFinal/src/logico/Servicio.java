package logico;

public abstract class Servicio {
	private String codServicio;
	private int impuestos;
	private float precioInstalacion;
	private float tarifa;
	
	
	public Servicio(String codServicio, int impuestos, float precioInstalacion, float tarifa) {
		super();
		this.codServicio = codServicio;
		this.impuestos = impuestos;
		this.precioInstalacion = precioInstalacion;
		this.tarifa = tarifa;
	}
	
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}
	public int getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}
	public float getPrecioInstalacion() {
		return precioInstalacion;
	}
	public void setPrecioInstalacion(float precioInstalacion) {
		this.precioInstalacion = precioInstalacion;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
	

}

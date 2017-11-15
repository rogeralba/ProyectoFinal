package logico;

public class Telefono extends Servicio{
	private int minutos;
	private boolean interLlamadas;
	private boolean dobleLinea;
	private boolean desvioLlamadas;
	private boolean minutosAdicionales;
	private AparatoTelefonico equipo;
	
	
	public Telefono(String codServicio, int impuestos, float precioInstalacion,float tarifa, int minutos, boolean interLlamadas, boolean dobleLinea, boolean desvioLlamadas, boolean minutosAdicionales, AparatoTelefonico equipo) {
		super(codServicio, impuestos, precioInstalacion, tarifa);
		this.minutos = minutos;
		this.interLlamadas = interLlamadas;
		this.dobleLinea = dobleLinea;
		this.desvioLlamadas = desvioLlamadas;
		this.minutosAdicionales = minutosAdicionales;
		this.equipo = equipo;
	}
	
	
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public boolean isInterLlamadas() {
		return interLlamadas;
	}
	public void setInterLlamadas(boolean interLlamadas) {
		this.interLlamadas = interLlamadas;
	}
	public boolean isDobleLinea() {
		return dobleLinea;
	}
	public void setDobleLinea(boolean dobleLinea) {
		this.dobleLinea = dobleLinea;
	}
	public boolean isDesvioLlamadas() {
		return desvioLlamadas;
	}
	public void setDesvioLlamadas(boolean desvioLlamadas) {
		this.desvioLlamadas = desvioLlamadas;
	}
	public boolean isMinutosAdicionales() {
		return minutosAdicionales;
	}
	public void setMinutosAdicionales(boolean minutosAdicionales) {
		this.minutosAdicionales = minutosAdicionales;
	}
	public AparatoTelefonico getEquipo() {
		return equipo;
	}
	public void setEquipo(AparatoTelefonico equipo) {
		this.equipo = equipo;
	}
	
	
	
	
	

}

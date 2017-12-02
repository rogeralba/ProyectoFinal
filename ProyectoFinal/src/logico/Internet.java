package logico;

public class Internet extends Servicio{
	private int velocidad;
	private int velSubida;
	
	public Internet(String codServicio, int impuestos, float precioInstalacion, float tarifa, int velocidad, int velSubida) {
		super(codServicio, impuestos, precioInstalacion, tarifa);
		this.velocidad = velocidad;
		this.velSubida = velSubida;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelSubida() {
		return velSubida;
	}
	public void setVelSubida(int velSubida) {
		this.velSubida = velSubida;
	}
	
	
}

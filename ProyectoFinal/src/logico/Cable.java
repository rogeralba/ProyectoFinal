package logico;

import java.util.ArrayList;

public class Cable extends Servicio{
	private int cantCanales;
	private int locales;
	private int internacionales;
	private int cantCanalesHD;
	private ArrayList<Paquete> misPaquetes;
	private boolean cajaHD;
	
	public Cable(String codServicio, int impuestos, float precioInstalacion, float tarifa, int cantCanales, int locales,
			int internacionales, int cantCanalesHD, ArrayList<Paquete> misPaquetes, boolean cajaHD) {
		super(codServicio, impuestos, precioInstalacion, tarifa);
		this.cantCanales = cantCanales;
		this.locales = locales;
		this.internacionales = internacionales;
		this.cantCanalesHD = cantCanalesHD;
		this.misPaquetes = misPaquetes;
		this.cajaHD = cajaHD;
	}
	
	
	public int getCantCanales() {
		return cantCanales;
	}
	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}
	public int getLocales() {
		return locales;
	}
	public void setLocales(int locales) {
		this.locales = locales;
	}
	public int getInternacionales() {
		return internacionales;
	}
	public void setInternacionales(int internacionales) {
		this.internacionales = internacionales;
	}
	public int getCantCanalesHD() {
		return cantCanalesHD;
	}
	public void setCantCanalesHD(int cantCanalesHD) {
		this.cantCanalesHD = cantCanalesHD;
	}
	public ArrayList<Paquete> getMisPaquetes() {
		return misPaquetes;
	}
	public void setMisPaquetes(ArrayList<Paquete> misPaquetes) {
		this.misPaquetes = misPaquetes;
	}
	public boolean isCajaHD() {
		return cajaHD;
	}
	public void setCajaHD(boolean cajaHD) {
		this.cajaHD = cajaHD;
	}
	
	
	
}

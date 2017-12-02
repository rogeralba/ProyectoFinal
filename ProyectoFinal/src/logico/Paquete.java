package logico;

import java.io.Serializable;

public class Paquete implements Serializable{
	private int codPaquete;
	private String nombre;
	private int precio;
	private int cantCanales;
	
	public Paquete(int codPaquete, String nombre, int precio, int cantCanales) {
		super();
		this.codPaquete = codPaquete;
		this.nombre = nombre;
		this.precio = precio;
		this.cantCanales = cantCanales;
	}
	
	public int getCodPaquete() {
		return codPaquete;
	}
	public void setCodPaquete(int codPaquete) {
		this.codPaquete = codPaquete;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantCanales() {
		return cantCanales;
	}
	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}
	
	

}

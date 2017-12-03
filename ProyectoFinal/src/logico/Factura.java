package logico;

import java.io.Serializable;


public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 293750880857425320L;
	private int cod;
	private String fechaEmision;
	private String fechaVencimiento;
	private Cliente cliente;
	private float totalBruto;
	private float totalNeto;
	private boolean vencida = false;
	private estadoFactura estado;
	
	public enum estadoFactura{
		activa, pagada, vencida, generada;
	}
	
	public Factura(String fechaEmision, Cliente cliente){
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
	}


	public Cliente getCliente() {
		return cliente;
	
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;	
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public float getTotalBruto() {
		return totalBruto;
	}


	public void setTotalBruto(float totalBruto) {
		this.totalBruto = totalBruto;
	}


	public float getTotalNeto() {
		return totalNeto;
	}


	public void setTotalNeto(float totalNeto) {
		this.totalNeto = totalNeto;
	}


	public boolean isVencida() {
		return vencida;
	}


	public void setVencida(boolean vencida) {
		this.vencida = vencida;
	}


	public estadoFactura getEstado() {
		return estado;
	}


	public void setEstado(estadoFactura estado) {
		this.estado = estado;
	}
	
	
}

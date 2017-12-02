package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Factura implements Serializable{
	
	private int cod;
	private LocalDate fechaEmision;
	private LocalDate fechaVencimiento;
	private Cliente cliente;
	private float totalBruto;
	private float totalNeto;
	private boolean vencida = false;
	private estadoFactura estado;
	
	public enum estadoFactura{
		activa, pagada, vencida, generada;
	}
	
	public Factura(LocalDate fechaEmision, Cliente cliente){
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fecha) {
		this.fechaEmision = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;	
	}
	
}

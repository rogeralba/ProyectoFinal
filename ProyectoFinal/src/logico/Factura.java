package logico;

import java.time.LocalDateTime;

public class Factura {
	/** https://vimeo.com/199183673 */ 
	//ejemplo de la factura
	
	private LocalDateTime fecha; 
	//Implemento esa clase para manejar la fecha 
	/** http://www.oracle.com/technetwork/es/articles/java/paquete-java-time-2390472-esa.html */
	private Cliente cliente;
	
	public Factura(LocalDateTime fecha, Cliente cliente){
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

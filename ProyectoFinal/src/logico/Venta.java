package logico;

import java.io.Serializable;

public class Venta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codVenta;
	private String cedulaEmpleado;
	private String nombreEmpleado;
	private String cedulaCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private Plan planVendido;
	
	public Venta(String codVenta, String cedulaEmpleado, String nombreEmpleado, String cedulaCliente, String nombreCliente, String apellidoCliente, Plan planVendido) {
		super();
		this.codVenta = codVenta;
		this.cedulaEmpleado = cedulaEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.cedulaCliente = cedulaCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.planVendido = planVendido;
	}
	
	public String getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}
	public String getCedulaEmpleado() {
		return cedulaEmpleado;
	}
	public void setCedulaEmpleado(String cedulaEmpleado) {
		this.cedulaEmpleado = cedulaEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public Plan getPlanVendido() {
		return planVendido;
	}
	public void setPlanVendido(Plan planVendido) {
		this.planVendido = planVendido;
	}
	
	
	
}

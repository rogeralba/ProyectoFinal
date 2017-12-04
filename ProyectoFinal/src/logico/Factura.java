package logico;

import java.io.Serializable;


public class Factura implements Serializable{
	private static final long serialVersionUID = 293750880857425320L;
	private String codFactura;
	private String fechaEmision;
	private String fechaVencimiento;
	private Cliente cliente;
	private float totalBruto;
	private float totalNeto;
	private boolean vencida = false;
	private Plan plan;
	private float mora;
	private int mesesVencidas;
	private estadoFactura estado;
	
	public enum estadoFactura{
		activa, pagada, vencida, generada;
	}
	

	public Factura(String codFactura, String fechaEmision, String fechaVencimiento, Cliente cliente,Plan plan, float totalBruto, float totalNeto, boolean vencida) {
		super();
		this.codFactura = codFactura;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.cliente = cliente;
		this.plan = plan;
		this.totalBruto = totalBruto;
		this.totalNeto = totalNeto;
		this.vencida = vencida;
		this.mora = 0;
		this.mesesVencidas = 0;
	}

	public Cliente getCliente() {
		return cliente;
	
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;	
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


	public boolean getVencida() {
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


	public String getCodFactura() {
		return codFactura;
	}


	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public float getMora() {
		return mora;
	}

	public void setMora(float mora) {
		this.mora = mora;
	}

	public int getMesesVencidas() {
		return mesesVencidas;
	}

	public void setMesesVencidas(int mesesVencidas) {
		this.mesesVencidas = mesesVencidas;
	}
	
	
}

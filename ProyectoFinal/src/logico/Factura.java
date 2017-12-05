package logico;

import java.io.Serializable;


public class Factura implements Serializable{
	private static final long serialVersionUID = 293750880857425320L;
	private String codFactura;
	private String fechaEmision;
	private String fechaVencimiento;
	private String fechaBloqueo;
	private Cliente cliente;
	private float totalBruto;
	private float totalNeto;
	private boolean vencida = false;
	private Plan plan;
	private float mora;
	private int mesesVencidas;
	private estadoFactura estado;
	private boolean pagada;
	private boolean ultimaFactura;
	
	public enum estadoFactura{
		activa, pagada, vencida, generada;
	}
	

	public Factura(String codFactura, String fechaEmision, String fechaVencimiento, String fechaBloqueo, Cliente cliente,Plan plan, float totalBruto, float totalNeto, boolean vencida, boolean ultimaFactura) {
		super();
		this.codFactura = codFactura;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaBloqueo = fechaBloqueo;
		this.cliente = cliente;
		this.plan = plan;
		this.totalBruto = totalBruto;
		this.totalNeto = totalNeto;
		this.vencida = vencida;
		this.mora = 0;
		this.mesesVencidas = 0;
		this.ultimaFactura = ultimaFactura;
		this.pagada = false;
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

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public String getFechaBloqueo() {
		return fechaBloqueo;
	}

	public void setFechaBloqueo(String fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
	}

	public boolean isUltimaFactura() {
		return ultimaFactura;
	}

	public void setUltimaFactura(boolean ultimaFactura) {
		this.ultimaFactura = ultimaFactura;
	}
	
	
}

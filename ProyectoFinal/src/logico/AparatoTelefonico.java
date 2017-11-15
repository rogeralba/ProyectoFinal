package logico;

public class AparatoTelefonico {
	private boolean callerID;
	private boolean inalambrico;
	private int precio;
	
	
	
	public AparatoTelefonico(boolean callerID, boolean inalambrico, int precio) {
		super();
		this.callerID = callerID;
		this.inalambrico = inalambrico;
		this.precio = precio;
	}
	
	public boolean isCallerID() {
		return callerID;
	}
	public void setCallerID(boolean callerID) {
		this.callerID = callerID;
	}
	public boolean isInalambrico() {
		return inalambrico;
	}
	public void setInalambrico(boolean inalambrico) {
		this.inalambrico = inalambrico;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	

}

package logico;

import java.util.ArrayList;
import java.util.Date;


public class ServicioC extends Empleado{

private static final long serialVersionUID = 1L;
private int comisionventas = 0;
private ArrayList<Venta> misVentas;
public ServicioC(String codigo,String nombre, String apellido, String apellido2, String cedula, String direccion, String telefono, String notamedia,
		float salario, String contrase, String nacim, String sexo,String email) {
	super(codigo,nombre, apellido,apellido2, cedula, direccion, telefono, notamedia, salario, contrase,nacim,sexo,email);
this.misVentas = new ArrayList<>();

}

public int getComisionventas() {
	return comisionventas;
}
public void setComisionventas(int comisionventas) {
	this.comisionventas = comisionventas;
}
public ArrayList<Venta> getMisVentas() {
	return misVentas;
}
public void setMisVentas(ArrayList<Venta> misVentas) {
	this.misVentas = misVentas;
}
	

}

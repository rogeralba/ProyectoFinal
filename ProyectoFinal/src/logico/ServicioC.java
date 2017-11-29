package logico;

import java.util.ArrayList;
import java.util.Date;


public class ServicioC extends Empleados{
private int comisionventas = 0;
private ArrayList<Plan> misVentas;
public ServicioC(String nombre, String apellido, String cedula, String direccion, String telefono, String notamedia,
		float salario, String contrase, int comisionventas, ArrayList<Plan> misVentas) {
	super(nombre, apellido, cedula, direccion, telefono, notamedia, salario, contrase);
	this.comisionventas = comisionventas;
	this.misVentas = misVentas;
}
	

}

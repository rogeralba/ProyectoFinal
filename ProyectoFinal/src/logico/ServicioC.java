package logico;

import java.util.ArrayList;
import java.util.Date;


public class ServicioC extends Empleado{
private int comisionventas = 0;
private ArrayList<Plan> misVentas;
public ServicioC(String nombre, String apellido, String apellido2, String cedula, String direccion, String telefono, String notamedia,
		float salario, String contrase, String nacim) {
	super(nombre, apellido,apellido2, cedula, direccion, telefono, notamedia, salario, contrase,nacim);
this.misVentas = new ArrayList<>();

}
	

}

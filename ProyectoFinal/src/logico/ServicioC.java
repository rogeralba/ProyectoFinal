package logico;

import java.util.ArrayList;
import java.util.Date;


public class ServicioC extends Empleados{
private int comisionventas = 0;
private ArrayList<Plan> misVentas;
	public ServicioC(String nombre,String apellido,String cedula,String direccion,String telefono,String codigoint,String notamedia,Date fechan,float salario) {
		super(nombre, apellido, cedula, direccion, telefono, codigoint, notamedia, fechan, salario);
		
		// TODO Auto-generated constructor stub
	}

}

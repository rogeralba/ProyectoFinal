package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Empleados{

	private ArrayList<Soporte> trabajosasignados;
	public Tecnico(String nombre,String apellido,String cedula,String direccion,String telefono,String codigoint,String notamedia,Date fechan,float salario) {
		super(nombre,apellido,cedula, direccion, telefono, codigoint, notamedia,fechan,salario);
		
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Soporte> getTrabajosasignados() {
		return trabajosasignados;
	}
	public void setTrabajosasignados(ArrayList<Soporte> trabajosasignados) {
		this.trabajosasignados = trabajosasignados;
	}

}

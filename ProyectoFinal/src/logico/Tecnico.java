package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Empleados{

	private ArrayList<Soporte> trabajosasignados;
	
	public Tecnico(String nombre, String apellido, String cedula, String direccion, String telefono, String notamedia,
			float salario, String contrase, ArrayList<Soporte> trabajosasignados) {
		super(nombre, apellido, cedula, direccion, telefono, notamedia, salario, contrase);
		this.trabajosasignados = trabajosasignados;
	}
	public ArrayList<Soporte> getTrabajosasignados() {
		return trabajosasignados;
	}
	public void setTrabajosasignados(ArrayList<Soporte> trabajosasignados) {
		this.trabajosasignados = trabajosasignados;
	}

}

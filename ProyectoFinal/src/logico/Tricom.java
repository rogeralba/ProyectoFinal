package logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Tricom {
	private ArrayList<Empleados> misEmpleados;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Servicio> misServicios;
	private static Tricom tricom;
	
	private Tricom()
	{
		super();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
	}
	
	public static Tricom getInstance()
	{
		if(tricom == null)
		   tricom = new Tricom();
		
		return tricom;
	}
	
	public void saveData() throws IOException
	{
		FileOutputStream planStream = new FileOutputStream("Planes.dat");
		ObjectOutputStream oos = new ObjectOutputStream(planStream);

		oos.writeInt(misPlanes.size());
		for(int i=0;i<misPlanes.size();i++)
		{
			oos.writeObject(misPlanes.get(i));
		}
		
		planStream.close();//Fichero
	}
	
	public void readData() throws IOException, ClassNotFoundException
	{
		int cantPlanes;
		FileInputStream planStream = new FileInputStream("Planes.dat");
		ObjectInputStream ois = new ObjectInputStream(planStream);
		
		cantPlanes = ois.readInt();
		
		for(int i=0; i < cantPlanes; i++)
		{
			misPlanes.add(i, (Plan)ois.readObject());	
		}
		planStream.close();
	}
	
	
	public void eliminarPlan(String codPlan)
	{
		int i = 0;
		boolean encontrado = false;
		while(i < misPlanes.size() && encontrado == false)
		{
			if(misPlanes.get(i).getCodPlan().equalsIgnoreCase(codPlan))
			{
				misPlanes.remove(i);
				encontrado = true;
			}
			i++;
		}
	}
	
	public void eliminarServicio(String codServicio)
	{
		int i = 0;
		boolean encontrado = false;
		while(i < misServicios.size() && encontrado == false)
		{
			if(misServicios.get(i).getCodServicio().equalsIgnoreCase(codServicio))
			{
				misServicios.remove(i);
				encontrado = true;
			}
			i++;
		}
		
	}
	

	
	public void ingresarPlan(Plan plan) throws IOException
	{
		misPlanes.add(plan);
		saveData();
	}
	
	
	public Plan buscarPlan(String codPlan)
	{
		boolean encontrado = false;
		int i = 0;
		Plan plan = null;
		
		while(i < misPlanes.size() && encontrado == false)
		{
			if(misPlanes.get(i).getCodPlan().equalsIgnoreCase(codPlan))
			{
				plan = misPlanes.get(i);
				encontrado = true;
			}
			i++;
		}
		return plan;
	}
	
	public void ingresarCliente(Cliente c){
		misClientes.add(c);
	}
	
	public Cliente buscarCliente(String id){
		boolean encontrado = false;
		int i = 0;
		Cliente c = null;
		while(i < misClientes.size() && !encontrado){
			if(misClientes.get(i).getId().equalsIgnoreCase(id)){
				c = misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}
	
	public boolean validarCedula(String cedula)
	{
		int i=0;
		boolean resultado = false;
		if(cedula.length() != 13 || cedula.charAt(3) != '-' || cedula.charAt(11) != '-')
		{
			return true;
		}
		while(i < cedula.length() && resultado == false)
		{
			if((int)cedula.charAt(i) >= 48 && (int)cedula.charAt(i) <= 57) //Si es un numero
			{
			    if(Integer.parseInt(cedula.charAt(i)+"") < 0 || Integer.parseInt(cedula.charAt(i)+"") > 9)//Si no se encuentra en ese rango
			    {
			    	resultado = true;
			    }
			}else if(i == 3 || i == 11)
			{
				resultado = false;
			}
			else
			{
				resultado = true;
			}
		    i++;
		}
		return resultado;
	}
	
	
	public ArrayList<Empleados> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleados> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	//Roger creacion y manejo de usuarios(Empleados)
	
public void crearempleado(Empleados emp){
	misEmpleados.add(emp);
	
}
}

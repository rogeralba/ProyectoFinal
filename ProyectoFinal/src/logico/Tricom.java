package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Tricom {
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Servicio> misServicios;
	private static Tricom tricom = null;
	private Empleado actual;
	
	public Tricom()
	{
		super();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		
		//Creacion de usuario inicial.
		if(misEmpleados.size() == 0){
		Administrativo adm = new Administrativo("admin", "el", "boss", "000-0000000-0", "Tricom SA HQ", "111", "Fallecido", 10, "000");
		misEmpleados.add(adm);
	}
	}
	
	public static Tricom getInstance()
	{
		if(tricom == null)
		   tricom = new Tricom();
		
		return tricom;
	}
	/*
	public void saveData() throws IOException
	{
		String dirCli = "./Data/Clientes.dat";
		String dirCuen = "./Data/Empleados.dat";
	
		FileOutputStream cliStream;
		ObjectOutputStream oos1;
		
		FileOutputStream empStream;
		ObjectOutputStream oos2;
		
		try {
			cliStream = new FileOutputStream(dirCli);
			oos1 = new ObjectOutputStream(cliStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirCli);
			archivo.createNewFile();
			cliStream = new FileOutputStream(dirCli);
			oos1 = new ObjectOutputStream(cliStream);
		}
		
		try {
			empStream = new FileOutputStream(dirCuen);
			oos2 = new ObjectOutputStream(empStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirCuen);
			archivo.createNewFile();
			empStream = new FileOutputStream(dirCuen);
			oos2 = new ObjectOutputStream(empStream);
		}
				
		oos1.writeInt(misClientes.size());
		oos2.writeInt(misEmpleados.size());
		
		for(Cliente cli: misClientes)
		{
			oos1.writeObject(cli);
		}
		
		for(Empleado emp: misEmpleados)
		{
			oos2.writeObject(emp);
		}
		cliStream.close();
		empStream.close();
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
		
		//Clientes
		int cantClientes;
		FileInputStream clienteStream = new FileInputStream("Clientes.dat");
		ObjectInputStream clo = new ObjectInputStream(clienteStream);
		
		cantClientes = clo.readInt();
		
		for(int i=0; i < cantClientes; i++)
		{
			misClientes.add(i, (Cliente)clo.readObject());	
		}
		clienteStream.close();
		
		//Empleados
		
		int cantEmpleados;
		FileInputStream empleadoSteam = new FileInputStream("Empleado.dat");
		ObjectInputStream empo = new ObjectInputStream(empleadoSteam);
		
		cantEmpleados = empo.readInt();
		
		for(int i=0; i < cantEmpleados; i++)
		{
			misEmpleados.add(i, (Empleado)empo.readObject());	
		}
		empleadoSteam.close();
	}
	*/
	
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
		//saveData();
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
			if(misClientes.get(i) instanceof ClienteComun)
			{
			    if(((ClienteComun)misClientes.get(i)).getCedula().equalsIgnoreCase(id)){
				   c = misClientes.get(i);
				   encontrado = true;
			    }
			}
			if(misClientes.get(i) instanceof ClienteEmpresa)
			{
			    if(((ClienteEmpresa)misClientes.get(i)).getRnc().equalsIgnoreCase(id)){
				   c = misClientes.get(i);
				   encontrado = true;
			    }
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
	
	
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	//Roger creacion y manejo de usuarios(Empleados)
	
public void crearempleado(Empleado emp){
	misEmpleados.add(emp);
	
}

public Empleado getActual() {
	return actual;
}

public void setActual(Empleado actual) {
	this.actual = actual;
}

public ArrayList<Cliente> getMisClientes() {
	return misClientes;
}

public void setMisClientes(ArrayList<Cliente> misClientes) {
	this.misClientes = misClientes;
}

public ArrayList<Servicio> getMisServicios() {
	return misServicios;
}

public void setMisServicios(ArrayList<Servicio> misServicios) {
	this.misServicios = misServicios;
}

public static Tricom getTricom() {
	return tricom;
}

public static void setTricom(Tricom tricom) {
	Tricom.tricom = tricom;
}
}

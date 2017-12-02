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
	private ArrayList<Factura> misFacturas;
	private ArrayList<Integer> cantRegistros; //Contiene la cantidad de registros que se han creado de cada clase.
	private static Tricom tricom = null;
	
	private Empleado actual;
	
	public Tricom()
	{
		super();
		this.misClientes = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misServicios = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.cantRegistros = new ArrayList<>(); //0-Clientes 1-Empleados 2-Planes 3-Servicios 4-Facturas
		for(int i=0;i<5;i++)
			cantRegistros.add(0);
	}
	
	public static Tricom getInstance()
	{
		if(tricom == null)
		   tricom = new Tricom();
		
		return tricom;
	}
	
	public void saveData() throws IOException
	{
		String dirCli = "./Data/Clientes.dat";
		String dirEmp = "./Data/Empleados.dat";
		String dirPlan = "./Data/Planes.dat";
		String dirSer = "./Data/Servicios.dat";
		String dirFac = "./Data/Facturas.dat";
		String dirReg = "./Data/totalReg.dat";
	
		FileOutputStream cliStream;
		ObjectOutputStream oos1;
		
		FileOutputStream empStream;
		ObjectOutputStream oos2;
		
		FileOutputStream planStream;
		ObjectOutputStream oos3;
		
		FileOutputStream serStream;
		ObjectOutputStream oos4;
		
		FileOutputStream facStream;
		ObjectOutputStream oos5;
		
		FileOutputStream regStream;
		ObjectOutputStream oos6;
		
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
			empStream = new FileOutputStream(dirEmp);
			oos2 = new ObjectOutputStream(empStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirEmp);
			archivo.createNewFile();
			empStream = new FileOutputStream(dirEmp);
			oos2 = new ObjectOutputStream(empStream);
		}
		
		try {
			planStream = new FileOutputStream(dirPlan);
			oos3 = new ObjectOutputStream(planStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirPlan);
			archivo.createNewFile();
			planStream = new FileOutputStream(dirPlan);
			oos3 = new ObjectOutputStream(planStream);
		}
		
		try {
			serStream = new FileOutputStream(dirSer);
			oos4 = new ObjectOutputStream(serStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirSer);
			archivo.createNewFile();
			serStream = new FileOutputStream(dirSer);
			oos4 = new ObjectOutputStream(serStream);
		}
		
		try {
			facStream = new FileOutputStream(dirFac);
			oos5 = new ObjectOutputStream(facStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirFac);
			archivo.createNewFile();
			facStream = new FileOutputStream(dirFac);
			oos5 = new ObjectOutputStream(facStream);
		}
		
		try {
			regStream = new FileOutputStream(dirReg);
			oos6 = new ObjectOutputStream(regStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirReg);
			archivo.createNewFile();
			regStream = new FileOutputStream(dirReg);
			oos6 = new ObjectOutputStream(regStream);
		}
				
		oos1.writeInt(misClientes.size());
		oos2.writeInt(misEmpleados.size());
		oos3.writeInt(misPlanes.size());
		oos4.writeInt(misServicios.size());
		oos5.writeInt(misFacturas.size());
		oos6.writeInt(cantRegistros.size());
		
		for(Cliente cli: misClientes)
			oos1.writeObject(cli);
		
		for(Empleado emp: misEmpleados)
			oos2.writeObject(emp);
		
		for(Plan plan: misPlanes)
			oos3.writeObject(plan);
		
		for(Servicio ser: misServicios)
			oos4.writeObject(ser);
		
		for(Factura fac: misFacturas)
			oos5.writeObject(fac);
		
		for(Integer cant: cantRegistros)
			oos6.writeObject(cant);
		
		cliStream.close();
		empStream.close();
		planStream.close();
		serStream.close();
		facStream.close();
		regStream.close();
	}
	
	public void readData() throws IOException, ClassNotFoundException
	{
		String dirCli = "./Data/Clientes.dat";
		String dirEmp = "./Data/Empleados.dat";
		String dirPlan = "./Data/Planes.dat";
		String dirSer = "./Data/Servicios.dat";
		String dirFac = "./Data/Facturas.dat";
		String dirReg = "./Data/totalReg.dat";
		
		//Clientes
		int cant = 0;
		FileInputStream clienteStream;
			ObjectInputStream ois1;
			try{
				clienteStream = new FileInputStream(dirCli);
				ois1 = new ObjectInputStream(clienteStream);
				cant = ois1.readInt();
				for(int i=0; i < cant; i++)
					misClientes.add(i, (Cliente)ois1.readObject());	
				clienteStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirCli);
				archivo.createNewFile();
			}
		
		
		//Empleados

			FileInputStream empleadoStream;
			ObjectInputStream ois2;
			try{
				empleadoStream = new FileInputStream(dirEmp);
				ois2 = new ObjectInputStream(empleadoStream);
				cant = ois2.readInt();
				for(int i=0; i < cant; i++)
					misEmpleados.add(i, (Empleado)ois2.readObject());	
				empleadoStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirEmp);
				archivo.createNewFile();
			}
		
		
		//Planes
	
			FileInputStream planStream;
			ObjectInputStream ois3;
			try{
				planStream = new FileInputStream(dirPlan);
				ois3 = new ObjectInputStream(planStream);
				cant = ois3.readInt();
				for(int i=0; i < cant; i++)
					misPlanes.add(i, (Plan)ois3.readObject());	
				planStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirPlan);
				archivo.createNewFile();
			}
		
		//Servicios	
			FileInputStream serStream;
			ObjectInputStream ois4;
			try{
				serStream = new FileInputStream(dirSer);
				ois4 = new ObjectInputStream(serStream);
				cant = ois4.readInt();
				for(int i=0; i < cant; i++)
					misServicios.add(i, (Servicio)ois4.readObject());	
				serStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirSer);
				archivo.createNewFile();
			}	
		
		//Facturas
			FileInputStream facStream;
			ObjectInputStream ois5;
			try{
				facStream = new FileInputStream(dirFac);
				ois5 = new ObjectInputStream(facStream);
				cant = ois5.readInt();
				for(int i=0; i < cant; i++)
					misFacturas.add(i, (Factura)ois5.readObject());	
				facStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirFac);
				archivo.createNewFile();
			}
			
		//Registros totales
	
			FileInputStream regStream;
			ObjectInputStream ois6;
			try{
				regStream = new FileInputStream(dirReg);
				ois6 = new ObjectInputStream(regStream);	
				cant = ois6.readInt();
				for(int i=0; i < cant; i++)
					cantRegistros.add(i, (Integer)ois6.readObject());	
				regStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirReg);
				archivo.createNewFile();
			}
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

public ArrayList<Factura> getMisFacturas() {
	return misFacturas;
}

public void setMisFacturas(ArrayList<Factura> misFacturas) {
	this.misFacturas = misFacturas;
}

public ArrayList<Integer> getCantRegistros() {
	return cantRegistros;
}

public void setCantRegistros(ArrayList<Integer> cantRegistros) {
	this.cantRegistros = cantRegistros;
}
}

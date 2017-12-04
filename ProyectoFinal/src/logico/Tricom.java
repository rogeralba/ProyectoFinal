package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.w3c.dom.CDATASection;

public class Tricom {
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Servicio> misServicios;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Integer> cantRegistros; //Contiene la cantidad de registros que se han creado de cada clase.
	private ArrayList<Venta> misVentas;
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
		this.cantRegistros = new ArrayList<>(); //0-Clientes 1-Empleados 2-Planes 3-Servicios 4-Facturas 5-Ventas
		this.misVentas = new ArrayList<>();
		for(int i=0;i<6;i++)
			cantRegistros.add(i,0);
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
		String dirVen = "./Data/Ventas.dat";
	
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
		
		FileOutputStream venStream;
		ObjectOutputStream oos7;
		
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
		
		try {
			venStream = new FileOutputStream(dirVen);
			oos7 = new ObjectOutputStream(venStream);
		} catch (FileNotFoundException e) { //Si el fichero no existe
			File archivo = new File(dirVen);
			archivo.createNewFile();
			venStream = new FileOutputStream(dirVen);
			oos7 = new ObjectOutputStream(venStream);
		}
		
		
				
		oos1.writeInt(misClientes.size());
		oos2.writeInt(misEmpleados.size());
		oos3.writeInt(misPlanes.size());
		oos4.writeInt(misServicios.size());
		oos5.writeInt(misFacturas.size());
		oos6.writeInt(cantRegistros.size());
		oos7.writeInt(misVentas.size());
		
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
		
		for(Venta cant: misVentas)
			oos7.writeObject(cant);
		
		cliStream.close();
		empStream.close();
		planStream.close();
		serStream.close();
		facStream.close();
		regStream.close();
		venStream.close();
	}
	
	public void readData() throws IOException, ClassNotFoundException
	{
		String dirCli = "./Data/Clientes.dat";
		String dirEmp = "./Data/Empleados.dat";
		String dirPlan = "./Data/Planes.dat";
		String dirSer = "./Data/Servicios.dat";
		String dirFac = "./Data/Facturas.dat";
		String dirReg = "./Data/totalReg.dat";
		String dirVen = "./Data/Ventas.dat";
		
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
				for(int i=0;i<6;i++)
					cantRegistros.add(i,0);
				for(int i=0; i < 6; i++)
					cantRegistros.add(i, (Integer)ois6.readObject());	
				regStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirReg);
				archivo.createNewFile();
			}
			
		//Ventas
			
			FileInputStream venStream;
			ObjectInputStream ois7;
			try{
				venStream = new FileInputStream(dirVen);
				ois7 = new ObjectInputStream(venStream);	
				cant = ois7.readInt();
				for(int i=0; i < cant; i++)
					misVentas.add(i, (Venta)ois7.readObject());	
				venStream.close();
			}catch(IOException e){
				cant = 0;
				File archivo = new File(dirVen);
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
	public void eliminarCliente(String codCli)
	{
		int i = 0;
		boolean encontrado = false;
		while(i < misClientes.size() && encontrado == false)
		{
			if(misClientes.get(i).getCodCli().equalsIgnoreCase(codCli))
			{
				misClientes.remove(i);
				encontrado = true;
			}
			i++;
		}
	}
	public void eliminarEmpleado(String codEmp)
	{
		int i = 0;
		boolean encontrado = false;
		while(i < misEmpleados.size() && encontrado == false)
		{
			if(misEmpleados.get(i).getCodigo().equalsIgnoreCase(codEmp))
			{
				misEmpleados.remove(i);
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
	public Cliente buscarClientecode(String codCli)
	{
		int i = 0;
		boolean encontrado = false;
		Cliente cliente = null;
		while(i < misClientes.size() && encontrado == false)
		{
			if(misClientes.get(i).getCodCli().equalsIgnoreCase(codCli))
			{
				encontrado = true;
				cliente = misClientes.get(i);
			}
			i++;
		}
		return cliente;
	}
	
	public Empleado buscarEmpcode(String codEmp)
	{
		int i = 0;
		boolean encontrado = false;
		Empleado empleado = null;
		while(i < misEmpleados.size() && encontrado == false)
		{
			if(misEmpleados.get(i).getCodigo().equalsIgnoreCase(codEmp))
			{
				empleado = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return empleado;
	}
	
	public Empleado buscarEmpleado(String cedula)
	{
		int i = 0;
		boolean encontrado = false;
		Empleado empleado = null;
		while(i < misEmpleados.size() && encontrado == false)
		{
			if(misEmpleados.get(i).getCedula().equalsIgnoreCase(cedula))
			{
				empleado = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return empleado;
	}
	
	public Plan buscarPlancode(String codPlan)
	{
		int i = 0;
		boolean encontrado = false;
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
	
	
	public Servicio buscarServcode(String codSer)
	{
		int i = 0;
		boolean encontrado = false;
		Servicio servicio = null;
		while(i < misServicios.size() && encontrado == false)
		{
			if(misServicios.get(i).getCodServicio().equalsIgnoreCase(codSer))
			{
				servicio = misServicios.get(i);
				encontrado = true;
			}
			i++;
		}
		return servicio;
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
	
	public int indexCLiente(String id){
		int index = -1;
		int i = 0;
		
		while(i < misClientes.size() && index == -1 ){
			if(misClientes.get(i) instanceof ClienteComun)
			{
			    if(((ClienteComun)misClientes.get(i)).getCedula().equalsIgnoreCase(id)){
				   index = i;
			    }
			}
			if(misClientes.get(i) instanceof ClienteEmpresa)
			{
			    if(((ClienteEmpresa)misClientes.get(i)).getRnc().equalsIgnoreCase(id)){
				   index = i;
			    }
			}
			i++;
		}
		return index;
	}
	
	public int indexEmpleado(String cedula)
	{
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		Empleado empleado = null;
		while(i < misEmpleados.size() && index == -1)
		{
			if(misEmpleados.get(i).getCodigo().equalsIgnoreCase(cedula))
			{
				index = i;
			}
			i++;
		}
		return index;
	}
	
	
	private Factura buscarFactura(String cod) {
		boolean encontrado = false;
		int i = 0;
		Factura f = null;
		while(i < misFacturas.size() && !encontrado){
			if(misFacturas.get(i).getCodFactura().equalsIgnoreCase(cod))
			{
			   f = misFacturas.get(i);
			   encontrado = true;
			}
			i++;
		}
		return f;
	}
	
	//Facturar
	public void Facturar(String cod){
		Factura f = buscarFactura(cod);
		Calendar fecha = new GregorianCalendar();
		String dir = "./Data/Factura.txt";
		FileWriter file = null;
		PrintWriter pw = null;
		
		try {
			file = new FileWriter(dir);
			pw = new PrintWriter(file);	
			
			pw.println("Codigo de la factura: "+f.getCodFactura()+"                        "+"Fecha de Emision: "+fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+"                     "+"Fecha de Vencimiento: "+f.getFechaVencimiento());            
			pw.println("Cliente: "+f.getCliente().getNombre()+"                     "+"Telefono: "+f.getCliente().getTelefono());
			pw.println("Direccion: "+f.getCliente().getDireccion());
			pw.println("Estado: "+f.getEstado());
			pw.println("Total Bruto: "+f.getTotalBruto()+"                          "+"Total Neto: "+f.getTotalNeto());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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

	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}

	public void setMisVentas(ArrayList<Venta> misVentas) {
		this.misVentas = misVentas;
	}
}

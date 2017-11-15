package logico;

import java.util.ArrayList;

public class Tricom {
	private ArrayList<Empleados> misEmpleados;
	private ArrayList<Plan> misPlanes;
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
	
	private Plan buscarPlan(String codPlan)
	{
		boolean encontrado = false;
		int i = 0;
		Plan plan = null;
		
		while(i < misPlanes.size() && encontrado == false)
		{
			if(misPlanes.get(i).getCodPlan().equalsIgnoreCase(codPlan))
			{
				plan = misPlanes.get(i);
			}
			i++;
		}
		return plan;
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
	
}

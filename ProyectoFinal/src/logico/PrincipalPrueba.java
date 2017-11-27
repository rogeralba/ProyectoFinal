package logico;

import java.io.IOException;

public class PrincipalPrueba {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Internet interSer = new Internet("1",88,200,500,4,400,4);
		
		
		Plan nuevoPlan = new Plan("1","Internet-Medio",18,interSer,null,null,"Ejemplo de una descripción.");
		Tricom.getInstance().ingresarPlan(nuevoPlan);
		

	}

}

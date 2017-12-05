package logico;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ControlarFacturas extends Thread{
	
	public void run()
	{
		int infinito = 0;
		Calendar c1 = new GregorianCalendar();
		String fechaActual = "";
		String fechaFactura = "";
		c1.get(Calendar.MONTH);
		Cliente cliente = null;
		String id = "";
		int index = -1;
		int tamano;
		Factura factura = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1;
		Date fecha2;
		
		while(infinito == 0)
		{
			c1 = new GregorianCalendar();
			fechaActual = new String(c1.get(Calendar.DATE) + "/" + (c1.get(Calendar.MONTH)+1) + "/" + c1.get(Calendar.YEAR));
			
			//Generar factura mes siguiente
			for(int i = 0; i < Tricom.getInstance().getMisFacturas().size(); i++)
			{
				factura = Tricom.getInstance().getMisFacturas().get(i);
				fechaFactura = new String(factura.getFechaVencimiento());
				fecha1 = sdf.parse(fechaActual, new ParsePosition(0));
				fecha2 = sdf.parse(fechaFactura, new ParsePosition(0));
				
				if((fecha2.before(fecha1) || fecha2.equals(fecha1)) && factura.isUltimaFactura() == true)
				{
					Tricom.getInstance().getMisFacturas().get(i).setUltimaFactura(false);
					cliente = factura.getCliente();
					if(cliente instanceof ClienteComun)
						id = new String(((ClienteComun)cliente).getCedula());
					if(cliente instanceof ClienteEmpresa)
						id = new String(((ClienteEmpresa)cliente).getRnc());
					
					index = Tricom.getInstance().indexCLiente(id);
					tamano = Tricom.getInstance().getMisClientes().get(index).getMisFacturas().size();
					for(int x = 0; x < tamano;x++)
					{
						if(Tricom.getInstance().getMisClientes().get(index).getMisFacturas().get(x).getCodFactura().equalsIgnoreCase(factura.getCodFactura()))
						{
							Tricom.getInstance().getMisClientes().get(index).getMisFacturas().get(x).setUltimaFactura(false);
							Tricom.getInstance().generarFactura(cliente, factura.getPlan());
						}
					}
				}
				
			}
			
			
			
			//Facturas vencidas
			for(int i=0; i < Tricom.getInstance().getMisFacturas().size(); i++)
			{
				factura = Tricom.getInstance().getMisFacturas().get(i);
				fechaFactura = new String(factura.getFechaVencimiento());
				fecha1 = sdf.parse(fechaActual, new ParsePosition(0));
				fecha2 = sdf.parse(fechaFactura, new ParsePosition(0));
				if(fecha2.before(fecha1) && factura.getVencida()==false)
				{
					Tricom.getInstance().getMisFacturas().get(i).setVencida(true);	
					Tricom.getInstance().getMisFacturas().get(i).setMora(200);
					cliente = factura.getCliente();
					if(cliente instanceof ClienteComun)
						id = new String(((ClienteComun)cliente).getCedula());
					if(cliente instanceof ClienteEmpresa)
						id = new String(((ClienteEmpresa)cliente).getRnc());
					
					index = Tricom.getInstance().indexCLiente(id);
					tamano = Tricom.getInstance().getMisClientes().get(index).getMisFacturas().size();
					for(int x = 0; x < tamano;x++)
					{
						if(Tricom.getInstance().getMisClientes().get(index).getMisFacturas().get(x).getCodFactura().equalsIgnoreCase(factura.getCodFactura()))
						{
							Tricom.getInstance().getMisClientes().get(index).getMisFacturas().get(x).setVencida(true);
							Tricom.getInstance().getMisClientes().get(index).getMisFacturas().get(x).setMora(200);
						}
					}
					
				}
			}
			esperarSegundos(5);
		}
	}
	
	private void esperarSegundos(Integer prod) {
		try {
			Thread.sleep(prod*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}








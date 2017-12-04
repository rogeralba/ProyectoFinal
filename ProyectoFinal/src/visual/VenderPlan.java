package visual;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Cable;
import logico.Cliente;
import logico.ClienteComun;
import logico.ClienteEmpresa;
import logico.Empleado;
import logico.Factura;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;
import logico.Tricom;
import logico.Venta;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

public class VenderPlan extends JDialog {
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtTarifa;
	private JTextField txtImpuestos;
	private JTextField txtInstalacion;
	private JTextField txtMinutos;
	private JTextField txtVelocidad;
	private JTextField txtSubida;
	private JTextField txtTelPrecio;
	private JTextField txtTelImpuestos;
	private JTextField txtInterPrecio;
	private JTextField txtInterImpuestos;
	private JTextField txtCanales;
	private JTextField txtLocales;
	private JTextField txtInternacionales;
	private JTextField txtCablePrecio;
	private JTextField txtCableImpuestos;
	private JRadioButton rdbDesvioSi;
	private JRadioButton rdbDesvioNo;
	private JRadioButton rdbDobleLineaNo;
	private JRadioButton rdbDobleLineaSi;
	private JRadioButton rdbMinAdNo;
	private JRadioButton rdbMinAdSi; 
	private JRadioButton rdbLlamIntNo;
	private JRadioButton rdbLlamIntSi;
	private JButton btnBuscar;
	private JComboBox cbxPlanes;
	private JComboBox cbxDuracion;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenderPlan dialog = new VenderPlan();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public VenderPlan(Cliente cliente, int accion) {//Accion = 1 Si es un cliente nuevo. Accion = 2 si es un cliente ya registrado
		
		
		
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Vender Planes");
		setForeground(SystemColor.textText);
		getContentPane().setForeground(SystemColor.text);
		setResizable(false);
		setBackground(SystemColor.menu);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula = txtCedula.getText().toString();
				Cliente cli = Tricom.getInstance().buscarCliente(cedula);
				
				int index = cbxPlanes.getSelectedIndex();
				Plan plan = Tricom.getInstance().getMisPlanes().get(index);
				int duracion = Integer.parseInt(cbxDuracion.getSelectedItem().toString());
				boolean desvio = rdbDesvioSi.isSelected();
				boolean dobleLinea = rdbDobleLineaSi.isSelected();
				boolean minutosAd = rdbMinAdSi.isSelected();
				boolean llamInt = rdbLlamIntSi.isSelected();
				int dia,mes,agno;
				
				if(plan.getTelefono() != null)
				{
					((Telefono)plan.getTelefono()).setDesvioLlamadas(desvio);
					((Telefono)plan.getTelefono()).setDobleLinea(dobleLinea);
					((Telefono)plan.getTelefono()).setMinutosAdicionales(minutosAd);
					((Telefono)plan.getTelefono()).setInterLlamadas(llamInt);
				}
				
				String codVenta = "codVenta-"+(Tricom.getInstance().getCantRegistros().get(5)+1);
				String codFactura = "codFact-"+(Tricom.getInstance().getCantRegistros().get(4)+1);
				Empleado emp = Tricom.getInstance().getActual();
				String id = null;
				String apellido = null;
				int cant;
				
				Calendar c1 = new GregorianCalendar();
				String fecha = c1.get(Calendar.DATE) + "/" + (c1.get(Calendar.MONTH)+1) + "/" + c1.get(Calendar.YEAR);
				
				if(accion == 1) //Cliente nuevo
				{
					if(cliente instanceof ClienteComun)
					{
						id = new String(((ClienteComun)cliente).getCedula());
						apellido = new String(((ClienteComun)cliente).getApellido1());
					}
					else
					{
						id = new String(((ClienteEmpresa)cliente).getRnc());
						apellido = new String("N/A");
					}
					
					
					dia = c1.get(Calendar.DATE);
					mes = (c1.get(Calendar.YEAR)+1);
					agno = c1.get(Calendar.YEAR);
					if(mes == 13)
					{
						mes = 1;
						agno += 1;
					}
					if(dia > 28 && mes == 2)
						dia = 1;

					String fechaVen = dia + "/" + mes + "/" + fecha;
					Factura factura = new Factura(codFactura,fecha,fechaVen,cliente,plan,plan.getTarifaMensual(),plan.getTarifaMensual(),false);
					Tricom.getInstance().getMisFacturas().add(factura);
					cant = Tricom.getInstance().getCantRegistros().get(4);
					Tricom.getInstance().getCantRegistros().add(4, (cant+1));
					
					
					cliente.getMisFacturas().add(factura);
					cliente.getMisPlanes().add(plan);
					Tricom.getInstance().getMisClientes().add(cliente);
					cant = Tricom.getInstance().getCantRegistros().get(0);
					Tricom.getInstance().getCantRegistros().add(0, (cant+1));
					
					Venta venta = new Venta(codVenta,emp.getCedula(),emp.getNombre(),id,cliente.getNombre(),apellido,fecha,plan);
					Tricom.getInstance().getMisVentas().add(venta);
					cant = Tricom.getInstance().getCantRegistros().get(5);
					Tricom.getInstance().getCantRegistros().add(5, (cant+1));
					
					JOptionPane.showMessageDialog(null, "Registro satisfactorio");
					dispose();
				}else if(accion == 2 && cli != null)
				{
					if(cli instanceof ClienteComun)
					{
						id = new String(((ClienteComun)cli).getCedula());
						apellido = new String(((ClienteComun)cli).getApellido1());
					}
					else
					{
						id = new String(((ClienteEmpresa)cli).getRnc());
						apellido = new String("N/A");
					}
					
					
					dia = c1.get(Calendar.DATE);
					mes = (c1.get(Calendar.YEAR)+1);
					agno = c1.get(Calendar.YEAR);
					if(mes == 13)
					{
						mes = 1;
						agno += 1;
					}
					if(dia > 28 && mes == 2)
						dia = 1;

					String fechaVen = dia + "/" + mes + "/" + fecha;
					Factura factura = new Factura(codFactura,fecha,fechaVen,cli,plan,plan.getTarifaMensual(),plan.getTarifaMensual(),false);
					Tricom.getInstance().getMisFacturas().add(factura);
					cant = Tricom.getInstance().getCantRegistros().get(4);
					Tricom.getInstance().getCantRegistros().add(4, (cant+1));
					
					
					cli.getMisFacturas().add(factura);
					cli.getMisPlanes().add(plan);
					if(cli instanceof ClienteComun)
						index = Tricom.getInstance().indexCLiente(((ClienteComun) cli).getCedula());
					else
						index = Tricom.getInstance().indexCLiente(((ClienteEmpresa) cli).getRnc());
					
					Tricom.getInstance().getMisClientes().add(index, cli);
					
					
					Venta venta = new Venta(codVenta,emp.getCedula(),emp.getNombre(),id,cli.getNombre(),apellido,fecha,plan);
					Tricom.getInstance().getMisVentas().add(venta);
					cant = Tricom.getInstance().getCantRegistros().get(5);
					Tricom.getInstance().getCantRegistros().add(5, (cant+1));
					
					JOptionPane.showMessageDialog(null, "Registro satisfactorio");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Elija un cliente por favor");
				}
				
			}
		});
		btnAceptar.setBounds(1026, 680, 97, 38);
		getContentPane().add(btnAceptar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(917, 680, 97, 38);
		getContentPane().add(btnAtras);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(808, 680, 97, 38);
		getContentPane().add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 0, 1147, 82);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblID = new JLabel("Identificaci\u00F3n:");
		lblID.setBounds(26, 107, 224, 25);
		getContentPane().add(lblID);
		lblID.setForeground(Color.DARK_GRAY);
		lblID.setBackground(new Color(128, 128, 128));
		lblID.setFont(new Font("Arial", Font.PLAIN, 17));
		
		
		Color myGreen = new Color(255, 159, 35);
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText().toString();
				Cliente cliente = Tricom.getInstance().buscarCliente(cedula);
				if(cliente != null)
				{
					txtNombre.setText(cliente.getNombre());
					if(cliente instanceof ClienteEmpresa)
						txtApellido.setText("N/A");
					else
						txtApellido.setText(((ClienteComun)cliente).getApellido1());
					txtTelefono.setText(cliente.getTelefono());
					txtDireccion.setText(cliente.getDireccion());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
				}
			}
		});
		btnBuscar.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(0, 128, 0));
		btnBuscar.setBounds(207, 133, 43, 30);
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		btnBuscar.setBorder(new LineBorder(myGreen, 1));
		
		
		String path = "./Imagenes/lupa.png";
		ImageIcon lupa = new ImageIcon(path);
		ImageIcon icono = new ImageIcon(lupa.getImage().getScaledInstance(37, 20, Image.SCALE_DEFAULT));
		btnBuscar.setIcon(icono);
		btnBuscar.setBackground(myGreen);
		getContentPane().add(btnBuscar);
		
		
		txtCedula = new JTextField();
		txtCedula.setForeground(new Color(0, 0, 0));
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setBounds(26, 133, 183, 30);
		txtCedula.setBorder(new LineBorder(myGreen, 1));
		txtCedula.setMargin(new Insets(0, 3, 0, 0));
		getContentPane().add(txtCedula);
		if(accion == 1)
		{
			btnBuscar.setEnabled(false);
			txtCedula.setEditable(false);
			if(cliente instanceof ClienteEmpresa)
				txtCedula.setText(((ClienteEmpresa)cliente).getRnc());
			else
				txtCedula.setText(((ClienteComun)cliente).getCedula());
		}
		txtCedula.setColumns(10);
		
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 84, 82);
		panel_1.add(imgLogo);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		
		JLabel lblNewLabel_1 = new JLabel("Venta de planes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(142, 13, 389, 56);
		panel_1.add(lblNewLabel_1);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(1051, 15, 45, 42);
		String path2 = "./Imagenes/user.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel_1.add(userImg);
		
		JLabel lblNewLabel_2 = new JLabel("Juan Lopez");
		lblNewLabel_2.setBounds(1039, 53, 68, 16);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 259, 1097, 408);
		getContentPane().add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setForeground(Color.DARK_GRAY);
		lblPlan.setFont(new Font("Arial", Font.BOLD, 16));
		lblPlan.setBackground(Color.GRAY);
		lblPlan.setBounds(25, 24, 71, 25);
		panel_2.add(lblPlan);
		
		cbxPlanes = new JComboBox();
		cbxPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarCampos();
			}
		});
		cbxPlanes.setBackground(new Color(255, 255, 255));
		cbxPlanes.setBounds(25, 51, 224, 27);
		panel_2.add(cbxPlanes);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setForeground(Color.DARK_GRAY);
		lblDuracion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDuracion.setBackground(Color.GRAY);
		lblDuracion.setBounds(284, 24, 112, 25);
		panel_2.add(lblDuracion);
		
		cbxDuracion = new JComboBox();
		cbxDuracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxDuracion.setModel(new DefaultComboBoxModel(new String[] {"18", "24", "36"}));
		cbxDuracion.setBounds(284, 50, 112, 27);
		cbxDuracion.setBackground(Color.WHITE);
		panel_2.add(cbxDuracion);
		
		txtTarifa = new JTextField();
		txtTarifa.setEditable(false);
		txtTarifa.setColumns(10);
		txtTarifa.setBounds(428, 51, 112, 27);
		panel_2.add(txtTarifa);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setForeground(Color.DARK_GRAY);
		lblTarifa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifa.setBackground(Color.GRAY);
		lblTarifa.setBounds(428, 27, 71, 25);
		panel_2.add(lblTarifa);
		
		txtImpuestos = new JTextField();
		txtImpuestos.setEditable(false);
		txtImpuestos.setColumns(10);
		txtImpuestos.setBounds(570, 51, 112, 27);
		panel_2.add(txtImpuestos);
		
		JLabel lblImpuestos = new JLabel("Impuestos:");
		lblImpuestos.setForeground(Color.DARK_GRAY);
		lblImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos.setBackground(Color.GRAY);
		lblImpuestos.setBounds(570, 27, 81, 25);
		panel_2.add(lblImpuestos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tel\u00E9fono", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(25, 91, 342, 289);
		panel_2.add(panel);
		panel.setLayout(null);
		
		txtMinutos = new JTextField();
		txtMinutos.setEditable(false);
		txtMinutos.setColumns(10);
		txtMinutos.setBounds(12, 56, 118, 27);
		txtMinutos.setBackground(SystemColor.menu);
		panel.add(txtMinutos);
		
		JLabel lblMinutos = new JLabel("Minutos:");
		lblMinutos.setForeground(Color.DARK_GRAY);
		lblMinutos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMinutos.setBackground(Color.GRAY);
		lblMinutos.setBounds(12, 32, 58, 25);
		panel.add(lblMinutos);
		
		JLabel lblLlamadasInternacionales = new JLabel("Llamadas internacionales:");
		lblLlamadasInternacionales.setForeground(Color.DARK_GRAY);
		lblLlamadasInternacionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLlamadasInternacionales.setBackground(Color.GRAY);
		lblLlamadasInternacionales.setBounds(12, 212, 200, 25);
		panel.add(lblLlamadasInternacionales);
		
		rdbLlamIntSi = new JRadioButton("");
		rdbLlamIntSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbLlamIntNo.setSelected(false);
				rdbLlamIntSi.setSelected(true);
			}
		});
		rdbLlamIntSi.setBounds(30, 235, 31, 25);
		rdbLlamIntSi.setBackground(Color.white);
		panel.add(rdbLlamIntSi);
		
		rdbLlamIntNo = new JRadioButton("");
		rdbLlamIntNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbLlamIntNo.setSelected(true);
				rdbLlamIntSi.setSelected(false);
			}
		});
		rdbLlamIntNo.setSelected(true);
		rdbLlamIntNo.setBackground(Color.WHITE);
		rdbLlamIntNo.setBounds(99, 235, 31, 25);
		panel.add(rdbLlamIntNo);
		
		JLabel lblSi = new JLabel("Si:");
		lblSi.setForeground(Color.DARK_GRAY);
		lblSi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSi.setBackground(Color.GRAY);
		lblSi.setBounds(12, 235, 25, 25);
		panel.add(lblSi);
		
		JLabel lblNo = new JLabel("No:");
		lblNo.setForeground(Color.DARK_GRAY);
		lblNo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNo.setBackground(Color.GRAY);
		lblNo.setBounds(78, 235, 25, 25);
		panel.add(lblNo);
		
		rdbMinAdNo = new JRadioButton("");
		rdbMinAdNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMinAdNo.setSelected(true);
				rdbMinAdSi.setSelected(false);
			}
		});
		rdbMinAdNo.setSelected(true);
		rdbMinAdNo.setBackground(Color.WHITE);
		rdbMinAdNo.setBounds(99, 180, 31, 25);
		panel.add(rdbMinAdNo);
		
		JLabel label = new JLabel("No:");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBackground(Color.GRAY);
		label.setBounds(78, 180, 25, 25);
		panel.add(label);
		
		rdbMinAdSi = new JRadioButton("");
		rdbMinAdSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMinAdNo.setSelected(false);
				rdbMinAdSi.setSelected(true);
			}
		});
		rdbMinAdSi.setBackground(Color.WHITE);
		rdbMinAdSi.setBounds(30, 180, 31, 25);
		panel.add(rdbMinAdSi);
		
		JLabel label_1 = new JLabel("Si:");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBackground(Color.GRAY);
		label_1.setBounds(12, 180, 25, 25);
		panel.add(label_1);
		
		JLabel lblMinsAdicionales = new JLabel("Min. adicionales:");
		lblMinsAdicionales.setForeground(Color.DARK_GRAY);
		lblMinsAdicionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMinsAdicionales.setBackground(Color.GRAY);
		lblMinsAdicionales.setBounds(12, 157, 153, 25);
		panel.add(lblMinsAdicionales);
		
		JLabel lblDobleLnea = new JLabel("Doble l\u00EDnea:");
		lblDobleLnea.setForeground(Color.DARK_GRAY);
		lblDobleLnea.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDobleLnea.setBackground(Color.GRAY);
		lblDobleLnea.setBounds(12, 96, 153, 25);
		panel.add(lblDobleLnea);
		
		rdbDobleLineaSi = new JRadioButton("");
		rdbDobleLineaSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDobleLineaSi.setSelected(true);
				rdbDobleLineaNo.setSelected(false);
			}
		});
		rdbDobleLineaSi.setBackground(Color.WHITE);
		rdbDobleLineaSi.setBounds(30, 119, 31, 25);
		panel.add(rdbDobleLineaSi);
		
		JLabel label_3 = new JLabel("Si:");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBackground(Color.GRAY);
		label_3.setBounds(12, 119, 25, 25);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("No:");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBackground(Color.GRAY);
		label_4.setBounds(78, 119, 25, 25);
		panel.add(label_4);
		
		rdbDobleLineaNo = new JRadioButton("");
		rdbDobleLineaNo.setSelected(true);
		rdbDobleLineaNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDobleLineaSi.setSelected(false);
				rdbDobleLineaNo.setSelected(true);
			}
		});
		rdbDobleLineaNo.setBackground(Color.WHITE);
		rdbDobleLineaNo.setBounds(99, 119, 31, 25);
		panel.add(rdbDobleLineaNo);
		
		JLabel lblDesvio = new JLabel("Desv\u00EDo:");
		lblDesvio.setForeground(Color.DARK_GRAY);
		lblDesvio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDesvio.setBackground(Color.GRAY);
		lblDesvio.setBounds(216, 32, 54, 25);
		panel.add(lblDesvio);
		
		rdbDesvioSi = new JRadioButton("");
		rdbDesvioSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDesvioSi.setSelected(true);
				rdbDesvioNo.setSelected(false);
			}
		});
		rdbDesvioSi.setBackground(Color.WHITE);
		rdbDesvioSi.setBounds(234, 55, 31, 25);
		panel.add(rdbDesvioSi);
		
		JLabel label_5 = new JLabel("Si:");
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBackground(Color.GRAY);
		label_5.setBounds(216, 55, 25, 25);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("No:");
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBackground(Color.GRAY);
		label_6.setBounds(282, 55, 25, 25);
		panel.add(label_6);
		
		rdbDesvioNo = new JRadioButton("");
		rdbDesvioNo.setSelected(true);
		rdbDesvioNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDesvioSi.setSelected(false);
				rdbDesvioNo.setSelected(true);
			}
		});
		rdbDesvioNo.setBackground(Color.WHITE);
		rdbDesvioNo.setBounds(303, 55, 31, 25);
		panel.add(rdbDesvioNo);
		
		txtTelPrecio = new JTextField();
		txtTelPrecio.setBackground(SystemColor.menu);
		txtTelPrecio.setEditable(false);
		txtTelPrecio.setColumns(10);
		txtTelPrecio.setBounds(216, 113, 91, 27);
		panel.add(txtTelPrecio);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio.setBackground(Color.GRAY);
		lblPrecio.setBounds(216, 89, 58, 25);
		panel.add(lblPrecio);
		
		txtTelImpuestos = new JTextField();
		txtTelImpuestos.setBackground(SystemColor.menu);
		txtTelImpuestos.setEditable(false);
		txtTelImpuestos.setColumns(10);
		txtTelImpuestos.setBounds(216, 174, 91, 27);
		panel.add(txtTelImpuestos);
		
		JLabel lblImpuestos_1 = new JLabel("Impuestos:");
		lblImpuestos_1.setForeground(Color.DARK_GRAY);
		lblImpuestos_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos_1.setBackground(Color.GRAY);
		lblImpuestos_1.setBounds(216, 150, 91, 25);
		panel.add(lblImpuestos_1);
		
		JButton btnTelfono = new JButton("Tel.");
		btnTelfono.setForeground(Color.WHITE);
		btnTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTelfono.setBackground(new Color(244, 164, 96));
		btnTelfono.setBounds(216, 220, 91, 40);
		panel.add(btnTelfono);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Internet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(379, 90, 342, 290);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		txtVelocidad = new JTextField();
		txtVelocidad.setBackground(SystemColor.menu);
		txtVelocidad.setEditable(false);
		txtVelocidad.setColumns(10);
		txtVelocidad.setBounds(24, 55, 91, 27);
		panel_3.add(txtVelocidad);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setForeground(Color.DARK_GRAY);
		lblVelocidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidad.setBackground(Color.GRAY);
		lblVelocidad.setBounds(24, 31, 75, 25);
		panel_3.add(lblVelocidad);
		
		txtSubida = new JTextField();
		txtSubida.setBackground(SystemColor.menu);
		txtSubida.setEditable(false);
		txtSubida.setColumns(10);
		txtSubida.setBounds(24, 119, 91, 27);
		panel_3.add(txtSubida);
		
		JLabel lblSubida = new JLabel("Velocidad de subida:");
		lblSubida.setForeground(Color.DARK_GRAY);
		lblSubida.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSubida.setBackground(Color.GRAY);
		lblSubida.setBounds(24, 95, 148, 25);
		panel_3.add(lblSubida);
		
		txtInterPrecio = new JTextField();
		txtInterPrecio.setEditable(false);
		txtInterPrecio.setColumns(10);
		txtInterPrecio.setBackground(SystemColor.menu);
		txtInterPrecio.setBounds(215, 55, 91, 27);
		panel_3.add(txtInterPrecio);
		
		JLabel lblInterPrecio = new JLabel("Precio:");
		lblInterPrecio.setForeground(Color.DARK_GRAY);
		lblInterPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInterPrecio.setBackground(Color.GRAY);
		lblInterPrecio.setBounds(215, 31, 58, 25);
		panel_3.add(lblInterPrecio);
		
		txtInterImpuestos = new JTextField();
		txtInterImpuestos.setEditable(false);
		txtInterImpuestos.setColumns(10);
		txtInterImpuestos.setBackground(SystemColor.menu);
		txtInterImpuestos.setBounds(215, 119, 91, 27);
		panel_3.add(txtInterImpuestos);
		
		JLabel label_7 = new JLabel("Impuestos:");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Arial", Font.PLAIN, 16));
		label_7.setBackground(Color.GRAY);
		label_7.setBounds(215, 95, 91, 25);
		panel_3.add(label_7);
		
		JButton btnNewButton = new JButton("M\u00F3dem");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setBounds(215, 218, 91, 40);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telecable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(733, 91, 342, 289);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		txtCanales = new JTextField();
		txtCanales.setEditable(false);
		txtCanales.setColumns(10);
		txtCanales.setBackground(SystemColor.menu);
		txtCanales.setBounds(22, 56, 91, 27);
		panel_4.add(txtCanales);
		
		JLabel lblCanales = new JLabel("Canales:");
		lblCanales.setForeground(Color.DARK_GRAY);
		lblCanales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCanales.setBackground(Color.GRAY);
		lblCanales.setBounds(22, 32, 91, 25);
		panel_4.add(lblCanales);
		
		txtLocales = new JTextField();
		txtLocales.setEditable(false);
		txtLocales.setColumns(10);
		txtLocales.setBackground(SystemColor.menu);
		txtLocales.setBounds(22, 120, 91, 27);
		panel_4.add(txtLocales);
		
		JLabel lblLocales = new JLabel("Locales:");
		lblLocales.setForeground(Color.DARK_GRAY);
		lblLocales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLocales.setBackground(Color.GRAY);
		lblLocales.setBounds(22, 96, 91, 25);
		panel_4.add(lblLocales);
		
		txtInternacionales = new JTextField();
		txtInternacionales.setEditable(false);
		txtInternacionales.setColumns(10);
		txtInternacionales.setBackground(SystemColor.menu);
		txtInternacionales.setBounds(22, 184, 91, 27);
		panel_4.add(txtInternacionales);
		
		JLabel lblInternacionales = new JLabel("Internacionales:");
		lblInternacionales.setForeground(Color.DARK_GRAY);
		lblInternacionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInternacionales.setBackground(Color.GRAY);
		lblInternacionales.setBounds(22, 160, 108, 25);
		panel_4.add(lblInternacionales);
		
		txtCablePrecio = new JTextField();
		txtCablePrecio.setEditable(false);
		txtCablePrecio.setColumns(10);
		txtCablePrecio.setBackground(SystemColor.menu);
		txtCablePrecio.setBounds(219, 56, 91, 27);
		panel_4.add(txtCablePrecio);
		
		JLabel lblCablePrecio = new JLabel("Precio:");
		lblCablePrecio.setForeground(Color.DARK_GRAY);
		lblCablePrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCablePrecio.setBackground(Color.GRAY);
		lblCablePrecio.setBounds(219, 32, 91, 25);
		panel_4.add(lblCablePrecio);
		
		txtCableImpuestos = new JTextField();
		txtCableImpuestos.setEditable(false);
		txtCableImpuestos.setColumns(10);
		txtCableImpuestos.setBackground(SystemColor.menu);
		txtCableImpuestos.setBounds(219, 120, 91, 27);
		panel_4.add(txtCableImpuestos);
		
		JLabel lblCableImpuestos = new JLabel("Impuestos:");
		lblCableImpuestos.setForeground(Color.DARK_GRAY);
		lblCableImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCableImpuestos.setBackground(Color.GRAY);
		lblCableImpuestos.setBounds(219, 96, 91, 25);
		panel_4.add(lblCableImpuestos);
		
		JButton btnHd = new JButton("HD");
		btnHd.setForeground(Color.WHITE);
		btnHd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHd.setBackground(new Color(244, 164, 96));
		btnHd.setBounds(219, 220, 91, 40);
		panel_4.add(btnHd);
		
		JLabel lblInstalacion = new JLabel("Instalaci\u00F3n:");
		lblInstalacion.setForeground(Color.DARK_GRAY);
		lblInstalacion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInstalacion.setBackground(Color.GRAY);
		lblInstalacion.setBounds(711, 27, 81, 25);
		panel_2.add(lblInstalacion);
		
		txtInstalacion = new JTextField();
		txtInstalacion.setEditable(false);
		txtInstalacion.setColumns(10);
		txtInstalacion.setBounds(711, 51, 112, 27);
		panel_2.add(txtInstalacion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(26, 200, 224, 27);
		getContentPane().add(txtNombre);
		txtNombre.setEditable(false);
		if(accion == 1)
			txtNombre.setText(cliente.getNombre());
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 176, 71, 25);
		getContentPane().add(lblNombre);
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBackground(Color.GRAY);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(262, 200, 224, 27);
		getContentPane().add(txtApellido);
		txtApellido.setEditable(false);
		if(accion == 1)
		{
			if(cliente instanceof ClienteEmpresa)
				txtApellido.setText("N/A");
			else
				txtApellido.setText(((ClienteComun)cliente).getApellido1());
		}
		txtApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(262, 176, 71, 25);
		getContentPane().add(lblApellido);
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido.setBackground(Color.GRAY);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(498, 200, 224, 27);
		getContentPane().add(txtTelefono);
		txtTelefono.setEditable(false);
		if(accion == 1)
			txtTelefono.setText(cliente.getTelefono());
		txtTelefono.setColumns(10);
		
		JLabel lblCdula = new JLabel("Tel\u00E9fono:");
		lblCdula.setBounds(498, 176, 71, 25);
		getContentPane().add(lblCdula);
		lblCdula.setForeground(Color.DARK_GRAY);
		lblCdula.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCdula.setBackground(Color.GRAY);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(734, 200, 347, 27);
		if(accion == 1)
			txtDireccion.setText(cliente.getDireccion());
		getContentPane().add(txtDireccion);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.DARK_GRAY);
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccin.setBackground(Color.GRAY);
		lblDireccin.setBounds(734, 176, 71, 25);
		getContentPane().add(lblDireccin);
		
		JLabel label_8 = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label_8.setBounds(26, 702, 291, 16);
		getContentPane().add(label_8);
		setBounds(100, 100, 1153, 771);

		for(Plan plan : Tricom.getInstance().getMisPlanes())
			cbxPlanes.addItem(plan.getNombre());
		llenarCampos();
	}
	
	
	public void llenarCampos()
	{
		int index = cbxPlanes.getSelectedIndex();
		Plan plan = Tricom.getInstance().getMisPlanes().get(index);
		
		txtTarifa.setText(String.valueOf(plan.getTarifaMensual()));
		txtImpuestos.setText(String.valueOf(plan.getImpuestos()));
		txtInstalacion.setText(String.valueOf(plan.getInstalacion()));
		
		if(plan.getTelefono() != null)
		{
			txtMinutos.setText(String.valueOf(((Telefono)plan.getTelefono()).getMinutos()));
			txtTelImpuestos.setText(String.valueOf(((Telefono)plan.getTelefono()).getImpuestos()));
			txtTelPrecio.setText(String.valueOf(((Telefono)plan.getTelefono()).getTarifa()));
		}else
		{
			txtMinutos.setText("");
			txtTelImpuestos.setText("");
			txtTelPrecio.setText("");
		}
		
		if(plan.getInternet() != null)
		{
			txtVelocidad.setText(String.valueOf(((Internet)plan.getInternet()).getVelocidad()));
			txtSubida.setText(String.valueOf(((Internet)plan.getInternet()).getVelSubida()));
			txtInterImpuestos.setText(String.valueOf(((Internet)plan.getInternet()).getImpuestos()));
			txtInterPrecio.setText(String.valueOf(((Internet)plan.getInternet()).getTarifa()));
		}
		else
		{
			txtVelocidad.setText("");
			txtSubida.setText("");
			txtInterImpuestos.setText("");
			txtInterPrecio.setText("");
		}
		
		if(plan.getCable() != null)
		{
			txtCanales.setText(String.valueOf(((Cable)plan.getCable()).getCantCanales()));
			txtLocales.setText(String.valueOf(((Cable)plan.getCable()).getLocales()));
			txtInternacionales.setText(String.valueOf(((Cable)plan.getCable()).getInternacionales()));
			txtCableImpuestos.setText(String.valueOf(((Cable)plan.getCable()).getImpuestos()));
			txtCablePrecio.setText(String.valueOf(((Cable)plan.getCable()).getTarifa()));
		}
		else
		{
			txtCanales.setText("");
			txtLocales.setText("");
			txtInternacionales.setText("");
			txtCableImpuestos.setText("");
			txtCablePrecio.setText("");
		}
	}
	
}






















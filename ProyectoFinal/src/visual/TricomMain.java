package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logico.Administrativo;
import logico.Cable;
import logico.Cliente;
import logico.ClienteComun;
import logico.ClienteEmpresa;
import logico.Empleado;
import logico.Factura;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.ServicioC;
import logico.Telefono;
import logico.Tricom;
import logico.Venta;
import logico.ControlarFacturas;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TricomMain extends JFrame {
	

	private JPanel contentPane;
	private Dimension dim;
	private static JTable table;
	private static DefaultTableModel model;
	private JLabel lblTitulo;
	private JLabel lblReg;
	private static JScrollPane scrollPane;
	private JPanel panelRegistros;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private static int activeButton = 1;
	private JLabel lblNewLabel;
	private static JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnBuscar;
	private Cliente clienteP = null;
	private JButton btnPagar;
	private JButton btnPlanes_1;
	private ChartPanel cp3;
	private ChartPanel cp2;
	private ChartPanel cp;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TricomMain frame = new TricomMain();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public TricomMain() {
		setResizable(false);
		Tricom tri = new Tricom();		
		setTitle("Tricom");
		setBounds(100, 100, 1360, 768);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//dim = super.getToolkit().getScreenSize();
		//super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		ControlarFacturas vaFac = new ControlarFacturas();
		vaFac.start();
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				try {
					Tricom.getInstance().saveData();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 118, 870);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(18, 18, 81, 81);
		String path2 = "./Imagenes/User2.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(userImg);
		
	 lblNewLabel = new JLabel("Juan Lopez");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(25, 108, 118, 16);
		panel.add(lblNewLabel);
	
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTitulo.setText("Clientes");
				lblReg.setText("Registros de Clientes");
				activeButton = 1;
				camposVisibles(true,false);
				cargarJtable(1);
				
			}
		});
		btnClientes.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClientes.setForeground(Color.LIGHT_GRAY);
		btnClientes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnClientes.setBackground(Color.DARK_GRAY);
		btnClientes.setBounds(0, 137, 118, 91);
		btnClientes.setMargin(new Insets(0, 0, 10, 0));
		String path = "./Imagenes/User3.png";
		ImageIcon img = new ImageIcon(path);
		ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnClientes.setIcon(icono);
		btnClientes.setHorizontalTextPosition( SwingConstants.CENTER );
		btnClientes.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnClientes.setFocusable(false);
		panel.add(btnClientes);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SI EL USUARUI ACTUAL ES ADMIN PUEDE VER LOS EMPLEADOS SI NO SE JODIO.
		if(Tricom.getInstance().getActual() instanceof Administrativo){
			
				lblTitulo.setText("Empleados");
				lblReg.setText("Registros de Empleados");
				activeButton = 2;
				camposVisibles(true,false);
				cargarJtable(2);
		}else {
			
			JOptionPane.showMessageDialog(null, "Usted no cuenta con permiso para accesar", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
			}
		});
		btnEmpleados.setBackground(Color.DARK_GRAY);
		btnEmpleados.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleados.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEmpleados.setMargin(new Insets(0, 0, 10, 0));
		btnEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleados.setForeground(Color.LIGHT_GRAY);
		btnEmpleados.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEmpleados.setBounds(0, 226, 118, 91);
		btnEmpleados.setMargin(new Insets(0, 0, 10, 0));
		String path3 = "./Imagenes/empleado1.png";
		img = new ImageIcon(path3);
		icono = new ImageIcon(img.getImage().getScaledInstance(45, 40, Image.SCALE_DEFAULT));
		btnEmpleados.setIcon(icono);
		btnEmpleados.setFocusable(false);
		panel.add(btnEmpleados);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Ventas");
				lblReg.setText("Registros de planes vendidos");
				activeButton = 3;
				camposVisibles(true,false);
				cargarJtable(3);
			
			}
		});
		btnVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVentas.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVentas.setMargin(new Insets(0, 0, 10, 0));
		btnVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVentas.setForeground(Color.LIGHT_GRAY);
		btnVentas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVentas.setFocusable(false);
		btnVentas.setBackground(Color.DARK_GRAY);
		btnVentas.setBounds(0, 315, 118, 91);
		String path4 = "./Imagenes/Ventas1.png";
		img = new ImageIcon(path4);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnVentas.setIcon(icono);
		btnVentas.setHorizontalTextPosition( SwingConstants.CENTER );
		btnVentas.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnVentas);
		
		JButton btnPlanes = new JButton("Planes");
		btnPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Planes");
				lblReg.setText("Planes disponibles");
				activeButton = 4;
				camposVisibles(true,false);
				cargarJtable(4);
			}
		});
		btnPlanes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPlanes.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlanes.setMargin(new Insets(0, 0, 10, 0));
		btnPlanes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlanes.setForeground(Color.LIGHT_GRAY);
		btnPlanes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPlanes.setFocusable(false);
		btnPlanes.setBackground(Color.DARK_GRAY);
		btnPlanes.setBounds(0, 405, 118, 91);
		String path5 = "./Imagenes/Planes1.png";
		img = new ImageIcon(path5);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnPlanes.setIcon(icono);
		btnPlanes.setHorizontalTextPosition( SwingConstants.CENTER );
		btnPlanes.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnPlanes);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Servicios");
				lblReg.setText("Servicios disponibles");
				activeButton = 5;
				camposVisibles(true,false);
				cargarJtable(5);
			}
		});
		btnServicios.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnServicios.setVerticalAlignment(SwingConstants.BOTTOM);
		btnServicios.setMargin(new Insets(0, 0, 10, 0));
		btnServicios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnServicios.setForeground(Color.LIGHT_GRAY);
		btnServicios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnServicios.setFocusable(false);
		btnServicios.setBackground(Color.DARK_GRAY);
		btnServicios.setBounds(0, 495, 118, 91);
		String path6 = "./Imagenes/Servicios1.png";
		img = new ImageIcon(path6);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnServicios.setIcon(icono);
		btnServicios.setHorizontalTextPosition( SwingConstants.CENTER );
		btnServicios.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnServicios);
		
		JButton btnPagos = new JButton("Pagos");
		btnPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.setText("Pagos");
				lblReg.setText("Realizar pago");
				activeButton = 6;
				camposVisibles(false,true);
				cargarJtable(6);
				
			}
		});
		btnPagos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPagos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPagos.setMargin(new Insets(0, 0, 10, 0));
		btnPagos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPagos.setForeground(Color.LIGHT_GRAY);
		btnPagos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPagos.setFocusable(false);
		btnPagos.setBackground(Color.DARK_GRAY);
		btnPagos.setBounds(0, 585, 118, 91);
		String path7 = "./Imagenes/pagos1.png";
		img = new ImageIcon(path7);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnPagos.setIcon(icono);
		btnPagos.setHorizontalTextPosition( SwingConstants.CENTER );
		btnPagos.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnPagos);
		String path8 = "./Imagenes/Acerca1.png";
		img = new ImageIcon(path8);
		icono = new ImageIcon(img.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(255, 102, 51));
		panel_1.setBounds(118, 0, 1564, 124);
		contentPane.add(panel_1);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 126, 124);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel_1.add(imgLogo);
		
		JLabel lblFueraDeAqu = new JLabel("Fuera de aqu\u00ED nada se vive mejor");
		lblFueraDeAqu.setForeground(Color.WHITE);
		lblFueraDeAqu.setFont(new Font("Calibri", Font.BOLD, 22));
		lblFueraDeAqu.setBackground(Color.WHITE);
		lblFueraDeAqu.setBounds(147, 84, 406, 40);
		panel_1.add(lblFueraDeAqu);
		
		JButton btnSingOut = new JButton("Cerrar Sesi\u00F3n");
		btnSingOut.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSingOut.setForeground(Color.WHITE);
		btnSingOut.setBackground(new Color(255, 99, 71));
		btnSingOut.setBounds(1407, 84, 145, 34);
		btnSingOut.setFocusable(false);
		btnSingOut.setBorder(null);
		panel_1.add(btnSingOut);
		
		panelRegistros = new JPanel();
		panelRegistros.setBackground(SystemColor.text);
		panelRegistros.setBounds(147, 192, 877, 528);
		contentPane.add(panelRegistros);
		panelRegistros.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 115, 820, 323);
		scrollPane.setBackground(SystemColor.text);
		panelRegistros.add(scrollPane);
		
		
		//Para iniciar el programa
		cargarJtable(1);
		
		lblReg = new JLabel("Registros de Clientes");
		lblReg.setFont(new Font("Calibri", Font.BOLD, 20));
		lblReg.setBounds(42, 27, 269, 27);
		panelRegistros.add(lblReg);
		
		btnModificar = new JButton("Modifcar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR
				int row;
				switch(activeButton)
				{
				case 1: //Boton de Clientes
						row = revisarCheckbox(table, "cliente");
						if(row != -1)
						{
							String codigo = table.getModel().getValueAt(row, 1).toString();
							Cliente cl = Tricom.getInstance().buscarClientecode(codigo);
							RegistrarCliente reg = new RegistrarCliente(cl, 2);
							reg.setVisible(true);
							cargarJtable(1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No se han seleccionado registros");
						}
					break;
				case 2://Boton de Empleados
						row = revisarCheckbox(table, "empleado");
						if(row != -1)
						{
							String codigo2 = table.getModel().getValueAt(row, 1).toString();
							Empleado cl2 = Tricom.getInstance().buscarEmpcode(codigo2);
							RegistrarEmpleado reg2 = new RegistrarEmpleado(cl2, 2);
							reg2.setVisible(true);
							cargarJtable(2);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No se han seleccionado registros");
						}	
					break;
				case 4://Boton de Planes
						row = revisarCheckbox(table, "plan");
						if(row != -1)
						{
							String codigo4 = table.getModel().getValueAt(row, 1).toString();
							Plan cl4 = Tricom.getInstance().buscarPlancode(codigo4);
							RegistrarPlan reg4 = new RegistrarPlan(cl4, 2);
							reg4.setVisible(true);
							cargarJtable(3);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No se han seleccionado registros");
						}
						break;
				case 5://Boton de Servicios
						row = revisarCheckbox(table, "servicio");
						if(row != -1)
						{
							String codigo5 = table.getModel().getValueAt(row, 1).toString();
							Servicio cl5 = Tricom.getInstance().buscarServcode(codigo5);
							RegistrarServicio reg5 = new RegistrarServicio(cl5, 2);
							reg5.setVisible(true);
							cargarJtable(4);
						}	
						else
						{
							JOptionPane.showMessageDialog(null, "No se han seleccionado registros");
						}

					break;
				default:
					break;
				}	
				
				loadData();
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.DARK_GRAY);
		btnModificar.setBounds(170, 457, 104, 44);
		panelRegistros.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ELIMINAR
				switch(activeButton)
				{
				
				case 1: //Boton de Clientes
					while(revisarCheckbox(table, "cliente")!=-1){
						String codigo = table.getModel().getValueAt(revisarCheckbox(table, "cliente"), 1).toString();
						Tricom.getInstance().eliminarCliente(codigo);
						cargarJtable(1);
					}
					break;
				case 2://Boton de Empleados
					boolean salir = false;
					while(revisarCheckbox(table, "empleado")!=-1 && salir == false){
						String codigo = table.getModel().getValueAt(revisarCheckbox(table, "empleado"), 1).toString();
						if(Tricom.getInstance().getActual().getCodigo().equalsIgnoreCase(codigo)){
							JOptionPane.showMessageDialog(null, "No se puede borrar el usuario actual.");
							salir = true;
						}else{
						Tricom.getInstance().eliminarEmpleado(codigo);
						cargarJtable(2);
						}
					}
					break;
				case 4://Boton de Planes
					while(revisarCheckbox(table, "plan")!=-1){
						String codigo = table.getModel().getValueAt(revisarCheckbox(table, "plan"), 1).toString();
						Tricom.getInstance().eliminarPlan(codigo);
						cargarJtable(4);
					}
					break;
				case 5://Boton de Servicios
					while(revisarCheckbox(table, "servicio")!=-1){
						String codigo = table.getModel().getValueAt(revisarCheckbox(table, "servicio"), 1).toString();
						Tricom.getInstance().eliminarServicio(codigo);
						cargarJtable(5);	
					}
					break;
				default:
					break;
				}	
				table.repaint();
				loadData();
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setBounds(300, 457, 104, 44);
		panelRegistros.add(btnEliminar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(activeButton)
				{
				case 1: //Boton de Clientes
					if(Tricom.getInstance().getMisServicios().size() == 0)
					{
						JOptionPane.showMessageDialog(null, "No se puede registrar clientes porque no se han creado planes.");
					}
					else
					{
						RegistrarCliente rgCli = new RegistrarCliente(null,1);
						rgCli.setVisible(true);
						cargarJtable(1);
					}
					break;
				case 2://Boton de Empleados
					RegistrarEmpleado regEmp = new RegistrarEmpleado(null,1);
					regEmp.setVisible(true);
					cargarJtable(2);
					break;
				case 3://Boton de Ventas
					if(Tricom.getInstance().getMisServicios().size() == 0)
					{
						JOptionPane.showMessageDialog(null, "No se han creado planes.");
					}
					else
					{
						VenderPlan venPlan = new VenderPlan(null,2);
						venPlan.setVisible(true);
						cargarJtable(3);
					}
					break;	
				case 4://Boton de Planes
					if(Tricom.getInstance().getMisServicios().size() == 0)
					{
						JOptionPane.showMessageDialog(null, "No hay servicios registrados crear un plan.");
					}
					else
					{
						RegistrarPlan regPlan = new RegistrarPlan(null,1);
						regPlan.setVisible(true);
						cargarJtable(4);
					}
					break;
				case 5://Boton de Servicios
					RegistrarServicio regSer = new RegistrarServicio(null,1);
					regSer.setVisible(true);
					cargarJtable(5);
					break;
				default:
					break;
				}	
			}
		});
		
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(Color.DARK_GRAY);
		btnNuevo.setBounds(42, 457, 104, 44);
		panelRegistros.add(btnNuevo);
		
		Color myGreen = new Color(255, 159, 35);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(42, 67, 183, 30);
		panelRegistros.add(txtCedula);
		txtCedula.setMargin(new Insets(0, 3, 0, 0));
		txtCedula.setForeground(Color.BLACK);
		txtCedula.setBorder(new LineBorder(myGreen, 1));
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setColumns(10);
		
		
		
		String path11 = "./Imagenes/lupa.png";
		ImageIcon lupa = new ImageIcon(path11);
		ImageIcon icono11 = new ImageIcon(lupa.getImage().getScaledInstance(37, 20, Image.SCALE_DEFAULT));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(42, 134, 148, 27);
		panelRegistros.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBackground(Color.GRAY);
		lblNombre.setBounds(42, 110, 71, 25);
		panelRegistros.add(lblNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(224, 134, 155, 27);
		panelRegistros.add(txtApellido);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido.setBackground(Color.GRAY);
		lblApellido.setBounds(224, 110, 155, 25);
		panelRegistros.add(lblApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(414, 134, 161, 27);
		panelRegistros.add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBackground(Color.GRAY);
		lblTelefono.setBounds(414, 110, 71, 25);
		panelRegistros.add(lblTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(611, 134, 177, 27);
		panelRegistros.add(txtDireccion);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setForeground(Color.DARK_GRAY);
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion.setBackground(Color.GRAY);
		lblDireccion.setBounds(611, 110, 71, 25);
		panelRegistros.add(lblDireccion);
		
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(224, 67, 43, 30);
		panelRegistros.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod = txtCedula.getText().toString();
				switch(activeButton)
				{
					case 1:
						Cliente clien = Tricom.getInstance().buscarCliente(cod);
						if(clien != null)
						{
							cargarBusqueda(1,clien,null,null,null,null);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
							cargarJtable(1);
						}
						break;
					case 2:
						Empleado emp = Tricom.getInstance().buscarEmpleado(cod);
						if(emp != null)
						{
							cargarBusqueda(2,null,emp,null,null,null);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
							cargarJtable(2);
						}
						break;
					case 3:
						Venta ven = Tricom.getInstance().buscarVenta(cod);
						if(ven != null)
						{
							cargarBusqueda(3, null, null,ven, null, null);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
							cargarJtable(3);
						}
						break;
					//
					case 4:
						Plan pla= Tricom.getInstance().buscarPlancode(cod);
						if(pla != null)
						{
							cargarBusqueda(4, null, null,null, pla, null);
						}
						else
						{	
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
							cargarJtable(4);
						}
						break;
						
					case 5:
						Servicio ser = Tricom.getInstance().buscarServcode(cod);
						if(ser != null)
						{
							cargarBusqueda(5, null, null, null,null, ser);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
							cargarJtable(5);
						}
						break;
					case 6:
						Cliente clien1 = Tricom.getInstance().buscarCliente(cod);
						if(clien1 != null)
						{
							txtNombre.setText(clien1.getNombre());
							if(clien1 instanceof ClienteEmpresa)
								txtApellido.setText("N/A");
							else
								txtApellido.setText(((ClienteComun)clien1).getApellido1());
							txtTelefono.setText(clien1.getTelefono());
							txtDireccion.setText(clien1.getDireccion());
						}
						else
						{
							btnPagar.setEnabled(false);
							JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado.");
						}
		
						
				}
				
				
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(0, 128, 0));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		btnBuscar.setBorder(new LineBorder(myGreen, 1));
		btnBuscar.setIcon(icono11);
		btnBuscar.setBackground(myGreen);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = table.getModel().getValueAt(revisarCheckbox(table, "factura"), 1).toString();
				Tricom.getInstance().pagarFactura(codigo);
				
			}
		});
		btnPagar.setEnabled(false);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBackground(Color.DARK_GRAY);
		btnPagar.setBounds(38, 541, 104, 44);
		panelRegistros.add(btnPagar);
		
		btnPlanes_1 = new JButton("Planes");
		btnPlanes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = table.getModel().getValueAt(revisarCheckbox(table, "cliente"), 1).toString();
				Cliente cl = Tricom.getInstance().buscarClientecode(codigo);
				RegistrarCliente reg = new RegistrarCliente(cl, 3);
				reg.setVisible(true);
			}
		});
		btnPlanes_1.setForeground(Color.WHITE);
		btnPlanes_1.setBackground(Color.DARK_GRAY);
		btnPlanes_1.setBounds(428, 457, 104, 44);
		panelRegistros.add(btnPlanes_1);
		
		camposVisibles(true,false);
		
		lblTitulo = new JLabel("Clientes");
		lblTitulo.setForeground(SystemColor.windowBorder);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitulo.setBounds(147, 150, 227, 38);
		contentPane.add(lblTitulo);
		
		JPanel panelGraficos = new JPanel();
		panelGraficos.setBackground(SystemColor.text);
		panelGraficos.setBounds(1046, 192, 296, 460);
		contentPane.add(panelGraficos);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Tricom.getInstance().saveData();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		//Creating piechart
		if(Tricom.getInstance().getActual() instanceof ServicioC){
			DefaultPieDataset data = new DefaultPieDataset();
			data.setValue(""+((ServicioC)Tricom.getInstance().getActual()).getMisVentas().size()+" Ventas", ((ServicioC)Tricom.getInstance().getActual()).getMisVentas().size());
			data.setValue(""+((ServicioC)Tricom.getInstance().getActual()).getComisionventas()+" Comisiones",  ((ServicioC)Tricom.getInstance().getActual()).getComisionventas());
			JFreeChart chart = ChartFactory.createPieChart(
					"Resumen ",
					data,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
			 cp = new ChartPanel(chart);
		    cp.setPreferredSize(new Dimension(panelGraficos.getBounds().width, panelGraficos.getBounds().height/2));

			panelGraficos.add(cp,BorderLayout.CENTER);
			
			
			
		}else{
			DefaultPieDataset data = new DefaultPieDataset();
			data.setValue(""+Tricom.getInstance().getMisPlanes().size()+" Planes", Tricom.getInstance().getMisPlanes().size());
			data.setValue(""+Tricom.getInstance().getMisClientes().size()+" Clientes",  Tricom.getInstance().getMisClientes().size());
			data.setValue(""+Tricom.getInstance().getMisEmpleados().size()+" Usuarios",  Tricom.getInstance().getMisEmpleados().size());
			JFreeChart chart = ChartFactory.createPieChart(
					"Resumen ",
					data,
					true, // legend?
					true, // tooltips?
					false // URLs?
					);
			// create and display a frame...
			 cp = new ChartPanel(chart);
		    cp.setPreferredSize(new Dimension(panelGraficos.getBounds().width-10, panelGraficos.getBounds().height/3-5));

			panelGraficos.add(cp,BorderLayout.CENTER);
			
			DefaultPieDataset data2 = new DefaultPieDataset();
			int per = 0;
			int empr = 0;
			for(Cliente emp : Tricom.getInstance().getMisClientes()){
				if (emp instanceof ClienteComun)
					per++;
				if (emp instanceof ClienteEmpresa)
					empr++;
			}
			data2.setValue(""+per+" Clientes personales", per);
			data2.setValue(""+empr+" Clientes empresariales ",  empr);
			JFreeChart chart2 = ChartFactory.createPieChart(
					"Resumen ",
					data2,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
			 cp2 = new ChartPanel(chart2);
		    cp2.setPreferredSize(new Dimension(panelGraficos.getBounds().width - 10, panelGraficos.getBounds().height/3-5));

			panelGraficos.add(cp2,BorderLayout.CENTER);
			
			
			DefaultPieDataset data3 = new DefaultPieDataset();
			int adm = 0;
			int serv = 0;
			for(Empleado emp : Tricom.getInstance().getMisEmpleados()){
				if (emp instanceof Administrativo)
					adm++;
				if (emp instanceof ServicioC)
					serv++;
			}
			data3.setValue(""+adm+" Administradores", adm);
			data3.setValue(""+empr+" Vendedores ",  empr);
			JFreeChart chart3 = ChartFactory.createPieChart(
					"Resumen ",
					data3,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
			 cp3 = new ChartPanel(chart3);
		    cp3.setPreferredSize(new Dimension(panelGraficos.getBounds().width - 10, panelGraficos.getBounds().height/3-5));

			panelGraficos.add(cp3,BorderLayout.CENTER);
		}
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(1238, 676, 104, 44);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label.setBounds(147, 954, 291, 16);
		contentPane.add(label);
		
		
		
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		loaddataemp();
		
	}
	
	//LOAD DATA DE EMPLEADO, CUANDO EL EMPLEADO SE LOGEA SE CARGAN LOS DATOS DE EL
	public void loaddataemp(){
		lblNewLabel.setText(""+Tricom.getInstance().getActual().getNombre()+" "+Tricom.getInstance().getActual().getApellido1());
	}
	
	public static Object[][] loadData() {
		int i = 0;
		Object[][] fila = null;
		switch(activeButton)
		{
		   case 1:
			   fila = new Object[Tricom.getInstance().getMisClientes().size()][10];
			   for (Cliente cli: Tricom.getInstance().getMisClientes()) 
			   {
				   if(cli instanceof ClienteComun)
				   {
					   fila[i][0] = false;
					   fila[i][1] = cli.getCodCli();
					   fila[i][2] = ((ClienteComun) (cli)).getCedula();
					   fila[i][3] = cli.getNombre();
					   fila[i][4] = ((ClienteComun)(cli)).getApellido1();
					   fila[i][5] = ((ClienteComun)(cli)).getApellido2();
					   fila[i][6] = ((ClienteComun)(cli)).getFecNac();
					   fila[i][7] = cli.getTelefono();
					   fila[i][8] = cli.getEmail();	
				   }
				   else
				   {
					   fila[i][0] = false;
					   fila[i][1] = cli.getCodCli();
					   fila[i][2] = ((ClienteEmpresa) (cli)).getRnc();
					   fila[i][3] = cli.getNombre();
					   fila[i][4] = "N/A";
					   fila[i][5] = "N/A";
					   fila[i][6] = "N/A";
					   fila[i][7] = cli.getTelefono();
					   fila[i][8] = cli.getEmail();
				   }
				   i++;
			   }
			   break;
		   case 2:
			   fila = new Object[Tricom.getInstance().getMisEmpleados().size()][10];
			   for (Empleado emp: Tricom.getInstance().getMisEmpleados()) 
			   {
				   fila[i][0] = false;
				   fila[i][1] = emp.getCodigo();
				   if(emp instanceof Administrativo)
					   fila[i][2] = "Admistrativo";
				   else
					   fila[i][2] = "Servicio";
				   fila[i][3] = emp.getCedula();
				   fila[i][4] = emp.getNombre();
				   fila[i][5] = emp.getApellido1();
				   fila[i][6] = emp.getApellido2();
				   fila[i][7] = emp.getTelefono();
				   fila[i][8] = String.valueOf(emp.getSalario());
				   i++;
			   }
			   break;
		   case 3:
			   fila = new Object[Tricom.getInstance().getMisVentas().size()][8];
			   for (Venta ven: Tricom.getInstance().getMisVentas()) 
			   {
				   fila[i][0] = false;
				   fila[i][1] = ven.getCodVenta();
				   fila[i][2] = ven.getNombreCliente()+" "+ven.getApellidoCliente();
				   fila[i][3] = ven.getCedulaCliente();
				   fila[i][4] = ven.getNombreEmpleado();
				   fila[i][5] = ven.getCedulaEmpleado();
				   fila[i][6] = ven.getPlanVendido().getNombre();
				   fila[i][7] = ven.getFecha();
				   i++;
			   }
			   break;
		   case 4:
			   fila = new Object[Tricom.getInstance().getMisPlanes().size()][9];
			   for (Plan plan: Tricom.getInstance().getMisPlanes()) 
			   {
				   fila[i][0] = false;
				   fila[i][1] = plan.getCodPlan();
				   fila[i][2] = plan.getNombre();
				   if(plan.getInternet() != null) //Internet
					   fila[i][3] = "Si";
				   else
					   fila[i][3] = "No";
				   if(plan.getTelefono() != null)//Telefono
					   fila[i][4] = "Si";
				   else
					   fila[i][4] = "No";
				   if(plan.getCable() != null)//Cable
					   fila[i][5] = "Si";
				   else
					   fila[i][5] = "No";
				   
				   fila[i][6] = String.valueOf(plan.getTarifaMensual());
				   fila[i][7] = String.valueOf(plan.getImpuestos());
				   fila[i][8] = String.valueOf(plan.getInstalacion());
				   i++;
			   }
			   break;
		   case 5:
			   fila = new Object[Tricom.getInstance().getMisServicios().size()][6];
			   for (Servicio ser: Tricom.getInstance().getMisServicios()) 
			   {
				   fila[i][0] = false;
				   fila[i][1] = ser.getCodServicio();
				   if(ser instanceof Internet)
					   fila[i][2] = "Internet";
				   else if(ser instanceof Telefono)
					   fila[i][2] = "Telefono";
				   else if(ser instanceof Cable)
					   fila[i][2] = "TeleCable";
				   fila[i][3] = String.valueOf(ser.getTarifa());
				   fila[i][4] = String.valueOf(ser.getImpuestos());
				   fila[i][5] = String.valueOf(ser.getPrecioInstalacion());
				   i++;
			   }
			   break;
		   case 6:
			   String id = txtCedula.getText().toString();
			   Cliente cliente = Tricom.getInstance().buscarCliente(id);
			   if(cliente != null)
			   {
				   fila = new Object[cliente.getMisFacturas().size()][9];
				   for (Factura fac: cliente.getMisFacturas()) 
				   {
					  fila[i][0] = false;
					  fila[i][1] = fac.getCodFactura();
					  fila[i][2] = fac.getPlan().getNombre();
					  fila[i][3] = fac.getTotalNeto();
					  fila[i][4] = fac.getPlan().getImpuestos();
					  fila[i][5] = fac.getMora();
					  fila[i][6] = fac.getFechaVencimiento();
					  if(fac.isPagada() == true)
						  fila[i][7] = "Pagada";
					  else
						  fila[i][7] = "Sin pagar";
					  if(fac.getVencida() == true)
						  fila[i][8] = "Vencida";
					  else
						  fila[i][8] = "En fecha";
				   	  i++;
				   }
			   }
			   break;
		   default:
			   JOptionPane.showMessageDialog(null, "sd");
		}
		return fila;
		
}
	//
	private  void reloadGraficos(){
		
		
		if(Tricom.getInstance().getActual() instanceof ServicioC){
			DefaultPieDataset data = new DefaultPieDataset();
			data.setValue(""+((ServicioC)Tricom.getInstance().getActual()).getMisVentas().size()+" Ventas", ((ServicioC)Tricom.getInstance().getActual()).getMisVentas().size());
			data.setValue(""+((ServicioC)Tricom.getInstance().getActual()).getComisionventas()+" Comisiones",  ((ServicioC)Tricom.getInstance().getActual()).getComisionventas());
			JFreeChart chart = ChartFactory.createPieChart(
					"Resumen ",
					data,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
			cp = new ChartPanel(chart);

			
			
		}else{
			DefaultPieDataset data = new DefaultPieDataset();
			data.setValue(""+Tricom.getInstance().getMisPlanes().size()+" Planes", Tricom.getInstance().getMisPlanes().size());
			data.setValue(""+Tricom.getInstance().getMisClientes().size()+" Clientes",  Tricom.getInstance().getMisClientes().size());
			data.setValue(""+Tricom.getInstance().getMisEmpleados().size()+" Usuarios",  Tricom.getInstance().getMisEmpleados().size());
			JFreeChart chart = ChartFactory.createPieChart(
					"Resumen ",
					data,
					true, // legend?
					true, // tooltips?
					false // URLs?
					);
			// create and display a frame...
			cp = new ChartPanel(chart);

			DefaultPieDataset data2 = new DefaultPieDataset();
			int per = 0;
			int empr = 0;
			for(Cliente emp : Tricom.getInstance().getMisClientes()){
				if (emp instanceof ClienteComun)
					per++;
				if (emp instanceof ClienteEmpresa)
					empr++;
			}
			data2.setValue(""+per+" Clientes personales", per);
			data2.setValue(""+empr+" Clientes empresariales ",  empr);
			JFreeChart chart2 = ChartFactory.createPieChart(
					"Resumen ",
					data2,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
	cp2 = new ChartPanel(chart2);
			
			
			DefaultPieDataset data3 = new DefaultPieDataset();
			int adm = 0;
			int serv = 0;
			for(Empleado emp : Tricom.getInstance().getMisEmpleados()){
				if (emp instanceof Administrativo)
					adm++;
				if (emp instanceof ServicioC)
					serv++;
			}
			data3.setValue(""+adm+" Administradores", adm);
			data3.setValue(""+empr+" Vendedores ",  empr);
			JFreeChart chart3 = ChartFactory.createPieChart(
					"Resumen ",
					data3,
					true, // legend?
					true, // tooltips?
					false //
					);
			// create and display a frame...
			cp3 = new ChartPanel(chart3);
		  
		}
	}
	private void camposVisibles(boolean visible1, boolean visible2)
	{
		btnNuevo.setVisible(visible1);
		btnModificar.setVisible(visible1);
		btnEliminar.setVisible(visible1);
		//txtCedula.setVisible(visible2);
		txtNombre.setVisible(visible2);
		txtApellido.setVisible(visible2);
		txtTelefono.setVisible(visible2);
		txtDireccion.setVisible(visible2);
		//btnBuscar.setVisible(visible2);
		btnPagar.setVisible(visible2);
		btnPlanes_1.setVisible(visible1);
		if(visible2)
			scrollPane.setBounds(42, 189, 800, 280);
		if(visible1)
			scrollPane.setBounds(42, 115, 820, 323);
		
		if(activeButton != 3){ 
			btnModificar.setEnabled(true);
		}else{			
			btnModificar.setEnabled(false);
		}

	}
	//
	public static void cargarJtable(int tipo)
	{

		String[] columnNames1 = {"Seleccionar","Codigo", "ID", "Nombre","Primer Apellido", "Segundo Apellido", "Fecha de Nacimiento","Telefono","Email"};
		String[] columnNames2 = {"Seleccionar","Codigo","Tipo", "ID", "Nombre","Primer Apellido", "Segundo Apellido", "Telefono","Salario"};
		String[] columnNames3 = {"Seleccionar","Codigo","Cliente","Cedula-Cliente","Empleado","Cedula-Empleado","Nombre del Plan","Fecha"};
		String[] columnNames4 = {"Seleccionar","Codigo","Nombre","Internet","Telefono","Telecable","Tarifa","Impuestos","Instalacion"};
		String[] columnNames5 = {"Seleccionar","Codigo","Tipo", "Precio Total", "Impuestos","Instalacion"};
		String[] columnNames6 = {"Seleccionar","Codigo","Plan", "Precio Total", "Impuestos","Mora","Vencimiento","Estado","Pago"};
		
		
		switch(tipo)
		{
			case 1:
				model = new DefaultTableModel(loadData(),columnNames1);
				break;
			case 2:
				model = new DefaultTableModel(loadData(),columnNames2);
				break;
			case 3:
				model = new DefaultTableModel(loadData(),columnNames3);
				break;
			case 4:
				model = new DefaultTableModel(loadData(),columnNames4);
				break;
			case 5:
				model = new DefaultTableModel(loadData(),columnNames5);
				break;
			case 6:
				model = new DefaultTableModel(loadData(),columnNames6);	
				break;
				
		}
		
		table = new JTable(model)
		{
	        public Class getColumnClass(int column) 
	        {
	           switch (column) 
	           {
	              case 0:
	            	  return Boolean.class;
	              default:
	            	  return String.class;
	            }
	         }
	      };
		table.setBackground(SystemColor.window);
		scrollPane.setViewportView(table);
		
	
	}
	public static void cargarBusqueda(int tipo,Cliente cl,Empleado emp, Venta ven, Plan plan,Servicio ser)
	{

		String[] columnNames;
		String[] columnNames1 = {"Seleccionar","Codigo", "ID", "Nombre","Primer Apellido", "Segundo Apellido", "Fecha de Nacimiento","Telefono","Email"};
		String[] columnNames2 = {"Seleccionar","Codigo","Tipo", "ID", "Nombre","Primer Apellido", "Segundo Apellido", "Telefono","Salario"};
		String[] columnNames3 = {"Seleccionar","Codigo","Cliente","Cedula-Cliente","Empleado","Cedula-Empleado","Nombre del Plan","Fecha"};
		String[] columnNames4 = {"Seleccionar","Codigo","Nombre","Internet","Telefono","Telecable","Tarifa","Impuestos","Instalacion"};
		String[] columnNames5 = {"Seleccionar","Codigo","Tipo", "Precio Total", "Impuestos","Instalacion"};
		String[] columnNames6 = {"Seleccionar","Codigo","Plan", "Precio Total", "Impuestos","Mora","Vencimiento","Estado","Pago"};
		
		
		switch(tipo)
		{
			case 1:
				model = new DefaultTableModel(loadBusqueda(cl, null, null, null, null),columnNames1);
				break;
			case 2:
				model = new DefaultTableModel(loadBusqueda(null, emp, null, null, null),columnNames2);
				break;
			case 3:
				model = new DefaultTableModel(loadBusqueda(null, null, ven, null, null),columnNames3);
				break;
			case 4:
				model = new DefaultTableModel(loadBusqueda(null, null, null, plan, null),columnNames4);
				break;
			case 5:
				model = new DefaultTableModel(loadBusqueda(null, null, null, null, ser),columnNames5);
				break;
				
		}
		
		table = new JTable(model)
		{
	        public Class getColumnClass(int column) 
	        {
	           switch (column) 
	           {
	              case 0:
	            	  return Boolean.class;
	              default:
	            	  return String.class;
	            }
	         }
	      };
		table.setBackground(SystemColor.window);
		scrollPane.setViewportView(table);
	}
	
	public int checkboxsActivos(JTable table, String tipo)
	{
		int i = 0;
		int cant = 0;
		if(tipo.equalsIgnoreCase("cliente"))
		{
			while(i < Tricom.getInstance().getMisClientes().size())
			{
				if((Boolean)table.getModel().getValueAt(i, 0)) //Si el CheckBox se encuentra check
					cant++;
				i++;
			}
		}
		if(tipo.equalsIgnoreCase("empleado"))
		{
			while(i < Tricom.getInstance().getMisEmpleados().size())
			{
				if((Boolean)table.getModel().getValueAt(i, 0)) //Si el CheckBox se encuentra check
					cant++;
				i++;
			}
		}
		if(tipo.equalsIgnoreCase("plan"))
		{
			while(i < Tricom.getInstance().getMisPlanes().size())
			{
				if((Boolean)table.getModel().getValueAt(i, 0)) //Si el CheckBox se encuentra check
					cant++;
				i++;
			}
		}
		if(tipo.equalsIgnoreCase("servicio"))
		{
			while(i < Tricom.getInstance().getMisEmpleados().size())
			{
				if((Boolean)table.getModel().getValueAt(i, 0)) //Si el CheckBox se encuentra check
					cant++;
				i++;
			}
		}
		return cant;
	}
	
	public int revisarCheckbox(JTable table,String tipo){
		int i = 0;
		int row= -1;
		if(tipo.equalsIgnoreCase("cliente")){
			while(i < Tricom.getInstance().getMisClientes().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		if(tipo.equalsIgnoreCase("empleado")){
			while(i < Tricom.getInstance().getMisEmpleados().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		if(tipo.equalsIgnoreCase("venta")){
			while(i < Tricom.getInstance().getMisVentas().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		if(tipo.equalsIgnoreCase("plan")){
			while(i < Tricom.getInstance().getMisPlanes().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		if(tipo.equalsIgnoreCase("servicio")){
			while(i < Tricom.getInstance().getMisServicios().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		if(tipo.equalsIgnoreCase("factura")){
			while(i < Tricom.getInstance().getMisFacturas().size()){
				if((boolean)table.getModel().getValueAt(i, 0)){
					row = i;
				}
			i++;
			}
		}
		
		return row;
	}
	
	public static Object[][] loadBusqueda(Cliente cli,Empleado emp, Venta ven,Plan plan, Servicio ser) {
		int i = 0;
		Object[][] fila = null;
		switch(activeButton)
		{
		   case 1:
			   fila = new Object[1][10];
				   if(cli instanceof ClienteComun)
				   {
					   fila[i][0] = false;
					   fila[i][1] = cli.getCodCli();
					   fila[i][2] = ((ClienteComun) (cli)).getCedula();
					   fila[i][3] = cli.getNombre();
					   fila[i][4] = ((ClienteComun)(cli)).getApellido1();
					   fila[i][5] = ((ClienteComun)(cli)).getApellido2();
					   fila[i][6] = ((ClienteComun)(cli)).getFecNac();
					   fila[i][7] = cli.getTelefono();
					   fila[i][8] = cli.getEmail();	
				   }
				   else
				   {
					   fila[i][0] = false;
					   fila[i][1] = cli.getCodCli();
					   fila[i][2] = ((ClienteEmpresa) (cli)).getRnc();
					   fila[i][3] = cli.getNombre();
					   fila[i][4] = "N/A";
					   fila[i][5] = "N/A";
					   fila[i][6] = "N/A";
					   fila[i][7] = cli.getTelefono();
					   fila[i][8] = cli.getEmail();
				   }
				   i++;
			   
			   break;
		   case 2:
			   fila = new Object[1][10];

				   fila[i][0] = false;
				   fila[i][1] = emp.getCodigo();
				   if(emp instanceof Administrativo)
					   fila[i][2] = "Admistrativo";
				   else
					   fila[i][2] = "Servicio";
				   fila[i][3] = emp.getCedula();
				   fila[i][4] = emp.getNombre();
				   fila[i][5] = emp.getApellido1();
				   fila[i][6] = emp.getApellido2();
				   fila[i][7] = emp.getTelefono();
				   fila[i][8] = String.valueOf(emp.getSalario());
				   i++;
			   
			   break;
		   case 3:
			   fila = new Object[1][8];
				   fila[i][0] = false;
				   fila[i][1] = ven.getCodVenta();
				   fila[i][2] = ven.getNombreCliente()+" "+ven.getApellidoCliente();
				   fila[i][3] = ven.getCedulaCliente();
				   fila[i][4] = ven.getNombreEmpleado();
				   fila[i][5] = ven.getCedulaEmpleado();
				   fila[i][6] = ven.getPlanVendido().getNombre();
				   fila[i][7] = ven.getFecha();
				   i++;
			   break;
		   case 4:
			   fila = new Object[1][9];
			   
				   fila[i][0] = false;
				   fila[i][1] = plan.getCodPlan();
				   fila[i][2] = plan.getNombre();
				   if(plan.getInternet() != null) //Internet
					   fila[i][3] = "Si";
				   else
					   fila[i][3] = "No";
				   if(plan.getTelefono() != null)//Telefono
					   fila[i][4] = "Si";
				   else
					   fila[i][4] = "No";
				   if(plan.getCable() != null)//Cable
					   fila[i][5] = "Si";
				   else
					   fila[i][5] = "No";
				   
				   fila[i][6] = String.valueOf(plan.getTarifaMensual());
				   fila[i][7] = String.valueOf(plan.getImpuestos());
				   fila[i][8] = String.valueOf(plan.getInstalacion());
				   i++;
			   
			   break;
		   case 5:
			   fila = new Object[1][6];
			 
				   fila[i][0] = false;
				   fila[i][1] = ser.getCodServicio();
				   if(ser instanceof Internet)
					   fila[i][2] = "Internet";
				   else if(ser instanceof Telefono)
					   fila[i][2] = "Telefono";
				   else if(ser instanceof Cable)
					   fila[i][2] = "TeleCable";
				   fila[i][3] = String.valueOf(ser.getTarifa());
				   fila[i][4] = String.valueOf(ser.getImpuestos());
				   fila[i][5] = String.valueOf(ser.getPrecioInstalacion());
				   i++;
			   
			   break;
		   case 6:
			   String id = txtCedula.getText().toString();
			   Cliente cliente = Tricom.getInstance().buscarCliente(id);
			   if(cliente != null)
			   {
				   fila = new Object[cliente.getMisFacturas().size()][9];
				   for (Factura fac: cliente.getMisFacturas()) 
				   {
					  fila[i][0] = false;
					  fila[i][1] = fac.getCodFactura();
					  fila[i][2] = fac.getPlan().getNombre();
					  fila[i][3] = fac.getTotalNeto();
					  fila[i][4] = fac.getPlan().getImpuestos();
					  fila[i][5] = fac.getMora();
					  fila[i][6] = fac.getFechaVencimiento();
					  if(fac.isPagada() == true)
						  fila[i][7] = "Pagada";
					  else
						  fila[i][7] = "Sin pagar";
					  if(fac.getVencida() == true)
						  fila[i][8] = "Vencida";
					  else
						  fila[i][8] = "En fecha";
				   	  i++;
				   }
			   }
			   break;
		   default:
			   JOptionPane.showMessageDialog(null, "sd");
		}
		return fila;
}
	
	
}

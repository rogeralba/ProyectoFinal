package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.ClienteComun;
import logico.ClienteEmpresa;
import logico.Tricom;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TricomMain extends JFrame {
	

	private JPanel contentPane;
	private Dimension dim;
	private JTable tableClientes;
	private JTable tableClientes_1;
	private static DefaultTableModel model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TricomMain frame = new TricomMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TricomMain() {
		setTitle("Tricom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 118, 983);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(18, 18, 81, 81);
		String path2 = "./Imagenes/User2.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(userImg);
		
		JLabel lblNewLabel = new JLabel("Juan Lopez");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(25, 108, 118, 16);
		panel.add(lblNewLabel);
		
	
		JButton btnClientes = new JButton("Clientes");
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
		
		//
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAcercaDe.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAcercaDe.setMargin(new Insets(0, 0, 10, 0));
		btnAcercaDe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAcercaDe.setForeground(Color.LIGHT_GRAY);
		btnAcercaDe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAcercaDe.setFocusable(false);
		btnAcercaDe.setBackground(Color.DARK_GRAY);
		btnAcercaDe.setBounds(0, 675, 118, 91);
		String path8 = "./Imagenes/Acerca1.png";
		img = new ImageIcon(path8);
		icono = new ImageIcon(img.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		btnAcercaDe.setIcon(icono);
		btnAcercaDe.setHorizontalTextPosition( SwingConstants.CENTER );
		btnAcercaDe.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnAcercaDe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(255, 102, 51));
		panel_1.setBounds(118, 0, 1784, 124);
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
		btnSingOut.setBounds(1627, 84, 145, 34);
		btnSingOut.setFocusable(false);
		btnSingOut.setBorder(null);
		panel_1.add(btnSingOut);
		
		JPanel panelClientes = new JPanel();
		panelClientes.setBackground(SystemColor.text);
		panelClientes.setBounds(147, 192, 1179, 668);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);
		
		JScrollPane scrollPaneCli = new JScrollPane();
		scrollPaneCli.setBounds(42, 68, 1091, 323);
		scrollPaneCli.setBackground(SystemColor.text);
		panelClientes.add(scrollPaneCli);
		
		tableClientes = new JTable();
		String[] columnNames = {"Seleccionar","Codigo", "ID", "Primer Apellido", "Segundo Apellido", "Fecha de Nacimiento","Telefono","Email"};
		model = new DefaultTableModel(loadData(),columnNames);
		tableClientes_1 = new JTable(model)
		{
	        public Class getColumnClass(int column) 
	        {
	           switch (column) 
	           {
	              case 0:
	            	  return Boolean.class;
	              case 1:
	                  return String.class;
	              case 2:
	            	  return String.class;
	              case 3:
	            	  return String.class;
	              case 4:
	            	  return String.class;
	              case 5:
	            	  return String.class;
	              case 6:
	            	  return Date.class;
	              case 7:
	            	  return String.class;
	              default:
	            	  return String.class;
	            }
	         }
	      };
		tableClientes_1.setBackground(SystemColor.window);
		scrollPaneCli.setViewportView(tableClientes_1);
		
		JLabel lblReg = new JLabel("Registros de Clientes");
		lblReg.setFont(new Font("Calibri", Font.BOLD, 20));
		lblReg.setBounds(42, 38, 189, 27);
		panelClientes.add(lblReg);
		
		JButton btnModifcar = new JButton("Modifcar");
		btnModifcar.setForeground(Color.WHITE);
		btnModifcar.setBackground(Color.DARK_GRAY);
		btnModifcar.setBounds(170, 419, 104, 44);
		panelClientes.add(btnModifcar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setBounds(300, 419, 104, 44);
		panelClientes.add(btnEliminar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(Color.DARK_GRAY);
		btnNuevo.setBounds(42, 419, 104, 44);
		panelClientes.add(btnNuevo);
		
		JLabel lblTitulo = new JLabel("Clientes");
		lblTitulo.setForeground(SystemColor.windowBorder);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitulo.setBounds(147, 150, 227, 38);
		contentPane.add(lblTitulo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(1376, 192, 469, 668);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(1741, 909, 104, 44);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label.setBounds(147, 954, 291, 16);
		contentPane.add(label);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		
	}
	
	public Object[][] loadData() {
		int i = 0;
		try {
			Tricom.getInstance().readData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		Object[][] fila = new Object[Tricom.getInstance().getMisClientes().size()][10];
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
		return fila;
	}
}

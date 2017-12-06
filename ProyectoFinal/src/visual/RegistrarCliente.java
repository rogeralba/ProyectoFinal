package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logico.Cable;
import logico.Cliente;
import logico.ClienteComun;
import logico.ClienteEmpresa;
import logico.Factura;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;
import logico.Tricom;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static DefaultTableModel model;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtPasaporte;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JRadioButton rdbCedula;
	private JRadioButton rdbPasaporte;
	private JLabel lblRNC;
	private JFormattedTextField txtRNC;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JFormattedTextField txtTelefono;
	private JLabel lblDerechos;
	private JLabel lblFecNac;
	private JDateChooser dtcFecNac;
	private JFormattedTextField txtCedula;
	private JComboBox cbxSexo;
	private JLabel lblSexo;
	private JComboBox cbxTipo;
	private JTable table_1;
	/*
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/


	public RegistrarCliente(Cliente cliente, int accion) //accion: 1-Registrar (El parametro cliente es NULL), 2-Modificar
	{
		setResizable(false);
		setTitle("Registrar Cliente");
		setBounds(100, 100, 667, 949);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 663, 82);
		contentPanel.add(panel);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(36, 0, 84, 82);
		imgLogo.setBounds(30, 0, 84, 82);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel.add(imgLogo);
		
		JLabel lblRegistrarCliente = new JLabel("Registrar Cliente");
		lblRegistrarCliente.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRegistrarCliente.setBounds(142, 13, 389, 56);
		panel.add(lblRegistrarCliente);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(575, 13, 45, 42);
		String path2 = "./Imagenes/user.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(userImg);
		
		JLabel label_3 = new JLabel("Juan Lopez");
		label_3.setBounds(567, 53, 68, 16);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(24, 108, 614, 444);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.DARK_GRAY);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCodigo.setBackground(Color.GRAY);
		lblCodigo.setBounds(23, 26, 71, 25);
		panel_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(23, 50, 224, 27);
		txtCodigo.setText("codCli-"+(Tricom.getInstance().getCantRegistros().get(0)+1));
		panel_1.add(txtCodigo);
		
		 cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = cbxTipo.getSelectedItem().toString();
				if(tipo.equalsIgnoreCase("Empresa"))
				{
					lblApellido1.setVisible(false);
					txtApellido1.setVisible(false);
					lblApellido2.setVisible(false);
					txtApellido2.setVisible(false);
					rdbCedula.setVisible(false);
					rdbPasaporte.setVisible(false);
					txtPasaporte.setVisible(false);
					lblRNC.setVisible(true);
					txtRNC.setVisible(true);
					lblFecNac.setVisible(false);
					dtcFecNac.setVisible(false);
					lblTelefono.setBounds(23, 233, 116, 25);
					txtTelefono.setBounds(23, 257, 224, 27);
					lblEmail.setBounds(23, 297, 128, 25);
					txtEmail.setBounds(23, 321, 224, 27);
				cbxSexo.setVisible(false);
				lblSexo.setVisible(false);
				
				}
				else
				{
					lblApellido1.setVisible(true);
					txtApellido1.setVisible(true);
					lblApellido2.setVisible(true);
					txtApellido2.setVisible(true);
					rdbCedula.setVisible(true);
					rdbCedula.setSelected(true);
					rdbPasaporte.setVisible(true);
					rdbPasaporte.setSelected(false);
					txtCedula.setVisible(true);
					txtPasaporte.setVisible(false);
					lblRNC.setVisible(false);
					txtRNC.setVisible(false);
					lblTelefono.setBounds(364, 233, 116, 25);
					txtTelefono.setBounds(364, 257, 224, 27);
					lblEmail.setBounds(364, 297, 128, 25);
					txtEmail.setBounds(364, 321, 224, 27);
					lblFecNac.setVisible(true);
					dtcFecNac.setVisible(true);
					cbxSexo.setVisible(true);
					lblSexo.setVisible(true);
				}
			}
		});
		cbxTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Corriente", "Empresa"}));
		cbxTipo.setBackground(Color.WHITE);
		cbxTipo.setBounds(23, 119, 224, 27);
		panel_1.add(cbxTipo);
		
		JLabel lblTipo = new JLabel("Tipo de cliente:");
		lblTipo.setForeground(Color.DARK_GRAY);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipo.setBackground(Color.GRAY);
		lblTipo.setBounds(23, 90, 116, 25);
		panel_1.add(lblTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBackground(Color.GRAY);
		lblNombre.setBounds(23, 164, 71, 25);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBounds(23, 188, 224, 27);
		panel_1.add(txtNombre);
		
		txtApellido1 = new JTextField();
		txtApellido1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(Color.WHITE);
		txtApellido1.setBounds(23, 257, 224, 27);
		panel_1.add(txtApellido1);
		
		lblApellido1 = new JLabel("Primer apellido:");
		lblApellido1.setForeground(Color.DARK_GRAY);
		lblApellido1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido1.setBackground(Color.GRAY);
		lblApellido1.setBounds(23, 233, 116, 25);
		panel_1.add(lblApellido1);
		
		txtApellido2 = new JTextField();
		txtApellido2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(Color.WHITE);
		txtApellido2.setBounds(23, 321, 224, 27);
		panel_1.add(txtApellido2);
		
		lblApellido2 = new JLabel("Segundo Apellido:");
		lblApellido2.setForeground(Color.DARK_GRAY);
		lblApellido2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido2.setBackground(Color.GRAY);
		lblApellido2.setBounds(23, 297, 128, 25);
		panel_1.add(lblApellido2);
		
		txtPasaporte = new JTextField();
		txtPasaporte.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPasaporte.setColumns(10);
		txtPasaporte.setBackground(Color.WHITE);
		txtPasaporte.setBounds(364, 119, 224, 27);
		txtPasaporte.setVisible(false);
		panel_1.add(txtPasaporte);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(364, 188, 224, 27);
		panel_1.add(txtDireccion);
		
		JLabel lblDireccion1 = new JLabel("Direcci\u00F3n:");
		lblDireccion1.setForeground(Color.DARK_GRAY);
		lblDireccion1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion1.setBackground(Color.GRAY);
		lblDireccion1.setBounds(364, 164, 71, 25);
		panel_1.add(lblDireccion1);
		
		rdbCedula = new JRadioButton("C\u00E9dula");
		rdbCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbCedula.setSelected(true);
				rdbPasaporte.setSelected(false);	
				txtPasaporte.setVisible(false);
				txtCedula.setVisible(true);
			}
		});
		rdbCedula.setSelected(true);
		rdbCedula.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbCedula.setBackground(Color.WHITE);
		rdbCedula.setBounds(359, 90, 79, 25);
		panel_1.add(rdbCedula);
		
		rdbPasaporte = new JRadioButton("Pasaporte");
		rdbPasaporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbCedula.setSelected(false);
				rdbPasaporte.setSelected(true);
				txtCedula.setVisible(false);
				txtPasaporte.setVisible(true);
			}
		});
		rdbPasaporte.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbPasaporte.setBackground(Color.WHITE);
		rdbPasaporte.setBounds(442, 90, 120, 25);
		panel_1.add(rdbPasaporte);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBackground(Color.GRAY);
		lblTelefono.setBounds(364, 233, 71, 25);
		panel_1.add(lblTelefono);
		
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("###-###-####");
			txtTelefono = new JFormattedTextField(mascara);
			txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
			txtTelefono.setBounds(364, 257, 224, 27);
			panel_1.add(txtTelefono);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(364, 321, 224, 27);
		panel_1.add(txtEmail);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBackground(Color.GRAY);
		lblEmail.setBounds(364, 297, 71, 25);
		panel_1.add(lblEmail);
		
		lblRNC = new JLabel("RNC:");
		lblRNC.setForeground(Color.DARK_GRAY);
		lblRNC.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRNC.setBackground(Color.GRAY);
		lblRNC.setBounds(364, 90, 71, 25);
		lblRNC.setVisible(false);
		
		panel_1.add(lblRNC);
		
		try {
			mascara = new MaskFormatter("###-#####-#");
			txtRNC = new JFormattedTextField(mascara);
			txtRNC.setFont(new Font("Arial", Font.PLAIN, 15));
			txtRNC.setBounds(364, 119, 224, 27);
			txtRNC.setVisible(false);
			panel_1.add(txtRNC);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			mascara = new MaskFormatter("###-#######-#");
			txtCedula = new JFormattedTextField(mascara);
			txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
			txtCedula.setBounds(364, 119, 224, 27);
			panel_1.add(txtCedula);
			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		dtcFecNac = new JDateChooser();
		dtcFecNac.setBounds(23, 390, 224, 27);
		panel_1.add(dtcFecNac);
		
		lblFecNac = new JLabel("Fecha de nacimiento:");
		lblFecNac.setForeground(Color.DARK_GRAY);
		lblFecNac.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFecNac.setBackground(Color.GRAY);
		lblFecNac.setBounds(23, 361, 166, 25);
		panel_1.add(lblFecNac);
		
		cbxSexo = new JComboBox();
		cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		cbxSexo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxSexo.setBackground(Color.WHITE);
		cbxSexo.setBounds(364, 390, 141, 27);
		panel_1.add(cbxSexo);
		
		 lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSexo.setBounds(364, 368, 57, 14);
		panel_1.add(lblSexo);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(432, 847, 97, 44);
		contentPanel.add(btnCancelar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = null;
				boolean valido = false;
				String nombre = txtNombre.getText().toString();
				String apellido1 = txtApellido1.getText().toString();
				String apellido2 = txtApellido2.getText().toString();
				String direccion = txtDireccion.getText().toString();
				String telefono = txtTelefono.getText().toString();
				String email = txtEmail.getText().toString();
				String cedula = txtCedula.getText().toString();
				String pasaporte = txtPasaporte.getText().toString();
				String rnc = txtRNC.getText().toString();
				String sexo = cbxSexo.getSelectedItem().toString();
				String codCli = "";
				if(accion == 1)
					codCli = new String("codCli-"+(Tricom.getInstance().getCantRegistros().get(0)+1));
				else
					codCli = new String(cliente.getCodCli());
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String fecNac ="";
				if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Corriente"))
				{
					try{
						fecNac = new String(formatter.format(dtcFecNac.getDate()));
					}catch(NullPointerException e)
					{
						JOptionPane.showMessageDialog(null, "Debe ingresar una fecha válida.");
					}
				}
				
				if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Corriente"))
				{
					if(rdbCedula.isSelected() == true)
					{
						if(nombre.equalsIgnoreCase("")==false && apellido1.equalsIgnoreCase("")==false && apellido2.equalsIgnoreCase("")==false && direccion.equalsIgnoreCase("")==false && telefono.equalsIgnoreCase("   -   -    ")==false && cedula.equalsIgnoreCase("   -       - ")==false && email.equalsIgnoreCase("")==false && fecNac.equals("") == false)
						{
							cliente = new ClienteComun(codCli,nombre,apellido1,apellido2,direccion,telefono,email,cedula,fecNac,sexo);
							valido = true;
						}
					}else if(rdbPasaporte.isSelected() == true)
					{
						if(nombre.equalsIgnoreCase("")==false && apellido1.equalsIgnoreCase("")==false && apellido2.equalsIgnoreCase("")==false && direccion.equalsIgnoreCase("")==false && telefono.equalsIgnoreCase("   -   -    ")==false && pasaporte.equalsIgnoreCase("")==false && email.equalsIgnoreCase("")==false && fecNac.equals("") == false)
						{
							cliente = new ClienteComun(codCli,nombre,apellido1,apellido2,direccion,telefono,email,pasaporte,fecNac,sexo);
							valido = true;
						}
					}	
				}else if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Empresa"))
				{
					if(nombre.equalsIgnoreCase("")==false && direccion.equalsIgnoreCase("")==false && telefono.equalsIgnoreCase("   -   -    ")==false && rnc.equalsIgnoreCase("   -     - ")==false && email.equalsIgnoreCase("")==false)
					{
						cliente = new ClienteEmpresa(codCli,nombre,direccion,telefono,email,rnc);
						valido = true;
					}
				}	
				
				if(accion == 1)
				{
					if(valido == true)
					{
						VenderPlan venPlan = new VenderPlan(cliente,1);
						venPlan.setVisible(true);
						dispose();
					}else
					{
						JOptionPane.showMessageDialog(null, "Todos los campos deben ser válidos.");
					}
				}else if(accion == 2)
				{
					if(valido == true)
					{
						Tricom.getInstance().reemplazarCliente(cliente);
						TricomMain.cargarJtable(1);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Todos los campos deben ser válidos.");
					}
				}
			}
		});
		btnSiguiente.setBounds(541, 847, 97, 44);
		contentPanel.add(btnSiguiente);
		
		lblDerechos = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		lblDerechos.setBounds(24, 875, 291, 16);
		contentPanel.add(lblDerechos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(24, 595, 614, 228);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPlanes = new JLabel("Mis Planes");
		lblPlanes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlanes.setBounds(24, 566, 122, 29);
		contentPanel.add(lblPlanes);
		
		
		if(accion == 1 || accion == 2)
		{
			setBounds(100, 100, 667, 657);
			lblPlanes.setVisible(false);
			lblDerechos.setBounds(24, 575, 291, 16);
			btnCancelar.setBounds(432, 565, 97, 44);
			btnSiguiente.setBounds(541, 565, 97, 44);
			scrollPane.setVisible(false);
		}
		
		if(accion == 2)
		{
			loadDatos(cliente);
			btnSiguiente.setText("Aceptar");
		}
		
		if(accion == 3)
		{
			loadDatos(cliente);
			btnSiguiente.setVisible(false);
			btnCancelar.setBounds(541, 847, 97, 44);
			btnCancelar.setText("Cerrar");
			cbxTipo.setEnabled(false);
			txtNombre.setEnabled(false);
			txtDireccion.setEnabled(false);
			txtTelefono.setEnabled(false);
			txtEmail.setEnabled(false);
			txtRNC.setEnabled(false);
			txtApellido1.setEnabled(false);
			txtApellido2.setEnabled(false);
			txtCedula.setEnabled(false);
			dtcFecNac.setEnabled(false);
			cargarJtable(cliente);
		}
	
			
	}
	
	public void loadDatos(Cliente cl){
		cbxTipo.setEnabled(false);
		txtCodigo.setText(cl.getCodCli());
		if(cl instanceof ClienteComun)
		{
			cbxTipo.setSelectedIndex(0);
			ClienteComun clc = (ClienteComun)cl;
			txtNombre.setText(clc.getNombre());
			txtApellido1.setText(clc.getApellido1());
			txtApellido2.setText(clc.getApellido2());
			txtDireccion.setText(clc.getDireccion());
			txtTelefono.setText(clc.getTelefono());
			txtEmail.setText(clc.getEmail());
			if(clc.getCedula().equalsIgnoreCase("   -       - ")); //Si no hay cedula es porque hay pasaporte
			{
				rdbPasaporte.setSelected(true);
				rdbCedula.setSelected(false);
				txtPasaporte.setVisible(true);
				txtPasaporte.setText(clc.getCedula());
				txtCedula.setVisible(false);
				
			}
			if (clc.getSexo().equalsIgnoreCase("Femenino")) 
				cbxSexo.setSelectedIndex(0);
			else
				cbxSexo.setSelectedIndex(1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date dt;
			try {
				dt = formatter.parse(((ClienteComun) cl).getFecNac());
				dtcFecNac.setDate(dt);
				
			} catch (ParseException e) {
		}
		
		}
		if(cl instanceof ClienteEmpresa)
		{
			cbxTipo.setSelectedIndex(1);
			txtNombre.setText(cl.getNombre());
			txtDireccion.setText(cl.getDireccion());
			txtTelefono.setText(cl.getTelefono());
			txtEmail.setText(cl.getEmail());
			txtRNC.setText(((ClienteEmpresa) cl).getRnc());
		}
	}
	
	public void cargarJtable(Cliente cliente)
	{
		Object[][] fila = null;
		int i = 0;
		String[] columnNames = {"Codigo","Nombre","Internet","Telefono","Telecable","Tarifa","Impuestos","Instalacion"};
		fila = new Object[cliente.getMisPlanes().size()][8];
		for (Plan plan: cliente.getMisPlanes()) 
		{
			fila[i][0] = plan.getCodPlan();
			fila[i][1] = plan.getNombre();
			if(plan.getInternet() != null) //Internet
			    fila[i][2] = "Si";
			else
				fila[i][2] = "No";
			if(plan.getTelefono() != null)//Telefono
				fila[i][3] = "Si";
			else
				fila[i][3] = "No";
			if(plan.getCable() != null)//Cable
				fila[i][4] = "Si";
			else
				fila[i][4] = "No";
			   
			fila[i][5] = String.valueOf(plan.getTarifaMensual());
			fila[i][6] = String.valueOf(plan.getImpuestos());
			fila[i][7] = String.valueOf(plan.getInstalacion());
			i++;
		  }
		model = new DefaultTableModel(fila,columnNames);	
		table = new JTable(model)
		{
	        public Class getColumnClass(int column) 
	        {
	           switch (column) 
	           {
	              case 0:
	            	  return String.class;
	              default:
	            	  return String.class;
	            }
	         }
	      };
		table.setBackground(SystemColor.window);
		scrollPane.setViewportView(table);
	}
}

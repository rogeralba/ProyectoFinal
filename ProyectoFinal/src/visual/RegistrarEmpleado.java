package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Administrativo;
import logico.Empleado;
import logico.ServicioC;
import logico.Tricom;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class RegistrarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JComboBox cbxSexo;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private Empleado myvend;
	private boolean option = true;
	private JButton btnAceptar;
	private String[] nombrePlan;
	private int cant = 6;
	private DefaultComboBoxModel<String> combonombres;
	private String numberOnly1;
	private JTextField txtContrasena;
	private JSpinner spnSalario;
	private JTextField txtApellido2;
	private JLabel lblNotaMedica;
	private JDateChooser dtcFecNac;
	private JTextField txtCodigo;
	private JTextArea txtANota;
	private JComboBox cbxCargo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String title = null;
					boolean option = false;
					Empleado cli = null;
					RegistrarEmpleado frame = new RegistrarEmpleado(null,1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistrarEmpleado(Empleado empleado, int accion) { //accion: 1-Registrar (El parametro empleado es NULL), 2-Modificar
		setTitle("Registrar Empleado\r\n");
		setBounds(100, 100, 693, 776);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		String path0 = "./Imagenes/tricom.png";
		Image icono0 = Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(24, 106, 638, 565);
		contentPanel.add(panel);
		panel.setLayout(null);
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("###-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setForeground(Color.DARK_GRAY);
		lblCedula.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCedula.setBounds(31, 123, 91, 14);
		panel.add(lblCedula);

		txtCedula = new JFormattedTextField(patron);
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setBounds(31, 144, 224, 27);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(31, 189, 70, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(31, 208, 224, 27);
		panel.add(txtNombre);
		if(accion == 2)
		   txtNombre.setText(empleado.getNombre());
		txtNombre.setColumns(10);

		JLabel lblApellido1 = new JLabel("Primer apellido:");
		lblApellido1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido1.setBounds(375, 183, 141, 27);
		panel.add(lblApellido1);

		txtApellido1 = new JTextField();
		txtApellido1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido1.setBounds(375, 208, 224, 27);
		panel.add(txtApellido1);
		txtApellido1.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCorreo.setBounds(31, 251, 70, 14);
		panel.add(lblCorreo);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setBounds(31, 271, 224, 27);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSexo.setBounds(375, 315, 57, 14);
		panel.add(lblSexo);

		cbxSexo = new JComboBox();
		cbxSexo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxSexo.setBackground(Color.WHITE);

		cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		cbxSexo.setBounds(375, 337, 141, 27);
		panel.add(cbxSexo);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion.setBounds(33, 376, 108, 14);
		panel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setBounds(31, 398, 292, 27);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBounds(375, 123, 91, 14);
		panel.add(lblTelefono);

		txtTelefono = new JFormattedTextField(tele);
		txtTelefono.setText("   -   -    ");
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefono.setBounds(375, 144, 224, 27);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena.setBounds(31, 316, 211, 14);
		panel.add(lblContrasena);

		txtContrasena = new JTextField();
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		txtContrasena.setBounds(31, 337, 224, 27);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);

		lblNotaMedica = new JLabel("Nota Medica:\r\n");
		lblNotaMedica.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNotaMedica.setBounds(31, 438, 132, 17);
		panel.add(lblNotaMedica);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSalario.setBounds(375, 377, 57, 14);
		panel.add(lblSalario);

		spnSalario = new JSpinner();
		spnSalario.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnSalario.setBounds(375, 398, 141, 27);
		panel.add(spnSalario);

		txtApellido2 = new JTextField();
		txtApellido2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido2.setColumns(10);
		txtApellido2.setBounds(375, 271, 224, 27);
		panel.add(txtApellido2);

		JLabel lblApellido2 = new JLabel("Segundo apellido:");
		lblApellido2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido2.setBounds(375, 245, 141, 27);
		panel.add(lblApellido2);
		panel.setEnabled(false);

		cbxCargo = new JComboBox();
		cbxCargo.setBackground(Color.WHITE);
		cbxCargo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxCargo.setBounds(375, 81, 141, 27);
		panel.add(cbxCargo);
		cbxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxCargo.getSelectedIndex() == 0) {
					panel.setEnabled(false);
				}
				if (cbxCargo.getSelectedIndex() > 0) {
					panel.setEnabled(true);
				}
			}
		});
		cbxCargo.setModel(new DefaultComboBoxModel(new String[] {"Ventas", "Administrativo"}));

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCargo.setBounds(375, 56, 62, 27);
		panel.add(lblCargo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(31, 81, 224, 27);
		txtCodigo.setText("codEmp-"+(Tricom.getInstance().getCantRegistros().get(1)+1));
		panel.add(txtCodigo);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.DARK_GRAY);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCodigo.setBackground(Color.GRAY);
		lblCodigo.setBounds(31, 57, 71, 25);
		panel.add(lblCodigo);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(375, 439, 171, 14);
		panel.add(lblFechaDeNacimiento);
		
		dtcFecNac = new JDateChooser();
		dtcFecNac.setBounds(375, 468, 141, 27);
		panel.add(dtcFecNac);
		
		txtANota = new JTextArea();
		txtANota.setFont(new Font("Arial", Font.PLAIN, 15));
		txtANota.setBounds(31, 468, 292, 73);
		txtANota.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		panel.add(txtANota);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(0, 0, 687, 82);
		contentPanel.add(panel_1);

		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 84, 82);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel_1.add(imgLogo);

		JLabel lblRegistrarEmpleado = new JLabel("Registrar Empleado");
		lblRegistrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRegistrarEmpleado.setBounds(142, 13, 389, 56);
		panel_1.add(lblRegistrarEmpleado);

		JLabel userImg = new JLabel("");
		userImg.setBounds(575, 13, 45, 42);
		String path2 = "./Imagenes/user.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(
				userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel_1.add(userImg);

		JLabel lblUserName = new JLabel("Juan Lopez");
		lblUserName.setBounds(567, 53, 68, 16);
		panel_1.add(lblUserName);
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(472, 684, 89, 43);
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String fechanac ="";
			fechanac =  new String(formatter.format(dtcFecNac.getDate()));

				String codigo = "codEmp-"+(Tricom.getInstance().getCantRegistros().get(1)+1);
				if(accion == 1)
				{
					if (!(txtNombre.getText().equalsIgnoreCase("")) && !(txtContrasena.getText().equalsIgnoreCase("")) && (txtCedula.getText().equalsIgnoreCase("   -       - ")==false)&& !(txtDireccion.getText().equalsIgnoreCase(""))&& !(txtApellido1.getText().equalsIgnoreCase(""))&& !(txtEmail.getText().equalsIgnoreCase(""))&& !(txtTelefono.getText().equalsIgnoreCase("   -   -    "))) 
					{
						if (cbxCargo.getSelectedIndex() == 0) 
						{
							
							ServicioC vend = new ServicioC(codigo,txtNombre.getText(), txtApellido1.getText(),txtApellido2.getText(), txtCedula.getText(), txtDireccion.getText(),txtTelefono.getText(), txtANota.getText(), (float)spnSalario.getValue(),txtContrasena.getText(),fechanac,cbxSexo.getSelectedItem().toString(),txtEmail.getText());
							Tricom.getInstance().getMisEmpleados().add(vend);
							JOptionPane.showMessageDialog(null, "Empleado registrado.", null, JOptionPane.INFORMATION_MESSAGE,null);
							dispose();
						}
						if (cbxCargo.getSelectedIndex() == 1) 
						{
							Administrativo vend = new Administrativo(codigo,txtNombre.getText(), txtApellido1.getText(),txtApellido2.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText(), txtANota.getText(), (float)spnSalario.getValue(),txtContrasena.getText(),fechanac,cbxSexo.getSelectedItem().toString(),txtEmail.getText());
							Tricom.getInstance().getMisEmpleados().add(vend);
							JOptionPane.showMessageDialog(null, "Empleado registrado.", null, JOptionPane.INFORMATION_MESSAGE,null);
							dispose();
						}
						int cant = Tricom.getInstance().getCantRegistros().get(1);
						Tricom.getInstance().getCantRegistros().set(1, (cant+1));
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
					}
				}else{
					
					if (!(txtNombre.getText().equalsIgnoreCase("")) && !(txtContrasena.getText().equalsIgnoreCase("")) && (txtCedula.getText().equalsIgnoreCase("   -       - ")==false)&& !(txtDireccion.getText().equalsIgnoreCase(""))&& !(txtApellido1.getText().equalsIgnoreCase(""))&& !(txtEmail.getText().equalsIgnoreCase(""))&& !(txtTelefono.getText().equalsIgnoreCase("   -   -    "))) 
					{
						if (cbxCargo.getSelectedIndex() == 0) 
						{
							ServicioC vend = new ServicioC(codigo,txtNombre.getText(), txtApellido1.getText(),txtApellido2.getText(), txtCedula.getText(), txtDireccion.getText(),txtTelefono.getText(), txtANota.getText(), (float)spnSalario.getValue(),txtContrasena.getText(),fechanac,cbxSexo.getSelectedItem().toString(),txtEmail.getText());
							Tricom.getInstance().reemplazarEmpleado(vend);
							JOptionPane.showMessageDialog(null, "Empleado Modificado.", null, JOptionPane.INFORMATION_MESSAGE,null);
							dispose();
						}
						if (cbxCargo.getSelectedIndex() == 1) 
						{
							Administrativo vend = new Administrativo(codigo,txtNombre.getText(), txtApellido1.getText(),txtApellido2.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText(), txtANota.getText(), (float)spnSalario.getValue(),txtContrasena.getText(),fechanac,cbxSexo.getSelectedItem().toString(),txtEmail.getText());
							//Tricom.getInstance().getMisEmpleados().add(vend);
							Tricom.getInstance().reemplazarEmpleado(vend);
							JOptionPane.showMessageDialog(null, "Empleado Modificado.", null, JOptionPane.INFORMATION_MESSAGE,null);
							dispose();
						}
						int cant = Tricom.getInstance().getCantRegistros().get(1);
						Tricom.getInstance().getCantRegistros().set(1, (cant+1));
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
					}
					
				}
				
				TricomMain.cargarJtable(2);
			}
		});
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(573, 684, 89, 43);
		contentPanel.add(btnCerrar);

		JLabel label_1 = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label_1.setBounds(24, 712, 291, 16);
		contentPanel.add(label_1);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		if(accion == 2){
			txtCedula.setEditable(false);
			loadDatos(empleado);
		}
}
 
	public void loadDatos(Empleado cl){
		txtCodigo.setText(cl.getCodigo()); 
		cbxCargo.setSelectedIndex(0);
		txtNombre.setText(cl.getNombre()); 
		txtApellido1.setText(cl.getApellido1());
		txtApellido2.setText(cl.getApellido2());
		txtDireccion.setText(cl.getDireccion());
		txtTelefono.setText(cl.getTelefono());
		txtCedula.setText(cl.getCedula());
		txtANota.setText(cl.getNotamedica());
		txtEmail.setText(cl.getEmail());
		if (cl.getSexo().equalsIgnoreCase("Femenino"))
		{
			cbxSexo.setSelectedIndex(0);
		}else{
			cbxSexo.setSelectedIndex(1);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dt;
		try {
			dt = formatter.parse(cl.getfNacimiento());
			dtcFecNac.setDate(dt);
		} catch (ParseException e) {
	}
}
}

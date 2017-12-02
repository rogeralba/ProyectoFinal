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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.text.ParseException;
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

public class RegistrarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cedulaUser;
	private JTextField nombreUser;
	private JTextField apellidoUser;
	private JTextField correoUser;
	private JTextField direccionUser;
	private JTextField txtTelefono;
	private JComboBox cbxSexo;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private Empleado myvend;
	private boolean option = true;
	private JButton btnAceptar;
	private String[] nombrePlan;
	private int cant=6;
	private DefaultComboBoxModel<String> combonombres;
	private String numberOnly1;
	private JTextField contraUser;
	private JSpinner spnsal;
	private JTextField txtappellido2;
	private JLabel lblNotaMedica;
	private JTextField txtnotam ;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String title = null;
					boolean option = false;
					Empleado cli = null;
					RegistrarEmpleado frame = new RegistrarEmpleado(title,option,cli);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegistrarEmpleado(String title, boolean option, Empleado client) {
		setTitle("Registrar Empleado\r\n");
		setBounds(100, 100, 693, 776);
		setLocationRelativeTo(null);
		setResizable(false);
		this.nombrePlan = new String[cant];
		this.option = option;
		myvend = client;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		cedulaUser = new JFormattedTextField(patron);
		cedulaUser.setFont(new Font("Arial", Font.PLAIN, 15));
		cedulaUser.setBounds(31, 144, 224, 27);
		panel.add(cedulaUser);
		cedulaUser.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(31, 189, 70, 14);
		panel.add(lblNombre);
		
		nombreUser = new JTextField();
		nombreUser.setFont(new Font("Arial", Font.PLAIN, 15));
		nombreUser.setBounds(31, 208, 224, 27);
		panel.add(nombreUser);
		nombreUser.setColumns(10);
		
		JLabel lblApellido = new JLabel("Primer apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido.setBounds(375, 183, 141, 27);
		panel.add(lblApellido);
		
		apellidoUser = new JTextField();
		apellidoUser.setFont(new Font("Arial", Font.PLAIN, 15));
		apellidoUser.setBounds(375, 208, 224, 27);
		panel.add(apellidoUser);
		apellidoUser.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCorreo.setBounds(31, 251, 70, 14);
		panel.add(lblCorreo);
		
		correoUser = new JTextField();
		correoUser.setFont(new Font("Arial", Font.PLAIN, 15));
		correoUser.setBounds(31, 271, 224, 27);
		panel.add(correoUser);
		correoUser.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSexo.setBounds(375, 315, 57, 14);
		panel.add(lblSexo);
		
		cbxSexo = new JComboBox();
		cbxSexo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxSexo.setBackground(Color.WHITE);
		
		cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
		cbxSexo.setBounds(375, 337, 141, 27);
		panel.add(cbxSexo);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion.setBounds(33, 376, 108, 14);
		panel.add(lblDireccion);
		
		direccionUser = new JTextField();
		direccionUser.setFont(new Font("Arial", Font.PLAIN, 15));
		direccionUser.setBounds(31, 398, 292, 27);
		panel.add(direccionUser);
		direccionUser.setColumns(10);
		
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
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasea.setBounds(31, 316, 211, 14);
		panel.add(lblContrasea);
		
		contraUser = new JTextField();
		contraUser.setFont(new Font("Arial", Font.PLAIN, 15));
		contraUser.setBounds(31, 337, 224, 27);
		panel.add(contraUser);
		contraUser.setColumns(10);
		
		JTextField txtnotam = new JTextField();
		txtnotam.setFont(new Font("Arial", Font.PLAIN, 15));
		txtnotam.setColumns(10);
		txtnotam.setBounds(31, 461, 292, 71);
		panel.add(txtnotam);
		
		 lblNotaMedica = new JLabel("Nota Medica:\r\n");
		 lblNotaMedica.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNotaMedica.setBounds(31, 438, 132, 17);
		panel.add(lblNotaMedica);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSalario.setBounds(375, 377, 57, 14);
		panel.add(lblSalario);
		
	 spnsal = new JSpinner();
		spnsal.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnsal.setBounds(375, 398, 141, 27);
		panel.add(spnsal);
		
		txtappellido2 = new JTextField();
		txtappellido2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtappellido2.setColumns(10);
		txtappellido2.setBounds(375, 271, 224, 27);
		panel.add(txtappellido2);
		
		JLabel lblApellido_1 = new JLabel("Segundo apellido:");
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido_1.setBounds(375, 245, 141, 27);
		panel.add(lblApellido_1);
		panel.setEnabled(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setBounds(375, 81, 141, 27);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0){
					panel.setEnabled(false);
				}
				if (comboBox.getSelectedIndex() > 0){
					panel.setEnabled(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Ventas", "Administrativo"}));
		
		JLabel lblNewLabel = new JLabel("Cargo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(375, 56, 62, 27);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(31, 81, 224, 27);
		panel.add(textField);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBackground(Color.GRAY);
		label.setBounds(31, 57, 71, 25);
		panel.add(label);
		
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
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel_1.add(userImg);
		
		JLabel label_14 = new JLabel("Juan Lopez");
		label_14.setBounds(567, 53, 68, 16);
		panel_1.add(label_14);
		{
			 btnAceptar = new JButton("Aceptar");
			 btnAceptar.setBounds(472, 684, 89, 43);
			 contentPanel.add(btnAceptar);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						if(!(nombreUser.getText().equalsIgnoreCase("")) && !(contraUser.getText().equalsIgnoreCase("")) && (cedulaUser.getText().length() == 13) && !(direccionUser.getText().equalsIgnoreCase("") && !(apellidoUser.getText().equalsIgnoreCase("")) && !(correoUser.getText().equalsIgnoreCase("")) && !(txtTelefono.getText().equalsIgnoreCase("")) && cbxSexo.getSelectedIndex()!= 0) )
						{
							
							if (comboBox.getSelectedIndex() == 1){
								ServicioC vend = new ServicioC(nombreUser.getText(),apellidoUser.getText(), txtappellido2.getText(),cedulaUser.getText(),direccionUser.getText(),txtTelefono.getText(),txtnotam.getText(),(float) spnsal.getValue(),contraUser.getText());
								Tricom.getInstance().crearempleado(vend);
								limpiarDialogos();
								JOptionPane.showMessageDialog(null, "Operacion Exitosa", null, JOptionPane.INFORMATION_MESSAGE, null);

							}
							if (comboBox.getSelectedIndex() > 2){
								Administrativo vend = new Administrativo(nombreUser.getText(),apellidoUser.getText(), txtappellido2.getText(),cedulaUser.getText(),direccionUser.getText(),txtTelefono.getText(),txtnotam.getText(),(float) spnsal.getValue(),contraUser.getText());
								Tricom.getInstance().crearempleado(vend);
								limpiarDialogos();
								JOptionPane.showMessageDialog(null, "Operacion Exitosa", null, JOptionPane.INFORMATION_MESSAGE, null);

							}
							String m = correoUser.getText();	
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Los campos con * son obligatorios", null, JOptionPane.INFORMATION_MESSAGE, null);
						}
				}
			});
			getRootPane().setDefaultButton(btnAceptar);
		}
		{
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
		}
		
		cargarModific();
		
		
		
	}
	
	public void limpiarDialogos()
	{
		nombreUser.setText("");
		apellidoUser.setText("");
		cedulaUser.setText("");
		txtTelefono.setText("");
		cbxSexo.setSelectedIndex(0);
		correoUser.setText("");
		direccionUser.setText("");
		contraUser.setText("");
		txtappellido2.setText("");
		txtnotam.setText("");
		
		
	}
	
	public void cargarModific()
	{
		
	}
}

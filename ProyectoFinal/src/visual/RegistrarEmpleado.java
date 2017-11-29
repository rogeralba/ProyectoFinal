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

import logico.Empleados;
import logico.Tricom;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class RegistrarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cedulaUser;
	private JTextField nombreUser;
	private JTextField apellidoUser;
	private JTextField correoUser;
	private JTextField direccionUser;
	private JTextField telefonoUser;
	private JComboBox combosexoUser;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private Empleados myvend;
	private boolean option = true;
	private JButton okButton;
	private String[] nombrePlan;
	private int cant=6;
	private DefaultComboBoxModel<String> combonombres;
	private String numberOnly1;
	private JTextField contraUser;
	private JSpinner spnsal;

	public RegistrarEmpleado(String title, boolean option, Empleados client) {
		setTitle("Registrar Empleado\r\n");
		setBounds(100, 100, 557, 369);
		setLocationRelativeTo(null);
		setResizable(false);
		this.nombrePlan = new String[cant];
		this.option = option;
		myvend = client;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 531, 271);
		contentPanel.add(panel);
		panel.setLayout(null);
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 37, 49, 14);
		panel.add(lblCedula);
		
		cedulaUser = new JFormattedTextField(patron);
		cedulaUser.setBounds(85, 34, 120, 20);
		panel.add(cedulaUser);
		cedulaUser.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 68, 57, 14);
		panel.add(lblNombre);
		
		nombreUser = new JTextField();
		nombreUser.setBounds(85, 65, 120, 20);
		panel.add(nombreUser);
		nombreUser.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(299, 68, 57, 14);
		panel.add(lblApellido);
		
		apellidoUser = new JTextField();
		apellidoUser.setBounds(386, 65, 120, 20);
		panel.add(apellidoUser);
		apellidoUser.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 100, 49, 14);
		panel.add(lblCorreo);
		
		correoUser = new JTextField();
		correoUser.setBounds(85, 97, 168, 20);
		panel.add(correoUser);
		correoUser.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(299, 100, 57, 14);
		panel.add(lblSexo);
		
		combosexoUser = new JComboBox();
		
		combosexoUser.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
		combosexoUser.setBounds(386, 99, 120, 18);
		panel.add(combosexoUser);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 131, 57, 14);
		panel.add(lblDireccion);
		
		direccionUser = new JTextField();
		direccionUser.setBounds(95, 128, 421, 20);
		panel.add(direccionUser);
		direccionUser.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(299, 37, 57, 14);
		panel.add(lblTelefono);
		
		telefonoUser = new JFormattedTextField(tele);
		telefonoUser.setBounds(386, 34, 120, 20);
		panel.add(telefonoUser);
		telefonoUser.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(69, 37, 11, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(69, 68, 11, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(69, 100, 11, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(79, 128, 11, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(365, 37, 11, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(365, 71, 11, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(366, 100, 11, 14);
		panel.add(label_6);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a para acceder al sistema:");
		lblContrasea.setBounds(10, 214, 211, 14);
		panel.add(lblContrasea);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(231, 214, 11, 14);
		panel.add(label_7);
		
		contraUser = new JTextField();
		contraUser.setBounds(252, 211, 140, 20);
		panel.add(contraUser);
		contraUser.setColumns(10);
		
		JTextField txtnotam = new JTextField();
		txtnotam.setColumns(10);
		txtnotam.setBounds(95, 156, 421, 20);
		panel.add(txtnotam);
		
		JLabel lblNotaMedica = new JLabel("Nota Medica:\r\n");
		lblNotaMedica.setBounds(10, 159, 70, 14);
		panel.add(lblNotaMedica);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBounds(79, 156, 11, 14);
		panel.add(label_9);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(10, 190, 57, 14);
		panel.add(lblSalario);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setBounds(79, 187, 11, 14);
		panel.add(label_10);
		
	 spnsal = new JSpinner();
		spnsal.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnsal.setBounds(95, 187, 91, 20);
		panel.add(spnsal);
		
	
		
	
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							if(!(nombreUser.getText().equalsIgnoreCase("")) && !(contraUser.getText().equalsIgnoreCase("")) && (cedulaUser.getText().length() == 13) && !(direccionUser.getText().equalsIgnoreCase("") && !(apellidoUser.getText().equalsIgnoreCase("")) && !(correoUser.getText().equalsIgnoreCase("")) && !(telefonoUser.getText().equalsIgnoreCase("")) && combosexoUser.getSelectedIndex()!= 0) )
							{
								
								
								
								Empleados vend = new Empleados(nombreUser.getText(),apellidoUser.getText(),cedulaUser.getText(),direccionUser.getText(),telefonoUser.getText(),txtnotam.getText(), spnsal.getValue(),contraUser.getText());
								
								Tricom.getInstance().crearempleado(vend);
								String m = correoUser.getText();
								
								
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Los campos con * son obligatorios", null, JOptionPane.INFORMATION_MESSAGE, null);

							}

						
					}
				});
				okButton.setActionCommand("Salvar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarModific();
		
		
		
	}
	
	public void limpiarDialogos()
	{
		nombreUser.setText("");
		apellidoUser.setText("");
		cedulaUser.setText("");
		telefonoUser.setText("");
		combosexoUser.setSelectedIndex(0);
		correoUser.setText("");
		direccionUser.setText("");
		contraUser.setText("");
		
	}
	
	public void cargarModific()
	{
		
	}
	

	
	
	
}

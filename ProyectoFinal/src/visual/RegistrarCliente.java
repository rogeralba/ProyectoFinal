package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setTitle("Registrar Cliente");
		setResizable(false);
		setBounds(100, 100, 540, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 338, 534, 33);
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("Salvar");
		panel.add(btnGuardar);
		
		JButton button_1 = new JButton("Salir");
		button_1.setActionCommand("Cancel");
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 514, 324);
		contentPanel.add(panel_1);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCdula.setBounds(20, 28, 103, 14);
		panel_1.add(lblCdula);
		
		JFormattedTextField txtCedula = new JFormattedTextField((AbstractFormatter) null);
		txtCedula.setColumns(10);
		txtCedula.setBounds(85, 22, 170, 30);
		panel_1.add(txtCedula);
		
		JLabel label_1 = new JLabel("Nombre: ");
		label_1.setFont(new Font("Arial", Font.PLAIN, 17));
		label_1.setBounds(20, 88, 120, 14);
		panel_1.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(85, 80, 149, 30);
		panel_1.add(txtNombre);
		
		JLabel label_2 = new JLabel("Apellido:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 17));
		label_2.setBounds(256, 85, 120, 20);
		panel_1.add(label_2);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(333, 80, 149, 30);
		panel_1.add(txtApellido);
		
		JLabel label_3 = new JLabel("Correo:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 17));
		label_3.setBounds(20, 217, 103, 14);
		panel_1.add(label_3);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(85, 209, 273, 30);
		panel_1.add(txtEmail);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDireccin.setBounds(20, 257, 120, 14);
		panel_1.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(20, 280, 480, 30);
		panel_1.add(txtDireccion);
		
		JLabel lblTelfono = new JLabel("Tel.:");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(20, 156, 67, 14);
		panel_1.add(lblTelfono);
		
		JFormattedTextField txtTelefono = new JFormattedTextField((AbstractFormatter) null);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(85, 148, 149, 30);
		panel_1.add(txtTelefono);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(10, 30, 11, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(10, 90, 11, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBounds(10, 217, 11, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setBounds(10, 259, 11, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setBounds(10, 158, 11, 14);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(244, 90, 11, 14);
		panel_1.add(label_12);
	}
}

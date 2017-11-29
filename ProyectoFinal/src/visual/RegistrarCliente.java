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
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 540, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 94, 514, 353);
		contentPanel.add(panel_1);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setForeground(Color.DARK_GRAY);
		lblCedula.setBackground(Color.GRAY);
		lblCedula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCedula.setBounds(20, 49, 103, 14);
		panel_1.add(lblCedula);
		
		JFormattedTextField txtCedula = new JFormattedTextField((AbstractFormatter) null);
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setColumns(10);
		txtCedula.setBounds(97, 43, 149, 27);
		panel_1.add(txtCedula);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setBackground(Color.GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(20, 111, 120, 14);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.menu);
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 105, 149, 27);
		panel_1.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setBackground(Color.GRAY);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellido.setBounds(264, 108, 120, 20);
		panel_1.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(SystemColor.menu);
		txtApellido.setColumns(10);
		txtApellido.setBounds(333, 105, 167, 27);
		panel_1.add(txtApellido);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setBackground(Color.GRAY);
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreo.setBounds(20, 224, 103, 14);
		panel_1.add(lblCorreo);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setColumns(10);
		txtEmail.setBounds(97, 220, 273, 27);
		panel_1.add(txtEmail);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.DARK_GRAY);
		lblDireccin.setBackground(Color.GRAY);
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDireccin.setBounds(20, 274, 120, 14);
		panel_1.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setBackground(SystemColor.menu);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(20, 309, 480, 27);
		panel_1.add(txtDireccion);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setForeground(Color.DARK_GRAY);
		lblTelfono.setBackground(Color.GRAY);
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(20, 172, 67, 14);
		panel_1.add(lblTelfono);
		
		JFormattedTextField txtTelefono = new JFormattedTextField((AbstractFormatter) null);
		txtTelefono.setBackground(SystemColor.menu);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(97, 166, 149, 27);
		panel_1.add(txtTelefono);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(10, 51, 11, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(10, 113, 11, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBounds(10, 224, 11, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setBounds(10, 276, 11, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setBounds(10, 174, 11, 14);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(252, 111, 11, 14);
		panel_1.add(label_12);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(402, 11, 11, 14);
		panel_1.add(label);
		
		JLabel lblObligatorioDeLlenar = new JLabel("Obligatorio de llenar");
		lblObligatorioDeLlenar.setForeground(Color.DARK_GRAY);
		lblObligatorioDeLlenar.setBackground(Color.GRAY);
		lblObligatorioDeLlenar.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblObligatorioDeLlenar.setBounds(415, 12, 85, 14);
		panel_1.add(lblObligatorioDeLlenar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegistrar.setBounds(435, 452, 89, 38);
		contentPanel.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(336, 452, 89, 38);
		contentPanel.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(10, 0, 514, 95);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistroDeCliente = new JLabel("Registro de Cliente");
		lblRegistroDeCliente.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblRegistroDeCliente.setBounds(128, 27, 310, 40);
		panel.add(lblRegistroDeCliente);
	}
}

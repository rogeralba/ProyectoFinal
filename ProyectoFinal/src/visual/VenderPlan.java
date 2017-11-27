package visual;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenderPlan extends JDialog {
	private JTextField txtCedula;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;

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
	}


	public VenderPlan() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Vender Planes");
		setForeground(SystemColor.textText);
		getContentPane().setForeground(SystemColor.text);
		setResizable(false);
		setBackground(SystemColor.menu);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(1026, 631, 97, 38);
		getContentPane().add(btnAceptar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(917, 631, 97, 38);
		getContentPane().add(btnAtras);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(808, 631, 97, 38);
		getContentPane().add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 0, 1147, 82);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula:");
		lblNewLabel.setBounds(26, 107, 71, 25);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		
		
		Color myGreen = new Color(255, 159, 35);
		JButton btnBuscar = new JButton("");
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
		getContentPane().add(txtCedula);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 260, 1097, 362);
		getContentPane().add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		
		textField = new JTextField();
		textField.setBounds(26, 200, 224, 27);
		getContentPane().add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 176, 71, 25);
		getContentPane().add(lblNombre);
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBackground(Color.GRAY);
		
		textField_3 = new JTextField();
		textField_3.setBounds(262, 200, 224, 27);
		getContentPane().add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(262, 176, 71, 25);
		getContentPane().add(lblApellido);
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellido.setBackground(Color.GRAY);
		
		textField_1 = new JTextField();
		textField_1.setBounds(498, 200, 224, 27);
		getContentPane().add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel lblCdula = new JLabel("Tel\u00E9fono:");
		lblCdula.setBounds(498, 176, 71, 25);
		getContentPane().add(lblCdula);
		lblCdula.setForeground(Color.DARK_GRAY);
		lblCdula.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCdula.setBackground(Color.GRAY);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(734, 200, 347, 27);
		getContentPane().add(textField_2);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.DARK_GRAY);
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccin.setBackground(Color.GRAY);
		lblDireccin.setBounds(734, 176, 71, 25);
		getContentPane().add(lblDireccin);
		
		
		
		
		setBounds(100, 100, 1153, 717);

	}
}

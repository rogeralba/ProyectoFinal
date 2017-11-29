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
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class VenderPlan extends JDialog {
	private JTextField txtCedula;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

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
		
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		JButton btnAceptar = new JButton("Aceptar");
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(25, 51, 224, 27);
		panel_2.add(comboBox);
		
		JLabel lblTarifaMensual = new JLabel("Duraci\u00F3n:");
		lblTarifaMensual.setForeground(Color.DARK_GRAY);
		lblTarifaMensual.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifaMensual.setBackground(Color.GRAY);
		lblTarifaMensual.setBounds(284, 24, 112, 25);
		panel_2.add(lblTarifaMensual);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"18"}));
		comboBox_1.setBounds(284, 50, 112, 27);
		comboBox_1.setBackground(Color.WHITE);
		panel_2.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(428, 51, 112, 27);
		panel_2.add(textField_4);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setForeground(Color.DARK_GRAY);
		lblTarifa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifa.setBackground(Color.GRAY);
		lblTarifa.setBounds(428, 27, 71, 25);
		panel_2.add(lblTarifa);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(570, 51, 112, 27);
		panel_2.add(textField_5);
		
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(12, 56, 118, 27);
		textField_7.setBackground(SystemColor.menu);
		panel.add(textField_7);
		
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
		
		JRadioButton rdbInter1 = new JRadioButton("");
		rdbInter1.setBounds(30, 235, 31, 25);
		rdbInter1.setBackground(Color.white);
		panel.add(rdbInter1);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(99, 235, 31, 25);
		panel.add(radioButton);
		
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
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(99, 180, 31, 25);
		panel.add(radioButton_1);
		
		JLabel label = new JLabel("No:");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBackground(Color.GRAY);
		label.setBounds(78, 180, 25, 25);
		panel.add(label);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(30, 180, 31, 25);
		panel.add(radioButton_2);
		
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
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setBounds(30, 119, 31, 25);
		panel.add(radioButton_3);
		
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
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBackground(Color.WHITE);
		radioButton_4.setBounds(99, 119, 31, 25);
		panel.add(radioButton_4);
		
		JLabel lblDesvo = new JLabel("Desv\u00EDo:");
		lblDesvo.setForeground(Color.DARK_GRAY);
		lblDesvo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDesvo.setBackground(Color.GRAY);
		lblDesvo.setBounds(216, 32, 54, 25);
		panel.add(lblDesvo);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBackground(Color.WHITE);
		radioButton_5.setBounds(234, 55, 31, 25);
		panel.add(radioButton_5);
		
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
		
		JRadioButton radioButton_6 = new JRadioButton("");
		radioButton_6.setBackground(Color.WHITE);
		radioButton_6.setBounds(303, 55, 31, 25);
		panel.add(radioButton_6);
		
		textField_11 = new JTextField();
		textField_11.setBackground(SystemColor.menu);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(216, 113, 91, 27);
		panel.add(textField_11);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio.setBackground(Color.GRAY);
		lblPrecio.setBounds(216, 89, 58, 25);
		panel.add(lblPrecio);
		
		textField_12 = new JTextField();
		textField_12.setBackground(SystemColor.menu);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(216, 174, 91, 27);
		panel.add(textField_12);
		
		JLabel lblImpuestos_1 = new JLabel("Impuestos:");
		lblImpuestos_1.setForeground(Color.DARK_GRAY);
		lblImpuestos_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos_1.setBackground(Color.GRAY);
		lblImpuestos_1.setBounds(216, 150, 91, 25);
		panel.add(lblImpuestos_1);
		
		JButton button_1 = new JButton("Equipo");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(new Color(244, 164, 96));
		button_1.setBounds(216, 220, 91, 40);
		panel.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Internet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(379, 90, 342, 290);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.menu);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(24, 55, 91, 27);
		panel_3.add(textField_8);
		
		JLabel lblMegas = new JLabel("Megas:");
		lblMegas.setForeground(Color.DARK_GRAY);
		lblMegas.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMegas.setBackground(Color.GRAY);
		lblMegas.setBounds(24, 31, 58, 25);
		panel_3.add(lblMegas);
		
		textField_9 = new JTextField();
		textField_9.setBackground(SystemColor.menu);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(24, 119, 91, 27);
		panel_3.add(textField_9);
		
		JLabel lblVelocidadDeSubida = new JLabel("Velocidad de subida:");
		lblVelocidadDeSubida.setForeground(Color.DARK_GRAY);
		lblVelocidadDeSubida.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidadDeSubida.setBackground(Color.GRAY);
		lblVelocidadDeSubida.setBounds(24, 95, 148, 25);
		panel_3.add(lblVelocidadDeSubida);
		
		textField_10 = new JTextField();
		textField_10.setBackground(SystemColor.menu);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(24, 183, 91, 27);
		panel_3.add(textField_10);
		
		JLabel lblVelocidadDeBajada = new JLabel("Velocidad de bajada:");
		lblVelocidadDeBajada.setForeground(Color.DARK_GRAY);
		lblVelocidadDeBajada.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidadDeBajada.setBackground(Color.GRAY);
		lblVelocidadDeBajada.setBounds(24, 159, 163, 25);
		panel_3.add(lblVelocidadDeBajada);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBackground(SystemColor.menu);
		textField_13.setBounds(215, 55, 91, 27);
		panel_3.add(textField_13);
		
		JLabel label_2 = new JLabel("Precio:");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(215, 31, 58, 25);
		panel_3.add(label_2);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBackground(SystemColor.menu);
		textField_14.setBounds(215, 119, 91, 27);
		panel_3.add(textField_14);
		
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
		btnNewButton.setBounds(215, 220, 91, 40);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telecable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(733, 91, 342, 289);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBackground(SystemColor.menu);
		textField_15.setBounds(22, 56, 91, 27);
		panel_4.add(textField_15);
		
		JLabel lblCanales = new JLabel("Canales:");
		lblCanales.setForeground(Color.DARK_GRAY);
		lblCanales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCanales.setBackground(Color.GRAY);
		lblCanales.setBounds(22, 32, 91, 25);
		panel_4.add(lblCanales);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBackground(SystemColor.menu);
		textField_16.setBounds(22, 120, 91, 27);
		panel_4.add(textField_16);
		
		JLabel lblLocales = new JLabel("Locales:");
		lblLocales.setForeground(Color.DARK_GRAY);
		lblLocales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLocales.setBackground(Color.GRAY);
		lblLocales.setBounds(22, 96, 91, 25);
		panel_4.add(lblLocales);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBackground(SystemColor.menu);
		textField_17.setBounds(22, 184, 91, 27);
		panel_4.add(textField_17);
		
		JLabel lblInternacionales = new JLabel("Internacionales:");
		lblInternacionales.setForeground(Color.DARK_GRAY);
		lblInternacionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInternacionales.setBackground(Color.GRAY);
		lblInternacionales.setBounds(22, 160, 108, 25);
		panel_4.add(lblInternacionales);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBackground(SystemColor.menu);
		textField_18.setBounds(219, 56, 91, 27);
		panel_4.add(textField_18);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setForeground(Color.DARK_GRAY);
		lblPrecio_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio_1.setBackground(Color.GRAY);
		lblPrecio_1.setBounds(219, 32, 91, 25);
		panel_4.add(lblPrecio_1);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBackground(SystemColor.menu);
		textField_19.setBounds(219, 120, 91, 27);
		panel_4.add(textField_19);
		
		JLabel label_12 = new JLabel("Impuestos:");
		label_12.setForeground(Color.DARK_GRAY);
		label_12.setFont(new Font("Arial", Font.PLAIN, 16));
		label_12.setBackground(Color.GRAY);
		label_12.setBounds(219, 96, 91, 25);
		panel_4.add(label_12);
		
		JButton btnHd = new JButton("HD");
		btnHd.setForeground(Color.WHITE);
		btnHd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHd.setBackground(new Color(244, 164, 96));
		btnHd.setBounds(219, 220, 91, 40);
		panel_4.add(btnHd);
		
		JLabel lblInstalacin = new JLabel("Instalaci\u00F3n:");
		lblInstalacin.setForeground(Color.DARK_GRAY);
		lblInstalacin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInstalacin.setBackground(Color.GRAY);
		lblInstalacin.setBounds(711, 27, 81, 25);
		panel_2.add(lblInstalacin);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(711, 51, 112, 27);
		panel_2.add(textField_6);
		
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
		
		JLabel label_8 = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label_8.setBounds(26, 702, 291, 16);
		getContentPane().add(label_8);
		
		
		
		
		setBounds(100, 100, 1153, 771);

	}
}

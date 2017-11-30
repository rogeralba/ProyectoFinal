package visual;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegistrarPlan extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPlan dialog = new RegistrarPlan();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPlan() {
		setResizable(false);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(100, 100, 756, 609);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 738, 82);
		getContentPane().add(panel);
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 84, 82);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel.add(imgLogo);
		
		JLabel lblRegistrarNuevoPlan = new JLabel("Registrar Plan");
		lblRegistrarNuevoPlan.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRegistrarNuevoPlan.setBounds(142, 13, 389, 56);
		panel.add(lblRegistrarNuevoPlan);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(630, 13, 45, 42);
		panel.add(userImg);
		
		JLabel label_3 = new JLabel("Juan Lopez");
		label_3.setBounds(622, 53, 68, 16);
		String path2 = "./Imagenes/user.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(22, 111, 694, 377);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(442, 40, 224, 27);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombreDelPlan = new JLabel("Nombre del Plan:");
		lblNombreDelPlan.setBounds(442, 13, 134, 25);
		panel_1.add(lblNombreDelPlan);
		lblNombreDelPlan.setForeground(Color.DARK_GRAY);
		lblNombreDelPlan.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombreDelPlan.setBackground(Color.GRAY);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(Color.DARK_GRAY);
		lblDescripcin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDescripcin.setBackground(Color.GRAY);
		lblDescripcin.setBounds(24, 83, 134, 25);
		panel_1.add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(24, 111, 400, 160);
		textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel_1.add(textArea);
		
		JLabel lblServicioTelefnico = new JLabel("Servicio telef\u00F3nico:");
		lblServicioTelefnico.setForeground(Color.DARK_GRAY);
		lblServicioTelefnico.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioTelefnico.setBackground(Color.GRAY);
		lblServicioTelefnico.setBounds(442, 83, 134, 25);
		panel_1.add(lblServicioTelefnico);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setEnabled(false);
		comboBox.setBounds(442, 109, 224, 27);
		panel_1.add(comboBox);
		
		JLabel lblServicioDeInternet = new JLabel("Servicio de Internet:");
		lblServicioDeInternet.setForeground(Color.DARK_GRAY);
		lblServicioDeInternet.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioDeInternet.setBackground(Color.GRAY);
		lblServicioDeInternet.setBounds(442, 152, 146, 25);
		panel_1.add(lblServicioDeInternet);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(442, 178, 224, 27);
		panel_1.add(comboBox_1);
		
		JLabel lblServicioDeTelecable = new JLabel("Servicio de telecable:");
		lblServicioDeTelecable.setForeground(Color.DARK_GRAY);
		lblServicioDeTelecable.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioDeTelecable.setBackground(Color.GRAY);
		lblServicioDeTelecable.setBounds(442, 218, 172, 25);
		panel_1.add(lblServicioDeTelecable);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(442, 244, 224, 27);
		panel_1.add(comboBox_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(24, 320, 189, 27);
		panel_1.add(textField_2);
		
		JLabel lblTarifaMensual = new JLabel("Tarifa mensual:");
		lblTarifaMensual.setForeground(Color.DARK_GRAY);
		lblTarifaMensual.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifaMensual.setBackground(Color.GRAY);
		lblTarifaMensual.setBounds(24, 292, 134, 25);
		panel_1.add(lblTarifaMensual);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(235, 320, 189, 27);
		panel_1.add(textField_3);
		
		JLabel lblImpuestos = new JLabel("Impuestos:");
		lblImpuestos.setForeground(Color.DARK_GRAY);
		lblImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos.setBackground(Color.GRAY);
		lblImpuestos.setBounds(235, 292, 134, 25);
		panel_1.add(lblImpuestos);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(442, 320, 224, 27);
		panel_1.add(textField_4);
		
		JLabel lblPrecioDeInstalacin = new JLabel("Precio de instalaci\u00F3n:");
		lblPrecioDeInstalacin.setForeground(Color.DARK_GRAY);
		lblPrecioDeInstalacin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecioDeInstalacin.setBackground(Color.GRAY);
		lblPrecioDeInstalacin.setBounds(442, 292, 172, 25);
		panel_1.add(lblPrecioDeInstalacin);
		
		textField = new JTextField();
		textField.setBounds(24, 41, 224, 27);
		panel_1.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(24, 17, 71, 25);
		panel_1.add(lblCdigo);
		lblCdigo.setForeground(Color.DARK_GRAY);
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCdigo.setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(510, 506, 97, 36);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Aceptar");
		button.setBounds(619, 506, 97, 36);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		lblNewLabel.setBounds(22, 533, 291, 16);
		getContentPane().add(lblNewLabel);

	}
}

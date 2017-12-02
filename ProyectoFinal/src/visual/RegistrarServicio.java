package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegistrarServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner txtImpuestos;
	private JTextField txtCodigo;
	private JSpinner txtInstalacion;
	private JSpinner txtTarifa;
	private JSpinner spnVelocidad;
	private JSpinner spnSubida;
	private JSpinner txtMinutos;
	private JSpinner txtLocales;
	private JSpinner txtInter;
	private JSpinner txtHD;
	JRadioButton rdbCable;
	JRadioButton rdbInternet;
	JRadioButton rdbTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarServicio dialog = new RegistrarServicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarServicio() {
		setBounds(100, 100, 738, 912);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 720, 82);
		contentPanel.add(panel);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 84, 82);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel.add(imgLogo);
		
		JLabel lblRegistrarServicio = new JLabel("Registro de Servicio");
		lblRegistrarServicio.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRegistrarServicio.setBounds(142, 13, 389, 56);
		panel.add(lblRegistrarServicio);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(626, 13, 45, 42);
		String path2 = "./Imagenes/user.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(userImg);
		
		JLabel label_3 = new JLabel("Juan Lopez");
		label_3.setBounds(618, 53, 68, 16);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(25, 111, 672, 672);
		contentPanel.add(panel_1);
		
		txtImpuestos = new JSpinner();
		txtImpuestos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtImpuestos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtImpuestos.setBounds(425, 114, 224, 27);
		panel_1.add(txtImpuestos);
		
		JLabel lblImpuestos = new JLabel("Impuestos:");
		lblImpuestos.setForeground(Color.DARK_GRAY);
		lblImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos.setBackground(Color.GRAY);
		lblImpuestos.setBounds(425, 87, 156, 25);
		panel_1.add(lblImpuestos);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(24, 41, 224, 27);
		panel_1.add(txtCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.DARK_GRAY);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCodigo.setBackground(Color.GRAY);
		lblCodigo.setBounds(24, 17, 71, 25);
		panel_1.add(lblCodigo);
		
		JLabel lblTipoDeServicio = new JLabel("Tipo de servicio:");
		lblTipoDeServicio.setForeground(Color.DARK_GRAY);
		lblTipoDeServicio.setFont(new Font("Arial", Font.BOLD, 16));
		lblTipoDeServicio.setBackground(Color.GRAY);
		lblTipoDeServicio.setBounds(24, 159, 136, 25);
		panel_1.add(lblTipoDeServicio);
		
		txtInstalacion = new JSpinner();
		txtInstalacion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInstalacion.setBounds(425, 44, 224, 27);
		panel_1.add(txtInstalacion);
		
		JLabel lblInstalacion = new JLabel("Precio de intalaci\u00F3n:");
		lblInstalacion.setForeground(Color.DARK_GRAY);
		lblInstalacion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInstalacion.setBackground(Color.GRAY);
		lblInstalacion.setBounds(425, 17, 156, 25);
		panel_1.add(lblInstalacion);
		
		txtTarifa = new JSpinner();
		txtTarifa.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		txtTarifa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTarifa.setBounds(24, 114, 224, 27);
		panel_1.add(txtTarifa);
		
		JLabel lblTarifa = new JLabel("Tarifa base:");
		lblTarifa.setForeground(Color.DARK_GRAY);
		lblTarifa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifa.setBackground(Color.GRAY);
		lblTarifa.setBounds(24, 87, 156, 25);
		panel_1.add(lblTarifa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Internet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(24, 235, 625, 127);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		spnVelocidad = new JSpinner();
		spnVelocidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnVelocidad.setBounds(20, 54, 136, 27);
		panel_2.add(spnVelocidad);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setForeground(Color.DARK_GRAY);
		lblVelocidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidad.setBackground(Color.GRAY);
		lblVelocidad.setBounds(20, 27, 156, 25);
		panel_2.add(lblVelocidad);
		
		JLabel lblNewLabel = new JLabel("Mbps");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(159, 65, 56, 16);
		panel_2.add(lblNewLabel);
		
		spnSubida = new JSpinner();
		spnSubida.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnSubida.setBackground(SystemColor.text);
		spnSubida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnSubida.setBounds(227, 54, 136, 27);
		panel_2.add(spnSubida);
		
		JLabel lblMbp = new JLabel("KB/s");
		lblMbp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMbp.setBounds(366, 65, 40, 16);
		panel_2.add(lblMbp);
		
		JLabel lblVelocidadDeSubida = new JLabel("Velocidad de subida:");
		lblVelocidadDeSubida.setForeground(Color.DARK_GRAY);
		lblVelocidadDeSubida.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidadDeSubida.setBackground(Color.GRAY);
		lblVelocidadDeSubida.setBounds(227, 27, 156, 25);
		panel_2.add(lblVelocidadDeSubida);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tel\u00E9fono", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(24, 375, 625, 119);
		panel_1.add(panel_3);
		
		txtMinutos = new JSpinner();
		txtMinutos.setEnabled(false);
		txtMinutos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtMinutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMinutos.setBounds(20, 54, 166, 27);
		panel_3.add(txtMinutos);
		
		JLabel lblCantidadDeMinutos = new JLabel("Cantidad de minutos:");
		lblCantidadDeMinutos.setForeground(Color.DARK_GRAY);
		lblCantidadDeMinutos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidadDeMinutos.setBackground(Color.GRAY);
		lblCantidadDeMinutos.setBounds(20, 27, 156, 25);
		panel_3.add(lblCantidadDeMinutos);
		
		rdbInternet = new JRadioButton("Internet");
		rdbInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbInternet.setSelected(true);
				rdbCable.setSelected(false);
				rdbTelefono.setSelected(false);
				spnVelocidad.setEnabled(true);
				spnSubida.setEnabled(true);
				txtMinutos.setEnabled(false);
				txtInter.setEnabled(false);
				txtLocales.setEnabled(false);
				txtHD.setEnabled(false);		
		}
		});
		rdbInternet.setBackground(SystemColor.text);
		rdbInternet.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbInternet.setBounds(34, 187, 127, 25);
		rdbInternet.setSelected(true);
		panel_1.add(rdbInternet);
		
		rdbCable = new JRadioButton("Telecable");
		rdbCable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbCable.setSelected(true);
				rdbInternet.setSelected(false);
				rdbTelefono.setSelected(false);
				spnVelocidad.setEnabled(false);
				spnSubida.setEnabled(false);
				txtMinutos.setEnabled(false);
				txtInter.setEnabled(true);
				txtLocales.setEnabled(true);
				txtHD.setEnabled(true);
			}
		});
		rdbCable.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbCable.setBackground(Color.WHITE);
		rdbCable.setBounds(522, 187, 127, 25);
		panel_1.add(rdbCable);
		
		rdbTelefono = new JRadioButton("Tel\u00E9fono");
		rdbTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbTelefono.setSelected(true);
				rdbInternet.setSelected(false);
				rdbCable.setSelected(false);
				spnVelocidad.setEnabled(false);
				spnSubida.setEnabled(false);
				txtMinutos.setEnabled(true);
				txtInter.setEnabled(false);
				txtLocales.setEnabled(false);
				txtHD.setEnabled(false);
			}
		});
		rdbTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbTelefono.setBackground(Color.WHITE);
		rdbTelefono.setBounds(294, 187, 117, 25);
		panel_1.add(rdbTelefono);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telecable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(24, 507, 625, 119);
		panel_1.add(panel_4);
		
		txtLocales = new JSpinner();
		txtLocales.setEnabled(false);
		txtLocales.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtLocales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLocales.setBounds(20, 54, 166, 27);
		panel_4.add(txtLocales);
		
		JLabel lblCantidadDeCanales = new JLabel("Locales");
		lblCantidadDeCanales.setForeground(Color.DARK_GRAY);
		lblCantidadDeCanales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidadDeCanales.setBackground(Color.GRAY);
		lblCantidadDeCanales.setBounds(20, 27, 156, 25);
		panel_4.add(lblCantidadDeCanales);
		
		JLabel lblLocales = new JLabel("Internacionales:");
		lblLocales.setForeground(Color.DARK_GRAY);
		lblLocales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLocales.setBackground(Color.GRAY);
		lblLocales.setBounds(227, 27, 156, 25);
		panel_4.add(lblLocales);
		
		txtInter = new JSpinner();
		txtInter.setEnabled(false);
		txtInter.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtInter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInter.setBounds(227, 54, 166, 27);
		panel_4.add(txtInter);
		
		txtHD = new JSpinner();
		txtHD.setEnabled(false);
		txtHD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHD.setBounds(436, 54, 166, 27);
		panel_4.add(txtHD);
		
		JLabel lblInternacionales = new JLabel("En HD:");
		lblInternacionales.setForeground(Color.DARK_GRAY);
		lblInternacionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInternacionales.setBackground(Color.GRAY);
		lblInternacionales.setBounds(436, 27, 156, 25);
		panel_4.add(lblInternacionales);
		
		JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label.setBounds(25, 825, 291, 16);
		contentPanel.add(label);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(600, 806, 97, 40);
		contentPanel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(490, 806, 97, 40);
		contentPanel.add(btnCancelar);
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
	}
}

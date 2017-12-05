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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import logico.AparatoTelefonico;
import logico.Cable;
import logico.Internet;
import logico.Paquete;
import logico.Servicio;
import logico.Telefono;
import logico.Tricom;

import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegistrarServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnImpuestos;
	private JTextField txtCodigo;
	private JSpinner spnInstalacion;
	private JSpinner spnTarifa;
	private JSpinner spnVelocidad;
	private JSpinner spnSubida;
	private JSpinner spnMinutos;
	private JSpinner spnLocales;
	private JSpinner spnInter;
	private JSpinner spnHD;
	JRadioButton rdbCable;
	JRadioButton rdbInternet;
	JRadioButton rdbTelefono;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			RegistrarServicio dialog = new RegistrarServicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public RegistrarServicio(Servicio servicio, int accion) {//accion: 1-Registrar (El parametro empleado es NULL), 2-Modificar
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
		
		spnImpuestos = new JSpinner();
		spnImpuestos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnImpuestos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnImpuestos.setBounds(425, 114, 224, 27);
		panel_1.add(spnImpuestos);
		
		JLabel lblImpuestos = new JLabel("Impuestos:");
		lblImpuestos.setForeground(Color.DARK_GRAY);
		lblImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos.setBackground(Color.GRAY);
		lblImpuestos.setBounds(425, 87, 156, 25);
		panel_1.add(lblImpuestos);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(24, 41, 224, 27);
		txtCodigo.setText("codSer-"+(Tricom.getInstance().getCantRegistros().get(3)+1));
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
		
		spnInstalacion = new JSpinner();
		spnInstalacion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnInstalacion.setBounds(425, 44, 224, 27);
		panel_1.add(spnInstalacion);
		
		JLabel lblInstalacion = new JLabel("Precio de intalaci\u00F3n:");
		lblInstalacion.setForeground(Color.DARK_GRAY);
		lblInstalacion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInstalacion.setBackground(Color.GRAY);
		lblInstalacion.setBounds(425, 17, 156, 25);
		panel_1.add(lblInstalacion);
		
		spnTarifa = new JSpinner();
		spnTarifa.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spnTarifa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnTarifa.setBounds(24, 114, 224, 27);
		panel_1.add(spnTarifa);
		
		JLabel lblTarifa = new JLabel("Tarifa base:");
		lblTarifa.setForeground(Color.DARK_GRAY);
		lblTarifa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifa.setBackground(Color.GRAY);
		lblTarifa.setBounds(24, 87, 156, 25);
		panel_1.add(lblTarifa);
		
		JPanel panelInter = new JPanel();
		panelInter.setBorder(new TitledBorder(null, "Internet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInter.setBackground(SystemColor.text);
		panelInter.setBounds(24, 235, 625, 127);
		panel_1.add(panelInter);
		panelInter.setLayout(null);
		
		spnVelocidad = new JSpinner();
		spnVelocidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnVelocidad.setBounds(20, 54, 136, 27);
		panelInter.add(spnVelocidad);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setForeground(Color.DARK_GRAY);
		lblVelocidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidad.setBackground(Color.GRAY);
		lblVelocidad.setBounds(20, 27, 156, 25);
		panelInter.add(lblVelocidad);
		
		JLabel lblNewLabel = new JLabel("Mbps");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(159, 65, 56, 16);
		panelInter.add(lblNewLabel);
		
		spnSubida = new JSpinner();
		spnSubida.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnSubida.setBackground(SystemColor.text);
		spnSubida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnSubida.setBounds(227, 54, 136, 27);
		panelInter.add(spnSubida);
		
		JLabel lblMbp = new JLabel("KB/s");
		lblMbp.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMbp.setBounds(366, 65, 40, 16);
		panelInter.add(lblMbp);
		
		JLabel lblVelocidadDeSubida = new JLabel("Velocidad de subida:");
		lblVelocidadDeSubida.setForeground(Color.DARK_GRAY);
		lblVelocidadDeSubida.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVelocidadDeSubida.setBackground(Color.GRAY);
		lblVelocidadDeSubida.setBounds(227, 27, 156, 25);
		panelInter.add(lblVelocidadDeSubida);
		
		JPanel panelTele = new JPanel();
		panelTele.setLayout(null);
		panelTele.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tel\u00E9fono", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTele.setBackground(Color.WHITE);
		panelTele.setBounds(24, 375, 625, 119);
		panel_1.add(panelTele);
		
		spnMinutos = new JSpinner();
		spnMinutos.setEnabled(false);
		spnMinutos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnMinutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnMinutos.setBounds(20, 54, 166, 27);
		panelTele.add(spnMinutos);
		
		JLabel lblCantidadDeMinutos = new JLabel("Cantidad de minutos:");
		lblCantidadDeMinutos.setForeground(Color.DARK_GRAY);
		lblCantidadDeMinutos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidadDeMinutos.setBackground(Color.GRAY);
		lblCantidadDeMinutos.setBounds(20, 27, 156, 25);
		panelTele.add(lblCantidadDeMinutos);
		
		rdbInternet = new JRadioButton("Internet");
		rdbInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbInternet.setSelected(true);
				rdbCable.setSelected(false);
				rdbTelefono.setSelected(false);
				spnVelocidad.setEnabled(true);
				spnSubida.setEnabled(true);
				spnMinutos.setEnabled(false);
				spnInter.setEnabled(false);
				spnLocales.setEnabled(false);
				spnHD.setEnabled(false);		
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
				spnMinutos.setEnabled(false);
				spnInter.setEnabled(true);
				spnLocales.setEnabled(true);
				spnHD.setEnabled(true);
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
				spnMinutos.setEnabled(true);
				spnInter.setEnabled(false);
				spnLocales.setEnabled(false);
				spnHD.setEnabled(false);
			}
		});
		rdbTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbTelefono.setBackground(Color.WHITE);
		rdbTelefono.setBounds(294, 187, 117, 25);
		panel_1.add(rdbTelefono);
		
		JPanel panelCable = new JPanel();
		panelCable.setLayout(null);
		panelCable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telecable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCable.setBackground(Color.WHITE);
		panelCable.setBounds(24, 507, 625, 119);
		panel_1.add(panelCable);
		
		spnLocales = new JSpinner();
		spnLocales.setEnabled(false);
		spnLocales.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLocales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnLocales.setBounds(20, 54, 166, 27);
		panelCable.add(spnLocales);
		
		JLabel lblCantidadDeCanales = new JLabel("Locales");
		lblCantidadDeCanales.setForeground(Color.DARK_GRAY);
		lblCantidadDeCanales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidadDeCanales.setBackground(Color.GRAY);
		lblCantidadDeCanales.setBounds(20, 27, 156, 25);
		panelCable.add(lblCantidadDeCanales);
		
		JLabel lblLocales = new JLabel("Internacionales:");
		lblLocales.setForeground(Color.DARK_GRAY);
		lblLocales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLocales.setBackground(Color.GRAY);
		lblLocales.setBounds(227, 27, 156, 25);
		panelCable.add(lblLocales);
		
		spnInter = new JSpinner();
		spnInter.setEnabled(false);
		spnInter.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnInter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnInter.setBounds(227, 54, 166, 27);
		panelCable.add(spnInter);
		
		spnHD = new JSpinner();
		spnHD.setEnabled(false);
		spnHD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnHD.setBounds(436, 54, 166, 27);
		panelCable.add(spnHD);
		
		JLabel lblInternacionales = new JLabel("En HD:");
		lblInternacionales.setForeground(Color.DARK_GRAY);
		lblInternacionales.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInternacionales.setBackground(Color.GRAY);
		lblInternacionales.setBounds(436, 27, 156, 25);
		panelCable.add(lblInternacionales);
		
		JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label.setBounds(25, 825, 291, 16);
		contentPanel.add(label);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicio servicio = null;
				int impuestos = Integer.parseInt(spnImpuestos.getValue().toString());
				float instalacion = Float.parseFloat(spnInstalacion.getValue().toString());
				float tarifa = Float.parseFloat(spnTarifa.getValue().toString());
				int velocidad = Integer.parseInt(spnVelocidad.getValue().toString());
				int subida = Integer.parseInt(spnSubida.getValue().toString());
				int minutos = Integer.parseInt(spnMinutos.getValue().toString());
				int locales = Integer.parseInt(spnLocales.getValue().toString());
				int internacionales = Integer.parseInt(spnInter.getValue().toString());
				int hd = Integer.parseInt(spnHD.getValue().toString());
				
				String codigo = "codSer-"+(Tricom.getInstance().getCantRegistros().get(3)+1);
				
				if(rdbInternet.isSelected())
				{
					servicio = new Internet(codigo,impuestos,instalacion,tarifa+impuestos,velocidad,subida);
				}
				if(rdbTelefono.isSelected())
				{
					AparatoTelefonico aparato = null;
					servicio = new Telefono(codigo,impuestos,instalacion,tarifa+impuestos,minutos,false,false,false,false,aparato); 
				}
				if(rdbCable.isSelected())
				{
					ArrayList<Paquete> misPaquetes = null;
					servicio = new Cable(codigo,impuestos,instalacion,tarifa+impuestos,locales+internacionales,locales,internacionales,hd,misPaquetes,false); 
				}
				
				if(accion == 2){
					Tricom.getInstance().reemplazarServicio(servicio);	
					JOptionPane.showMessageDialog(null, "Modificacion satisfactoria");
				dispose();
				}else{
				Tricom.getInstance().getMisServicios().add(servicio);
				
				int cant = Tricom.getInstance().getCantRegistros().get(3);
				Tricom.getInstance().getCantRegistros().set(3, (cant+1));
				JOptionPane.showMessageDialog(null, "Registro satisfactorio");
				}
				dispose();
				
		}
			
		});
		btnAceptar.setBounds(600, 806, 97, 40);
		contentPanel.add(btnAceptar);
		
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
		if(accion  ==2 ){
			load(servicio);
		}
	}
	
	public void load(Servicio ser ){
		txtCodigo.setText(ser.getCodServicio());
		spnImpuestos.setValue(ser.getImpuestos());
	spnInstalacion.setValue(ser.getPrecioInstalacion());
	spnTarifa.setValue(ser.getTarifa());
	
	if(ser instanceof Internet){
	rdbInternet.setSelected(true);
	
		 
		spnVelocidad.setValue(((Internet)ser).getVelocidad());
		spnSubida.setValue(((Internet)ser).getVelSubida());
		}
	if(ser instanceof Telefono){
		rdbTelefono.setSelected(true);
		
			 
		spnMinutos.setValue(((Telefono)ser).getMinutos());
			}
	if(ser instanceof Cable){
		rdbCable.setSelected(true);
		
			 
		spnLocales.setValue(((Cable)ser).getLocales());
		spnInter.setValue(((Cable)ser).getInternacionales());
		spnHD.setValue(((Cable)ser).getCantCanalesHD());
			}
	
	
		
	}
}

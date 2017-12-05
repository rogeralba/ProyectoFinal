package visual;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import logico.Cable;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;
import logico.Tricom;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegistrarPlan extends JDialog {
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTarifa;
	private JTextField txtImpuestos;
	private JTextField txtInstalacion;
	private JComboBox cbxTelefono;
	private JComboBox cbxInternet;
	private JComboBox cbxCable;
private JTextArea txtADescripcion;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPlan dialog = new RegistrarPlan(null,1);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrarPlan(Plan plan, int accion) {//accion: 1-Registrar (El parametro plan es NULL), 2-Modificar
		setResizable(false);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(100, 100, 742, 609);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
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
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(442, 40, 224, 27);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
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
		
		 txtADescripcion = new JTextArea();
		txtADescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtADescripcion.setWrapStyleWord(true);
		txtADescripcion.setLineWrap(true);
		txtADescripcion.setBounds(24, 111, 400, 160);
		txtADescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel_1.add(txtADescripcion);
		
		JLabel lblServicioTelefnico = new JLabel("Servicio telef\u00F3nico:");
		lblServicioTelefnico.setForeground(Color.DARK_GRAY);
		lblServicioTelefnico.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioTelefnico.setBackground(Color.GRAY);
		lblServicioTelefnico.setBounds(442, 83, 134, 25);
		panel_1.add(lblServicioTelefnico);
		
		cbxTelefono = new JComboBox();
		cbxTelefono.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar"}));
		cbxTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarCostos();
			}
		});
		cbxTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxTelefono.setBounds(442, 109, 224, 27);
		
		panel_1.add(cbxTelefono);
		
		JLabel lblServicioDeInternet = new JLabel("Servicio de Internet:");
		lblServicioDeInternet.setForeground(Color.DARK_GRAY);
		lblServicioDeInternet.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioDeInternet.setBackground(Color.GRAY);
		lblServicioDeInternet.setBounds(442, 152, 146, 25);
		panel_1.add(lblServicioDeInternet);
		
		cbxInternet = new JComboBox();
		cbxInternet.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar"}));
		cbxInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarCostos();
			}
		});
		cbxInternet.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxInternet.setBounds(442, 178, 224, 27);
		panel_1.add(cbxInternet);
		
		JLabel lblServicioDeTelecable = new JLabel("Servicio de telecable:");
		lblServicioDeTelecable.setForeground(Color.DARK_GRAY);
		lblServicioDeTelecable.setFont(new Font("Arial", Font.PLAIN, 16));
		lblServicioDeTelecable.setBackground(Color.GRAY);
		lblServicioDeTelecable.setBounds(442, 218, 172, 25);
		panel_1.add(lblServicioDeTelecable);
		
		cbxCable = new JComboBox();
		cbxCable.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar"}));
		cbxCable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarCostos();
			}
		});
		cbxCable.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxCable.setBounds(442, 244, 224, 27);
		panel_1.add(cbxCable);
		
		txtTarifa = new JTextField();
		txtTarifa.setEditable(false);
		txtTarifa.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTarifa.setColumns(10);
		txtTarifa.setBounds(24, 320, 189, 27);
		panel_1.add(txtTarifa);
		
		JLabel lblTarifaMensual = new JLabel("Tarifa mensual (+Imp.):");
		lblTarifaMensual.setForeground(Color.DARK_GRAY);
		lblTarifaMensual.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTarifaMensual.setBackground(Color.GRAY);
		lblTarifaMensual.setBounds(24, 292, 172, 25);
		panel_1.add(lblTarifaMensual);
		
		txtImpuestos = new JTextField();
		txtImpuestos.setEditable(false);
		txtImpuestos.setFont(new Font("Arial", Font.PLAIN, 15));
		txtImpuestos.setColumns(10);
		txtImpuestos.setBounds(235, 320, 189, 27);
		panel_1.add(txtImpuestos);
		
		JLabel lblImpuestos = new JLabel("Impuestos:");
		lblImpuestos.setForeground(Color.DARK_GRAY);
		lblImpuestos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImpuestos.setBackground(Color.GRAY);
		lblImpuestos.setBounds(235, 292, 134, 25);
		panel_1.add(lblImpuestos);
		
		txtInstalacion = new JTextField();
		txtInstalacion.setEditable(false);
		txtInstalacion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtInstalacion.setColumns(10);
		txtInstalacion.setBounds(442, 320, 224, 27);
		panel_1.add(txtInstalacion);
		
		JLabel lblPrecioDeInstalacin = new JLabel("Precio de instalaci\u00F3n:");
		lblPrecioDeInstalacin.setForeground(Color.DARK_GRAY);
		lblPrecioDeInstalacin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecioDeInstalacin.setBackground(Color.GRAY);
		lblPrecioDeInstalacin.setBounds(442, 292, 172, 25);
		panel_1.add(lblPrecioDeInstalacin);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setBounds(24, 41, 224, 27);
		panel_1.add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setText("codPlan-"+(Tricom.getInstance().getCantRegistros().get(2)+1));
		txtCodigo.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(24, 17, 71, 25);
		panel_1.add(lblCdigo);
		lblCdigo.setForeground(Color.DARK_GRAY);
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCdigo.setBackground(Color.GRAY);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(510, 506, 97, 36);
		getContentPane().add(btnCancelar);
		
		for(Servicio ser: Tricom.getInstance().getMisServicios())
		{
			if(ser instanceof Telefono)
				cbxTelefono.addItem(ser.getCodServicio());
		}
		for(Servicio ser: Tricom.getInstance().getMisServicios())
		{
			if(ser instanceof Internet)
				cbxInternet.addItem(ser.getCodServicio());
		}
		for(Servicio ser: Tricom.getInstance().getMisServicios())
		{
			if(ser instanceof Cable)
				cbxCable.addItem(ser.getCodServicio());
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText().toString();
				String descripcion = txtADescripcion.getText().toString();
				String teleCode = cbxTelefono.getSelectedItem().toString();
				String interCode = cbxInternet.getSelectedItem().toString();
				String cableCode = cbxCable.getSelectedItem().toString();
				Servicio telefono = Tricom.getInstance().buscarServcode(teleCode);
				Servicio internet = Tricom.getInstance().buscarServcode(interCode);
				Servicio cable = Tricom.getInstance().buscarServcode(cableCode);
				int impuestos;
				float instalacion;
				
				try{
					impuestos = Integer.parseInt(txtImpuestos.getText().toString());
				}catch(NumberFormatException e)
				{
					impuestos = 0;
				}
				
				try{
					instalacion = Float.parseFloat(txtInstalacion.getText().toString());
				}catch(NumberFormatException e)
				{
					instalacion = 0;
				}
				String codigo = "codPlan-"+(Tricom.getInstance().getCantRegistros().get(2)+1);
				
				if(nombre.equalsIgnoreCase("")==false && descripcion.equalsIgnoreCase("")==false && (telefono != null || internet != null || cable != null))
				{
					
					
					if(accion == 1){
						Plan plan = new Plan(codigo,nombre,0,internet,telefono,cable,descripcion,true,impuestos,instalacion);
						Tricom.getInstance().getMisPlanes().add(plan);
						int cant = Tricom.getInstance().getCantRegistros().get(2);
						Tricom.getInstance().getCantRegistros().set(2, (cant+1));
						JOptionPane.showMessageDialog(null, "Registro satisfactorio.");
						dispose();
						}else{
							Plan plan = new Plan(codigo,nombre,0,internet,telefono,cable,descripcion,true,impuestos,instalacion);

								Tricom.getInstance().reemplazarPlan(plan);
								JOptionPane.showMessageDialog(null, "Modificacion satisfactoria.");
TricomMain.cargarJtable(3);
								dispose();
							
						}
				}
				else if(telefono == null && internet == null && cable == null)
				{
					JOptionPane.showMessageDialog(null, "Debe elegir al menos un servicio.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
				}
				
			}
		});
		btnAceptar.setBounds(619, 506, 97, 36);
		getContentPane().add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		lblNewLabel.setBounds(22, 533, 291, 16);
		getContentPane().add(lblNewLabel);
		if(accion == 2){
			loadModif(plan);
		}

	}
	
	
	private void llenarCostos()
	{
		float tarifa = 0;
		int impuestos = 0;
		float instalacion = 0;
		Servicio servicio = null;
		String codSer1 = null;
		String codSer2 = null;
		String codSer3 = null;
		
			
		try{
			codSer1 = new String(cbxTelefono.getSelectedItem().toString());
		}catch(NullPointerException e)
		{
			codSer1 = new String("");
		}
		
		try{
			codSer2 = new String(cbxInternet.getSelectedItem().toString());
		}catch(NullPointerException e)
		{
			codSer2 = new String("");
		}
		
		try{
			codSer3 = new String(cbxCable.getSelectedItem().toString());
		}catch(NullPointerException e)
		{
			codSer3 = new String("");
		}
		
		
		servicio = Tricom.getInstance().buscarServcode(codSer1);
		if(servicio != null)
		{
			tarifa += servicio.getTarifa();
			impuestos += servicio.getImpuestos();
			instalacion += servicio.getPrecioInstalacion();
		}
		
		servicio = Tricom.getInstance().buscarServcode(codSer2);
		if(servicio != null)
		{
			tarifa += servicio.getTarifa();
			impuestos += servicio.getImpuestos();
			instalacion += servicio.getPrecioInstalacion();
		}
		
		servicio = Tricom.getInstance().buscarServcode(codSer3);
		if(servicio != null)
		{
			tarifa += servicio.getTarifa();
			impuestos += servicio.getImpuestos();
			instalacion += servicio.getPrecioInstalacion();
		}
		
		txtTarifa.setText(String.valueOf(tarifa));
		txtImpuestos.setText(String.valueOf(impuestos));
		txtInstalacion.setText(String.valueOf(instalacion));
		
	}
	public void loadModif(Plan pl){
		txtCodigo.setText(pl.getCodPlan());
		txtNombre.setText(pl.getNombre());
		txtADescripcion.setText(pl.getDescripcion());
		
		
		
		
		
		if(pl.getCable() != null){
			int indcabl = Tricom.getInstance().indexCable(pl);

			cbxCable.setSelectedIndex(indcabl+1);
		}
		if(pl.getInternet() != null){
			int ind = Tricom.getInstance().indexInter(pl);
			cbxInternet.setSelectedIndex(ind+1);
		}
		if(pl.getTelefono() != null){
			int indtel = Tricom.getInstance().indexTel(pl);
			cbxTelefono.setSelectedIndex(indtel+1);

		}
		
llenarCostos();

	}
	
}

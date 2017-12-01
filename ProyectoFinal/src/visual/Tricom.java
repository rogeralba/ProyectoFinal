package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Tricom extends JFrame {
	

	private JPanel contentPane;
	private Dimension dim;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tricom frame = new Tricom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tricom() {
		setTitle("Tricom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 118, 983);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userImg = new JLabel("");
		userImg.setBounds(18, 18, 81, 81);
		String path2 = "./Imagenes/user2.png";
		ImageIcon userLogo = new ImageIcon(path2);
		ImageIcon icono2 = new ImageIcon(userLogo.getImage().getScaledInstance(userImg.getWidth(), userImg.getHeight(), Image.SCALE_DEFAULT));
		userImg.setIcon(icono2);
		panel.add(userImg);
		
		JLabel lblNewLabel = new JLabel("Juan Lopez");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(25, 108, 118, 16);
		panel.add(lblNewLabel);
		
	
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClientes.setForeground(Color.LIGHT_GRAY);
		btnClientes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnClientes.setBackground(Color.DARK_GRAY);
		btnClientes.setBounds(0, 137, 118, 91);
		btnClientes.setMargin(new Insets(0, 0, 10, 0));
		String path = "./Imagenes/user3.png";
		ImageIcon img = new ImageIcon(path);
		ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnClientes.setIcon(icono);
		btnClientes.setHorizontalTextPosition( SwingConstants.CENTER );
		btnClientes.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnClientes.setFocusable(false);
		panel.add(btnClientes);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(Color.DARK_GRAY);
		btnEmpleados.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleados.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEmpleados.setMargin(new Insets(0, 0, 10, 0));
		btnEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleados.setForeground(Color.LIGHT_GRAY);
		btnEmpleados.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEmpleados.setBounds(0, 226, 118, 91);
		btnEmpleados.setMargin(new Insets(0, 0, 10, 0));
		String path3 = "./Imagenes/empleado.png";
		img = new ImageIcon(path3);
		icono = new ImageIcon(img.getImage().getScaledInstance(45, 40, Image.SCALE_DEFAULT));
		btnEmpleados.setIcon(icono);
		btnEmpleados.setFocusable(false);
		panel.add(btnEmpleados);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVentas.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVentas.setMargin(new Insets(0, 0, 10, 0));
		btnVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVentas.setForeground(Color.LIGHT_GRAY);
		btnVentas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVentas.setFocusable(false);
		btnVentas.setBackground(Color.DARK_GRAY);
		btnVentas.setBounds(0, 315, 118, 91);
		String path4 = "./Imagenes/ventas.png";
		img = new ImageIcon(path4);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnVentas.setIcon(icono);
		btnVentas.setHorizontalTextPosition( SwingConstants.CENTER );
		btnVentas.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnVentas);
		
		JButton btnPlanes = new JButton("Planes");
		btnPlanes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPlanes.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlanes.setMargin(new Insets(0, 0, 10, 0));
		btnPlanes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlanes.setForeground(Color.LIGHT_GRAY);
		btnPlanes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPlanes.setFocusable(false);
		btnPlanes.setBackground(Color.DARK_GRAY);
		btnPlanes.setBounds(0, 405, 118, 91);
		String path5 = "./Imagenes/Planes.png";
		img = new ImageIcon(path5);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnPlanes.setIcon(icono);
		btnPlanes.setHorizontalTextPosition( SwingConstants.CENTER );
		btnPlanes.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnPlanes);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnServicios.setVerticalAlignment(SwingConstants.BOTTOM);
		btnServicios.setMargin(new Insets(0, 0, 10, 0));
		btnServicios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnServicios.setForeground(Color.LIGHT_GRAY);
		btnServicios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnServicios.setFocusable(false);
		btnServicios.setBackground(Color.DARK_GRAY);
		btnServicios.setBounds(0, 495, 118, 91);
		String path6 = "./Imagenes/Servicios.png";
		img = new ImageIcon(path6);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnServicios.setIcon(icono);
		btnServicios.setHorizontalTextPosition( SwingConstants.CENTER );
		btnServicios.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnServicios);
		
		JButton btnPagos = new JButton("Pagos");
		btnPagos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPagos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPagos.setMargin(new Insets(0, 0, 10, 0));
		btnPagos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPagos.setForeground(Color.LIGHT_GRAY);
		btnPagos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPagos.setFocusable(false);
		btnPagos.setBackground(Color.DARK_GRAY);
		btnPagos.setBounds(0, 585, 118, 91);
		String path7 = "./Imagenes/Pagos.png";
		img = new ImageIcon(path7);
		icono = new ImageIcon(img.getImage().getScaledInstance(40, 35, Image.SCALE_DEFAULT));
		btnPagos.setIcon(icono);
		btnPagos.setHorizontalTextPosition( SwingConstants.CENTER );
		btnPagos.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnPagos);
		
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAcercaDe.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAcercaDe.setMargin(new Insets(0, 0, 10, 0));
		btnAcercaDe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAcercaDe.setForeground(Color.LIGHT_GRAY);
		btnAcercaDe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAcercaDe.setFocusable(false);
		btnAcercaDe.setBackground(Color.DARK_GRAY);
		btnAcercaDe.setBounds(0, 675, 118, 91);
		String path8 = "./Imagenes/acerca.png";
		img = new ImageIcon(path8);
		icono = new ImageIcon(img.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		btnAcercaDe.setIcon(icono);
		btnAcercaDe.setHorizontalTextPosition( SwingConstants.CENTER );
		btnAcercaDe.setVerticalTextPosition( SwingConstants.BOTTOM );
		panel.add(btnAcercaDe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(255, 102, 51));
		panel_1.setBounds(118, 0, 1784, 124);
		contentPane.add(panel_1);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setBounds(30, 0, 126, 124);
		String path1 = "./Imagenes/Tricom.png";
		ImageIcon tricomLogo = new ImageIcon(path1);
		ImageIcon icono1 = new ImageIcon(tricomLogo.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_DEFAULT));
		imgLogo.setIcon(icono1);
		panel_1.add(imgLogo);
		
		JLabel lblFueraDeAqu = new JLabel("Fuera de aqu\u00ED nada se vive mejor");
		lblFueraDeAqu.setForeground(Color.WHITE);
		lblFueraDeAqu.setFont(new Font("Calibri", Font.BOLD, 22));
		lblFueraDeAqu.setBackground(Color.WHITE);
		lblFueraDeAqu.setBounds(147, 84, 406, 40);
		panel_1.add(lblFueraDeAqu);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		
		
		String path0 = "./Imagenes/tricom.png";
		Image icono0 =  Toolkit.getDefaultToolkit().getImage(path0);
		this.setIconImage(icono0);
		
		
	}
}

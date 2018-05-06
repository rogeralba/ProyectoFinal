package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.Administrativo;
import logico.Empleado;
import logico.Tricom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private MaskFormatter patron;
	private static TricomMain frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	private boolean verificarLogin(){
		boolean resultado = false;
	
		for (Empleado p : Tricom.getInstance().getMisEmpleados()) {
			if(p.getCedula().compareTo(txtUsuario.getText()) == 0 && p.getContrasena().compareTo(txtContrasena.getText()) == 0){
				resultado = true;
				Tricom.getInstance().setActual(p);
			}
		}
		
		return resultado;
	}
	

	public Login() {
		try {
			patron = new MaskFormatter("###-#######-#");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Leer la data al iniciar el programa
		try {
			Tricom.getInstance().readData();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		
		//Creacion de usuario inicial.
		if(Tricom.getInstance().getMisEmpleados().size() == 0)
		{
			Administrativo adm = new Administrativo("codEmp-1","Julio", "Estevez", "Gonzales", "000-0000000-0", "La Esmeralda c/15 #11", "809-745-3545", "Sin problemas", 50000, "000","02/07/1980","Masculino","julioE@hotmail.com");
			int cant = Tricom.getInstance().getCantRegistros().get(1);
			Tricom.getInstance().getCantRegistros().set(1, (cant+1));
			Tricom.getInstance().getMisEmpleados().add(adm);
		}
		
		setTitle("Tricom SA");
		setResizable(false);
		setBounds(100, 100, 544, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de gestion de Tricom SA");
		lblBienvenidoAlSistema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBienvenidoAlSistema.setBounds(110, 28, 344, 27);
		contentPanel.add(lblBienvenidoAlSistema);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(242, 68, 86, 16);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(232, 132, 86, 16);
		contentPanel.add(lblContrasea);
		
		txtUsuario = new JFormattedTextField(patron);
		txtUsuario.setBounds(193, 85, 156, 27);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(193, 152, 156, 27);
		contentPanel.add(txtContrasena);
		txtContrasena.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(verificarLogin()){
							TricomMain triMain = new TricomMain();
							triMain.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(contentPanel, "Usuario y/o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

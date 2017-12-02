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

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private MaskFormatter patron;
	private static TricomMain frame;

	/**
	 * Launch the application.
	 */
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
			Administrativo adm = new Administrativo("admin", "el", "boss", "000-0000000-0", "Tricom SA HQ", "111", "Fallecido", 10, "000","00/00/0000");
			Tricom.getInstance().getMisEmpleados().add(adm);
		}
		
		setTitle("Tricom SA");
		setResizable(false);
		setBounds(100, 100, 303, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de gestion de Tricom SA");
		lblBienvenidoAlSistema.setBounds(12, 13, 279, 16);
		contentPanel.add(lblBienvenidoAlSistema);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(22, 42, 56, 16);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(12, 71, 66, 16);
		contentPanel.add(lblContrasea);
		
		txtUsuario = new JFormattedTextField(patron);
		txtUsuario.setBounds(90, 42, 116, 22);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(90, 68, 116, 22);
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
							JOptionPane.showMessageDialog(contentPanel, "Usuario y/o contraseņa incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
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

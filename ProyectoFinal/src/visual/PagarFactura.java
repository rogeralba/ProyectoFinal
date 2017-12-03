package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logico.Cliente;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PagarFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField correoCliente;
	private static JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private String nombre;
	private Cliente client;
	private Cliente myclient;
	private JTextField txtCliente;
	private JTextField txtCedula;
	private JComboBox cbxNombre;
	private MaskFormatter ced;
	private MaskFormatter tele;
	private JTextField txtTelefono;
	private JButton okButton;
	private JTable table_1;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PagarFactura dialog = new PagarFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagarFactura() {
		setBounds(100, 100, 640, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
		label.setBounds(10, 464, 291, 16);
		contentPanel.add(label);
		try {
			ced = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(809)###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 84, 604, 139);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("Id:");
		lblCdula.setForeground(Color.DARK_GRAY);
		lblCdula.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCdula.setBackground(Color.GRAY);
		lblCdula.setBounds(10, 30, 71, 25);
		panel.add(lblCdula);
		
		txtCedula = new JFormattedTextField(ced);
		txtCedula.setEditable(false);
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setColumns(10);
		txtCedula.setBounds(82, 30, 214, 27);
		panel.add(txtCedula);
		
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setBackground(Color.GRAY);
		lblTelefono.setBounds(10, 89, 95, 25);
		panel.add(lblTelefono);
		
		txtTelefono = new JFormattedTextField(tele);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(82, 88, 214, 27);
		panel.add(txtTelefono);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBackground(Color.GRAY);
		lblNombre.setBounds(331, 30, 71, 25);
		panel.add(lblNombre);
		
		JComboBox cbxNombre = new JComboBox();
		cbxNombre.setSelectedIndex(0);
		cbxNombre.setBounds(412, 29, 182, 27);
		panel.add(cbxNombre);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCorreo.setBackground(Color.GRAY);
		lblCorreo.setBounds(331, 89, 71, 25);
		panel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(412, 89, 182, 27);
		panel.add(txtCorreo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(250, 240, 230));
		panel_2.setBounds(0, 0, 624, 82);
		contentPanel.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(30, 0, 84, 82);
		panel_2.add(label_1);
		
		JLabel lblPagarFactura = new JLabel("Pagar Factura");
		lblPagarFactura.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPagarFactura.setBounds(142, 13, 389, 56);
		panel_2.add(lblPagarFactura);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(554, 13, 45, 42);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Juan Lopez");
		label_4.setBounds(546, 53, 68, 16);
		panel_2.add(label_4);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setEnabled(false);
		btnPagar.setBounds(517, 436, 97, 44);
		contentPanel.add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(405, 436, 97, 44);
		contentPanel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 234, 604, 183);
		contentPanel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
	}
}

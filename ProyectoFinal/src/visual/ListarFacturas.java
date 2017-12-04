package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class ListarFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarFacturas dialog = new ListarFacturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarFacturas() {
		setBounds(100, 100, 560, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.setBounds(437, 324, 97, 44);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(btnSalir);
		}
		{
			JLabel label = new JLabel("\u00A9 2017 Tricom. Todos los derechos reservados.");
			label.setBounds(10, 351, 291, 16);
			contentPanel.add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 524, 287);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
			}
		}
	}

}

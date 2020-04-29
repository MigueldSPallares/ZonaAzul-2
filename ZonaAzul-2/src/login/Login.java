package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnRegistrar;
	private JTextField textDni;
	private JPasswordField passwordField;
	private JButton btnComprobar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
			  System.out.println("Error setting native LAF: " + e);
			}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\migue\\git\\ZonaAzul-2\\ZonaAzul-2\\src\\images\\admin.png"));
		lblNewLabel.setBounds(91, 10, 243, 256);
		contentPane.add(lblNewLabel);
		
		btnRegistrar = new JButton("Registrar nuevo usuario");
		btnRegistrar.addMouseListener(new BtnRegistrarMouseListener());
		btnRegistrar.setBounds(140, 398, 146, 21);
		contentPane.add(btnRegistrar);
		
		textDni = new JTextField();
		textDni.setBounds(140, 287, 146, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 316, 146, 19);
		contentPane.add(passwordField);
		
		btnComprobar = new JButton("Comprobar usuario");
		btnComprobar.setBounds(140, 355, 146, 21);
		contentPane.add(btnComprobar);
		btnComprobar.setEnabled(false);
	}
	private class BtnRegistrarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Register r = new Register();
			r.setVisible(true);
			dispose();
		}
	}
}

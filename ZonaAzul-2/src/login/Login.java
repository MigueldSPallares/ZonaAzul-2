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

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textDni;
	private JTextField textContrasena;
	private JButton btnComprobar;
	private JButton btnRegistrar;

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
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(175, 109, 46, 13);
		contentPane.add(lblNewLabel);
		
		textDni = new JTextField();
		textDni.setBounds(133, 217, 149, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(133, 264, 149, 19);
		contentPane.add(textContrasena);
		textContrasena.setColumns(10);
		
		btnComprobar = new JButton("Comprobar usuario");
		btnComprobar.setBounds(133, 313, 149, 21);
		contentPane.add(btnComprobar);
		
		btnRegistrar = new JButton("Registrar nuevo usuario");
		btnRegistrar.setBounds(136, 360, 146, 21);
		contentPane.add(btnRegistrar);
	}
}

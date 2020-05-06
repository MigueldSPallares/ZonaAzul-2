package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import clases.IOData;
import clases.Usuario;
import main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnRegistrar;
	private JTextField textDni;
	private JPasswordField passwordField;
	private JButton btnComprobar;
	public ArrayList<Usuario> vUsuario = new ArrayList<Usuario>();
	public boolean usuarioVacio;
	private char passwordChar;

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
		lblNewLabel.setFocusable(true);
		lblNewLabel.requestFocus();
		
		btnRegistrar = new JButton("Registrar nuevo usuario");
		btnRegistrar.addMouseListener(new BtnRegistrarMouseListener());
		btnRegistrar.setBounds(140, 398, 146, 21);
		contentPane.add(btnRegistrar);
		
		textDni = new JTextField();
		textDni.addKeyListener(new TextDniKeyListener());
		textDni.addFocusListener(new TextDniFocusListener());
		textDni.setText("Usuario");
		textDni.setBounds(140, 287, 146, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordChar = passwordField.getEchoChar();
		passwordField.addFocusListener(new PasswordFieldFocusListener());
		passwordField.addKeyListener(new PasswordFieldKeyListener());
		passwordField.setBounds(140, 316, 146, 19);
		passwordField.setText("Contraseña");
		passwordField.setEchoChar((char)0);
		contentPane.add(passwordField);
		
		
		btnComprobar = new JButton("Comprobar usuario");
		btnComprobar.addMouseListener(new BtnComprobarMouseListener());
		btnComprobar.setBounds(140, 355, 146, 21);
		contentPane.add(btnComprobar);
		btnComprobar.setEnabled(false);
		usuarioVacio = false;
		try {
			vUsuario = IOData.cargarNuevoUsuario();
			usuarioVacio = true;
		}catch (NullPointerException e){
			
		}
	}
	private class BtnRegistrarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Register r = new Register();
			r.setVisible(true);
			dispose();
		}
	}
	private class TextDniFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			if(textDni.getText().equalsIgnoreCase("Usuario")) {
				textDni.setText("");
			}
		}
	}
	private class BtnComprobarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!usuarioVacio) {
				for (Usuario usuario : vUsuario) {
					if(textDni.getText().equalsIgnoreCase(usuario.getDni())&&passwordField.getText().equalsIgnoreCase(usuario.getPassword())) {
						Main m = new Main(usuario.getDni());
						m.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
						textDni.setText("Usuario");
						passwordField.setText("Contraseña");
						passwordField.setEchoChar((char)0);
					}
				}
			}
		}
	}
	private class TextDniKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			comprobarRellenado();
		}
	}
	private class PasswordFieldKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			comprobarRellenado();
		}
	}
	private class PasswordFieldFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			if(passwordField.getText().equalsIgnoreCase("Contraseña")) {
				passwordField.setText("");
				passwordField.setEchoChar(passwordChar);
			}
		}
	}
	private void comprobarRellenado() {
		if(textDni.getText().equalsIgnoreCase("Usuario") || textDni.getText().equalsIgnoreCase("") || 
				passwordField.getText().equalsIgnoreCase("Contraseña") || passwordField.getText().equalsIgnoreCase("")) {
			btnComprobar.setEnabled(false);
		}else {
			btnComprobar.setEnabled(true);
		}
	}
}

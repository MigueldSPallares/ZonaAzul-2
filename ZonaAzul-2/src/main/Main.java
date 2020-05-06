package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends JFrame {

	/**
	 * Variable dni para moverse por las interfaces declarada aquí
	 */
	private String dniEnviadoDesdeMain;

	/**
	 * Inicializacion fecha
	 */
	private Calendar fecha;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JTextField tfHoraActual;
	private JTextField tfFechaActual;
	private JLabel lblSeleccionarCoche;
	private JComboBox cbSeleccioneCoche;
	private JLabel lblSeleccioneTiempoReserva;
	private JTextField tfMinutos;
	private JLabel lblCoste;
	private JTextField tfCoste;
	private JButton btnReservar;
	private JButton btnVerCoches;
	private JButton btnVerTarifas;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 * El constructor por defecto de la clase no puede utilizarse dado que el dni de
					 * ejemplo no es valido
					 */
					Main frame = new Main("dniEjemplo");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param dniUsuario
	 */
	public Main(String dniUsuario) {
		setTitle("Zona Azul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblIcon = new JLabel("");
		lblIcon.setFocusable(false);
		lblIcon.setIcon(new ImageIcon(Main.class.getResource("/images/ZonaAzul.png")));
		lblIcon.setBounds(15, 11, 225, 225);
		contentPane.add(lblIcon);

		tfHoraActual = new JTextField();
		tfHoraActual.setFocusable(false);
		tfHoraActual.setEditable(false);
		tfHoraActual.setBorder(null);
		tfHoraActual.setHorizontalAlignment(SwingConstants.CENTER);
		tfHoraActual.setFont(new Font("Microsoft YaHei", Font.PLAIN, 50));
		tfHoraActual.setBounds(245, 50, 200, 80);
		contentPane.add(tfHoraActual);
		tfHoraActual.setColumns(10);

		tfFechaActual = new JTextField();
		tfFechaActual.setFocusable(false);
		tfFechaActual.setEditable(false);
		tfFechaActual.setBorder(null);
		tfFechaActual.setForeground(Color.GRAY);
		tfFechaActual.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		tfFechaActual.setHorizontalAlignment(SwingConstants.CENTER);
		tfFechaActual.setBounds(245, 155, 200, 30);
		contentPane.add(tfFechaActual);
		tfFechaActual.setColumns(10);

		lblSeleccionarCoche = new JLabel("Seleccione Coche:");
		lblSeleccionarCoche.setFocusable(false);
		lblSeleccionarCoche.setForeground(Color.GRAY);
		lblSeleccionarCoche.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblSeleccionarCoche.setBounds(15, 259, 200, 25);
		contentPane.add(lblSeleccionarCoche);

		cbSeleccioneCoche = new JComboBox();
		cbSeleccioneCoche.setBackground(Color.WHITE);
		cbSeleccioneCoche.setBounds(225, 261, 220, 25);
		contentPane.add(cbSeleccioneCoche);

		lblSeleccioneTiempoReserva = new JLabel("Tiempo de reserva (min)");
		lblSeleccioneTiempoReserva.setFocusable(false);
		lblSeleccioneTiempoReserva.setForeground(Color.GRAY);
		lblSeleccioneTiempoReserva.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblSeleccioneTiempoReserva.setBounds(15, 330, 200, 25);
		contentPane.add(lblSeleccioneTiempoReserva);

		tfMinutos = new JTextField();
		tfMinutos.addKeyListener(new TextFieldKeyListener());
		tfMinutos.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tfMinutos.setBounds(225, 330, 70, 25);
		contentPane.add(tfMinutos);
		tfMinutos.setColumns(10);

		lblCoste = new JLabel("Coste:");
		lblCoste.setForeground(Color.GRAY);
		lblCoste.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblCoste.setFocusable(false);
		lblCoste.setBounds(315, 330, 50, 25);
		contentPane.add(lblCoste);

		tfCoste = new JTextField();
		tfCoste.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tfCoste.setText("0.00\u20AC");
		tfCoste.setEditable(false);
		tfCoste.setColumns(10);
		tfCoste.setBounds(375, 332, 70, 25);
		contentPane.add(tfCoste);

		btnReservar = new JButton("Reservar");
		btnReservar.setEnabled(false);
		btnReservar.addKeyListener(new BtnReservarKeyListener());
		btnReservar.addMouseListener(new BtnReservarMouseListener());
		btnReservar.addKeyListener(new BtnReservarKeyListener());
		btnReservar.setFocusPainted(false);
		btnReservar.setBackground(Color.LIGHT_GRAY);
		btnReservar.setBorder(null);
		btnReservar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnReservar.setBounds(185, 395, 114, 35);
		contentPane.add(btnReservar);

		btnVerCoches = new JButton("Ver Coches");
		btnVerCoches.addMouseListener(new BtnVerCochesMouseListener());
		btnVerCoches.addKeyListener(new BtnVerCochesKeyListener());
		btnVerCoches.setFocusPainted(false);
		btnVerCoches.setBorder(null);
		btnVerCoches.setBackground(Color.LIGHT_GRAY);
		btnVerCoches.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnVerCoches.setBounds(25, 465, 114, 35);
		contentPane.add(btnVerCoches);

		btnVerTarifas = new JButton("Ver Tarifas");
		btnVerTarifas.addMouseListener(new BtnVerTarifasMouseListener());
		btnVerTarifas.addKeyListener(new BtnVerTarifasKeyListener());
		btnVerTarifas.setFocusPainted(false);
		btnVerTarifas.setBorder(null);
		btnVerTarifas.setBackground(Color.LIGHT_GRAY);
		btnVerTarifas.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnVerTarifas.setBounds(185, 465, 114, 35);
		contentPane.add(btnVerTarifas);

		btnVolver = new JButton("Volver");
		btnVolver.addKeyListener(new BtnVolverKeyListener());
		btnVolver.addMouseListener(new BtnVolverMouseListener());
		btnVolver.addKeyListener(new BtnVolverKeyListener());
		btnVolver.setFocusPainted(false);
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBorder(null);
		btnVolver.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnVolver.setBounds(345, 465, 114, 35);
		contentPane.add(btnVolver);

		/**
		 * Inicializacion y comienzo del timer
		 */
		actualizarFechaHora();
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFechaHora();
			}
		});
		timer.start();
	}

	protected void actualizarFechaHora() {
		fecha = new GregorianCalendar();
		String horaActual = "";
		String fechaActual = "";

		if (fecha.get(Calendar.HOUR_OF_DAY) < 10) {
			horaActual += 0;
		}
		horaActual += fecha.get(Calendar.HOUR_OF_DAY) + ":";

		if (fecha.get(Calendar.MINUTE) < 10) {
			horaActual += 0;
		}
		horaActual += fecha.get(Calendar.MINUTE) + ":";

		if (fecha.get(Calendar.SECOND) < 10) {
			horaActual += 0;
		}
		horaActual += fecha.get(Calendar.SECOND);

		if (fecha.get(Calendar.DAY_OF_MONTH) < 10) {
			fechaActual += 0;
		}
		fechaActual += fecha.get(Calendar.DAY_OF_MONTH) + "/";

		if ((fecha.get(Calendar.MONTH) + 1) < 10) {
			fechaActual += 0;
		}
		fechaActual += (fecha.get(Calendar.MONTH) + 1) + "/";
		fechaActual += fecha.get(Calendar.YEAR);

		tfHoraActual.setText(horaActual);
		tfFechaActual.setText(fechaActual);
	}

	private class BtnReservarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			reservar();
		}
	}

	private class BtnVerCochesKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				verCoches();
			}
		}
	}

	private class BtnReservarKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				reservar();
			}
		}
	}

	private class BtnVerCochesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			verCoches();
		}
	}

	private class BtnVerTarifasKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				verTarifas();
			}
		}
	}

	private class BtnVerTarifasMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			verTarifas();
		}
	}

	private class BtnVolverMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			volver();
		}
	}

	private class BtnVolverKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				volver();
			}
		}
	}
	private class TextFieldKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			checkFormato();
		}
	}

	public void reservar() {
		/**
		 * Reservar por implementar
		 */
	}


	public void checkFormato() {
		String cadena = tfMinutos.getText();
		if(!cadena.equals("")) {
			if(!esNumero(cadena)) {
				if(btnReservar.isEnabled()) {
					btnReservar.setEnabled(false);
				}
				tfMinutos.setText("");
				JOptionPane.showMessageDialog(null, "Introduzca únicamente números (0-9)");
				
			} else {
				btnReservar.setEnabled(true);
			}
		}
	}

	private boolean esNumero(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public void volver() {
		Login login = new Login();
		login.setVisible(true);
		dispose();
	}

	public void verTarifas() {
		Tarifas tarifas = new Tarifas(dniEnviadoDesdeMain);
		tarifas.setVisible(true);
		dispose();
	}

	public void verCoches() {
		Coches coches = new Coches(dniEnviadoDesdeMain);
		coches.setVisible(true);
		dispose();
	}
}

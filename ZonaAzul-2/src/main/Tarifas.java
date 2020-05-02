package main;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Tarifas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable dni para volver al main declarada aqui
	 */
	private String dniUsuario;

	private JPanel contentPane;
	private JButton btnVolver;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 * El constructor por defecto de la clase no puede volver al Main dado que
					 * utiliza un dni no valido
					 */
					Tarifas frame = new Tarifas("dniEjemplo");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tarifas(String dniEnviadoDesdeMain) {
		setResizable(false);
		setTitle("Zona Azul");

		/**
		 * Aqui se pone el dni al que se ha enviado desde el main para poder volver mas
		 * adelante
		 */
		dniUsuario = dniEnviadoDesdeMain;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 335);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addFocusListener(new BtnVolverFocusListener());
		btnVolver.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setSelected(true);
		btnVolver.addKeyListener(new BtnNewButtonKeyListener());
		btnVolver.addMouseListener(new BtnNewButtonMouseListener());
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(254, 255, 120, 30);
		contentPane.add(btnVolver);

		scrollPane = new JScrollPane();
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setFocusable(false);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setEnabled(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 12, 364, 233);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setRowHeight(35);
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { "20 min.", "0.20\u20AC" }, { "30 min.", "0.35\u20AC" },
								{ "60 min.", "0.85\u20AC" }, { "90 min.", "1.35\u20AC" }, { "120 min.", "1.90\u20AC" },
								{ "150 min. (max)", "2.40\u20AC" }, },
						new String[] { "Tiempo de Estacionamiento", "Tarifa" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(0).setMinWidth(175);
		table.getColumnModel().getColumn(0).setMaxWidth(175);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);

		btnVolver.requestFocus();
	}

	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			volver();
		}
	}

	private class BtnNewButtonKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				volver();
			}
		}
	}

	private class BtnVolverFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
		}
	}

	public void volver() {
		Main main = new Main(dniUsuario);
		main.setVisible(true);
		dispose();
	}
}

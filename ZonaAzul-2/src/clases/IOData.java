package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOData {

	static File ficheroUsuarios = new File("./ZonaAzul-2/src/data/Passwd.dat");
	static File ficheroReservas = new File("./ZonaAzul-2/src/data/reservasZonaAzul.dat");

	@SuppressWarnings("unchecked")
	public static Usuario cargarUsuario(String dniUsuario) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Usuario> usuarios;
		Usuario usuario = null;

		try {
			fis = new FileInputStream(ficheroUsuarios);
			ois = new ObjectInputStream(fis);

			usuarios = (ArrayList<Usuario>) ois.readObject();
			for (Usuario usuarioArray : usuarios) {
				if (usuarioArray.getDni().equals(dniUsuario)) {
					usuario = usuarioArray;
				}
				break;
			}
		} catch (EOFException eof) {
			System.out.println("No existe ningun usuario");
		} catch (Exception e) {
			System.out.println("Fallo");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {
					System.out.println("Fallo al acceder al disco");
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
					System.out.println("Fallo al acceder al disco");
				}
			}
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public static boolean guardarReserva(String dniEnviadoDesdeMain, String matricula, String fecha, String horaInicio,
			String horaFin) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Reserva> reservas = null;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		Reserva reserva = null;

		try {
			fis = new FileInputStream(ficheroReservas);
			ois = new ObjectInputStream(fis);

			reservas = (ArrayList<Reserva>) ois.readObject();
		} catch (EOFException eof) {
			System.out.println("No existe ninguna reserva usuario");
		} catch (Exception e) {
			System.out.println("Fallo al acceder a las reservas");
			return false;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {
					System.out.println("Fallo al acceder al disco");
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
					System.out.println("Fallo al acceder al disco");
				}
			}
		}

		try {
			fos = new FileOutputStream(ficheroReservas);
			oos = new ObjectOutputStream(fos);

			reserva = new Reserva(dniEnviadoDesdeMain, matricula, fecha, horaInicio, horaFin);
			reservas.add(reserva);
			oos.writeObject(reservas);
		} catch (Exception e) {
			return false;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	}

}

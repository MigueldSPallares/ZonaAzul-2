package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class IOData {
	public static void guardarNuevoUsuario(ArrayList<Usuario> vUsuario) {
		File fichero = new File("./Passwd.dat");
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				fo = new FileOutputStream(fichero);
				escribir = new ObjectOutputStream(fo);
				escribir.writeObject(vUsuario);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fo.close();
					escribir.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static ArrayList<Usuario> cargarNuevoUsuario() {
		ArrayList<Usuario> vUsuario = new ArrayList<Usuario>();
		File fichero = new File("./Passwd.dat");
		FileInputStream fi = null;
		ObjectInputStream leer = null;
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
				return vUsuario;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				fi = new FileInputStream(fichero);
				leer = new ObjectInputStream(leer);
				
				vUsuario = (ArrayList<Usuario>) leer.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if (fi!=null)
						fi.close();
					if (leer!=null)
						leer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vUsuario;
	}
	public static void guardarNuevaReserva(ArrayList<Reserva> vReserva) {
		File fichero = new File("./reservasZonaAzul.dat");
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				fo = new FileOutputStream(fichero);
				escribir = new ObjectOutputStream(fo);
				escribir.writeObject(vReserva);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fo.close();
					escribir.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static ArrayList<Reserva> cargarNuevaReserva() {
		ArrayList<Reserva> vReserva = new ArrayList<Reserva>();
		File fichero = new File("./reservasZonaAzul.dat");
		FileInputStream fi = null;
		ObjectInputStream leer = null;
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				fi = new FileInputStream(fichero);
				leer = new ObjectInputStream(leer);
				
				vReserva = (ArrayList<Reserva>) leer.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if (fi!=null)
						fi.close();
					if (leer!=null)
						leer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vReserva;
	}
}

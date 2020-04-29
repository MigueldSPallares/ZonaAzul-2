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
		File fichero = new File("Passwd.dat");
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	public static ArrayList<Usuario> cargarNuevoUsuario() {
		ArrayList<Usuario> vUsuario = new ArrayList<Usuario>();
		File fichero = new File("Passwd.dat");
		FileInputStream fi = null;
		ObjectInputStream leer = null;
		return vUsuario;
	}
	public static void guardarNuevaReserva() {
		
	}
	public static ArrayList<Reserva> cargarNuevaReserva() {
		ArrayList<Reserva> vReserva = new ArrayList<Reserva>();
		return vReserva;
	}
}

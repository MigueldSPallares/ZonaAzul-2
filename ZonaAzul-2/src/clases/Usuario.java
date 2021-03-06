package clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Usuario {
	private String dni;
	private char[] password;
	private ArrayList<String> vCoches;
	private ArrayList<Reserva> vReservas;
	
	public Usuario(String dni, char[] password, ArrayList<String> vCoches, ArrayList<Reserva> vReservas) {
		super();
		this.dni = dni;
		this.password = password;
		this.vCoches = vCoches;
		this.vReservas = vReservas;
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", password=" + Arrays.toString(password) + ", vCoches=" + vCoches
				+ ", vReservas=" + vReservas + "]";
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public ArrayList<String> getvCoches() {
		return vCoches;
	}
	public void setvCoches(ArrayList<String> vCoches) {
		this.vCoches = vCoches;
	}
	public ArrayList<Reserva> getvReservas() {
		return vReservas;
	}
	public void setvReservas(ArrayList<Reserva> vReservas) {
		this.vReservas = vReservas;
	}
}

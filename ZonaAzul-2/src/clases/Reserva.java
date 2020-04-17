package clases;

public class Reserva {
	private String dni;
	private String matricula;
	private String fecha;
	private String hora_inicio;
	private String hora_fin;
	
	public Reserva(String dni, String matricula, String fecha, String hora_inicio, String hora_fin) {
		super();
		this.dni = dni;
		this.matricula = matricula;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}
	@Override
	public String toString() {
		return "Reserva [dni=" + dni + ", matricula=" + matricula + ", fecha=" + fecha + ", hora_inicio=" + hora_inicio
				+ ", hora_fin=" + hora_fin + "]";
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
}

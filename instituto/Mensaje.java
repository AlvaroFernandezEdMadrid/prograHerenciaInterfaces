package instituto;

import java.time.LocalDate;
import java.util.Objects;

import daw.com.Teclado;

public class Mensaje {
	private String emisor;
	private LocalDate fecha;
	private String contenido;
	
	public Mensaje(String emisor, LocalDate fecha, String contenido) {
		this.emisor = emisor;
		this.fecha = fecha;
		this.contenido = contenido;
	}
	
	public Mensaje() {
		this("",LocalDate.now(),"");
	}
	
	public Mensaje(Mensaje og) {
		this.emisor=og.emisor;
		this.fecha=og.fecha;
		this.contenido=og.contenido;
	}

	public String getEmisor() {
		return emisor;
	}
	
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		if (fecha==null) {
			fecha=LocalDate.now();
		}
		this.fecha = fecha;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(contenido, other.contenido) && Objects.equals(emisor, other.emisor)
				&& Objects.equals(fecha, other.fecha);
	}
	
	

	@Override
	public String toString() {
		return "Mensaje "
				+ "\nEmisor=" + emisor +
				"\nFecha=" + fecha +
				"\nContenido=" + contenido;
	}

	public void leerDatos() {
		setEmisor(Teclado.leerString("\nEmisor: "));
		setFecha(LocalDate.parse(Teclado.leerString("\nFecha en aaaa-mm-dd: ")));
		setContenido(Teclado.leerString("\nContenido: "));
	}
	
	
}

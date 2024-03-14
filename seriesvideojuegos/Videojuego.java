package seriesvideojuegos;

import java.util.Objects;

public class Videojuego implements Entregable{
	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String compania;
	
	public Videojuego(String titulo, int horasEstimadas, String compania) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.compania = compania;
	}
	
	public Videojuego(String titulo, int horasEstimadas) {
		this(titulo, horasEstimadas, "");
	}
	
	public Videojuego() {
		this("", 10);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Serie: \nTitulo=" + titulo +
				"\nHoras Estimadas=" + horasEstimadas +
				"\nEntregado=" + entregado +
				"\nCompania="+ compania;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public void entregar() {
		this.entregado=true;
	}

	@Override
	public void devolver() {
		this.entregado=false;
	}

	@Override
	public boolean isEntregado() {
		return entregado;
	}
	
}

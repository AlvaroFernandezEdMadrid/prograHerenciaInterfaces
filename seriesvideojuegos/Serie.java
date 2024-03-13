package seriesvideojuegos;

import java.util.Objects;

public class Serie implements Entregable{
	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	public Serie(String titulo, int numTemporadas, String genero, String creador) {
		this.titulo = titulo;
		setNumTemporadas(numTemporadas);
		this.genero = genero;
		this.creador = creador;
		this.entregado=false;
	}
	
	public Serie(String titulo, String creador) {
		this(titulo,3,"",creador);
	}

	public Serie() {
		this("","");
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumTemporadas() {
		return numTemporadas;
	}
	public void setNumTemporadas(int numTemporadas) {
		if (numTemporadas<0) {
			numTemporadas=0;
		}
		this.numTemporadas = numTemporadas;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie: \nTitulo=" + titulo +
				"\nNTemporadas=" + numTemporadas +
				"\nEntregado=" + entregado +
				"\nGenero="+ genero +
				"\nCreador=" + creador;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
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

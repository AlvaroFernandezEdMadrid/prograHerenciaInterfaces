package seriesvideojuegos;

import java.util.Objects;

import daw.com.Teclado;

public class VideoJuego implements Entregable{
	private String titulo;
	private float horasEstimadas;
	private boolean entregado;
	private String compania;
	
	public VideoJuego(String titulo, int horasEstimadas, String compania) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.compania = compania;
	}
	
	public VideoJuego(String titulo, int horasEstimadas) {
		this(titulo, horasEstimadas, "");
	}
	
	public VideoJuego() {
		this("", 10);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(float f) {
		this.horasEstimadas = f;
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
		VideoJuego other = (VideoJuego) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	public void leerDatos ()
	{
		titulo = Teclado.leerString("Titulo");
		setHorasEstimadas(Teclado.leerFloat("horas"));
		setCompania(Teclado.leerString("Empresa"));
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

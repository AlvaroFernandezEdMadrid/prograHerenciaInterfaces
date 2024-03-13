package habladores;

public class Piolin extends Ave {
	private boolean canta;
	private int nPeliculas;
	
	public Piolin(String sexo, int edad, boolean canta, int nPeliculas) {
		super(sexo, edad);
		this.canta = canta;
		this.nPeliculas = nPeliculas;
	}
	
	public Piolin(String sexo, int edad) {
		this(sexo, edad, false, 0);
	}
	
	public Piolin() {
		this("", 0);
	}

	public boolean isCanta() {
		return canta;
	}
	public void setCanta(boolean canta) {
		this.canta = canta;
	}
	public int getnPeliculas() {
		return nPeliculas;
	}
	public void setnPeliculas(int nPeliculas) {
		this.nPeliculas = nPeliculas;
	}
	
}

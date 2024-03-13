package habladores;

public class Buitre extends Ave {
	private int velocidadVuelo;
	private float peso;
	
	public Buitre(String sexo, int edad, int velocidadVuelo, float peso) {
		super(sexo, edad);
		this.velocidadVuelo = velocidadVuelo;
		this.peso = peso;
	}
	
	public Buitre(String sexo, int edad) {
		this(sexo, edad,0,0);
	}

	public Buitre() {
		this("",0);
	}
	
	public int getVelocidadVuelo() {
		return velocidadVuelo;
	}
	public void setVelocidadVuelo(int velocidadVuelo) {
		this.velocidadVuelo = velocidadVuelo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}

package interfaces;

import daw.com.Pantalla;

public class Pajaro extends Animal implements Cantante {
	
	private String color;
	
	public Pajaro() {
		super();
	
		color = "";
	}

	public Pajaro(String tipo, String continente, String color) {
		super(tipo, continente);
	
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pajaro [color=" + color + "]" + super.toString();
	}

	@Override
	public void afinar (String frase)
	{
		Pantalla.escribirString("\nLos p�jaros no afinamos\n");
	}
	
	@Override
	public void cantar() {
		
		Pantalla.escribirString("\npiopiopiopiopio\n");

	}

}

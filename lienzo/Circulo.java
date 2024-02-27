package lienzo;

import daw.com.Teclado;

public class Circulo extends Figura {

	private int radio;

	public Circulo(String nombre, int x, int y, int color,float grosor, int radio) {
		
		super (nombre, x, y, color, grosor);
		
		setRadio (radio);

	}
	
	public Circulo(String nombre, int x, int y, int color, float grosor) {
		
		this (nombre, x,y,color,grosor, 0);
	}

	public Circulo() {
		this ("", 0,0,0,0);
	}
	
	public Circulo(String nombre) {
		this (nombre, 0,0,0,0);
	}

	public Circulo(Circulo og) {
		super(og);
		this.radio=og.radio;
	}
	
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio <= 0 ? 1: radio;
	}

	@Override
	public void leerDatos ()
	{
		super.leerDatos();

		setRadio (Teclado.leerInt("\nRadio"));
		
	}
	
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + 
				", toString()=" + super.toString() + "]";
	}

	@Override
	public float getPerimetro ()
	{
		return (float) (2 *Math.PI * radio);
	}

	@Override
	public float getArea() {
		return (float) (radio*radio*Math.PI);
	}

}
package habladores;

public class Persona {
	private String nombre;
	private int edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		setEdad(edad);
	}
	
	public Persona() {
		this("",0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad<0) {
			edad=0;
		}
		this.edad = edad;
	}
	
}

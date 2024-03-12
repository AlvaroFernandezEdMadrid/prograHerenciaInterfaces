package interfaces;

import daw.com.Pantalla;

public class Sabio extends Humano implements Cantante, Ordenable {
	private int librosLeidos;

	public Sabio() {
		super();
		librosLeidos = 0;
	}

	public Sabio(String raza, int edad, boolean varon, int librosLeidos) {
		super(raza, edad, varon);
		
		this.librosLeidos = librosLeidos;
	}

	public int getLibrosLeidos() {
		return librosLeidos;
	}

	public void setLibrosLeidos(int librosLeidos) {
		this.librosLeidos = librosLeidos;
	}

	@Override
	public String toString() {
		return "Sabio [librosLeidos=" + librosLeidos  + "]" + super.toString();
	}

	@Override
	public void cantar() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n soy un sabio y canto as�: ");
		Pantalla.escribirString(LETRA);
		
	}

	@Override
	public boolean esMayor(Ordenable otro) {
		// TODO Auto-generated method stub
		Sabio s = (Sabio) otro;
		
		return s.librosLeidos > librosLeidos;
	}

	@Override
	public boolean esMenor(Ordenable otro) {
		// TODO Auto-generated method stub
		Sabio s = (Sabio) otro;
		
		return s.librosLeidos < librosLeidos;
	}
	
}

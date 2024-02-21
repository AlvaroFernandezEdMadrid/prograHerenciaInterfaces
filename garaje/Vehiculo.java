package garaje;

import java.util.Objects;

import Libreria.Libreria;
import daw.com.Teclado;

public abstract class Vehiculo {
	private int potencia;
	private String matricula;
	
	public Vehiculo(int potencia, String matricula) {
		setPotencia(potencia);
		this.matricula = matricula;
	}
	
	public Vehiculo(String matricula) {
		this(0,matricula);
	}
	
	public Vehiculo() {
		this("");
	}
	
	public Vehiculo(Vehiculo og) {
		potencia=og.potencia;
		matricula=og.matricula;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		if (potencia<1) {
			potencia=1;
		}
		this.potencia = potencia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [potencia=" + potencia + ", matricula=" + matricula + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	public boolean equals(Vehiculo otro) {
	return matricula.equals(otro.matricula);
	}

	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		setMatricula(Teclado.leerString("Matricula: "));
	}

	public void leerOtrosDatos() {
		setPotencia(Libreria.leerEnteroPositivo("Potencia(cv): "));
	}
	 
	public void mostrarDatos() {
		System.out.println(this);
	}
	
	public abstract float getCuota();
}

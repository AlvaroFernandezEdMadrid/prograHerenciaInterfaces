package empleadosEnsenanza;

import java.time.LocalDate;

import daw.com.Teclado;

public class Auxiliar extends Empleado {
	
	private boolean ingles;

	public Auxiliar(String nombre, LocalDate fNac, String dni, float sueldoBase, boolean ingles) {
		super(nombre, fNac, dni, sueldoBase);
		this.ingles = ingles;
	}
	
	public Auxiliar(String dni) {
		super(dni);
		setIngles(ingles);
	}
	
	public Auxiliar() {
		this("");
		setIngles(false);
	}
	
	public Auxiliar(Auxiliar og) {
		super(og);
		this.ingles=og.ingles;
	}

	public boolean isIngles() {
		return ingles;
	}

	public void setIngles(boolean ingles) {
		this.ingles = ingles;
	}
	
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setIngles(Teclado.leerString("Sabe ingles (S/N)? ").equalsIgnoreCase("s"));
	}

	@Override
	public String toString() {
		return "Auxiliar [ingles=" + ingles + ", toString()=" + super.toString() + "]";
	}

	@Override
	public float getSueldoNeto() {
		float sueldoNeto=this.getSueldoBase();
		
		if (ingles) {
			sueldoNeto+=100;
		}
		
		return sueldoNeto;
	}

}

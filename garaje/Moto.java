package garaje;

import daw.com.Teclado;

public class Moto extends Vehiculo {
	private boolean asegurada;

	public Moto(int potencia, String matricula, boolean asegurada) {
		super(potencia, matricula);
		this.asegurada = asegurada;
	}
	
	public Moto(String matricula) {
		this(1, matricula, false);
	}
	
	public Moto() {
		this("");
	}

	public boolean isAsegurada() {
		return asegurada;
	}

	public void setAsegurada(boolean asegurada) {
		this.asegurada = asegurada;
	}
	
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setAsegurada(Teclado.leerString("Esta asegurada? (S/N)").equalsIgnoreCase("s"));
	}

	@Override
	public String toString() {
		return "Moto [asegurada=" + asegurada + super.toString() + "]";
	}

	@Override
	public float getCuota() {
		// TODO Auto-generated method stub
		//potencia *2
		return this.getPotencia()*2;
	}
}

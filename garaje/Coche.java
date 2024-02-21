package garaje;

import Libreria.Libreria;

public class Coche extends Vehiculo {
	private int nPlazas;

	public Coche(int potencia, String matricula, int nPlazas) {
		super(potencia, matricula);
		setnPlazas(nPlazas);
	}
	
	public Coche (String matricula) {
		super(matricula);
		setnPlazas(1);
	}
	
	public Coche() {
		this("");
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		if (nPlazas<1) {
			nPlazas=1;
		}
		this.nPlazas = nPlazas;
	}
	
	@Override
	public void leerOtrosDatos(){
		super.leerOtrosDatos();
		setnPlazas(Libreria.leerEntreLimites(1, 9, "Numero de plazas: "));
	}

	@Override
	public String toString() {
		return "Coche [nPlazas=" + nPlazas + super.toString() + "]";
	}

	@Override
	public float getCuota() {
		// TODO Auto-generated method stub
		//multi potencia *nplaza
		
		return this.getPotencia()*nPlazas;
		
	}
	
	
	
}

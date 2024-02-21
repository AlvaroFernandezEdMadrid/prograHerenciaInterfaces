package garaje;

import java.util.ArrayList;

public class Garaje {
	private int nPlazas;
	private ArrayList<Vehiculo> vehiculos;

	public Garaje(int nPlazas, ArrayList<Vehiculo> vehiculos) {
		setnPlazas(nPlazas);
		setVehiculos(vehiculos);
	}

	public Garaje() {
		this(1,null);
	}
	
	public int getnPlazas() {
		return nPlazas;
	}
	
	public void setnPlazas(int nPlazas) {
		if (nPlazas<1) {
			nPlazas=1;
		}
		this.nPlazas=nPlazas;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		if (vehiculos==null) {
			vehiculos=new ArrayList<Vehiculo>();
		}
		this.vehiculos = vehiculos;
	}
	
	public boolean addVehiculo() {
		boolean exito=false;
		
		return exito;
	}
	
}

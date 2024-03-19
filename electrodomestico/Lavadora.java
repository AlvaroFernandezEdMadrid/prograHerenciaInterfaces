package electrodomestico;

import daw.com.Teclado;

public class Lavadora extends Electrodomestico {

	private final static float CARGADEFECTO=5;
	
	private float carga;
	
	
	public Lavadora(String id, int stock, float precio, Color color, Consumo consumo, float peso, float carga) {
		super(id, stock, precio, color, consumo, peso);
		this.carga = carga;
	}

	public Lavadora(String id) {
		super(id);
		this.carga = CARGADEFECTO;
	}

	public Lavadora() {
		this("");
	}
	
	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		if (carga<0) {
			carga=0;
		}
		this.carga = carga;
	}
	
	@Override
	public String toString() {
		return "[Lavadora Carga=" + carga
				+super.toString()+"]";
	}
	
	@Override
	public void leerDatos() {
		super.leerDatos();
		setCarga(Teclado.leerFloat("\nCarga: "));
	}
	
	@Override
	public void mostrarDatos() {
		System.out.println(this);
	}

	@Override
	public float getPrecioFinal() {
		return super.getPrecioBase()+(carga>30?50:0);
	}

}

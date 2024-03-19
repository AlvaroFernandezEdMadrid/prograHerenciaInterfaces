package electrodomestico;

import daw.com.Teclado;

public class Television extends Electrodomestico {
	private final static int RESOLUCIONDEFECTO=20;
	private final static boolean SINTONIZADORDEFECTO=false; 
	
	private int resolucion;
	private boolean tdt;
	
	public Television(String id, int stock, float precio, Color color, Consumo consumo, float peso, int resolucion,
			boolean tdt) {
		super(id, stock, precio, color, consumo, peso);
		this.resolucion = resolucion;
		this.tdt = tdt;
	}

	public Television(String id) {
		super(id);
		this.resolucion = RESOLUCIONDEFECTO;
		this.tdt = SINTONIZADORDEFECTO;
	}
	
	public Television() {
		this("");
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		if (resolucion<0) {
			resolucion=0;
		}
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	@Override
	public String toString() {
		return "[Television "
				+ "\nResolucion: " + resolucion
				+ "\nTDT: " + tdt
				+super.toString()+"]";
	}
	
	@Override
	public void leerDatos() {
		super.leerDatos();
		setResolucion(Teclado.leerInt("\nResolucion: "));
		setTdt(Teclado.leerString("\nTiene TDT (S/N)?: ").equalsIgnoreCase("s"));
	}
	
	@Override
	public void mostrarDatos() {
		System.out.println(this);
	}
	
	@Override
	public float getPrecioFinal() {
		float fin=0;
		
		fin=(float) (super.getPrecioBase()*(resolucion>40?1.3:1));
		
		if (tdt) {
			fin+=50;
		}
		
		return fin;
	}

}

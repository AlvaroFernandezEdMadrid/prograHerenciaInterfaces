package javapowersolutions;

import daw.com.Teclado;

public class Desarrollo extends Producto {
	private String lenguaje;
	private int lineas;
	private float precioLinea;

	public Desarrollo(String id, String nombre, String lenguaje, int lineas, float precioLinea) {
		super(id, nombre);
		this.lenguaje = lenguaje;
		setLineas(lineas);
		setPrecioLinea(precioLinea);
	}

	public Desarrollo(String id) {
		this(id,"","",0,0);
	}
	
	public Desarrollo() {
		this("");
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public int getLineas() {
		return lineas;
	}

	public void setLineas(int lineas) {
		if (lineas<0) {
			lineas=0;
		}
		this.lineas = lineas;
	}

	public float getPrecioLinea() {
		return precioLinea;
	}

	public void setPrecioLinea(float precioLinea) {
		if (precioLinea<0) {
			precioLinea=0;
		}
		this.precioLinea = precioLinea;
	}
	
	@Override
	public String toString() {
		return "Desarrollo ID:"+ getId() + ", nombre="+ getNombre()
		+ ", lenguaje=" + lenguaje + ", lineas=" + lineas 
		+ ", precioLinea=" + precioLinea;
	}
	
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setLenguaje(Teclado.leerString("\nLenguaje: "));
		setLineas(Teclado.leerInt("\nNumero de lineas: "));
		setPrecioLinea(Teclado.leerFloat("\nPrecio/linea: "));
	}
	
	public void mostrarDatos() {
		System.out.println(this);
	}
	
	@Override
	public float getPrecioFinal() {
		return lineas*precioLinea;
	}

}

package electrodomestico;

import java.util.ArrayList;
import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Electrodomestico {
	private final static Color COLORDEFECTO=Color.BLANCO;
	private final static Consumo CONSUMODEFECTO=Consumo.F;
	private final static float PRECIOBASE=100;
	private final static float PESOBASE=5;

	private final String id;
	private int stock;
	private float precio;
	private Color color;
	private Consumo consumo;
	private float peso;

	public Electrodomestico(String id, int stock, float precio, Color color, Consumo consumo, float peso) {
		this.id=id;
		setStock(stock);
		setPrecio(precio);
		setColor(color);
		setConsumo(consumo);
		setPeso(peso);
	}

	public Electrodomestico(String id) {
		this(id,0,PRECIOBASE,COLORDEFECTO,CONSUMODEFECTO,PESOBASE);
	}

	public Electrodomestico() {
		this("");
	}

	public String getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if (stock<0) {
			stock=0;
		}
		this.stock = stock;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		if (precio<0) {
			precio=0;
		}
		this.precio = precio;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "\nID=" + id + 
				"\nStock=" + stock + 
				"\nPrecio=" + precio + 
				"\nColor=" + color+ 
				"\nConsumo=" + consumo + 
				"\nPeso=" + peso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;*/
		Electrodomestico other = (Electrodomestico) obj;
		return Objects.equals(id, other.id);
	}

	public void leerDatos () {
		setStock(Teclado.leerInt("\nStock: "));
		setPrecio(Teclado.leerFloat("\nPrecio: "));
		setColor(leerColor());
		setConsumo(leerConsumo());
		setPeso(Teclado.leerFloat("\nPeso: "));
	}

	public void mostrarDatos() {
		System.out.println(this);
	}

	public Consumo leerConsumo ()
	{
		String cons;
		ArrayList <String> consumos = new ArrayList<> ();


		consumos = Consumo.getValuesAsStringArrayList();

		do
		{
			Pantalla.escribirString("\nElija un consumo");
			Pantalla.escribirString("\n" + consumos);
			cons = Teclado.leerString("\nConsumo").toUpperCase();
		}while (!consumos.contains(cons));	

		return Consumo.valueOf(cons); // Convertir String a enum
	}

	public Color leerColor ()
	{
		String col;
		ArrayList <String> colores = new ArrayList<> ();	

		colores = Consumo.getValuesAsStringArrayList();

		do
		{
			Pantalla.escribirString("\nElija un consumo");
			Pantalla.escribirString("\n" + colores);
			col = Teclado.leerString("\nConsumo").toUpperCase();
		}while (!colores.contains(col));

		return Color.valueOf(col); // Convertir String a enum
	}

	public float getRecargoPeso() {
		float recargo=0;

		if (peso>=80) {
			recargo=100;
		}else if (peso>=50&&peso<=79) {
			recargo=80;
		}else if (peso>=20&&peso<=49) {
			recargo=50;
		}else if (peso>=0&&peso<=19) {
			recargo=10;
		}

		return recargo;
	}

	public float getPrecioBase() {
		return consumo.getCoste()+getRecargoPeso();
	}

	public abstract float getPrecioFinal();

}

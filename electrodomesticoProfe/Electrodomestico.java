package electrodomesticoProfe;

import java.util.ArrayList;
import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Electrodomestico implements LeerYMostrarDatos {
	// Valores por defecto
	private final static float PRECIOBASE = 100;
	private final static Color COLOR = Color.BLANCO;
	private final static ConsumoElectrodomestico CONSUMO = ConsumoElectrodomestico.F;
	private final static int PESO = 5;
	
	
	
	private String identificador;
	private int stock; 
	private float preciobase;
	private Color color;
	private ConsumoElectrodomestico consumo;
	private int peso;
	
	public Electrodomestico ()
	{
		this ("");
	}
	
	public Electrodomestico (String identificador)
	{
		this (identificador, 0, PRECIOBASE, COLOR, CONSUMO, PESO);
	}
	
	
	
	public Electrodomestico(String identificador, int stock, 
			float preciobase, Color color, ConsumoElectrodomestico consumo, int peso) 
	{
		
		this.identificador = identificador;
		setStock (stock);
		setPreciobase (preciobase);
		this.color = color;
		this.consumo = consumo;
		setPeso  (peso);
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0)
			stock = 0;
		this.stock = stock;
	}

	public float getPreciobase() {
		return preciobase;
	}

	private void setPreciobase(float preciobase) {
		if (preciobase < PRECIOBASE)
			preciobase = PRECIOBASE;
		this.preciobase = preciobase;
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		this.color = color;
	}
	
	public ConsumoElectrodomestico getConsumo() {
		return consumo;
	}

	private void setConsumo(ConsumoElectrodomestico consumo) {
		this.consumo = consumo;
	}
	
	public int getPeso() {
		return peso;
	}

	private void setPeso(int peso) {
		if  (peso < PESO)
			peso = PESO;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Electrodomestico [identificador=" + identificador + 
				", stock=" + stock + 
				", preciobase=" + preciobase +
				", color=" + color + 
				", consumo=" + consumo + 
				", peso=" + peso + 
				"]";
	}
	
	@Override
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);
		Pantalla.escribirFloat("\nprecio final", precioFinal());
	}
	
	public void leerIdentificador ()
	{
		identificador = Teclado.leerString("\nIdentificador ");
	}
	
	public void leerRestoDatos ()
	{
		setStock (Teclado.leerInt("stock"));
		setPreciobase (Teclado.leerFloat("precio base"));
		leerColor ();
		leerConsumo ();
		setPeso (Teclado.leerInt("peso"));
		
	}
	
	public void leerColor ()
	{
		String colorString;
		ArrayList<String> colores = new ArrayList<>();
		
		// crear arraylist de string a partir de array de colores
		for (Color c: Color.values())
			colores.add(c.toString()); 
		
		do
		{
			// Mostrar lista de colores
			Pantalla.escribirString("\n" + colores);
			// Elejir color
			colorString = Teclado.leerString("Elija un color ").toUpperCase();
		}while (!colores.contains(colorString)); // comprobar que est� en lista
		
		// Convertir String a Color
		this.color = Color.valueOf(colorString);
	}
	
	public void leerConsumo ()
	{
		String consumoString;
		ArrayList<String> consumos = new ArrayList<>();
		
		// crear arraylist de string a partir de array de consumos
		for (ConsumoElectrodomestico c: ConsumoElectrodomestico.values())
			consumos.add(c.toString());
		
		do
		{
			// Mostrar lista de colores
			Pantalla.escribirString("\n" + consumos);
			// Elejir consumo
			consumoString = Teclado.leerString("Elija un consumo ").toUpperCase();
		}while (!consumos.contains(consumoString)); // comprobar que est� en lista
		
		// Convertir String a Consumo
		this.consumo = ConsumoElectrodomestico.valueOf(consumoString);
		
	}

	
	public float precioFinal ()
	{
		
		float preciofinal = preciobase;
		
		// sumar precio por consumo
		preciofinal += consumo.getCoste();
				
		// sumar precio por peso
		if (peso > 80)
			preciofinal += 100;
		else if (peso > 50)
			preciofinal += 80;
		else if (peso > 20)
			preciofinal += 50;
		else
			preciofinal += 10;
		
		preciofinal += getExtra();
		
		return preciofinal;
	}
	

	public abstract float getExtra ();

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// lo quito para evitar que falle la chapuza
		/*
		if (getClass() != obj.getClass()) {
			return false;
		}*/
		Electrodomestico other = (Electrodomestico) obj;
		if (!identificador.equals(other.identificador)) {
			return false;
		}
		return true;
	}
	
}

package lienzo;

import java.util.ArrayList;

import daw.com.Teclado;
import Libreria.Libreria;

public class Lienzo {
	private String nombre;
	private int alto;
	private int ancho;
	private ArrayList<Figura> figuras;
	
	public Lienzo(String nombre, int alto, int ancho, ArrayList<Figura> figuras) {
		
		this.nombre = nombre;
		setAlto (alto);
		setAncho (ancho);
		setFiguras (figuras);
	}
	
	public Lienzo (String nombre)
	{
		this (nombre, 1, 1, new ArrayList<>());
	}

	public Lienzo ()
	{
		this ("");
	}
	
	public Lienzo (Lienzo original)
	{
		this (original.nombre, original.ancho,
				original.alto, original.figuras);
	}

	public String getNombre() {
		return nombre;
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public ArrayList<Figura> getFiguras() {
		ArrayList<Figura> copia = new ArrayList<>();
		
		for (Figura f : figuras)
			copia.add(crearCopiaFigura(f));
		
		return copia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAlto(int alto) {
		if (alto < 1)
			alto = 1;
		this.alto = alto;
	}

	public void setAncho(int ancho) {
		if (ancho < 1)
			ancho = 1;
		this.ancho = ancho;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		
		this.figuras = new ArrayList<>();
		
		for (Figura f : figuras)
			//this.figuras.add(crearCopiaFigura(f));
			addFigura (f);
			
	}
	
	public static Figura crearCopiaFigura (Figura f)
	{
		/*
		return 	switch (f){
		case Rectangulo r -> new Rectangulo(r);
		case Circulo c -> new Circulo(c);
		default -> f;
		};
		*/
		
		Figura copia;
		
		if (f instanceof Rectangulo r) // pattern matching
			copia = new Rectangulo(r);   
		else if (f instanceof Circulo c)
			copia = new Circulo(c);
		else
			copia = f;
		
		return copia;
	}
	
	public float getArea ()
	{
		return alto * ancho;
	}
	
	public float getAreaFiguras ()
	{
		float area = 0;
		
		for (Figura f : figuras)
			area += f.getArea();
		
		return area;
	}
	
	public boolean addFigura (Figura f)
	{
		boolean exito = false;
		
		if (!figuras.contains(f) &&
				getAreaFiguras () + f.getArea() <= 
				getArea() )
		{
			exito = true;
			figuras.add(crearCopiaFigura(f));
		}
		
		return exito;
	}
	
	public void leerDatos ()
	{
		nombre = Teclado.leerString("nombre lienzo");
		alto = Libreria.leerEnteroPositivo("\nalto");
		ancho = Libreria.leerEnteroPositivo("\nancho");
	}
	public boolean estaLLena ()
	{
		return getArea() == getAreaFiguras();
	}
	
	public  Figura getFigura (String nombreFigura)
	{
		Figura figura; 
		int cual;
		
		figura =  new Rectangulo (nombreFigura);//chapuza
		
		cual = figuras.indexOf(figura);
		
		if (cual >= 0)
			figura = crearCopiaFigura(figuras.get(cual));
		else
			figura = null;
		
		return figura;
	}
	
	public boolean eliminarFigura (String nombreFigura)
	{
		boolean exito = false;
		Figura f;
		
		f = getFigura (nombreFigura);
		
		if (f != null)
		{
			exito = true;
			figuras.remove(f);
		}
		
		return exito;
	}
	

}
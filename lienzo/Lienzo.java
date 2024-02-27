package lienzo;

import java.util.ArrayList;

public class Lienzo {
	private String nombre;
	private int ancho, alto;
	private ArrayList<Figura> figuras;

	public Lienzo(String nombre, int ancho, int alto, ArrayList<Figura> figuras) {
		this.nombre = nombre;
		setAncho(ancho);
		setAlto(alto);
		figuras=new ArrayList<Figura>();
	}

	public Lienzo(String nombre) {
		this(nombre, 0,0,new ArrayList<Figura>());
	}

	public Lienzo() {
		this("");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho<0) {
			ancho=0;
		}
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto<0) {
			alto=0;
		}
		this.alto = alto;
	}

	public ArrayList<Figura> getFiguras() {
		ArrayList<Figura> copia;

		copia=new ArrayList<Figura>();

		for (int i = 0; i < figuras.size(); i++) {
			if (figuras.get(i) instanceof Circulo c) { //Pattern matching, c es referencia
				copia.set(i, new Circulo(c));
			}else if (figuras.get(i) instanceof Rectangulo r) {
				copia.set(i, new Rectangulo(r));
			}
		}

		return copia;
	}

	public void setFiguras(ArrayList<Figura> figuras) {

		ArrayList<Figura> copia;
		int areaLienzo=alto*ancho;


		copia=new ArrayList<Figura>();

		for (int i = 0; i < figuras.size(); i++) {
			if (figuras.get(i).getArea()<=(areaLienzo-calcularAreaOcupada(copia))&&!copia.contains(figuras.get(i))) { //Que quepan y no esten repetidas
				if (figuras.get(i) instanceof Circulo c) { //Pattern matching, c es referencia
					copia.set(i, new Circulo(c));
				}else if (figuras.get(i) instanceof Rectangulo r) {
					copia.set(i, new Rectangulo(r));
				}
			}else
				System.out.println("No cabe mas");
		}

		this.figuras = copia;
	}

	public boolean addFigura(Figura nueva) {
		//Se puede anadir si el area de las figuras que 
		//hay en el liezo no supera el area del propio lienzo
		Figura copia;
		boolean exito=false;
		int areaLienzo=alto*ancho;
		int areaOcupada=calcularAreaOcupada(figuras);

		if (nueva instanceof Circulo c) { //Pattern matching
			copia=new Circulo(c);
		}else {
			copia=new Rectangulo((Rectangulo)nueva);//Cast cutre
		}

		if (areaOcupada<areaLienzo&&copia.getArea()<=(areaLienzo-areaOcupada)) {
			if (!figuras.contains(copia)) {
				figuras.add(nueva);
				exito=true;
			}

		}

		return exito;
	}

	private int calcularAreaOcupada(ArrayList<Figura> figuras2) {
		int total=0;

		for (int i = 0; i < figuras.size(); i++) {
			total+=figuras.get(i).getArea();
		}

		return total;
	}

	public boolean eliminarFigura(String nombre) {
		boolean exito=false;
		
		for (int i = 0; i < figuras.size()&&!exito; i++) {
			if (figuras.get(i).getNombre().equalsIgnoreCase(nombre)) {
				figuras.remove(i);
				exito=true;
			}
		}
		
		return exito;
	}
	
	public int getFiguraMayor() {
		int donde=0;
		
		for (int i = 0; i < figuras.size(); i++) {
			if (figuras.get(i).getArea()>figuras.get(donde).getArea()) {
				donde=i;
			}
		}
		
		return donde;
	}
}

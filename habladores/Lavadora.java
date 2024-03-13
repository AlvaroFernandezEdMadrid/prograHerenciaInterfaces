package habladores;

public class Lavadora extends Aparato {
	private int alto, ancho;

	public Lavadora(String consumo, float precio, int alto, int ancho) {
		super(consumo, precio);
		setAlto(alto);
		setAncho(ancho);
	}

	public Lavadora(String consumo, float precio) {
		this(consumo,precio, 0,0);
	}
	
	public Lavadora() {
		this("",0);
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

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho<0) {
			ancho=0;
		}
		this.ancho = ancho;
	}
	
}

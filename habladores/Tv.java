package habladores;

public class Tv extends Aparato{
	private boolean teletexto;
	private int antiguedad;
	
	public Tv(String consumo, float precio, boolean teletexto, int antiguedad) {
		super(consumo, precio);
		this.teletexto = teletexto;
		setAntiguedad(antiguedad);
	}
	
	public Tv(String consumo, float precio) {
		this("",0,false,0);
	}
	
	public Tv() {
		this("",0);
	}

	public boolean isTeletexto() {
		return teletexto;
	}
	public void setTeletexto(boolean teletexto) {
		this.teletexto = teletexto;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		if (antiguedad<0) {
			antiguedad=0;
		}
		this.antiguedad = antiguedad;
	}
	
}

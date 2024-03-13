package habladores;

public class Radio extends Aparato {
	private boolean cassete;
	private int potencia;
	
	public Radio(String consumo, float precio, boolean cassete, int potencia) {
		super(consumo, precio);
		this.cassete = cassete;
		setPotencia(potencia);
	}
	
	public Radio(String consumo, float precio) {
		this(consumo, precio, false, 0);
	}
	
	public Radio() {
		this("",0);
	}

	public boolean isCassete() {
		return cassete;
	}
	public void setCassete(boolean cassete) {
		this.cassete = cassete;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		if (potencia<0) {
			potencia=0;
		}
		this.potencia = potencia;
	}
	
}

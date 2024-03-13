package habladores;

public class Aparato {
	private String consumo;
	private float precio;
	
	public Aparato(String consumo, float precio) {
		setConsumo(consumo);
		setPrecio(precio);
	}
	
	public Aparato() {
		this("G",0);
	}

	public String getConsumo() {
		return consumo;
	}
	public void setConsumo(String consumo) {
		boolean loEs=false;
		final String CONSUMOS[]=new String[7];
		
		CONSUMOS[0]="A";CONSUMOS[1]="B";CONSUMOS[2]="C";
		CONSUMOS[3]="D";CONSUMOS[4]="E";CONSUMOS[5]="F";
		CONSUMOS[6]="G";
		
		for (int i = 0; i < CONSUMOS.length&&!loEs; i++) {
			if (consumo.equalsIgnoreCase(CONSUMOS[i])) {
				loEs=true;
			}
		}
		
		if (loEs) {
			this.consumo = consumo;
		}else
			this.consumo="G";
		
		
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
	
	
}

package habladores;

public class Ave {
	private String sexo;
	private int edad;
	
	public Ave(String sexo, int edad) {
		this.sexo = sexo;
		setEdad(edad);
	}
	
	public Ave() {
		this("",0);
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		if (edad<0) {
			edad=0;
		}
		this.edad = edad;
	}
	
}

package habladores;

public class Profesor extends Persona{
	private String email;
	private int despacho;
	
	public Profesor(String nombre, int edad, String email, int despacho) {
		super(nombre, edad);
		this.email = email;
		setDespacho(despacho);
	}
	
	public Profesor() {
		this("",0,"",1);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDespacho() {
		return despacho;
	}
	public void setDespacho(int despacho) {
		if (despacho<1) {
			despacho=1;
		}
		this.despacho = despacho;
	}
	
	
}

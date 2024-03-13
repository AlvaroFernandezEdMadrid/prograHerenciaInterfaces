package habladores;

public class Bedel extends Persona {
	private int turno;
	private String email;
	
	public Bedel(String nombre, int edad, int turno, String email) {
		super(nombre, edad);
		this.turno = turno;
		this.email = email;
	}
	
	public Bedel(String nombre, int edad) {
		this(nombre, edad, 1, "");
	}
	
	public Bedel() {
		this("",0);
	}

	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		if (turno<1) {
			turno=1;
		}
		this.turno = turno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

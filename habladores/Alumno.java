package habladores;

public class Alumno extends Persona {
	private String carrera;
	private int curso;
	
	public Alumno(String nombre, int edad, String carrera, int curso) {
		super(nombre, edad);
		this.carrera = carrera;
		setCurso(curso);
	}
	
	public Alumno(String nombre, int edad) {
		this(nombre, edad, "", 1);
	}
	
	public Alumno() {
		this("",0);
	}
	
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		if (curso<1) {
			curso=1;
		}
		this.curso = curso;
	}
	
}

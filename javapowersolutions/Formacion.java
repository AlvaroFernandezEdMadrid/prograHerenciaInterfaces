package javapowersolutions;

import daw.com.Teclado;

public class Formacion extends Producto {
	private int horas;
	private int profesores;
	private String titulacion;
	
	public Formacion(String id, String nombre, int horas, int profesores, String titulacion) {
		super(id, nombre);
		setHoras(horas);
		setProfesores(profesores);
		this.titulacion = titulacion;
	}
	
	public Formacion(String id) {
		this(id,"",0,0,"");
	}
	
	public Formacion() {
		this("");
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		if (horas<0) {
			horas=0;
		}
		this.horas = horas;
	}

	public int getProfesores() {
		return profesores;
	}

	public void setProfesores(int profesores) {
		if (profesores<0) {
			profesores=0;
		}
		this.profesores = profesores;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return "Formacion ID=" + getId()+
				", nombre="+getNombre()+
				", horas="+horas+
				", profesores=" + profesores +
				", titulacion=" + titulacion
				;
	}

	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setHoras(Teclado.leerInt("\nNumero de horas: "));
		setProfesores(Teclado.leerInt("\nNumero de profesores: "));
		setTitulacion(Teclado.leerString("\nTitulacion: "));
	}
	
	public void mostrarDatos() {
		System.out.println(this);
	}
	
	@Override
	public float getPrecioFinal() {
		return horas*profesores*300;
	}

}

package empleadosEnsenanza;

import java.time.LocalDate;

import Libreria.Libreria;
import daw.com.Teclado;

public class Profesor extends Empleado {

	private String titulacion;
	private int nPublicaciones;
	
	public Profesor(String nombre, LocalDate fNac, String dni, float sueldoBase, String titulacion,
			int nPublicaciones) {
		super(nombre, fNac, dni, sueldoBase);
		this.titulacion = titulacion;
		setnPublicaciones(nPublicaciones);
	}
	
	public Profesor(String dni) {
		super(dni);
		this.titulacion="";
		setnPublicaciones(0);
	}
	
	public Profesor() {
		this("");
	}
	
	public Profesor(Profesor og) {
		super(og);
		this.nPublicaciones=og.nPublicaciones;
		this.titulacion=og.titulacion;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getnPublicaciones() {
		return nPublicaciones;
	}

	public void setnPublicaciones(int nPublicaciones) {
		if (nPublicaciones<0) {
			nPublicaciones=0;
		}
		this.nPublicaciones = nPublicaciones;
	}
	
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setTitulacion(Teclado.leerString("Titulacion: "));
		setnPublicaciones(Libreria.leerEnteroPositivo("Cuantas publicaciones: "));
	}

	@Override
	public String toString() {
		return "Profesor [titulacion=" + titulacion + ", nPublicaciones=" + nPublicaciones + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public float getSueldoNeto() {
		float sueldoNeto=this.getSueldoBase();
		
		if (nPublicaciones>0) {
			sueldoNeto+=(nPublicaciones*20);
		}
		
		return sueldoNeto;
	}

}

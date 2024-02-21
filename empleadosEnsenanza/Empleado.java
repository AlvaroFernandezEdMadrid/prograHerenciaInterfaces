package empleadosEnsenanza;

import java.time.LocalDate;

import Libreria.Libreria;
import daw.com.Teclado;

public abstract class Empleado {

	private String nombre;
	private LocalDate fNac;
	private String dni;
	private float sueldoBase;
	
	public Empleado(String nombre, LocalDate fNac, String dni, float sueldoBase) {
		this.nombre = nombre;
		setfNac(fNac);
		this.dni = dni;
		setSueldoBase(sueldoBase);
	}
	
	public Empleado(String dni) {
		this("", LocalDate.now().minusYears(16), dni,0);
	}
	
	public Empleado() {
		this("");
	}
	
	public Empleado(Empleado og) {
		this.nombre=og.nombre;
		this.fNac=og.fNac;
		this.dni=og.dni;
		this.sueldoBase=og.sueldoBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getfNac() {
		return fNac;
	}

	public void setfNac(LocalDate fNac) {
		if (!fNac.isBefore(LocalDate.now().minusYears(16))) {
			fNac=LocalDate.now().minusYears(16);
		}
		this.fNac = fNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		if (sueldoBase<0) {
			sueldoBase=0;
		}
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + 
				", fNac=" + fNac + ", dni=" + dni + 
				", sueldoBase=" + sueldoBase + "]";
	}
	
	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		setDni(Teclado.leerString("DNI: "));
	}

	public void leerOtrosDatos() {
		setNombre(Teclado.leerString("Nombre: "));
		setfNac(LocalDate.parse(Teclado.leerString("Fecha de nacimiento AAAA-MM-DD:")));
		setSueldoBase(Libreria.leerEnteroPositivo("Sueldo base: "));
	}
	
	public boolean equals(Empleado otro) {
		return dni.equalsIgnoreCase(otro.dni);
	}
	
	public abstract float getSueldoNeto();
	
}

package inmobiliaria;

import java.util.Objects;

import daw.com.Teclado;

public class Cliente {
	private String nombre;
	private String dni;
	private float Presupuesto;
	
	public Cliente(String nombre, String dni, float Presupuesto) {
		this.nombre = nombre;
		this.dni = dni;
		setPresupuesto(Presupuesto);
	}
	
	public Cliente(String dni) {
		this("",dni,0);
	}
	
	public Cliente() {
		this("");
	}
	
	public Cliente(Cliente og) {
		this(og.nombre,og.dni,og.Presupuesto);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public float getPresupuesto() {
		return Presupuesto;
	}

	public void setPresupuesto(float Presupuesto) {
		if (Presupuesto<0) {
			Presupuesto=0;
		}
		this.Presupuesto = Presupuesto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;*/
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + "\nDNI=" + dni + "\nPresupuesto=" + Presupuesto;
	}
	
	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		setDni(Teclado.leerString("\nDNI:"));
	}

	public void leerOtrosDatos() {
		setNombre(Teclado.leerString("\nNombre: "));
		setPresupuesto(Teclado.leerFloat("\nPresupuesto: "));
	}
	
}

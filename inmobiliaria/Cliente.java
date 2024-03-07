package inmobiliaria;

import daw.com.Teclado;

public class Cliente {
	private String dni;
	private String nombre;
	private float cantidad;
	
	public Cliente(String dni, String nombre, float cantidad) {
		
		this.dni = dni;
		this.nombre = nombre;
		setCantidad (cantidad);
	}

	public Cliente(String dni) {
		this (dni, "", 0);
	}
	
	public Cliente ()
	{
		this ("");
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		if (cantidad < 0)
			cantidad = 0;
		
		this.cantidad = cantidad;
	}
	
	public void leerClave ()
	{
		dni = Teclado.leerString("\ndni ");
	}
		
	public void leerOtrosDatos ()
	{
		nombre = Teclado.leerString("nombre ");
		setCantidad (Teclado.leerFloat("Cantidad a gastar "));
	}

	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}




}
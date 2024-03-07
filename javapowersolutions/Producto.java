package javapowersolutions;

import java.util.Objects;

import daw.com.Teclado;

public abstract class Producto {
	private String id;
	private String nombre;

	public Producto(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Producto(String id) {
		this(id, "");
	}

	public Producto() {
		this("");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;*/
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}
	
	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		id=Teclado.leerString("\nID: ");
	}

	public void leerOtrosDatos() {
		setNombre(Teclado.leerString("\nNombre: "));
	}

	public abstract float getPrecioFinal();

}
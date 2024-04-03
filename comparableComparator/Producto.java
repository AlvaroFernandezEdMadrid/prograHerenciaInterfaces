package comparableComparator;

import java.util.Objects;

import daw.com.Teclado;

public class Producto implements Comparable<Producto>{
	private String nombre;
	private float precio;
	private int cantidad;

	public Producto(String nombre, float precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Producto() {
		this("",0,0);
	}
	
	public Producto(Producto og) {
		this.nombre=og.nombre;
		this.precio=og.precio;
		this.cantidad=og.cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		if (precio<0) {
			precio=0;
		}
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int compareTo(Producto o) {
		
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Producto Nombre=" + nombre + ", Precio=" + precio + ", Cantidad=" + cantidad;
	}

	public void leerClave() {
		setNombre(Teclado.leerString("\nNombre del producto: "));
	}

	public void leerOtrosDatos() {
		setPrecio(Teclado.leerFloat("\nPrecio del producto: "));
		setCantidad(Teclado.leerInt("\nCantidad del producto: "));
	}
	
}

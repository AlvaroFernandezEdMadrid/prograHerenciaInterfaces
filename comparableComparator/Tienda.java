package comparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Tienda {
	private ArrayList<Producto> productos;

	public Tienda(ArrayList<Producto> productos) {
		setProductos(productos);
	}
	
	public Tienda() {
		this(null);
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		if (productos==null) {
			productos=new ArrayList<Producto>();
		}
		this.productos = productos;
	}
	
	public boolean addProducto(Producto p) {
		boolean exito=false;
		
		if (p!=null) {
			if (!productos.contains(p)) {
				productos.add(p);
				exito=true;
			}else {
				System.out.println("\nEl producto ya esta en la lista.");
			}
		}
		
		if(exito) {
			System.out.println("\nProducto anadido con exito.");
		}else {
			System.out.println("\nEl producto no se ha podido anadir.");
		}
		
		return exito; 
	}
	
	public boolean removeProducto(Producto p) {
		boolean exito=false;
		
		if (p!=null) {
			if (productos.contains(p)) {
				productos.remove(p);
				exito=true;
			}
		}
		
		return exito;
	}
	
	public void listarNormal() {
		for(Producto p:productos)
			System.out.println("\n"+p);
	}
	
	public void listarOrdenadosNombre() {
		ArrayList<Producto> prodCopia;
		
		prodCopia=new ArrayList<Producto>();
		
		for (Producto p:productos)
			prodCopia.add(new Producto(p));
		
		Collections.sort(prodCopia);
		
		for(Producto p:prodCopia)
			System.out.println("\n"+p);
	}
	
	public void listarOrdenadosPrecio() {
		ArrayList<Producto> prodCopia;

		prodCopia=new ArrayList<Producto>();

		for (Producto p:productos)
			prodCopia.add(new Producto(p));
		
		prodCopia.sort(new ComparadorPrecio());

		for(Producto p:prodCopia)
			System.out.println("\n"+p);
	}
}

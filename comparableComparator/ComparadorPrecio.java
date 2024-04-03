package comparableComparator;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		
		return Float.compare(o1.getPrecio(), o2.getPrecio());
	}
	
}

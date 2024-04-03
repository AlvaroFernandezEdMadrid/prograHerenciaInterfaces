package comparableComparator;

public class AppComparatorComparable extends AppConMenu {

	private Tienda tienda;

	public AppComparatorComparable() {
		super();
		this.tienda=new Tienda();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppComparatorComparable app=new AppComparatorComparable();

		app.addOpcion("Anadir producto");
		app.addOpcion("Quitar producto");
		app.addOpcion("Listar por nombre");
		app.addOpcion("Listar por precio");
		app.addOpcion("Listar sin ordenar");

		app.run();
	}

	@Override
	public void evaluarOpcion(int opc) {
		switch (opc) {
		case 1:
			addProductoTienda();
			break;
		case 2:
			removeProductoTienda();
			break;
		case 3:
			tienda.listarOrdenadosNombre();
			break;
		case 4:
			tienda.listarOrdenadosPrecio();
			break;
		case 5:
			tienda.listarNormal();;
			break;
		}
	}

	private void addProductoTienda() {
		Producto p;

		p=new Producto();

		do {
			p.leerClave();
		} while (tienda.getProductos().contains(p));

		p.leerOtrosDatos();

		tienda.addProducto(p);
	}

	private void removeProductoTienda() {
		Producto p;

		p=new Producto();


		p.leerClave();
		
		if (tienda.removeProducto(p)) {
			System.out.println("\nProducto eliminado correctamente.");
		}else {
			System.out.println("\nProducto no encontrado.");
		}

	}
}

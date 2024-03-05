package inmobiliaria;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppInmobiliaria extends AppConMenu {
	
	private Inmobiliaria inmboliaria;
	
	public AppInmobiliaria ()
	{
		super (); // llamar al constructor por defecto del padre
		
		// Cargar opciones de menÃº
		addOpcion("Annadir Vivienda");
		addOpcion("Eliminar Vivienda");
		addOpcion("Mostrar Vivienda");
		addOpcion("Mostrar Viviendas");
		
		// Crear objeto inmobiliaria
		
		inmboliaria = new Inmobiliaria("dam1");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppInmobiliaria app = new AppInmobiliaria();
		app.run();

	}
	
	
	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		switch (opc)
		{
			case 1:
				altaVivienda ();
				break;
			case 2:
				bajaVivienda ();
				break;
			case 3:
				mostrarVivienda ();
				break;
			case 4:
				mostrarViviendas ();
				break;
			case 5:
				salir ();
		}
	}
	
	public void mostrarViviendas() {
		// TODO Auto-generated method stub
		for (int i = 0; i < inmboliaria.getNViviendas(); i++)
			Pantalla.escribirString("\n" + inmboliaria.getVivienda(i));

	}


	public void mostrarVivienda() {
		// TODO Auto-generated method stub
		Direccion direccion = new Direccion (); 
		Vivienda v;
		
		direccion.leerDatos();
		
		v = inmboliaria.getVivienda(direccion);
		
		if (v != null)
			Pantalla.escribirString("\n" + inmboliaria.toString());
		else
			Pantalla.escribirString("\nVivienda no encontrada");
	}

	public void salir() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nAdios....");
		
	}

	public void bajaVivienda() {
		// TODO Auto-generated method stub
		Direccion direccion = new Direccion (); 
		
		direccion.leerDatos();

		if (inmboliaria.eliminarVivienda(direccion))
			Pantalla.escribirString("\nVivienda eliminada correctamente");
		else
			Pantalla.escribirString("\nVivienda no encontrada");
		
	}

	public void altaVivienda ()
	{
		Direccion direccion = new Direccion (); 
		Vivienda v;
		int tipo;
		
		direccion.leerDatos();
		
		if (inmboliaria.getVivienda(direccion) == null)
		{
			do
			{
				tipo = Teclado.leerInt("Tipo de vivienda (1/2)");
			}while (tipo != 1 && tipo != 2);
			
			if (tipo == 1)
				v = new ViviendaLibre (direccion);
			else 
				v = new ViviendaProtegida (direccion);
			
			v.leerOtroDatos();
			
			inmboliaria.insertarVivienda(v);
			
			Pantalla.escribirString("\nvivienda insertada");
		}
		else
			Pantalla.escribirString("\nYa existe una vivienda en esa direcciÃ³n");
		
	}


}
package inmobiliaria;

import java.util.ArrayList;

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
		addOpcion("Insertar Cliente");
		addOpcion("Mostrar Clientes");
		addOpcion("Insertar Visita");
		addOpcion("Mostrar Visitas de un Cliente");
		
		
		// crear objeto inmobiliaria
		
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
				insertarCliente ();
				break;
			case 6:
				mostrarClientes ();
				break;
			case 7:
				insertarVisita ();
				break;
			case 8:
				mostrarVisitasPorCliente ();
				break;
			case 9:
				salir ();
		}
	}
	
	public void mostrarVisitasPorCliente() {
		// TODO Auto-generated method stub
		String dni;
		Cliente cliente;
		ArrayList<Visita> visitasCliente;
		
		dni = Teclado.leerString("dni ");
		
		cliente = inmboliaria.getCliente(dni);
		
		if ( cliente != null)
		{
			visitasCliente = inmboliaria.getVisitasPorCliente(cliente);
			if (!visitasCliente.isEmpty())
			{
				Pantalla.escribirString("\nListado de visitas del cliente " + cliente.getDni());
				for (Visita visita : visitasCliente)
				{
					// filtrar las visitas 
					if (visita.getVivienda().getPrecioFinal() < visita.getCliente().getCantidad())
						Pantalla.escribirString("\n" + visita);
				}
			}
			else
				Pantalla.escribirString("\nEl cliente no tiene visitas");
		}
	}
	
	public void insertarVisita() {
		// TODO Auto-generated method stub
		String dni;
		Direccion direccion;
		Vivienda vivienda;
		Cliente cliente;
		Visita visita;
		
		dni = Teclado.leerString("dni ");
		cliente = inmboliaria.getCliente(dni);
		
		if (cliente != null)
		{
			direccion = new Direccion ();
			direccion.leerDatos();
			vivienda = inmboliaria.getVivienda(direccion);
			
			if (vivienda != null)
			{
				visita = new Visita (vivienda, cliente);
				visita.leerDatos();
				inmboliaria.insertarVisita(visita);
				Pantalla.escribirString("\nVisita registrada correctamente");
			}
			else
				Pantalla.escribirString("\nNo existe la vivienda");
		}
		else
			Pantalla.escribirString("\nNo existe el cliente");
		
		
	}
	

	public void mostrarClientes() {
		// TODO Auto-generated method stub
		
		for (Cliente cliente : inmboliaria.getClientes())
			Pantalla.escribirString("\n" + cliente);
		
	}
	
	public void insertarCliente() {
		// TODO Auto-generated method stub
		String dni;
		Cliente cliente;
		
		dni = Teclado.leerString("dni ");
		
		cliente = new Cliente (dni);
		
		if (inmboliaria.getCliente(dni) == null)
		{
			cliente.leerOtrosDatos();
			inmboliaria.insertarCliente(cliente);
		}
		else
			Pantalla.escribirString("Cliente ya existe");
		
		
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
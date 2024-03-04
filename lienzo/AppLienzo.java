package lienzo;

import java.util.ArrayList;

import daw.com.Pantalla;
import daw.com.Teclado;
import Libreria.Libreria;

public class AppLienzo extends AppConMenu {

	private Lienzo lienzo;
	
	public AppLienzo ()
	{
		super ();
		// Crear lienzo
		lienzo = new Lienzo ();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppLienzo app = new AppLienzo ();
		app.lienzo.leerDatos();
		
		// aÃ±adir opciones de menÃº
		app.addOpcion("AÃ±adir figura");
		app.addOpcion("Eliminar figura");
		app.addOpcion("Mostrar figura mayor");
		app.addOpcion("Alinear horizontal");
		app.addOpcion("Alinear vertical");

		app.run();
	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub

		switch (opc)
		{
			case 1:
					insertarFigura ();
					break;
			case 2:
					eliminarFigura ();
					break;
			case 3:
					mostrarMayor ();
					break;
			case 4:
					alinearHorizontal ();
					break;
			case 5:
					alinearVertical ();
					break;
					
			case 6:
					salir ();
					break;
		}
	}

	private void salir() {
		// TODO Auto-generated method stub
		ArrayList<Figura> figuras;
		Figura aux;
		
		figuras = lienzo.getFiguras();
		
		for (int i = 0; i < figuras.size() - 1; i++)
			for (int j = i +1; j < figuras.size(); j++)
				if (figuras.get(j).getPerimetro() > 
						figuras.get(i).getPerimetro())
				{
					aux = figuras.get(i);
					figuras.set(i, figuras.get(j));
					figuras.set(j, aux);
				}
		
		for (Figura f: figuras)
			Pantalla.escribirString("\n"+ f);
		
		/*
		lienzo.getFiguras().stream().
					sorted(Comparator.comparing(Figura::getPerimetro)).
					forEach(System.out::println);
		*/
	}

	private void alinearVertical() {
		// TODO Auto-generated method stub
		ArrayList<Figura> figuras;
		int xMasIzquierda;
		
		// sacar figuras del lienzo
		figuras = lienzo.getFiguras();
		
		// buscar la mÃ¡s alta
		xMasIzquierda = figuras.get(0).getX();
		for (Figura f: figuras)
			if (f.getX() < xMasIzquierda)
				xMasIzquierda = f.getX();
		// llevar todas las figuras a la y mÃ¡s alta
		for (Figura f: figuras)
			f.setX(xMasIzquierda);
		
		// Meter figuras en lienzo
		lienzo.setFiguras(figuras);
		
	}

	private void alinearHorizontal() {
		// TODO Auto-generated method stub
		
		ArrayList<Figura> figuras;
		int yMasAlta;
		
		// sacar figuras del lienzo
		figuras = lienzo.getFiguras();
		
		// buscar la mÃ¡s alta
		yMasAlta = figuras.get(0).getY();
		for (Figura f: figuras)
			if (f.getY() > yMasAlta)
				yMasAlta = f.getY();
		// llevar todas las figuras a la y mÃ¡s alta
		for (Figura f: figuras)
			f.setY(yMasAlta);
		
		// Meter figuras en lienzo
		lienzo.setFiguras(figuras);
	}

	private void mostrarMayor() {
		// TODO Auto-generated method stub
		Figura mayor;
		ArrayList<Figura> figuras;
		
		figuras = lienzo.getFiguras();
		
		mayor = figuras.get(0);
		
		for (Figura f: figuras)
			if (f.getArea() > mayor.getArea())
				mayor = f;
		
		Pantalla.escribirString("\n La figura mayor es " + mayor);
	}

	private void eliminarFigura() {
		// TODO Auto-generated method stub
		String nombre;
		
		nombre = Teclado.leerString("\nombre Figura");
		
		if (lienzo.eliminarFigura(nombre))
			Pantalla.escribirString("\nFigura borrada");
		else
			Pantalla.escribirString("\nLa figura no existe");
		
		
	}

	private void insertarFigura() {
		// TODO Auto-generated method stub
		Figura figura;
		String nombre;
		int tipo;
		if (!lienzo.estaLLena())
		{
			do
			{
				nombre = Teclado.leerString("\nombre Figura");
			} while (lienzo.getFigura(nombre) != null);

			tipo = Libreria.leerEntreLimites(1, 2, "\nTipo figura (1-2)");

			if (tipo == 1)
				figura = new Rectangulo (nombre);
			else
				figura = new Circulo (nombre);

			figura.leerOtrosDatos();

			if (lienzo.addFigura(figura))
				Pantalla.escribirString("\nfigura aÃ±adida correctamente");
			else
				Pantalla.escribirString("\nLa figura no cabe");
		}
		else
			Pantalla.escribirString("\nNo se admiten mÃ¡s figuras");
	}
}
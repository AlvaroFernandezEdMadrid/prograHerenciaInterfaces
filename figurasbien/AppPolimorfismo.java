package figurasbien;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppPolimorfismo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura figuras[];
		int cuantas, tipo;
		
		cuantas = Teclado.leerInt("\nCuantas?");
		
		figuras = new Figura[cuantas];
		
		for (int i = 0 ; i < cuantas; i++)
		{
			tipo = Teclado.leerInt("\ntipo figura");
			
			switch (tipo)
			{
				case 1:
					figuras[i] = new Rectangulo ();
					break;
				case 2:
					figuras[i] = new Circulo ();
					break;
				case 3:
					figuras[i] = new Triangulo ();
					break;
			}
			
			// magia -> polimorfismo
			figuras[i].leerDatos();
		}
		
		
		for (Figura f : figuras)
			if (f instanceof Circulo) {
				Pantalla.escribirString("\n" + f);
				Circulo c=(Circulo)f;		//Acceder a metodos del hijo
				c.setRadio(25);
			}
				
		
		 // Mostrar un listado de perimetros de figuras. 
		for(Figura f: figuras)
			System.out.println("\nPerimetro "+f.getPerimetro());
	}

}
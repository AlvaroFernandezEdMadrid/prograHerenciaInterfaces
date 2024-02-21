package empleadosEnsenanza;

import Libreria.Libreria;
import daw.com.Teclado;

public class AppEnsenanza {

	private Empleado personas[];
	
	public AppEnsenanza (int cuantas)
	{
		cuantas = cuantas <= 0 ? 1: cuantas;
		personas = new Empleado[cuantas];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int cuantas;
		
		cuantas = Teclado.leerInt("Cuantas personas:");
		
		AppEnsenanza app = new AppEnsenanza(cuantas);
		app.leerPersonas ();
		app.ordenarPersonasPorSueldo();
		app.mostrarDatos ();
		
	}

	private void mostrarDatos() {
		// TODO Auto-generated method stub
		for (Empleado e: personas)
			System.out.println(e.toString());
	}

	private void ordenarPersonasPorSueldo() {
		// TODO Auto-generated method stub
		Empleado aux;
		
		for (int i = 0 ; i < personas.length - 1; i++)
			for (int j = i + 1; j < personas.length; j++)
				if (personas[i].getSueldoNeto() < personas[j].getSueldoNeto())
				{
					aux = personas[i];
					personas[i] = personas[j];
					personas[j] = aux;
				}
	}

	private void leerPersonas() {
		// TODO Auto-generated method stub
		int tipo;
		
		for (int i = 0; i < personas.length; i++)
		{
			Empleado aux;
			System.out.println("["+(i+1)+"]");
			tipo = Libreria.leerEntreLimites(1, 3, "Tipo empleado"
					+ "\n1. Profesor"
					+ "\n2. Administrativo"
					+ "\n3. Auxiliar"
					+ "\nEleccion:");
			aux = null;
			switch (tipo)
			{
				case 1:
					aux = new Profesor ();
					break;
				case 2:
					aux = new Administrativo ();
					break;
				case 3:
					aux = new Auxiliar ();
					break;
			}
			do
			{
				// polimorfismo
				aux.leerClave();
			}while (contains (aux));
			
			aux.leerOtrosDatos();
			
			personas[i] = aux;
		}
		
	}

	private boolean contains(Empleado aux) {
		// TODO Auto-generated method stub
		boolean esta = false;
		
		for (int i = 0; !esta && i < personas.length; i++ )
			if (personas[i] != null && 
					personas[i].equals(aux))
				esta = true;
			
		return esta;
	}

}
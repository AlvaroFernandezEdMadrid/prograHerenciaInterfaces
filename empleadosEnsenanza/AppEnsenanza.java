package empleadosEnsenanza;

import Libreria.Libreria;

public class AppEnsenanza {

	public static void main(String[] args) {
		int cuantos;
		Empleado[] empleados;
		int tipo;
		
		cuantos=Libreria.leerEnteroPositivo("Cuantos empleados: ");
		
		empleados=new Empleado[cuantos];
		
		for (int i = 0; i < empleados.length; i++) {
			System.out.println("["+(i+1)+"]");
			mostrarTipos();
			
			tipo=Libreria.leerEntreLimites(1, 3, "Tipo de empleado:");
			
			switch (tipo) {
			case 1:
				empleados[i]= new Administrativo();
				break;
			case 2:
				empleados[i]= new Profesor();
				break;
			case 3:
				empleados[i]= new Auxiliar();
				break;
			}
			
			do {
				empleados[i].leerClave();
			} while (buscarEmpleado(empleados[i])!=-1);
		}
		
		listarPorSueldo(empleados);

	}

	private static int buscarEmpleado(Empleado empleado) {
		int pos=-1;
		
		
		
		return pos;
	}

	public static void listarPorSueldo(Empleado[] empleados) {
		
	}
	
	public static void mostrarTipos() {
		System.out.println("1. Administrativo");
		System.out.println("2. Profesor");
		System.out.println("3. Auxiliar");
	}

}

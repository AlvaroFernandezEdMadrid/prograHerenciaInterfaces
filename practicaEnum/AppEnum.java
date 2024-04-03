package practicaEnum;

import Libreria.Libreria;

public class AppEnum extends AppConMenu {
	private Agenda agenda;

	public AppEnum() {
		super();
		agenda=new Agenda();
	}

	public static void main(String[] args) {
		AppEnum app;

		app=new AppEnum();

		app.addOpcion("Anadir dia");
		app.addOpcion("Quitar dia");
		app.addOpcion("Ver dia siguiente");
		app.addOpcion("Listar todo");
		
		app.run();
	}

	@Override
	public void evaluarOpcion(int opc) {
		switch (opc) {
		case 1:
			addDia();
			break;
		case 2:
			removeDia();
			break;
		case 3:
			diaSiguiente();
			break;
		case 4:
			listarTodo();
			break;
		}
	}

	private void listarTodo() {
		for (DiasSemana d : agenda.getDias()) {
			System.out.println(d.toString());
		}
	}

	private void addDia() {
		DiasSemana diaA;
		int cual;

		cual=Libreria.leerEntreLimites(1, 7, "\nQue dia (1-7): ");

		switch (cual) {
		case 1:
			diaA=DiasSemana.LUNES;
			break;
		case 2:
			diaA=DiasSemana.MARTES;
			break;
		case 3:
			diaA=DiasSemana.MIERCOLES;
			break;
		case 4:
			diaA=DiasSemana.JUEVES;
			break;
		case 5:
			diaA=DiasSemana.VIERNES;
			break;
		case 6:
			diaA=DiasSemana.SABADO;
			break;
		default:
			diaA=DiasSemana.DOMINGO;
			break;
		}

		if (agenda.addDia(diaA)) {
			System.out.println("\nDia anadido con exito");
		}else {
			System.out.println("\nDia ya existente");
		}

	}

	private void removeDia() {
		DiasSemana diaA;
		int cual;

		cual=Libreria.leerEntreLimites(1, 7, "\nQue dia (1-7): ");
		
		switch (cual) {
		case 1:
			diaA=DiasSemana.LUNES;
			break;
		case 2:
			diaA=DiasSemana.MARTES;
			break;
		case 3:
			diaA=DiasSemana.MIERCOLES;
			break;
		case 4:
			diaA=DiasSemana.JUEVES;
			break;
		case 5:
			diaA=DiasSemana.VIERNES;
			break;
		case 6:
			diaA=DiasSemana.SABADO;
			break;
		default:
			diaA=DiasSemana.DOMINGO;
			break;
		}
		
		if (agenda.removeDia(diaA)) {
			System.out.println("\nDia quitado con exito");
		}
	}

	private void diaSiguiente() {
		int cual=Libreria.leerEntreLimites(1, 7, "\nQue dia (1-7): ");
		
		System.out.println(DiasSemana.getDiaSiguiente(cual));
	}
}

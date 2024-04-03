package practicaEnum;

import java.util.ArrayList;

public enum DiasSemana {
	LUNES(1), MARTES(2), MIERCOLES(3), JUEVES(4), VIERNES(5), SABADO(6), DOMINGO(7);

	int dia;

	private DiasSemana(int dia) {
		this.dia = dia;
	}

	public int getDia() {
		return dia;
	}

	public static ArrayList<String> diasSemanaToStringList(){
		ArrayList<String> diasSemana;

		diasSemana=new ArrayList<String>();

		for (DiasSemana d : DiasSemana.values()) {
			diasSemana.add(d.toString());
		}

		return diasSemana;
	}

	public static DiasSemana getDiaSiguiente(int ddia) {
		DiasSemana diaDevolver=LUNES;


		if (ddia==1) {
			diaDevolver=MARTES;
		}else if (ddia==2) {
			diaDevolver=MIERCOLES;
		}else if (ddia==3) {
			diaDevolver=JUEVES;
		}else if (ddia==4) {
			diaDevolver=VIERNES;
		}else if (ddia==5) {
			diaDevolver=SABADO;
		}else if (ddia==6){
			diaDevolver=DOMINGO;
		}

		return diaDevolver;
	}

}

package practicaEnum;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<DiasSemana> dias;

	public Agenda(List<DiasSemana> dias) {
		setDias(dias);
	}
	
	public Agenda() {
		this(null);
	}

	public List<DiasSemana> getDias() {
		return dias;
	}

	public void setDias(List<DiasSemana> dias) {
		if (dias==null) {
			dias=new ArrayList<DiasSemana>();
		}
		this.dias = dias;
	}
	
	public boolean addDia(DiasSemana d) {
		boolean exito=false;
		if (d!=null) {
			if (!dias.contains(d)) {
				dias.add(d);
				exito=true;
			}
		}
		return exito;
	}
	
	public boolean removeDia(DiasSemana d) {
		boolean exito=false;
		if (d!=null) {
			if (dias.contains(d)) {
				dias.remove(d);
				exito=true;
			}
		}
		return exito;
	}
	
	
}

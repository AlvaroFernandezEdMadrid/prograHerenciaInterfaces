package seriesvideojuegos;

import java.util.Comparator;

public class ComparadorHoras implements Comparator<Entregable> {

	@Override
	public int compare(Entregable o1, Entregable o2) {
		// TODO Auto-generated method stub
		return Float.compare(((VideoJuego)o1).getHorasEstimadas(), ((VideoJuego)o2).getHorasEstimadas());
	}

}
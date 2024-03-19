package electrodomestico;

import java.util.ArrayList;

public enum Consumo {
	A(100), B(80), C(60), D(50), E(30), F(10);

	private int coste;

	private Consumo(int coste) {
		this.coste=coste;
	}

	public int getCoste() {
		return coste;
	}

	// Convertir enumeracion a un ArrayList de String
	public static ArrayList<String> getValuesAsStringArrayList ()
	{


		//String consumos[] = new String [Consumo.values().length];
		ArrayList<String> consumos = new ArrayList<>();
		Consumo consumoElec[] = Consumo.values();

		for (int i = 0; i < consumoElec.length; i++)
			consumos.add (consumoElec[i].name());


		return consumos;
	}
}



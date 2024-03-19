package electrodomestico;

import java.util.ArrayList;

public enum Color {
	BLANCO, NEGRO, ROJO, AZUL, GRIS;

	// Convertir enumeracion a un ArrayList de String
	public static ArrayList<String> getValuesAsStringArrayList ()
	{
		//String colores[] = new String [Color.values().length];
		ArrayList<String> colores = new ArrayList<>();
		Color coloresElec[] = Color.values();

		for (int i = 0; i < coloresElec.length; i++)
			colores.add (coloresElec[i].name());


		return colores;
	}
}

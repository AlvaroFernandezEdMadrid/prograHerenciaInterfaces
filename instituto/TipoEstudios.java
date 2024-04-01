package instituto;

import java.util.ArrayList;

import electrodomestico.Consumo;

public enum TipoEstudios {
	ESO, BACHILLERATO, FPGMEDIO, FPGSUPERIOR;
	
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

package predicate;

import java.util.ArrayList;

import daw.com.Teclado;

public class AppPedorra {

	public static void main(String[] args) {
		ArrayList<Integer> numeros, numerosCopia0, numerosCopia1;
		boolean sigo=true;


		numeros=new ArrayList<Integer>();
		numerosCopia0=new ArrayList<Integer>();
		numerosCopia1=new ArrayList<Integer>();

		do {
			numeros.add(Teclado.leerInt("\nNumero: "));
			sigo=Teclado.leerString("Sigo? (S/N): ").equalsIgnoreCase("s")?true:false;
		} while (sigo);

		for (int i = 0; i < numeros.size(); i++) {
			numerosCopia0.add(numeros.get(i));
			numerosCopia1.add(numeros.get(i));
		}

		numerosCopia0.removeIf(new FiltroPares().negate());

		System.out.println("\nNumeros pares de la lista: ");

		for (Integer i : numerosCopia0) {
			System.out.println("\n"+i);
		}

		numerosCopia1.removeIf(new FiltroMayores10().negate());

		System.out.println("\nNumeros mayores de 10 de la lista: ");

		for (Integer i : numerosCopia1) {
			System.out.println("\n"+i);
		}
	}

}

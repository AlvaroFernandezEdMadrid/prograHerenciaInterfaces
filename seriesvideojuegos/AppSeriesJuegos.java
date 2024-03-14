package seriesvideojuegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AppSeriesJuegos {

	public static void main(String[] args) {
		ArrayList<Entregable> entregables=new ArrayList<Entregable>();
		Comparator<Videojuego> comparadorPorNHoras;
		Comparator<Serie> comparadorPorNTemporadas;
		int entregados=0;
		
		Videojuego v1=new Videojuego("The Legend of Zelda:Ocarina of Time", 100, "Nintendo");
		Serie s1=new Serie("Breaking Bad",5,"Drama criminal","Vince Gilligan");
		Videojuego v2=new Videojuego("Borderlands!: The Pre-Sequel", 200, "2K");
		Serie s2=new Serie("JoJo's Bizarre Adventure",6,"Aventuras","Hirohiko Araki");
		Videojuego v3=new Videojuego("Halo: Combat Evolved", 150, "Microsoft");
		Serie s3=new Serie("Amar en tiempos revueltos",7,"Melodrama","Josep Maria Benet i Jornet");
		
		entregables.add(v1);
		entregables.add(s1);
		entregables.add(v2);
		entregables.add(s2);
		entregables.add(v3);
		entregables.add(s3);
		
		v1.entregar();
		s2.entregar();
		
		//Contar entregados
		for(Entregable e:entregables) 
			if (e.isEntregado())
				entregados++;
			
		System.out.println("Hay "+entregados+" productos entregados.");	
		
		//Devolver todo
		for(Entregable e:entregables)
			if(e.isEntregado())
				e.devolver();
		
		//Sacar videojuego con mas horas
		comparadorPorNHoras=new Comparator<Videojuego>() {
			
			@Override
			public int compare(Videojuego o1, Videojuego o2) {
				int ret=-1;
				if (o1.getHorasEstimadas()==o2.getHorasEstimadas()) {
					ret=0;
				}else if (o1.getHorasEstimadas()>o2.getHorasEstimadas()) {
					ret=1;
				}
				return ret;
			}
		
		};
		
		Collections.max(entregables,comparadorPorNHoras);
		//Sacar serie con mas temporadas
		
		
	}

}

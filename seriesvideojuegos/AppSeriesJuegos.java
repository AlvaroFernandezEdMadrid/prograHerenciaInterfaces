package seriesvideojuegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AppSeriesJuegos {

	public static void main(String[] args) {
		ArrayList<Entregable> entregables=new ArrayList<Entregable>();
		Comparator<VideoJuego> comparadorPorNHoras;
		Comparator<Serie> comparadorPorNTemporadas;
		int entregados=0;
		
		VideoJuego v1=new VideoJuego("The Legend of Zelda:Ocarina of Time", 100, "Nintendo");
		Serie s1=new Serie("Breaking Bad",5,"Drama criminal","Vince Gilligan");
		VideoJuego v2=new VideoJuego("Borderlands!: The Pre-Sequel", 200, "GearBox");
		Serie s2=new Serie("JoJo's Bizarre Adventure",6,"Aventuras","Hirohiko Araki");
		VideoJuego v3=new VideoJuego("Halo: Combat Evolved", 150, "Microsoft");
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
		comparadorPorNHoras=new Comparator<VideoJuego>() {
			
			@Override
			public int compare(VideoJuego o1, VideoJuego o2) {
				int ret=-1;
				if (o1.getHorasEstimadas()==o2.getHorasEstimadas()) {
					ret=0;
				}else if (o1.getHorasEstimadas()>o2.getHorasEstimadas()) {
					ret=1;
				}
				return ret;
			}
		
		};
		
		
		//Sacar serie con mas temporadas
		
		
	}

}

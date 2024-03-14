package seriesvideojuegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppSeriesYVideosJuegos {

	private ArrayList <Entregable> entregables;
	
	
	public AppSeriesYVideosJuegos() {
		entregables = new ArrayList<>();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppSeriesYVideosJuegos app = new AppSeriesYVideosJuegos();
		app.cargarDatos ();
		
		
		app.entregar ();
		
		app.contar ();
		
		app.devolver ();
		
		app.mostrarMaximos ();
		
	}
	
	public void cargarDatos ()
	{
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
		
	}
	
	public boolean existeEntregable (Entregable e)
	{
		boolean existe = false;
		String titulo="";
		
		if (e instanceof Serie s) //pattern matching
			titulo = s.getTitulo();
		else if (e instanceof VideoJuego v)
			titulo = v.getTitulo();
		
		if (buscarPorTituloBueno(titulo) != null)
			existe = true;
		
		return existe;
	}
	
	public void entregar ()
	{
		
		String titulo;
		Entregable e;
		do
		{
			
			titulo = Teclado.leerString("\nTitulo a entregar");
			e = buscarPorTituloBueno (titulo);
			if (e!= null)
			{
				e.entregar();
				Pantalla.escribirString("\nEntregado un " + e.getClass().getSimpleName() );
			}
			else
				Pantalla.escribirString("\nNo existe " + titulo);
		}while (Teclado.leerString("\nSeguir? (s/n)").equals("s"));
	}
	
	public Entregable buscarPorTitulo (String titulo)
	{
		// No funciona
		Entregable e = null;
		int lugar;
		lugar = entregables.indexOf (new Serie (titulo,""));
		if (lugar >= 0)
			e = entregables.get(lugar);
		
		return e;
	}
	
	public Entregable buscarPorTituloBueno (String titulo)
	{
		Predicate<Entregable> estaTitulo;
		Entregable e;
		e = null;
		ArrayList<Entregable> copia = new ArrayList<>();
		
		copia.addAll(entregables);
		estaTitulo = new TieneTitulo (titulo);
	
		copia.removeIf(estaTitulo.negate());
		
		if (!copia.isEmpty())
			e = copia.get(0);
		
		return e;
	}
	
		
	public void contar ()
	{
		int cuantos = 0;
		/*
		for (Entregable e: entregables)
		{
			if (e.isEntregado())
				cuantos++;
		}
		
		
		Pantalla.escribirString("\n\nHay entregados " + cuantos + " productos");
		Pantalla.escribirString("\nListado de productos");
		for (Entregable e : entregables)
			Pantalla.escribirString("\n"+ e);
		*/
		Predicate<Entregable> estaEntregado = new EstaEntregado();
		List<Entregable> copia = new ArrayList<>();		
		copia.addAll(entregables);
		copia.removeIf(estaEntregado.negate());
		cuantos = copia.size();
		Pantalla.escribirString("\nEntregados" + cuantos);
	}
	
	public void devolver ()
	{
		/*
		for (Entregable e: entregables)
			if (e.isEntregado())
				e.devolver();
		*/
		Predicate<Entregable> estaEntregado = new EstaEntregado();
		List<Entregable> copia = new ArrayList<>();		
		copia.addAll(entregables);
		copia.removeIf(estaEntregado.negate());//filtro
		copia.forEach(new Devolvedor()); // acciÃ³n
		
		Pantalla.escribirString("\n\nSe han devuelto todos los no entregados");
	}
	
	public void mostrarMaximos ()
	{
		List<Entregable> series, videojuegos;
		Predicate <Entregable> esSerie, esVideoJuego;
		Serie serie;
		VideoJuego videojuego;
		
		// Copiar entregables en series
		series = new ArrayList<> ();
		series.addAll(entregables);
		
		// Copiar entregables en videojuegos
		videojuegos = new ArrayList<>();
		videojuegos.addAll(entregables);
		
		// Filtro de series
		esSerie = new EsSerie ();
		
		// Filtro de Videojuegos
		esVideoJuego = new EsVideoJuego ();
		
		
		series.removeIf(esVideoJuego); // borrar todos los videojuegos
		videojuegos.removeIf(esSerie); // borrar todas las series
		
		serie = (Serie) Collections.max(series,new ComparadorPorTemporadas());
		videojuego = (VideoJuego) Collections.max(videojuegos,new ComparadorHoras());
		
	
		Pantalla.escribirString("\nLa serie con mas temporadas es " + serie);
		Pantalla.escribirString("\nEl videojuego con mas horas es " + videojuego);
	}
	

}
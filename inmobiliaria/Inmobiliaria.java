package inmobiliaria;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Vivienda> viviendas;
	private ArrayList<Visita> visitas;
	private ArrayList<Cliente> clientes;
	
	private String nombre;
	
	public Inmobiliaria ()
	{
		nombre ="";
		viviendas = new ArrayList<>();
		visitas=new ArrayList<Visita>();
		clientes=new ArrayList<Cliente>();
	}

	public Inmobiliaria (String nombre)
	{
		this.nombre = nombre;
		viviendas = new ArrayList<>();
	}
	
	public Inmobiliaria (Inmobiliaria original)
	{
		this.nombre = original.nombre;
		
		viviendas = new ArrayList<>();
		
		for (Vivienda v: original.viviendas)
			viviendas.add(v);
		/*
		for (int i = 0; i < original.viviendas.size(); i++)
		{
			Vivienda v = original.viviendas.get(i);
			viviendas.add(v);
		}*/
		//original.viviendas.forEach(v -> viviendas.add(v));
	}
	
	public Vivienda getVivienda (int cual)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;
		
		return viviendas.get(cual);
	}
	
	public int getNViviendas ()
	{
		return viviendas.size();
	}
	
	public void setVivivenda (int cual, Vivienda v)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;
		
		if (!viviendas.contains(v))
			viviendas.set(cual, v);
	}

	public Vivienda getVivienda (Direccion direccion)
	{
		Vivienda v = null;
		int cual;
		
		cual = viviendas.indexOf(new ViviendaLibre(direccion));
		
		if (cual >= 0)
			v = viviendas.get(cual);
			
		return v;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean insertarVivienda (Vivienda v)
	{
		boolean exito = false;
		
		if (!viviendas.contains(v))
		{
			viviendas.add(v);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean eliminarVivienda (Direccion direccion)
	{
		boolean exito = false;
		Vivienda v = getVivienda (direccion);
		
		if (v != null)
		{
			viviendas.remove(v);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public String toString() {
		return "Inmobiliaria [viviendas=" + viviendas + ", nombre=" + nombre + "]";
	}
	
}
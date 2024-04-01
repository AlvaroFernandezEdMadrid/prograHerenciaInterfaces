package instituto;

import java.util.ArrayList;
import java.util.Objects;

import daw.com.Teclado;

public class Persona {
	private String nombre;
	private String nif;
	private int anio;
	private String poblacion;
	private Direccion direccion;
	private Buzon buzon;
	private ArrayList<Telefono> agenda;
	
	public Persona(String nombre, String nif, int anio, String poblacion, Direccion direccion, Buzon buzon,
			ArrayList<Telefono> agenda) {
		this.nombre = nombre;
		this.nif = nif;
		setAnio(anio);
		this.poblacion = poblacion;
		setDireccion(direccion);
		setBuzon(buzon);
		setAgenda(agenda);
	}
	
	
	public Persona(String nif) {
		this("",nif,0,"",new Direccion(), new Buzon(), new ArrayList<Telefono>());
	}

	public Persona() {
		this("");
	}
	
	public Persona(Persona og) {
		this.nombre=og.nombre;
		this.nif=og.nif;
		this.anio=og.anio;
		this.poblacion=og.poblacion;
		this.direccion=og.direccion;
		this.buzon=og.buzon;
		this.agenda=og.agenda;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		if (anio<0) {
			anio=0;
		}
		this.anio = anio;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public Direccion getDireccion() {
		return new Direccion(direccion);	//Composicion
	}
	
	public void setDireccion(Direccion direccion) {	
		this.direccion = new Direccion(direccion);	//Copia dura
	}
	
	public Buzon getBuzon() {
		return new Buzon(buzon);	//Composicion
	}
	
	public void setBuzon(Buzon buzon) {
		this.buzon = new Buzon(buzon);	//Copia dura
	}
	
	public ArrayList<Telefono> getAgenda() {
		ArrayList<Telefono> copia;
		
		copia=new ArrayList<Telefono>();	//Copia dura
		
		for (int i = 0; i < agenda.size(); i++) {
			copia.add(agenda.get(i));
		}
		
		return copia;
	}
	
	public void setAgenda(ArrayList<Telefono> agenda) {
		if (agenda!=null) {
			for (int i = 0; i < agenda.size(); i++) {
				this.agenda.add(agenda.get(i));
			}
		}else {
			this.agenda=new ArrayList<Telefono>();
		}
		
	}


	@Override
	public String toString() {
		return "\nNombre=" + nombre +
				"\nNIF=" + nif +
				"\nAnio=" + anio +
				"\nPoblacion=" + poblacion+
				"\nDireccion=" + direccion +
				"\nBuzon=" + buzon +
				"\nAgenda=" + agenda;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Persona other = (Persona) obj;
		return Objects.equals(nif, other.nif);
	}
	
	public void leerClave() {
		setNif(Teclado.leerString("\nNIF: "));
	}
	
	public void leerOtrosDatos() {
		setNombre(Teclado.leerString());
		setAnio(Teclado.leerInt());
		setPoblacion(Teclado.leerString());
		setDireccion(leerDireccion());
		setBuzon(leerBuzon());
		setAgenda(leerAgenda());
	}


	public Direccion leerDireccion() {
		Direccion dir;
		
		dir=new Direccion();
		
		dir.leerDatos();
		
		return dir;
	}


	public Buzon leerBuzon() {
		Buzon bu;
		boolean seguir=true;
		String s="s";
		
		bu=new Buzon();
		
		do {
			bu.addMensaje();
			s=Teclado.leerString("\nSigo S/N?");
			if (s.equalsIgnoreCase("n")) {
				seguir=false;
			}
		} while (seguir);
		
		return bu;
	}


	public ArrayList<Telefono> leerAgenda() {
		Telefono tel;
		ArrayList<Telefono> age;
		boolean seguir=true;
		String s="s";
		
		age=new ArrayList<Telefono>();
		
		do {
			tel=new Telefono();
			tel.leerDatos();
			
			if (!age.contains(tel)) {
				age.add(tel);
			}
			
			s=Teclado.leerString("\nSigo S/N?");
			if (s.equalsIgnoreCase("n")) {
				seguir=false;
			}
		} while (seguir);
		
		
		return age;
	}
	
}

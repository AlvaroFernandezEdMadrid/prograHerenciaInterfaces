package instituto;

import java.util.ArrayList;

public class Buzon {
	private ArrayList<Mensaje> mensajes;
	
	public Buzon(ArrayList<Mensaje> mensajes) {
		setMensajes(mensajes);
	}

	public Buzon() {
		mensajes=new ArrayList<Mensaje>();
	}
	
	public Buzon(Buzon og) {
		this.mensajes=og.mensajes;
	}

	public ArrayList<Mensaje> getMensajes() {
		ArrayList<Mensaje> copia;
		
		copia=new ArrayList<Mensaje>(); //Composicion
		
		for (int i = 0; i < mensajes.size(); i++) {
			copia.add(new Mensaje(mensajes.get(i)));
		}
		
		return copia;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		
		if (mensajes!=null) {
			for (int i = 0; i < mensajes.size(); i++) {
				this.mensajes.add(new Mensaje(mensajes.get(i))); //Copia dura
			}
		}else {
			this.mensajes=new ArrayList<Mensaje>();
		}
		
		this.mensajes = mensajes;
	}
	
	public boolean addMensaje() {
		Mensaje mensaje;
		boolean exito=false;
		
		mensaje=new Mensaje();
		
		mensaje.leerDatos();
		
		if (!mensajes.contains(mensaje)) {
			mensajes.add(mensaje);
			exito=true;
		}	
		
		return exito;
	}
	
	public boolean removeMensaje(int cual) {
		boolean exito=false;
		
		if (mensajes!=null) {
			if (mensajes.remove(cual)!= null) {
				mensajes.remove(cual);
				exito=true;
			}
		}
		
		return exito;
	}
	
	
	
}

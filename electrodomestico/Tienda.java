package electrodomestico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Cliente> clientes;
	private ArrayList<Electrodomestico> electrodomesticos;
	
	public Tienda() {
		this.clientes=new ArrayList<Cliente>();
		this.electrodomesticos=new ArrayList<Electrodomestico>();
	}
	
	public ArrayList<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}
	
	public Electrodomestico getElectrodomestico(String id) {
		Electrodomestico elec=null;
		
		for (int i = 0; i < electrodomesticos.size()&&elec==null; i++) {
			if(electrodomesticos.get(i).getId().equals(id));
			elec=electrodomesticos.get(i);
		}
				
		return elec;
	}
	
	public Cliente getCliente(String cif) {
		Cliente cl=null;
		
		for (int i = 0; i < clientes.size()&&cl==null; i++) {
			if (clientes.get(i).getCif().equals(cif)) {
				cl=clientes.get(i);
			}
		}
		
		return cl;
	}
	
	public boolean insertarCliente() {
		Cliente c;
		boolean exito=false;
		
		c=new Cliente();
		
		do {
			c.leerClave();
			exito=true;
		} while (clientes.contains(c));
		
		c.leerOtrosDatos();
		
		clientes.add(c);
		
		return exito;
	}
	
	public boolean insertarElectrodomestico() {
		Electrodomestico e=null;
		
		boolean exito=false;
		
		
		
		return exito;
	}
	
	
}

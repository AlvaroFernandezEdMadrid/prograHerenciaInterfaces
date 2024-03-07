package inmobiliaria;

import java.time.LocalDate;

import daw.com.Teclado;

public class Visita {
	private LocalDate fecha;
	private String impresion;
	private Vivienda vivienda;
	private Cliente cliente;
	
	public Visita(LocalDate fecha, String impresion, Vivienda vivienda, Cliente cliente) {
		
		setFecha (fecha);
		this.impresion = impresion;
		this.vivienda = vivienda;
		this.cliente = cliente;
	}

	public Visita ()
	{
		this (LocalDate.now(), "", null, null);
	}
	
	public Visita (Vivienda vivienda, Cliente cliente)
	{
		this (LocalDate.now(),"", vivienda, cliente);
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		if (fecha.isAfter(LocalDate.now()))
			fecha = LocalDate.now();
		this.fecha = fecha;
	}

	public String getImpresion() {
		return impresion;
	}

	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void leerDatos ()
	{
		fecha = LocalDate.parse(Teclado.leerString("\naaaa-mm-dd"));

		impresion = Teclado.leerString("\nimpresiÃ³n cliente ");
	}

	@Override
	public String toString() {
		return "Visita [fecha=" + fecha + ", hora=" + impresion + 
				", vivienda=" + vivienda.getDireccion()
				+ ", cliente=" + cliente.getDni() + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vivienda == null) {
			if (other.vivienda != null)
				return false;
		} else if (!vivienda.equals(other.vivienda))
			return false;
		return true;
	}




}
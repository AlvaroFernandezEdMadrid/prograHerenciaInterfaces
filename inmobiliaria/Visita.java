package inmobiliaria;

import java.time.LocalDate;
import java.util.Objects;

public class Visita {
	private LocalDate fechaVisita;
	private Vivienda vivienda;
	private String impresion;
	private Cliente cliente;
	
	public Visita(LocalDate fechaVisita, Vivienda vivienda, String impresion, Cliente cliente) {
		setFechaVisita(fechaVisita);
		this.vivienda = vivienda;
		this.impresion = impresion;
		this.cliente = cliente;
	}
	
	public Visita() {
		this(LocalDate.now(),new ViviendaLibre(),"",new Cliente());
	}

	public LocalDate getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(LocalDate fechaVisita) {
		if (fechaVisita.isAfter(LocalDate.now())) {
			fechaVisita=LocalDate.now();
		}
		this.fechaVisita = fechaVisita;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public String getImpresion() {
		return impresion;
	}

	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;*/
		Visita other = (Visita) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaVisita, other.fechaVisita)
				&& Objects.equals(impresion, other.impresion) && Objects.equals(vivienda, other.vivienda);
	}
	
	
}

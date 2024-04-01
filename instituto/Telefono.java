package instituto;

import java.util.Objects;

import daw.com.Teclado;

public class Telefono {
	private String tipo;
	private String numero;
	
	
	public Telefono(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Telefono() {
		this("","");
	}
	
	public Telefono(Telefono og) {
		this.tipo=og.tipo;
		this.numero=og.numero;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Telefono "
				+ "\nTipo=" + tipo +
				"\nNumero=" + numero + "]";
	}
	
	public void leerDatos() {
		setTipo(Teclado.leerString("\nTipo: "));
		setNumero(Teclado.leerString("\nNumero: "));
	}
	
	
}

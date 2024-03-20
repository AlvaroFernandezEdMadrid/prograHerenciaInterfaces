package electrodomestico;

import java.util.Objects;

import daw.com.Teclado;

public class Cliente {
	
	private String cif;
	private String nombre;
	private String telefono;
	private float saldo;
	
	public Cliente(String cif, String nombre, String telefono, float saldo) {
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		setSaldo(saldo);
	}
	
	public Cliente(String cif) {
		this.cif = cif;
	}

	public Cliente() {
		this("");
	}
	
	public Cliente(Cliente og) {
		this.cif=og.cif;
		this.nombre=og.nombre;
		this.telefono=og.telefono;
		this.saldo=og.saldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		if (saldo<0) {
			saldo=0;
		}
		this.saldo = saldo;
	}
	
	public void setCif(String cif) {
		this.cif=cif;
	}
	
	public String getCif() {
		return cif;
	}
	
	@Override
	public String toString() {
		return "Cliente " +
				"\nCIF=" + cif + 
				"\nNombre=" + nombre + 
				"\nTelefono=" + telefono + 
				"\nSaldo=" + saldo;
	}
	
	public void mostrarDatos() {
		System.out.println(this);
	}

	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		setCif(Teclado.leerString("\nCIF: "));
	}

	public void leerOtrosDatos() {
		setNombre(Teclado.leerString("\nNombre: "));
		setTelefono(Teclado.leerString("\nTelefono: "));
		setSaldo(Teclado.leerFloat("\nSaldo: "));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}
	
}

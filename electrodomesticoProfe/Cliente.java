package electrodomesticoProfe;

import daw.com.Teclado;

public class Cliente {
	private String cif; 
	private String nombre;
	private String telefono;
	private float saldo;
	
	public Cliente ()
	{
		this ("");
	}
	
	public Cliente (String cif)
	{
		this (cif, "", "", 0f);
	}
	
	public Cliente(String cif, String nombre, String telefono, float saldo) {
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		setSaldo (saldo);
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String gettelefono() {
		return telefono;
	}

	public void settelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if (saldo < 0)
			saldo = 0;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", telefono=" + telefono + ", saldo=" + saldo + "]";
	}
	
	public void leerCif ()
	{
		cif = Teclado.leerString("\nCIF");
	}
	
	public void leerRestoDatos ()
	{
		nombre = Teclado.leerString("nombre ");
		telefono = Teclado.leerString ("telefono");
		setSaldo (Teclado.leerFloat("saldo"));
		
	}
	
	public void leerDatos ()
	{
		leerCif ();
		leerRestoDatos();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (cif == null) {
			if (other.cif != null) {
				return false;
			}
		} else if (!cif.equals(other.cif)) {
			return false;
		}
		return true;
	}
	
	
	

}

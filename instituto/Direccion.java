package instituto;

import java.util.Objects;

import daw.com.Teclado;

public class Direccion {
	private String calle;
	private String ciudad;
	private String cp;
	private String pais;
	
	public Direccion(String calle, String ciudad, String cp, String pais) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
	}
	
	public Direccion() {
		this("","","","");
	}
	
	public Direccion(Direccion og) {
		this.calle=og.calle;
		this.ciudad=og.ciudad;
		this.cp=og.ciudad;
		this.pais=og.pais;
	}

	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCp() {
		return cp;
	}
	
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(cp, other.cp) && Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Direccion "
				+ "\nCalle=" + calle +
				"\nCiudad=" + ciudad +
				"\nCP=" + cp +
				"\nPais=" + pais;
	}
	
	public void leerDatos() {
		setCalle(Teclado.leerString("\nCalle: "));
		setCiudad(Teclado.leerString("\nCiudad: "));
		setCp(Teclado.leerString("\nCodigo Postal: "));
		setPais(Teclado.leerString("\nPais: "));
	}
	
	
	
}

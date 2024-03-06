package inmobiliaria;

import java.util.Objects;

import Libreria.Libreria;
import daw.com.Teclado;

public class Direccion {
	private String calle;
	private int numero;
	private int piso;
	private String letra;
	private String poblacion;
	private String codigoPostal;
	
	public Direccion(String calle, int numero, int piso, String letra, String poblacion, String codigoPostal) {
		setCalle(calle);
		setNumero(numero);
		setPiso(piso);
		setLetra(letra);
		setPoblacion(poblacion);
		setCodigoPostal(codigoPostal);
	}
	
	public Direccion() {
		this("",0,0,"","","");
	}
	
	public Direccion(Direccion og) {
		this(og.calle,og.numero,og.piso,og.letra,og.poblacion,og.codigoPostal);
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if (numero<0) {
			numero=0;
		}
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		if (piso<0) {
			piso=0;
		}
		this.piso = piso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", letra=" + letra + ", poblacion="
				+ poblacion + ", codigoPostal=" + codigoPostal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle);
	}
	
	public void leerDatos() {
		setCalle(Teclado.leerString("\nCalle: "));
		setNumero(Libreria.leerEnteroPositivo("\nNumero: "));
		setPiso(Libreria.leerEnteroPositivo("\nPiso: "));
		setLetra(Teclado.leerString("\nLetra: "));
		setPoblacion(Teclado.leerString("\nPoblacion: "));
		do {
			setCodigoPostal(Teclado.leerString("\nCodigo Postal: "));
		} while (this.codigoPostal.length()>5);
	}
	
	public void mostrarDatos() {
		System.out.println("\nCalle: "+calle);
		System.out.println("\nNumero: "+numero);
		System.out.println("\nPiso: "+piso);
		System.out.println("\nLetra: "+letra);
		System.out.println("\nPoblacion: "+poblacion);
		System.out.println("\nCodigo Postal: "+codigoPostal);
	}
}

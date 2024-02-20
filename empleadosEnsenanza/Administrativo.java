package empleadosEnsenanza;

import java.time.LocalDate;

import daw.com.Teclado;

public class Administrativo extends Empleado {
	
	private String categoria;
	private String destinoActual;

	public Administrativo(String nombre, LocalDate fNac, String dni, float sueldoBase, String categoria,
			String destinoActual) {
		super(nombre, fNac, dni, sueldoBase);
		this.categoria = categoria;
		this.destinoActual = destinoActual;
	}
	
	public Administrativo(String dni) {
		super(dni);
		categoria="";
		destinoActual="";
	}

	public Administrativo() {
		this("");
	}
	
	public Administrativo(Administrativo og) {
		super(og);
		this.categoria=og.categoria;
		this.destinoActual=og.destinoActual;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDestinoActual() {
		return destinoActual;
	}

	public void setDestinoActual(String destinoActual) {
		this.destinoActual = destinoActual;
	}
	
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setCategoria(Teclado.leerString("Categoria: "));
		setDestinoActual(Teclado.leerString("Destino actual: "));
	}
	
	@Override
	public String toString() {
		return "Administrativo [categoria=" + categoria + ", destinoActual=" + destinoActual + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public float getSueldoNeto() {
		float sueldoNeto=this.getSueldoBase();
		if (categoria.equalsIgnoreCase("oficial")) {
			sueldoNeto+=200;
		}
		return sueldoNeto;
	}

}

package javapowersolutions;

public class Formacion extends Producto {
	private int horas;
	private int profesores;
	private String titulacion;

	
	
	@Override
	public float getPrecioFinal() {
		return horas*profesores*300;
	}

}

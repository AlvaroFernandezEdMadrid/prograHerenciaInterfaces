package inmobiliaria;

public abstract class Vivienda {
	private Direccion direccion;
	private int metrosCua;
	private String descripcion;
	private float precio;
	
	public Vivienda(Direccion direccion, int metrosCua, String descripcion, float precio) {
		setDireccion(direccion);
		setMetrosCua(metrosCua);
		this.descripcion = descripcion;
		setPrecio(precio);
	}

	public Vivienda(Direccion direccion) {
		this(direccion,0,"",0);
	}

	public Vivienda() {
		this(null);
	}

	public Direccion getDireccion() {
		Direccion copia;
		
		copia=new Direccion(direccion);
		
		return copia;
	}

	public void setDireccion(Direccion direccion) {
		// copia dura
		this.direccion = direccion != null? 
					new Direccion (direccion):
					new Direccion();
	}

	public int getMetrosCua() {
		return metrosCua;
	}

	public void setMetrosCua(int metrosCua) {
		if (metrosCua<0) {
			metrosCua=0;
		}
		this.metrosCua = metrosCua;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if (precio<0) {
			precio=0;
		}
		this.precio = precio;
	}
	
	public abstract float getComision();
	
}

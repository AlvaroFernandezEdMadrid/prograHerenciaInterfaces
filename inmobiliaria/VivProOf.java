package inmobiliaria;

public class VivProOf extends Vivienda{
	private int aniosPO;
	
	public VivProOf(Direccion direccion, int metrosCua, String descripcion, float precio, int aniosPO) {
		super(direccion, metrosCua, descripcion, precio);
		setAniosPO(aniosPO);
	}


	public VivProOf(Direccion direccion) {
		super(direccion);
		setAniosPO(aniosPO);
	}

	public VivProOf() {
		this(null);
	}
	
	public int getAniosPO() {
		return aniosPO;
	}


	public void setAniosPO(int aniosPO) {
		if (aniosPO<0) {
			aniosPO=0;
		}
		this.aniosPO = aniosPO;
	}


	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		float comision;
		float prc=(float) (0.1*aniosPO);
	
		comision=this.getPrecio()*prc;
		
		return comision;
	}

}

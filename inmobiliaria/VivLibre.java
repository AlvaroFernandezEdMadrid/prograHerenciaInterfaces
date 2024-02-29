package inmobiliaria;

public class VivLibre extends Vivienda{
	private int beneficio;
	
	public VivLibre(Direccion direccion, int metrosCua, String descripcion, float precio, int beneficio) {
		super(direccion, metrosCua, descripcion, precio);
		setBeneficio(beneficio);
	}

	public VivLibre(Direccion direccion) {
		super(direccion);
		setBeneficio(beneficio);
	}

	public VivLibre() {
		this(null);
	}
	

	public int getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(int beneficio) {
		if (beneficio<0) {
			beneficio=0;
		}
		this.beneficio = beneficio;
	}


	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		return 0;
	}

}

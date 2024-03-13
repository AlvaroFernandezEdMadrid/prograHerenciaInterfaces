package habladores;

public class Loro extends Ave {
	private String region, color;

	public Loro(String sexo, int edad, String region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}

	public Loro(String sexo, int edad) {
		this(sexo, edad, "","");
	}
	
	public Loro() {
		this("",0);
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
